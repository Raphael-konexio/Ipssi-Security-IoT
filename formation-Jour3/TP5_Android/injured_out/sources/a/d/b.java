package a.d;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {
    private static final int[] j = new int[0];
    private static final Object[] k = new Object[0];
    private static Object[] l;
    private static int m;
    private static Object[] n;
    private static int o;
    private int[] f;
    Object[] g;
    int h;
    private f<E, E> i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends f<E, E> {
        a() {
        }

        @Override // a.d.f
        protected void a() {
            b.this.clear();
        }

        @Override // a.d.f
        protected Object b(int i, int i2) {
            return b.this.g[i];
        }

        @Override // a.d.f
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // a.d.f
        protected int d() {
            return b.this.h;
        }

        @Override // a.d.f
        protected int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // a.d.f
        protected int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // a.d.f
        protected void g(E e, E e2) {
            b.this.add(e);
        }

        @Override // a.d.f
        protected void h(int i) {
            b.this.m(i);
        }

        @Override // a.d.f
        protected E i(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    public b(int i) {
        if (i == 0) {
            this.f = j;
            this.g = k;
        } else {
            d(i);
        }
        this.h = 0;
    }

    private void d(int i) {
        if (i == 8) {
            synchronized (b.class) {
                if (n != null) {
                    Object[] objArr = n;
                    this.g = objArr;
                    n = (Object[]) objArr[0];
                    this.f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    o--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (b.class) {
                if (l != null) {
                    Object[] objArr2 = l;
                    this.g = objArr2;
                    l = (Object[]) objArr2[0];
                    this.f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    m--;
                    return;
                }
            }
        }
        this.f = new int[i];
        this.g = new Object[i];
    }

    private static void f(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (o < 10) {
                    objArr[0] = n;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    n = objArr;
                    o++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (m < 10) {
                    objArr[0] = l;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    l = objArr;
                    m++;
                }
            }
        }
    }

    private f<E, E> g() {
        if (this.i == null) {
            this.i = new a();
        }
        return this.i;
    }

    private int i(Object obj, int i) {
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.f, i2, i);
        if (a2 >= 0 && !obj.equals(this.g[a2])) {
            int i3 = a2 + 1;
            while (i3 < i2 && this.f[i3] == i) {
                if (obj.equals(this.g[i3])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = a2 - 1; i4 >= 0 && this.f[i4] == i; i4--) {
                if (obj.equals(this.g[i4])) {
                    return i4;
                }
            }
            return ~i3;
        }
        return a2;
    }

    private int l() {
        int i = this.h;
        if (i == 0) {
            return -1;
        }
        int a2 = c.a(this.f, i, 0);
        if (a2 >= 0 && this.g[a2] != null) {
            int i2 = a2 + 1;
            while (i2 < i && this.f[i2] == 0) {
                if (this.g[i2] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = a2 - 1; i3 >= 0 && this.f[i3] == 0; i3--) {
                if (this.g[i3] == null) {
                    return i3;
                }
            }
            return ~i2;
        }
        return a2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int i2;
        if (e == null) {
            i2 = l();
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            i2 = i(e, hashCode);
        }
        if (i2 >= 0) {
            return false;
        }
        int i3 = ~i2;
        int i4 = this.h;
        if (i4 >= this.f.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.f;
            Object[] objArr = this.g;
            d(i5);
            int[] iArr2 = this.f;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.g, 0, objArr.length);
            }
            f(iArr, objArr, this.h);
        }
        int i6 = this.h;
        if (i3 < i6) {
            int[] iArr3 = this.f;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.g;
            System.arraycopy(objArr2, i3, objArr2, i7, this.h - i3);
        }
        this.f[i3] = i;
        this.g[i3] = e;
        this.h++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        e(this.h + collection.size());
        boolean z = false;
        for (E e : collection) {
            z |= add(e);
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.h;
        if (i != 0) {
            f(this.f, this.g, i);
            this.f = j;
            this.g = k;
            this.h = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void e(int i) {
        int[] iArr = this.f;
        if (iArr.length < i) {
            Object[] objArr = this.g;
            d(i);
            int i2 = this.h;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f, 0, i2);
                System.arraycopy(objArr, 0, this.g, 0, this.h);
            }
            f(iArr, objArr, this.h);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.h; i++) {
                try {
                    if (!set.contains(s(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f;
        int i = this.h;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public int indexOf(Object obj) {
        return obj == null ? l() : i(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.h <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return g().m().iterator();
    }

    public E m(int i) {
        Object[] objArr = this.g;
        E e = (E) objArr[i];
        int i2 = this.h;
        if (i2 <= 1) {
            f(this.f, objArr, i2);
            this.f = j;
            this.g = k;
            this.h = 0;
        } else {
            int[] iArr = this.f;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                int i3 = this.h - 1;
                this.h = i3;
                if (i < i3) {
                    int[] iArr2 = this.f;
                    int i4 = i + 1;
                    System.arraycopy(iArr2, i4, iArr2, i, i3 - i);
                    Object[] objArr2 = this.g;
                    System.arraycopy(objArr2, i4, objArr2, i, this.h - i);
                }
                this.g[this.h] = null;
            } else {
                int i5 = i2 > 8 ? i2 + (i2 >> 1) : 8;
                int[] iArr3 = this.f;
                Object[] objArr3 = this.g;
                d(i5);
                this.h--;
                if (i > 0) {
                    System.arraycopy(iArr3, 0, this.f, 0, i);
                    System.arraycopy(objArr3, 0, this.g, 0, i);
                }
                int i6 = this.h;
                if (i < i6) {
                    int i7 = i + 1;
                    System.arraycopy(iArr3, i7, this.f, i, i6 - i);
                    System.arraycopy(objArr3, i7, this.g, i, this.h - i);
                }
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            m(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.h - 1; i >= 0; i--) {
            if (!collection.contains(this.g[i])) {
                m(i);
                z = true;
            }
        }
        return z;
    }

    public E s(int i) {
        return (E) this.g[i];
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.h;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.h;
        Object[] objArr = new Object[i];
        System.arraycopy(this.g, 0, objArr, 0, i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.h) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.h));
        }
        System.arraycopy(this.g, 0, tArr, 0, this.h);
        int length = tArr.length;
        int i = this.h;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.h * 14);
        sb.append('{');
        for (int i = 0; i < this.h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E s = s(i);
            if (s != this) {
                sb.append(s);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
