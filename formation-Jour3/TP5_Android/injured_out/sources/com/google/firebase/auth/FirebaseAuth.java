package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import b.c.a.a.d.c.q1;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.z.a.y0;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class FirebaseAuth implements com.google.firebase.auth.internal.b {

    /* renamed from: a  reason: collision with root package name */
    private b.c.c.c f1878a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f1879b;

    /* renamed from: c  reason: collision with root package name */
    private final List<com.google.firebase.auth.internal.a> f1880c;

    /* renamed from: d  reason: collision with root package name */
    private List<a> f1881d;
    private com.google.firebase.auth.z.a.i e;
    private n f;
    private final Object g;
    private String h;
    private final com.google.firebase.auth.internal.q i;
    private final com.google.firebase.auth.internal.h j;
    private com.google.firebase.auth.internal.p k;
    private com.google.firebase.auth.internal.r l;

    /* loaded from: classes.dex */
    public interface a {
        void a(FirebaseAuth firebaseAuth);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(FirebaseAuth firebaseAuth);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements com.google.firebase.auth.internal.c {
        c() {
        }

        @Override // com.google.firebase.auth.internal.c
        public final void a(q1 q1Var, n nVar) {
            com.google.android.gms.common.internal.r.h(q1Var);
            com.google.android.gms.common.internal.r.h(nVar);
            nVar.p(q1Var);
            FirebaseAuth.this.j(nVar, q1Var, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements com.google.firebase.auth.internal.c, com.google.firebase.auth.internal.g {
        d() {
        }

        @Override // com.google.firebase.auth.internal.c
        public final void a(q1 q1Var, n nVar) {
            com.google.android.gms.common.internal.r.h(q1Var);
            com.google.android.gms.common.internal.r.h(nVar);
            nVar.p(q1Var);
            FirebaseAuth.this.k(nVar, q1Var, true, true);
        }

        @Override // com.google.firebase.auth.internal.g
        public final void e(Status status) {
            if (status.b() == 17011 || status.b() == 17021 || status.b() == 17005 || status.b() == 17091) {
                FirebaseAuth.this.f();
            }
        }
    }

    public FirebaseAuth(b.c.c.c cVar) {
        this(cVar, com.google.firebase.auth.z.a.u0.a(cVar.j(), new y0(cVar.n().b()).a()), new com.google.firebase.auth.internal.q(cVar.j(), cVar.o()), com.google.firebase.auth.internal.h.a());
    }

    private FirebaseAuth(b.c.c.c cVar, com.google.firebase.auth.z.a.i iVar, com.google.firebase.auth.internal.q qVar, com.google.firebase.auth.internal.h hVar) {
        q1 f;
        this.g = new Object();
        com.google.android.gms.common.internal.r.h(cVar);
        this.f1878a = cVar;
        com.google.android.gms.common.internal.r.h(iVar);
        this.e = iVar;
        com.google.android.gms.common.internal.r.h(qVar);
        this.i = qVar;
        com.google.android.gms.common.internal.r.h(hVar);
        this.j = hVar;
        this.f1879b = new CopyOnWriteArrayList();
        this.f1880c = new CopyOnWriteArrayList();
        this.f1881d = new CopyOnWriteArrayList();
        this.l = com.google.firebase.auth.internal.r.a();
        n a2 = this.i.a();
        this.f = a2;
        if (a2 != null && (f = this.i.f(a2)) != null) {
            j(this.f, f, false);
        }
        this.j.c(this);
    }

    @Keep
    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) b.c.c.c.k().h(FirebaseAuth.class);
    }

    @Keep
    public static FirebaseAuth getInstance(b.c.c.c cVar) {
        return (FirebaseAuth) cVar.h(FirebaseAuth.class);
    }

    private final synchronized void l(com.google.firebase.auth.internal.p pVar) {
        this.k = pVar;
    }

    private final boolean q(String str) {
        h0 a2 = h0.a(str);
        return (a2 == null || TextUtils.equals(this.h, a2.c())) ? false : true;
    }

    private final void t(n nVar) {
        String str;
        if (nVar != null) {
            String c2 = nVar.c();
            StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 45);
            sb.append("Notifying id token listeners about user ( ");
            sb.append(c2);
            sb.append(" ).");
            str = sb.toString();
        } else {
            str = "Notifying id token listeners about a sign-out event.";
        }
        Log.d("FirebaseAuth", str);
        this.l.execute(new n0(this, new b.c.c.m.b(nVar != null ? nVar.y() : null)));
    }

    private final synchronized com.google.firebase.auth.internal.p u() {
        if (this.k == null) {
            l(new com.google.firebase.auth.internal.p(this.f1878a));
        }
        return this.k;
    }

    private final void v(n nVar) {
        String str;
        if (nVar != null) {
            String c2 = nVar.c();
            StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 47);
            sb.append("Notifying auth state listeners about user ( ");
            sb.append(c2);
            sb.append(" ).");
            str = sb.toString();
        } else {
            str = "Notifying auth state listeners about a sign-out event.";
        }
        Log.d("FirebaseAuth", str);
        this.l.execute(new p0(this));
    }

    @Override // com.google.firebase.auth.internal.b
    public void a(com.google.firebase.auth.internal.a aVar) {
        com.google.android.gms.common.internal.r.h(aVar);
        this.f1880c.add(aVar);
        u().b(this.f1880c.size());
    }

    @Override // com.google.firebase.auth.internal.b
    public b.c.a.a.f.g<p> b(boolean z) {
        return g(this.f, z);
    }

    public n c() {
        return this.f;
    }

    public b.c.a.a.f.g<Object> d() {
        n nVar = this.f;
        if (nVar == null || !nVar.h()) {
            return this.e.m(this.f1878a, new c(), this.h);
        }
        com.google.firebase.auth.internal.d0 d0Var = (com.google.firebase.auth.internal.d0) this.f;
        d0Var.E(false);
        return b.c.a.a.f.j.b(new com.google.firebase.auth.internal.x(d0Var));
    }

    public b.c.a.a.f.g<Object> e(com.google.firebase.auth.b bVar) {
        com.google.android.gms.common.internal.r.h(bVar);
        com.google.firebase.auth.b c2 = bVar.c();
        if (c2 instanceof com.google.firebase.auth.c) {
            com.google.firebase.auth.c cVar = (com.google.firebase.auth.c) c2;
            return !cVar.p() ? this.e.s(this.f1878a, cVar.k(), cVar.n(), this.h, new c()) : q(cVar.o()) ? b.c.a.a.f.j.a(com.google.firebase.auth.z.a.o0.a(new Status(17072))) : this.e.i(this.f1878a, cVar, new c());
        } else if (c2 instanceof t) {
            return this.e.l(this.f1878a, (t) c2, this.h, new c());
        } else {
            return this.e.h(this.f1878a, c2, this.h, new c());
        }
    }

    public void f() {
        i();
        com.google.firebase.auth.internal.p pVar = this.k;
        if (pVar != null) {
            pVar.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.internal.u, com.google.firebase.auth.o0] */
    public final b.c.a.a.f.g<p> g(n nVar, boolean z) {
        if (nVar == null) {
            return b.c.a.a.f.j.a(com.google.firebase.auth.z.a.o0.a(new Status(17495)));
        }
        q1 w = nVar.w();
        return (!w.h() || z) ? this.e.k(this.f1878a, nVar, w.j(), new o0(this)) : b.c.a.a.f.j.b(com.google.firebase.auth.internal.k.a(w.k()));
    }

    public final void i() {
        n nVar = this.f;
        if (nVar != null) {
            com.google.firebase.auth.internal.q qVar = this.i;
            com.google.android.gms.common.internal.r.h(nVar);
            qVar.e(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", nVar.c()));
            this.f = null;
        }
        this.i.e("com.google.firebase.auth.FIREBASE_USER");
        t(null);
        v(null);
    }

    public final void j(n nVar, q1 q1Var, boolean z) {
        k(nVar, q1Var, z, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
        if (r0 == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(com.google.firebase.auth.n r5, b.c.a.a.d.c.q1 r6, boolean r7, boolean r8) {
        /*
            r4 = this;
            com.google.android.gms.common.internal.r.h(r5)
            com.google.android.gms.common.internal.r.h(r6)
            com.google.firebase.auth.n r0 = r4.f
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1e
            java.lang.String r0 = r5.c()
            com.google.firebase.auth.n r3 = r4.f
            java.lang.String r3 = r3.c()
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            if (r0 != 0) goto L24
            if (r8 == 0) goto L24
            return
        L24:
            com.google.firebase.auth.n r8 = r4.f
            if (r8 != 0) goto L2a
        L28:
            r1 = 1
            goto L46
        L2a:
            b.c.a.a.d.c.q1 r8 = r8.w()
            java.lang.String r8 = r8.k()
            java.lang.String r3 = r6.k()
            boolean r8 = r8.equals(r3)
            r8 = r8 ^ r2
            if (r0 == 0) goto L41
            if (r8 != 0) goto L41
            r8 = 0
            goto L42
        L41:
            r8 = 1
        L42:
            r2 = r8
            if (r0 != 0) goto L46
            goto L28
        L46:
            com.google.android.gms.common.internal.r.h(r5)
            com.google.firebase.auth.n r8 = r4.f
            if (r8 != 0) goto L50
            r4.f = r5
            goto L6f
        L50:
            java.util.List r0 = r5.b()
            r8.n(r0)
            boolean r8 = r5.h()
            if (r8 != 0) goto L62
            com.google.firebase.auth.n r8 = r4.f
            r8.q()
        L62:
            com.google.firebase.auth.v0 r8 = r5.z()
            java.util.List r8 = r8.a()
            com.google.firebase.auth.n r0 = r4.f
            r0.r(r8)
        L6f:
            if (r7 == 0) goto L78
            com.google.firebase.auth.internal.q r8 = r4.i
            com.google.firebase.auth.n r0 = r4.f
            r8.c(r0)
        L78:
            if (r2 == 0) goto L86
            com.google.firebase.auth.n r8 = r4.f
            if (r8 == 0) goto L81
            r8.p(r6)
        L81:
            com.google.firebase.auth.n r8 = r4.f
            r4.t(r8)
        L86:
            if (r1 == 0) goto L8d
            com.google.firebase.auth.n r8 = r4.f
            r4.v(r8)
        L8d:
            if (r7 == 0) goto L94
            com.google.firebase.auth.internal.q r7 = r4.i
            r7.d(r5, r6)
        L94:
            com.google.firebase.auth.internal.p r5 = r4.u()
            com.google.firebase.auth.n r6 = r4.f
            b.c.a.a.d.c.q1 r6 = r6.w()
            r5.c(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.k(com.google.firebase.auth.n, b.c.a.a.d.c.q1, boolean, boolean):void");
    }

    public final void m(String str) {
        com.google.android.gms.common.internal.r.f(str);
        synchronized (this.g) {
            this.h = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.google.firebase.auth.internal.u, com.google.firebase.auth.FirebaseAuth$d] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.firebase.auth.internal.u, com.google.firebase.auth.FirebaseAuth$d] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.internal.u, com.google.firebase.auth.FirebaseAuth$d] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.firebase.auth.internal.u, com.google.firebase.auth.FirebaseAuth$d] */
    public final b.c.a.a.f.g<Object> n(n nVar, com.google.firebase.auth.b bVar) {
        com.google.android.gms.common.internal.r.h(nVar);
        com.google.android.gms.common.internal.r.h(bVar);
        com.google.firebase.auth.b c2 = bVar.c();
        if (!(c2 instanceof com.google.firebase.auth.c)) {
            return c2 instanceof t ? this.e.q(this.f1878a, nVar, (t) c2, this.h, new d()) : this.e.o(this.f1878a, nVar, c2, nVar.v(), new d());
        }
        com.google.firebase.auth.c cVar = (com.google.firebase.auth.c) c2;
        return "password".equals(cVar.h()) ? this.e.r(this.f1878a, nVar, cVar.k(), cVar.n(), nVar.v(), new d()) : q(cVar.o()) ? b.c.a.a.f.j.a(com.google.firebase.auth.z.a.o0.a(new Status(17072))) : this.e.p(this.f1878a, nVar, cVar, new d());
    }

    public final b.c.c.c o() {
        return this.f1878a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.internal.u, com.google.firebase.auth.FirebaseAuth$d] */
    public final b.c.a.a.f.g<Object> r(n nVar, com.google.firebase.auth.b bVar) {
        com.google.android.gms.common.internal.r.h(bVar);
        com.google.android.gms.common.internal.r.h(nVar);
        return this.e.j(this.f1878a, nVar, bVar.c(), new d());
    }
}
