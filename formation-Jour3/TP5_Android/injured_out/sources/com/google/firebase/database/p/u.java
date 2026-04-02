package com.google.firebase.database.p;

import com.google.firebase.database.p.h0.e;
import com.google.firebase.database.p.h0.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private final Map<com.google.firebase.database.p.h0.h, com.google.firebase.database.p.h0.j> f2288a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.database.p.f0.e f2289b;

    public u(com.google.firebase.database.p.f0.e eVar) {
        this.f2289b = eVar;
    }

    private List<com.google.firebase.database.p.h0.d> c(com.google.firebase.database.p.h0.j jVar, com.google.firebase.database.p.e0.d dVar, c0 c0Var, com.google.firebase.database.r.n nVar) {
        j.a b2 = jVar.b(dVar, c0Var, nVar);
        if (!jVar.g().g()) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (com.google.firebase.database.p.h0.c cVar : b2.f2225b) {
                e.a j = cVar.j();
                if (j == e.a.CHILD_ADDED) {
                    hashSet2.add(cVar.i());
                } else if (j == e.a.CHILD_REMOVED) {
                    hashSet.add(cVar.i());
                }
            }
            if (!hashSet2.isEmpty() || !hashSet.isEmpty()) {
                this.f2289b.g(jVar.g(), hashSet2, hashSet);
            }
        }
        return b2.f2224a;
    }

    public List<com.google.firebase.database.p.h0.d> a(i iVar, c0 c0Var, com.google.firebase.database.p.h0.a aVar) {
        boolean z;
        com.google.firebase.database.p.h0.i e = iVar.e();
        com.google.firebase.database.p.h0.j jVar = this.f2288a.get(e.d());
        if (jVar == null) {
            com.google.firebase.database.r.n b2 = c0Var.b(aVar.f() ? aVar.b() : null);
            if (b2 != null) {
                z = true;
            } else {
                b2 = c0Var.e(aVar.b());
                z = false;
            }
            jVar = new com.google.firebase.database.p.h0.j(e, new com.google.firebase.database.p.h0.k(new com.google.firebase.database.p.h0.a(com.google.firebase.database.r.i.f(b2, e.c()), z, false), aVar));
            if (!e.g()) {
                HashSet hashSet = new HashSet();
                for (com.google.firebase.database.r.m mVar : jVar.e()) {
                    hashSet.add(mVar.c());
                }
                this.f2289b.h(e, hashSet);
            }
            this.f2288a.put(e.d(), jVar);
        }
        jVar.a(iVar);
        return jVar.f(iVar);
    }

    public List<com.google.firebase.database.p.h0.d> b(com.google.firebase.database.p.e0.d dVar, c0 c0Var, com.google.firebase.database.r.n nVar) {
        com.google.firebase.database.p.h0.h b2 = dVar.b().b();
        if (b2 != null) {
            return c(this.f2288a.get(b2), dVar, c0Var, nVar);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<com.google.firebase.database.p.h0.h, com.google.firebase.database.p.h0.j> entry : this.f2288a.entrySet()) {
            arrayList.addAll(c(entry.getValue(), dVar, c0Var, nVar));
        }
        return arrayList;
    }

    public com.google.firebase.database.r.n d(l lVar) {
        for (com.google.firebase.database.p.h0.j jVar : this.f2288a.values()) {
            if (jVar.d(lVar) != null) {
                return jVar.d(lVar);
            }
        }
        return null;
    }

    public com.google.firebase.database.p.h0.j e() {
        for (Map.Entry<com.google.firebase.database.p.h0.h, com.google.firebase.database.p.h0.j> entry : this.f2288a.entrySet()) {
            com.google.firebase.database.p.h0.j value = entry.getValue();
            if (value.g().g()) {
                return value;
            }
        }
        return null;
    }

    public List<com.google.firebase.database.p.h0.j> f() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<com.google.firebase.database.p.h0.h, com.google.firebase.database.p.h0.j> entry : this.f2288a.entrySet()) {
            com.google.firebase.database.p.h0.j value = entry.getValue();
            if (!value.g().g()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public boolean g() {
        return e() != null;
    }

    public boolean h() {
        return this.f2288a.isEmpty();
    }

    public com.google.firebase.database.p.g0.g<List<com.google.firebase.database.p.h0.i>, List<com.google.firebase.database.p.h0.e>> i(com.google.firebase.database.p.h0.i iVar, i iVar2, com.google.firebase.database.b bVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean g = g();
        if (iVar.f()) {
            Iterator<Map.Entry<com.google.firebase.database.p.h0.h, com.google.firebase.database.p.h0.j>> it = this.f2288a.entrySet().iterator();
            while (it.hasNext()) {
                com.google.firebase.database.p.h0.j value = it.next().getValue();
                arrayList2.addAll(value.j(iVar2, bVar));
                if (value.i()) {
                    it.remove();
                    if (!value.g().g()) {
                        arrayList.add(value.g());
                    }
                }
            }
        } else {
            com.google.firebase.database.p.h0.j jVar = this.f2288a.get(iVar.d());
            if (jVar != null) {
                arrayList2.addAll(jVar.j(iVar2, bVar));
                if (jVar.i()) {
                    this.f2288a.remove(iVar.d());
                    if (!jVar.g().g()) {
                        arrayList.add(jVar.g());
                    }
                }
            }
        }
        if (g && !g()) {
            arrayList.add(com.google.firebase.database.p.h0.i.a(iVar.e()));
        }
        return new com.google.firebase.database.p.g0.g<>(arrayList, arrayList2);
    }

    public boolean j(com.google.firebase.database.p.h0.i iVar) {
        return k(iVar) != null;
    }

    public com.google.firebase.database.p.h0.j k(com.google.firebase.database.p.h0.i iVar) {
        return iVar.g() ? e() : this.f2288a.get(iVar.d());
    }
}
