package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class k0 implements Parcelable.Creator<l0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l0 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        String str2 = null;
        ArrayList arrayList = null;
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
                arrayList = com.google.android.gms.common.internal.w.b.f(parcel, k, com.google.firebase.auth.e0.CREATOR);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new l0(str, str2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l0[] newArray(int i) {
        return new l0[i];
    }
}
