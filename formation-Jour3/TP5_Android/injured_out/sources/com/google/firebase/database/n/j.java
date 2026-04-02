package com.google.firebase.database.n;

import com.google.firebase.database.n.h;
import java.util.Comparator;
/* loaded from: classes.dex */
public abstract class j<K, V> implements h<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final K f2047a;

    /* renamed from: b  reason: collision with root package name */
    private final V f2048b;

    /* renamed from: c  reason: collision with root package name */
    private h<K, V> f2049c;

    /* renamed from: d  reason: collision with root package name */
    private final h<K, V> f2050d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(K k, V v, h<K, V> hVar, h<K, V> hVar2) {
        this.f2047a = k;
        this.f2048b = v;
        this.f2049c = hVar == null ? g.j() : hVar;
        this.f2050d = hVar2 == null ? g.j() : hVar2;
    }

    private j<K, V> j() {
        h<K, V> hVar = this.f2049c;
        h<K, V> e = hVar.e(null, null, q(hVar), null, null);
        h<K, V> hVar2 = this.f2050d;
        return e(null, null, q(this), e, hVar2.e(null, null, q(hVar2), null, null));
    }

    private j<K, V> m() {
        j<K, V> s = (!this.f2050d.c() || this.f2049c.c()) ? this : s();
        if (s.f2049c.c() && ((j) s.f2049c).f2049c.c()) {
            s = s.t();
        }
        return (s.f2049c.c() && s.f2050d.c()) ? s.j() : s;
    }

    private j<K, V> o() {
        j<K, V> j = j();
        return j.d().a().c() ? j.l(null, null, null, ((j) j.d()).t()).s().j() : j;
    }

    private j<K, V> p() {
        j<K, V> j = j();
        return j.a().a().c() ? j.t().j() : j;
    }

    private static h.a q(h hVar) {
        return hVar.c() ? h.a.BLACK : h.a.RED;
    }

    private h<K, V> r() {
        if (this.f2049c.isEmpty()) {
            return g.j();
        }
        j<K, V> o = (a().c() || a().a().c()) ? this : o();
        return o.l(null, null, ((j) o.f2049c).r(), null).m();
    }

    private j<K, V> s() {
        return (j) this.f2050d.e(null, null, n(), e(null, null, h.a.RED, null, ((j) this.f2050d).f2049c), null);
    }

    private j<K, V> t() {
        return (j) this.f2049c.e(null, null, n(), null, e(null, null, h.a.RED, ((j) this.f2049c).f2050d, null));
    }

    @Override // com.google.firebase.database.n.h
    public h<K, V> a() {
        return this.f2049c;
    }

    @Override // com.google.firebase.database.n.h
    public h<K, V> b(K k, V v, Comparator<K> comparator) {
        int compare = comparator.compare(k, this.f2047a);
        return (compare < 0 ? l(null, null, this.f2049c.b(k, v, comparator), null) : compare == 0 ? l(k, v, null, null) : l(null, null, null, this.f2050d.b(k, v, comparator))).m();
    }

    @Override // com.google.firebase.database.n.h
    public h<K, V> d() {
        return this.f2050d;
    }

    @Override // com.google.firebase.database.n.h
    public h<K, V> f(K k, Comparator<K> comparator) {
        j<K, V> l;
        if (comparator.compare(k, this.f2047a) < 0) {
            j<K, V> o = (this.f2049c.isEmpty() || this.f2049c.c() || ((j) this.f2049c).f2049c.c()) ? this : o();
            l = o.l(null, null, o.f2049c.f(k, comparator), null);
        } else {
            j<K, V> t = this.f2049c.c() ? t() : this;
            if (!t.f2050d.isEmpty() && !t.f2050d.c() && !((j) t.f2050d).f2049c.c()) {
                t = t.p();
            }
            if (comparator.compare(k, t.f2047a) == 0) {
                if (t.f2050d.isEmpty()) {
                    return g.j();
                }
                h<K, V> g = t.f2050d.g();
                t = t.l(g.getKey(), g.getValue(), null, ((j) t.f2050d).r());
            }
            l = t.l(null, null, null, t.f2050d.f(k, comparator));
        }
        return l.m();
    }

    @Override // com.google.firebase.database.n.h
    public h<K, V> g() {
        return this.f2049c.isEmpty() ? this : this.f2049c.g();
    }

    @Override // com.google.firebase.database.n.h
    public K getKey() {
        return this.f2047a;
    }

    @Override // com.google.firebase.database.n.h
    public V getValue() {
        return this.f2048b;
    }

    @Override // com.google.firebase.database.n.h
    public void h(h.b<K, V> bVar) {
        this.f2049c.h(bVar);
        bVar.a(this.f2047a, this.f2048b);
        this.f2050d.h(bVar);
    }

    @Override // com.google.firebase.database.n.h
    public h<K, V> i() {
        return this.f2050d.isEmpty() ? this : this.f2050d.i();
    }

    @Override // com.google.firebase.database.n.h
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.firebase.database.n.h
    /* renamed from: k */
    public j<K, V> e(K k, V v, h.a aVar, h<K, V> hVar, h<K, V> hVar2) {
        if (k == null) {
            k = this.f2047a;
        }
        if (v == null) {
            v = this.f2048b;
        }
        if (hVar == null) {
            hVar = this.f2049c;
        }
        if (hVar2 == null) {
            hVar2 = this.f2050d;
        }
        return aVar == h.a.RED ? new i(k, v, hVar, hVar2) : new f(k, v, hVar, hVar2);
    }

    protected abstract j<K, V> l(K k, V v, h<K, V> hVar, h<K, V> hVar2);

    protected abstract h.a n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(h<K, V> hVar) {
        this.f2049c = hVar;
    }
}
