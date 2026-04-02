package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class c0 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<c0> CREATOR = new d0();
    Bundle f;
    b.c.a.a.b.c[] g;

    public c0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(Bundle bundle, b.c.a.a.b.c[] cVarArr) {
        this.f = bundle;
        this.g = cVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.e(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.m(parcel, 2, this.g, i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
