package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class h0 implements Parcelable.Creator<e0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e0 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                j = com.google.android.gms.common.internal.w.b.n(parcel, k);
            } else if (h != 2) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                j2 = com.google.android.gms.common.internal.w.b.n(parcel, k);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new e0(j, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e0[] newArray(int i) {
        return new e0[i];
    }
}
