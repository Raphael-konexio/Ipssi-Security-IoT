package a.e.a.j;

import a.e.a.j.e;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    public static float j0 = 0.5f;
    protected e[] A;
    protected ArrayList<e> B;
    protected b[] C;
    f D;
    int E;
    int F;
    protected float G;
    protected int H;
    protected int I;
    protected int J;
    int K;
    int L;
    private int M;
    private int N;
    protected int O;
    protected int P;
    int Q;
    protected int R;
    protected int S;
    private int T;
    private int U;
    float V;
    float W;
    private Object X;
    private int Y;
    private String Z;
    private String a0;
    boolean b0;

    /* renamed from: c  reason: collision with root package name */
    m f109c;
    boolean c0;

    /* renamed from: d  reason: collision with root package name */
    m f110d;
    boolean d0;
    int e0;
    int f0;
    float[] g0;
    protected f[] h0;
    protected f[] i0;
    e z;

    /* renamed from: a  reason: collision with root package name */
    public int f107a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f108b = -1;
    int e = 0;
    int f = 0;
    int[] g = new int[2];
    int h = 0;
    int i = 0;
    float j = 1.0f;
    int k = 0;
    int l = 0;
    float m = 1.0f;
    int n = -1;
    float o = 1.0f;
    h p = null;
    private int[] q = {Reader.READ_DONE, Reader.READ_DONE};
    private float r = 0.0f;
    e s = new e(this, e.d.LEFT);
    e t = new e(this, e.d.TOP);
    e u = new e(this, e.d.RIGHT);
    e v = new e(this, e.d.BOTTOM);
    e w = new e(this, e.d.BASELINE);
    e x = new e(this, e.d.CENTER_X);
    e y = new e(this, e.d.CENTER_Y);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f111a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f112b;

        static {
            int[] iArr = new int[b.values().length];
            f112b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f112b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f112b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f112b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[e.d.values().length];
            f111a = iArr2;
            try {
                iArr2[e.d.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f111a[e.d.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f111a[e.d.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f111a[e.d.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f111a[e.d.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f111a[e.d.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f111a[e.d.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f111a[e.d.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f111a[e.d.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public f() {
        e eVar = new e(this, e.d.CENTER);
        this.z = eVar;
        this.A = new e[]{this.s, this.u, this.t, this.v, this.w, eVar};
        this.B = new ArrayList<>();
        b bVar = b.FIXED;
        this.C = new b[]{bVar, bVar};
        this.D = null;
        this.E = 0;
        this.F = 0;
        this.G = 0.0f;
        this.H = -1;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        float f = j0;
        this.V = f;
        this.W = f;
        this.Y = 0;
        this.Z = null;
        this.a0 = null;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = new float[]{-1.0f, -1.0f};
        this.h0 = new f[]{null, null};
        this.i0 = new f[]{null, null};
        a();
    }

    private boolean K(int i) {
        int i2 = i * 2;
        e[] eVarArr = this.A;
        if (eVarArr[i2].f105d != null && eVarArr[i2].f105d.f105d != eVarArr[i2]) {
            int i3 = i2 + 1;
            if (eVarArr[i3].f105d != null && eVarArr[i3].f105d.f105d == eVarArr[i3]) {
                return true;
            }
        }
        return false;
    }

    private void a() {
        this.B.add(this.s);
        this.B.add(this.t);
        this.B.add(this.u);
        this.B.add(this.v);
        this.B.add(this.x);
        this.B.add(this.y);
        this.B.add(this.z);
        this.B.add(this.w);
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x01ef, code lost:
        if (r25 != false) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02db A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void e(a.e.a.e r24, boolean r25, a.e.a.i r26, a.e.a.i r27, a.e.a.j.f.b r28, boolean r29, a.e.a.j.e r30, a.e.a.j.e r31, int r32, int r33, int r34, int r35, float r36, boolean r37, boolean r38, int r39, int r40, int r41, float r42, boolean r43) {
        /*
            Method dump skipped, instructions count: 792
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.j.f.e(a.e.a.e, boolean, a.e.a.i, a.e.a.i, a.e.a.j.f$b, boolean, a.e.a.j.e, a.e.a.j.e, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int A() {
        return this.J + this.P;
    }

    public void A0(int i) {
        this.U = i;
    }

    public b B() {
        return this.C[1];
    }

    public void B0(int i) {
        this.T = i;
    }

    public int C() {
        return this.Y;
    }

    public void C0(int i) {
        this.I = i;
    }

    public int D() {
        if (this.Y == 8) {
            return 0;
        }
        return this.E;
    }

    public void D0(int i) {
        this.J = i;
    }

    public int E() {
        return this.U;
    }

    public void E0(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.n == -1) {
            if (z3 && !z4) {
                this.n = 0;
            } else if (!z3 && z4) {
                this.n = 1;
                if (this.H == -1) {
                    this.o = 1.0f / this.o;
                }
            }
        }
        if (this.n == 0 && (!this.t.k() || !this.v.k())) {
            this.n = 1;
        } else if (this.n == 1 && (!this.s.k() || !this.u.k())) {
            this.n = 0;
        }
        if (this.n == -1 && (!this.t.k() || !this.v.k() || !this.s.k() || !this.u.k())) {
            if (this.t.k() && this.v.k()) {
                this.n = 0;
            } else if (this.s.k() && this.u.k()) {
                this.o = 1.0f / this.o;
                this.n = 1;
            }
        }
        if (this.n == -1) {
            if (z && !z2) {
                this.n = 0;
            } else if (!z && z2) {
                this.o = 1.0f / this.o;
                this.n = 1;
            }
        }
        if (this.n == -1) {
            if (this.h > 0 && this.k == 0) {
                this.n = 0;
            } else if (this.h == 0 && this.k > 0) {
                this.o = 1.0f / this.o;
                this.n = 1;
            }
        }
        if (this.n == -1 && z && z2) {
            this.o = 1.0f / this.o;
            this.n = 1;
        }
    }

    public int F() {
        return this.T;
    }

    public void F0() {
        int i = this.I;
        int i2 = this.J;
        this.M = i;
        this.N = i2;
    }

    public int G() {
        return this.I;
    }

    public void G0(a.e.a.e eVar) {
        int y = eVar.y(this.s);
        int y2 = eVar.y(this.t);
        int y3 = eVar.y(this.u);
        int y4 = eVar.y(this.v);
        int i = y4 - y2;
        if (y3 - y < 0 || i < 0 || y == Integer.MIN_VALUE || y == Integer.MAX_VALUE || y2 == Integer.MIN_VALUE || y2 == Integer.MAX_VALUE || y3 == Integer.MIN_VALUE || y3 == Integer.MAX_VALUE || y4 == Integer.MIN_VALUE || y4 == Integer.MAX_VALUE) {
            y4 = 0;
            y = 0;
            y2 = 0;
            y3 = 0;
        }
        a0(y, y2, y3, y4);
    }

    public int H() {
        return this.J;
    }

    public void H0() {
        for (int i = 0; i < 6; i++) {
            this.A[i].f().q();
        }
    }

    public boolean I() {
        return this.Q > 0;
    }

    public void J(e.d dVar, f fVar, e.d dVar2, int i, int i2) {
        h(dVar).a(fVar.h(dVar2), i, i2, e.c.STRONG, 0, true);
    }

    public boolean L() {
        return this.s.f().f123b == 1 && this.u.f().f123b == 1 && this.t.f().f123b == 1 && this.v.f().f123b == 1;
    }

    public boolean M() {
        e eVar = this.s;
        e eVar2 = eVar.f105d;
        if (eVar2 == null || eVar2.f105d != eVar) {
            e eVar3 = this.u;
            e eVar4 = eVar3.f105d;
            return eVar4 != null && eVar4.f105d == eVar3;
        }
        return true;
    }

    public boolean N() {
        e eVar = this.t;
        e eVar2 = eVar.f105d;
        if (eVar2 == null || eVar2.f105d != eVar) {
            e eVar3 = this.v;
            e eVar4 = eVar3.f105d;
            return eVar4 != null && eVar4.f105d == eVar3;
        }
        return true;
    }

    public boolean O() {
        return this.f == 0 && this.G == 0.0f && this.k == 0 && this.l == 0 && this.C[1] == b.MATCH_CONSTRAINT;
    }

    public boolean P() {
        return this.e == 0 && this.G == 0.0f && this.h == 0 && this.i == 0 && this.C[0] == b.MATCH_CONSTRAINT;
    }

    public void Q() {
        this.s.m();
        this.t.m();
        this.u.m();
        this.v.m();
        this.w.m();
        this.x.m();
        this.y.m();
        this.z.m();
        this.D = null;
        this.r = 0.0f;
        this.E = 0;
        this.F = 0;
        this.G = 0.0f;
        this.H = -1;
        this.I = 0;
        this.J = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        float f = j0;
        this.V = f;
        this.W = f;
        b[] bVarArr = this.C;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.X = null;
        this.Y = 0;
        this.a0 = null;
        this.e0 = 0;
        this.f0 = 0;
        float[] fArr = this.g0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f107a = -1;
        this.f108b = -1;
        int[] iArr = this.q;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.e = 0;
        this.f = 0;
        this.j = 1.0f;
        this.m = 1.0f;
        this.i = Reader.READ_DONE;
        this.l = Reader.READ_DONE;
        this.h = 0;
        this.k = 0;
        this.n = -1;
        this.o = 1.0f;
        m mVar = this.f109c;
        if (mVar != null) {
            mVar.e();
        }
        m mVar2 = this.f110d;
        if (mVar2 != null) {
            mVar2.e();
        }
        this.p = null;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
    }

    public void R() {
        f u = u();
        if (u != null && (u instanceof g) && ((g) u()).S0()) {
            return;
        }
        int size = this.B.size();
        for (int i = 0; i < size; i++) {
            this.B.get(i).m();
        }
    }

    public void S() {
        for (int i = 0; i < 6; i++) {
            this.A[i].f().e();
        }
    }

    public void T(a.e.a.c cVar) {
        this.s.n(cVar);
        this.t.n(cVar);
        this.u.n(cVar);
        this.v.n(cVar);
        this.w.n(cVar);
        this.z.n(cVar);
        this.x.n(cVar);
        this.y.n(cVar);
    }

    public void U() {
    }

    public void V(int i) {
        this.Q = i;
    }

    public void W(Object obj) {
        this.X = obj;
    }

    public void X(String str) {
        this.Z = str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please submit an issue!!! */
    public void Y(String str) {
        float f;
        int i = 0;
        if (str == null || str.length() == 0) {
            this.G = 0.0f;
            return;
        }
        int i2 = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i3 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase("W")) {
                i2 = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i2 = 1;
            }
            i3 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i3);
            if (substring2.length() > 0) {
                f = Float.parseFloat(substring2);
            }
            f = 0.0f;
        } else {
            String substring3 = str.substring(i3, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                float parseFloat = Float.parseFloat(substring3);
                float parseFloat2 = Float.parseFloat(substring4);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    f = i2 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                }
            }
            f = 0.0f;
        }
        i = (f > i ? 1 : (f == i ? 0 : -1));
        if (i > 0) {
            this.G = f;
            this.H = i2;
        }
    }

    public void Z(int i, int i2, int i3) {
        if (i3 == 0) {
            f0(i, i2);
        } else if (i3 == 1) {
            t0(i, i2);
        }
        this.c0 = true;
    }

    public void a0(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.I = i;
        this.J = i2;
        if (this.Y == 8) {
            this.E = 0;
            this.F = 0;
            return;
        }
        if (this.C[0] == b.FIXED && i7 < (i6 = this.E)) {
            i7 = i6;
        }
        if (this.C[1] == b.FIXED && i8 < (i5 = this.F)) {
            i8 = i5;
        }
        this.E = i7;
        this.F = i8;
        int i9 = this.S;
        if (i8 < i9) {
            this.F = i9;
        }
        int i10 = this.E;
        int i11 = this.R;
        if (i10 < i11) {
            this.E = i11;
        }
        this.c0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x024c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(a.e.a.e r39) {
        /*
            Method dump skipped, instructions count: 843
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.j.f.b(a.e.a.e):void");
    }

    public void b0(int i) {
        this.F = i;
        int i2 = this.S;
        if (i < i2) {
            this.F = i2;
        }
    }

    public boolean c() {
        return this.Y != 8;
    }

    public void c0(boolean z) {
    }

    public void d(int i) {
        k.a(i, this);
    }

    public void d0(float f) {
        this.V = f;
    }

    public void e0(int i) {
        this.e0 = i;
    }

    public void f(f fVar, float f, int i) {
        e.d dVar = e.d.CENTER;
        J(dVar, fVar, dVar, i, 0);
        this.r = f;
    }

    public void f0(int i, int i2) {
        this.I = i;
        int i3 = i2 - i;
        this.E = i3;
        int i4 = this.R;
        if (i3 < i4) {
            this.E = i4;
        }
    }

    public void g(a.e.a.e eVar) {
        eVar.r(this.s);
        eVar.r(this.t);
        eVar.r(this.u);
        eVar.r(this.v);
        if (this.Q > 0) {
            eVar.r(this.w);
        }
    }

    public void g0(b bVar) {
        this.C[0] = bVar;
        if (bVar == b.WRAP_CONTENT) {
            y0(this.T);
        }
    }

    public e h(e.d dVar) {
        switch (a.f111a[dVar.ordinal()]) {
            case 1:
                return this.s;
            case 2:
                return this.t;
            case 3:
                return this.u;
            case 4:
                return this.v;
            case 5:
                return this.w;
            case 6:
                return this.z;
            case 7:
                return this.x;
            case 8:
                return this.y;
            case 9:
                return null;
            default:
                throw new AssertionError(dVar.name());
        }
    }

    public void h0(int i, int i2, int i3, float f) {
        this.e = i;
        this.h = i2;
        this.i = i3;
        this.j = f;
        if (f >= 1.0f || i != 0) {
            return;
        }
        this.e = 2;
    }

    public ArrayList<e> i() {
        return this.B;
    }

    public void i0(float f) {
        this.g0[0] = f;
    }

    public int j() {
        return this.Q;
    }

    public void j0(int i) {
        this.q[1] = i;
    }

    public float k(int i) {
        if (i == 0) {
            return this.V;
        }
        if (i == 1) {
            return this.W;
        }
        return -1.0f;
    }

    public void k0(int i) {
        this.q[0] = i;
    }

    public int l() {
        return H() + this.F;
    }

    public void l0(int i) {
        if (i < 0) {
            i = 0;
        }
        this.S = i;
    }

    public Object m() {
        return this.X;
    }

    public void m0(int i) {
        if (i < 0) {
            i = 0;
        }
        this.R = i;
    }

    public String n() {
        return this.Z;
    }

    public void n0(int i, int i2) {
        this.O = i;
        this.P = i2;
    }

    public b o(int i) {
        if (i == 0) {
            return s();
        }
        if (i == 1) {
            return B();
        }
        return null;
    }

    public void o0(int i, int i2) {
        this.I = i;
        this.J = i2;
    }

    public int p() {
        return this.M + this.O;
    }

    public void p0(f fVar) {
        this.D = fVar;
    }

    public int q() {
        return this.N + this.P;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q0(int i, int i2) {
        if (i2 == 0) {
            this.K = i;
        } else if (i2 == 1) {
            this.L = i;
        }
    }

    public int r() {
        if (this.Y == 8) {
            return 0;
        }
        return this.F;
    }

    public void r0(float f) {
        this.W = f;
    }

    public b s() {
        return this.C[0];
    }

    public void s0(int i) {
        this.f0 = i;
    }

    public int t(int i) {
        if (i == 0) {
            return D();
        }
        if (i == 1) {
            return r();
        }
        return 0;
    }

    public void t0(int i, int i2) {
        this.J = i;
        int i3 = i2 - i;
        this.F = i3;
        int i4 = this.S;
        if (i3 < i4) {
            this.F = i4;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.a0 != null) {
            str = "type: " + this.a0 + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.Z != null) {
            str2 = "id: " + this.Z + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.I);
        sb.append(", ");
        sb.append(this.J);
        sb.append(") - (");
        sb.append(this.E);
        sb.append(" x ");
        sb.append(this.F);
        sb.append(") wrap: (");
        sb.append(this.T);
        sb.append(" x ");
        sb.append(this.U);
        sb.append(")");
        return sb.toString();
    }

    public f u() {
        return this.D;
    }

    public void u0(b bVar) {
        this.C[1] = bVar;
        if (bVar == b.WRAP_CONTENT) {
            b0(this.U);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int v(int i) {
        if (i == 0) {
            return this.K;
        }
        if (i == 1) {
            return this.L;
        }
        return 0;
    }

    public void v0(int i, int i2, int i3, float f) {
        this.f = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        if (f >= 1.0f || i != 0) {
            return;
        }
        this.f = 2;
    }

    public m w() {
        if (this.f110d == null) {
            this.f110d = new m();
        }
        return this.f110d;
    }

    public void w0(float f) {
        this.g0[1] = f;
    }

    public m x() {
        if (this.f109c == null) {
            this.f109c = new m();
        }
        return this.f109c;
    }

    public void x0(int i) {
        this.Y = i;
    }

    public int y() {
        return G() + this.E;
    }

    public void y0(int i) {
        this.E = i;
        int i2 = this.R;
        if (i < i2) {
            this.E = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int z() {
        return this.I + this.O;
    }

    public void z0(boolean z) {
    }
}
