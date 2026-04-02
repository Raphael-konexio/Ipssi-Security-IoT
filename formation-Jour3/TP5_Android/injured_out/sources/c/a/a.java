package c.a;

import io.flutter.embedding.engine.g.c;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f1474c;

    /* renamed from: a  reason: collision with root package name */
    private c f1475a;

    /* renamed from: b  reason: collision with root package name */
    private io.flutter.embedding.engine.f.a f1476b;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private c f1477a;

        /* renamed from: b  reason: collision with root package name */
        private io.flutter.embedding.engine.f.a f1478b;

        private void b() {
            if (this.f1477a == null) {
                this.f1477a = new c();
            }
        }

        public a a() {
            b();
            return new a(this.f1477a, this.f1478b);
        }
    }

    private a(c cVar, io.flutter.embedding.engine.f.a aVar) {
        this.f1475a = cVar;
        this.f1476b = aVar;
    }

    public static a c() {
        if (f1474c == null) {
            f1474c = new b().a();
        }
        return f1474c;
    }

    public io.flutter.embedding.engine.f.a a() {
        return this.f1476b;
    }

    public c b() {
        return this.f1475a;
    }
}
