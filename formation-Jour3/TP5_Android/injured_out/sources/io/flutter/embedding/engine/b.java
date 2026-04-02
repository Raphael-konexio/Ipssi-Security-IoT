package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f2467b;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f2468a = new HashMap();

    b() {
    }

    public static b b() {
        if (f2467b == null) {
            f2467b = new b();
        }
        return f2467b;
    }

    public a a(String str) {
        return this.f2468a.get(str);
    }

    public void c(String str, a aVar) {
        if (aVar != null) {
            this.f2468a.put(str, aVar);
        } else {
            this.f2468a.remove(str);
        }
    }

    public void d(String str) {
        c(str, null);
    }
}
