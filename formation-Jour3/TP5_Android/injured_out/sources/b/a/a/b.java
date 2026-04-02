package b.a.a;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public interface b {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f1145a;

        /* renamed from: b  reason: collision with root package name */
        public String f1146b;

        /* renamed from: c  reason: collision with root package name */
        public long f1147c;

        /* renamed from: d  reason: collision with root package name */
        public long f1148d;
        public long e;
        public long f;
        public Map<String, String> g = Collections.emptyMap();
        public List<g> h;

        public boolean a() {
            return this.e < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f < System.currentTimeMillis();
        }
    }

    void a();

    void b(String str, a aVar);

    a c(String str);
}
