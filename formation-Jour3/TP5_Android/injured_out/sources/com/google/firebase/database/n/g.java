package com.google.firebase.database.n;

import com.google.firebase.database.n.h;
import java.util.Comparator;
/* loaded from: classes.dex */
public class g<K, V> implements h<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private static final g f2046a = new g();

    private g() {
    }

    public static <K, V> g<K, V> j() {
        return f2046a;
    }

    @Override // com.google.firebase.database.n.h
    public h<K, V> a() {
        return this;
    }

    @Override // com.google.firebase.database.n.h
    public h<K, V> b(K k, V v, Comparator<K> comparator) {
        return new i(k, v);
    }

    @Override // com.google.firebase.database.n.h
    public boolean c() {
        return false;
    }

    @Override // com.google.firebase.database.n.h
    public h<K, V> d() {
        return this;
    }

    @Override // com.google.firebase.database.n.h
    public h<K, V> e(K k, V v, h.a aVar, h<K, V> hVar, h<K, V> hVar2) {
        return this;
    }

    @Override // com.google.firebase.database.n.h
    public h<K, V> f(K k, Comparator<K> comparator) {
        return this;
    }

    @Override // com.google.firebase.database.n.h
    public h<K, V> g() {
        return this;
    }

    @Override // com.google.firebase.database.n.h
    public K getKey() {
        return null;
    }

    @Override // com.google.firebase.database.n.h
    public V getValue() {
        return null;
    }

    @Override // com.google.firebase.database.n.h
    public void h(h.b<K, V> bVar) {
    }

    @Override // com.google.firebase.database.n.h
    public h<K, V> i() {
        return this;
    }

    @Override // com.google.firebase.database.n.h
    public boolean isEmpty() {
        return true;
    }

    @Override // com.google.firebase.database.n.h
    public int size() {
        return 0;
    }
}
