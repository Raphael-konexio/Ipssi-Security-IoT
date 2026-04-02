package com.google.crypto.tink.prf;

import java.util.Map;
/* loaded from: classes.dex */
public abstract class PrfSet {
    public byte[] computePrimary(byte[] bArr, int i) {
        return getPrfs().get(Integer.valueOf(getPrimaryId())).compute(bArr, i);
    }

    public abstract Map<Integer, Prf> getPrfs();

    public abstract int getPrimaryId();
}
