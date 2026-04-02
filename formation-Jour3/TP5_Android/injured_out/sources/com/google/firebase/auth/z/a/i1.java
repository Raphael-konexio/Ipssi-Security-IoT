package com.google.firebase.auth.z.a;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
/* loaded from: classes.dex */
public final class i1<ResultT, CallbackT> implements a1<ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final z0<ResultT, CallbackT> f1938a;

    /* renamed from: b  reason: collision with root package name */
    private final b.c.a.a.f.h<ResultT> f1939b;

    public i1(z0<ResultT, CallbackT> z0Var, b.c.a.a.f.h<ResultT> hVar) {
        this.f1938a = z0Var;
        this.f1939b = hVar;
    }

    @Override // com.google.firebase.auth.z.a.a1
    public final void a(ResultT resultt, Status status) {
        com.google.android.gms.common.internal.r.i(this.f1939b, "completion source cannot be null");
        if (status == null) {
            this.f1939b.c(resultt);
            return;
        }
        z0<ResultT, CallbackT> z0Var = this.f1938a;
        if (z0Var.s != null) {
            b.c.a.a.f.h<ResultT> hVar = this.f1939b;
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(z0Var.f1961c);
            z0<ResultT, CallbackT> z0Var2 = this.f1938a;
            hVar.b(o0.c(firebaseAuth, z0Var2.s, ("reauthenticateWithCredential".equals(z0Var2.c()) || "reauthenticateWithCredentialWithData".equals(this.f1938a.c())) ? this.f1938a.f1962d : null));
            return;
        }
        com.google.firebase.auth.b bVar = z0Var.p;
        if (bVar != null) {
            this.f1939b.b(o0.b(status, bVar, z0Var.q, z0Var.r));
        } else {
            this.f1939b.b(o0.a(status));
        }
    }
}
