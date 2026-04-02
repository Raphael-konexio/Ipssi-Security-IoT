package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.Registry;
@Deprecated
/* loaded from: classes.dex */
public final class AeadFactory {
    @Deprecated
    public static Aead getPrimitive(KeysetHandle keysetHandle) {
        return getPrimitive(keysetHandle, null);
    }

    @Deprecated
    public static Aead getPrimitive(KeysetHandle keysetHandle, KeyManager<Aead> keyManager) {
        Registry.registerPrimitiveWrapper(new AeadWrapper());
        return (Aead) Registry.wrap(Registry.getPrimitives(keysetHandle, keyManager, Aead.class));
    }
}
