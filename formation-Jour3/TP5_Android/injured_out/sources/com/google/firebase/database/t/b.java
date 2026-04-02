package com.google.firebase.database.t;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;
/* loaded from: classes.dex */
public class b {
    public static Map<String, Object> a(String str) {
        try {
            return h(new JSONObject(str));
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    public static Object b(String str) {
        try {
            return f(new JSONTokener(str).nextValue());
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    public static String c(Map<String, Object> map) {
        return d(map);
    }

    public static String d(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof String) {
            return JSONObject.quote((String) obj);
        }
        if (obj instanceof Number) {
            try {
                return JSONObject.numberToString((Number) obj);
            } catch (JSONException e) {
                throw new IOException("Could not serialize number", e);
            }
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? "true" : "false";
        } else {
            try {
                JSONStringer jSONStringer = new JSONStringer();
                e(obj, jSONStringer);
                return jSONStringer.toString();
            } catch (JSONException e2) {
                throw new IOException("Failed to serialize JSON", e2);
            }
        }
    }

    private static void e(Object obj, JSONStringer jSONStringer) {
        if (obj instanceof Map) {
            jSONStringer.object();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                jSONStringer.key((String) entry.getKey());
                e(entry.getValue(), jSONStringer);
            }
            jSONStringer.endObject();
        } else if (!(obj instanceof Collection)) {
            jSONStringer.value(obj);
        } else {
            jSONStringer.array();
            for (Object obj2 : (Collection) obj) {
                e(obj2, jSONStringer);
            }
            jSONStringer.endArray();
        }
    }

    private static Object f(Object obj) {
        if (obj instanceof JSONObject) {
            return h((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return g((JSONArray) obj);
        }
        if (obj.equals(JSONObject.NULL)) {
            return null;
        }
        return obj;
    }

    private static List<Object> g(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(f(jSONArray.get(i)));
        }
        return arrayList;
    }

    private static Map<String, Object> h(JSONObject jSONObject) {
        HashMap hashMap = new HashMap(jSONObject.length());
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, f(jSONObject.get(next)));
        }
        return hashMap;
    }
}
