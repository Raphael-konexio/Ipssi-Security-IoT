package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class BinaryKeysetWriter implements KeysetWriter {
    private final OutputStream outputStream;

    private BinaryKeysetWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public static KeysetWriter withFile(File file) {
        return new BinaryKeysetWriter(new FileOutputStream(file));
    }

    public static KeysetWriter withOutputStream(OutputStream outputStream) {
        return new BinaryKeysetWriter(outputStream);
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(EncryptedKeyset encryptedKeyset) {
        this.outputStream.write(encryptedKeyset.toByteArray());
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(Keyset keyset) {
        this.outputStream.write(keyset.toByteArray());
    }
}
