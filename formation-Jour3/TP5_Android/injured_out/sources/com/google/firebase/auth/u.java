package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class u extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<u> CREATOR = new j0();

    public static u b() {
        return new u();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.common.internal.w.c.b(parcel, com.google.android.gms.common.internal.w.c.a(parcel));
    }
}
