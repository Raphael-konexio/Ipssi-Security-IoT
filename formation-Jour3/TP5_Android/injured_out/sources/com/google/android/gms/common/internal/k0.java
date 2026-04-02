package com.google.android.gms.common.internal;

import android.os.Parcel;
/* loaded from: classes.dex */
public abstract class k0 extends b.c.a.a.d.b.b implements j0 {
    public k0() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    @Override // b.c.a.a.d.b.b
    protected final boolean d(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            b.c.a.a.c.a a2 = a();
            parcel2.writeNoException();
            b.c.a.a.d.b.c.c(parcel2, a2);
        } else if (i != 2) {
            return false;
        } else {
            int b2 = b();
            parcel2.writeNoException();
            parcel2.writeInt(b2);
        }
        return true;
    }
}
