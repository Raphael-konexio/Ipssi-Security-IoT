package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class l0 implements Parcelable.Creator<c> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        boolean z = false;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h == 2) {
                str2 = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h == 3) {
                str3 = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h == 4) {
                str4 = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h != 5) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                z = com.google.android.gms.common.internal.w.b.i(parcel, k);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new c(str, str2, str3, str4, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i) {
        return new c[i];
    }
}
