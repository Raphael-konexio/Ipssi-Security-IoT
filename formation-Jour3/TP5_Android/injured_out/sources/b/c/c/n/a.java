package b.c.c.n;
/* loaded from: classes.dex */
final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final String f1430a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1431b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f1430a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f1431b = str2;
    }

    @Override // b.c.c.n.f
    public String b() {
        return this.f1430a;
    }

    @Override // b.c.c.n.f
    public String c() {
        return this.f1431b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.f1430a.equals(fVar.b()) && this.f1431b.equals(fVar.c());
        }
        return false;
    }

    public int hashCode() {
        return ((this.f1430a.hashCode() ^ 1000003) * 1000003) ^ this.f1431b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f1430a + ", version=" + this.f1431b + "}";
    }
}
