package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a.d.c.a2;
/* loaded from: classes.dex */
public class w extends b {
    public static final Parcelable.Creator<w> CREATOR = new f0();
    private final String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(String str) {
        com.google.android.gms.common.internal.r.f(str);
        this.f = str;
    }

    public static a2 h(w wVar, String str) {
        com.google.android.gms.common.internal.r.h(wVar);
        return new a2(null, null, wVar.b(), null, null, wVar.f, str, null, null);
    }

    @Override // com.google.firebase.auth.b
    public String b() {
        return "playgames.google.com";
    }

    @Override // com.google.firebase.auth.b
    public final b c() {
        return new w(this.f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
