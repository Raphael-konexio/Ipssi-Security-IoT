package com.google.firebase.database.n;

import java.util.Comparator;
/* loaded from: classes.dex */
public interface h<K, V> {

    /* loaded from: classes.dex */
    public enum a {
        RED,
        BLACK
    }

    /* loaded from: classes.dex */
    public static abstract class b<K, V> {
        public abstract void a(K k, V v);
    }

    h<K, V> a();

    h<K, V> b(K k, V v, Comparator<K> comparator);

    boolean c();

    h<K, V> d();

    h<K, V> e(K k, V v, a aVar, h<K, V> hVar, h<K, V> hVar2);

    h<K, V> f(K k, Comparator<K> comparator);

    h<K, V> g();

    K getKey();

    V getValue();

    void h(b<K, V> bVar);

    h<K, V> i();

    boolean isEmpty();

    int size();
}
