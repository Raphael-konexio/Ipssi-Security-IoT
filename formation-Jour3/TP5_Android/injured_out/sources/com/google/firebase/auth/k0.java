package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a.d.c.a2;
/* loaded from: classes.dex */
public final class k0 implements Parcelable.Creator<i0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i0 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        a2 a2Var = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
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
                    str3 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 4:
                    a2Var = (a2) com.google.android.gms.common.internal.w.b.b(parcel, k, a2.CREATOR);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 6:
                    str5 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 7:
                    str6 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                default:
                    com.google.android.gms.common.internal.w.b.q(parcel, k);
                    break;
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new i0(str, str2, str3, a2Var, str4, str5, str6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i0[] newArray(int i) {
        return new i0[i];
    }
}
