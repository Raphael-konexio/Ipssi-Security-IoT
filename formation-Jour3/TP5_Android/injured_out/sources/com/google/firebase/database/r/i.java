package com.google.firebase.database.r;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class i implements Iterable<m> {
    private static final com.google.firebase.database.n.e<m> i = new com.google.firebase.database.n.e<>(Collections.emptyList(), null);
    private final n f;
    private com.google.firebase.database.n.e<m> g;
    private final h h;

    private i(n nVar, h hVar) {
        this.h = hVar;
        this.f = nVar;
        this.g = null;
    }

    private i(n nVar, h hVar, com.google.firebase.database.n.e<m> eVar) {
        this.h = hVar;
        this.f = nVar;
        this.g = eVar;
    }

    private void d() {
        if (this.g == null) {
            if (!this.h.equals(j.j())) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (m mVar : this.f) {
                    z = z || this.h.e(mVar.d());
                    arrayList.add(new m(mVar.c(), mVar.d()));
                }
                if (z) {
                    this.g = new com.google.firebase.database.n.e<>(arrayList, this.h);
                    return;
                }
            }
            this.g = i;
        }
    }

    public static i e(n nVar) {
        return new i(nVar, q.j());
    }

    public static i f(n nVar, h hVar) {
        return new i(nVar, hVar);
    }

    public m g() {
        if (this.f instanceof c) {
            d();
            if (com.google.android.gms.common.internal.q.a(this.g, i)) {
                b i2 = ((c) this.f).i();
                return new m(i2, this.f.b(i2));
            }
            return this.g.e();
        }
        return null;
    }

    public m i() {
        if (this.f instanceof c) {
            d();
            if (com.google.android.gms.common.internal.q.a(this.g, i)) {
                b l = ((c) this.f).l();
                return new m(l, this.f.b(l));
            }
            return this.g.d();
        }
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<m> iterator() {
        d();
        return com.google.android.gms.common.internal.q.a(this.g, i) ? this.f.iterator() : this.g.iterator();
    }

    public n l() {
        return this.f;
    }

    public b m(b bVar, n nVar, h hVar) {
        if (this.h.equals(j.j()) || this.h.equals(hVar)) {
            d();
            if (com.google.android.gms.common.internal.q.a(this.g, i)) {
                return this.f.n(bVar);
            }
            m f = this.g.f(new m(bVar, nVar));
            if (f != null) {
                return f.c();
            }
            return null;
        }
        throw new IllegalArgumentException("Index not available in IndexedNode!");
    }

    public i s(b bVar, n nVar) {
        n p = this.f.p(bVar, nVar);
        if (!com.google.android.gms.common.internal.q.a(this.g, i) || this.h.e(nVar)) {
            com.google.firebase.database.n.e<m> eVar = this.g;
            if (eVar == null || com.google.android.gms.common.internal.q.a(eVar, i)) {
                return new i(p, this.h, null);
            }
            com.google.firebase.database.n.e<m> i2 = this.g.i(new m(bVar, this.f.b(bVar)));
            if (!nVar.isEmpty()) {
                i2 = i2.g(new m(bVar, nVar));
            }
            return new i(p, this.h, i2);
        }
        return new i(p, this.h, i);
    }

    public Iterator<m> t() {
        d();
        return com.google.android.gms.common.internal.q.a(this.g, i) ? this.f.t() : this.g.t();
    }

    public i u(n nVar) {
        return new i(this.f.j(nVar), this.h, this.g);
    }
}
