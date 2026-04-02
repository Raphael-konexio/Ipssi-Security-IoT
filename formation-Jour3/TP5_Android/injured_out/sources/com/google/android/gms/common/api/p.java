package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class p implements Parcelable.Creator<Status> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                i2 = com.google.android.gms.common.internal.w.b.m(parcel, k);
            } else if (h == 2) {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h == 3) {
                pendingIntent = (PendingIntent) com.google.android.gms.common.internal.w.b.b(parcel, k, PendingIntent.CREATOR);
            } else if (h != 1000) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                i = com.google.android.gms.common.internal.w.b.m(parcel, k);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new Status(i, i2, str, pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i) {
        return new Status[i];
    }
}
