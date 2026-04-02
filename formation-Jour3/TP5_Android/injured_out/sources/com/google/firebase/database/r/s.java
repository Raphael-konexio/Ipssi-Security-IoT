package com.google.firebase.database.r;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.firebase.database.p.l f2369a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.database.p.l f2370b;

    /* renamed from: c  reason: collision with root package name */
    private final n f2371c;

    public s(com.google.firebase.database.o.j jVar) {
        List<String> a2 = jVar.a();
        this.f2369a = a2 != null ? new com.google.firebase.database.p.l(a2) : null;
        List<String> b2 = jVar.b();
        this.f2370b = b2 != null ? new com.google.firebase.database.p.l(b2) : null;
        this.f2371c = o.a(jVar.c());
    }

    private n b(com.google.firebase.database.p.l lVar, n nVar, n nVar2) {
        com.google.firebase.database.p.l lVar2 = this.f2369a;
        int compareTo = lVar2 == null ? 1 : lVar.compareTo(lVar2);
        com.google.firebase.database.p.l lVar3 = this.f2370b;
        int compareTo2 = lVar3 == null ? -1 : lVar.compareTo(lVar3);
        com.google.firebase.database.p.l lVar4 = this.f2369a;
        boolean z = false;
        boolean z2 = lVar4 != null && lVar.s(lVar4);
        com.google.firebase.database.p.l lVar5 = this.f2370b;
        if (lVar5 != null && lVar.s(lVar5)) {
            z = true;
        }
        if (compareTo <= 0 || compareTo2 >= 0 || z) {
            if (compareTo > 0 && z && nVar2.k()) {
                return nVar2;
            }
            if (compareTo > 0 && compareTo2 == 0) {
                return nVar.k() ? g.s() : nVar;
            } else if (z2 || z) {
                HashSet hashSet = new HashSet();
                Iterator<m> it = nVar.iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next().c());
                }
                Iterator<m> it2 = nVar2.iterator();
                while (it2.hasNext()) {
                    hashSet.add(it2.next().c());
                }
                ArrayList<b> arrayList = new ArrayList(hashSet.size() + 1);
                arrayList.addAll(hashSet);
                if (!nVar2.c().isEmpty() || !nVar.c().isEmpty()) {
                    arrayList.add(b.m());
                }
                n nVar3 = nVar;
                for (b bVar : arrayList) {
                    n b2 = nVar.b(bVar);
                    n b3 = b(lVar.l(bVar), nVar.b(bVar), nVar2.b(bVar));
                    if (b3 != b2) {
                        nVar3 = nVar3.p(bVar, b3);
                    }
                }
                return nVar3;
            } else {
                return nVar;
            }
        }
        return nVar2;
    }

    public n a(n nVar) {
        return b(com.google.firebase.database.p.l.w(), nVar, this.f2371c);
    }

    public String toString() {
        return "RangeMerge{optExclusiveStart=" + this.f2369a + ", optInclusiveEnd=" + this.f2370b + ", snap=" + this.f2371c + '}';
    }
}
