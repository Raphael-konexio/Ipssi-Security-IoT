package com.google.firebase.database.r;
/* loaded from: classes.dex */
public class u extends h {
    private static final u f = new u();

    private u() {
    }

    public static u j() {
        return f;
    }

    @Override // com.google.firebase.database.r.h
    public String c() {
        return ".value";
    }

    @Override // com.google.firebase.database.r.h
    public boolean e(n nVar) {
        return true;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return obj instanceof u;
    }

    @Override // com.google.firebase.database.r.h
    public m f(b bVar, n nVar) {
        return new m(bVar, nVar);
    }

    @Override // com.google.firebase.database.r.h
    public m g() {
        return new m(b.i(), n.f2368b);
    }

    public int hashCode() {
        return 4;
    }

    @Override // java.util.Comparator
    /* renamed from: i */
    public int compare(m mVar, m mVar2) {
        int compareTo = mVar.d().compareTo(mVar2.d());
        return compareTo == 0 ? mVar.c().compareTo(mVar2.c()) : compareTo;
    }

    public String toString() {
        return "ValueIndex";
    }
}
