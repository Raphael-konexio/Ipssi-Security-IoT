package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f899a = new HashMap();

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        Map<String, Object> map = this.f899a;
        if (map != null) {
            synchronized (map) {
                for (Object obj : this.f899a.values()) {
                    b(obj);
                }
            }
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> T c(String str) {
        T t;
        Map<String, Object> map = this.f899a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = (T) this.f899a.get(str);
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
    }
}
