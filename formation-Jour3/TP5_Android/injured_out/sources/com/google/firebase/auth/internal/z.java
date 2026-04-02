package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import b.c.a.a.d.c.m1;
import b.c.a.a.d.c.u1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class z extends com.google.android.gms.common.internal.w.a implements com.google.firebase.auth.y {
    public static final Parcelable.Creator<z> CREATOR = new c0();
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private boolean l;
    private String m;

    public z(m1 m1Var, String str) {
        com.google.android.gms.common.internal.r.h(m1Var);
        com.google.android.gms.common.internal.r.f(str);
        String h = m1Var.h();
        com.google.android.gms.common.internal.r.f(h);
        this.f = h;
        this.g = str;
        this.j = m1Var.b();
        this.h = m1Var.j();
        Uri k = m1Var.k();
        if (k != null) {
            this.i = k.toString();
        }
        this.l = m1Var.c();
        this.m = null;
        this.k = m1Var.n();
    }

    public z(u1 u1Var) {
        com.google.android.gms.common.internal.r.h(u1Var);
        this.f = u1Var.b();
        String j = u1Var.j();
        com.google.android.gms.common.internal.r.f(j);
        this.g = j;
        this.h = u1Var.c();
        Uri h = u1Var.h();
        if (h != null) {
            this.i = h.toString();
        }
        this.j = u1Var.o();
        this.k = u1Var.k();
        this.l = false;
        this.m = u1Var.n();
    }

    public z(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        this.f = str;
        this.g = str2;
        this.j = str3;
        this.k = str4;
        this.h = str5;
        this.i = str6;
        if (!TextUtils.isEmpty(str6)) {
            Uri.parse(this.i);
        }
        this.l = z;
        this.m = str7;
    }

    public static z n(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new z(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString("email"), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new com.google.firebase.auth.z.b(e);
        }
    }

    @Override // com.google.firebase.auth.y
    public final String a() {
        return this.g;
    }

    public final String b() {
        return this.h;
    }

    public final String c() {
        return this.j;
    }

    public final String h() {
        return this.k;
    }

    public final String j() {
        return this.f;
    }

    public final boolean k() {
        return this.l;
    }

    public final String o() {
        return this.m;
    }

    public final String p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.f);
            jSONObject.putOpt("providerId", this.g);
            jSONObject.putOpt("displayName", this.h);
            jSONObject.putOpt("photoUrl", this.i);
            jSONObject.putOpt("email", this.j);
            jSONObject.putOpt("phoneNumber", this.k);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.l));
            jSONObject.putOpt("rawUserInfo", this.m);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new com.google.firebase.auth.z.b(e);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, j(), false);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, a(), false);
        com.google.android.gms.common.internal.w.c.k(parcel, 3, b(), false);
        com.google.android.gms.common.internal.w.c.k(parcel, 4, this.i, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 5, c(), false);
        com.google.android.gms.common.internal.w.c.k(parcel, 6, h(), false);
        com.google.android.gms.common.internal.w.c.c(parcel, 7, k());
        com.google.android.gms.common.internal.w.c.k(parcel, 8, this.m, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
