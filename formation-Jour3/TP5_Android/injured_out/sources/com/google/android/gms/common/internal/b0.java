package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class b0 implements Parcelable.Creator<t> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ t createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        IBinder iBinder = null;
        b.c.a.a.b.a aVar = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                i = com.google.android.gms.common.internal.w.b.m(parcel, k);
            } else if (h == 2) {
                iBinder = com.google.android.gms.common.internal.w.b.l(parcel, k);
            } else if (h == 3) {
                aVar = (b.c.a.a.b.a) com.google.android.gms.common.internal.w.b.b(parcel, k, b.c.a.a.b.a.CREATOR);
            } else if (h == 4) {
                z = com.google.android.gms.common.internal.w.b.i(parcel, k);
            } else if (h != 5) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                z2 = com.google.android.gms.common.internal.w.b.i(parcel, k);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new t(i, iBinder, aVar, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ t[] newArray(int i) {
        return new t[i];
    }
}
