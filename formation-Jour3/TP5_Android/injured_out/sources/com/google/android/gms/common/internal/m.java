package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public interface m extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends b.c.a.a.d.b.b implements m {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // b.c.a.a.d.b.b
        protected final boolean d(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                X(parcel.readInt(), parcel.readStrongBinder(), (Bundle) b.c.a.a.d.b.c.b(parcel, Bundle.CREATOR));
            } else if (i == 2) {
                Q(parcel.readInt(), (Bundle) b.c.a.a.d.b.c.b(parcel, Bundle.CREATOR));
            } else if (i != 3) {
                return false;
            } else {
                N(parcel.readInt(), parcel.readStrongBinder(), (c0) b.c.a.a.d.b.c.b(parcel, c0.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void N(int i, IBinder iBinder, c0 c0Var);

    void Q(int i, Bundle bundle);

    void X(int i, IBinder iBinder, Bundle bundle);
}
