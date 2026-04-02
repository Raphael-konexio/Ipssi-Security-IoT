package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class i0 implements Parcelable.Creator<j0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ j0 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        ArrayList arrayList = null;
        l0 l0Var = null;
        String str = null;
        com.google.firebase.auth.i0 i0Var = null;
        d0 d0Var = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                arrayList = com.google.android.gms.common.internal.w.b.f(parcel, k, com.google.firebase.auth.e0.CREATOR);
            } else if (h == 2) {
                l0Var = (l0) com.google.android.gms.common.internal.w.b.b(parcel, k, l0.CREATOR);
            } else if (h == 3) {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h == 4) {
                i0Var = (com.google.firebase.auth.i0) com.google.android.gms.common.internal.w.b.b(parcel, k, com.google.firebase.auth.i0.CREATOR);
            } else if (h != 5) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                d0Var = (d0) com.google.android.gms.common.internal.w.b.b(parcel, k, d0.CREATOR);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new j0(arrayList, l0Var, str, i0Var, d0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ j0[] newArray(int i) {
        return new j0[i];
    }
}
