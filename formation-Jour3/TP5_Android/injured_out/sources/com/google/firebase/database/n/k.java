package com.google.firebase.database.n;

import com.google.firebase.database.n.c;
import com.google.firebase.database.n.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class k<K, V> extends c<K, V> {
    private h<K, V> f;
    private Comparator<K> g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b<A, B, C> {

        /* renamed from: a  reason: collision with root package name */
        private final List<A> f2051a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<B, C> f2052b;

        /* renamed from: c  reason: collision with root package name */
        private final c.a.InterfaceC0093a<A, B> f2053c;

        /* renamed from: d  reason: collision with root package name */
        private j<A, C> f2054d;
        private j<A, C> e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a implements Iterable<C0095b> {
            private long f;
            private final int g;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.google.firebase.database.n.k$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0094a implements Iterator<C0095b> {
                private int f;

                C0094a() {
                    this.f = a.this.g - 1;
                }

                @Override // java.util.Iterator
                /* renamed from: a */
                public C0095b next() {
                    C0095b c0095b = new C0095b();
                    c0095b.f2055a = (a.this.f & ((long) (1 << this.f))) == 0;
                    c0095b.f2056b = (int) Math.pow(2.0d, this.f);
                    this.f--;
                    return c0095b;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f >= 0;
                }

                @Override // java.util.Iterator
                public void remove() {
                }
            }

            public a(int i) {
                int i2 = i + 1;
                int floor = (int) Math.floor(Math.log(i2) / Math.log(2.0d));
                this.g = floor;
                this.f = (((long) Math.pow(2.0d, floor)) - 1) & i2;
            }

            @Override // java.lang.Iterable
            public Iterator<C0095b> iterator() {
                return new C0094a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.firebase.database.n.k$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0095b {

            /* renamed from: a  reason: collision with root package name */
            public boolean f2055a;

            /* renamed from: b  reason: collision with root package name */
            public int f2056b;

            C0095b() {
            }
        }

        private b(List<A> list, Map<B, C> map, c.a.InterfaceC0093a<A, B> interfaceC0093a) {
            this.f2051a = list;
            this.f2052b = map;
            this.f2053c = interfaceC0093a;
        }

        private h<A, C> a(int i, int i2) {
            if (i2 == 0) {
                return g.j();
            }
            if (i2 == 1) {
                A a2 = this.f2051a.get(i);
                return new f(a2, d(a2), null, null);
            }
            int i3 = i2 / 2;
            int i4 = i + i3;
            h<A, C> a3 = a(i, i3);
            h<A, C> a4 = a(i4 + 1, i3);
            A a5 = this.f2051a.get(i4);
            return new f(a5, d(a5), a3, a4);
        }

        public static <A, B, C> k<A, C> b(List<A> list, Map<B, C> map, c.a.InterfaceC0093a<A, B> interfaceC0093a, Comparator<A> comparator) {
            b bVar = new b(list, map, interfaceC0093a);
            Collections.sort(list, comparator);
            Iterator<C0095b> it = new a(list.size()).iterator();
            int size = list.size();
            while (it.hasNext()) {
                C0095b next = it.next();
                int i = next.f2056b;
                size -= i;
                if (next.f2055a) {
                    bVar.c(h.a.BLACK, i, size);
                } else {
                    bVar.c(h.a.BLACK, i, size);
                    int i2 = next.f2056b;
                    size -= i2;
                    bVar.c(h.a.RED, i2, size);
                }
            }
            h hVar = bVar.f2054d;
            if (hVar == null) {
                hVar = g.j();
            }
            return new k<>(hVar, comparator);
        }

        private void c(h.a aVar, int i, int i2) {
            h<A, C> a2 = a(i2 + 1, i - 1);
            A a3 = this.f2051a.get(i2);
            j<A, C> iVar = aVar == h.a.RED ? new i<>(a3, d(a3), null, a2) : new f<>(a3, d(a3), null, a2);
            if (this.f2054d == null) {
                this.f2054d = iVar;
            } else {
                this.e.u(iVar);
            }
            this.e = iVar;
        }

        private C d(A a2) {
            Map<B, C> map = this.f2052b;
            this.f2053c.a(a2);
            return map.get(a2);
        }
    }

    private k(h<K, V> hVar, Comparator<K> comparator) {
        this.f = hVar;
        this.g = comparator;
    }

    public static <A, B, C> k<A, C> w(List<A> list, Map<B, C> map, c.a.InterfaceC0093a<A, B> interfaceC0093a, Comparator<A> comparator) {
        return b.b(list, map, interfaceC0093a, comparator);
    }

    public static <A, B> k<A, B> x(Map<A, B> map, Comparator<A> comparator) {
        return b.b(new ArrayList(map.keySet()), map, c.a.d(), comparator);
    }

    private h<K, V> y(K k) {
        h<K, V> hVar = this.f;
        while (!hVar.isEmpty()) {
            int compare = this.g.compare(k, hVar.getKey());
            if (compare < 0) {
                hVar = hVar.a();
            } else if (compare == 0) {
                return hVar;
            } else {
                hVar = hVar.d();
            }
        }
        return null;
    }

    @Override // com.google.firebase.database.n.c
    public boolean d(K k) {
        return y(k) != null;
    }

    @Override // com.google.firebase.database.n.c
    public V e(K k) {
        h<K, V> y = y(k);
        if (y != null) {
            return y.getValue();
        }
        return null;
    }

    @Override // com.google.firebase.database.n.c
    public Comparator<K> f() {
        return this.g;
    }

    @Override // com.google.firebase.database.n.c
    public K g() {
        return this.f.i().getKey();
    }

    @Override // com.google.firebase.database.n.c
    public K i() {
        return this.f.g().getKey();
    }

    @Override // com.google.firebase.database.n.c
    public boolean isEmpty() {
        return this.f.isEmpty();
    }

    @Override // com.google.firebase.database.n.c, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new d(this.f, null, this.g, false);
    }

    @Override // com.google.firebase.database.n.c
    public K l(K k) {
        h<K, V> hVar = this.f;
        h<K, V> hVar2 = null;
        while (!hVar.isEmpty()) {
            int compare = this.g.compare(k, hVar.getKey());
            if (compare == 0) {
                if (hVar.a().isEmpty()) {
                    if (hVar2 != null) {
                        return hVar2.getKey();
                    }
                    return null;
                }
                h<K, V> a2 = hVar.a();
                while (!a2.d().isEmpty()) {
                    a2 = a2.d();
                }
                return a2.getKey();
            } else if (compare < 0) {
                hVar = hVar.a();
            } else {
                hVar2 = hVar;
                hVar = hVar.d();
            }
        }
        throw new IllegalArgumentException("Couldn't find predecessor key of non-present key: " + k);
    }

    @Override // com.google.firebase.database.n.c
    public void m(h.b<K, V> bVar) {
        this.f.h(bVar);
    }

    @Override // com.google.firebase.database.n.c
    public c<K, V> s(K k, V v) {
        return new k(this.f.b(k, v, this.g).e(null, null, h.a.BLACK, null, null), this.g);
    }

    @Override // com.google.firebase.database.n.c
    public int size() {
        return this.f.size();
    }

    @Override // com.google.firebase.database.n.c
    public Iterator<Map.Entry<K, V>> t() {
        return new d(this.f, null, this.g, true);
    }

    @Override // com.google.firebase.database.n.c
    public c<K, V> u(K k) {
        return !d(k) ? this : new k(this.f.f(k, this.g).e(null, null, h.a.BLACK, null, null), this.g);
    }
}
