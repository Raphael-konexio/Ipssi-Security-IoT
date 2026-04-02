package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class q1 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<q1> CREATOR = new p1();
    private String f;
    private String g;
    private Long h;
    private String i;
    private Long j;

    public q1() {
        this.j = Long.valueOf(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q1(String str, String str2, Long l, String str3, Long l2) {
        this.f = str;
        this.g = str2;
        this.h = l;
        this.i = str3;
        this.j = l2;
    }

    public static q1 c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            q1 q1Var = new q1();
            q1Var.f = jSONObject.optString("refresh_token", null);
            q1Var.g = jSONObject.optString("access_token", null);
            q1Var.h = Long.valueOf(jSONObject.optLong("expires_in"));
            q1Var.i = jSONObject.optString("token_type", null);
            q1Var.j = Long.valueOf(jSONObject.optLong("issued_at"));
            return q1Var;
        } catch (JSONException e) {
            Log.d("GetTokenResponse", "Failed to read GetTokenResponse from JSONObject");
            throw new com.google.firebase.auth.z.b(e);
        }
    }

    public final void b(String str) {
        com.google.android.gms.common.internal.r.f(str);
        this.f = str;
    }

    public final boolean h() {
        return com.google.android.gms.common.util.f.b().a() + 300000 < this.j.longValue() + (this.h.longValue() * 1000);
    }

    public final String j() {
        return this.f;
    }

    public final String k() {
        return this.g;
    }

    public final long n() {
        Long l = this.h;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final long o() {
        return this.j.longValue();
    }

    public final String p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh_token", this.f);
            jSONObject.put("access_token", this.g);
            jSONObject.put("expires_in", this.h);
            jSONObject.put("token_type", this.i);
            jSONObject.put("issued_at", this.j);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d("GetTokenResponse", "Failed to convert GetTokenResponse to JSON");
            throw new com.google.firebase.auth.z.b(e);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, this.f, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 3, this.g, false);
        com.google.android.gms.common.internal.w.c.i(parcel, 4, Long.valueOf(n()), false);
        com.google.android.gms.common.internal.w.c.k(parcel, 5, this.i, false);
        com.google.android.gms.common.internal.w.c.i(parcel, 6, Long.valueOf(this.j.longValue()), false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
