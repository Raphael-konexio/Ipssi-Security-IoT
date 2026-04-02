package a.b.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    c<K, V> f;
    private c<K, V> g;
    private WeakHashMap<f<K, V>, Boolean> h = new WeakHashMap<>();
    private int i = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // a.b.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.i;
        }

        @Override // a.b.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.h;
        }
    }

    /* renamed from: a.b.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0003b<K, V> extends e<K, V> {
        C0003b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // a.b.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.h;
        }

        @Override // a.b.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        final K f;
        final V g;
        c<K, V> h;
        c<K, V> i;

        c(K k, V v) {
            this.f = k;
            this.g = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.f.equals(cVar.f) && this.g.equals(cVar.g);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f.hashCode() ^ this.g.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f + "=" + this.g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {
        private c<K, V> f;
        private boolean g = true;

        d() {
        }

        @Override // a.b.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.i;
                this.f = cVar3;
                this.g = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.g) {
                this.g = false;
                cVar = b.this.f;
            } else {
                c<K, V> cVar2 = this.f;
                cVar = cVar2 != null ? cVar2.h : null;
            }
            this.f = cVar;
            return this.f;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.g) {
                return b.this.f != null;
            }
            c<K, V> cVar = this.f;
            return (cVar == null || cVar.h == null) ? false : true;
        }
    }

    /* loaded from: classes.dex */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {
        c<K, V> f;
        c<K, V> g;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f = cVar2;
            this.g = cVar;
        }

        private c<K, V> e() {
            c<K, V> cVar = this.g;
            c<K, V> cVar2 = this.f;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // a.b.a.b.b.f
        public void a(c<K, V> cVar) {
            if (this.f == cVar && cVar == this.g) {
                this.g = null;
                this.f = null;
            }
            c<K, V> cVar2 = this.f;
            if (cVar2 == cVar) {
                this.f = b(cVar2);
            }
            if (this.g == cVar) {
                this.g = e();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: d */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.g;
            this.g = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.g != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> d() {
        C0003b c0003b = new C0003b(this.g, this.f);
        this.h.put(c0003b, Boolean.FALSE);
        return c0003b;
    }

    public Map.Entry<K, V> e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (size() != bVar.size()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    protected c<K, V> f(K k) {
        c<K, V> cVar = this.f;
        while (cVar != null && !cVar.f.equals(k)) {
            cVar = cVar.h;
        }
        return cVar;
    }

    public b<K, V>.d g() {
        b<K, V>.d dVar = new d();
        this.h.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    public Map.Entry<K, V> i() {
        return this.g;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f, this.g);
        this.h.put(aVar, Boolean.FALSE);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> l(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.i++;
        c<K, V> cVar2 = this.g;
        if (cVar2 == null) {
            this.f = cVar;
        } else {
            cVar2.h = cVar;
            cVar.i = cVar2;
        }
        this.g = cVar;
        return cVar;
    }

    public V m(K k, V v) {
        c<K, V> f2 = f(k);
        if (f2 != null) {
            return f2.g;
        }
        l(k, v);
        return null;
    }

    public V s(K k) {
        c<K, V> f2 = f(k);
        if (f2 == null) {
            return null;
        }
        this.i--;
        if (!this.h.isEmpty()) {
            for (f<K, V> fVar : this.h.keySet()) {
                fVar.a(f2);
            }
        }
        c<K, V> cVar = f2.i;
        if (cVar != null) {
            cVar.h = f2.h;
        } else {
            this.f = f2.h;
        }
        c<K, V> cVar2 = f2.h;
        if (cVar2 != null) {
            cVar2.i = f2.i;
        } else {
            this.g = f2.i;
        }
        f2.h = null;
        f2.i = null;
        return f2.g;
    }

    public int size() {
        return this.i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
