package com.google.firebase.database.p.h0.m;

import com.google.firebase.database.p.h0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<com.google.firebase.database.r.b, com.google.firebase.database.p.h0.c> f2236a = new HashMap();

    public List<com.google.firebase.database.p.h0.c> a() {
        return new ArrayList(this.f2236a.values());
    }

    public void b(com.google.firebase.database.p.h0.c cVar) {
        Map<com.google.firebase.database.r.b, com.google.firebase.database.p.h0.c> map;
        e.a j = cVar.j();
        com.google.firebase.database.r.b i = cVar.i();
        if (this.f2236a.containsKey(i)) {
            com.google.firebase.database.p.h0.c cVar2 = this.f2236a.get(i);
            e.a j2 = cVar2.j();
            if (j == e.a.CHILD_ADDED && j2 == e.a.CHILD_REMOVED) {
                this.f2236a.put(cVar.i(), com.google.firebase.database.p.h0.c.d(i, cVar.k(), cVar2.k()));
                return;
            } else if (j == e.a.CHILD_REMOVED && j2 == e.a.CHILD_ADDED) {
                this.f2236a.remove(i);
                return;
            } else if (j == e.a.CHILD_REMOVED && j2 == e.a.CHILD_CHANGED) {
                this.f2236a.put(i, com.google.firebase.database.p.h0.c.g(i, cVar2.l()));
                return;
            } else if (j == e.a.CHILD_CHANGED && j2 == e.a.CHILD_ADDED) {
                map = this.f2236a;
                cVar = com.google.firebase.database.p.h0.c.b(i, cVar.k());
            } else {
                e.a aVar = e.a.CHILD_CHANGED;
                if (j != aVar || j2 != aVar) {
                    throw new IllegalStateException("Illegal combination of changes: " + cVar + " occurred after " + cVar2);
                }
                map = this.f2236a;
                cVar = com.google.firebase.database.p.h0.c.d(i, cVar.k(), cVar2.l());
            }
        } else {
            map = this.f2236a;
            i = cVar.i();
        }
        map.put(i, cVar);
    }
}
