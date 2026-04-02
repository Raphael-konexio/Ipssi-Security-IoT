package io.flutter.embedding.engine.h.g;

import android.app.Activity;
import c.a.c.a.k;
import c.a.c.a.l;
import c.a.c.a.m;
import c.a.c.a.n;
import c.a.c.a.o;
import c.a.c.a.p;
import io.flutter.embedding.engine.h.a;
import io.flutter.embedding.engine.h.c.c;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
class b implements m, io.flutter.embedding.engine.h.a, io.flutter.embedding.engine.h.c.a {

    /* renamed from: a  reason: collision with root package name */
    private final Set<p> f2519a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private final Set<n> f2520b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private final Set<k> f2521c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    private final Set<l> f2522d = new HashSet();
    private final Set<o> e = new HashSet();
    private a.b f;
    private c g;

    public b(String str, Map<String, Object> map) {
    }

    private void j() {
        for (n nVar : this.f2520b) {
            this.g.c(nVar);
        }
        for (k kVar : this.f2521c) {
            this.g.a(kVar);
        }
        for (l lVar : this.f2522d) {
            this.g.b(lVar);
        }
        for (o oVar : this.e) {
            this.g.d(oVar);
        }
    }

    @Override // c.a.c.a.m
    public m a(k kVar) {
        this.f2521c.add(kVar);
        c cVar = this.g;
        if (cVar != null) {
            cVar.a(kVar);
        }
        return this;
    }

    @Override // io.flutter.embedding.engine.h.c.a
    public void b(c cVar) {
        c.a.b.d("ShimRegistrar", "Attached to an Activity.");
        this.g = cVar;
        j();
    }

    @Override // io.flutter.embedding.engine.h.a
    public void c(a.b bVar) {
        c.a.b.d("ShimRegistrar", "Attached to FlutterEngine.");
        this.f = bVar;
    }

    @Override // io.flutter.embedding.engine.h.c.a
    public void d() {
        c.a.b.d("ShimRegistrar", "Detached from an Activity.");
        this.g = null;
    }

    @Override // io.flutter.embedding.engine.h.c.a
    public void e(c cVar) {
        c.a.b.d("ShimRegistrar", "Reconnected to an Activity after config changes.");
        this.g = cVar;
        j();
    }

    @Override // io.flutter.embedding.engine.h.a
    public void f(a.b bVar) {
        c.a.b.d("ShimRegistrar", "Detached from FlutterEngine.");
        for (p pVar : this.f2519a) {
            pVar.a(null);
        }
        this.f = null;
        this.g = null;
    }

    @Override // c.a.c.a.m
    public Activity g() {
        c cVar = this.g;
        if (cVar != null) {
            return cVar.e();
        }
        return null;
    }

    @Override // c.a.c.a.m
    public c.a.c.a.b h() {
        a.b bVar = this.f;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    @Override // io.flutter.embedding.engine.h.c.a
    public void i() {
        c.a.b.d("ShimRegistrar", "Detached from an Activity for config changes.");
        this.g = null;
    }
}
