package com.google.firebase.database.p;

import com.google.firebase.database.n.h;
import com.google.firebase.database.p.g0.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class v {
    private final p e;
    private final com.google.firebase.database.p.f0.e f;
    private final com.google.firebase.database.q.c g;
    private long h = 1;

    /* renamed from: a  reason: collision with root package name */
    private com.google.firebase.database.p.g0.d<u> f2290a = com.google.firebase.database.p.g0.d.e();

    /* renamed from: b  reason: collision with root package name */
    private final b0 f2291b = new b0();

    /* renamed from: c  reason: collision with root package name */
    private final Map<w, com.google.firebase.database.p.h0.i> f2292c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<com.google.firebase.database.p.h0.i, w> f2293d = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Callable<List<? extends com.google.firebase.database.p.h0.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f2294a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.l f2295b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f2296c;

        a(w wVar, com.google.firebase.database.p.l lVar, Map map) {
            this.f2294a = wVar;
            this.f2295b = lVar;
            this.f2296c = map;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<? extends com.google.firebase.database.p.h0.e> call() {
            com.google.firebase.database.p.h0.i N = v.this.N(this.f2294a);
            if (N != null) {
                com.google.firebase.database.p.l z = com.google.firebase.database.p.l.z(N.e(), this.f2295b);
                com.google.firebase.database.p.b u = com.google.firebase.database.p.b.u(this.f2296c);
                v.this.f.n(this.f2295b, u);
                return v.this.C(N, new com.google.firebase.database.p.e0.c(com.google.firebase.database.p.e0.e.a(N.d()), z, u));
            }
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Callable<List<? extends com.google.firebase.database.p.h0.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.i f2298a;

        b(com.google.firebase.database.p.i iVar) {
            this.f2298a = iVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<? extends com.google.firebase.database.p.h0.e> call() {
            com.google.firebase.database.p.h0.a o;
            com.google.firebase.database.r.n d2;
            com.google.firebase.database.p.h0.i e = this.f2298a.e();
            com.google.firebase.database.p.l e2 = e.e();
            com.google.firebase.database.p.g0.d dVar = v.this.f2290a;
            com.google.firebase.database.r.n nVar = null;
            com.google.firebase.database.p.l lVar = e2;
            boolean z = false;
            while (!dVar.isEmpty()) {
                u uVar = (u) dVar.getValue();
                if (uVar != null) {
                    if (nVar == null) {
                        nVar = uVar.d(lVar);
                    }
                    z = z || uVar.g();
                }
                dVar = dVar.u(lVar.isEmpty() ? com.google.firebase.database.r.b.g("") : lVar.x());
                lVar = lVar.A();
            }
            u uVar2 = (u) v.this.f2290a.s(e2);
            if (uVar2 == null) {
                uVar2 = new u(v.this.f);
                v vVar = v.this;
                vVar.f2290a = vVar.f2290a.B(e2, uVar2);
            } else {
                z = z || uVar2.g();
                if (nVar == null) {
                    nVar = uVar2.d(com.google.firebase.database.p.l.w());
                }
            }
            v.this.f.l(e);
            if (nVar != null) {
                o = new com.google.firebase.database.p.h0.a(com.google.firebase.database.r.i.f(nVar, e.c()), true, false);
            } else {
                o = v.this.f.o(e);
                if (!o.f()) {
                    com.google.firebase.database.r.n s = com.google.firebase.database.r.g.s();
                    Iterator it = v.this.f2290a.D(e2).w().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        u uVar3 = (u) ((com.google.firebase.database.p.g0.d) entry.getValue()).getValue();
                        if (uVar3 != null && (d2 = uVar3.d(com.google.firebase.database.p.l.w())) != null) {
                            s = s.p((com.google.firebase.database.r.b) entry.getKey(), d2);
                        }
                    }
                    for (com.google.firebase.database.r.m mVar : o.b()) {
                        if (!s.o(mVar.c())) {
                            s = s.p(mVar.c(), mVar.d());
                        }
                    }
                    o = new com.google.firebase.database.p.h0.a(com.google.firebase.database.r.i.f(s, e.c()), false, false);
                }
            }
            boolean j = uVar2.j(e);
            if (!j && !e.g()) {
                w L = v.this.L();
                v.this.f2293d.put(e, L);
                v.this.f2292c.put(L, e);
            }
            List<com.google.firebase.database.p.h0.d> a2 = uVar2.a(this.f2298a, v.this.f2291b.h(e2), o);
            if (!j && !z) {
                v.this.S(e, uVar2.k(e));
            }
            return a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Callable<List<com.google.firebase.database.p.h0.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.h0.i f2300a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.i f2301b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.b f2302c;

        c(com.google.firebase.database.p.h0.i iVar, com.google.firebase.database.p.i iVar2, com.google.firebase.database.b bVar) {
            this.f2300a = iVar;
            this.f2301b = iVar2;
            this.f2302c = bVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<com.google.firebase.database.p.h0.e> call() {
            boolean z;
            com.google.firebase.database.p.l e = this.f2300a.e();
            u uVar = (u) v.this.f2290a.s(e);
            List<com.google.firebase.database.p.h0.e> arrayList = new ArrayList<>();
            if (uVar != null && (this.f2300a.f() || uVar.j(this.f2300a))) {
                com.google.firebase.database.p.g0.g<List<com.google.firebase.database.p.h0.i>, List<com.google.firebase.database.p.h0.e>> i = uVar.i(this.f2300a, this.f2301b, this.f2302c);
                if (uVar.h()) {
                    v vVar = v.this;
                    vVar.f2290a = vVar.f2290a.z(e);
                }
                List<com.google.firebase.database.p.h0.i> a2 = i.a();
                arrayList = i.b();
                loop0: while (true) {
                    for (com.google.firebase.database.p.h0.i iVar : a2) {
                        v.this.f.e(this.f2300a);
                        z = z || iVar.g();
                    }
                }
                com.google.firebase.database.p.g0.d dVar = v.this.f2290a;
                boolean z2 = dVar.getValue() != null && ((u) dVar.getValue()).g();
                Iterator<com.google.firebase.database.r.b> it = e.iterator();
                while (it.hasNext()) {
                    dVar = dVar.u(it.next());
                    z2 = z2 || (dVar.getValue() != null && ((u) dVar.getValue()).g());
                    if (z2) {
                        break;
                    } else if (dVar.isEmpty()) {
                        break;
                    }
                }
                if (z && !z2) {
                    com.google.firebase.database.p.g0.d D = v.this.f2290a.D(e);
                    if (!D.isEmpty()) {
                        for (com.google.firebase.database.p.h0.j jVar : v.this.J(D)) {
                            o oVar = new o(jVar);
                            v.this.e.a(v.this.M(jVar.g()), oVar.f2336b, oVar, oVar);
                        }
                    }
                }
                if (!z2 && !a2.isEmpty() && this.f2302c == null) {
                    if (z) {
                        v.this.e.b(v.this.M(this.f2300a), null);
                    } else {
                        for (com.google.firebase.database.p.h0.i iVar2 : a2) {
                            v.this.e.b(v.this.M(iVar2), v.this.T(iVar2));
                        }
                    }
                }
                v.this.R(a2);
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements d.c<u, Void> {
        d() {
        }

        @Override // com.google.firebase.database.p.g0.d.c
        /* renamed from: b */
        public Void a(com.google.firebase.database.p.l lVar, u uVar, Void r5) {
            if (!lVar.isEmpty() && uVar.g()) {
                com.google.firebase.database.p.h0.i g = uVar.e().g();
                v.this.e.b(v.this.M(g), v.this.T(g));
                return null;
            }
            for (com.google.firebase.database.p.h0.j jVar : uVar.f()) {
                com.google.firebase.database.p.h0.i g2 = jVar.g();
                v.this.e.b(v.this.M(g2), v.this.T(g2));
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends h.b<com.google.firebase.database.r.b, com.google.firebase.database.p.g0.d<u>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.r.n f2305a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c0 f2306b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.e0.d f2307c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List f2308d;

        e(com.google.firebase.database.r.n nVar, c0 c0Var, com.google.firebase.database.p.e0.d dVar, List list) {
            this.f2305a = nVar;
            this.f2306b = c0Var;
            this.f2307c = dVar;
            this.f2308d = list;
        }

        @Override // com.google.firebase.database.n.h.b
        /* renamed from: b */
        public void a(com.google.firebase.database.r.b bVar, com.google.firebase.database.p.g0.d<u> dVar) {
            com.google.firebase.database.r.n nVar = this.f2305a;
            com.google.firebase.database.r.n b2 = nVar != null ? nVar.b(bVar) : null;
            c0 h = this.f2306b.h(bVar);
            com.google.firebase.database.p.e0.d d2 = this.f2307c.d(bVar);
            if (d2 != null) {
                this.f2308d.addAll(v.this.v(d2, dVar, b2, h));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Callable<List<? extends com.google.firebase.database.p.h0.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f2309a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.l f2310b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.r.n f2311c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f2312d;
        final /* synthetic */ com.google.firebase.database.r.n e;
        final /* synthetic */ boolean f;

        f(boolean z, com.google.firebase.database.p.l lVar, com.google.firebase.database.r.n nVar, long j, com.google.firebase.database.r.n nVar2, boolean z2) {
            this.f2309a = z;
            this.f2310b = lVar;
            this.f2311c = nVar;
            this.f2312d = j;
            this.e = nVar2;
            this.f = z2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<? extends com.google.firebase.database.p.h0.e> call() {
            if (this.f2309a) {
                v.this.f.d(this.f2310b, this.f2311c, this.f2312d);
            }
            v.this.f2291b.b(this.f2310b, this.e, Long.valueOf(this.f2312d), this.f);
            return !this.f ? Collections.emptyList() : v.this.x(new com.google.firebase.database.p.e0.f(com.google.firebase.database.p.e0.e.f2143d, this.f2310b, this.e));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements Callable<List<? extends com.google.firebase.database.p.h0.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f2313a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.l f2314b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.b f2315c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f2316d;
        final /* synthetic */ com.google.firebase.database.p.b e;

        g(boolean z, com.google.firebase.database.p.l lVar, com.google.firebase.database.p.b bVar, long j, com.google.firebase.database.p.b bVar2) {
            this.f2313a = z;
            this.f2314b = lVar;
            this.f2315c = bVar;
            this.f2316d = j;
            this.e = bVar2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<? extends com.google.firebase.database.p.h0.e> call() {
            if (this.f2313a) {
                v.this.f.b(this.f2314b, this.f2315c, this.f2316d);
            }
            v.this.f2291b.a(this.f2314b, this.e, Long.valueOf(this.f2316d));
            return v.this.x(new com.google.firebase.database.p.e0.c(com.google.firebase.database.p.e0.e.f2143d, this.f2314b, this.e));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements Callable<List<? extends com.google.firebase.database.p.h0.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f2317a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f2318b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f2319c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.g0.a f2320d;

        h(boolean z, long j, boolean z2, com.google.firebase.database.p.g0.a aVar) {
            this.f2317a = z;
            this.f2318b = j;
            this.f2319c = z2;
            this.f2320d = aVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<? extends com.google.firebase.database.p.h0.e> call() {
            if (this.f2317a) {
                v.this.f.a(this.f2318b);
            }
            y i = v.this.f2291b.i(this.f2318b);
            boolean l = v.this.f2291b.l(this.f2318b);
            if (i.f() && !this.f2319c) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(i.d()));
                com.google.firebase.database.r.n I = v.this.I(i.c(), arrayList);
                Map<String, Object> b2 = r.b(this.f2320d);
                if (i.e()) {
                    v.this.f.k(i.c(), r.f(i.b(), I, b2));
                } else {
                    v.this.f.m(i.c(), r.e(i.a(), I, b2));
                }
            }
            if (l) {
                com.google.firebase.database.p.g0.d e = com.google.firebase.database.p.g0.d.e();
                if (i.e()) {
                    e = e.B(com.google.firebase.database.p.l.w(), Boolean.TRUE);
                } else {
                    Iterator<Map.Entry<com.google.firebase.database.p.l, com.google.firebase.database.r.n>> it = i.a().iterator();
                    while (it.hasNext()) {
                        e = e.B(it.next().getKey(), Boolean.TRUE);
                    }
                }
                return v.this.x(new com.google.firebase.database.p.e0.a(i.c(), e, this.f2319c));
            }
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements Callable<List<? extends com.google.firebase.database.p.h0.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.l f2321a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.r.n f2322b;

        i(com.google.firebase.database.p.l lVar, com.google.firebase.database.r.n nVar) {
            this.f2321a = lVar;
            this.f2322b = nVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<? extends com.google.firebase.database.p.h0.e> call() {
            v.this.f.j(com.google.firebase.database.p.h0.i.a(this.f2321a), this.f2322b);
            return v.this.x(new com.google.firebase.database.p.e0.f(com.google.firebase.database.p.e0.e.e, this.f2321a, this.f2322b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements Callable<List<? extends com.google.firebase.database.p.h0.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f2324a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.l f2325b;

        j(Map map, com.google.firebase.database.p.l lVar) {
            this.f2324a = map;
            this.f2325b = lVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<? extends com.google.firebase.database.p.h0.e> call() {
            com.google.firebase.database.p.b u = com.google.firebase.database.p.b.u(this.f2324a);
            v.this.f.n(this.f2325b, u);
            return v.this.x(new com.google.firebase.database.p.e0.c(com.google.firebase.database.p.e0.e.e, this.f2325b, u));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements Callable<List<? extends com.google.firebase.database.p.h0.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.l f2327a;

        k(com.google.firebase.database.p.l lVar) {
            this.f2327a = lVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<? extends com.google.firebase.database.p.h0.e> call() {
            v.this.f.f(com.google.firebase.database.p.h0.i.a(this.f2327a));
            return v.this.x(new com.google.firebase.database.p.e0.b(com.google.firebase.database.p.e0.e.e, this.f2327a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l implements Callable<List<? extends com.google.firebase.database.p.h0.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f2329a;

        l(w wVar) {
            this.f2329a = wVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<? extends com.google.firebase.database.p.h0.e> call() {
            com.google.firebase.database.p.h0.i N = v.this.N(this.f2329a);
            if (N != null) {
                v.this.f.f(N);
                return v.this.C(N, new com.google.firebase.database.p.e0.b(com.google.firebase.database.p.e0.e.a(N.d()), com.google.firebase.database.p.l.w()));
            }
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m implements Callable<List<? extends com.google.firebase.database.p.h0.e>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f2331a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.l f2332b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.r.n f2333c;

        m(w wVar, com.google.firebase.database.p.l lVar, com.google.firebase.database.r.n nVar) {
            this.f2331a = wVar;
            this.f2332b = lVar;
            this.f2333c = nVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<? extends com.google.firebase.database.p.h0.e> call() {
            com.google.firebase.database.p.h0.i N = v.this.N(this.f2331a);
            if (N != null) {
                com.google.firebase.database.p.l z = com.google.firebase.database.p.l.z(N.e(), this.f2332b);
                v.this.f.j(z.isEmpty() ? N : com.google.firebase.database.p.h0.i.a(this.f2332b), this.f2333c);
                return v.this.C(N, new com.google.firebase.database.p.e0.f(com.google.firebase.database.p.e0.e.a(N.d()), z, this.f2333c));
            }
            return Collections.emptyList();
        }
    }

    /* loaded from: classes.dex */
    public interface n {
        List<? extends com.google.firebase.database.p.h0.e> a(com.google.firebase.database.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class o implements com.google.firebase.database.o.g, n {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.firebase.database.p.h0.j f2335a;

        /* renamed from: b  reason: collision with root package name */
        private final w f2336b;

        public o(com.google.firebase.database.p.h0.j jVar) {
            this.f2335a = jVar;
            this.f2336b = v.this.T(jVar.g());
        }

        @Override // com.google.firebase.database.p.v.n
        public List<? extends com.google.firebase.database.p.h0.e> a(com.google.firebase.database.b bVar) {
            if (bVar == null) {
                com.google.firebase.database.p.h0.i g = this.f2335a.g();
                w wVar = this.f2336b;
                return wVar != null ? v.this.B(wVar) : v.this.u(g.e());
            }
            com.google.firebase.database.q.c cVar = v.this.g;
            cVar.i("Listen at " + this.f2335a.g().e() + " failed: " + bVar.toString());
            return v.this.O(this.f2335a.g(), bVar);
        }

        @Override // com.google.firebase.database.o.g
        public com.google.firebase.database.o.a b() {
            com.google.firebase.database.r.d b2 = com.google.firebase.database.r.d.b(this.f2335a.h());
            List<com.google.firebase.database.p.l> e = b2.e();
            ArrayList arrayList = new ArrayList(e.size());
            for (com.google.firebase.database.p.l lVar : e) {
                arrayList.add(lVar.g());
            }
            return new com.google.firebase.database.o.a(arrayList, b2.d());
        }

        @Override // com.google.firebase.database.o.g
        public boolean c() {
            return com.google.firebase.database.p.g0.e.b(this.f2335a.h()) > 1024;
        }

        @Override // com.google.firebase.database.o.g
        public String d() {
            return this.f2335a.h().getHash();
        }
    }

    /* loaded from: classes.dex */
    public interface p {
        void a(com.google.firebase.database.p.h0.i iVar, w wVar, com.google.firebase.database.o.g gVar, n nVar);

        void b(com.google.firebase.database.p.h0.i iVar, w wVar);
    }

    public v(com.google.firebase.database.p.g gVar, com.google.firebase.database.p.f0.e eVar, p pVar) {
        new HashSet();
        this.e = pVar;
        this.f = eVar;
        this.g = gVar.n("SyncTree");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<? extends com.google.firebase.database.p.h0.e> C(com.google.firebase.database.p.h0.i iVar, com.google.firebase.database.p.e0.d dVar) {
        com.google.firebase.database.p.l e2 = iVar.e();
        return this.f2290a.s(e2).b(dVar, this.f2291b.h(e2), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.google.firebase.database.p.h0.j> J(com.google.firebase.database.p.g0.d<u> dVar) {
        ArrayList arrayList = new ArrayList();
        K(dVar, arrayList);
        return arrayList;
    }

    private void K(com.google.firebase.database.p.g0.d<u> dVar, List<com.google.firebase.database.p.h0.j> list) {
        u value = dVar.getValue();
        if (value != null && value.g()) {
            list.add(value.e());
            return;
        }
        if (value != null) {
            list.addAll(value.f());
        }
        Iterator<Map.Entry<com.google.firebase.database.r.b, com.google.firebase.database.p.g0.d<u>>> it = dVar.w().iterator();
        while (it.hasNext()) {
            K(it.next().getValue(), list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public w L() {
        long j2 = this.h;
        this.h = 1 + j2;
        return new w(j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.firebase.database.p.h0.i M(com.google.firebase.database.p.h0.i iVar) {
        return (!iVar.g() || iVar.f()) ? iVar : com.google.firebase.database.p.h0.i.a(iVar.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.firebase.database.p.h0.i N(w wVar) {
        return this.f2292c.get(wVar);
    }

    private List<com.google.firebase.database.p.h0.e> Q(com.google.firebase.database.p.h0.i iVar, com.google.firebase.database.p.i iVar2, com.google.firebase.database.b bVar) {
        return (List) this.f.i(new c(iVar, iVar2, bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(List<com.google.firebase.database.p.h0.i> list) {
        for (com.google.firebase.database.p.h0.i iVar : list) {
            if (!iVar.g()) {
                w T = T(iVar);
                this.f2293d.remove(iVar);
                this.f2292c.remove(T);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(com.google.firebase.database.p.h0.i iVar, com.google.firebase.database.p.h0.j jVar) {
        com.google.firebase.database.p.l e2 = iVar.e();
        w T = T(iVar);
        o oVar = new o(jVar);
        this.e.a(M(iVar), T, oVar, oVar);
        com.google.firebase.database.p.g0.d<u> D = this.f2290a.D(e2);
        if (T != null) {
            return;
        }
        D.m(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public w T(com.google.firebase.database.p.h0.i iVar) {
        return this.f2293d.get(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.google.firebase.database.p.h0.e> v(com.google.firebase.database.p.e0.d dVar, com.google.firebase.database.p.g0.d<u> dVar2, com.google.firebase.database.r.n nVar, c0 c0Var) {
        u value = dVar2.getValue();
        if (nVar == null && value != null) {
            nVar = value.d(com.google.firebase.database.p.l.w());
        }
        ArrayList arrayList = new ArrayList();
        dVar2.w().m(new e(nVar, c0Var, dVar, arrayList));
        if (value != null) {
            arrayList.addAll(value.b(dVar, c0Var, nVar));
        }
        return arrayList;
    }

    private List<com.google.firebase.database.p.h0.e> w(com.google.firebase.database.p.e0.d dVar, com.google.firebase.database.p.g0.d<u> dVar2, com.google.firebase.database.r.n nVar, c0 c0Var) {
        if (dVar.a().isEmpty()) {
            return v(dVar, dVar2, nVar, c0Var);
        }
        u value = dVar2.getValue();
        if (nVar == null && value != null) {
            nVar = value.d(com.google.firebase.database.p.l.w());
        }
        ArrayList arrayList = new ArrayList();
        com.google.firebase.database.r.b x = dVar.a().x();
        com.google.firebase.database.p.e0.d d2 = dVar.d(x);
        com.google.firebase.database.p.g0.d<u> e2 = dVar2.w().e(x);
        if (e2 != null && d2 != null) {
            arrayList.addAll(w(d2, e2, nVar != null ? nVar.b(x) : null, c0Var.h(x)));
        }
        if (value != null) {
            arrayList.addAll(value.b(dVar, c0Var, nVar));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.google.firebase.database.p.h0.e> x(com.google.firebase.database.p.e0.d dVar) {
        return w(dVar, this.f2290a, null, this.f2291b.h(com.google.firebase.database.p.l.w()));
    }

    public List<? extends com.google.firebase.database.p.h0.e> A(com.google.firebase.database.p.l lVar, List<com.google.firebase.database.r.s> list) {
        com.google.firebase.database.p.h0.j e2;
        u s = this.f2290a.s(lVar);
        if (s != null && (e2 = s.e()) != null) {
            com.google.firebase.database.r.n h2 = e2.h();
            for (com.google.firebase.database.r.s sVar : list) {
                h2 = sVar.a(h2);
            }
            return z(lVar, h2);
        }
        return Collections.emptyList();
    }

    public List<? extends com.google.firebase.database.p.h0.e> B(w wVar) {
        return (List) this.f.i(new l(wVar));
    }

    public List<? extends com.google.firebase.database.p.h0.e> D(com.google.firebase.database.p.l lVar, Map<com.google.firebase.database.p.l, com.google.firebase.database.r.n> map, w wVar) {
        return (List) this.f.i(new a(wVar, lVar, map));
    }

    public List<? extends com.google.firebase.database.p.h0.e> E(com.google.firebase.database.p.l lVar, com.google.firebase.database.r.n nVar, w wVar) {
        return (List) this.f.i(new m(wVar, lVar, nVar));
    }

    public List<? extends com.google.firebase.database.p.h0.e> F(com.google.firebase.database.p.l lVar, List<com.google.firebase.database.r.s> list, w wVar) {
        com.google.firebase.database.p.h0.i N = N(wVar);
        if (N != null) {
            com.google.firebase.database.r.n h2 = this.f2290a.s(N.e()).k(N).h();
            for (com.google.firebase.database.r.s sVar : list) {
                h2 = sVar.a(h2);
            }
            return E(lVar, h2, wVar);
        }
        return Collections.emptyList();
    }

    public List<? extends com.google.firebase.database.p.h0.e> G(com.google.firebase.database.p.l lVar, com.google.firebase.database.p.b bVar, com.google.firebase.database.p.b bVar2, long j2, boolean z) {
        return (List) this.f.i(new g(z, lVar, bVar, j2, bVar2));
    }

    public List<? extends com.google.firebase.database.p.h0.e> H(com.google.firebase.database.p.l lVar, com.google.firebase.database.r.n nVar, com.google.firebase.database.r.n nVar2, long j2, boolean z, boolean z2) {
        com.google.firebase.database.p.g0.l.f(z || !z2, "We shouldn't be persisting non-visible writes.");
        return (List) this.f.i(new f(z2, lVar, nVar, j2, nVar2, z));
    }

    public com.google.firebase.database.r.n I(com.google.firebase.database.p.l lVar, List<Long> list) {
        com.google.firebase.database.p.g0.d<u> dVar = this.f2290a;
        dVar.getValue();
        com.google.firebase.database.p.l w = com.google.firebase.database.p.l.w();
        com.google.firebase.database.r.n nVar = null;
        com.google.firebase.database.p.l lVar2 = lVar;
        do {
            com.google.firebase.database.r.b x = lVar2.x();
            lVar2 = lVar2.A();
            w = w.l(x);
            com.google.firebase.database.p.l z = com.google.firebase.database.p.l.z(w, lVar);
            dVar = x != null ? dVar.u(x) : com.google.firebase.database.p.g0.d.e();
            u value = dVar.getValue();
            if (value != null) {
                nVar = value.d(z);
            }
            if (lVar2.isEmpty()) {
                break;
            }
        } while (nVar == null);
        return this.f2291b.d(lVar, nVar, list, true);
    }

    public List<com.google.firebase.database.p.h0.e> O(com.google.firebase.database.p.h0.i iVar, com.google.firebase.database.b bVar) {
        return Q(iVar, null, bVar);
    }

    public List<com.google.firebase.database.p.h0.e> P(com.google.firebase.database.p.i iVar) {
        return Q(iVar.e(), iVar, null);
    }

    public List<? extends com.google.firebase.database.p.h0.e> s(long j2, boolean z, boolean z2, com.google.firebase.database.p.g0.a aVar) {
        return (List) this.f.i(new h(z2, j2, z, aVar));
    }

    public List<? extends com.google.firebase.database.p.h0.e> t(com.google.firebase.database.p.i iVar) {
        return (List) this.f.i(new b(iVar));
    }

    public List<? extends com.google.firebase.database.p.h0.e> u(com.google.firebase.database.p.l lVar) {
        return (List) this.f.i(new k(lVar));
    }

    public List<? extends com.google.firebase.database.p.h0.e> y(com.google.firebase.database.p.l lVar, Map<com.google.firebase.database.p.l, com.google.firebase.database.r.n> map) {
        return (List) this.f.i(new j(map, lVar));
    }

    public List<? extends com.google.firebase.database.p.h0.e> z(com.google.firebase.database.p.l lVar, com.google.firebase.database.r.n nVar) {
        return (List) this.f.i(new i(lVar, nVar));
    }
}
