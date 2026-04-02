package com.google.firebase.database.r;

import com.google.firebase.database.r.k;
import com.google.firebase.database.r.n;
/* loaded from: classes.dex */
public class l extends k<l> {
    private final long h;

    public l(Long l, n nVar) {
        super(nVar);
        this.h = l.longValue();
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            return this.h == lVar.h && this.f.equals(lVar.f);
        }
        return false;
    }

    @Override // com.google.firebase.database.r.k
    protected k.b g() {
        return k.b.Number;
    }

    @Override // com.google.firebase.database.r.n
    public Object getValue() {
        return Long.valueOf(this.h);
    }

    public int hashCode() {
        long j = this.h;
        return ((int) (j ^ (j >>> 32))) + this.f.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.database.r.k
    /* renamed from: m */
    public int d(l lVar) {
        return com.google.firebase.database.p.g0.l.b(this.h, lVar.h);
    }

    @Override // com.google.firebase.database.r.n
    /* renamed from: s */
    public l j(n nVar) {
        return new l(Long.valueOf(this.h), nVar);
    }

    @Override // com.google.firebase.database.r.n
    public String v(n.b bVar) {
        return (i(bVar) + "number:") + com.google.firebase.database.p.g0.l.c(this.h);
    }
}
