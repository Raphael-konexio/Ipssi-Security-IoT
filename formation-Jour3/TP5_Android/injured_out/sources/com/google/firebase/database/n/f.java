package com.google.firebase.database.n;

import com.google.firebase.database.n.h;
/* loaded from: classes.dex */
public class f<K, V> extends j<K, V> {
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(K k, V v, h<K, V> hVar, h<K, V> hVar2) {
        super(k, v, hVar, hVar2);
        this.e = -1;
    }

    @Override // com.google.firebase.database.n.h
    public boolean c() {
        return false;
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
        return new f(k, v, hVar, hVar2);
    }

    @Override // com.google.firebase.database.n.j
    protected h.a n() {
        return h.a.BLACK;
    }

    @Override // com.google.firebase.database.n.h
    public int size() {
        if (this.e == -1) {
            this.e = a().size() + 1 + d().size();
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.database.n.j
    public void u(h<K, V> hVar) {
        if (this.e != -1) {
            throw new IllegalStateException("Can't set left after using size");
        }
        super.u(hVar);
    }
}
