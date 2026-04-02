package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e0 implements com.google.firebase.auth.o {
    public static final Parcelable.Creator<e0> CREATOR = new h0();
    private long f;
    private long g;

    public e0(long j, long j2) {
        this.f = j;
        this.g = j2;
    }

    public static e0 c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new e0(jSONObject.getLong("lastSignInTimestamp"), jSONObject.getLong("creationTimestamp"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final long a() {
        return this.g;
    }

    public final long b() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.f);
            jSONObject.put("creationTimestamp", this.g);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.h(parcel, 1, b());
        com.google.android.gms.common.internal.w.c.h(parcel, 2, a());
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
