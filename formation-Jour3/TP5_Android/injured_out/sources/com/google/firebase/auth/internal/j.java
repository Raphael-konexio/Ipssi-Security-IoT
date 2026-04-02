package com.google.firebase.auth.internal;

import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final b.c.a.a.b.k.a f1897a = new b.c.a.a.b.k.a("JSONParser", new String[0]);

    private static List<Object> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = c((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static Map<String, Object> b(String str) {
        com.google.android.gms.common.internal.r.f(str);
        List<String> c2 = b.c.a.a.d.c.l.b('.').c(str);
        if (c2.size() < 2) {
            b.c.a.a.b.k.a aVar = f1897a;
            String valueOf = String.valueOf(str);
            aVar.b(valueOf.length() != 0 ? "Invalid idToken ".concat(valueOf) : new String("Invalid idToken "), new Object[0]);
        } else {
            try {
                Map<String, Object> d2 = d(new String(com.google.android.gms.common.util.b.b(c2.get(1)), "UTF-8"));
                return d2 == null ? b.c.a.a.d.c.b0.a() : d2;
            } catch (UnsupportedEncodingException e) {
                f1897a.a("Unable to decode token", e, new Object[0]);
            }
        }
        return b.c.a.a.d.c.b0.a();
    }

    private static Map<String, Object> c(JSONObject jSONObject) {
        a.d.a aVar = new a.d.a();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = c((JSONObject) obj);
            }
            aVar.put(next, obj);
        }
        return aVar;
    }

    public static Map<String, Object> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return c(jSONObject);
            }
            return null;
        } catch (Exception e) {
            Log.d("JSONParser", "Failed to parse JSONObject into Map.");
            throw new com.google.firebase.auth.z.b(e);
        }
    }
}
