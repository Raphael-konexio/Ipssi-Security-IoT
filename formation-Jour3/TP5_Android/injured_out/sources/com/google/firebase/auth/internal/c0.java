package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class c0 implements Parcelable.Creator<z> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        boolean z = false;
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
                    str5 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 4:
                    str4 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 5:
                    str3 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 6:
                    str6 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.w.b.i(parcel, k);
                    break;
                case 8:
                    str7 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                default:
                    com.google.android.gms.common.internal.w.b.q(parcel, k);
                    break;
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new z(str, str2, str3, str4, str5, str6, z, str7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z[] newArray(int i) {
        return new z[i];
    }
}
