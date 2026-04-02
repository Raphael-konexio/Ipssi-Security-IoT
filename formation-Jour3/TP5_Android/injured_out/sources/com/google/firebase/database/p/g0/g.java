package com.google.firebase.database.p.g0;
/* loaded from: classes.dex */
public final class g<T, U> {

    /* renamed from: a  reason: collision with root package name */
    private final T f2182a;

    /* renamed from: b  reason: collision with root package name */
    private final U f2183b;

    public g(T t, U u) {
        this.f2182a = t;
        this.f2183b = u;
    }

    public T a() {
        return this.f2182a;
    }

    public U b() {
        return this.f2183b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        T t = this.f2182a;
        if (t == null ? gVar.f2182a == null : t.equals(gVar.f2182a)) {
            U u = this.f2183b;
            U u2 = gVar.f2183b;
            return u == null ? u2 == null : u.equals(u2);
        }
        return false;
    }

    public int hashCode() {
        T t = this.f2182a;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        U u = this.f2183b;
        return hashCode + (u != null ? u.hashCode() : 0);
    }

    public String toString() {
        return "Pair(" + this.f2182a + "," + this.f2183b + ")";
    }
}
