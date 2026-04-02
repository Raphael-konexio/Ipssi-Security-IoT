package b.c.a.a.e;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.q;
/* loaded from: classes.dex */
public final class a implements a.d {
    public static final a o = new a(false, false, null, false, null, null, false, null, null);
    private final boolean f = false;
    private final boolean g = false;
    private final String h = null;
    private final boolean i = false;
    private final boolean l = false;
    private final String j = null;
    private final String k = null;
    private final Long m = null;
    private final Long n = null;

    private a(boolean z, boolean z2, String str, boolean z3, String str2, String str3, boolean z4, Long l, Long l2) {
    }

    public final Long b() {
        return this.m;
    }

    public final String d() {
        return this.j;
    }

    public final String e() {
        return this.k;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f == aVar.f && this.g == aVar.g && q.a(this.h, aVar.h) && this.i == aVar.i && this.l == aVar.l && q.a(this.j, aVar.j) && q.a(this.k, aVar.k) && q.a(this.m, aVar.m) && q.a(this.n, aVar.n);
        }
        return false;
    }

    public final Long f() {
        return this.n;
    }

    public final String g() {
        return this.h;
    }

    public final boolean h() {
        return this.i;
    }

    public final int hashCode() {
        return q.b(Boolean.valueOf(this.f), Boolean.valueOf(this.g), this.h, Boolean.valueOf(this.i), Boolean.valueOf(this.l), this.j, this.k, this.m, this.n);
    }

    public final boolean i() {
        return this.g;
    }

    public final boolean j() {
        return this.f;
    }

    public final boolean k() {
        return this.l;
    }
}
