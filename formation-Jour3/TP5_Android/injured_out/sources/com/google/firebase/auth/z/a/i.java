package com.google.firebase.auth.z.a;

import android.content.Context;
import b.c.a.a.d.c.h2;
import b.c.a.a.d.c.m1;
import b.c.a.a.d.c.o1;
import b.c.a.a.d.c.u1;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public final class i extends b<v0> {

    /* renamed from: c  reason: collision with root package name */
    private final Context f1936c;

    /* renamed from: d  reason: collision with root package name */
    private final v0 f1937d;
    private final Future<a<v0>> e = c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, v0 v0Var) {
        this.f1936c = context;
        this.f1937d = v0Var;
    }

    private final <ResultT> b.c.a.a.f.g<ResultT> g(b.c.a.a.f.g<ResultT> gVar, e<n0, ResultT> eVar) {
        return (b.c.a.a.f.g<ResultT>) gVar.h(new h(this, eVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.firebase.auth.internal.d0 n(b.c.c.c cVar, m1 m1Var) {
        com.google.android.gms.common.internal.r.h(cVar);
        com.google.android.gms.common.internal.r.h(m1Var);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.google.firebase.auth.internal.z(m1Var, "firebase"));
        List<u1> r = m1Var.r();
        if (r != null && !r.isEmpty()) {
            for (int i = 0; i < r.size(); i++) {
                arrayList.add(new com.google.firebase.auth.internal.z(r.get(i)));
            }
        }
        com.google.firebase.auth.internal.d0 d0Var = new com.google.firebase.auth.internal.d0(cVar, arrayList);
        d0Var.C(new com.google.firebase.auth.internal.e0(m1Var.p(), m1Var.o()));
        d0Var.E(m1Var.q());
        d0Var.D(m1Var.t());
        d0Var.r(com.google.firebase.auth.internal.m.b(m1Var.v()));
        return d0Var;
    }

    @Override // com.google.firebase.auth.z.a.b
    final Future<a<v0>> c() {
        Future<a<v0>> future = this.e;
        if (future != null) {
            return future;
        }
        return o1.a().a(h2.f1256a).submit(new l0(this.f1937d, this.f1936c));
    }

    public final b.c.a.a.f.g<Object> h(b.c.c.c cVar, com.google.firebase.auth.b bVar, String str, com.google.firebase.auth.internal.c cVar2) {
        e0 e0Var = new e0(bVar, str);
        e0Var.e(cVar);
        e0Var.h(cVar2);
        e0 e0Var2 = e0Var;
        return g(e(e0Var2), e0Var2);
    }

    public final b.c.a.a.f.g<Object> i(b.c.c.c cVar, com.google.firebase.auth.c cVar2, com.google.firebase.auth.internal.c cVar3) {
        i0 i0Var = new i0(cVar2);
        i0Var.e(cVar);
        i0Var.h(cVar3);
        i0 i0Var2 = i0Var;
        return g(e(i0Var2), i0Var2);
    }

    public final b.c.a.a.f.g<Object> j(b.c.c.c cVar, com.google.firebase.auth.n nVar, com.google.firebase.auth.b bVar, com.google.firebase.auth.internal.u uVar) {
        com.google.android.gms.common.internal.r.h(cVar);
        com.google.android.gms.common.internal.r.h(bVar);
        com.google.android.gms.common.internal.r.h(nVar);
        com.google.android.gms.common.internal.r.h(uVar);
        List<String> o = nVar.o();
        if (o == null || !o.contains(bVar.b())) {
            if (bVar instanceof com.google.firebase.auth.c) {
                com.google.firebase.auth.c cVar2 = (com.google.firebase.auth.c) bVar;
                if (cVar2.p()) {
                    s sVar = new s(cVar2);
                    sVar.e(cVar);
                    sVar.f(nVar);
                    sVar.h(uVar);
                    sVar.g(uVar);
                    s sVar2 = sVar;
                    return g(e(sVar2), sVar2);
                }
                m mVar = new m(cVar2);
                mVar.e(cVar);
                mVar.f(nVar);
                mVar.h(uVar);
                mVar.g(uVar);
                m mVar2 = mVar;
                return g(e(mVar2), mVar2);
            } else if (bVar instanceof com.google.firebase.auth.t) {
                q qVar = new q((com.google.firebase.auth.t) bVar);
                qVar.e(cVar);
                qVar.f(nVar);
                qVar.h(uVar);
                qVar.g(uVar);
                q qVar2 = qVar;
                return g(e(qVar2), qVar2);
            } else {
                com.google.android.gms.common.internal.r.h(cVar);
                com.google.android.gms.common.internal.r.h(bVar);
                com.google.android.gms.common.internal.r.h(nVar);
                com.google.android.gms.common.internal.r.h(uVar);
                o oVar = new o(bVar);
                oVar.e(cVar);
                oVar.f(nVar);
                oVar.h(uVar);
                oVar.g(uVar);
                o oVar2 = oVar;
                return g(e(oVar2), oVar2);
            }
        }
        return b.c.a.a.f.j.a(o0.a(new Status(17015)));
    }

    public final b.c.a.a.f.g<com.google.firebase.auth.p> k(b.c.c.c cVar, com.google.firebase.auth.n nVar, String str, com.google.firebase.auth.internal.u uVar) {
        k kVar = new k(str);
        kVar.e(cVar);
        kVar.f(nVar);
        kVar.h(uVar);
        kVar.g(uVar);
        k kVar2 = kVar;
        return g(b(kVar2), kVar2);
    }

    public final b.c.a.a.f.g<Object> l(b.c.c.c cVar, com.google.firebase.auth.t tVar, String str, com.google.firebase.auth.internal.c cVar2) {
        k0 k0Var = new k0(tVar, str);
        k0Var.e(cVar);
        k0Var.h(cVar2);
        k0 k0Var2 = k0Var;
        return g(e(k0Var2), k0Var2);
    }

    public final b.c.a.a.f.g<Object> m(b.c.c.c cVar, com.google.firebase.auth.internal.c cVar2, String str) {
        c0 c0Var = new c0(str);
        c0Var.e(cVar);
        c0Var.h(cVar2);
        c0 c0Var2 = c0Var;
        return g(e(c0Var2), c0Var2);
    }

    public final b.c.a.a.f.g<Object> o(b.c.c.c cVar, com.google.firebase.auth.n nVar, com.google.firebase.auth.b bVar, String str, com.google.firebase.auth.internal.u uVar) {
        u uVar2 = new u(bVar, str);
        uVar2.e(cVar);
        uVar2.f(nVar);
        uVar2.h(uVar);
        uVar2.g(uVar);
        u uVar3 = uVar2;
        return g(e(uVar3), uVar3);
    }

    public final b.c.a.a.f.g<Object> p(b.c.c.c cVar, com.google.firebase.auth.n nVar, com.google.firebase.auth.c cVar2, com.google.firebase.auth.internal.u uVar) {
        w wVar = new w(cVar2);
        wVar.e(cVar);
        wVar.f(nVar);
        wVar.h(uVar);
        wVar.g(uVar);
        w wVar2 = wVar;
        return g(e(wVar2), wVar2);
    }

    public final b.c.a.a.f.g<Object> q(b.c.c.c cVar, com.google.firebase.auth.n nVar, com.google.firebase.auth.t tVar, String str, com.google.firebase.auth.internal.u uVar) {
        a0 a0Var = new a0(tVar, str);
        a0Var.e(cVar);
        a0Var.f(nVar);
        a0Var.h(uVar);
        a0Var.g(uVar);
        a0 a0Var2 = a0Var;
        return g(e(a0Var2), a0Var2);
    }

    public final b.c.a.a.f.g<Object> r(b.c.c.c cVar, com.google.firebase.auth.n nVar, String str, String str2, String str3, com.google.firebase.auth.internal.u uVar) {
        y yVar = new y(str, str2, str3);
        yVar.e(cVar);
        yVar.f(nVar);
        yVar.h(uVar);
        yVar.g(uVar);
        y yVar2 = yVar;
        return g(e(yVar2), yVar2);
    }

    public final b.c.a.a.f.g<Object> s(b.c.c.c cVar, String str, String str2, String str3, com.google.firebase.auth.internal.c cVar2) {
        g0 g0Var = new g0(str, str2, str3);
        g0Var.e(cVar);
        g0Var.h(cVar2);
        g0 g0Var2 = g0Var;
        return g(e(g0Var2), g0Var2);
    }
}
