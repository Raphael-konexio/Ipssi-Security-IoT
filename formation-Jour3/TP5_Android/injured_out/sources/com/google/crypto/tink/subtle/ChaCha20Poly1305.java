package com.google.crypto.tink.subtle;
/* loaded from: classes.dex */
public final class ChaCha20Poly1305 extends ChaCha20Poly1305Base {
    public ChaCha20Poly1305(byte[] bArr) {
        super(bArr);
    }

    @Override // com.google.crypto.tink.subtle.ChaCha20Poly1305Base, com.google.crypto.tink.Aead
    public /* bridge */ /* synthetic */ byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return super.decrypt(bArr, bArr2);
    }

    @Override // com.google.crypto.tink.subtle.ChaCha20Poly1305Base, com.google.crypto.tink.Aead
    public /* bridge */ /* synthetic */ byte[] encrypt(byte[] bArr, byte[] bArr2) {
        return super.encrypt(bArr, bArr2);
    }

    @Override // com.google.crypto.tink.subtle.ChaCha20Poly1305Base
    ChaCha20Base newChaCha20Instance(byte[] bArr, int i) {
        return new ChaCha20(bArr, i);
    }
}
