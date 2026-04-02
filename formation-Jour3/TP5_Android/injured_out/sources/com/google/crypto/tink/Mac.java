package com.google.crypto.tink;
/* loaded from: classes.dex */
public interface Mac {
    byte[] computeMac(byte[] bArr);

    void verifyMac(byte[] bArr, byte[] bArr2);
}
