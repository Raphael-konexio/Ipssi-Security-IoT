package a.d;
/* loaded from: classes.dex */
public class h<E> implements Cloneable {
    private static final Object j = new Object();
    private boolean f;
    private int[] g;
    private Object[] h;
    private int i;

    public h() {
        this(10);
    }

    public h(int i) {
        this.f = false;
        if (i == 0) {
            this.g = c.f63a;
            this.h = c.f65c;
            return;
        }
        int e = c.e(i);
        this.g = new int[e];
        this.h = new Object[e];
    }

    private void d() {
        int i = this.i;
        int[] iArr = this.g;
        Object[] objArr = this.h;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != j) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f = false;
        this.i = i2;
    }

    public void a(int i, E e) {
        int i2 = this.i;
        if (i2 != 0 && i <= this.g[i2 - 1]) {
            i(i, e);
            return;
        }
        if (this.f && this.i >= this.g.length) {
            d();
        }
        int i3 = this.i;
        if (i3 >= this.g.length) {
            int e2 = c.e(i3 + 1);
            int[] iArr = new int[e2];
            Object[] objArr = new Object[e2];
            int[] iArr2 = this.g;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.h;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.g = iArr;
            this.h = objArr;
        }
        this.g[i3] = i;
        this.h[i3] = e;
        this.i = i3 + 1;
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
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.g = (int[]) this.g.clone();
            hVar.h = (Object[]) this.h.clone();
            return hVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E e(int i) {
        return f(i, null);
    }

    public E f(int i, E e) {
        int a2 = c.a(this.g, this.i, i);
        if (a2 >= 0) {
            Object[] objArr = this.h;
            if (objArr[a2] != j) {
                return (E) objArr[a2];
            }
        }
        return e;
    }

    public int g(E e) {
        if (this.f) {
            d();
        }
        for (int i = 0; i < this.i; i++) {
            if (this.h[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int h(int i) {
        if (this.f) {
            d();
        }
        return this.g[i];
    }

    public void i(int i, E e) {
        int a2 = c.a(this.g, this.i, i);
        if (a2 >= 0) {
            this.h[a2] = e;
            return;
        }
        int i2 = ~a2;
        if (i2 < this.i) {
            Object[] objArr = this.h;
            if (objArr[i2] == j) {
                this.g[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.f && this.i >= this.g.length) {
            d();
            i2 = ~c.a(this.g, this.i, i);
        }
        int i3 = this.i;
        if (i3 >= this.g.length) {
            int e2 = c.e(i3 + 1);
            int[] iArr = new int[e2];
            Object[] objArr2 = new Object[e2];
            int[] iArr2 = this.g;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.h;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.g = iArr;
            this.h = objArr2;
        }
        int i4 = this.i;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.g;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.h;
            System.arraycopy(objArr4, i2, objArr4, i5, this.i - i2);
        }
        this.g[i2] = i;
        this.h[i2] = e;
        this.i++;
    }

    public void j(int i) {
        int a2 = c.a(this.g, this.i, i);
        if (a2 >= 0) {
            Object[] objArr = this.h;
            Object obj = objArr[a2];
            Object obj2 = j;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f = true;
            }
        }
    }

    public void k(int i) {
        Object[] objArr = this.h;
        Object obj = objArr[i];
        Object obj2 = j;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f = true;
        }
    }

    public int l() {
        if (this.f) {
            d();
        }
        return this.i;
    }

    public E m(int i) {
        if (this.f) {
            d();
        }
        return (E) this.h[i];
    }

    public String toString() {
        if (l() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.i * 28);
        sb.append('{');
        for (int i = 0; i < this.i; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(h(i));
            sb.append('=');
            E m = m(i);
            if (m != this) {
                sb.append(m);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
