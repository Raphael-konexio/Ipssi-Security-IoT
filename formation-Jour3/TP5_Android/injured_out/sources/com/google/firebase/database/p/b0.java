package com.google.firebase.database.p;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b0 {

    /* renamed from: d  reason: collision with root package name */
    private static final com.google.firebase.database.p.g0.i<y> f2121d = new b();

    /* renamed from: a  reason: collision with root package name */
    private com.google.firebase.database.p.b f2122a = com.google.firebase.database.p.b.s();

    /* renamed from: b  reason: collision with root package name */
    private List<y> f2123b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private Long f2124c = -1L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements com.google.firebase.database.p.g0.i<y> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f2125b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f2126c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ l f2127d;

        a(b0 b0Var, boolean z, List list, l lVar) {
            this.f2125b = z;
            this.f2126c = list;
            this.f2127d = lVar;
        }

        @Override // com.google.firebase.database.p.g0.i
        /* renamed from: b */
        public boolean a(y yVar) {
            return (yVar.f() || this.f2125b) && !this.f2126c.contains(Long.valueOf(yVar.d())) && (yVar.c().s(this.f2127d) || this.f2127d.s(yVar.c()));
        }
    }

    /* loaded from: classes.dex */
    class b implements com.google.firebase.database.p.g0.i<y> {
        b() {
        }

        @Override // com.google.firebase.database.p.g0.i
        /* renamed from: b */
        public boolean a(y yVar) {
            return yVar.f();
        }
    }

    private static com.google.firebase.database.p.b j(List<y> list, com.google.firebase.database.p.g0.i<y> iVar, l lVar) {
        l z;
        com.google.firebase.database.r.n b2;
        l z2;
        com.google.firebase.database.p.b s = com.google.firebase.database.p.b.s();
        for (y yVar : list) {
            if (iVar.a(yVar)) {
                l c2 = yVar.c();
                if (!yVar.e()) {
                    if (lVar.s(c2)) {
                        z2 = l.z(lVar, c2);
                    } else if (c2.s(lVar)) {
                        l z3 = l.z(c2, lVar);
                        if (z3.isEmpty()) {
                            z2 = l.w();
                        } else {
                            b2 = yVar.a().y(z3);
                            if (b2 != null) {
                                z = l.w();
                                s = s.d(z, b2);
                            }
                        }
                    }
                    s = s.f(z2, yVar.a());
                } else if (lVar.s(c2)) {
                    z = l.z(lVar, c2);
                    b2 = yVar.b();
                    s = s.d(z, b2);
                } else if (c2.s(lVar)) {
                    s = s.d(l.w(), yVar.b().h(l.z(c2, lVar)));
                }
            }
        }
        return s;
    }

    private boolean k(y yVar, l lVar) {
        if (yVar.e()) {
            return yVar.c().s(lVar);
        }
        Iterator<Map.Entry<l, com.google.firebase.database.r.n>> it = yVar.a().iterator();
        while (it.hasNext()) {
            if (yVar.c().i(it.next().getKey()).s(lVar)) {
                return true;
            }
        }
        return false;
    }

    private void m() {
        long j;
        this.f2122a = j(this.f2123b, f2121d, l.w());
        if (this.f2123b.size() > 0) {
            List<y> list = this.f2123b;
            j = list.get(list.size() - 1).d();
        } else {
            j = -1;
        }
        this.f2124c = Long.valueOf(j);
    }

    public void a(l lVar, com.google.firebase.database.p.b bVar, Long l) {
        this.f2123b.add(new y(l.longValue(), lVar, bVar));
        this.f2122a = this.f2122a.f(lVar, bVar);
        this.f2124c = l;
    }

    public void b(l lVar, com.google.firebase.database.r.n nVar, Long l, boolean z) {
        this.f2123b.add(new y(l.longValue(), lVar, nVar, z));
        if (z) {
            this.f2122a = this.f2122a.d(lVar, nVar);
        }
        this.f2124c = l;
    }

    public com.google.firebase.database.r.n c(l lVar, com.google.firebase.database.r.b bVar, com.google.firebase.database.p.h0.a aVar) {
        l l = lVar.l(bVar);
        com.google.firebase.database.r.n y = this.f2122a.y(l);
        if (y != null) {
            return y;
        }
        if (aVar.c(bVar)) {
            return this.f2122a.l(l).g(aVar.b().b(bVar));
        }
        return null;
    }

    public com.google.firebase.database.r.n d(l lVar, com.google.firebase.database.r.n nVar, List<Long> list, boolean z) {
        if (list.isEmpty() && !z) {
            com.google.firebase.database.r.n y = this.f2122a.y(lVar);
            if (y != null) {
                return y;
            }
            com.google.firebase.database.p.b l = this.f2122a.l(lVar);
            if (l.isEmpty()) {
                return nVar;
            }
            if (nVar != null || l.A(l.w())) {
                if (nVar == null) {
                    nVar = com.google.firebase.database.r.g.s();
                }
                return l.g(nVar);
            }
            return null;
        }
        com.google.firebase.database.p.b l2 = this.f2122a.l(lVar);
        if (z || !l2.isEmpty()) {
            if (z || nVar != null || l2.A(l.w())) {
                com.google.firebase.database.p.b j = j(this.f2123b, new a(this, z, list, lVar), lVar);
                if (nVar == null) {
                    nVar = com.google.firebase.database.r.g.s();
                }
                return j.g(nVar);
            }
            return null;
        }
        return nVar;
    }

    public com.google.firebase.database.r.n e(l lVar, com.google.firebase.database.r.n nVar) {
        com.google.firebase.database.r.n s = com.google.firebase.database.r.g.s();
        com.google.firebase.database.r.n y = this.f2122a.y(lVar);
        if (y != null) {
            if (!y.k()) {
                for (com.google.firebase.database.r.m mVar : y) {
                    s = s.p(mVar.c(), mVar.d());
                }
            }
            return s;
        }
        com.google.firebase.database.p.b l = this.f2122a.l(lVar);
        for (com.google.firebase.database.r.m mVar2 : nVar) {
            s = s.p(mVar2.c(), l.l(new l(mVar2.c())).g(mVar2.d()));
        }
        for (com.google.firebase.database.r.m mVar3 : l.x()) {
            s = s.p(mVar3.c(), mVar3.d());
        }
        return s;
    }

    public com.google.firebase.database.r.n f(l lVar, l lVar2, com.google.firebase.database.r.n nVar, com.google.firebase.database.r.n nVar2) {
        l i = lVar.i(lVar2);
        if (this.f2122a.A(i)) {
            return null;
        }
        com.google.firebase.database.p.b l = this.f2122a.l(i);
        return l.isEmpty() ? nVar2.h(lVar2) : l.g(nVar2.h(lVar2));
    }

    public com.google.firebase.database.r.m g(l lVar, com.google.firebase.database.r.n nVar, com.google.firebase.database.r.m mVar, boolean z, com.google.firebase.database.r.h hVar) {
        com.google.firebase.database.p.b l = this.f2122a.l(lVar);
        com.google.firebase.database.r.n y = l.y(l.w());
        com.google.firebase.database.r.m mVar2 = null;
        if (y == null) {
            if (nVar != null) {
                y = l.g(nVar);
            }
            return mVar2;
        }
        for (com.google.firebase.database.r.m mVar3 : y) {
            if (hVar.a(mVar3, mVar, z) > 0 && (mVar2 == null || hVar.a(mVar3, mVar2, z) < 0)) {
                mVar2 = mVar3;
            }
        }
        return mVar2;
    }

    public c0 h(l lVar) {
        return new c0(lVar, this);
    }

    public y i(long j) {
        for (y yVar : this.f2123b) {
            if (yVar.d() == j) {
                return yVar;
            }
        }
        return null;
    }

    public boolean l(long j) {
        y yVar;
        Iterator<y> it = this.f2123b.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                yVar = null;
                break;
            }
            yVar = it.next();
            if (yVar.d() == j) {
                break;
            }
            i++;
        }
        this.f2123b.remove(yVar);
        boolean f = yVar.f();
        boolean z = false;
        for (int size = this.f2123b.size() - 1; f && size >= 0; size--) {
            y yVar2 = this.f2123b.get(size);
            if (yVar2.f()) {
                if (size >= i && k(yVar2, yVar.c())) {
                    f = false;
                } else if (yVar.c().s(yVar2.c())) {
                    z = true;
                }
            }
        }
        if (f) {
            if (z) {
                m();
                return true;
            }
            if (yVar.e()) {
                this.f2122a = this.f2122a.B(yVar.c());
            } else {
                Iterator<Map.Entry<l, com.google.firebase.database.r.n>> it2 = yVar.a().iterator();
                while (it2.hasNext()) {
                    this.f2122a = this.f2122a.B(yVar.c().i(it2.next().getKey()));
                }
            }
            return true;
        }
        return false;
    }

    public com.google.firebase.database.r.n n(l lVar) {
        return this.f2122a.y(lVar);
    }
}
