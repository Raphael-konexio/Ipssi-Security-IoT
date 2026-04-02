package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class c0 implements Parcelable.Creator<t> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ t createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            switch (com.google.android.gms.common.internal.w.b.h(k)) {
                case 1:
                    str = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 3:
                    z = com.google.android.gms.common.internal.w.b.i(parcel, k);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 5:
                    z2 = com.google.android.gms.common.internal.w.b.i(parcel, k);
                    break;
                case 6:
                    str4 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 7:
                    str5 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                default:
                    com.google.android.gms.common.internal.w.b.q(parcel, k);
                    break;
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new t(str, str2, z, str3, z2, str4, str5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ t[] newArray(int i) {
        return new t[i];
    }
}
