package com.google.firebase.database.n;

import com.google.firebase.database.n.c;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class e<T> implements Iterable<T> {
    private final c<T, Void> f;

    /* loaded from: classes.dex */
    private static class a<T> implements Iterator<T> {
        final Iterator<Map.Entry<T, Void>> f;

        public a(Iterator<Map.Entry<T, Void>> it) {
            this.f = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f.next().getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f.remove();
        }
    }

    private e(c<T, Void> cVar) {
        this.f = cVar;
    }

    public e(List<T> list, Comparator<T> comparator) {
        this.f = c.a.a(list, Collections.emptyMap(), c.a.d(), comparator);
    }

    public T d() {
        return this.f.g();
    }

    public T e() {
        return this.f.i();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f.equals(((e) obj).f);
        }
        return false;
    }

    public T f(T t) {
        return this.f.l(t);
    }

    public e<T> g(T t) {
        return new e<>(this.f.s(t, null));
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public e<T> i(T t) {
        c<T, Void> u = this.f.u(t);
        return u == this.f ? this : new e<>(u);
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.f.iterator());
    }

    public Iterator<T> t() {
        return new a(this.f.t());
    }
}
