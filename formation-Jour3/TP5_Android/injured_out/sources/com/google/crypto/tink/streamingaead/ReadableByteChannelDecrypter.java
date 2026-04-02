package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.subtle.RewindableReadableByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
final class ReadableByteChannelDecrypter implements ReadableByteChannel {
    byte[] associatedData;
    RewindableReadableByteChannel ciphertextChannel;
    PrimitiveSet<StreamingAead> primitives;
    boolean attemptedMatching = false;
    ReadableByteChannel matchingChannel = null;

    public ReadableByteChannelDecrypter(PrimitiveSet<StreamingAead> primitiveSet, ReadableByteChannel readableByteChannel, byte[] bArr) {
        this.primitives = primitiveSet;
        this.ciphertextChannel = new RewindableReadableByteChannel(readableByteChannel);
        this.associatedData = (byte[]) bArr.clone();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.ciphertextChannel.close();
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.ciphertextChannel.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        RewindableReadableByteChannel rewindableReadableByteChannel;
        if (byteBuffer.remaining() == 0) {
            return 0;
        }
        if (this.matchingChannel != null) {
            return this.matchingChannel.read(byteBuffer);
        } else if (this.attemptedMatching) {
            throw new IOException("No matching key found for the ciphertext in the stream.");
        } else {
            this.attemptedMatching = true;
            for (PrimitiveSet.Entry<StreamingAead> entry : this.primitives.getRawPrimitives()) {
                try {
                    try {
                        ReadableByteChannel newDecryptingChannel = entry.getPrimitive().newDecryptingChannel(this.ciphertextChannel, this.associatedData);
                        int read = newDecryptingChannel.read(byteBuffer);
                        if (read > 0) {
                            this.matchingChannel = newDecryptingChannel;
                            this.ciphertextChannel.disableRewinding();
                        } else if (read == 0) {
                            this.ciphertextChannel.rewind();
                            this.attemptedMatching = false;
                        }
                        return read;
                    } catch (IOException unused) {
                        rewindableReadableByteChannel = this.ciphertextChannel;
                        rewindableReadableByteChannel.rewind();
                    }
                } catch (GeneralSecurityException unused2) {
                    rewindableReadableByteChannel = this.ciphertextChannel;
                    rewindableReadableByteChannel.rewind();
                }
            }
            throw new IOException("No matching key found for the ciphertext in the stream.");
        }
    }
}
