package com.google.firebase.database.p.h0;

import com.google.firebase.database.p.c0;
import com.google.firebase.database.p.e0.d;
import com.google.firebase.database.p.h0.l;
import com.google.firebase.database.r.m;
import com.google.firebase.database.r.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final i f2220a;

    /* renamed from: b  reason: collision with root package name */
    private final l f2221b;

    /* renamed from: c  reason: collision with root package name */
    private k f2222c;

    /* renamed from: d  reason: collision with root package name */
    private final List<com.google.firebase.database.p.i> f2223d;
    private final f e;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<d> f2224a;

        /* renamed from: b  reason: collision with root package name */
        public final List<c> f2225b;

        public a(List<d> list, List<c> list2) {
            this.f2224a = list;
            this.f2225b = list2;
        }
    }

    public j(i iVar, k kVar) {
        this.f2220a = iVar;
        com.google.firebase.database.p.h0.m.b bVar = new com.google.firebase.database.p.h0.m.b(iVar.c());
        com.google.firebase.database.p.h0.m.d h = iVar.d().h();
        this.f2221b = new l(h);
        com.google.firebase.database.p.h0.a d2 = kVar.d();
        com.google.firebase.database.p.h0.a c2 = kVar.c();
        com.google.firebase.database.r.i f = com.google.firebase.database.r.i.f(com.google.firebase.database.r.g.s(), iVar.c());
        com.google.firebase.database.r.i a2 = d2.a();
        bVar.f(f, a2, null);
        com.google.firebase.database.r.i f2 = h.f(f, c2.a(), null);
        this.f2222c = new k(new com.google.firebase.database.p.h0.a(f2, c2.f(), h.c()), new com.google.firebase.database.p.h0.a(a2, d2.f(), bVar.c()));
        this.f2223d = new ArrayList();
        this.e = new f(iVar);
    }

    private List<d> c(List<c> list, com.google.firebase.database.r.i iVar, com.google.firebase.database.p.i iVar2) {
        return this.e.d(list, iVar, iVar2 == null ? this.f2223d : Arrays.asList(iVar2));
    }

    public void a(com.google.firebase.database.p.i iVar) {
        this.f2223d.add(iVar);
    }

    public a b(com.google.firebase.database.p.e0.d dVar, c0 c0Var, n nVar) {
        if (dVar.c() == d.a.Merge) {
            dVar.b().b();
        }
        l.c b2 = this.f2221b.b(this.f2222c, dVar, c0Var, nVar);
        k kVar = b2.f2231a;
        this.f2222c = kVar;
        return new a(c(b2.f2232b, kVar.c().a(), null), b2.f2232b);
    }

    public n d(com.google.firebase.database.p.l lVar) {
        n b2 = this.f2222c.b();
        if (b2 != null) {
            if (this.f2220a.g() || !(lVar.isEmpty() || b2.b(lVar.x()).isEmpty())) {
                return b2.h(lVar);
            }
            return null;
        }
        return null;
    }

    public n e() {
        return this.f2222c.c().b();
    }

    public List<d> f(com.google.firebase.database.p.i iVar) {
        com.google.firebase.database.p.h0.a c2 = this.f2222c.c();
        ArrayList arrayList = new ArrayList();
        for (m mVar : c2.b()) {
            arrayList.add(c.c(mVar.c(), mVar.d()));
        }
        if (c2.f()) {
            arrayList.add(c.m(c2.a()));
        }
        return c(arrayList, c2.a(), iVar);
    }

    public i g() {
        return this.f2220a;
    }

    public n h() {
        return this.f2222c.d().b();
    }

    public boolean i() {
        return this.f2223d.isEmpty();
    }

    public List<e> j(com.google.firebase.database.p.i iVar, com.google.firebase.database.b bVar) {
        List<e> emptyList;
        if (bVar != null) {
            emptyList = new ArrayList<>();
            com.google.firebase.database.p.l e = this.f2220a.e();
            for (com.google.firebase.database.p.i iVar2 : this.f2223d) {
                emptyList.add(new b(iVar2, bVar, e));
            }
        } else {
            emptyList = Collections.emptyList();
        }
        if (iVar != null) {
            int i = 0;
            int i2 = -1;
            while (true) {
                if (i >= this.f2223d.size()) {
                    i = i2;
                    break;
                }
                com.google.firebase.database.p.i iVar3 = this.f2223d.get(i);
                if (iVar3.f(iVar)) {
                    if (iVar3.g()) {
                        break;
                    }
                    i2 = i;
                }
                i++;
            }
            if (i != -1) {
                this.f2223d.remove(i);
                this.f2223d.get(i).k();
            }
        } else {
            for (com.google.firebase.database.p.i iVar4 : this.f2223d) {
                iVar4.k();
            }
            this.f2223d.clear();
        }
        return emptyList;
    }
}
