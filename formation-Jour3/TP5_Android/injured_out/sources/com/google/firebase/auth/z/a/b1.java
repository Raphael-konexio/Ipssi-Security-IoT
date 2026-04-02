package com.google.firebase.auth.z.a;

import b.c.a.a.d.c.k1;
import b.c.a.a.d.c.m1;
import b.c.a.a.d.c.q1;
import b.c.a.a.d.c.x1;
import com.google.android.gms.common.api.Status;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b1 extends q0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z0 f1923a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b1(z0 z0Var) {
        this.f1923a = z0Var;
    }

    private final void g(Status status, com.google.firebase.auth.b bVar, String str, String str2) {
        this.f1923a.m(status);
        z0 z0Var = this.f1923a;
        z0Var.p = bVar;
        z0Var.q = str;
        z0Var.r = str2;
        com.google.firebase.auth.internal.g gVar = z0Var.f;
        if (gVar != null) {
            gVar.e(status);
        }
        this.f1923a.i(status);
    }

    private final void h(g1 g1Var) {
        this.f1923a.i.execute(new h1(this, g1Var));
    }

    @Override // com.google.firebase.auth.z.a.r0
    public final void A() {
        boolean z = this.f1923a.f1959a == 5;
        int i = this.f1923a.f1959a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        com.google.android.gms.common.internal.r.k(z, sb.toString());
        this.f1923a.p();
    }

    @Override // com.google.firebase.auth.z.a.r0
    public final void E(b.c.a.a.d.c.h1 h1Var) {
        z0 z0Var = this.f1923a;
        z0Var.s = h1Var;
        z0Var.i(com.google.firebase.auth.internal.m0.a("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    @Override // com.google.firebase.auth.z.a.r0
    public final void F(x1 x1Var) {
        boolean z = this.f1923a.f1959a == 4;
        int i = this.f1923a.f1959a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        com.google.android.gms.common.internal.r.k(z, sb.toString());
        z0 z0Var = this.f1923a;
        z0Var.m = x1Var;
        z0Var.p();
    }

    @Override // com.google.firebase.auth.z.a.r0
    public final void I(q1 q1Var) {
        boolean z = this.f1923a.f1959a == 1;
        int i = this.f1923a.f1959a;
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        com.google.android.gms.common.internal.r.k(z, sb.toString());
        z0 z0Var = this.f1923a;
        z0Var.j = q1Var;
        z0Var.p();
    }

    @Override // com.google.firebase.auth.z.a.r0
    public final void T(b.c.a.a.d.c.g1 g1Var) {
        g(g1Var.b(), g1Var.c(), g1Var.h(), g1Var.j());
    }

    @Override // com.google.firebase.auth.z.a.r0
    public final void a() {
        boolean z = this.f1923a.f1959a == 6;
        int i = this.f1923a.f1959a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        com.google.android.gms.common.internal.r.k(z, sb.toString());
        this.f1923a.p();
    }

    @Override // com.google.firebase.auth.z.a.r0
    public final void b() {
        boolean z = this.f1923a.f1959a == 9;
        int i = this.f1923a.f1959a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        com.google.android.gms.common.internal.r.k(z, sb.toString());
        this.f1923a.p();
    }

    @Override // com.google.firebase.auth.z.a.r0
    public final void e(Status status) {
        String c2 = status.c();
        if (c2 != null) {
            if (c2.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (c2.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (c2.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (c2.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (c2.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (c2.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (c2.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (c2.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (c2.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (c2.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        z0 z0Var = this.f1923a;
        if (z0Var.f1959a != 8) {
            z0Var.m(status);
            this.f1923a.i(status);
            return;
        }
        z0.l(z0Var, true);
        this.f1923a.w = false;
        h(new e1(this, status));
    }

    @Override // com.google.firebase.auth.z.a.r0
    public final void f(String str) {
        boolean z = this.f1923a.f1959a == 7;
        int i = this.f1923a.f1959a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        com.google.android.gms.common.internal.r.k(z, sb.toString());
        z0 z0Var = this.f1923a;
        z0Var.n = str;
        z0Var.p();
    }

    @Override // com.google.firebase.auth.z.a.r0
    public final void i(Status status, com.google.firebase.auth.t tVar) {
        boolean z = this.f1923a.f1959a == 2;
        int i = this.f1923a.f1959a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        com.google.android.gms.common.internal.r.k(z, sb.toString());
        g(status, tVar, null, null);
    }

    @Override // com.google.firebase.auth.z.a.r0
    public final void o(String str) {
        boolean z = this.f1923a.f1959a == 8;
        int i = this.f1923a.f1959a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        com.google.android.gms.common.internal.r.k(z, sb.toString());
        z0 z0Var = this.f1923a;
        z0Var.o = str;
        z0.l(z0Var, true);
        this.f1923a.w = true;
        h(new f1(this, str));
    }

    @Override // com.google.firebase.auth.z.a.r0
    public final void q(com.google.firebase.auth.t tVar) {
        boolean z = this.f1923a.f1959a == 8;
        int i = this.f1923a.f1959a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        com.google.android.gms.common.internal.r.k(z, sb.toString());
        z0.l(this.f1923a, true);
        this.f1923a.w = true;
        h(new c1(this, tVar));
    }

    @Override // com.google.firebase.auth.z.a.r0
    public final void t(q1 q1Var, m1 m1Var) {
        boolean z = this.f1923a.f1959a == 2;
        int i = this.f1923a.f1959a;
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        com.google.android.gms.common.internal.r.k(z, sb.toString());
        z0 z0Var = this.f1923a;
        z0Var.j = q1Var;
        z0Var.k = m1Var;
        z0Var.p();
    }

    @Override // com.google.firebase.auth.z.a.r0
    public final void w(k1 k1Var) {
        boolean z = this.f1923a.f1959a == 3;
        int i = this.f1923a.f1959a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        com.google.android.gms.common.internal.r.k(z, sb.toString());
        z0 z0Var = this.f1923a;
        z0Var.l = k1Var;
        z0Var.p();
    }

    @Override // com.google.firebase.auth.z.a.r0
    public final void z(String str) {
        boolean z = this.f1923a.f1959a == 8;
        int i = this.f1923a.f1959a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        com.google.android.gms.common.internal.r.k(z, sb.toString());
        this.f1923a.o = str;
        h(new d1(this, str));
    }
}
