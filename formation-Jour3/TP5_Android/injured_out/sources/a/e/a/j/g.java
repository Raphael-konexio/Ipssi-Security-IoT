package a.e.a.j;

import a.e.a.j.e;
import a.e.a.j.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class g extends p {
    private o n0;
    int o0;
    int p0;
    int q0;
    int r0;
    private boolean l0 = false;
    protected a.e.a.e m0 = new a.e.a.e();
    int s0 = 0;
    int t0 = 0;
    d[] u0 = new d[4];
    d[] v0 = new d[4];
    public List<h> w0 = new ArrayList();
    public boolean x0 = false;
    public boolean y0 = false;
    public boolean z0 = false;
    public int A0 = 0;
    public int B0 = 0;
    private int C0 = 7;
    public boolean D0 = false;
    private boolean E0 = false;
    private boolean F0 = false;

    private void P0(f fVar) {
        int i = this.s0 + 1;
        d[] dVarArr = this.v0;
        if (i >= dVarArr.length) {
            this.v0 = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.v0[this.s0] = new d(fVar, 0, U0());
        this.s0++;
    }

    private void Q0(f fVar) {
        int i = this.t0 + 1;
        d[] dVarArr = this.u0;
        if (i >= dVarArr.length) {
            this.u0 = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.u0[this.t0] = new d(fVar, 1, U0());
        this.t0++;
    }

    private void b1() {
        this.s0 = 0;
        this.t0 = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01d6  */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v27 */
    @Override // a.e.a.j.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void K0() {
        /*
            Method dump skipped, instructions count: 833
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.j.g.K0():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N0(f fVar, int i) {
        if (i == 0) {
            P0(fVar);
        } else if (i == 1) {
            Q0(fVar);
        }
    }

    public boolean O0(a.e.a.e eVar) {
        b(eVar);
        int size = this.k0.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.k0.get(i);
            if (fVar instanceof g) {
                f.b[] bVarArr = fVar.C;
                f.b bVar = bVarArr[0];
                f.b bVar2 = bVarArr[1];
                if (bVar == f.b.WRAP_CONTENT) {
                    fVar.g0(f.b.FIXED);
                }
                if (bVar2 == f.b.WRAP_CONTENT) {
                    fVar.u0(f.b.FIXED);
                }
                fVar.b(eVar);
                if (bVar == f.b.WRAP_CONTENT) {
                    fVar.g0(bVar);
                }
                if (bVar2 == f.b.WRAP_CONTENT) {
                    fVar.u0(bVar2);
                }
            } else {
                k.c(this, eVar, fVar);
                fVar.b(eVar);
            }
        }
        if (this.s0 > 0) {
            c.a(this, eVar, 0);
        }
        if (this.t0 > 0) {
            c.a(this, eVar, 1);
        }
        return true;
    }

    @Override // a.e.a.j.p, a.e.a.j.f
    public void Q() {
        this.m0.E();
        this.o0 = 0;
        this.q0 = 0;
        this.p0 = 0;
        this.r0 = 0;
        this.w0.clear();
        this.D0 = false;
        super.Q();
    }

    public int R0() {
        return this.C0;
    }

    public boolean S0() {
        return false;
    }

    public boolean T0() {
        return this.F0;
    }

    public boolean U0() {
        return this.l0;
    }

    public boolean V0() {
        return this.E0;
    }

    public void W0() {
        if (!X0(8)) {
            d(this.C0);
        }
        e1();
    }

    public boolean X0(int i) {
        return (this.C0 & i) == i;
    }

    public void Y0(int i, int i2) {
        m mVar;
        m mVar2;
        if (this.C[0] != f.b.WRAP_CONTENT && (mVar2 = this.f109c) != null) {
            mVar2.h(i);
        }
        if (this.C[1] == f.b.WRAP_CONTENT || (mVar = this.f110d) == null) {
            return;
        }
        mVar.h(i2);
    }

    public void Z0() {
        int size = this.k0.size();
        S();
        for (int i = 0; i < size; i++) {
            this.k0.get(i).S();
        }
    }

    public void a1() {
        Z0();
        d(this.C0);
    }

    public void c1(int i) {
        this.C0 = i;
    }

    @Override // a.e.a.j.f
    public void d(int i) {
        super.d(i);
        int size = this.k0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.k0.get(i2).d(i);
        }
    }

    public void d1(boolean z) {
        this.l0 = z;
    }

    public void e1() {
        l f = h(e.d.LEFT).f();
        l f2 = h(e.d.TOP).f();
        f.l(null, 0.0f);
        f2.l(null, 0.0f);
    }

    public void f1(a.e.a.e eVar, boolean[] zArr) {
        zArr[2] = false;
        G0(eVar);
        int size = this.k0.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.k0.get(i);
            fVar.G0(eVar);
            if (fVar.C[0] == f.b.MATCH_CONSTRAINT && fVar.D() < fVar.F()) {
                zArr[2] = true;
            }
            if (fVar.C[1] == f.b.MATCH_CONSTRAINT && fVar.r() < fVar.E()) {
                zArr[2] = true;
            }
        }
    }
}
