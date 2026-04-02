package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class w implements com.google.firebase.auth.a {
    public static final Parcelable.Creator<w> CREATOR = new y();
    private final String f;
    private final String g;
    private boolean h;

    public w(String str, String str2, boolean z) {
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.f(str2);
        this.f = str;
        this.g = str2;
        j.d(str2);
        this.h = z;
    }

    public w(boolean z) {
        this.h = z;
        this.g = null;
        this.f = null;
    }

    public final String a() {
        return this.f;
    }

    public final boolean b() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, a(), false);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, this.g, false);
        com.google.android.gms.common.internal.w.c.c(parcel, 3, b());
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
