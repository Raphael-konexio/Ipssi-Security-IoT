package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a.d.c.q1;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class f0 implements Parcelable.Creator<d0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d0 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        q1 q1Var = null;
        z zVar = null;
        String str = null;
        String str2 = null;
        ArrayList arrayList = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        Boolean bool = null;
        e0 e0Var = null;
        com.google.firebase.auth.i0 i0Var = null;
        l lVar = null;
        boolean z = false;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            switch (com.google.android.gms.common.internal.w.b.h(k)) {
                case 1:
                    q1Var = (q1) com.google.android.gms.common.internal.w.b.b(parcel, k, q1.CREATOR);
                    break;
                case 2:
                    zVar = (z) com.google.android.gms.common.internal.w.b.b(parcel, k, z.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 5:
                    arrayList = com.google.android.gms.common.internal.w.b.f(parcel, k, z.CREATOR);
                    break;
                case 6:
                    arrayList2 = com.google.android.gms.common.internal.w.b.d(parcel, k);
                    break;
                case 7:
                    str3 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 8:
                    bool = com.google.android.gms.common.internal.w.b.j(parcel, k);
                    break;
                case 9:
                    e0Var = (e0) com.google.android.gms.common.internal.w.b.b(parcel, k, e0.CREATOR);
                    break;
                case 10:
                    z = com.google.android.gms.common.internal.w.b.i(parcel, k);
                    break;
                case 11:
                    i0Var = (com.google.firebase.auth.i0) com.google.android.gms.common.internal.w.b.b(parcel, k, com.google.firebase.auth.i0.CREATOR);
                    break;
                case 12:
                    lVar = (l) com.google.android.gms.common.internal.w.b.b(parcel, k, l.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.w.b.q(parcel, k);
                    break;
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new d0(q1Var, zVar, str, str2, arrayList, arrayList2, str3, bool, e0Var, z, i0Var, lVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d0[] newArray(int i) {
        return new d0[i];
    }
}
