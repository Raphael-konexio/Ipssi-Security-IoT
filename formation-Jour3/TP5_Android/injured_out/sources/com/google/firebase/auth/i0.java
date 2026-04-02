package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a.d.c.a2;
/* loaded from: classes.dex */
public class i0 extends s {
    public static final Parcelable.Creator<i0> CREATOR = new k0();
    private final String f;
    private final String g;
    private final String h;
    private final a2 i;
    private final String j;
    private final String k;
    private final String l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(String str, String str2, String str3, a2 a2Var, String str4, String str5, String str6) {
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = a2Var;
        this.j = str4;
        this.k = str5;
        this.l = str6;
    }

    public static a2 n(i0 i0Var, String str) {
        com.google.android.gms.common.internal.r.h(i0Var);
        a2 a2Var = i0Var.i;
        return a2Var != null ? a2Var : new a2(i0Var.j(), i0Var.h(), i0Var.b(), null, i0Var.k(), null, str, i0Var.j, i0Var.l);
    }

    public static i0 o(a2 a2Var) {
        com.google.android.gms.common.internal.r.i(a2Var, "Must specify a non-null webSignInCredential");
        return new i0(null, null, null, a2Var, null, null, null);
    }

    @Override // com.google.firebase.auth.b
    public String b() {
        return this.f;
    }

    @Override // com.google.firebase.auth.b
    public final b c() {
        return new i0(this.f, this.g, this.h, this.i, this.j, this.k, this.l);
    }

    public String h() {
        return this.h;
    }

    public String j() {
        return this.g;
    }

    public String k() {
        return this.k;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, b(), false);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, j(), false);
        com.google.android.gms.common.internal.w.c.k(parcel, 3, h(), false);
        com.google.android.gms.common.internal.w.c.j(parcel, 4, this.i, i, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 5, this.j, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 6, k(), false);
        com.google.android.gms.common.internal.w.c.k(parcel, 7, this.l, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
