package a.e.a;

import a.e.a.i;
import a.e.a.j.e;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static int p = 1000;
    public static f q;

    /* renamed from: c  reason: collision with root package name */
    private a f86c;
    b[] f;
    final c l;
    private final a o;

    /* renamed from: a  reason: collision with root package name */
    int f84a = 0;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, i> f85b = null;

    /* renamed from: d  reason: collision with root package name */
    private int f87d = 32;
    private int e = 32;
    public boolean g = false;
    private boolean[] h = new boolean[32];
    int i = 1;
    int j = 0;
    private int k = 32;
    private i[] m = new i[p];
    private int n = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(a aVar);

        void b(i iVar);

        i c(e eVar, boolean[] zArr);

        void clear();

        i getKey();
    }

    public e() {
        this.f = null;
        this.f = new b[32];
        D();
        c cVar = new c();
        this.l = cVar;
        this.f86c = new d(cVar);
        this.o = new b(this.l);
    }

    private final int C(a aVar, boolean z) {
        f fVar = q;
        if (fVar != null) {
            fVar.h++;
        }
        for (int i = 0; i < this.i; i++) {
            this.h[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            f fVar2 = q;
            if (fVar2 != null) {
                fVar2.i++;
            }
            i2++;
            if (i2 >= this.i * 2) {
                return i2;
            }
            if (aVar.getKey() != null) {
                this.h[aVar.getKey().f95b] = true;
            }
            i c2 = aVar.c(this, this.h);
            if (c2 != null) {
                boolean[] zArr = this.h;
                int i3 = c2.f95b;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (c2 != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.j; i5++) {
                    b bVar = this.f[i5];
                    if (bVar.f77a.g != i.a.UNRESTRICTED && !bVar.e && bVar.s(c2)) {
                        float f2 = bVar.f80d.f(c2);
                        if (f2 < 0.0f) {
                            float f3 = (-bVar.f78b) / f2;
                            if (f3 < f) {
                                i4 = i5;
                                f = f3;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    b bVar2 = this.f[i4];
                    bVar2.f77a.f96c = -1;
                    f fVar3 = q;
                    if (fVar3 != null) {
                        fVar3.j++;
                    }
                    bVar2.v(c2);
                    i iVar = bVar2.f77a;
                    iVar.f96c = i4;
                    iVar.f(bVar2);
                }
            }
            z2 = true;
        }
        return i2;
    }

    private void D() {
        int i = 0;
        while (true) {
            b[] bVarArr = this.f;
            if (i >= bVarArr.length) {
                return;
            }
            b bVar = bVarArr[i];
            if (bVar != null) {
                this.l.f81a.a(bVar);
            }
            this.f[i] = null;
            i++;
        }
    }

    private final void F(b bVar) {
        if (this.j > 0) {
            bVar.f80d.o(bVar, this.f);
            if (bVar.f80d.f73a == 0) {
                bVar.e = true;
            }
        }
    }

    private i a(i.a aVar, String str) {
        i b2 = this.l.f82b.b();
        if (b2 == null) {
            b2 = new i(aVar, str);
        } else {
            b2.d();
        }
        b2.e(aVar, str);
        int i = this.n;
        int i2 = p;
        if (i >= i2) {
            int i3 = i2 * 2;
            p = i3;
            this.m = (i[]) Arrays.copyOf(this.m, i3);
        }
        i[] iVarArr = this.m;
        int i4 = this.n;
        this.n = i4 + 1;
        iVarArr[i4] = b2;
        return b2;
    }

    private void g(b bVar) {
        bVar.d(this, 0);
    }

    private final void m(b bVar) {
        b[] bVarArr = this.f;
        int i = this.j;
        if (bVarArr[i] != null) {
            this.l.f81a.a(bVarArr[i]);
        }
        b[] bVarArr2 = this.f;
        int i2 = this.j;
        bVarArr2[i2] = bVar;
        i iVar = bVar.f77a;
        iVar.f96c = i2;
        this.j = i2 + 1;
        iVar.f(bVar);
    }

    private void o() {
        for (int i = 0; i < this.j; i++) {
            b bVar = this.f[i];
            bVar.f77a.e = bVar.f78b;
        }
    }

    public static b t(e eVar, i iVar, i iVar2, i iVar3, float f, boolean z) {
        b s = eVar.s();
        if (z) {
            eVar.g(s);
        }
        s.i(iVar, iVar2, iVar3, f);
        return s;
    }

    private int v(a aVar) {
        float f;
        boolean z;
        int i = 0;
        while (true) {
            f = 0.0f;
            if (i >= this.j) {
                z = false;
                break;
            }
            b[] bVarArr = this.f;
            if (bVarArr[i].f77a.g != i.a.UNRESTRICTED && bVarArr[i].f78b < 0.0f) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            boolean z2 = false;
            int i2 = 0;
            while (!z2) {
                f fVar = q;
                if (fVar != null) {
                    fVar.k++;
                }
                i2++;
                float f2 = Float.MAX_VALUE;
                int i3 = 0;
                int i4 = -1;
                int i5 = -1;
                int i6 = 0;
                while (i3 < this.j) {
                    b bVar = this.f[i3];
                    if (bVar.f77a.g != i.a.UNRESTRICTED && !bVar.e && bVar.f78b < f) {
                        int i7 = 1;
                        while (i7 < this.i) {
                            i iVar = this.l.f83c[i7];
                            float f3 = bVar.f80d.f(iVar);
                            if (f3 > f) {
                                for (int i8 = 0; i8 < 7; i8++) {
                                    float f4 = iVar.f[i8] / f3;
                                    if ((f4 < f2 && i8 == i6) || i8 > i6) {
                                        i5 = i7;
                                        i6 = i8;
                                        f2 = f4;
                                        i4 = i3;
                                    }
                                }
                            }
                            i7++;
                            f = 0.0f;
                        }
                    }
                    i3++;
                    f = 0.0f;
                }
                if (i4 != -1) {
                    b bVar2 = this.f[i4];
                    bVar2.f77a.f96c = -1;
                    f fVar2 = q;
                    if (fVar2 != null) {
                        fVar2.j++;
                    }
                    bVar2.v(this.l.f83c[i5]);
                    i iVar2 = bVar2.f77a;
                    iVar2.f96c = i4;
                    iVar2.f(bVar2);
                } else {
                    z2 = true;
                }
                if (i2 > this.i / 2) {
                    z2 = true;
                }
                f = 0.0f;
            }
            return i2;
        }
        return 0;
    }

    public static f x() {
        return q;
    }

    private void z() {
        int i = this.f87d * 2;
        this.f87d = i;
        this.f = (b[]) Arrays.copyOf(this.f, i);
        c cVar = this.l;
        cVar.f83c = (i[]) Arrays.copyOf(cVar.f83c, this.f87d);
        int i2 = this.f87d;
        this.h = new boolean[i2];
        this.e = i2;
        this.k = i2;
        f fVar = q;
        if (fVar != null) {
            fVar.f91d++;
            fVar.o = Math.max(fVar.o, i2);
            f fVar2 = q;
            fVar2.A = fVar2.o;
        }
    }

    public void A() {
        f fVar = q;
        if (fVar != null) {
            fVar.e++;
        }
        if (this.g) {
            f fVar2 = q;
            if (fVar2 != null) {
                fVar2.q++;
            }
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.j) {
                    z = true;
                    break;
                } else if (!this.f[i].e) {
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                f fVar3 = q;
                if (fVar3 != null) {
                    fVar3.p++;
                }
                o();
                return;
            }
        }
        B(this.f86c);
    }

    void B(a aVar) {
        f fVar = q;
        if (fVar != null) {
            fVar.s++;
            fVar.t = Math.max(fVar.t, this.i);
            f fVar2 = q;
            fVar2.u = Math.max(fVar2.u, this.j);
        }
        F((b) aVar);
        v(aVar);
        C(aVar, false);
        o();
    }

    public void E() {
        c cVar;
        int i = 0;
        while (true) {
            cVar = this.l;
            i[] iVarArr = cVar.f83c;
            if (i >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i];
            if (iVar != null) {
                iVar.d();
            }
            i++;
        }
        cVar.f82b.c(this.m, this.n);
        this.n = 0;
        Arrays.fill(this.l.f83c, (Object) null);
        HashMap<String, i> hashMap = this.f85b;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f84a = 0;
        this.f86c.clear();
        this.i = 1;
        for (int i2 = 0; i2 < this.j; i2++) {
            this.f[i2].f79c = false;
        }
        D();
        this.j = 0;
    }

    public void b(a.e.a.j.f fVar, a.e.a.j.f fVar2, float f, int i) {
        i r = r(fVar.h(e.d.LEFT));
        i r2 = r(fVar.h(e.d.TOP));
        i r3 = r(fVar.h(e.d.RIGHT));
        i r4 = r(fVar.h(e.d.BOTTOM));
        i r5 = r(fVar2.h(e.d.LEFT));
        i r6 = r(fVar2.h(e.d.TOP));
        i r7 = r(fVar2.h(e.d.RIGHT));
        i r8 = r(fVar2.h(e.d.BOTTOM));
        b s = s();
        double d2 = f;
        double d3 = i;
        s.p(r2, r4, r6, r8, (float) (Math.sin(d2) * d3));
        d(s);
        b s2 = s();
        s2.p(r, r3, r5, r7, (float) (Math.cos(d2) * d3));
        d(s2);
    }

    public void c(i iVar, i iVar2, int i, float f, i iVar3, i iVar4, int i2, int i3) {
        b s = s();
        s.g(iVar, iVar2, i, f, iVar3, iVar4, i2);
        if (i3 != 6) {
            s.d(this, i3);
        }
        d(s);
    }

    public void d(b bVar) {
        i u;
        if (bVar == null) {
            return;
        }
        f fVar = q;
        if (fVar != null) {
            fVar.f++;
            if (bVar.e) {
                fVar.g++;
            }
        }
        boolean z = true;
        if (this.j + 1 >= this.k || this.i + 1 >= this.e) {
            z();
        }
        boolean z2 = false;
        if (!bVar.e) {
            F(bVar);
            if (bVar.t()) {
                return;
            }
            bVar.q();
            if (bVar.f(this)) {
                i q2 = q();
                bVar.f77a = q2;
                m(bVar);
                this.o.a(bVar);
                C(this.o, true);
                if (q2.f96c == -1) {
                    if (bVar.f77a == q2 && (u = bVar.u(q2)) != null) {
                        f fVar2 = q;
                        if (fVar2 != null) {
                            fVar2.j++;
                        }
                        bVar.v(u);
                    }
                    if (!bVar.e) {
                        bVar.f77a.f(bVar);
                    }
                    this.j--;
                }
            } else {
                z = false;
            }
            if (!bVar.r()) {
                return;
            }
            z2 = z;
        }
        if (z2) {
            return;
        }
        m(bVar);
    }

    public b e(i iVar, i iVar2, int i, int i2) {
        b s = s();
        s.m(iVar, iVar2, i);
        if (i2 != 6) {
            s.d(this, i2);
        }
        d(s);
        return s;
    }

    public void f(i iVar, int i) {
        b s;
        int i2 = iVar.f96c;
        if (i2 != -1) {
            b bVar = this.f[i2];
            if (!bVar.e) {
                if (bVar.f80d.f73a == 0) {
                    bVar.e = true;
                } else {
                    s = s();
                    s.l(iVar, i);
                }
            }
            bVar.f78b = i;
            return;
        }
        s = s();
        s.h(iVar, i);
        d(s);
    }

    public void h(i iVar, i iVar2, boolean z) {
        b s = s();
        i u = u();
        u.f97d = 0;
        s.n(iVar, iVar2, u, 0);
        if (z) {
            n(s, (int) (s.f80d.f(u) * (-1.0f)), 1);
        }
        d(s);
    }

    public void i(i iVar, i iVar2, int i, int i2) {
        b s = s();
        i u = u();
        u.f97d = 0;
        s.n(iVar, iVar2, u, i);
        if (i2 != 6) {
            n(s, (int) (s.f80d.f(u) * (-1.0f)), i2);
        }
        d(s);
    }

    public void j(i iVar, i iVar2, boolean z) {
        b s = s();
        i u = u();
        u.f97d = 0;
        s.o(iVar, iVar2, u, 0);
        if (z) {
            n(s, (int) (s.f80d.f(u) * (-1.0f)), 1);
        }
        d(s);
    }

    public void k(i iVar, i iVar2, int i, int i2) {
        b s = s();
        i u = u();
        u.f97d = 0;
        s.o(iVar, iVar2, u, i);
        if (i2 != 6) {
            n(s, (int) (s.f80d.f(u) * (-1.0f)), i2);
        }
        d(s);
    }

    public void l(i iVar, i iVar2, i iVar3, i iVar4, float f, int i) {
        b s = s();
        s.j(iVar, iVar2, iVar3, iVar4, f);
        if (i != 6) {
            s.d(this, i);
        }
        d(s);
    }

    void n(b bVar, int i, int i2) {
        bVar.e(p(i2, null), i);
    }

    public i p(int i, String str) {
        f fVar = q;
        if (fVar != null) {
            fVar.l++;
        }
        if (this.i + 1 >= this.e) {
            z();
        }
        i a2 = a(i.a.ERROR, str);
        int i2 = this.f84a + 1;
        this.f84a = i2;
        this.i++;
        a2.f95b = i2;
        a2.f97d = i;
        this.l.f83c[i2] = a2;
        this.f86c.b(a2);
        return a2;
    }

    public i q() {
        f fVar = q;
        if (fVar != null) {
            fVar.n++;
        }
        if (this.i + 1 >= this.e) {
            z();
        }
        i a2 = a(i.a.SLACK, null);
        int i = this.f84a + 1;
        this.f84a = i;
        this.i++;
        a2.f95b = i;
        this.l.f83c[i] = a2;
        return a2;
    }

    public i r(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.i + 1 >= this.e) {
            z();
        }
        if (obj instanceof a.e.a.j.e) {
            a.e.a.j.e eVar = (a.e.a.j.e) obj;
            iVar = eVar.g();
            if (iVar == null) {
                eVar.n(this.l);
                iVar = eVar.g();
            }
            int i = iVar.f95b;
            if (i == -1 || i > this.f84a || this.l.f83c[i] == null) {
                if (iVar.f95b != -1) {
                    iVar.d();
                }
                int i2 = this.f84a + 1;
                this.f84a = i2;
                this.i++;
                iVar.f95b = i2;
                iVar.g = i.a.UNRESTRICTED;
                this.l.f83c[i2] = iVar;
            }
        }
        return iVar;
    }

    public b s() {
        b b2 = this.l.f81a.b();
        if (b2 == null) {
            b2 = new b(this.l);
        } else {
            b2.w();
        }
        i.b();
        return b2;
    }

    public i u() {
        f fVar = q;
        if (fVar != null) {
            fVar.m++;
        }
        if (this.i + 1 >= this.e) {
            z();
        }
        i a2 = a(i.a.SLACK, null);
        int i = this.f84a + 1;
        this.f84a = i;
        this.i++;
        a2.f95b = i;
        this.l.f83c[i] = a2;
        return a2;
    }

    public c w() {
        return this.l;
    }

    public int y(Object obj) {
        i g = ((a.e.a.j.e) obj).g();
        if (g != null) {
            return (int) (g.e + 0.5f);
        }
        return 0;
    }
}
