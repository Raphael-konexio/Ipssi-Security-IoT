package d.s.d;
/* loaded from: classes.dex */
public final class i implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f2412a;

    public i(Class<?> cls, String str) {
        g.e(cls, "jClass");
        g.e(str, "moduleName");
        this.f2412a = cls;
    }

    @Override // d.s.d.b
    public Class<?> a() {
        return this.f2412a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && g.a(a(), ((i) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
