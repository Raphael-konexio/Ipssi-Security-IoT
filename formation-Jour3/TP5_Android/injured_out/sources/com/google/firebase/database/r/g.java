package com.google.firebase.database.r;

import com.google.firebase.database.r.n;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class g extends c implements n {
    private static final g j = new g();

    private g() {
    }

    public static g s() {
        return j;
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public int a() {
        return 0;
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public n b(b bVar) {
        return this;
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public n c() {
        return this;
    }

    @Override // com.google.firebase.database.r.c, java.lang.Comparable
    /* renamed from: e */
    public int compareTo(n nVar) {
        return nVar.isEmpty() ? 0 : -1;
    }

    @Override // com.google.firebase.database.r.c
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (nVar.isEmpty()) {
                c();
                if (equals(nVar.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public String getHash() {
        return "";
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public Object getValue() {
        return null;
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public n h(com.google.firebase.database.p.l lVar) {
        return this;
    }

    @Override // com.google.firebase.database.r.c
    public int hashCode() {
        return 0;
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public boolean isEmpty() {
        return true;
    }

    @Override // com.google.firebase.database.r.c, java.lang.Iterable
    public Iterator<m> iterator() {
        return Collections.emptyList().iterator();
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public /* bridge */ /* synthetic */ n j(n nVar) {
        u(nVar);
        return this;
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public boolean k() {
        return false;
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public b n(b bVar) {
        return null;
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public boolean o(b bVar) {
        return false;
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public n p(b bVar, n nVar) {
        return (nVar.isEmpty() || bVar.w()) ? this : new c().p(bVar, nVar);
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public n q(com.google.firebase.database.p.l lVar, n nVar) {
        if (lVar.isEmpty()) {
            return nVar;
        }
        b x = lVar.x();
        b(x);
        return p(x, q(lVar.A(), nVar));
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public Object r(boolean z) {
        return null;
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public Iterator<m> t() {
        return Collections.emptyList().iterator();
    }

    @Override // com.google.firebase.database.r.c
    public String toString() {
        return "<Empty Node>";
    }

    public g u(n nVar) {
        return this;
    }

    @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
    public String v(n.b bVar) {
        return "";
    }
}
