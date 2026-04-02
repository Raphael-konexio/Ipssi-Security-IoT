package c.a.c.a;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f1490a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f1491b;

    public h(String str, Object obj) {
        this.f1490a = str;
        this.f1491b = obj;
    }

    public <T> T a(String str) {
        Object obj = this.f1491b;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return (T) ((Map) obj).get(str);
        }
        if (obj instanceof JSONObject) {
            return (T) ((JSONObject) obj).opt(str);
        }
        throw new ClassCastException();
    }

    public <T> T b() {
        return (T) this.f1491b;
    }
}
