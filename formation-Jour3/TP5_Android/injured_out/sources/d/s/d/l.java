package d.s.d;
/* loaded from: classes.dex */
public abstract class l extends a implements d.u.e {
    public l() {
    }

    public l(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            return h().equals(lVar.h()) && g().equals(lVar.g()) && j().equals(lVar.j()) && g.a(f(), lVar.f());
        } else if (obj instanceof d.u.e) {
            return obj.equals(d());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((h().hashCode() * 31) + g().hashCode()) * 31) + j().hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // d.s.d.a
    /* renamed from: k */
    public d.u.e i() {
        return (d.u.e) super.i();
    }

    public String toString() {
        d.u.a d2 = d();
        if (d2 != this) {
            return d2.toString();
        }
        return "property " + g() + " (Kotlin reflection is not available)";
    }
}
