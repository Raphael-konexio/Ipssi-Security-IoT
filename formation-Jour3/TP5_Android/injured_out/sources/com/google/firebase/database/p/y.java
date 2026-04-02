package com.google.firebase.database.p;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private final long f2340a;

    /* renamed from: b  reason: collision with root package name */
    private final l f2341b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.database.r.n f2342c;

    /* renamed from: d  reason: collision with root package name */
    private final b f2343d;
    private final boolean e;

    public y(long j, l lVar, b bVar) {
        this.f2340a = j;
        this.f2341b = lVar;
        this.f2342c = null;
        this.f2343d = bVar;
        this.e = true;
    }

    public y(long j, l lVar, com.google.firebase.database.r.n nVar, boolean z) {
        this.f2340a = j;
        this.f2341b = lVar;
        this.f2342c = nVar;
        this.f2343d = null;
        this.e = z;
    }

    public b a() {
        b bVar = this.f2343d;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalArgumentException("Can't access merge when write is an overwrite!");
    }

    public com.google.firebase.database.r.n b() {
        com.google.firebase.database.r.n nVar = this.f2342c;
        if (nVar != null) {
            return nVar;
        }
        throw new IllegalArgumentException("Can't access overwrite when write is a merge!");
    }

    public l c() {
        return this.f2341b;
    }

    public long d() {
        return this.f2340a;
    }

    public boolean e() {
        return this.f2342c != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y.class != obj.getClass()) {
            return false;
        }
        y yVar = (y) obj;
        if (this.f2340a == yVar.f2340a && this.f2341b.equals(yVar.f2341b) && this.e == yVar.e) {
            com.google.firebase.database.r.n nVar = this.f2342c;
            if (nVar == null ? yVar.f2342c == null : nVar.equals(yVar.f2342c)) {
                b bVar = this.f2343d;
                b bVar2 = yVar.f2343d;
                return bVar == null ? bVar2 == null : bVar.equals(bVar2);
            }
            return false;
        }
        return false;
    }

    public boolean f() {
        return this.e;
    }

    public int hashCode() {
        int hashCode = ((((Long.valueOf(this.f2340a).hashCode() * 31) + Boolean.valueOf(this.e).hashCode()) * 31) + this.f2341b.hashCode()) * 31;
        com.google.firebase.database.r.n nVar = this.f2342c;
        int hashCode2 = (hashCode + (nVar != null ? nVar.hashCode() : 0)) * 31;
        b bVar = this.f2343d;
        return hashCode2 + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "UserWriteRecord{id=" + this.f2340a + " path=" + this.f2341b + " visible=" + this.e + " overwrite=" + this.f2342c + " merge=" + this.f2343d + "}";
    }
}
