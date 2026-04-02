package com.google.firebase.database.p.f0;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final long f2159a;

    /* renamed from: b  reason: collision with root package name */
    public final com.google.firebase.database.p.h0.i f2160b;

    /* renamed from: c  reason: collision with root package name */
    public final long f2161c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2162d;
    public final boolean e;

    public h(long j, com.google.firebase.database.p.h0.i iVar, long j2, boolean z, boolean z2) {
        this.f2159a = j;
        if (iVar.g() && !iVar.f()) {
            throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
        }
        this.f2160b = iVar;
        this.f2161c = j2;
        this.f2162d = z;
        this.e = z2;
    }

    public h a(boolean z) {
        return new h(this.f2159a, this.f2160b, this.f2161c, this.f2162d, z);
    }

    public h b() {
        return new h(this.f2159a, this.f2160b, this.f2161c, true, this.e);
    }

    public h c(long j) {
        return new h(this.f2159a, this.f2160b, j, this.f2162d, this.e);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != h.class) {
            return false;
        }
        h hVar = (h) obj;
        return this.f2159a == hVar.f2159a && this.f2160b.equals(hVar.f2160b) && this.f2161c == hVar.f2161c && this.f2162d == hVar.f2162d && this.e == hVar.e;
    }

    public int hashCode() {
        return (((((((Long.valueOf(this.f2159a).hashCode() * 31) + this.f2160b.hashCode()) * 31) + Long.valueOf(this.f2161c).hashCode()) * 31) + Boolean.valueOf(this.f2162d).hashCode()) * 31) + Boolean.valueOf(this.e).hashCode();
    }

    public String toString() {
        return "TrackedQuery{id=" + this.f2159a + ", querySpec=" + this.f2160b + ", lastUse=" + this.f2161c + ", complete=" + this.f2162d + ", active=" + this.e + "}";
    }
}
