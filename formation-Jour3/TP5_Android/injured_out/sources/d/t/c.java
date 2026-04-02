package d.t;
/* loaded from: classes.dex */
public final class c extends d.t.a {
    public static final a k = new a(null);
    private static final c j = new c(1, 0);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d.s.d.e eVar) {
            this();
        }

        public final c a() {
            return c.j;
        }
    }

    public c(int i, int i2) {
        super(i, i2, 1);
    }

    @Override // d.t.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (d() != cVar.d() || e() != cVar.e()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // d.t.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (d() * 31) + e();
    }

    @Override // d.t.a
    public boolean isEmpty() {
        return d() > e();
    }

    public Integer l() {
        return Integer.valueOf(e());
    }

    public Integer m() {
        return Integer.valueOf(d());
    }

    @Override // d.t.a
    public String toString() {
        return d() + ".." + e();
    }
}
