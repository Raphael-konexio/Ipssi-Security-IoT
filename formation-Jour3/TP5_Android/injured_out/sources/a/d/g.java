package a.d;

import java.util.ConcurrentModificationException;
import java.util.Map;
/* loaded from: classes.dex */
public class g<K, V> {
    static Object[] i;
    static int j;
    static Object[] k;
    static int l;
    int[] f;
    Object[] g;
    int h;

    public g() {
        this.f = c.f63a;
        this.g = c.f65c;
        this.h = 0;
    }

    public g(int i2) {
        if (i2 == 0) {
            this.f = c.f63a;
            this.g = c.f65c;
        } else {
            a(i2);
        }
        this.h = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(g<K, V> gVar) {
        this();
        if (gVar != 0) {
            j(gVar);
        }
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (g.class) {
                if (k != null) {
                    Object[] objArr = k;
                    this.g = objArr;
                    k = (Object[]) objArr[0];
                    this.f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    l--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (g.class) {
                if (i != null) {
                    Object[] objArr2 = i;
                    this.g = objArr2;
                    i = (Object[]) objArr2[0];
                    this.f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    j--;
                    return;
                }
            }
        }
        this.f = new int[i2];
        this.g = new Object[i2 << 1];
    }

    private static int b(int[] iArr, int i2, int i3) {
        try {
            return c.a(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                if (l < 10) {
                    objArr[0] = k;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    k = objArr;
                    l++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (g.class) {
                if (j < 10) {
                    objArr[0] = i;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    i = objArr;
                    j++;
                }
            }
        }
    }

    public void c(int i2) {
        int i3 = this.h;
        int[] iArr = this.f;
        if (iArr.length < i2) {
            Object[] objArr = this.g;
            a(i2);
            if (this.h > 0) {
                System.arraycopy(iArr, 0, this.f, 0, i3);
                System.arraycopy(objArr, 0, this.g, 0, i3 << 1);
            }
            d(iArr, objArr, i3);
        }
        if (this.h != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i2 = this.h;
        if (i2 > 0) {
            int[] iArr = this.f;
            Object[] objArr = this.g;
            this.f = c.f63a;
            this.g = c.f65c;
            this.h = 0;
            d(iArr, objArr, i2);
        }
        if (this.h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    int e(Object obj, int i2) {
        int i3 = this.h;
        if (i3 == 0) {
            return -1;
        }
        int b2 = b(this.f, i3, i2);
        if (b2 >= 0 && !obj.equals(this.g[b2 << 1])) {
            int i4 = b2 + 1;
            while (i4 < i3 && this.f[i4] == i2) {
                if (obj.equals(this.g[i4 << 1])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = b2 - 1; i5 >= 0 && this.f[i5] == i2; i5--) {
                if (obj.equals(this.g[i5 << 1])) {
                    return i5;
                }
            }
            return ~i4;
        }
        return b2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.h; i2++) {
                try {
                    K i3 = i(i2);
                    V m = m(i2);
                    Object obj2 = gVar.get(i3);
                    if (m == null) {
                        if (obj2 != null || !gVar.containsKey(i3)) {
                            return false;
                        }
                    } else if (!m.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.h; i4++) {
                try {
                    K i5 = i(i4);
                    V m2 = m(i4);
                    Object obj3 = map.get(i5);
                    if (m2 == null) {
                        if (obj3 != null || !map.containsKey(i5)) {
                            return false;
                        }
                    } else if (!m2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    int g() {
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int b2 = b(this.f, i2, 0);
        if (b2 >= 0 && this.g[b2 << 1] != null) {
            int i3 = b2 + 1;
            while (i3 < i2 && this.f[i3] == 0) {
                if (this.g[i3 << 1] == null) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = b2 - 1; i4 >= 0 && this.f[i4] == 0; i4--) {
                if (this.g[i4 << 1] == null) {
                    return i4;
                }
            }
            return ~i3;
        }
        return b2;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int f = f(obj);
        return f >= 0 ? (V) this.g[(f << 1) + 1] : v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(Object obj) {
        int i2 = this.h * 2;
        Object[] objArr = this.g;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f;
        Object[] objArr = this.g;
        int i2 = this.h;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            i5 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return i5;
    }

    public K i(int i2) {
        return (K) this.g[i2 << 1];
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public void j(g<? extends K, ? extends V> gVar) {
        int i2 = gVar.h;
        c(this.h + i2);
        if (this.h != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(gVar.i(i3), gVar.m(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(gVar.f, 0, this.f, 0, i2);
            System.arraycopy(gVar.g, 0, this.g, 0, i2 << 1);
            this.h = i2;
        }
    }

    public V k(int i2) {
        Object[] objArr = this.g;
        int i3 = i2 << 1;
        V v = (V) objArr[i3 + 1];
        int i4 = this.h;
        int i5 = 0;
        if (i4 <= 1) {
            d(this.f, objArr, i4);
            this.f = c.f63a;
            this.g = c.f65c;
        } else {
            int i6 = i4 - 1;
            int[] iArr = this.f;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i6) {
                    int[] iArr2 = this.f;
                    int i7 = i2 + 1;
                    int i8 = i6 - i2;
                    System.arraycopy(iArr2, i7, iArr2, i2, i8);
                    Object[] objArr2 = this.g;
                    System.arraycopy(objArr2, i7 << 1, objArr2, i3, i8 << 1);
                }
                Object[] objArr3 = this.g;
                int i9 = i6 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                int i10 = i4 > 8 ? i4 + (i4 >> 1) : 8;
                int[] iArr3 = this.f;
                Object[] objArr4 = this.g;
                a(i10);
                if (i4 != this.h) {
                    throw new ConcurrentModificationException();
                }
                if (i2 > 0) {
                    System.arraycopy(iArr3, 0, this.f, 0, i2);
                    System.arraycopy(objArr4, 0, this.g, 0, i3);
                }
                if (i2 < i6) {
                    int i11 = i2 + 1;
                    int i12 = i6 - i2;
                    System.arraycopy(iArr3, i11, this.f, i2, i12);
                    System.arraycopy(objArr4, i11 << 1, this.g, i3, i12 << 1);
                }
            }
            i5 = i6;
        }
        if (i4 == this.h) {
            this.h = i5;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public V l(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        Object[] objArr = this.g;
        V v2 = (V) objArr[i3];
        objArr[i3] = v;
        return v2;
    }

    public V m(int i2) {
        return (V) this.g[(i2 << 1) + 1];
    }

    public V put(K k2, V v) {
        int i2;
        int e;
        int i3 = this.h;
        if (k2 == null) {
            e = g();
            i2 = 0;
        } else {
            int hashCode = k2.hashCode();
            i2 = hashCode;
            e = e(k2, hashCode);
        }
        if (e >= 0) {
            int i4 = (e << 1) + 1;
            Object[] objArr = this.g;
            V v2 = (V) objArr[i4];
            objArr[i4] = v;
            return v2;
        }
        int i5 = ~e;
        if (i3 >= this.f.length) {
            int i6 = 4;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f;
            Object[] objArr2 = this.g;
            a(i6);
            if (i3 != this.h) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.g, 0, objArr2.length);
            }
            d(iArr, objArr2, i3);
        }
        if (i5 < i3) {
            int[] iArr3 = this.f;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr3 = this.g;
            System.arraycopy(objArr3, i5 << 1, objArr3, i7 << 1, (this.h - i5) << 1);
        }
        int i8 = this.h;
        if (i3 == i8) {
            int[] iArr4 = this.f;
            if (i5 < iArr4.length) {
                iArr4[i5] = i2;
                Object[] objArr4 = this.g;
                int i9 = i5 << 1;
                objArr4[i9] = k2;
                objArr4[i9 + 1] = v;
                this.h = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k2, V v) {
        V v2 = get(k2);
        return v2 == null ? put(k2, v) : v2;
    }

    public V remove(Object obj) {
        int f = f(obj);
        if (f >= 0) {
            return k(f);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int f = f(obj);
        if (f >= 0) {
            V m = m(f);
            if (obj2 == m || (obj2 != null && obj2.equals(m))) {
                k(f);
                return true;
            }
            return false;
        }
        return false;
    }

    public V replace(K k2, V v) {
        int f = f(k2);
        if (f >= 0) {
            return l(f, v);
        }
        return null;
    }

    public boolean replace(K k2, V v, V v2) {
        int f = f(k2);
        if (f >= 0) {
            V m = m(f);
            if (m == v || (v != null && v.equals(m))) {
                l(f, v2);
                return true;
            }
            return false;
        }
        return false;
    }

    public int size() {
        return this.h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.h * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.h; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            K i3 = i(i2);
            if (i3 != this) {
                sb.append(i3);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V m = m(i2);
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
