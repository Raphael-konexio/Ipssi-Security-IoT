package a.e.a.j;

import a.e.a.j.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static void a(g gVar) {
        if ((gVar.R0() & 32) != 32) {
            j(gVar);
            return;
        }
        gVar.D0 = true;
        gVar.x0 = false;
        gVar.y0 = false;
        gVar.z0 = false;
        ArrayList<f> arrayList = gVar.k0;
        List<h> list = gVar.w0;
        boolean z = gVar.s() == f.b.WRAP_CONTENT;
        boolean z2 = gVar.B() == f.b.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (f fVar : arrayList) {
            fVar.p = null;
            fVar.d0 = false;
            fVar.S();
        }
        for (f fVar2 : arrayList) {
            if (fVar2.p == null && !b(fVar2, list, z3)) {
                j(gVar);
                gVar.D0 = false;
                return;
            }
        }
        int i = 0;
        int i2 = 0;
        for (h hVar : list) {
            i = Math.max(i, c(hVar, 0));
            i2 = Math.max(i2, c(hVar, 1));
        }
        if (z) {
            gVar.g0(f.b.FIXED);
            gVar.y0(i);
            gVar.x0 = true;
            gVar.y0 = true;
            gVar.A0 = i;
        }
        if (z2) {
            gVar.u0(f.b.FIXED);
            gVar.b0(i2);
            gVar.x0 = true;
            gVar.z0 = true;
            gVar.B0 = i2;
        }
        i(list, 0, gVar.D());
        i(list, 1, gVar.r());
    }

    private static boolean b(f fVar, List<h> list, boolean z) {
        h hVar = new h(new ArrayList(), true);
        list.add(hVar);
        return k(fVar, hVar, list, z);
    }

    private static int c(h hVar, int i) {
        int i2 = i * 2;
        List<f> b2 = hVar.b(i);
        int size = b2.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            f fVar = b2.get(i4);
            e[] eVarArr = fVar.A;
            int i5 = i2 + 1;
            i3 = Math.max(i3, d(fVar, i, eVarArr[i5].f105d == null || !(eVarArr[i2].f105d == null || eVarArr[i5].f105d == null), 0));
        }
        hVar.e[i] = i3;
        return i3;
    }

    private static int d(f fVar, int i, boolean z, int i2) {
        int r;
        int j;
        int i3;
        int i4;
        int i5;
        int D;
        int i6;
        int i7;
        int i8;
        int i9 = 0;
        if (fVar.b0) {
            boolean z2 = fVar.w.f105d != null && i == 1;
            if (z) {
                r = fVar.j();
                j = fVar.r() - fVar.j();
                i4 = i * 2;
                i3 = i4 + 1;
            } else {
                r = fVar.r() - fVar.j();
                j = fVar.j();
                i3 = i * 2;
                i4 = i3 + 1;
            }
            e[] eVarArr = fVar.A;
            if (eVarArr[i3].f105d == null || eVarArr[i4].f105d != null) {
                i5 = 1;
            } else {
                i5 = -1;
                int i10 = i3;
                i3 = i4;
                i4 = i10;
            }
            int i11 = z2 ? i2 - r : i2;
            int d2 = (fVar.A[i4].d() * i5) + e(fVar, i);
            int i12 = i11 + d2;
            int D2 = (i == 0 ? fVar.D() : fVar.r()) * i5;
            Iterator<n> it = fVar.A[i4].f().f122a.iterator();
            while (it.hasNext()) {
                i9 = Math.max(i9, d(((l) it.next()).f119c.f103b, i, z, i12));
            }
            int i13 = 0;
            for (Iterator<n> it2 = fVar.A[i3].f().f122a.iterator(); it2.hasNext(); it2 = it2) {
                i13 = Math.max(i13, d(((l) it2.next()).f119c.f103b, i, z, D2 + i12));
            }
            if (z2) {
                i9 -= r;
                D = i13 + j;
            } else {
                D = i13 + ((i == 0 ? fVar.D() : fVar.r()) * i5);
            }
            int i14 = 1;
            if (i == 1) {
                Iterator<n> it3 = fVar.w.f().f122a.iterator();
                int i15 = 0;
                while (it3.hasNext()) {
                    Iterator<n> it4 = it3;
                    l lVar = (l) it3.next();
                    if (i5 == i14) {
                        i15 = Math.max(i15, d(lVar.f119c.f103b, i, z, r + i12));
                        i8 = i3;
                    } else {
                        i8 = i3;
                        i15 = Math.max(i15, d(lVar.f119c.f103b, i, z, (j * i5) + i12));
                    }
                    it3 = it4;
                    i3 = i8;
                    i14 = 1;
                }
                i6 = i3;
                int i16 = i15;
                i7 = (fVar.w.f().f122a.size() <= 0 || z2) ? i16 : i5 == 1 ? i16 + r : i16 - j;
            } else {
                i6 = i3;
                i7 = 0;
            }
            int max = d2 + Math.max(i9, Math.max(D, i7));
            int i17 = D2 + i12;
            if (i5 == -1) {
                i17 = i12;
                i12 = i17;
            }
            if (z) {
                k.e(fVar, i, i12);
                fVar.Z(i12, i17, i);
            } else {
                fVar.p.a(fVar, i);
                fVar.q0(i12, i);
            }
            if (fVar.o(i) == f.b.MATCH_CONSTRAINT && fVar.G != 0.0f) {
                fVar.p.a(fVar, i);
            }
            e[] eVarArr2 = fVar.A;
            if (eVarArr2[i4].f105d != null && eVarArr2[i6].f105d != null) {
                f u = fVar.u();
                e[] eVarArr3 = fVar.A;
                if (eVarArr3[i4].f105d.f103b == u && eVarArr3[i6].f105d.f103b == u) {
                    fVar.p.a(fVar, i);
                }
            }
            return max;
        }
        return 0;
    }

    private static int e(f fVar, int i) {
        e eVar;
        int i2 = i * 2;
        e[] eVarArr = fVar.A;
        e eVar2 = eVarArr[i2];
        e eVar3 = eVarArr[i2 + 1];
        e eVar4 = eVar2.f105d;
        if (eVar4 != null) {
            f fVar2 = eVar4.f103b;
            f fVar3 = fVar.D;
            if (fVar2 == fVar3 && (eVar = eVar3.f105d) != null && eVar.f103b == fVar3) {
                return (int) ((((fVar3.t(i) - eVar2.d()) - eVar3.d()) - fVar.t(i)) * (i == 0 ? fVar.V : fVar.W));
            }
            return 0;
        }
        return 0;
    }

    private static void f(g gVar, f fVar, h hVar) {
        hVar.f116d = false;
        gVar.D0 = false;
        fVar.b0 = false;
    }

    private static int g(f fVar) {
        if (fVar.s() == f.b.MATCH_CONSTRAINT) {
            int r = (int) (fVar.H == 0 ? fVar.r() * fVar.G : fVar.r() / fVar.G);
            fVar.y0(r);
            return r;
        } else if (fVar.B() == f.b.MATCH_CONSTRAINT) {
            int D = (int) (fVar.H == 1 ? fVar.D() * fVar.G : fVar.D() / fVar.G);
            fVar.b0(D);
            return D;
        } else {
            return -1;
        }
    }

    private static void h(e eVar) {
        l f = eVar.f();
        e eVar2 = eVar.f105d;
        if (eVar2 == null || eVar2.f105d == eVar) {
            return;
        }
        eVar2.f().a(f);
    }

    public static void i(List<h> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (f fVar : list.get(i3).c(i)) {
                if (fVar.b0) {
                    l(fVar, i, i2);
                }
            }
        }
    }

    private static void j(g gVar) {
        gVar.w0.clear();
        gVar.w0.add(0, new h(gVar.k0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0181, code lost:
        if (r3.f103b == r4) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0128, code lost:
        if (r3.f103b == r4) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean k(a.e.a.j.f r8, a.e.a.j.h r9, java.util.List<a.e.a.j.h> r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.j.a.k(a.e.a.j.f, a.e.a.j.h, java.util.List, boolean):boolean");
    }

    private static void l(f fVar, int i, int i2) {
        int i3 = i * 2;
        e[] eVarArr = fVar.A;
        e eVar = eVarArr[i3];
        e eVar2 = eVarArr[i3 + 1];
        if ((eVar.f105d == null || eVar2.f105d == null) ? false : true) {
            k.e(fVar, i, e(fVar, i) + eVar.d());
        } else if (fVar.G == 0.0f || fVar.o(i) != f.b.MATCH_CONSTRAINT) {
            int v = i2 - fVar.v(i);
            int t = v - fVar.t(i);
            fVar.Z(t, v, i);
            k.e(fVar, i, t);
        } else {
            int g = g(fVar);
            int i4 = (int) fVar.A[i3].f().g;
            eVar2.f().f = eVar.f();
            eVar2.f().g = g;
            eVar2.f().f123b = 1;
            fVar.Z(i4, i4 + g, i);
        }
    }
}
