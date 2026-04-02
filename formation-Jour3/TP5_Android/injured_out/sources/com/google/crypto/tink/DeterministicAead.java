package com.google.crypto.tink;
/* loaded from: classes.dex */
public interface DeterministicAead {
    byte[] decryptDeterministically(byte[] bArr, byte[] bArr2);

    byte[] encryptDeterministically(byte[] bArr, byte[] bArr2);
}
