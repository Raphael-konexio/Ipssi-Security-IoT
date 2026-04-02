package com.google.crypto.tink.signature;

import com.google.crypto.tink.Config;
@Deprecated
/* loaded from: classes.dex */
public final class PublicKeySignConfig {
    @Deprecated
    public static void registerStandardKeyTypes() {
        Config.register(SignatureConfig.TINK_1_0_0);
    }
}
