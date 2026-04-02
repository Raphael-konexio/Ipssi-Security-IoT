package androidx.navigation;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private boolean f949a;

    /* renamed from: b  reason: collision with root package name */
    private int f950b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f951c;

    /* renamed from: d  reason: collision with root package name */
    private int f952d;
    private int e;
    private int f;
    private int g;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f953a;

        /* renamed from: c  reason: collision with root package name */
        boolean f955c;

        /* renamed from: b  reason: collision with root package name */
        int f954b = -1;

        /* renamed from: d  reason: collision with root package name */
        int f956d = -1;
        int e = -1;
        int f = -1;
        int g = -1;

        public o a() {
            return new o(this.f953a, this.f954b, this.f955c, this.f956d, this.e, this.f, this.g);
        }

        public a b(int i) {
            this.f956d = i;
            return this;
        }

        public a c(int i) {
            this.e = i;
            return this;
        }

        public a d(boolean z) {
            this.f953a = z;
            return this;
        }

        public a e(int i) {
            this.f = i;
            return this;
        }

        public a f(int i) {
            this.g = i;
            return this;
        }

        public a g(int i, boolean z) {
            this.f954b = i;
            this.f955c = z;
            return this;
        }
    }

    o(boolean z, int i, boolean z2, int i2, int i3, int i4, int i5) {
        this.f949a = z;
        this.f950b = i;
        this.f951c = z2;
        this.f952d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
    }

    public int a() {
        return this.f952d;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.g;
    }

    public int e() {
        return this.f950b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.f949a == oVar.f949a && this.f950b == oVar.f950b && this.f951c == oVar.f951c && this.f952d == oVar.f952d && this.e == oVar.e && this.f == oVar.f && this.g == oVar.g;
    }

    public boolean f() {
        return this.f951c;
    }

    public boolean g() {
        return this.f949a;
    }

    public int hashCode() {
        return ((((((((((((g() ? 1 : 0) * 31) + e()) * 31) + (f() ? 1 : 0)) * 31) + a()) * 31) + b()) * 31) + c()) * 31) + d();
    }
}
