package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.w.a;
import com.google.android.gms.common.internal.w.c;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GoogleSignInAccount extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new b();
    private static d s = f.b();
    private final int f;
    private String g;
    private String h;
    private String i;
    private String j;
    private Uri k;
    private String l;
    private long m;
    private String n;
    private List<Scope> o;
    private String p;
    private String q;
    private Set<Scope> r = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f = i;
        this.g = str;
        this.h = str2;
        this.i = str3;
        this.j = str4;
        this.k = uri;
        this.l = str5;
        this.m = j;
        this.n = str6;
        this.o = list;
        this.p = str7;
        this.q = str8;
    }

    public static GoogleSignInAccount t(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount v = v(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        v.l = jSONObject.optString("serverAuthCode", null);
        return v;
    }

    private static GoogleSignInAccount v(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        long longValue = (l == null ? Long.valueOf(s.a() / 1000) : l).longValue();
        r.f(str7);
        r.h(set);
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, longValue, str7, new ArrayList(set), str5, str6);
    }

    public Account b() {
        if (this.i == null) {
            return null;
        }
        return new Account(this.i, "com.google");
    }

    public String c() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GoogleSignInAccount) {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
            return googleSignInAccount.n.equals(this.n) && googleSignInAccount.q().equals(q());
        }
        return false;
    }

    public String h() {
        return this.i;
    }

    public int hashCode() {
        return ((this.n.hashCode() + 527) * 31) + q().hashCode();
    }

    public String j() {
        return this.q;
    }

    public String k() {
        return this.p;
    }

    public String n() {
        return this.g;
    }

    public String o() {
        return this.h;
    }

    public Uri p() {
        return this.k;
    }

    public Set<Scope> q() {
        HashSet hashSet = new HashSet(this.o);
        hashSet.addAll(this.r);
        return hashSet;
    }

    public String r() {
        return this.l;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.g(parcel, 1, this.f);
        c.k(parcel, 2, n(), false);
        c.k(parcel, 3, o(), false);
        c.k(parcel, 4, h(), false);
        c.k(parcel, 5, c(), false);
        c.j(parcel, 6, p(), i, false);
        c.k(parcel, 7, r(), false);
        c.h(parcel, 8, this.m);
        c.k(parcel, 9, this.n, false);
        c.n(parcel, 10, this.o, false);
        c.k(parcel, 11, k(), false);
        c.k(parcel, 12, j(), false);
        c.b(parcel, a2);
    }
}
