package com.google.firebase.database.p.h0.m;

import com.google.firebase.database.p.h0.m.d;
import com.google.firebase.database.p.l;
import com.google.firebase.database.r.h;
import com.google.firebase.database.r.i;
import com.google.firebase.database.r.m;
import com.google.firebase.database.r.n;
/* loaded from: classes.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private final h f2237a;

    public b(h hVar) {
        this.f2237a = hVar;
    }

    @Override // com.google.firebase.database.p.h0.m.d
    public d a() {
        return this;
    }

    @Override // com.google.firebase.database.p.h0.m.d
    public i b(i iVar, n nVar) {
        return iVar.l().isEmpty() ? iVar : iVar.u(nVar);
    }

    @Override // com.google.firebase.database.p.h0.m.d
    public boolean c() {
        return false;
    }

    @Override // com.google.firebase.database.p.h0.m.d
    public h d() {
        return this.f2237a;
    }

    @Override // com.google.firebase.database.p.h0.m.d
    public i e(i iVar, com.google.firebase.database.r.b bVar, n nVar, l lVar, d.a aVar, a aVar2) {
        com.google.firebase.database.p.h0.c c2;
        n l = iVar.l();
        n b2 = l.b(bVar);
        if (b2.h(lVar).equals(nVar.h(lVar)) && b2.isEmpty() == nVar.isEmpty()) {
            return iVar;
        }
        if (aVar2 != null) {
            if (!nVar.isEmpty()) {
                c2 = b2.isEmpty() ? com.google.firebase.database.p.h0.c.c(bVar, nVar) : com.google.firebase.database.p.h0.c.e(bVar, nVar, b2);
            } else if (l.o(bVar)) {
                c2 = com.google.firebase.database.p.h0.c.h(bVar, b2);
            }
            aVar2.b(c2);
        }
        return (l.k() && nVar.isEmpty()) ? iVar : iVar.s(bVar, nVar);
    }

    @Override // com.google.firebase.database.p.h0.m.d
    public i f(i iVar, i iVar2, a aVar) {
        com.google.firebase.database.p.h0.c c2;
        if (aVar != null) {
            for (m mVar : iVar.l()) {
                if (!iVar2.l().o(mVar.c())) {
                    aVar.b(com.google.firebase.database.p.h0.c.h(mVar.c(), mVar.d()));
                }
            }
            if (!iVar2.l().k()) {
                for (m mVar2 : iVar2.l()) {
                    if (iVar.l().o(mVar2.c())) {
                        n b2 = iVar.l().b(mVar2.c());
                        if (!b2.equals(mVar2.d())) {
                            c2 = com.google.firebase.database.p.h0.c.e(mVar2.c(), mVar2.d(), b2);
                        }
                    } else {
                        c2 = com.google.firebase.database.p.h0.c.c(mVar2.c(), mVar2.d());
                    }
                    aVar.b(c2);
                }
            }
        }
        return iVar2;
    }
}
