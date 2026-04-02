package com.google.crypto.tink;
/* loaded from: classes.dex */
public interface PrimitiveWrapper<P> {
    Class<P> getPrimitiveClass();

    P wrap(PrimitiveSet<P> primitiveSet);
}
