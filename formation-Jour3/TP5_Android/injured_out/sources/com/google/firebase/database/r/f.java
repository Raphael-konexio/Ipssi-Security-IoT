package com.google.firebase.database.r;

import com.google.firebase.database.r.k;
import com.google.firebase.database.r.n;
/* loaded from: classes.dex */
public class f extends k<f> {
    private final Double h;

    public f(Double d2, n nVar) {
        super(nVar);
        this.h = d2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.h.equals(fVar.h) && this.f.equals(fVar.f);
        }
        return false;
    }

    @Override // com.google.firebase.database.r.k
    protected k.b g() {
        return k.b.Number;
    }

    @Override // com.google.firebase.database.r.n
    public Object getValue() {
        return this.h;
    }

    public int hashCode() {
        return this.h.hashCode() + this.f.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.database.r.k
    /* renamed from: m */
    public int d(f fVar) {
        return this.h.compareTo(fVar.h);
    }

    @Override // com.google.firebase.database.r.n
    /* renamed from: s */
    public f j(n nVar) {
        return new f(this.h, nVar);
    }

    @Override // com.google.firebase.database.r.n
    public String v(n.b bVar) {
        return (i(bVar) + "number:") + com.google.firebase.database.p.g0.l.c(this.h.doubleValue());
    }
}
