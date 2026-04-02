package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e0 extends u0 {
    public static final Parcelable.Creator<e0> CREATOR = new d0();
    private final String f;
    private final String g;
    private final long h;
    private final String i;

    public e0(String str, String str2, long j, String str3) {
        com.google.android.gms.common.internal.r.f(str);
        this.f = str;
        this.g = str2;
        this.h = j;
        com.google.android.gms.common.internal.r.f(str3);
        this.i = str3;
    }

    public static e0 c(JSONObject jSONObject) {
        if (jSONObject.has("enrollmentTimestamp")) {
            return new e0(jSONObject.optString("uid"), jSONObject.optString("displayName"), jSONObject.optLong("enrollmentTimestamp"), jSONObject.optString("phoneNumber"));
        }
        throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance.");
    }

    @Override // com.google.firebase.auth.u0
    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("factorIdKey", "phone");
            jSONObject.putOpt("uid", this.f);
            jSONObject.putOpt("displayName", this.g);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.h));
            jSONObject.putOpt("phoneNumber", this.i);
            return jSONObject;
        } catch (JSONException e) {
            Log.d("PhoneMultiFactorInfo", "Failed to jsonify this object");
            throw new com.google.firebase.auth.z.b(e);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, this.g, false);
        com.google.android.gms.common.internal.w.c.h(parcel, 3, this.h);
        com.google.android.gms.common.internal.w.c.k(parcel, 4, this.i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
