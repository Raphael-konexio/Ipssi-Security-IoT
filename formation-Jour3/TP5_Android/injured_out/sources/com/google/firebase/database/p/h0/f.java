package com.google.firebase.database.p.h0;

import com.google.firebase.database.p.h0.e;
import com.google.firebase.database.r.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final i f2209a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.database.r.h f2210b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            return f.this.f2210b.compare(new m(cVar.i(), cVar.k().l()), new m(cVar2.i(), cVar2.k().l()));
        }
    }

    public f(i iVar) {
        this.f2209a = iVar;
        this.f2210b = iVar.c();
    }

    private Comparator<c> b() {
        return new a();
    }

    private d c(c cVar, com.google.firebase.database.p.i iVar, com.google.firebase.database.r.i iVar2) {
        if (!cVar.j().equals(e.a.VALUE) && !cVar.j().equals(e.a.CHILD_REMOVED)) {
            cVar = cVar.a(iVar2.m(cVar.i(), cVar.k().l(), this.f2210b));
        }
        return iVar.b(cVar, this.f2209a);
    }

    private void e(List<d> list, e.a aVar, List<c> list2, List<com.google.firebase.database.p.i> list3, com.google.firebase.database.r.i iVar) {
        ArrayList<c> arrayList = new ArrayList();
        for (c cVar : list2) {
            if (cVar.j().equals(aVar)) {
                arrayList.add(cVar);
            }
        }
        Collections.sort(arrayList, b());
        for (c cVar2 : arrayList) {
            for (com.google.firebase.database.p.i iVar2 : list3) {
                if (iVar2.h(aVar)) {
                    list.add(c(cVar2, iVar2, iVar));
                }
            }
        }
    }

    public List<d> d(List<c> list, com.google.firebase.database.r.i iVar, List<com.google.firebase.database.p.i> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (c cVar : list) {
            if (cVar.j().equals(e.a.CHILD_CHANGED) && this.f2210b.d(cVar.l().l(), cVar.k().l())) {
                arrayList2.add(c.f(cVar.i(), cVar.k()));
            }
        }
        e(arrayList, e.a.CHILD_REMOVED, list, list2, iVar);
        e(arrayList, e.a.CHILD_ADDED, list, list2, iVar);
        e(arrayList, e.a.CHILD_MOVED, arrayList2, list2, iVar);
        e(arrayList, e.a.CHILD_CHANGED, list, list2, iVar);
        e(arrayList, e.a.VALUE, list, list2, iVar);
        return arrayList;
    }
}
