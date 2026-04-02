package com.google.firebase.database.p.f0;

import com.google.firebase.database.p.l;
import com.google.firebase.database.p.y;
import com.google.firebase.database.r.n;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private final f f2148a;

    /* renamed from: b  reason: collision with root package name */
    private final i f2149b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.database.q.c f2150c;

    /* renamed from: d  reason: collision with root package name */
    private final a f2151d;
    private long e;

    public b(com.google.firebase.database.p.g gVar, f fVar, a aVar) {
        this(gVar, fVar, aVar, new com.google.firebase.database.p.g0.b());
    }

    public b(com.google.firebase.database.p.g gVar, f fVar, a aVar, com.google.firebase.database.p.g0.a aVar2) {
        this.e = 0L;
        this.f2148a = fVar;
        this.f2150c = gVar.n("Persistence");
        this.f2149b = new i(this.f2148a, this.f2150c, aVar2);
        this.f2151d = aVar;
    }

    private void p() {
        long j = this.e + 1;
        this.e = j;
        if (this.f2151d.d(j)) {
            if (this.f2150c.f()) {
                this.f2150c.b("Reached prune check threshold.", new Object[0]);
            }
            this.e = 0L;
            boolean z = true;
            long n = this.f2148a.n();
            if (this.f2150c.f()) {
                com.google.firebase.database.q.c cVar = this.f2150c;
                cVar.b("Cache size: " + n, new Object[0]);
            }
            while (z && this.f2151d.a(n, this.f2149b.f())) {
                g p = this.f2149b.p(this.f2151d);
                if (p.e()) {
                    this.f2148a.u(l.w(), p);
                } else {
                    z = false;
                }
                n = this.f2148a.n();
                if (this.f2150c.f()) {
                    com.google.firebase.database.q.c cVar2 = this.f2150c;
                    cVar2.b("Cache size after prune: " + n, new Object[0]);
                }
            }
        }
    }

    @Override // com.google.firebase.database.p.f0.e
    public void a(long j) {
        this.f2148a.a(j);
    }

    @Override // com.google.firebase.database.p.f0.e
    public void b(l lVar, com.google.firebase.database.p.b bVar, long j) {
        this.f2148a.b(lVar, bVar, j);
    }

    @Override // com.google.firebase.database.p.f0.e
    public List<y> c() {
        return this.f2148a.c();
    }

    @Override // com.google.firebase.database.p.f0.e
    public void d(l lVar, n nVar, long j) {
        this.f2148a.d(lVar, nVar, j);
    }

    @Override // com.google.firebase.database.p.f0.e
    public void e(com.google.firebase.database.p.h0.i iVar) {
        this.f2149b.x(iVar);
    }

    @Override // com.google.firebase.database.p.f0.e
    public void f(com.google.firebase.database.p.h0.i iVar) {
        if (iVar.g()) {
            this.f2149b.t(iVar.e());
        } else {
            this.f2149b.w(iVar);
        }
    }

    @Override // com.google.firebase.database.p.f0.e
    public void g(com.google.firebase.database.p.h0.i iVar, Set<com.google.firebase.database.r.b> set, Set<com.google.firebase.database.r.b> set2) {
        this.f2148a.s(this.f2149b.i(iVar).f2159a, set, set2);
    }

    @Override // com.google.firebase.database.p.f0.e
    public void h(com.google.firebase.database.p.h0.i iVar, Set<com.google.firebase.database.r.b> set) {
        this.f2148a.k(this.f2149b.i(iVar).f2159a, set);
    }

    @Override // com.google.firebase.database.p.f0.e
    public <T> T i(Callable<T> callable) {
        this.f2148a.f();
        try {
            T call = callable.call();
            this.f2148a.r();
            return call;
        } finally {
        }
    }

    @Override // com.google.firebase.database.p.f0.e
    public void j(com.google.firebase.database.p.h0.i iVar, n nVar) {
        if (iVar.g()) {
            this.f2148a.m(iVar.e(), nVar);
        } else {
            this.f2148a.j(iVar.e(), nVar);
        }
        f(iVar);
        p();
    }

    @Override // com.google.firebase.database.p.f0.e
    public void k(l lVar, n nVar) {
        if (this.f2149b.l(lVar)) {
            return;
        }
        this.f2148a.m(lVar, nVar);
        this.f2149b.g(lVar);
    }

    @Override // com.google.firebase.database.p.f0.e
    public void l(com.google.firebase.database.p.h0.i iVar) {
        this.f2149b.u(iVar);
    }

    @Override // com.google.firebase.database.p.f0.e
    public void m(l lVar, com.google.firebase.database.p.b bVar) {
        Iterator<Map.Entry<l, n>> it = bVar.iterator();
        while (it.hasNext()) {
            Map.Entry<l, n> next = it.next();
            k(lVar.i(next.getKey()), next.getValue());
        }
    }

    @Override // com.google.firebase.database.p.f0.e
    public void n(l lVar, com.google.firebase.database.p.b bVar) {
        this.f2148a.o(lVar, bVar);
        p();
    }

    @Override // com.google.firebase.database.p.f0.e
    public com.google.firebase.database.p.h0.a o(com.google.firebase.database.p.h0.i iVar) {
        Set<com.google.firebase.database.r.b> j;
        boolean z;
        if (this.f2149b.n(iVar)) {
            h i = this.f2149b.i(iVar);
            j = (iVar.g() || i == null || !i.f2162d) ? null : this.f2148a.h(i.f2159a);
            z = true;
        } else {
            j = this.f2149b.j(iVar.e());
            z = false;
        }
        n q = this.f2148a.q(iVar.e());
        if (j != null) {
            n s = com.google.firebase.database.r.g.s();
            for (com.google.firebase.database.r.b bVar : j) {
                s = s.p(bVar, q.b(bVar));
            }
            return new com.google.firebase.database.p.h0.a(com.google.firebase.database.r.i.f(s, iVar.c()), z, true);
        }
        return new com.google.firebase.database.p.h0.a(com.google.firebase.database.r.i.f(q, iVar.c()), z, false);
    }
}
