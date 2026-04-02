package androidx.navigation;

import android.os.Bundle;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final p f913a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f914b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f915c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f916d;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private p<?> f917a;

        /* renamed from: c  reason: collision with root package name */
        private Object f919c;

        /* renamed from: b  reason: collision with root package name */
        private boolean f918b = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f920d = false;

        public d a() {
            if (this.f917a == null) {
                this.f917a = p.e(this.f919c);
            }
            return new d(this.f917a, this.f918b, this.f919c, this.f920d);
        }

        public a b(Object obj) {
            this.f919c = obj;
            this.f920d = true;
            return this;
        }

        public a c(boolean z) {
            this.f918b = z;
            return this;
        }

        public a d(p<?> pVar) {
            this.f917a = pVar;
            return this;
        }
    }

    d(p<?> pVar, boolean z, Object obj, boolean z2) {
        if (!pVar.f() && z) {
            throw new IllegalArgumentException(pVar.c() + " does not allow nullable values");
        } else if (!z && z2 && obj == null) {
            throw new IllegalArgumentException("Argument with type " + pVar.c() + " has null value but is not nullable.");
        } else {
            this.f913a = pVar;
            this.f914b = z;
            this.f916d = obj;
            this.f915c = z2;
        }
    }

    public p<?> a() {
        return this.f913a;
    }

    public boolean b() {
        return this.f915c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, Bundle bundle) {
        if (this.f915c) {
            this.f913a.i(bundle, str, this.f916d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(String str, Bundle bundle) {
        if (!this.f914b && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.f913a.b(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f914b == dVar.f914b && this.f915c == dVar.f915c && this.f913a.equals(dVar.f913a)) {
            Object obj2 = this.f916d;
            Object obj3 = dVar.f916d;
            return obj2 != null ? obj2.equals(obj3) : obj3 == null;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f913a.hashCode() * 31) + (this.f914b ? 1 : 0)) * 31) + (this.f915c ? 1 : 0)) * 31;
        Object obj = this.f916d;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }
}
