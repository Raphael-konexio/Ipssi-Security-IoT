package com.google.crypto.tink.prf;
/* loaded from: classes.dex */
public final class PrfConfig {
    public static final String PRF_TYPE_URL = new HkdfPrfKeyManager().getKeyType();

    private PrfConfig() {
    }

    public static void register() {
        HkdfPrfKeyManager.register(true);
        PrfSetWrapper.register();
    }
}
