package com.google.firebase.database.p.g0;

import java.util.Map;
/* loaded from: classes.dex */
public class j<T> {

    /* renamed from: a  reason: collision with root package name */
    private com.google.firebase.database.r.b f2187a;

    /* renamed from: b  reason: collision with root package name */
    private j<T> f2188b;

    /* renamed from: c  reason: collision with root package name */
    private k<T> f2189c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements c<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f2190a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f2191b;

        a(j jVar, c cVar, boolean z) {
            this.f2190a = cVar;
            this.f2191b = z;
        }

        @Override // com.google.firebase.database.p.g0.j.c
        public void a(j<T> jVar) {
            jVar.e(this.f2190a, true, this.f2191b);
        }
    }

    /* loaded from: classes.dex */
    public interface b<T> {
        boolean a(j<T> jVar);
    }

    /* loaded from: classes.dex */
    public interface c<T> {
        void a(j<T> jVar);
    }

    public j() {
        this(null, null, new k());
    }

    public j(com.google.firebase.database.r.b bVar, j<T> jVar, k<T> kVar) {
        this.f2187a = bVar;
        this.f2188b = jVar;
        this.f2189c = kVar;
    }

    private void m(com.google.firebase.database.r.b bVar, j<T> jVar) {
        boolean i = jVar.i();
        boolean containsKey = this.f2189c.f2192a.containsKey(bVar);
        if (i && containsKey) {
            this.f2189c.f2192a.remove(bVar);
        } else if (i || containsKey) {
            return;
        } else {
            this.f2189c.f2192a.put(bVar, jVar.f2189c);
        }
        n();
    }

    private void n() {
        j<T> jVar = this.f2188b;
        if (jVar != null) {
            jVar.m(this.f2187a, this);
        }
    }

    public boolean a(b<T> bVar) {
        return b(bVar, false);
    }

    public boolean b(b<T> bVar, boolean z) {
        for (j<T> jVar = z ? this : this.f2188b; jVar != null; jVar = jVar.f2188b) {
            if (bVar.a(jVar)) {
                return true;
            }
        }
        return false;
    }

    public void c(c<T> cVar) {
        for (Object obj : this.f2189c.f2192a.entrySet().toArray()) {
            Map.Entry entry = (Map.Entry) obj;
            cVar.a(new j<>((com.google.firebase.database.r.b) entry.getKey(), this, (k) entry.getValue()));
        }
    }

    public void d(c<T> cVar) {
        e(cVar, false, false);
    }

    public void e(c<T> cVar, boolean z, boolean z2) {
        if (z && !z2) {
            cVar.a(this);
        }
        c(new a(this, cVar, z2));
        if (z && z2) {
            cVar.a(this);
        }
    }

    public com.google.firebase.database.p.l f() {
        j<T> jVar = this.f2188b;
        return jVar != null ? jVar.f().l(this.f2187a) : this.f2187a != null ? new com.google.firebase.database.p.l(this.f2187a) : com.google.firebase.database.p.l.w();
    }

    public T g() {
        return this.f2189c.f2193b;
    }

    public boolean h() {
        return !this.f2189c.f2192a.isEmpty();
    }

    public boolean i() {
        k<T> kVar = this.f2189c;
        return kVar.f2193b == null && kVar.f2192a.isEmpty();
    }

    public void j(T t) {
        this.f2189c.f2193b = t;
        n();
    }

    public j<T> k(com.google.firebase.database.p.l lVar) {
        com.google.firebase.database.r.b x = lVar.x();
        j<T> jVar = this;
        while (x != null) {
            j<T> jVar2 = new j<>(x, jVar, jVar.f2189c.f2192a.containsKey(x) ? jVar.f2189c.f2192a.get(x) : new k<>());
            lVar = lVar.A();
            x = lVar.x();
            jVar = jVar2;
        }
        return jVar;
    }

    String l(String str) {
        com.google.firebase.database.r.b bVar = this.f2187a;
        String e = bVar == null ? "<anon>" : bVar.e();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(e);
        sb.append("\n");
        k<T> kVar = this.f2189c;
        sb.append(kVar.a(str + "\t"));
        return sb.toString();
    }

    public String toString() {
        return l("");
    }
}
