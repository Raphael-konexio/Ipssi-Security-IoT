package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a.d.c.a2;
/* loaded from: classes.dex */
public class x extends b {
    public static final Parcelable.Creator<x> CREATOR = new g0();
    private String f;
    private String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(String str, String str2) {
        com.google.android.gms.common.internal.r.f(str);
        this.f = str;
        com.google.android.gms.common.internal.r.f(str2);
        this.g = str2;
    }

    public static a2 h(x xVar, String str) {
        com.google.android.gms.common.internal.r.h(xVar);
        return new a2(null, xVar.f, xVar.b(), null, xVar.g, null, str, null, null);
    }

    @Override // com.google.firebase.auth.b
    public String b() {
        return "twitter.com";
    }

    @Override // com.google.firebase.auth.b
    public final b c() {
        return new x(this.f, this.g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, this.g, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
