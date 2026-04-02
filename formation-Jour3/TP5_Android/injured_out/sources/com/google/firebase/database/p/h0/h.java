package com.google.firebase.database.p.h0;

import com.google.firebase.database.r.n;
import com.google.firebase.database.r.o;
import com.google.firebase.database.r.q;
import com.google.firebase.database.r.r;
import com.google.firebase.database.r.t;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class h {
    public static final h i = new h();

    /* renamed from: a  reason: collision with root package name */
    private Integer f2213a;

    /* renamed from: b  reason: collision with root package name */
    private b f2214b;

    /* renamed from: c  reason: collision with root package name */
    private n f2215c = null;

    /* renamed from: d  reason: collision with root package name */
    private com.google.firebase.database.r.b f2216d = null;
    private n e = null;
    private com.google.firebase.database.r.b f = null;
    private com.google.firebase.database.r.h g = q.j();
    private String h = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2217a;

        static {
            int[] iArr = new int[b.values().length];
            f2217a = iArr;
            try {
                iArr[b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2217a[b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum b {
        LEFT,
        RIGHT
    }

    public static h a(Map<String, Object> map) {
        h hVar = new h();
        hVar.f2213a = (Integer) map.get("l");
        if (map.containsKey("sp")) {
            hVar.f2215c = p(o.a(map.get("sp")));
            String str = (String) map.get("sn");
            if (str != null) {
                hVar.f2216d = com.google.firebase.database.r.b.g(str);
            }
        }
        if (map.containsKey("ep")) {
            hVar.e = p(o.a(map.get("ep")));
            String str2 = (String) map.get("en");
            if (str2 != null) {
                hVar.f = com.google.firebase.database.r.b.g(str2);
            }
        }
        String str3 = (String) map.get("vf");
        if (str3 != null) {
            hVar.f2214b = str3.equals("l") ? b.LEFT : b.RIGHT;
        }
        String str4 = (String) map.get("i");
        if (str4 != null) {
            hVar.g = com.google.firebase.database.r.h.b(str4);
        }
        return hVar;
    }

    private static n p(n nVar) {
        if ((nVar instanceof t) || (nVar instanceof com.google.firebase.database.r.a) || (nVar instanceof com.google.firebase.database.r.f) || (nVar instanceof com.google.firebase.database.r.g)) {
            return nVar;
        }
        if (nVar instanceof com.google.firebase.database.r.l) {
            return new com.google.firebase.database.r.f(Double.valueOf(((Long) nVar.getValue()).doubleValue()), r.a());
        }
        throw new IllegalStateException("Unexpected value passed to normalizeValue: " + nVar.getValue());
    }

    public com.google.firebase.database.r.h b() {
        return this.g;
    }

    public com.google.firebase.database.r.b c() {
        if (j()) {
            com.google.firebase.database.r.b bVar = this.f;
            return bVar != null ? bVar : com.google.firebase.database.r.b.i();
        }
        throw new IllegalArgumentException("Cannot get index end name if start has not been set");
    }

    public n d() {
        if (j()) {
            return this.e;
        }
        throw new IllegalArgumentException("Cannot get index end value if start has not been set");
    }

    public com.google.firebase.database.r.b e() {
        if (l()) {
            com.google.firebase.database.r.b bVar = this.f2216d;
            return bVar != null ? bVar : com.google.firebase.database.r.b.l();
        }
        throw new IllegalArgumentException("Cannot get index start name if start has not been set");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        Integer num = this.f2213a;
        if (num == null ? hVar.f2213a == null : num.equals(hVar.f2213a)) {
            com.google.firebase.database.r.h hVar2 = this.g;
            if (hVar2 == null ? hVar.g == null : hVar2.equals(hVar.g)) {
                com.google.firebase.database.r.b bVar = this.f;
                if (bVar == null ? hVar.f == null : bVar.equals(hVar.f)) {
                    n nVar = this.e;
                    if (nVar == null ? hVar.e == null : nVar.equals(hVar.e)) {
                        com.google.firebase.database.r.b bVar2 = this.f2216d;
                        if (bVar2 == null ? hVar.f2216d == null : bVar2.equals(hVar.f2216d)) {
                            n nVar2 = this.f2215c;
                            if (nVar2 == null ? hVar.f2215c == null : nVar2.equals(hVar.f2215c)) {
                                return n() == hVar.n();
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public n f() {
        if (l()) {
            return this.f2215c;
        }
        throw new IllegalArgumentException("Cannot get index start value if start has not been set");
    }

    public int g() {
        if (k()) {
            return this.f2213a.intValue();
        }
        throw new IllegalArgumentException("Cannot get limit if limit has not been set");
    }

    public com.google.firebase.database.p.h0.m.d h() {
        return o() ? new com.google.firebase.database.p.h0.m.b(b()) : k() ? new com.google.firebase.database.p.h0.m.c(this) : new com.google.firebase.database.p.h0.m.e(this);
    }

    public int hashCode() {
        Integer num = this.f2213a;
        int intValue = (((num != null ? num.intValue() : 0) * 31) + (n() ? 1231 : 1237)) * 31;
        n nVar = this.f2215c;
        int hashCode = (intValue + (nVar != null ? nVar.hashCode() : 0)) * 31;
        com.google.firebase.database.r.b bVar = this.f2216d;
        int hashCode2 = (hashCode + (bVar != null ? bVar.hashCode() : 0)) * 31;
        n nVar2 = this.e;
        int hashCode3 = (hashCode2 + (nVar2 != null ? nVar2.hashCode() : 0)) * 31;
        com.google.firebase.database.r.b bVar2 = this.f;
        int hashCode4 = (hashCode3 + (bVar2 != null ? bVar2.hashCode() : 0)) * 31;
        com.google.firebase.database.r.h hVar = this.g;
        return hashCode4 + (hVar != null ? hVar.hashCode() : 0);
    }

    public Map<String, Object> i() {
        HashMap hashMap = new HashMap();
        if (l()) {
            hashMap.put("sp", this.f2215c.getValue());
            com.google.firebase.database.r.b bVar = this.f2216d;
            if (bVar != null) {
                hashMap.put("sn", bVar.e());
            }
        }
        if (j()) {
            hashMap.put("ep", this.e.getValue());
            com.google.firebase.database.r.b bVar2 = this.f;
            if (bVar2 != null) {
                hashMap.put("en", bVar2.e());
            }
        }
        Integer num = this.f2213a;
        if (num != null) {
            hashMap.put("l", num);
            b bVar3 = this.f2214b;
            if (bVar3 == null) {
                bVar3 = l() ? b.LEFT : b.RIGHT;
            }
            int i2 = a.f2217a[bVar3.ordinal()];
            if (i2 == 1) {
                hashMap.put("vf", "l");
            } else if (i2 == 2) {
                hashMap.put("vf", "r");
            }
        }
        if (!this.g.equals(q.j())) {
            hashMap.put("i", this.g.c());
        }
        return hashMap;
    }

    public boolean j() {
        return this.e != null;
    }

    public boolean k() {
        return this.f2213a != null;
    }

    public boolean l() {
        return this.f2215c != null;
    }

    public boolean m() {
        return o() && this.g.equals(q.j());
    }

    public boolean n() {
        b bVar = this.f2214b;
        return bVar != null ? bVar == b.LEFT : l();
    }

    public boolean o() {
        return (l() || j() || k()) ? false : true;
    }

    public String q() {
        if (this.h == null) {
            try {
                this.h = com.google.firebase.database.t.b.c(i());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return this.h;
    }

    public String toString() {
        return i().toString();
    }
}
