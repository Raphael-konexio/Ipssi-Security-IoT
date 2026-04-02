package com.google.crypto.tink;
@Deprecated
/* loaded from: classes.dex */
public interface Catalogue<P> {
    KeyManager<P> getKeyManager(String str, String str2, int i);

    PrimitiveWrapper<P> getPrimitiveWrapper();
}
