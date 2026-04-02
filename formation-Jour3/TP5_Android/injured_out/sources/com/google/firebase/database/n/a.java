package com.google.firebase.database.n;

import com.google.firebase.database.n.c;
import com.google.firebase.database.n.h;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class a<K, V> extends c<K, V> {
    private final K[] f;
    private final V[] g;
    private final Comparator<K> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.database.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0092a implements Iterator<Map.Entry<K, V>> {
        int f;
        final /* synthetic */ int g;
        final /* synthetic */ boolean h;

        C0092a(int i, boolean z) {
            this.g = i;
            this.h = z;
            this.f = this.g;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            Object obj = a.this.f[this.f];
            Object[] objArr = a.this.g;
            int i = this.f;
            Object obj2 = objArr[i];
            this.f = this.h ? i - 1 : i + 1;
            return new AbstractMap.SimpleImmutableEntry(obj, obj2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.h) {
                if (this.f >= 0) {
                    return true;
                }
            } else if (this.f < a.this.f.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
        }
    }

    public a(Comparator<K> comparator) {
        this.f = (K[]) new Object[0];
        this.g = (V[]) new Object[0];
        this.h = comparator;
    }

    private a(Comparator<K> comparator, K[] kArr, V[] vArr) {
        this.f = kArr;
        this.g = vArr;
        this.h = comparator;
    }

    private int A(K k) {
        int i = 0;
        for (K k2 : this.f) {
            if (this.h.compare(k, k2) == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int B(K k) {
        int i = 0;
        while (true) {
            K[] kArr = this.f;
            if (i >= kArr.length || this.h.compare(kArr[i], k) >= 0) {
                break;
            }
            i++;
        }
        return i;
    }

    public static <K, V> a<K, V> C(Map<K, V> map, Comparator<K> comparator) {
        return z(new ArrayList(map.keySet()), map, c.a.d(), comparator);
    }

    private Iterator<Map.Entry<K, V>> D(int i, boolean z) {
        return new C0092a(i, z);
    }

    private static <T> T[] E(T[] tArr, int i) {
        int length = tArr.length - 1;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i);
        System.arraycopy(tArr, i + 1, tArr2, i, length - i);
        return tArr2;
    }

    private static <T> T[] F(T[] tArr, int i, T t) {
        int length = tArr.length;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, length);
        tArr2[i] = t;
        return tArr2;
    }

    private static <T> T[] y(T[] tArr, int i, T t) {
        int length = tArr.length + 1;
        T[] tArr2 = (T[]) new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i);
        tArr2[i] = t;
        System.arraycopy(tArr, i, tArr2, i + 1, (length - i) - 1);
        return tArr2;
    }

    public static <A, B, C> a<A, C> z(List<A> list, Map<B, C> map, c.a.InterfaceC0093a<A, B> interfaceC0093a, Comparator<A> comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        int i = 0;
        for (A a2 : list) {
            objArr[i] = a2;
            interfaceC0093a.a(a2);
            objArr2[i] = map.get(a2);
            i++;
        }
        return new a<>(comparator, objArr, objArr2);
    }

    @Override // com.google.firebase.database.n.c
    public boolean d(K k) {
        return A(k) != -1;
    }

    @Override // com.google.firebase.database.n.c
    public V e(K k) {
        int A = A(k);
        if (A != -1) {
            return this.g[A];
        }
        return null;
    }

    @Override // com.google.firebase.database.n.c
    public Comparator<K> f() {
        return this.h;
    }

    @Override // com.google.firebase.database.n.c
    public K g() {
        K[] kArr = this.f;
        if (kArr.length > 0) {
            return kArr[kArr.length - 1];
        }
        return null;
    }

    @Override // com.google.firebase.database.n.c
    public K i() {
        K[] kArr = this.f;
        if (kArr.length > 0) {
            return kArr[0];
        }
        return null;
    }

    @Override // com.google.firebase.database.n.c
    public boolean isEmpty() {
        return this.f.length == 0;
    }

    @Override // com.google.firebase.database.n.c, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return D(0, false);
    }

    @Override // com.google.firebase.database.n.c
    public K l(K k) {
        int A = A(k);
        if (A != -1) {
            if (A > 0) {
                return this.f[A - 1];
            }
            return null;
        }
        throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
    }

    @Override // com.google.firebase.database.n.c
    public void m(h.b<K, V> bVar) {
        int i = 0;
        while (true) {
            K[] kArr = this.f;
            if (i >= kArr.length) {
                return;
            }
            bVar.a(kArr[i], this.g[i]);
            i++;
        }
    }

    @Override // com.google.firebase.database.n.c
    public c<K, V> s(K k, V v) {
        int A = A(k);
        if (A != -1) {
            if (this.f[A] == k && this.g[A] == v) {
                return this;
            }
            return new a(this.h, F(this.f, A, k), F(this.g, A, v));
        } else if (this.f.length <= 25) {
            int B = B(k);
            return new a(this.h, y(this.f, B, k), y(this.g, B, v));
        } else {
            HashMap hashMap = new HashMap(this.f.length + 1);
            int i = 0;
            while (true) {
                K[] kArr = this.f;
                if (i >= kArr.length) {
                    hashMap.put(k, v);
                    return k.x(hashMap, this.h);
                }
                hashMap.put(kArr[i], this.g[i]);
                i++;
            }
        }
    }

    @Override // com.google.firebase.database.n.c
    public int size() {
        return this.f.length;
    }

    @Override // com.google.firebase.database.n.c
    public Iterator<Map.Entry<K, V>> t() {
        return D(this.f.length - 1, true);
    }

    @Override // com.google.firebase.database.n.c
    public c<K, V> u(K k) {
        int A = A(k);
        if (A == -1) {
            return this;
        }
        return new a(this.h, E(this.f, A), E(this.g, A));
    }
}
