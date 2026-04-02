package com.google.firebase.database.p.f0;

import com.google.firebase.database.p.g0.d;
import com.google.firebase.database.p.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class i {
    private static final com.google.firebase.database.p.g0.i<Map<com.google.firebase.database.p.h0.h, h>> f = new a();
    private static final com.google.firebase.database.p.g0.i<Map<com.google.firebase.database.p.h0.h, h>> g = new b();
    private static final com.google.firebase.database.p.g0.i<h> h = new c();
    private static final com.google.firebase.database.p.g0.i<h> i = new d();

    /* renamed from: a  reason: collision with root package name */
    private com.google.firebase.database.p.g0.d<Map<com.google.firebase.database.p.h0.h, h>> f2163a = new com.google.firebase.database.p.g0.d<>(null);

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.database.p.f0.f f2164b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.database.q.c f2165c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.firebase.database.p.g0.a f2166d;
    private long e;

    /* loaded from: classes.dex */
    class a implements com.google.firebase.database.p.g0.i<Map<com.google.firebase.database.p.h0.h, h>> {
        a() {
        }

        @Override // com.google.firebase.database.p.g0.i
        /* renamed from: b */
        public boolean a(Map<com.google.firebase.database.p.h0.h, h> map) {
            h hVar = map.get(com.google.firebase.database.p.h0.h.i);
            return hVar != null && hVar.f2162d;
        }
    }

    /* loaded from: classes.dex */
    class b implements com.google.firebase.database.p.g0.i<Map<com.google.firebase.database.p.h0.h, h>> {
        b() {
        }

        @Override // com.google.firebase.database.p.g0.i
        /* renamed from: b */
        public boolean a(Map<com.google.firebase.database.p.h0.h, h> map) {
            h hVar = map.get(com.google.firebase.database.p.h0.h.i);
            return hVar != null && hVar.e;
        }
    }

    /* loaded from: classes.dex */
    class c implements com.google.firebase.database.p.g0.i<h> {
        c() {
        }

        @Override // com.google.firebase.database.p.g0.i
        /* renamed from: b */
        public boolean a(h hVar) {
            return !hVar.e;
        }
    }

    /* loaded from: classes.dex */
    class d implements com.google.firebase.database.p.g0.i<h> {
        d() {
        }

        @Override // com.google.firebase.database.p.g0.i
        /* renamed from: b */
        public boolean a(h hVar) {
            return !i.h.a(hVar);
        }
    }

    /* loaded from: classes.dex */
    class e implements d.c<Map<com.google.firebase.database.p.h0.h, h>, Void> {
        e() {
        }

        @Override // com.google.firebase.database.p.g0.d.c
        /* renamed from: b */
        public Void a(l lVar, Map<com.google.firebase.database.p.h0.h, h> map, Void r3) {
            for (Map.Entry<com.google.firebase.database.p.h0.h, h> entry : map.entrySet()) {
                h value = entry.getValue();
                if (!value.f2162d) {
                    i.this.s(value.b());
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    class f implements Comparator<h> {
        f(i iVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(h hVar, h hVar2) {
            return com.google.firebase.database.p.g0.l.b(hVar.f2161c, hVar2.f2161c);
        }
    }

    public i(com.google.firebase.database.p.f0.f fVar, com.google.firebase.database.q.c cVar, com.google.firebase.database.p.g0.a aVar) {
        this.e = 0L;
        this.f2164b = fVar;
        this.f2165c = cVar;
        this.f2166d = aVar;
        r();
        for (h hVar : this.f2164b.p()) {
            this.e = Math.max(hVar.f2159a + 1, this.e);
            d(hVar);
        }
    }

    private static void c(com.google.firebase.database.p.h0.i iVar) {
        com.google.firebase.database.p.g0.l.f(!iVar.g() || iVar.f(), "Can't have tracked non-default query that loads all data");
    }

    private void d(h hVar) {
        c(hVar.f2160b);
        Map<com.google.firebase.database.p.h0.h, h> s = this.f2163a.s(hVar.f2160b.e());
        if (s == null) {
            s = new HashMap<>();
            this.f2163a = this.f2163a.B(hVar.f2160b.e(), s);
        }
        h hVar2 = s.get(hVar.f2160b.d());
        com.google.firebase.database.p.g0.l.e(hVar2 == null || hVar2.f2159a == hVar.f2159a);
        s.put(hVar.f2160b.d(), hVar);
    }

    private static long e(com.google.firebase.database.p.f0.a aVar, long j) {
        return j - Math.min((long) Math.floor(((float) j) * (1.0f - aVar.b())), aVar.c());
    }

    private Set<Long> h(l lVar) {
        HashSet hashSet = new HashSet();
        Map<com.google.firebase.database.p.h0.h, h> s = this.f2163a.s(lVar);
        if (s != null) {
            for (h hVar : s.values()) {
                if (!hVar.f2160b.g()) {
                    hashSet.add(Long.valueOf(hVar.f2159a));
                }
            }
        }
        return hashSet;
    }

    private List<h> k(com.google.firebase.database.p.g0.i<h> iVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<l, Map<com.google.firebase.database.p.h0.h, h>>> it = this.f2163a.iterator();
        while (it.hasNext()) {
            for (h hVar : it.next().getValue().values()) {
                if (iVar.a(hVar)) {
                    arrayList.add(hVar);
                }
            }
        }
        return arrayList;
    }

    private boolean m(l lVar) {
        return this.f2163a.f(lVar, f) != null;
    }

    private static com.google.firebase.database.p.h0.i o(com.google.firebase.database.p.h0.i iVar) {
        return iVar.g() ? com.google.firebase.database.p.h0.i.a(iVar.e()) : iVar;
    }

    private void r() {
        try {
            this.f2164b.f();
            this.f2164b.i(this.f2166d.a());
            this.f2164b.r();
        } finally {
            this.f2164b.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(h hVar) {
        d(hVar);
        this.f2164b.l(hVar);
    }

    private void v(com.google.firebase.database.p.h0.i iVar, boolean z) {
        h hVar;
        com.google.firebase.database.p.h0.i o = o(iVar);
        h i2 = i(o);
        long a2 = this.f2166d.a();
        if (i2 != null) {
            hVar = i2.c(a2).a(z);
        } else {
            long j = this.e;
            this.e = 1 + j;
            hVar = new h(j, o, a2, false, z);
        }
        s(hVar);
    }

    public long f() {
        return k(h).size();
    }

    public void g(l lVar) {
        h b2;
        if (m(lVar)) {
            return;
        }
        com.google.firebase.database.p.h0.i a2 = com.google.firebase.database.p.h0.i.a(lVar);
        h i2 = i(a2);
        if (i2 == null) {
            long j = this.e;
            this.e = 1 + j;
            b2 = new h(j, a2, this.f2166d.a(), true, false);
        } else {
            b2 = i2.b();
        }
        s(b2);
    }

    public h i(com.google.firebase.database.p.h0.i iVar) {
        com.google.firebase.database.p.h0.i o = o(iVar);
        Map<com.google.firebase.database.p.h0.h, h> s = this.f2163a.s(o.e());
        if (s != null) {
            return s.get(o.d());
        }
        return null;
    }

    public Set<com.google.firebase.database.r.b> j(l lVar) {
        HashSet hashSet = new HashSet();
        Set<Long> h2 = h(lVar);
        if (!h2.isEmpty()) {
            hashSet.addAll(this.f2164b.t(h2));
        }
        Iterator<Map.Entry<com.google.firebase.database.r.b, com.google.firebase.database.p.g0.d<Map<com.google.firebase.database.p.h0.h, h>>>> it = this.f2163a.D(lVar).w().iterator();
        while (it.hasNext()) {
            Map.Entry<com.google.firebase.database.r.b, com.google.firebase.database.p.g0.d<Map<com.google.firebase.database.p.h0.h, h>>> next = it.next();
            com.google.firebase.database.r.b key = next.getKey();
            com.google.firebase.database.p.g0.d<Map<com.google.firebase.database.p.h0.h, h>> value = next.getValue();
            if (value.getValue() != null && f.a(value.getValue())) {
                hashSet.add(key);
            }
        }
        return hashSet;
    }

    public boolean l(l lVar) {
        return this.f2163a.A(lVar, g) != null;
    }

    public boolean n(com.google.firebase.database.p.h0.i iVar) {
        Map<com.google.firebase.database.p.h0.h, h> s;
        if (m(iVar.e())) {
            return true;
        }
        return !iVar.g() && (s = this.f2163a.s(iVar.e())) != null && s.containsKey(iVar.d()) && s.get(iVar.d()).f2162d;
    }

    public g p(com.google.firebase.database.p.f0.a aVar) {
        List<h> k = k(h);
        long e2 = e(aVar, k.size());
        g gVar = new g();
        if (this.f2165c.f()) {
            com.google.firebase.database.q.c cVar = this.f2165c;
            cVar.b("Pruning old queries.  Prunable: " + k.size() + " Count to prune: " + e2, new Object[0]);
        }
        Collections.sort(k, new f(this));
        for (int i2 = 0; i2 < e2; i2++) {
            h hVar = k.get(i2);
            gVar = gVar.d(hVar.f2160b.e());
            q(hVar.f2160b);
        }
        for (int i3 = (int) e2; i3 < k.size(); i3++) {
            gVar = gVar.c(k.get(i3).f2160b.e());
        }
        List<h> k2 = k(i);
        if (this.f2165c.f()) {
            com.google.firebase.database.q.c cVar2 = this.f2165c;
            cVar2.b("Unprunable queries: " + k2.size(), new Object[0]);
        }
        for (h hVar2 : k2) {
            gVar = gVar.c(hVar2.f2160b.e());
        }
        return gVar;
    }

    public void q(com.google.firebase.database.p.h0.i iVar) {
        com.google.firebase.database.p.h0.i o = o(iVar);
        this.f2164b.g(i(o).f2159a);
        Map<com.google.firebase.database.p.h0.h, h> s = this.f2163a.s(o.e());
        s.remove(o.d());
        if (s.isEmpty()) {
            this.f2163a = this.f2163a.z(o.e());
        }
    }

    public void t(l lVar) {
        this.f2163a.D(lVar).m(new e());
    }

    public void u(com.google.firebase.database.p.h0.i iVar) {
        v(iVar, true);
    }

    public void w(com.google.firebase.database.p.h0.i iVar) {
        h i2 = i(o(iVar));
        if (i2 == null || i2.f2162d) {
            return;
        }
        s(i2.b());
    }

    public void x(com.google.firebase.database.p.h0.i iVar) {
        v(iVar, false);
    }
}
