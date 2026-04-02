package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Mac;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public final class MacJce implements Mac {
    static final int MIN_KEY_SIZE_IN_BYTES = 16;
    static final int MIN_TAG_SIZE_IN_BYTES = 10;
    private final String algorithm;
    private final int digestSize;
    private final Key key;
    private final javax.crypto.Mac mac;

    public MacJce(String str, Key key, int i) {
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1823053428) {
            if (hashCode != 392315118) {
                if (hashCode == 392317873 && str.equals("HMACSHA512")) {
                    c2 = 2;
                }
            } else if (str.equals("HMACSHA256")) {
                c2 = 1;
            }
        } else if (str.equals("HMACSHA1")) {
            c2 = 0;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + str);
                } else if (i > 64) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
            } else if (i > 32) {
                throw new InvalidAlgorithmParameterException("tag size too big");
            }
        } else if (i > 20) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        this.algorithm = str;
        this.digestSize = i;
        this.key = key;
        javax.crypto.Mac engineFactory = EngineFactory.MAC.getInstance(str);
        this.mac = engineFactory;
        engineFactory.init(key);
    }

    @Override // com.google.crypto.tink.Mac
    public byte[] computeMac(byte[] bArr) {
        javax.crypto.Mac engineFactory;
        try {
            engineFactory = (javax.crypto.Mac) this.mac.clone();
        } catch (CloneNotSupportedException unused) {
            engineFactory = EngineFactory.MAC.getInstance(this.algorithm);
            engineFactory.init(this.key);
        }
        engineFactory.update(bArr);
        byte[] bArr2 = new byte[this.digestSize];
        System.arraycopy(engineFactory.doFinal(), 0, bArr2, 0, this.digestSize);
        return bArr2;
    }

    @Override // com.google.crypto.tink.Mac
    public void verifyMac(byte[] bArr, byte[] bArr2) {
        if (!Bytes.equal(computeMac(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
