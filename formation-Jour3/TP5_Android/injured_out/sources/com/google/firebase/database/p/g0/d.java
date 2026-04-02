package com.google.firebase.database.p.g0;

import com.google.firebase.database.n.c;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class d<T> implements Iterable<Map.Entry<com.google.firebase.database.p.l, T>> {
    private static final com.google.firebase.database.n.c h;
    private static final d i;
    private final T f;
    private final com.google.firebase.database.n.c<com.google.firebase.database.r.b, d<T>> g;

    /* loaded from: classes.dex */
    class a implements c<T, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f2178a;

        a(d dVar, ArrayList arrayList) {
            this.f2178a = arrayList;
        }

        @Override // com.google.firebase.database.p.g0.d.c
        /* renamed from: b */
        public Void a(com.google.firebase.database.p.l lVar, T t, Void r3) {
            this.f2178a.add(t);
            return null;
        }
    }

    /* loaded from: classes.dex */
    class b implements c<T, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f2179a;

        b(d dVar, List list) {
            this.f2179a = list;
        }

        @Override // com.google.firebase.database.p.g0.d.c
        /* renamed from: b */
        public Void a(com.google.firebase.database.p.l lVar, T t, Void r4) {
            this.f2179a.add(new AbstractMap.SimpleImmutableEntry(lVar, t));
            return null;
        }
    }

    /* loaded from: classes.dex */
    public interface c<T, R> {
        R a(com.google.firebase.database.p.l lVar, T t, R r);
    }

    static {
        com.google.firebase.database.n.c b2 = c.a.b(com.google.firebase.database.n.l.b(com.google.firebase.database.r.b.class));
        h = b2;
        i = new d(null, b2);
    }

    public d(T t) {
        this(t, h);
    }

    public d(T t, com.google.firebase.database.n.c<com.google.firebase.database.r.b, d<T>> cVar) {
        this.f = t;
        this.g = cVar;
    }

    public static <V> d<V> e() {
        return i;
    }

    private <R> R i(com.google.firebase.database.p.l lVar, c<? super T, R> cVar, R r) {
        Iterator<Map.Entry<com.google.firebase.database.r.b, d<T>>> it = this.g.iterator();
        while (it.hasNext()) {
            Map.Entry<com.google.firebase.database.r.b, d<T>> next = it.next();
            r = (R) next.getValue().i(lVar.l(next.getKey()), cVar, r);
        }
        Object obj = this.f;
        return obj != null ? cVar.a(lVar, obj, r) : r;
    }

    public T A(com.google.firebase.database.p.l lVar, i<? super T> iVar) {
        Object obj = (T) this.f;
        if (obj == null || !iVar.a(obj)) {
            Iterator<com.google.firebase.database.r.b> it = lVar.iterator();
            d<T> dVar = this;
            while (it.hasNext()) {
                dVar = dVar.g.e(it.next());
                if (dVar == null) {
                    return null;
                }
                Object obj2 = (T) dVar.f;
                if (obj2 != null && iVar.a(obj2)) {
                    return dVar.f;
                }
            }
            return null;
        }
        return this.f;
    }

    public d<T> B(com.google.firebase.database.p.l lVar, T t) {
        if (lVar.isEmpty()) {
            return new d<>(t, this.g);
        }
        com.google.firebase.database.r.b x = lVar.x();
        d<T> e = this.g.e(x);
        if (e == null) {
            e = e();
        }
        return new d<>(this.f, this.g.s(x, e.B(lVar.A(), t)));
    }

    public d<T> C(com.google.firebase.database.p.l lVar, d<T> dVar) {
        if (lVar.isEmpty()) {
            return dVar;
        }
        com.google.firebase.database.r.b x = lVar.x();
        d<T> e = this.g.e(x);
        if (e == null) {
            e = e();
        }
        d<T> C = e.C(lVar.A(), dVar);
        return new d<>(this.f, C.isEmpty() ? this.g.u(x) : this.g.s(x, C));
    }

    public d<T> D(com.google.firebase.database.p.l lVar) {
        if (lVar.isEmpty()) {
            return this;
        }
        d<T> e = this.g.e(lVar.x());
        return e != null ? e.D(lVar.A()) : e();
    }

    public Collection<T> E() {
        ArrayList arrayList = new ArrayList();
        m(new a(this, arrayList));
        return arrayList;
    }

    public boolean d(i<? super T> iVar) {
        Object obj = (T) this.f;
        if (obj == null || !iVar.a(obj)) {
            Iterator<Map.Entry<com.google.firebase.database.r.b, d<T>>> it = this.g.iterator();
            while (it.hasNext()) {
                if (it.next().getValue().d(iVar)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        com.google.firebase.database.n.c<com.google.firebase.database.r.b, d<T>> cVar = this.g;
        if (cVar == null ? dVar.g == null : cVar.equals(dVar.g)) {
            T t = this.f;
            T t2 = dVar.f;
            return t == null ? t2 == null : t.equals(t2);
        }
        return false;
    }

    public com.google.firebase.database.p.l f(com.google.firebase.database.p.l lVar, i<? super T> iVar) {
        com.google.firebase.database.r.b x;
        d<T> e;
        com.google.firebase.database.p.l f;
        Object obj = (T) this.f;
        if (obj == null || !iVar.a(obj)) {
            if (lVar.isEmpty() || (e = this.g.e((x = lVar.x()))) == null || (f = e.f(lVar.A(), iVar)) == null) {
                return null;
            }
            return new com.google.firebase.database.p.l(x).i(f);
        }
        return com.google.firebase.database.p.l.w();
    }

    public com.google.firebase.database.p.l g(com.google.firebase.database.p.l lVar) {
        return f(lVar, i.f2186a);
    }

    public T getValue() {
        return this.f;
    }

    public int hashCode() {
        T t = this.f;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        com.google.firebase.database.n.c<com.google.firebase.database.r.b, d<T>> cVar = this.g;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public boolean isEmpty() {
        return this.f == null && this.g.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<com.google.firebase.database.p.l, T>> iterator() {
        ArrayList arrayList = new ArrayList();
        m(new b(this, arrayList));
        return arrayList.iterator();
    }

    public <R> R l(R r, c<? super T, R> cVar) {
        return (R) i(com.google.firebase.database.p.l.w(), cVar, r);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void m(c<T, Void> cVar) {
        i(com.google.firebase.database.p.l.w(), cVar, null);
    }

    public T s(com.google.firebase.database.p.l lVar) {
        if (lVar.isEmpty()) {
            return this.f;
        }
        d<T> e = this.g.e(lVar.x());
        if (e != null) {
            return e.s(lVar.A());
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableTree { value=");
        sb.append(getValue());
        sb.append(", children={");
        Iterator<Map.Entry<com.google.firebase.database.r.b, d<T>>> it = this.g.iterator();
        while (it.hasNext()) {
            Map.Entry<com.google.firebase.database.r.b, d<T>> next = it.next();
            sb.append(next.getKey().e());
            sb.append("=");
            sb.append(next.getValue());
        }
        sb.append("} }");
        return sb.toString();
    }

    public d<T> u(com.google.firebase.database.r.b bVar) {
        d<T> e = this.g.e(bVar);
        return e != null ? e : e();
    }

    public com.google.firebase.database.n.c<com.google.firebase.database.r.b, d<T>> w() {
        return this.g;
    }

    public T x(com.google.firebase.database.p.l lVar) {
        return y(lVar, i.f2186a);
    }

    public T y(com.google.firebase.database.p.l lVar, i<? super T> iVar) {
        Object obj = (T) this.f;
        T t = (obj == null || !iVar.a(obj)) ? null : this.f;
        Iterator<com.google.firebase.database.r.b> it = lVar.iterator();
        d<T> dVar = this;
        while (it.hasNext()) {
            dVar = dVar.g.e(it.next());
            if (dVar == null) {
                return t;
            }
            Object obj2 = (T) dVar.f;
            if (obj2 != null && iVar.a(obj2)) {
                t = dVar.f;
            }
        }
        return t;
    }

    public d<T> z(com.google.firebase.database.p.l lVar) {
        if (lVar.isEmpty()) {
            return this.g.isEmpty() ? e() : new d<>(null, this.g);
        }
        com.google.firebase.database.r.b x = lVar.x();
        d<T> e = this.g.e(x);
        if (e != null) {
            d<T> z = e.z(lVar.A());
            com.google.firebase.database.n.c<com.google.firebase.database.r.b, d<T>> u = z.isEmpty() ? this.g.u(x) : this.g.s(x, z);
            return (this.f == null && u.isEmpty()) ? e() : new d<>(this.f, u);
        }
        return this;
    }
}
