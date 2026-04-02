package com.google.firebase.database.p;

import com.google.firebase.database.p.g0.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class b implements Iterable<Map.Entry<l, com.google.firebase.database.r.n>> {
    private static final b g = new b(new com.google.firebase.database.p.g0.d(null));
    private final com.google.firebase.database.p.g0.d<com.google.firebase.database.r.n> f;

    /* loaded from: classes.dex */
    class a implements d.c<com.google.firebase.database.r.n, b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f2118a;

        a(b bVar, l lVar) {
            this.f2118a = lVar;
        }

        @Override // com.google.firebase.database.p.g0.d.c
        /* renamed from: b */
        public b a(l lVar, com.google.firebase.database.r.n nVar, b bVar) {
            return bVar.d(this.f2118a.i(lVar), nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.database.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0101b implements d.c<com.google.firebase.database.r.n, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f2119a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f2120b;

        C0101b(b bVar, Map map, boolean z) {
            this.f2119a = map;
            this.f2120b = z;
        }

        @Override // com.google.firebase.database.p.g0.d.c
        /* renamed from: b */
        public Void a(l lVar, com.google.firebase.database.r.n nVar, Void r4) {
            this.f2119a.put(lVar.B(), nVar.r(this.f2120b));
            return null;
        }
    }

    private b(com.google.firebase.database.p.g0.d<com.google.firebase.database.r.n> dVar) {
        this.f = dVar;
    }

    private com.google.firebase.database.r.n i(l lVar, com.google.firebase.database.p.g0.d<com.google.firebase.database.r.n> dVar, com.google.firebase.database.r.n nVar) {
        if (dVar.getValue() != null) {
            return nVar.q(lVar, dVar.getValue());
        }
        com.google.firebase.database.r.n nVar2 = null;
        Iterator<Map.Entry<com.google.firebase.database.r.b, com.google.firebase.database.p.g0.d<com.google.firebase.database.r.n>>> it = dVar.w().iterator();
        while (it.hasNext()) {
            Map.Entry<com.google.firebase.database.r.b, com.google.firebase.database.p.g0.d<com.google.firebase.database.r.n>> next = it.next();
            com.google.firebase.database.p.g0.d<com.google.firebase.database.r.n> value = next.getValue();
            com.google.firebase.database.r.b key = next.getKey();
            if (key.w()) {
                nVar2 = value.getValue();
            } else {
                nVar = i(lVar.l(key), value, nVar);
            }
        }
        return (nVar.h(lVar).isEmpty() || nVar2 == null) ? nVar : nVar.q(lVar.l(com.google.firebase.database.r.b.m()), nVar2);
    }

    public static b s() {
        return g;
    }

    public static b u(Map<l, com.google.firebase.database.r.n> map) {
        com.google.firebase.database.p.g0.d e = com.google.firebase.database.p.g0.d.e();
        for (Map.Entry<l, com.google.firebase.database.r.n> entry : map.entrySet()) {
            e = e.C(entry.getKey(), new com.google.firebase.database.p.g0.d(entry.getValue()));
        }
        return new b(e);
    }

    public static b w(Map<String, Object> map) {
        com.google.firebase.database.p.g0.d e = com.google.firebase.database.p.g0.d.e();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            e = e.C(new l(entry.getKey()), new com.google.firebase.database.p.g0.d(com.google.firebase.database.r.o.a(entry.getValue())));
        }
        return new b(e);
    }

    public boolean A(l lVar) {
        return y(lVar) != null;
    }

    public b B(l lVar) {
        return lVar.isEmpty() ? g : new b(this.f.C(lVar, com.google.firebase.database.p.g0.d.e()));
    }

    public com.google.firebase.database.r.n C() {
        return this.f.getValue();
    }

    public b d(l lVar, com.google.firebase.database.r.n nVar) {
        if (lVar.isEmpty()) {
            return new b(new com.google.firebase.database.p.g0.d(nVar));
        }
        l g2 = this.f.g(lVar);
        if (g2 == null) {
            return new b(this.f.C(lVar, new com.google.firebase.database.p.g0.d<>(nVar)));
        }
        l z = l.z(g2, lVar);
        com.google.firebase.database.r.n s = this.f.s(g2);
        com.google.firebase.database.r.b u = z.u();
        if (u != null && u.w() && s.h(z.y()).isEmpty()) {
            return this;
        }
        return new b(this.f.B(g2, s.q(z, nVar)));
    }

    public b e(com.google.firebase.database.r.b bVar, com.google.firebase.database.r.n nVar) {
        return d(new l(bVar), nVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != b.class) {
            return false;
        }
        return ((b) obj).z(true).equals(z(true));
    }

    public b f(l lVar, b bVar) {
        return (b) bVar.f.l(this, new a(this, lVar));
    }

    public com.google.firebase.database.r.n g(com.google.firebase.database.r.n nVar) {
        return i(l.w(), this.f, nVar);
    }

    public int hashCode() {
        return z(true).hashCode();
    }

    public boolean isEmpty() {
        return this.f.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<l, com.google.firebase.database.r.n>> iterator() {
        return this.f.iterator();
    }

    public b l(l lVar) {
        if (lVar.isEmpty()) {
            return this;
        }
        com.google.firebase.database.r.n y = y(lVar);
        return y != null ? new b(new com.google.firebase.database.p.g0.d(y)) : new b(this.f.D(lVar));
    }

    public Map<com.google.firebase.database.r.b, b> m() {
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<com.google.firebase.database.r.b, com.google.firebase.database.p.g0.d<com.google.firebase.database.r.n>>> it = this.f.w().iterator();
        while (it.hasNext()) {
            Map.Entry<com.google.firebase.database.r.b, com.google.firebase.database.p.g0.d<com.google.firebase.database.r.n>> next = it.next();
            hashMap.put(next.getKey(), new b(next.getValue()));
        }
        return hashMap;
    }

    public String toString() {
        return "CompoundWrite{" + z(true).toString() + "}";
    }

    public List<com.google.firebase.database.r.m> x() {
        ArrayList arrayList = new ArrayList();
        if (this.f.getValue() != null) {
            for (com.google.firebase.database.r.m mVar : this.f.getValue()) {
                arrayList.add(new com.google.firebase.database.r.m(mVar.c(), mVar.d()));
            }
        } else {
            Iterator<Map.Entry<com.google.firebase.database.r.b, com.google.firebase.database.p.g0.d<com.google.firebase.database.r.n>>> it = this.f.w().iterator();
            while (it.hasNext()) {
                Map.Entry<com.google.firebase.database.r.b, com.google.firebase.database.p.g0.d<com.google.firebase.database.r.n>> next = it.next();
                com.google.firebase.database.p.g0.d<com.google.firebase.database.r.n> value = next.getValue();
                if (value.getValue() != null) {
                    arrayList.add(new com.google.firebase.database.r.m(next.getKey(), value.getValue()));
                }
            }
        }
        return arrayList;
    }

    public com.google.firebase.database.r.n y(l lVar) {
        l g2 = this.f.g(lVar);
        if (g2 != null) {
            return this.f.s(g2).h(l.z(g2, lVar));
        }
        return null;
    }

    public Map<String, Object> z(boolean z) {
        HashMap hashMap = new HashMap();
        this.f.m(new C0101b(this, hashMap, z));
        return hashMap;
    }
}
