package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class a2 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<a2> CREATOR = new d2();
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private boolean n;
    private boolean o;
    private String p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private String u;

    public a2() {
        this.n = true;
        this.o = true;
    }

    public a2(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f = "http://localhost";
        this.h = str;
        this.i = str2;
        this.m = str5;
        this.p = str6;
        this.s = str7;
        this.u = str8;
        this.n = true;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(this.i) && TextUtils.isEmpty(this.p)) {
            throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
        }
        com.google.android.gms.common.internal.r.f(str3);
        this.j = str3;
        this.k = null;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.h)) {
            sb.append("id_token=");
            sb.append(this.h);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.i)) {
            sb.append("access_token=");
            sb.append(this.i);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.k)) {
            sb.append("identifier=");
            sb.append(this.k);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.m)) {
            sb.append("oauth_token_secret=");
            sb.append(this.m);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.p)) {
            sb.append("code=");
            sb.append(this.p);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(str9)) {
            sb.append("nonce=");
            sb.append(str9);
            sb.append("&");
        }
        sb.append("providerId=");
        sb.append(this.j);
        this.l = sb.toString();
        this.o = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a2(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, String str9, String str10, String str11, String str12, boolean z3, String str13) {
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.j = str5;
        this.k = str6;
        this.l = str7;
        this.m = str8;
        this.n = z;
        this.o = z2;
        this.p = str9;
        this.q = str10;
        this.r = str11;
        this.s = str12;
        this.t = z3;
        this.u = str13;
    }

    public final a2 b(boolean z) {
        this.o = false;
        return this;
    }

    public final a2 c(String str) {
        this.s = str;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, this.f, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 3, this.g, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 4, this.h, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 5, this.i, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 6, this.j, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 7, this.k, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 8, this.l, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 9, this.m, false);
        com.google.android.gms.common.internal.w.c.c(parcel, 10, this.n);
        com.google.android.gms.common.internal.w.c.c(parcel, 11, this.o);
        com.google.android.gms.common.internal.w.c.k(parcel, 12, this.p, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 13, this.q, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 14, this.r, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 15, this.s, false);
        com.google.android.gms.common.internal.w.c.c(parcel, 16, this.t);
        com.google.android.gms.common.internal.w.c.k(parcel, 17, this.u, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
