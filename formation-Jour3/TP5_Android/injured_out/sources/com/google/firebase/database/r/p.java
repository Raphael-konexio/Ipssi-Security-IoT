package com.google.firebase.database.r;
/* loaded from: classes.dex */
public final class p extends h {
    private final com.google.firebase.database.p.l f;

    public p(com.google.firebase.database.p.l lVar) {
        if (lVar.size() == 1 && lVar.x().w()) {
            throw new IllegalArgumentException("Can't create PathIndex with '.priority' as key. Please use PriorityIndex instead!");
        }
        this.f = lVar;
    }

    @Override // com.google.firebase.database.r.h
    public String c() {
        return this.f.B();
    }

    @Override // com.google.firebase.database.r.h
    public boolean e(n nVar) {
        return !nVar.h(this.f).isEmpty();
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && p.class == obj.getClass() && this.f.equals(((p) obj).f);
    }

    @Override // com.google.firebase.database.r.h
    public m f(b bVar, n nVar) {
        return new m(bVar, g.s().q(this.f, nVar));
    }

    @Override // com.google.firebase.database.r.h
    public m g() {
        return new m(b.i(), g.s().q(this.f, n.f2368b));
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    @Override // java.util.Comparator
    /* renamed from: i */
    public int compare(m mVar, m mVar2) {
        int compareTo = mVar.d().h(this.f).compareTo(mVar2.d().h(this.f));
        return compareTo == 0 ? mVar.c().compareTo(mVar2.c()) : compareTo;
    }
}
