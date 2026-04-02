package a.d;
/* loaded from: classes.dex */
public class d<E> implements Cloneable {
    private static final Object j = new Object();
    private boolean f;
    private long[] g;
    private Object[] h;
    private int i;

    public d() {
        this(10);
    }

    public d(int i) {
        this.f = false;
        if (i == 0) {
            this.g = c.f64b;
            this.h = c.f65c;
            return;
        }
        int f = c.f(i);
        this.g = new long[f];
        this.h = new Object[f];
    }

    private void e() {
        int i = this.i;
        long[] jArr = this.g;
        Object[] objArr = this.h;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != j) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f = false;
        this.i = i2;
    }

    public void a(long j2, E e) {
        int i = this.i;
        if (i != 0 && j2 <= this.g[i - 1]) {
            j(j2, e);
            return;
        }
        if (this.f && this.i >= this.g.length) {
            e();
        }
        int i2 = this.i;
        if (i2 >= this.g.length) {
            int f = c.f(i2 + 1);
            long[] jArr = new long[f];
            Object[] objArr = new Object[f];
            long[] jArr2 = this.g;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.h;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.g = jArr;
            this.h = objArr;
        }
        this.g[i2] = j2;
        this.h[i2] = e;
        this.i = i2 + 1;
    }

    public void b() {
        int i = this.i;
        Object[] objArr = this.h;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.i = 0;
        this.f = false;
    }

    /* renamed from: c */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.g = (long[]) this.g.clone();
            dVar.h = (Object[]) this.h.clone();
            return dVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Deprecated
    public void d(long j2) {
        k(j2);
    }

    public E f(long j2) {
        return g(j2, null);
    }

    public E g(long j2, E e) {
        int b2 = c.b(this.g, this.i, j2);
        if (b2 >= 0) {
            Object[] objArr = this.h;
            if (objArr[b2] != j) {
                return (E) objArr[b2];
            }
        }
        return e;
    }

    public int h(long j2) {
        if (this.f) {
            e();
        }
        return c.b(this.g, this.i, j2);
    }

    public long i(int i) {
        if (this.f) {
            e();
        }
        return this.g[i];
    }

    public void j(long j2, E e) {
        int b2 = c.b(this.g, this.i, j2);
        if (b2 >= 0) {
            this.h[b2] = e;
            return;
        }
        int i = ~b2;
        if (i < this.i) {
            Object[] objArr = this.h;
            if (objArr[i] == j) {
                this.g[i] = j2;
                objArr[i] = e;
                return;
            }
        }
        if (this.f && this.i >= this.g.length) {
            e();
            i = ~c.b(this.g, this.i, j2);
        }
        int i2 = this.i;
        if (i2 >= this.g.length) {
            int f = c.f(i2 + 1);
            long[] jArr = new long[f];
            Object[] objArr2 = new Object[f];
            long[] jArr2 = this.g;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.h;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.g = jArr;
            this.h = objArr2;
        }
        int i3 = this.i;
        if (i3 - i != 0) {
            long[] jArr3 = this.g;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.h;
            System.arraycopy(objArr4, i, objArr4, i4, this.i - i);
        }
        this.g[i] = j2;
        this.h[i] = e;
        this.i++;
    }

    public void k(long j2) {
        int b2 = c.b(this.g, this.i, j2);
        if (b2 >= 0) {
            Object[] objArr = this.h;
            Object obj = objArr[b2];
            Object obj2 = j;
            if (obj != obj2) {
                objArr[b2] = obj2;
                this.f = true;
            }
        }
    }

    public void l(int i) {
        Object[] objArr = this.h;
        Object obj = objArr[i];
        Object obj2 = j;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f = true;
        }
    }

    public int m() {
        if (this.f) {
            e();
        }
        return this.i;
    }

    public E n(int i) {
        if (this.f) {
            e();
        }
        return (E) this.h[i];
    }

    public String toString() {
        if (m() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.i * 28);
        sb.append('{');
        for (int i = 0; i < this.i; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(i(i));
            sb.append('=');
            E n = n(i);
            if (n != this) {
                sb.append(n);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
