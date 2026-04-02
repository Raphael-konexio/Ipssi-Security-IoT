package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import b.c.a.a.d.c.q1;
import com.google.firebase.auth.u0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private Context f1904a;

    /* renamed from: b  reason: collision with root package name */
    private String f1905b;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f1906c;

    /* renamed from: d  reason: collision with root package name */
    private b.c.a.a.b.k.a f1907d;

    public q(Context context, String str) {
        com.google.android.gms.common.internal.r.h(context);
        com.google.android.gms.common.internal.r.f(str);
        this.f1905b = str;
        this.f1904a = context.getApplicationContext();
        this.f1906c = this.f1904a.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", this.f1905b), 0);
        this.f1907d = new b.c.a.a.b.k.a("StorageHelpers", new String[0]);
    }

    private final d0 b(JSONObject jSONObject) {
        JSONArray jSONArray;
        e0 c2;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z = jSONObject.getBoolean("anonymous");
            String string3 = jSONObject.getString("version");
            String str = string3 != null ? string3 : "2";
            JSONArray jSONArray2 = jSONObject.getJSONArray("userInfos");
            int length = jSONArray2.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(z.n(jSONArray2.getString(i)));
            }
            d0 d0Var = new d0(b.c.c.c.l(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                d0Var.p(q1.c(string));
            }
            if (!z) {
                d0Var.q();
            }
            d0Var.B(str);
            if (jSONObject.has("userMetadata") && (c2 = e0.c(jSONObject.getJSONObject("userMetadata"))) != null) {
                d0Var.C(c2);
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i2));
                    arrayList2.add("phone".equals(jSONObject2.optString("factorIdKey")) ? com.google.firebase.auth.e0.c(jSONObject2) : null);
                }
                d0Var.r(arrayList2);
            }
            return d0Var;
        } catch (com.google.firebase.auth.z.b | ArrayIndexOutOfBoundsException | IllegalArgumentException | JSONException e) {
            this.f1907d.h(e);
            return null;
        }
    }

    private final String g(com.google.firebase.auth.n nVar) {
        JSONObject jSONObject = new JSONObject();
        if (d0.class.isAssignableFrom(nVar.getClass())) {
            d0 d0Var = (d0) nVar;
            try {
                jSONObject.put("cachedTokenState", d0Var.x());
                jSONObject.put("applicationName", d0Var.t().m());
                jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
                if (d0Var.F() != null) {
                    JSONArray jSONArray = new JSONArray();
                    List<z> F = d0Var.F();
                    for (int i = 0; i < F.size(); i++) {
                        jSONArray.put(F.get(i).p());
                    }
                    jSONObject.put("userInfos", jSONArray);
                }
                jSONObject.put("anonymous", d0Var.h());
                jSONObject.put("version", "2");
                if (d0Var.A() != null) {
                    jSONObject.put("userMetadata", ((e0) d0Var.A()).h());
                }
                List<u0> a2 = ((g0) d0Var.z()).a();
                if (a2 != null && !a2.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        jSONArray2.put(a2.get(i2).b());
                    }
                    jSONObject.put("userMultiFactorInfo", jSONArray2);
                }
                return jSONObject.toString();
            } catch (Exception e) {
                this.f1907d.g("Failed to turn object into JSON", e, new Object[0]);
                throw new com.google.firebase.auth.z.b(e);
            }
        }
        return null;
    }

    public final com.google.firebase.auth.n a() {
        String string = this.f1906c.getString("com.google.firebase.auth.FIREBASE_USER", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return b(jSONObject);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final void c(com.google.firebase.auth.n nVar) {
        com.google.android.gms.common.internal.r.h(nVar);
        String g = g(nVar);
        if (TextUtils.isEmpty(g)) {
            return;
        }
        this.f1906c.edit().putString("com.google.firebase.auth.FIREBASE_USER", g).apply();
    }

    public final void d(com.google.firebase.auth.n nVar, q1 q1Var) {
        com.google.android.gms.common.internal.r.h(nVar);
        com.google.android.gms.common.internal.r.h(q1Var);
        this.f1906c.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", nVar.c()), q1Var.p()).apply();
    }

    public final void e(String str) {
        this.f1906c.edit().remove(str).apply();
    }

    public final q1 f(com.google.firebase.auth.n nVar) {
        com.google.android.gms.common.internal.r.h(nVar);
        String string = this.f1906c.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", nVar.c()), null);
        if (string != null) {
            return q1.c(string);
        }
        return null;
    }
}
