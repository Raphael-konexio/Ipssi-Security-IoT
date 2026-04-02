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
public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private final b f2242a;

    /* renamed from: b  reason: collision with root package name */
    private final h f2243b;

    /* renamed from: c  reason: collision with root package name */
    private final m f2244c;

    /* renamed from: d  reason: collision with root package name */
    private final m f2245d;

    public e(com.google.firebase.database.p.h0.h hVar) {
        this.f2242a = new b(hVar.b());
        this.f2243b = hVar.b();
        this.f2244c = j(hVar);
        this.f2245d = h(hVar);
    }

    private static m h(com.google.firebase.database.p.h0.h hVar) {
        if (hVar.j()) {
            return hVar.b().f(hVar.c(), hVar.d());
        }
        return hVar.b().g();
    }

    private static m j(com.google.firebase.database.p.h0.h hVar) {
        if (hVar.l()) {
            return hVar.b().f(hVar.e(), hVar.f());
        }
        return hVar.b().h();
    }

    @Override // com.google.firebase.database.p.h0.m.d
    public d a() {
        return this.f2242a;
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
        return this.f2243b;
    }

    @Override // com.google.firebase.database.p.h0.m.d
    public i e(i iVar, com.google.firebase.database.r.b bVar, n nVar, l lVar, d.a aVar, a aVar2) {
        if (!k(new m(bVar, nVar))) {
            nVar = g.s();
        }
        return this.f2242a.e(iVar, bVar, nVar, lVar, aVar, aVar2);
    }

    @Override // com.google.firebase.database.p.h0.m.d
    public i f(i iVar, i iVar2, a aVar) {
        i iVar3;
        if (iVar2.l().k()) {
            iVar3 = i.f(g.s(), this.f2243b);
        } else {
            i u = iVar2.u(r.a());
            Iterator<m> it = iVar2.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (!k(next)) {
                    u = u.s(next.c(), g.s());
                }
            }
            iVar3 = u;
        }
        this.f2242a.f(iVar, iVar3, aVar);
        return iVar3;
    }

    public m g() {
        return this.f2245d;
    }

    public m i() {
        return this.f2244c;
    }

    public boolean k(m mVar) {
        return this.f2243b.compare(i(), mVar) <= 0 && this.f2243b.compare(mVar, g()) <= 0;
    }
}
