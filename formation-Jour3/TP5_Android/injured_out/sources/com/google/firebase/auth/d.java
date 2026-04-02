package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a.d.c.a2;
/* loaded from: classes.dex */
public class d extends b {
    public static final Parcelable.Creator<d> CREATOR = new m0();
    private final String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        com.google.android.gms.common.internal.r.f(str);
        this.f = str;
    }

    public static a2 h(d dVar, String str) {
        com.google.android.gms.common.internal.r.h(dVar);
        return new a2(null, dVar.f, dVar.b(), null, null, null, str, null, null);
    }

    @Override // com.google.firebase.auth.b
    public String b() {
        return "facebook.com";
    }

    @Override // com.google.firebase.auth.b
    public final b c() {
        return new d(this.f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
