package a.g.j;
/* loaded from: classes.dex */
public class e<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f217a;

    /* renamed from: b  reason: collision with root package name */
    public final S f218b;

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            return d.a(eVar.f217a, this.f217a) && d.a(eVar.f218b, this.f218b);
        }
        return false;
    }

    public int hashCode() {
        F f = this.f217a;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.f218b;
        return hashCode ^ (s != null ? s.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f217a + " " + this.f218b + "}";
    }
}
