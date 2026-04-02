package b.a.a;

import android.text.TextUtils;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final String f1157a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1158b;

    public g(String str, String str2) {
        this.f1157a = str;
        this.f1158b = str2;
    }

    public final String a() {
        return this.f1157a;
    }

    public final String b() {
        return this.f1158b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return TextUtils.equals(this.f1157a, gVar.f1157a) && TextUtils.equals(this.f1158b, gVar.f1158b);
    }

    public int hashCode() {
        return (this.f1157a.hashCode() * 31) + this.f1158b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f1157a + ",value=" + this.f1158b + "]";
    }
}
