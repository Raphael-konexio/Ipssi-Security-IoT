package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class a0 implements Parcelable.Creator<x> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        d0 d0Var = null;
        w wVar = null;
        com.google.firebase.auth.i0 i0Var = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                d0Var = (d0) com.google.android.gms.common.internal.w.b.b(parcel, k, d0.CREATOR);
            } else if (h == 2) {
                wVar = (w) com.google.android.gms.common.internal.w.b.b(parcel, k, w.CREATOR);
            } else if (h != 3) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                i0Var = (com.google.firebase.auth.i0) com.google.android.gms.common.internal.w.b.b(parcel, k, com.google.firebase.auth.i0.CREATOR);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new x(d0Var, wVar, i0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x[] newArray(int i) {
        return new x[i];
    }
}
