package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
final class SeekableByteChannelDecrypter implements SeekableByteChannel {
    byte[] associatedData;
    SeekableByteChannel ciphertextChannel;
    PrimitiveSet<StreamingAead> primitives;
    long startingPosition;
    boolean attemptedMatching = false;
    SeekableByteChannel matchingChannel = null;
    long cachedPosition = -1;

    public SeekableByteChannelDecrypter(PrimitiveSet<StreamingAead> primitiveSet, SeekableByteChannel seekableByteChannel, byte[] bArr) {
        this.primitives = primitiveSet;
        this.ciphertextChannel = seekableByteChannel;
        this.startingPosition = seekableByteChannel.position();
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

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long position() {
        if (this.matchingChannel != null) {
            return this.matchingChannel.position();
        }
        return this.cachedPosition;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized SeekableByteChannel position(long j) {
        if (this.matchingChannel != null) {
            this.matchingChannel.position(j);
        } else if (j < 0) {
            throw new IllegalArgumentException("Position must be non-negative");
        } else {
            this.cachedPosition = j;
        }
        return this;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        SeekableByteChannel seekableByteChannel;
        long j;
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
                    SeekableByteChannel newSeekableDecryptingChannel = entry.getPrimitive().newSeekableDecryptingChannel(this.ciphertextChannel, this.associatedData);
                    if (this.cachedPosition >= 0) {
                        newSeekableDecryptingChannel.position(this.cachedPosition);
                    }
                    int read = newSeekableDecryptingChannel.read(byteBuffer);
                    if (read > 0) {
                        this.matchingChannel = newSeekableDecryptingChannel;
                    } else if (read == 0) {
                        this.ciphertextChannel.position(this.startingPosition);
                        this.attemptedMatching = false;
                    }
                    this.matchingChannel = newSeekableDecryptingChannel;
                    return read;
                } catch (IOException unused) {
                    seekableByteChannel = this.ciphertextChannel;
                    j = this.startingPosition;
                    seekableByteChannel.position(j);
                } catch (GeneralSecurityException unused2) {
                    seekableByteChannel = this.ciphertextChannel;
                    j = this.startingPosition;
                    seekableByteChannel.position(j);
                }
            }
            throw new IOException("No matching key found for the ciphertext in the stream.");
        }
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long size() {
        if (this.matchingChannel == null) {
            throw new IOException("Cannot determine size before first read()-call.");
        }
        return this.matchingChannel.size();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long j) {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        throw new NonWritableChannelException();
    }
}
