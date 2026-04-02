package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class c extends b {
    public static final Parcelable.Creator<c> CREATOR = new l0();
    private String f;
    private String g;
    private final String h;
    private String i;
    private boolean j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2, String str3, String str4, boolean z) {
        com.google.android.gms.common.internal.r.f(str);
        this.f = str;
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.j = z;
    }

    @Override // com.google.firebase.auth.b
    public String b() {
        return "password";
    }

    @Override // com.google.firebase.auth.b
    public final b c() {
        return new c(this.f, this.g, this.h, this.i, this.j);
    }

    public String h() {
        return !TextUtils.isEmpty(this.g) ? "password" : "emailLink";
    }

    public final c j(n nVar) {
        this.i = nVar.x();
        this.j = true;
        return this;
    }

    public final String k() {
        return this.f;
    }

    public final String n() {
        return this.g;
    }

    public final String o() {
        return this.h;
    }

    public final boolean p() {
        return !TextUtils.isEmpty(this.h);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, this.g, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 3, this.h, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 4, this.i, false);
        com.google.android.gms.common.internal.w.c.c(parcel, 5, this.j);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
