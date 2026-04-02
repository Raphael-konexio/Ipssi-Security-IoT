package a.e.a.j;

import a.e.a.j.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends j {
    private int m0 = 0;
    private ArrayList<l> n0 = new ArrayList<>(4);
    private boolean o0 = true;

    public void K0(boolean z) {
        this.o0 = z;
    }

    public void L0(int i) {
        this.m0 = i;
    }

    @Override // a.e.a.j.f
    public void S() {
        super.S();
        this.n0.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0084  */
    @Override // a.e.a.j.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void U() {
        /*
            r11 = this;
            int r0 = r11.m0
            r1 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L20
            if (r0 == r4) goto L18
            if (r0 == r3) goto L15
            if (r0 == r2) goto L12
            return
        L12:
            a.e.a.j.e r0 = r11.v
            goto L1a
        L15:
            a.e.a.j.e r0 = r11.t
            goto L22
        L18:
            a.e.a.j.e r0 = r11.u
        L1a:
            a.e.a.j.l r0 = r0.f()
            r1 = 0
            goto L26
        L20:
            a.e.a.j.e r0 = r11.s
        L22:
            a.e.a.j.l r0 = r0.f()
        L26:
            java.util.ArrayList<a.e.a.j.l> r5 = r11.n0
            int r5 = r5.size()
            r6 = 0
            r7 = 0
        L2e:
            if (r7 >= r5) goto L58
            java.util.ArrayList<a.e.a.j.l> r8 = r11.n0
            java.lang.Object r8 = r8.get(r7)
            a.e.a.j.l r8 = (a.e.a.j.l) r8
            int r9 = r8.f123b
            if (r9 == r4) goto L3d
            return
        L3d:
            int r9 = r11.m0
            if (r9 == 0) goto L4b
            if (r9 != r3) goto L44
            goto L4b
        L44:
            float r9 = r8.g
            int r10 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r10 <= 0) goto L55
            goto L51
        L4b:
            float r9 = r8.g
            int r10 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r10 >= 0) goto L55
        L51:
            a.e.a.j.l r1 = r8.f
            r6 = r1
            r1 = r9
        L55:
            int r7 = r7 + 1
            goto L2e
        L58:
            a.e.a.f r5 = a.e.a.e.x()
            if (r5 == 0) goto L69
            a.e.a.f r5 = a.e.a.e.x()
            long r7 = r5.y
            r9 = 1
            long r7 = r7 + r9
            r5.y = r7
        L69:
            r0.f = r6
            r0.g = r1
            r0.b()
            int r0 = r11.m0
            if (r0 == 0) goto L84
            if (r0 == r4) goto L81
            if (r0 == r3) goto L7e
            if (r0 == r2) goto L7b
            return
        L7b:
            a.e.a.j.e r0 = r11.t
            goto L86
        L7e:
            a.e.a.j.e r0 = r11.v
            goto L86
        L81:
            a.e.a.j.e r0 = r11.s
            goto L86
        L84:
            a.e.a.j.e r0 = r11.u
        L86:
            a.e.a.j.l r0 = r0.f()
            r0.l(r6, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.j.b.U():void");
    }

    @Override // a.e.a.j.f
    public void b(a.e.a.e eVar) {
        Object[] objArr;
        boolean z;
        a.e.a.i iVar;
        e eVar2;
        int i;
        int i2;
        e[] eVarArr = this.A;
        eVarArr[0] = this.s;
        eVarArr[2] = this.t;
        eVarArr[1] = this.u;
        eVarArr[3] = this.v;
        int i3 = 0;
        while (true) {
            objArr = this.A;
            if (i3 >= objArr.length) {
                break;
            }
            objArr[i3].i = eVar.r(objArr[i3]);
            i3++;
        }
        int i4 = this.m0;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        e eVar3 = objArr[i4];
        for (int i5 = 0; i5 < this.l0; i5++) {
            f fVar = this.k0[i5];
            if ((this.o0 || fVar.c()) && ((((i = this.m0) == 0 || i == 1) && fVar.s() == f.b.MATCH_CONSTRAINT) || (((i2 = this.m0) == 2 || i2 == 3) && fVar.B() == f.b.MATCH_CONSTRAINT))) {
                z = true;
                break;
            }
        }
        z = false;
        int i6 = this.m0;
        if (i6 == 0 || i6 == 1 ? u().s() == f.b.WRAP_CONTENT : u().B() == f.b.WRAP_CONTENT) {
            z = false;
        }
        for (int i7 = 0; i7 < this.l0; i7++) {
            f fVar2 = this.k0[i7];
            if (this.o0 || fVar2.c()) {
                a.e.a.i r = eVar.r(fVar2.A[this.m0]);
                e[] eVarArr2 = fVar2.A;
                int i8 = this.m0;
                eVarArr2[i8].i = r;
                if (i8 == 0 || i8 == 2) {
                    eVar.j(eVar3.i, r, z);
                } else {
                    eVar.h(eVar3.i, r, z);
                }
            }
        }
        int i9 = this.m0;
        if (i9 == 0) {
            eVar.e(this.u.i, this.s.i, 0, 6);
            if (z) {
                return;
            }
            iVar = this.s.i;
            eVar2 = this.D.u;
        } else if (i9 == 1) {
            eVar.e(this.s.i, this.u.i, 0, 6);
            if (z) {
                return;
            }
            iVar = this.s.i;
            eVar2 = this.D.s;
        } else if (i9 == 2) {
            eVar.e(this.v.i, this.t.i, 0, 6);
            if (z) {
                return;
            }
            iVar = this.t.i;
            eVar2 = this.D.v;
        } else if (i9 != 3) {
            return;
        } else {
            eVar.e(this.t.i, this.v.i, 0, 6);
            if (z) {
                return;
            }
            iVar = this.t.i;
            eVar2 = this.D.t;
        }
        eVar.e(iVar, eVar2.i, 0, 5);
    }

    @Override // a.e.a.j.f
    public boolean c() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0094 A[SYNTHETIC] */
    @Override // a.e.a.j.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(int r8) {
        /*
            r7 = this;
            a.e.a.j.f r8 = r7.D
            if (r8 != 0) goto L5
            return
        L5:
            a.e.a.j.g r8 = (a.e.a.j.g) r8
            r0 = 2
            boolean r8 = r8.X0(r0)
            if (r8 != 0) goto Lf
            return
        Lf:
            int r8 = r7.m0
            r1 = 3
            r2 = 1
            if (r8 == 0) goto L25
            if (r8 == r2) goto L22
            if (r8 == r0) goto L1f
            if (r8 == r1) goto L1c
            return
        L1c:
            a.e.a.j.e r8 = r7.v
            goto L27
        L1f:
            a.e.a.j.e r8 = r7.t
            goto L27
        L22:
            a.e.a.j.e r8 = r7.u
            goto L27
        L25:
            a.e.a.j.e r8 = r7.s
        L27:
            a.e.a.j.l r8 = r8.f()
            r3 = 5
            r8.p(r3)
            int r3 = r7.m0
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L44
            if (r3 != r2) goto L38
            goto L44
        L38:
            a.e.a.j.e r3 = r7.s
            a.e.a.j.l r3 = r3.f()
            r3.l(r5, r4)
            a.e.a.j.e r3 = r7.u
            goto L4f
        L44:
            a.e.a.j.e r3 = r7.t
            a.e.a.j.l r3 = r3.f()
            r3.l(r5, r4)
            a.e.a.j.e r3 = r7.v
        L4f:
            a.e.a.j.l r3 = r3.f()
            r3.l(r5, r4)
            java.util.ArrayList<a.e.a.j.l> r3 = r7.n0
            r3.clear()
            r3 = 0
        L5c:
            int r4 = r7.l0
            if (r3 >= r4) goto L97
            a.e.a.j.f[] r4 = r7.k0
            r4 = r4[r3]
            boolean r6 = r7.o0
            if (r6 != 0) goto L6f
            boolean r6 = r4.c()
            if (r6 != 0) goto L6f
            goto L94
        L6f:
            int r6 = r7.m0
            if (r6 == 0) goto L84
            if (r6 == r2) goto L81
            if (r6 == r0) goto L7e
            if (r6 == r1) goto L7b
            r4 = r5
            goto L8a
        L7b:
            a.e.a.j.e r4 = r4.v
            goto L86
        L7e:
            a.e.a.j.e r4 = r4.t
            goto L86
        L81:
            a.e.a.j.e r4 = r4.u
            goto L86
        L84:
            a.e.a.j.e r4 = r4.s
        L86:
            a.e.a.j.l r4 = r4.f()
        L8a:
            if (r4 == 0) goto L94
            java.util.ArrayList<a.e.a.j.l> r6 = r7.n0
            r6.add(r4)
            r4.a(r8)
        L94:
            int r3 = r3 + 1
            goto L5c
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.j.b.d(int):void");
    }
}
