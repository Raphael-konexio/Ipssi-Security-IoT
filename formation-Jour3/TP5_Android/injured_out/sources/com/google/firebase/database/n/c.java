package com.google.firebase.database.n;

import com.google.firebase.database.n.h;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class c<K, V> implements Iterable<Map.Entry<K, V>> {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final InterfaceC0093a f2045a = b.b();

        /* renamed from: com.google.firebase.database.n.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0093a<C, D> {
            D a(C c2);
        }

        public static <A, B, C> c<A, C> a(List<A> list, Map<B, C> map, InterfaceC0093a<A, B> interfaceC0093a, Comparator<A> comparator) {
            return list.size() < 25 ? com.google.firebase.database.n.a.z(list, map, interfaceC0093a, comparator) : k.w(list, map, interfaceC0093a, comparator);
        }

        public static <K, V> c<K, V> b(Comparator<K> comparator) {
            return new com.google.firebase.database.n.a(comparator);
        }

        public static <A, B> c<A, B> c(Map<A, B> map, Comparator<A> comparator) {
            return map.size() < 25 ? com.google.firebase.database.n.a.C(map, comparator) : k.x(map, comparator);
        }

        public static <A> InterfaceC0093a<A, A> d() {
            return f2045a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Object e(Object obj) {
            return obj;
        }
    }

    public abstract boolean d(K k);

    public abstract V e(K k);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (f().equals(cVar.f()) && size() == cVar.size()) {
                Iterator<Map.Entry<K, V>> it = iterator();
                Iterator<Map.Entry<K, V>> it2 = cVar.iterator();
                while (it.hasNext()) {
                    if (!it.next().equals(it2.next())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public abstract Comparator<K> f();

    public abstract K g();

    public int hashCode() {
        int hashCode = f().hashCode();
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            hashCode = (hashCode * 31) + it.next().hashCode();
        }
        return hashCode;
    }

    public abstract K i();

    public abstract boolean isEmpty();

    @Override // java.lang.Iterable
    public abstract Iterator<Map.Entry<K, V>> iterator();

    public abstract K l(K k);

    public abstract void m(h.b<K, V> bVar);

    public abstract c<K, V> s(K k, V v);

    public abstract int size();

    public abstract Iterator<Map.Entry<K, V>> t();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        Iterator<Map.Entry<K, V>> it = iterator();
        boolean z = true;
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append("(");
            sb.append(next.getKey());
            sb.append("=>");
            sb.append(next.getValue());
            sb.append(")");
        }
        sb.append("};");
        return sb.toString();
    }

    public abstract c<K, V> u(K k);
}
