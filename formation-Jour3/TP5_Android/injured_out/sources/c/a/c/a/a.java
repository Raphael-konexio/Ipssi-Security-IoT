package c.a.c.a;

import c.a.c.a.b;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final c.a.c.a.b f1479a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1480b;

    /* renamed from: c  reason: collision with root package name */
    private final g<T> f1481c;

    /* loaded from: classes.dex */
    private final class b implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final d<T> f1482a;

        /* renamed from: c.a.c.a.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0070a implements e<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b.InterfaceC0071b f1484a;

            C0070a(b.InterfaceC0071b interfaceC0071b) {
                this.f1484a = interfaceC0071b;
            }

            @Override // c.a.c.a.a.e
            public void a(T t) {
                this.f1484a.a(a.this.f1481c.a(t));
            }
        }

        private b(d<T> dVar) {
            this.f1482a = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.a.c.a.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0071b interfaceC0071b) {
            try {
                this.f1482a.a(a.this.f1481c.b(byteBuffer), new C0070a(interfaceC0071b));
            } catch (RuntimeException e) {
                c.a.b.c("BasicMessageChannel#" + a.this.f1480b, "Failed to handle message", e);
                interfaceC0071b.a(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c implements b.InterfaceC0071b {

        /* renamed from: a  reason: collision with root package name */
        private final e<T> f1486a;

        private c(e<T> eVar) {
            this.f1486a = eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.a.c.a.b.InterfaceC0071b
        public void a(ByteBuffer byteBuffer) {
            try {
                this.f1486a.a(a.this.f1481c.b(byteBuffer));
            } catch (RuntimeException e) {
                c.a.b.c("BasicMessageChannel#" + a.this.f1480b, "Failed to handle message reply", e);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d<T> {
        void a(T t, e<T> eVar);
    }

    /* loaded from: classes.dex */
    public interface e<T> {
        void a(T t);
    }

    public a(c.a.c.a.b bVar, String str, g<T> gVar) {
        this.f1479a = bVar;
        this.f1480b = str;
        this.f1481c = gVar;
    }

    public void c(T t) {
        d(t, null);
    }

    public void d(T t, e<T> eVar) {
        this.f1479a.a(this.f1480b, this.f1481c.a(t), eVar != null ? new c(eVar) : null);
    }

    public void e(d<T> dVar) {
        this.f1479a.b(this.f1480b, dVar != null ? new b(dVar) : null);
    }
}
