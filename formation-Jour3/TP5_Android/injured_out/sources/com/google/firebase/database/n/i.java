package com.google.firebase.database.n;

import com.google.firebase.database.n.h;
/* loaded from: classes.dex */
public class i<K, V> extends j<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(K k, V v) {
        super(k, v, g.j(), g.j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(K k, V v, h<K, V> hVar, h<K, V> hVar2) {
        super(k, v, hVar, hVar2);
    }

    @Override // com.google.firebase.database.n.h
    public boolean c() {
        return true;
    }

    @Override // com.google.firebase.database.n.j
    protected j<K, V> l(K k, V v, h<K, V> hVar, h<K, V> hVar2) {
        if (k == null) {
            k = getKey();
        }
        if (v == null) {
            v = getValue();
        }
        if (hVar == null) {
            hVar = a();
        }
        if (hVar2 == null) {
            hVar2 = d();
        }
        return new i(k, v, hVar, hVar2);
    }

    @Override // com.google.firebase.database.n.j
    protected h.a n() {
        return h.a.RED;
    }

    @Override // com.google.firebase.database.n.h
    public int size() {
        return a().size() + 1 + d().size();
    }
}
