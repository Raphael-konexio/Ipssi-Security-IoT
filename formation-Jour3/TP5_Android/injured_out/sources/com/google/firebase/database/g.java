package com.google.firebase.database;

import com.google.firebase.database.p.o;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final Map<o, f> f2011a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b.c.c.c f2012b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.database.p.a f2013c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b.c.c.c cVar, com.google.firebase.auth.internal.b bVar) {
        this.f2012b = cVar;
        this.f2013c = bVar != null ? com.google.firebase.database.m.e.d(bVar) : com.google.firebase.database.m.e.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized f a(o oVar) {
        f fVar;
        fVar = this.f2011a.get(oVar);
        if (fVar == null) {
            com.google.firebase.database.p.h hVar = new com.google.firebase.database.p.h();
            if (!this.f2012b.t()) {
                hVar.H(this.f2012b.m());
            }
            hVar.G(this.f2012b);
            hVar.F(this.f2013c);
            f fVar2 = new f(this.f2012b, oVar, hVar);
            this.f2011a.put(oVar, fVar2);
            fVar = fVar2;
        }
        return fVar;
    }
}
