package com.google.firebase.database.r;
/* loaded from: classes.dex */
public class q extends h {
    private static final q f = new q();

    private q() {
    }

    public static q j() {
        return f;
    }

    @Override // com.google.firebase.database.r.h
    public String c() {
        throw new IllegalArgumentException("Can't get query definition on priority index!");
    }

    @Override // com.google.firebase.database.r.h
    public boolean e(n nVar) {
        return !nVar.c().isEmpty();
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return obj instanceof q;
    }

    @Override // com.google.firebase.database.r.h
    public m f(b bVar, n nVar) {
        return new m(bVar, new t("[PRIORITY-POST]", nVar));
    }

    @Override // com.google.firebase.database.r.h
    public m g() {
        return f(b.i(), n.f2368b);
    }

    public int hashCode() {
        return 3155577;
    }

    @Override // java.util.Comparator
    /* renamed from: i */
    public int compare(m mVar, m mVar2) {
        return o.c(mVar.c(), mVar.d().c(), mVar2.c(), mVar2.d().c());
    }

    public String toString() {
        return "PriorityIndex";
    }
}
