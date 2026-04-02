package com.google.firebase.database.r;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: c  reason: collision with root package name */
    private static final m f2364c = new m(b.l(), g.s());

    /* renamed from: d  reason: collision with root package name */
    private static final m f2365d = new m(b.i(), n.f2368b);

    /* renamed from: a  reason: collision with root package name */
    private final b f2366a;

    /* renamed from: b  reason: collision with root package name */
    private final n f2367b;

    public m(b bVar, n nVar) {
        this.f2366a = bVar;
        this.f2367b = nVar;
    }

    public static m a() {
        return f2365d;
    }

    public static m b() {
        return f2364c;
    }

    public b c() {
        return this.f2366a;
    }

    public n d() {
        return this.f2367b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.f2366a.equals(mVar.f2366a) && this.f2367b.equals(mVar.f2367b);
    }

    public int hashCode() {
        return (this.f2366a.hashCode() * 31) + this.f2367b.hashCode();
    }

    public String toString() {
        return "NamedNode{name=" + this.f2366a + ", node=" + this.f2367b + '}';
    }
}
