package c.a.c.a;

import c.a.c.a.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final c.a.c.a.b f1492a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1493b;

    /* renamed from: c  reason: collision with root package name */
    private final j f1494c;

    /* loaded from: classes.dex */
    private final class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final c f1495a;

        /* renamed from: c.a.c.a.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0072a implements d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b.InterfaceC0071b f1497a;

            C0072a(b.InterfaceC0071b interfaceC0071b) {
                this.f1497a = interfaceC0071b;
            }

            @Override // c.a.c.a.i.d
            public void a() {
                this.f1497a.a(null);
            }

            @Override // c.a.c.a.i.d
            public void b(String str, String str2, Object obj) {
                this.f1497a.a(i.this.f1494c.c(str, str2, obj));
            }

            @Override // c.a.c.a.i.d
            public void c(Object obj) {
                this.f1497a.a(i.this.f1494c.a(obj));
            }
        }

        a(c cVar) {
            this.f1495a = cVar;
        }

        private String b(Exception exc) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }

        @Override // c.a.c.a.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0071b interfaceC0071b) {
            try {
                this.f1495a.b(i.this.f1494c.d(byteBuffer), new C0072a(interfaceC0071b));
            } catch (RuntimeException e) {
                c.a.b.c("MethodChannel#" + i.this.f1493b, "Failed to handle method call", e);
                interfaceC0071b.a(i.this.f1494c.b("error", e.getMessage(), null, b(e)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements b.InterfaceC0071b {

        /* renamed from: a  reason: collision with root package name */
        private final d f1499a;

        b(d dVar) {
            this.f1499a = dVar;
        }

        @Override // c.a.c.a.b.InterfaceC0071b
        public void a(ByteBuffer byteBuffer) {
            try {
                if (byteBuffer == null) {
                    this.f1499a.a();
                } else {
                    try {
                        this.f1499a.c(i.this.f1494c.e(byteBuffer));
                    } catch (c.a.c.a.c e) {
                        this.f1499a.b(e.f, e.getMessage(), e.g);
                    }
                }
            } catch (RuntimeException e2) {
                c.a.b.c("MethodChannel#" + i.this.f1493b, "Failed to handle method call result", e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void b(h hVar, d dVar);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b(String str, String str2, Object obj);

        void c(Object obj);
    }

    public i(c.a.c.a.b bVar, String str) {
        this(bVar, str, r.f1504b);
    }

    public i(c.a.c.a.b bVar, String str, j jVar) {
        this.f1492a = bVar;
        this.f1493b = str;
        this.f1494c = jVar;
    }

    public void c(String str, Object obj) {
        d(str, obj, null);
    }

    public void d(String str, Object obj, d dVar) {
        this.f1492a.a(this.f1493b, this.f1494c.f(new h(str, obj)), dVar == null ? null : new b(dVar));
    }

    public void e(c cVar) {
        this.f1492a.b(this.f1493b, cVar == null ? null : new a(cVar));
    }
}
