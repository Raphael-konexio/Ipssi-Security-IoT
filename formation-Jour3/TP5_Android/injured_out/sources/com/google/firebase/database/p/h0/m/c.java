package com.google.firebase.database.p.h0.m;

import com.google.firebase.database.p.h0.m.d;
import com.google.firebase.database.p.l;
import com.google.firebase.database.r.g;
import com.google.firebase.database.r.h;
import com.google.firebase.database.r.i;
import com.google.firebase.database.r.m;
import com.google.firebase.database.r.n;
import com.google.firebase.database.r.r;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private final e f2238a;

    /* renamed from: b  reason: collision with root package name */
    private final h f2239b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2240c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2241d;

    public c(com.google.firebase.database.p.h0.h hVar) {
        this.f2238a = new e(hVar);
        this.f2239b = hVar.b();
        this.f2240c = hVar.g();
        this.f2241d = !hVar.n();
    }

    private i g(i iVar, com.google.firebase.database.r.b bVar, n nVar, d.a aVar, a aVar2) {
        i s;
        com.google.firebase.database.r.b c2;
        n s2;
        m mVar = new m(bVar, nVar);
        m g = this.f2241d ? iVar.g() : iVar.i();
        boolean k = this.f2238a.k(mVar);
        if (iVar.l().o(bVar)) {
            n b2 = iVar.l().b(bVar);
            while (true) {
                g = aVar.a(this.f2239b, g, this.f2241d);
                if (g == null || (!g.c().equals(bVar) && !iVar.l().o(g.c()))) {
                    break;
                }
            }
            boolean z = true;
            if (k && !nVar.isEmpty() && (g == null ? 1 : this.f2239b.a(g, mVar, this.f2241d)) >= 0) {
                if (aVar2 != null) {
                    aVar2.b(com.google.firebase.database.p.h0.c.e(bVar, nVar, b2));
                }
                return iVar.s(bVar, nVar);
            }
            if (aVar2 != null) {
                aVar2.b(com.google.firebase.database.p.h0.c.h(bVar, b2));
            }
            s = iVar.s(bVar, g.s());
            if (!((g == null || !this.f2238a.k(g)) ? false : false)) {
                return s;
            }
            if (aVar2 != null) {
                aVar2.b(com.google.firebase.database.p.h0.c.c(g.c(), g.d()));
            }
            c2 = g.c();
            s2 = g.d();
        } else if (nVar.isEmpty() || !k || this.f2239b.a(g, mVar, this.f2241d) < 0) {
            return iVar;
        } else {
            if (aVar2 != null) {
                aVar2.b(com.google.firebase.database.p.h0.c.h(g.c(), g.d()));
                aVar2.b(com.google.firebase.database.p.h0.c.c(bVar, nVar));
            }
            s = iVar.s(bVar, nVar);
            c2 = g.c();
            s2 = g.s();
        }
        return s.s(c2, s2);
    }

    @Override // com.google.firebase.database.p.h0.m.d
    public d a() {
        return this.f2238a.a();
    }

    @Override // com.google.firebase.database.p.h0.m.d
    public i b(i iVar, n nVar) {
        return iVar;
    }

    @Override // com.google.firebase.database.p.h0.m.d
    public boolean c() {
        return true;
    }

    @Override // com.google.firebase.database.p.h0.m.d
    public h d() {
        return this.f2239b;
    }

    @Override // com.google.firebase.database.p.h0.m.d
    public i e(i iVar, com.google.firebase.database.r.b bVar, n nVar, l lVar, d.a aVar, a aVar2) {
        if (!this.f2238a.k(new m(bVar, nVar))) {
            nVar = g.s();
        }
        n nVar2 = nVar;
        return iVar.l().b(bVar).equals(nVar2) ? iVar : iVar.l().a() < this.f2240c ? this.f2238a.a().e(iVar, bVar, nVar2, lVar, aVar, aVar2) : g(iVar, bVar, nVar2, aVar, aVar2);
    }

    @Override // com.google.firebase.database.p.h0.m.d
    public i f(i iVar, i iVar2, a aVar) {
        i f;
        Iterator<m> it;
        m i;
        m g;
        int i2;
        if (iVar2.l().k() || iVar2.l().isEmpty()) {
            f = i.f(g.s(), this.f2239b);
        } else {
            f = iVar2.u(r.a());
            if (this.f2241d) {
                it = iVar2.t();
                i = this.f2238a.g();
                g = this.f2238a.i();
                i2 = -1;
            } else {
                it = iVar2.iterator();
                i = this.f2238a.i();
                g = this.f2238a.g();
                i2 = 1;
            }
            boolean z = false;
            int i3 = 0;
            while (it.hasNext()) {
                m next = it.next();
                if (!z && this.f2239b.compare(i, next) * i2 <= 0) {
                    z = true;
                }
                if (z && i3 < this.f2240c && this.f2239b.compare(next, g) * i2 <= 0) {
                    i3++;
                } else {
                    f = f.s(next.c(), g.s());
                }
            }
        }
        return this.f2238a.a().f(iVar, f, aVar);
    }
}
