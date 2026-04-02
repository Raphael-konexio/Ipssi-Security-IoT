package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class s0 implements Parcelable.Creator<q> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            if (com.google.android.gms.common.internal.w.b.h(k) != 1) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new q(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q[] newArray(int i) {
        return new q[i];
    }
}
