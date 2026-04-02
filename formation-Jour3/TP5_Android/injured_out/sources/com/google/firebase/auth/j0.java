package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class j0 implements Parcelable.Creator<u> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            com.google.android.gms.common.internal.w.b.h(k);
            com.google.android.gms.common.internal.w.b.q(parcel, k);
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new u();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u[] newArray(int i) {
        return new u[i];
    }
}
