package b.c.c.m;

import com.google.android.gms.common.internal.q;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f1429a;

    public b(String str) {
        this.f1429a = str;
    }

    public String a() {
        return this.f1429a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return q.a(this.f1429a, ((b) obj).f1429a);
        }
        return false;
    }

    public int hashCode() {
        return q.b(this.f1429a);
    }

    public String toString() {
        q.a c2 = q.c(this);
        c2.a("token", this.f1429a);
        return c2.toString();
    }
}
