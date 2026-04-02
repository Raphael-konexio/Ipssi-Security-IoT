package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class f0 implements Parcelable.Creator<w> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ w createFromParcel(Parcel parcel) {
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
        return new w(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ w[] newArray(int i) {
        return new w[i];
    }
}
