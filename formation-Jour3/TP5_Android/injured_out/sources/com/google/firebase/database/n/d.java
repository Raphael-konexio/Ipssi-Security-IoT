package com.google.firebase.database.n;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public class d<K, V> implements Iterator<Map.Entry<K, V>> {
    private final ArrayDeque<j<K, V>> f = new ArrayDeque<>();
    private final boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(h<K, V> hVar, K k, Comparator<K> comparator, boolean z) {
        int i;
        this.g = z;
        while (!hVar.isEmpty()) {
            if (k != null) {
                K key = hVar.getKey();
                i = z ? comparator.compare(k, key) : comparator.compare(key, k);
            } else {
                i = 1;
            }
            if (i < 0) {
                hVar = z ? hVar.a() : hVar.d();
            } else if (i == 0) {
                this.f.push((j) hVar);
                return;
            } else {
                this.f.push((j) hVar);
                if (z) {
                }
            }
        }
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public Map.Entry<K, V> next() {
        try {
            j<K, V> pop = this.f.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(pop.getKey(), pop.getValue());
            if (this.g) {
                for (h<K, V> a2 = pop.a(); !a2.isEmpty(); a2 = a2.d()) {
                    this.f.push((j) a2);
                }
            } else {
                for (h<K, V> d2 = pop.d(); !d2.isEmpty(); d2 = d2.a()) {
                    this.f.push((j) d2);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException unused) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f.size() > 0;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
