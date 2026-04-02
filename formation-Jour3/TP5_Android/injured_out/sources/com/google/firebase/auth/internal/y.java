package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class y implements Parcelable.Creator<w> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ w createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h == 2) {
                str2 = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h != 3) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                z = com.google.android.gms.common.internal.w.b.i(parcel, k);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new w(str, str2, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ w[] newArray(int i) {
        return new w[i];
    }
}
