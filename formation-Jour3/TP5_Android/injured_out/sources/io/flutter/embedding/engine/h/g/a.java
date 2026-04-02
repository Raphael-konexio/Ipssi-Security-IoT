package io.flutter.embedding.engine.h.g;

import c.a.c.a.m;
import io.flutter.embedding.engine.h.a;
import io.flutter.embedding.engine.h.c.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final io.flutter.embedding.engine.a f2513a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Object> f2514b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final b f2515c = new b();

    /* loaded from: classes.dex */
    private static class b implements io.flutter.embedding.engine.h.a, io.flutter.embedding.engine.h.c.a {

        /* renamed from: a  reason: collision with root package name */
        private final Set<io.flutter.embedding.engine.h.g.b> f2516a;

        /* renamed from: b  reason: collision with root package name */
        private a.b f2517b;

        /* renamed from: c  reason: collision with root package name */
        private c f2518c;

        private b() {
            this.f2516a = new HashSet();
        }

        public void a(io.flutter.embedding.engine.h.g.b bVar) {
            this.f2516a.add(bVar);
            a.b bVar2 = this.f2517b;
            if (bVar2 != null) {
                bVar.c(bVar2);
            }
            c cVar = this.f2518c;
            if (cVar != null) {
                bVar.b(cVar);
            }
        }

        @Override // io.flutter.embedding.engine.h.c.a
        public void b(c cVar) {
            this.f2518c = cVar;
            for (io.flutter.embedding.engine.h.g.b bVar : this.f2516a) {
                bVar.b(cVar);
            }
        }

        @Override // io.flutter.embedding.engine.h.a
        public void c(a.b bVar) {
            this.f2517b = bVar;
            for (io.flutter.embedding.engine.h.g.b bVar2 : this.f2516a) {
                bVar2.c(bVar);
            }
        }

        @Override // io.flutter.embedding.engine.h.c.a
        public void d() {
            for (io.flutter.embedding.engine.h.g.b bVar : this.f2516a) {
                bVar.d();
            }
            this.f2518c = null;
        }

        @Override // io.flutter.embedding.engine.h.c.a
        public void e(c cVar) {
            this.f2518c = cVar;
            for (io.flutter.embedding.engine.h.g.b bVar : this.f2516a) {
                bVar.e(cVar);
            }
        }

        @Override // io.flutter.embedding.engine.h.a
        public void f(a.b bVar) {
            for (io.flutter.embedding.engine.h.g.b bVar2 : this.f2516a) {
                bVar2.f(bVar);
            }
            this.f2517b = null;
            this.f2518c = null;
        }

        @Override // io.flutter.embedding.engine.h.c.a
        public void i() {
            for (io.flutter.embedding.engine.h.g.b bVar : this.f2516a) {
                bVar.d();
            }
            this.f2518c = null;
        }
    }

    public a(io.flutter.embedding.engine.a aVar) {
        this.f2513a = aVar;
        this.f2513a.p().j(this.f2515c);
    }

    public m a(String str) {
        c.a.b.d("ShimPluginRegistry", "Creating plugin Registrar for '" + str + "'");
        if (!this.f2514b.containsKey(str)) {
            this.f2514b.put(str, null);
            io.flutter.embedding.engine.h.g.b bVar = new io.flutter.embedding.engine.h.g.b(str, this.f2514b);
            this.f2515c.a(bVar);
            return bVar;
        }
        throw new IllegalStateException("Plugin key " + str + " is already in use");
    }
}
