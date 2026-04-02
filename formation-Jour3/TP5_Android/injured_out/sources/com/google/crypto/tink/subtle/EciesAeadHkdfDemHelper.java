package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
/* loaded from: classes.dex */
public interface EciesAeadHkdfDemHelper {
    Aead getAead(byte[] bArr);

    int getSymmetricKeySizeInBytes();
}
