package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class t extends b implements Cloneable {
    public static final Parcelable.Creator<t> CREATOR = new c0();
    private String f;
    private String g;
    private boolean h;
    private String i;
    private boolean j;
    private String k;
    private String l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(String str, String str2, boolean z, String str3, boolean z2, String str4, String str5) {
        com.google.android.gms.common.internal.r.b((z && !TextUtils.isEmpty(str3) && TextUtils.isEmpty(str5)) || (z && TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str5)) || !((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))), "Cannot create PhoneAuthCredential without either verificationProof, sessionInfo, temporary proof, or enrollment ID.");
        this.f = str;
        this.g = str2;
        this.h = z;
        this.i = str3;
        this.j = z2;
        this.k = str4;
        this.l = str5;
    }

    @Override // com.google.firebase.auth.b
    public String b() {
        return "phone";
    }

    @Override // com.google.firebase.auth.b
    public final b c() {
        return (t) clone();
    }

    public /* synthetic */ Object clone() {
        return new t(this.f, h(), this.h, this.i, this.j, this.k, this.l);
    }

    public String h() {
        return this.g;
    }

    public final t j(boolean z) {
        this.j = false;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, h(), false);
        com.google.android.gms.common.internal.w.c.c(parcel, 3, this.h);
        com.google.android.gms.common.internal.w.c.k(parcel, 4, this.i, false);
        com.google.android.gms.common.internal.w.c.c(parcel, 5, this.j);
        com.google.android.gms.common.internal.w.c.k(parcel, 6, this.k, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 7, this.l, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
