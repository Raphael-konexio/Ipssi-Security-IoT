package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
/* loaded from: classes.dex */
final class InputStreamDecrypter extends InputStream {
    byte[] associatedData;
    InputStream ciphertextStream;
    PrimitiveSet<StreamingAead> primitives;
    boolean attemptedMatching = false;
    InputStream matchingStream = null;

    public InputStreamDecrypter(PrimitiveSet<StreamingAead> primitiveSet, InputStream inputStream, byte[] bArr) {
        this.primitives = primitiveSet;
        if (inputStream.markSupported()) {
            this.ciphertextStream = inputStream;
        } else {
            this.ciphertextStream = new BufferedInputStream(inputStream);
        }
        this.ciphertextStream.mark(Reader.READ_DONE);
        this.associatedData = (byte[]) bArr.clone();
    }

    private void disableRewinding() {
        this.ciphertextStream.mark(0);
    }

    private void rewind() {
        this.ciphertextStream.reset();
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        if (this.matchingStream == null) {
            return 0;
        }
        return this.matchingStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.ciphertextStream.close();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        byte[] bArr = new byte[1];
        if (read(bArr) == 1) {
            return bArr[0];
        }
        return -1;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.matchingStream != null) {
            return this.matchingStream.read(bArr, i, i2);
        } else if (this.attemptedMatching) {
            throw new IOException("No matching key found for the ciphertext in the stream.");
        } else {
            this.attemptedMatching = true;
            for (PrimitiveSet.Entry<StreamingAead> entry : this.primitives.getRawPrimitives()) {
                try {
                    InputStream newDecryptingStream = entry.getPrimitive().newDecryptingStream(this.ciphertextStream, this.associatedData);
                    int read = newDecryptingStream.read(bArr, i, i2);
                    if (read == 0) {
                        rewind();
                        this.attemptedMatching = false;
                    } else {
                        this.matchingStream = newDecryptingStream;
                        disableRewinding();
                    }
                    return read;
                } catch (IOException | GeneralSecurityException unused) {
                    rewind();
                }
            }
            throw new IOException("No matching key found for the ciphertext in the stream.");
        }
    }
}
