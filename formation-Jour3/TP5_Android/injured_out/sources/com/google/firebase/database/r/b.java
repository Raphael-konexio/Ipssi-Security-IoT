package com.google.firebase.database.r;
/* loaded from: classes.dex */
public class b implements Comparable<b> {
    private static final b g = new b("[MIN_KEY]");
    private static final b h = new b("[MAX_KEY]");
    private static final b i = new b(".priority");
    private final String f;

    /* renamed from: com.google.firebase.database.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0103b extends b {
        private final int j;

        C0103b(String str, int i) {
            super(str);
            this.j = i;
        }

        @Override // com.google.firebase.database.r.b, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(b bVar) {
            return super.compareTo(bVar);
        }

        @Override // com.google.firebase.database.r.b
        protected int s() {
            return this.j;
        }

        @Override // com.google.firebase.database.r.b
        public String toString() {
            return "IntegerChildName(\"" + ((b) this).f + "\")";
        }

        @Override // com.google.firebase.database.r.b
        protected boolean u() {
            return true;
        }
    }

    private b(String str) {
        this.f = str;
    }

    public static b g(String str) {
        Integer j = com.google.firebase.database.p.g0.l.j(str);
        return j != null ? new C0103b(str, j.intValue()) : str.equals(".priority") ? i : new b(str);
    }

    public static b i() {
        return h;
    }

    public static b l() {
        return g;
    }

    public static b m() {
        return i;
    }

    public String e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (this == obj) {
                return true;
            }
            return this.f.equals(((b) obj).f);
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: f */
    public int compareTo(b bVar) {
        b bVar2;
        if (this == bVar) {
            return 0;
        }
        b bVar3 = g;
        if (this == bVar3 || bVar == (bVar2 = h)) {
            return -1;
        }
        if (bVar == bVar3 || this == bVar2) {
            return 1;
        }
        if (!u()) {
            if (bVar.u()) {
                return 1;
            }
            return this.f.compareTo(bVar.f);
        } else if (bVar.u()) {
            int a2 = com.google.firebase.database.p.g0.l.a(s(), bVar.s());
            return a2 == 0 ? com.google.firebase.database.p.g0.l.a(this.f.length(), bVar.f.length()) : a2;
        } else {
            return -1;
        }
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    protected int s() {
        return 0;
    }

    public String toString() {
        return "ChildKey(\"" + this.f + "\")";
    }

    protected boolean u() {
        return false;
    }

    public boolean w() {
        return equals(i);
    }
}
