package c.a.c.a;

import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e implements j {

    /* renamed from: a  reason: collision with root package name */
    public static final e f1489a = new e();

    private e() {
    }

    @Override // c.a.c.a.j
    public ByteBuffer a(Object obj) {
        return d.f1488a.a(new JSONArray().put(f.a(obj)));
    }

    @Override // c.a.c.a.j
    public ByteBuffer b(String str, String str2, Object obj, String str3) {
        return d.f1488a.a(new JSONArray().put(str).put(f.a(str2)).put(f.a(obj)).put(f.a(str3)));
    }

    @Override // c.a.c.a.j
    public ByteBuffer c(String str, String str2, Object obj) {
        return d.f1488a.a(new JSONArray().put(str).put(f.a(str2)).put(f.a(obj)));
    }

    @Override // c.a.c.a.j
    public h d(ByteBuffer byteBuffer) {
        try {
            Object b2 = d.f1488a.b(byteBuffer);
            if (b2 instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) b2;
                Object obj = jSONObject.get("method");
                Object g = g(jSONObject.opt("args"));
                if (obj instanceof String) {
                    return new h((String) obj, g);
                }
            }
            throw new IllegalArgumentException("Invalid method call: " + b2);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    @Override // c.a.c.a.j
    public Object e(ByteBuffer byteBuffer) {
        try {
            Object b2 = d.f1488a.b(byteBuffer);
            if (b2 instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) b2;
                if (jSONArray.length() == 1) {
                    return g(jSONArray.opt(0));
                }
                if (jSONArray.length() == 3) {
                    Object obj = jSONArray.get(0);
                    Object g = g(jSONArray.opt(1));
                    Object g2 = g(jSONArray.opt(2));
                    if ((obj instanceof String) && (g == null || (g instanceof String))) {
                        throw new c((String) obj, (String) g, g2);
                    }
                }
            }
            throw new IllegalArgumentException("Invalid envelope: " + b2);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    @Override // c.a.c.a.j
    public ByteBuffer f(h hVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", hVar.f1490a);
            jSONObject.put("args", f.a(hVar.f1491b));
            return d.f1488a.a(jSONObject);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    Object g(Object obj) {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj;
    }
}
