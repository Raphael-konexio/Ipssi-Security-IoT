package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class g0 implements Parcelable.Creator<x> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h != 2) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                str2 = com.google.android.gms.common.internal.w.b.c(parcel, k);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new x(str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x[] newArray(int i) {
        return new x[i];
    }
}
