package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b.c.a.a.d.c.a2;
/* loaded from: classes.dex */
public class r extends b {
    public static final Parcelable.Creator<r> CREATOR = new t0();
    private final String f;
    private final String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str, String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        j(str, "idToken");
        this.f = str;
        j(str2, "accessToken");
        this.g = str2;
    }

    public static a2 h(r rVar, String str) {
        com.google.android.gms.common.internal.r.h(rVar);
        return new a2(rVar.f, rVar.g, rVar.b(), null, null, null, str, null, null);
    }

    private static String j(String str, String str2) {
        if (str == null || !TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(str2).concat(" must not be empty"));
    }

    @Override // com.google.firebase.auth.b
    public String b() {
        return "google.com";
    }

    @Override // com.google.firebase.auth.b
    public final b c() {
        return new r(this.f, this.g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, this.g, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
