package io.flutter.embedding.engine.h;

import android.content.Context;
import io.flutter.plugin.platform.g;
import io.flutter.view.e;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: io.flutter.embedding.engine.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0119a {
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Context f2510a;

        /* renamed from: b  reason: collision with root package name */
        private final io.flutter.embedding.engine.a f2511b;

        /* renamed from: c  reason: collision with root package name */
        private final c.a.c.a.b f2512c;

        public b(Context context, io.flutter.embedding.engine.a aVar, c.a.c.a.b bVar, e eVar, g gVar, InterfaceC0119a interfaceC0119a) {
            this.f2510a = context;
            this.f2511b = aVar;
            this.f2512c = bVar;
        }

        public Context a() {
            return this.f2510a;
        }

        public c.a.c.a.b b() {
            return this.f2512c;
        }

        @Deprecated
        public io.flutter.embedding.engine.a c() {
            return this.f2511b;
        }
    }

    void c(b bVar);

    void f(b bVar);
}
