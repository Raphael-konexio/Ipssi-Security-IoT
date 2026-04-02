package com.google.firebase.database.p.h0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.firebase.database.p.k f2211a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.database.q.c f2212b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ ArrayList f;

        a(ArrayList arrayList) {
            this.f = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (g.this.f2212b.f()) {
                    com.google.firebase.database.q.c cVar = g.this.f2212b;
                    cVar.b("Raising " + eVar.toString(), new Object[0]);
                }
                eVar.a();
            }
        }
    }

    public g(com.google.firebase.database.p.g gVar) {
        this.f2211a = gVar.l();
        this.f2212b = gVar.n("EventRaiser");
    }

    public void b(List<? extends e> list) {
        if (this.f2212b.f()) {
            com.google.firebase.database.q.c cVar = this.f2212b;
            cVar.b("Raising " + list.size() + " event(s)", new Object[0]);
        }
        this.f2211a.b(new a(new ArrayList(list)));
    }
}
