package a.e.a.j;

import a.e.a.i;
/* loaded from: classes.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    final f f103b;

    /* renamed from: c  reason: collision with root package name */
    final d f104c;

    /* renamed from: d  reason: collision with root package name */
    e f105d;
    private int h;
    a.e.a.i i;

    /* renamed from: a  reason: collision with root package name */
    private l f102a = new l(this);
    public int e = 0;
    int f = -1;
    private c g = c.NONE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f106a;

        static {
            int[] iArr = new int[d.values().length];
            f106a = iArr;
            try {
                iArr[d.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f106a[d.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f106a[d.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f106a[d.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f106a[d.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f106a[d.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f106a[d.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f106a[d.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f106a[d.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        RELAXED,
        STRICT
    }

    /* loaded from: classes.dex */
    public enum c {
        NONE,
        STRONG,
        WEAK
    }

    /* loaded from: classes.dex */
    public enum d {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public e(f fVar, d dVar) {
        b bVar = b.RELAXED;
        this.h = 0;
        this.f103b = fVar;
        this.f104c = dVar;
    }

    public boolean a(e eVar, int i, int i2, c cVar, int i3, boolean z) {
        if (eVar == null) {
            this.f105d = null;
            this.e = 0;
            this.f = -1;
            this.g = c.NONE;
            this.h = 2;
            return true;
        } else if (z || l(eVar)) {
            this.f105d = eVar;
            if (i > 0) {
                this.e = i;
            } else {
                this.e = 0;
            }
            this.f = i2;
            this.g = cVar;
            this.h = i3;
            return true;
        } else {
            return false;
        }
    }

    public boolean b(e eVar, int i, c cVar, int i2) {
        return a(eVar, i, -1, cVar, i2, false);
    }

    public int c() {
        return this.h;
    }

    public int d() {
        e eVar;
        if (this.f103b.C() == 8) {
            return 0;
        }
        return (this.f <= -1 || (eVar = this.f105d) == null || eVar.f103b.C() != 8) ? this.e : this.f;
    }

    public f e() {
        return this.f103b;
    }

    public l f() {
        return this.f102a;
    }

    public a.e.a.i g() {
        return this.i;
    }

    public c h() {
        return this.g;
    }

    public e i() {
        return this.f105d;
    }

    public d j() {
        return this.f104c;
    }

    public boolean k() {
        return this.f105d != null;
    }

    public boolean l(e eVar) {
        boolean z = false;
        if (eVar == null) {
            return false;
        }
        d j = eVar.j();
        d dVar = this.f104c;
        if (j == dVar) {
            return dVar != d.BASELINE || (eVar.e().I() && e().I());
        }
        switch (a.f106a[dVar.ordinal()]) {
            case 1:
                return (j == d.BASELINE || j == d.CENTER_X || j == d.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z2 = j == d.LEFT || j == d.RIGHT;
                if (eVar.e() instanceof i) {
                    return (z2 || j == d.CENTER_X) ? true : true;
                }
                return z2;
            case 4:
            case 5:
                boolean z3 = j == d.TOP || j == d.BOTTOM;
                if (eVar.e() instanceof i) {
                    return (z3 || j == d.CENTER_Y) ? true : true;
                }
                return z3;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f104c.name());
        }
    }

    public void m() {
        this.f105d = null;
        this.e = 0;
        this.f = -1;
        this.g = c.STRONG;
        this.h = 0;
        b bVar = b.RELAXED;
        this.f102a.e();
    }

    public void n(a.e.a.c cVar) {
        a.e.a.i iVar = this.i;
        if (iVar == null) {
            this.i = new a.e.a.i(i.a.UNRESTRICTED, null);
        } else {
            iVar.d();
        }
    }

    public String toString() {
        return this.f103b.n() + ":" + this.f104c.toString();
    }
}
