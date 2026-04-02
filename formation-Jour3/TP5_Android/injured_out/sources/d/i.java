package d;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class i<A, B> implements Serializable {
    private final A f;
    private final B g;

    public i(A a2, B b2) {
        this.f = a2;
        this.g = b2;
    }

    public final A a() {
        return this.f;
    }

    public final B b() {
        return this.g;
    }

    public final A c() {
        return this.f;
    }

    public final B d() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                return d.s.d.g.a(this.f, iVar.f) && d.s.d.g.a(this.g, iVar.g);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a2 = this.f;
        int hashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b2 = this.g;
        return hashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f + ", " + this.g + ')';
    }
}
