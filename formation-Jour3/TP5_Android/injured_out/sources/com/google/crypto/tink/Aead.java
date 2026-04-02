package com.google.crypto.tink;
/* loaded from: classes.dex */
public interface Aead {
    byte[] decrypt(byte[] bArr, byte[] bArr2);

    byte[] encrypt(byte[] bArr, byte[] bArr2);
}
