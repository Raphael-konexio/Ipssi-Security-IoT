package c.a.c.a;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes.dex */
public final class d implements g<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final d f1488a = new d();

    private d() {
    }

    @Override // c.a.c.a.g
    public ByteBuffer a(Object obj) {
        s sVar;
        String obj2;
        if (obj == null) {
            return null;
        }
        Object a2 = f.a(obj);
        if (a2 instanceof String) {
            sVar = s.f1507b;
            obj2 = JSONObject.quote((String) a2);
        } else {
            sVar = s.f1507b;
            obj2 = a2.toString();
        }
        return sVar.a(obj2);
    }

    @Override // c.a.c.a.g
    public Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            JSONTokener jSONTokener = new JSONTokener(s.f1507b.b(byteBuffer));
            Object nextValue = jSONTokener.nextValue();
            if (jSONTokener.more()) {
                throw new IllegalArgumentException("Invalid JSON");
            }
            return nextValue;
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }
}
