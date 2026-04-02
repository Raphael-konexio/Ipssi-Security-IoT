package com.google.firebase.database.r;
/* loaded from: classes.dex */
public class j extends h {
    private static final j f = new j();

    private j() {
    }

    public static j j() {
        return f;
    }

    @Override // com.google.firebase.database.r.h
    public String c() {
        return ".key";
    }

    @Override // com.google.firebase.database.r.h
    public boolean e(n nVar) {
        return true;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return obj instanceof j;
    }

    @Override // com.google.firebase.database.r.h
    public m f(b bVar, n nVar) {
        return new m(b.g((String) nVar.getValue()), g.s());
    }

    @Override // com.google.firebase.database.r.h
    public m g() {
        return m.a();
    }

    public int hashCode() {
        return 37;
    }

    @Override // java.util.Comparator
    /* renamed from: i */
    public int compare(m mVar, m mVar2) {
        return mVar.c().compareTo(mVar2.c());
    }

    public String toString() {
        return "KeyIndex";
    }
}
