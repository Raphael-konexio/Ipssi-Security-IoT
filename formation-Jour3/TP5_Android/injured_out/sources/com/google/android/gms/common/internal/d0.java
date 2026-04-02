package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class d0 implements Parcelable.Creator<c0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c0 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        Bundle bundle = null;
        b.c.a.a.b.c[] cVarArr = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                bundle = com.google.android.gms.common.internal.w.b.a(parcel, k);
            } else if (h != 2) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                cVarArr = (b.c.a.a.b.c[]) com.google.android.gms.common.internal.w.b.e(parcel, k, b.c.a.a.b.c.CREATOR);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new c0(bundle, cVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c0[] newArray(int i) {
        return new c0[i];
    }
}
