package d.t;

import d.o.v;
/* loaded from: classes.dex */
public class a implements Iterable<Integer> {
    public static final C0112a i = new C0112a(null);
    private final int f;
    private final int g;
    private final int h;

    /* renamed from: d.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0112a {
        private C0112a() {
        }

        public /* synthetic */ C0112a(d.s.d.e eVar) {
            this();
        }

        public final a a(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }

    public a(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f = i2;
        this.g = d.q.c.b(i2, i3, i4);
        this.h = i4;
    }

    public final int d() {
        return this.f;
    }

    public final int e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f != aVar.f || this.g != aVar.g || this.h != aVar.h) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        return this.h;
    }

    @Override // java.lang.Iterable
    /* renamed from: g */
    public v iterator() {
        return new b(this.f, this.g, this.h);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f * 31) + this.g) * 31) + this.h;
    }

    public boolean isEmpty() {
        if (this.h > 0) {
            if (this.f > this.g) {
                return true;
            }
        } else if (this.f < this.g) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.h > 0) {
            sb = new StringBuilder();
            sb.append(this.f);
            sb.append("..");
            sb.append(this.g);
            sb.append(" step ");
            i2 = this.h;
        } else {
            sb = new StringBuilder();
            sb.append(this.f);
            sb.append(" downTo ");
            sb.append(this.g);
            sb.append(" step ");
            i2 = -this.h;
        }
        sb.append(i2);
        return sb.toString();
    }
}
