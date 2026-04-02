package com.google.firebase.database.p;

import com.google.firebase.database.k;
import com.google.firebase.database.o.h;
import com.google.firebase.database.p.a;
import com.google.firebase.database.p.g0.j;
import com.google.firebase.database.p.t;
import com.google.firebase.database.p.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class n implements h.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.firebase.database.p.o f2249a;

    /* renamed from: c  reason: collision with root package name */
    private com.google.firebase.database.o.h f2251c;

    /* renamed from: d  reason: collision with root package name */
    private s f2252d;
    private t e;
    private com.google.firebase.database.p.g0.j<List<p>> f;
    private final com.google.firebase.database.p.h0.g h;
    private final com.google.firebase.database.p.g i;
    private final com.google.firebase.database.q.c j;
    private final com.google.firebase.database.q.c k;
    private final com.google.firebase.database.q.c l;
    private v o;
    private v p;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.database.p.g0.f f2250b = new com.google.firebase.database.p.g0.f(new com.google.firebase.database.p.g0.b(), 0);
    private boolean g = false;
    public long m = 0;
    private long n = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements t.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f2253a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f2254b;

        a(Map map, List list) {
            this.f2253a = map;
            this.f2254b = list;
        }

        @Override // com.google.firebase.database.p.t.c
        public void a(com.google.firebase.database.p.l lVar, com.google.firebase.database.r.n nVar) {
            this.f2254b.addAll(n.this.p.z(lVar, r.f(nVar, n.this.p.I(lVar, new ArrayList()), this.f2253a)));
            n.this.Q(n.this.g(lVar, -9));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements j.c<List<p>> {
        b() {
        }

        @Override // com.google.firebase.database.p.g0.j.c
        public void a(com.google.firebase.database.p.g0.j<List<p>> jVar) {
            n.this.V(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements com.google.firebase.database.o.k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.l f2257a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f2258b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n f2259c;

        /* loaded from: classes.dex */
        class a implements Runnable {
            final /* synthetic */ p f;
            final /* synthetic */ com.google.firebase.database.a g;

            a(c cVar, p pVar, com.google.firebase.database.a aVar) {
                this.f = pVar;
                this.g = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.g.a(null, true, this.g);
            }
        }

        c(com.google.firebase.database.p.l lVar, List list, n nVar) {
            this.f2257a = lVar;
            this.f2258b = list;
            this.f2259c = nVar;
        }

        @Override // com.google.firebase.database.o.k
        public void a(String str, String str2) {
            com.google.firebase.database.b G = n.G(str, str2);
            n.this.Y("Transaction", this.f2257a, G);
            ArrayList arrayList = new ArrayList();
            if (G != null) {
                if (G.f() == -1) {
                    for (p pVar : this.f2258b) {
                        pVar.i = pVar.i == q.SENT_NEEDS_ABORT ? q.NEEDS_ABORT : q.RUN;
                    }
                } else {
                    for (p pVar2 : this.f2258b) {
                        pVar2.i = q.NEEDS_ABORT;
                        pVar2.m = G;
                    }
                }
                n.this.Q(this.f2257a);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            for (p pVar3 : this.f2258b) {
                pVar3.i = q.COMPLETED;
                arrayList.addAll(n.this.p.s(pVar3.n, false, false, n.this.f2250b));
                arrayList2.add(new a(this, pVar3, com.google.firebase.database.h.a(com.google.firebase.database.h.c(this.f2259c, pVar3.f), com.google.firebase.database.r.i.e(pVar3.q))));
                n.this.O(new a0(n.this, pVar3.h, com.google.firebase.database.p.h0.i.a(pVar3.f)));
            }
            n nVar = n.this;
            nVar.N(nVar.f.k(this.f2257a));
            n.this.U();
            this.f2259c.M(arrayList);
            for (int i = 0; i < arrayList2.size(); i++) {
                n.this.L((Runnable) arrayList2.get(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements j.c<List<p>> {
        d() {
        }

        @Override // com.google.firebase.database.p.g0.j.c
        public void a(com.google.firebase.database.p.g0.j<List<p>> jVar) {
            n.this.N(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        final /* synthetic */ p f;

        e(p pVar) {
            this.f = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.O(new a0(n.this, this.f.h, com.google.firebase.database.p.h0.i.a(this.f.f)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        final /* synthetic */ p f;
        final /* synthetic */ com.google.firebase.database.b g;
        final /* synthetic */ com.google.firebase.database.a h;

        f(n nVar, p pVar, com.google.firebase.database.b bVar, com.google.firebase.database.a aVar) {
            this.f = pVar;
            this.g = bVar;
            this.h = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f.g.a(this.g, false, this.h);
        }
    }

    /* loaded from: classes.dex */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements j.c<List<p>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f2262a;

        h(List list) {
            this.f2262a = list;
        }

        @Override // com.google.firebase.database.p.g0.j.c
        public void a(com.google.firebase.database.p.g0.j<List<p>> jVar) {
            n.this.D(this.f2262a, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements j.b<List<p>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2264a;

        i(int i) {
            this.f2264a = i;
        }

        @Override // com.google.firebase.database.p.g0.j.b
        public boolean a(com.google.firebase.database.p.g0.j<List<p>> jVar) {
            n.this.h(jVar, this.f2264a);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements j.c<List<p>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2266a;

        j(int i) {
            this.f2266a = i;
        }

        @Override // com.google.firebase.database.p.g0.j.c
        public void a(com.google.firebase.database.p.g0.j<List<p>> jVar) {
            n.this.h(jVar, this.f2266a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements Runnable {
        final /* synthetic */ p f;
        final /* synthetic */ com.google.firebase.database.b g;

        k(n nVar, p pVar, com.google.firebase.database.b bVar) {
            this.f = pVar;
            this.g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f.g.a(this.g, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l implements a.b {
        l() {
        }

        @Override // com.google.firebase.database.p.a.b
        public void a(String str) {
            n.this.j.b("Auth token changed, triggering auth token refresh", new Object[0]);
            n.this.f2251c.e(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m implements v.p {

        /* loaded from: classes.dex */
        class a implements Runnable {
            final /* synthetic */ com.google.firebase.database.p.h0.i f;
            final /* synthetic */ v.n g;

            a(com.google.firebase.database.p.h0.i iVar, v.n nVar) {
                this.f = iVar;
                this.g = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.google.firebase.database.r.n a2 = n.this.f2252d.a(this.f.e());
                if (a2.isEmpty()) {
                    return;
                }
                n.this.M(n.this.o.z(this.f.e(), a2));
                this.g.a(null);
            }
        }

        m() {
        }

        @Override // com.google.firebase.database.p.v.p
        public void a(com.google.firebase.database.p.h0.i iVar, w wVar, com.google.firebase.database.o.g gVar, v.n nVar) {
            n.this.T(new a(iVar, nVar));
        }

        @Override // com.google.firebase.database.p.v.p
        public void b(com.google.firebase.database.p.h0.i iVar, w wVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.database.p.n$n  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0102n implements v.p {

        /* renamed from: com.google.firebase.database.p.n$n$a */
        /* loaded from: classes.dex */
        class a implements com.google.firebase.database.o.k {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ v.n f2271a;

            a(v.n nVar) {
                this.f2271a = nVar;
            }

            @Override // com.google.firebase.database.o.k
            public void a(String str, String str2) {
                n.this.M(this.f2271a.a(n.G(str, str2)));
            }
        }

        C0102n() {
        }

        @Override // com.google.firebase.database.p.v.p
        public void a(com.google.firebase.database.p.h0.i iVar, w wVar, com.google.firebase.database.o.g gVar, v.n nVar) {
            n.this.f2251c.f(iVar.e().g(), iVar.d().i(), gVar, wVar != null ? Long.valueOf(wVar.a()) : null, new a(nVar));
        }

        @Override // com.google.firebase.database.p.v.p
        public void b(com.google.firebase.database.p.h0.i iVar, w wVar) {
            n.this.f2251c.j(iVar.e().g(), iVar.d().i());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o implements com.google.firebase.database.o.k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f2273a;

        o(y yVar) {
            this.f2273a = yVar;
        }

        @Override // com.google.firebase.database.o.k
        public void a(String str, String str2) {
            com.google.firebase.database.b G = n.G(str, str2);
            n.this.Y("Persisted write", this.f2273a.c(), G);
            n.this.B(this.f2273a.d(), this.f2273a.c(), G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class p implements Comparable<p> {
        private com.google.firebase.database.p.l f;
        private k.b g;
        private com.google.firebase.database.l h;
        private q i;
        private long j;
        private boolean k;
        private int l;
        private com.google.firebase.database.b m;
        private long n;
        private com.google.firebase.database.r.n o;
        private com.google.firebase.database.r.n p;
        private com.google.firebase.database.r.n q;

        static /* synthetic */ int y(p pVar) {
            int i = pVar.l;
            pVar.l = i + 1;
            return i;
        }

        @Override // java.lang.Comparable
        /* renamed from: F */
        public int compareTo(p pVar) {
            long j = this.j;
            long j2 = pVar.j;
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum q {
        INITIALIZING,
        RUN,
        SENT,
        COMPLETED,
        SENT_NEEDS_ABORT,
        NEEDS_ABORT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(com.google.firebase.database.p.o oVar, com.google.firebase.database.p.g gVar, com.google.firebase.database.f fVar) {
        this.f2249a = oVar;
        this.i = gVar;
        this.j = gVar.n("RepoOperation");
        this.k = this.i.n("Transaction");
        this.l = this.i.n("DataOperation");
        this.h = new com.google.firebase.database.p.h0.g(this.i);
        T(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(long j2, com.google.firebase.database.p.l lVar, com.google.firebase.database.b bVar) {
        if (bVar == null || bVar.f() != -25) {
            List<? extends com.google.firebase.database.p.h0.e> s = this.p.s(j2, !(bVar == null), true, this.f2250b);
            if (s.size() > 0) {
                Q(lVar);
            }
            M(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(List<p> list, com.google.firebase.database.p.g0.j<List<p>> jVar) {
        List<p> g2 = jVar.g();
        if (g2 != null) {
            list.addAll(g2);
        }
        jVar.c(new h(list));
    }

    private List<p> E(com.google.firebase.database.p.g0.j<List<p>> jVar) {
        ArrayList arrayList = new ArrayList();
        D(arrayList, jVar);
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        com.google.firebase.database.p.o oVar = this.f2249a;
        this.f2251c = this.i.B(new com.google.firebase.database.o.f(oVar.f2275a, oVar.f2277c, oVar.f2276b), this);
        this.i.j().b(((com.google.firebase.database.p.g0.c) this.i.s()).c(), new l());
        this.f2251c.a();
        com.google.firebase.database.p.f0.e q2 = this.i.q(this.f2249a.f2275a);
        this.f2252d = new s();
        this.e = new t();
        this.f = new com.google.firebase.database.p.g0.j<>();
        this.o = new v(this.i, new com.google.firebase.database.p.f0.d(), new m());
        this.p = new v(this.i, q2, new C0102n());
        R(q2);
        X(com.google.firebase.database.p.c.f2130c, Boolean.FALSE);
        X(com.google.firebase.database.p.c.f2131d, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.google.firebase.database.b G(String str, String str2) {
        if (str != null) {
            return com.google.firebase.database.b.d(str, str2);
        }
        return null;
    }

    private com.google.firebase.database.p.g0.j<List<p>> H(com.google.firebase.database.p.l lVar) {
        com.google.firebase.database.p.g0.j<List<p>> jVar = this.f;
        while (!lVar.isEmpty() && jVar.g() == null) {
            jVar = jVar.k(new com.google.firebase.database.p.l(lVar.x()));
            lVar = lVar.A();
        }
        return jVar;
    }

    private com.google.firebase.database.r.n I(com.google.firebase.database.p.l lVar, List<Long> list) {
        com.google.firebase.database.r.n I = this.p.I(lVar, list);
        return I == null ? com.google.firebase.database.r.g.s() : I;
    }

    private long J() {
        long j2 = this.n;
        this.n = 1 + j2;
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(List<? extends com.google.firebase.database.p.h0.e> list) {
        if (list.isEmpty()) {
            return;
        }
        this.h.b(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(com.google.firebase.database.p.g0.j<List<p>> jVar) {
        List<p> g2 = jVar.g();
        if (g2 != null) {
            int i2 = 0;
            while (i2 < g2.size()) {
                if (g2.get(i2).i == q.COMPLETED) {
                    g2.remove(i2);
                } else {
                    i2++;
                }
            }
            if (g2.size() <= 0) {
                g2 = null;
            }
            jVar.j(g2);
        }
        jVar.c(new d());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
        if (r10.f() != (-25)) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void P(java.util.List<com.google.firebase.database.p.n.p> r23, com.google.firebase.database.p.l r24) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.p.n.P(java.util.List, com.google.firebase.database.p.l):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.firebase.database.p.l Q(com.google.firebase.database.p.l lVar) {
        com.google.firebase.database.p.g0.j<List<p>> H = H(lVar);
        com.google.firebase.database.p.l f2 = H.f();
        P(E(H), f2);
        return f2;
    }

    private void R(com.google.firebase.database.p.f0.e eVar) {
        List<y> c2 = eVar.c();
        Map<String, Object> b2 = r.b(this.f2250b);
        long j2 = Long.MIN_VALUE;
        for (y yVar : c2) {
            o oVar = new o(yVar);
            if (j2 >= yVar.d()) {
                throw new IllegalStateException("Write ids were not in order.");
            }
            j2 = yVar.d();
            this.n = yVar.d() + 1;
            com.google.firebase.database.r.n I = this.p.I(yVar.c(), new ArrayList());
            if (yVar.e()) {
                if (this.j.f()) {
                    com.google.firebase.database.q.c cVar = this.j;
                    cVar.b("Restoring overwrite with id " + yVar.d(), new Object[0]);
                }
                this.f2251c.b(yVar.c().g(), yVar.b().r(true), oVar);
                this.p.H(yVar.c(), yVar.b(), r.f(yVar.b(), I, b2), yVar.d(), true, false);
            } else {
                if (this.j.f()) {
                    com.google.firebase.database.q.c cVar2 = this.j;
                    cVar2.b("Restoring merge with id " + yVar.d(), new Object[0]);
                }
                this.f2251c.h(yVar.c().g(), yVar.a().z(true), oVar);
                this.p.G(yVar.c(), yVar.a(), r.e(yVar.a(), I, b2), yVar.d(), false);
            }
        }
    }

    private void S() {
        Map<String, Object> b2 = r.b(this.f2250b);
        ArrayList arrayList = new ArrayList();
        this.e.b(com.google.firebase.database.p.l.w(), new a(b2, arrayList));
        this.e = new t();
        M(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        com.google.firebase.database.p.g0.j<List<p>> jVar = this.f;
        N(jVar);
        V(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(com.google.firebase.database.p.g0.j<List<p>> jVar) {
        if (jVar.g() == null) {
            if (jVar.h()) {
                jVar.c(new b());
                return;
            }
            return;
        }
        List<p> E = E(jVar);
        Boolean bool = Boolean.TRUE;
        Iterator<p> it = E.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().i != q.RUN) {
                bool = Boolean.FALSE;
                break;
            }
        }
        if (bool.booleanValue()) {
            W(E, jVar.f());
        }
    }

    private void W(List<p> list, com.google.firebase.database.p.l lVar) {
        ArrayList arrayList = new ArrayList();
        for (p pVar : list) {
            arrayList.add(Long.valueOf(pVar.n));
        }
        com.google.firebase.database.r.n I = I(lVar, arrayList);
        String hash = !this.g ? I.getHash() : "badhash";
        for (p pVar2 : list) {
            pVar2.i = q.SENT;
            p.y(pVar2);
            I = I.q(com.google.firebase.database.p.l.z(lVar, pVar2.f), pVar2.p);
        }
        this.f2251c.d(lVar.g(), I.r(true), hash, new c(lVar, list, this));
    }

    private void X(com.google.firebase.database.r.b bVar, Object obj) {
        if (bVar.equals(com.google.firebase.database.p.c.f2129b)) {
            this.f2250b.b(((Long) obj).longValue());
        }
        com.google.firebase.database.p.l lVar = new com.google.firebase.database.p.l(com.google.firebase.database.p.c.f2128a, bVar);
        try {
            com.google.firebase.database.r.n a2 = com.google.firebase.database.r.o.a(obj);
            this.f2252d.c(lVar, a2);
            M(this.o.z(lVar, a2));
        } catch (com.google.firebase.database.c e2) {
            this.j.c("Failed to parse info update", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(String str, com.google.firebase.database.p.l lVar, com.google.firebase.database.b bVar) {
        if (bVar == null || bVar.f() == -1 || bVar.f() == -25) {
            return;
        }
        com.google.firebase.database.q.c cVar = this.j;
        cVar.i(str + " at " + lVar.toString() + " failed: " + bVar.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.firebase.database.p.l g(com.google.firebase.database.p.l lVar, int i2) {
        com.google.firebase.database.p.l f2 = H(lVar).f();
        if (this.k.f()) {
            com.google.firebase.database.q.c cVar = this.j;
            cVar.b("Aborting transactions for path: " + lVar + ". Affected: " + f2, new Object[0]);
        }
        com.google.firebase.database.p.g0.j<List<p>> k2 = this.f.k(lVar);
        k2.a(new i(i2));
        h(k2, i2);
        k2.d(new j(i2));
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.google.firebase.database.p.g0.j<List<p>> jVar, int i2) {
        com.google.firebase.database.b a2;
        List<p> g2 = jVar.g();
        ArrayList arrayList = new ArrayList();
        if (g2 != null) {
            ArrayList<Runnable> arrayList2 = new ArrayList();
            if (i2 == -9) {
                a2 = com.google.firebase.database.b.c("overriddenBySet");
            } else {
                boolean z = i2 == -25;
                com.google.firebase.database.p.g0.l.f(z, "Unknown transaction abort reason: " + i2);
                a2 = com.google.firebase.database.b.a(-25);
            }
            int i3 = -1;
            for (int i4 = 0; i4 < g2.size(); i4++) {
                p pVar = g2.get(i4);
                if (pVar.i != q.SENT_NEEDS_ABORT) {
                    if (pVar.i == q.SENT) {
                        pVar.i = q.SENT_NEEDS_ABORT;
                        pVar.m = a2;
                        i3 = i4;
                    } else {
                        O(new a0(this, pVar.h, com.google.firebase.database.p.h0.i.a(pVar.f)));
                        if (i2 == -9) {
                            arrayList.addAll(this.p.s(pVar.n, true, false, this.f2250b));
                        } else {
                            boolean z2 = i2 == -25;
                            com.google.firebase.database.p.g0.l.f(z2, "Unknown transaction abort reason: " + i2);
                        }
                        arrayList2.add(new k(this, pVar, a2));
                    }
                }
            }
            jVar.j(i3 == -1 ? null : g2.subList(0, i3 + 1));
            M(arrayList);
            for (Runnable runnable : arrayList2) {
                L(runnable);
            }
        }
    }

    public void C(com.google.firebase.database.p.i iVar) {
        com.google.firebase.database.r.b x = iVar.e().e().x();
        M(((x == null || !x.equals(com.google.firebase.database.p.c.f2128a)) ? this.p : this.o).t(iVar));
    }

    public void K(com.google.firebase.database.r.b bVar, Object obj) {
        X(bVar, obj);
    }

    public void L(Runnable runnable) {
        this.i.C();
        this.i.l().b(runnable);
    }

    public void O(com.google.firebase.database.p.i iVar) {
        M((com.google.firebase.database.p.c.f2128a.equals(iVar.e().e().x()) ? this.o : this.p).P(iVar));
    }

    public void T(Runnable runnable) {
        this.i.C();
        this.i.s().b(runnable);
    }

    @Override // com.google.firebase.database.o.h.a
    public void a() {
        K(com.google.firebase.database.p.c.f2131d, Boolean.TRUE);
    }

    @Override // com.google.firebase.database.o.h.a
    public void b(boolean z) {
        K(com.google.firebase.database.p.c.f2130c, Boolean.valueOf(z));
    }

    @Override // com.google.firebase.database.o.h.a
    public void c(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            X(com.google.firebase.database.r.b.g(entry.getKey()), entry.getValue());
        }
    }

    @Override // com.google.firebase.database.o.h.a
    public void d(List<String> list, Object obj, boolean z, Long l2) {
        List<? extends com.google.firebase.database.p.h0.e> z2;
        com.google.firebase.database.p.l lVar = new com.google.firebase.database.p.l(list);
        if (this.j.f()) {
            this.j.b("onDataUpdate: " + lVar, new Object[0]);
        }
        if (this.l.f()) {
            this.j.b("onDataUpdate: " + lVar + " " + obj, new Object[0]);
        }
        this.m++;
        try {
            if (l2 != null) {
                w wVar = new w(l2.longValue());
                if (z) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        hashMap.put(new com.google.firebase.database.p.l((String) entry.getKey()), com.google.firebase.database.r.o.a(entry.getValue()));
                    }
                    z2 = this.p.D(lVar, hashMap, wVar);
                } else {
                    z2 = this.p.E(lVar, com.google.firebase.database.r.o.a(obj), wVar);
                }
            } else if (z) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry entry2 : ((Map) obj).entrySet()) {
                    hashMap2.put(new com.google.firebase.database.p.l((String) entry2.getKey()), com.google.firebase.database.r.o.a(entry2.getValue()));
                }
                z2 = this.p.y(lVar, hashMap2);
            } else {
                z2 = this.p.z(lVar, com.google.firebase.database.r.o.a(obj));
            }
            if (z2.size() > 0) {
                Q(lVar);
            }
            M(z2);
        } catch (com.google.firebase.database.c e2) {
            this.j.c("FIREBASE INTERNAL ERROR", e2);
        }
    }

    @Override // com.google.firebase.database.o.h.a
    public void e() {
        K(com.google.firebase.database.p.c.f2131d, Boolean.FALSE);
        S();
    }

    @Override // com.google.firebase.database.o.h.a
    public void f(List<String> list, List<com.google.firebase.database.o.j> list2, Long l2) {
        com.google.firebase.database.p.l lVar = new com.google.firebase.database.p.l(list);
        if (this.j.f()) {
            this.j.b("onRangeMergeUpdate: " + lVar, new Object[0]);
        }
        if (this.l.f()) {
            this.j.b("onRangeMergeUpdate: " + lVar + " " + list2, new Object[0]);
        }
        this.m++;
        ArrayList arrayList = new ArrayList(list2.size());
        for (com.google.firebase.database.o.j jVar : list2) {
            arrayList.add(new com.google.firebase.database.r.s(jVar));
        }
        v vVar = this.p;
        List<? extends com.google.firebase.database.p.h0.e> F = l2 != null ? vVar.F(lVar, arrayList, new w(l2.longValue())) : vVar.A(lVar, arrayList);
        if (F.size() > 0) {
            Q(lVar);
        }
        M(F);
    }

    public String toString() {
        return this.f2249a.toString();
    }
}
