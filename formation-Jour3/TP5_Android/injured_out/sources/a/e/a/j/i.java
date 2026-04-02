package a.e.a.j;

import a.e.a.j.e;
import a.e.a.j.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends f {
    protected float k0 = -1.0f;
    protected int l0 = -1;
    protected int m0 = -1;
    private e n0 = this.t;
    private int o0 = 0;
    private boolean p0 = false;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f117a;

        static {
            int[] iArr = new int[e.d.values().length];
            f117a = iArr;
            try {
                iArr[e.d.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f117a[e.d.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f117a[e.d.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f117a[e.d.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f117a[e.d.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f117a[e.d.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f117a[e.d.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f117a[e.d.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f117a[e.d.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public i() {
        this.B.clear();
        this.B.add(this.n0);
        int length = this.A.length;
        for (int i = 0; i < length; i++) {
            this.A[i] = this.n0;
        }
    }

    @Override // a.e.a.j.f
    public void G0(a.e.a.e eVar) {
        if (u() == null) {
            return;
        }
        int y = eVar.y(this.n0);
        if (this.o0 == 1) {
            C0(y);
            D0(0);
            b0(u().r());
            y0(0);
            return;
        }
        C0(0);
        D0(y);
        y0(u().D());
        b0(0);
    }

    public int I0() {
        return this.o0;
    }

    public void J0(int i) {
        if (i > -1) {
            this.k0 = -1.0f;
            this.l0 = i;
            this.m0 = -1;
        }
    }

    public void K0(int i) {
        if (i > -1) {
            this.k0 = -1.0f;
            this.l0 = -1;
            this.m0 = i;
        }
    }

    public void L0(float f) {
        if (f > -1.0f) {
            this.k0 = f;
            this.l0 = -1;
            this.m0 = -1;
        }
    }

    public void M0(int i) {
        if (this.o0 == i) {
            return;
        }
        this.o0 = i;
        this.B.clear();
        this.n0 = this.o0 == 1 ? this.s : this.t;
        this.B.add(this.n0);
        int length = this.A.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.A[i2] = this.n0;
        }
    }

    @Override // a.e.a.j.f
    public void b(a.e.a.e eVar) {
        g gVar = (g) u();
        if (gVar == null) {
            return;
        }
        e h = gVar.h(e.d.LEFT);
        e h2 = gVar.h(e.d.RIGHT);
        f fVar = this.D;
        boolean z = true;
        boolean z2 = fVar != null && fVar.C[0] == f.b.WRAP_CONTENT;
        if (this.o0 == 0) {
            h = gVar.h(e.d.TOP);
            h2 = gVar.h(e.d.BOTTOM);
            f fVar2 = this.D;
            z2 = (fVar2 == null || fVar2.C[1] != f.b.WRAP_CONTENT) ? false : false;
        }
        if (this.l0 != -1) {
            a.e.a.i r = eVar.r(this.n0);
            eVar.e(r, eVar.r(h), this.l0, 6);
            if (z2) {
                eVar.i(eVar.r(h2), r, 0, 5);
            }
        } else if (this.m0 == -1) {
            if (this.k0 != -1.0f) {
                eVar.d(a.e.a.e.t(eVar, eVar.r(this.n0), eVar.r(h), eVar.r(h2), this.k0, this.p0));
            }
        } else {
            a.e.a.i r2 = eVar.r(this.n0);
            a.e.a.i r3 = eVar.r(h2);
            eVar.e(r2, r3, -this.m0, 6);
            if (z2) {
                eVar.i(r2, eVar.r(h), 0, 5);
                eVar.i(r3, r2, 0, 5);
            }
        }
    }

    @Override // a.e.a.j.f
    public boolean c() {
        return true;
    }

    @Override // a.e.a.j.f
    public void d(int i) {
        int i2;
        l f;
        e eVar;
        l f2;
        e eVar2;
        e eVar3;
        l f3;
        int i3;
        f u = u();
        if (u == null) {
            return;
        }
        if (I0() == 1) {
            this.t.f().h(1, u.t.f(), 0);
            this.v.f().h(1, u.t.f(), 0);
            if (this.l0 != -1) {
                this.s.f().h(1, u.s.f(), this.l0);
                f2 = this.u.f();
                eVar3 = u.s;
                f3 = eVar3.f();
                i3 = this.l0;
            } else if (this.m0 == -1) {
                if (this.k0 == -1.0f || u.s() != f.b.FIXED) {
                    return;
                }
                i2 = (int) (u.E * this.k0);
                this.s.f().h(1, u.s.f(), i2);
                f = this.u.f();
                eVar = u.s;
                f.h(1, eVar.f(), i2);
                return;
            } else {
                this.s.f().h(1, u.u.f(), -this.m0);
                f2 = this.u.f();
                eVar2 = u.u;
                f3 = eVar2.f();
                i3 = -this.m0;
            }
        } else {
            this.s.f().h(1, u.s.f(), 0);
            this.u.f().h(1, u.s.f(), 0);
            if (this.l0 != -1) {
                this.t.f().h(1, u.t.f(), this.l0);
                f2 = this.v.f();
                eVar3 = u.t;
                f3 = eVar3.f();
                i3 = this.l0;
            } else if (this.m0 == -1) {
                if (this.k0 == -1.0f || u.B() != f.b.FIXED) {
                    return;
                }
                i2 = (int) (u.F * this.k0);
                this.t.f().h(1, u.t.f(), i2);
                f = this.v.f();
                eVar = u.t;
                f.h(1, eVar.f(), i2);
                return;
            } else {
                this.t.f().h(1, u.v.f(), -this.m0);
                f2 = this.v.f();
                eVar2 = u.v;
                f3 = eVar2.f();
                i3 = -this.m0;
            }
        }
        f2.h(1, f3, i3);
    }

    @Override // a.e.a.j.f
    public e h(e.d dVar) {
        switch (a.f117a[dVar.ordinal()]) {
            case 1:
            case 2:
                if (this.o0 == 1) {
                    return this.n0;
                }
                break;
            case 3:
            case 4:
                if (this.o0 == 0) {
                    return this.n0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(dVar.name());
    }

    @Override // a.e.a.j.f
    public ArrayList<e> i() {
        return this.B;
    }
}
