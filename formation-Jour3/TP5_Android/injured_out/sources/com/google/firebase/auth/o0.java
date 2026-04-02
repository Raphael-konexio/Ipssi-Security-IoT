package com.google.firebase.auth;

import b.c.a.a.d.c.q1;
import com.google.android.gms.common.api.Status;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o0 implements com.google.firebase.auth.internal.c, com.google.firebase.auth.internal.g {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f1912a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(FirebaseAuth firebaseAuth) {
        this.f1912a = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.c
    public final void a(q1 q1Var, n nVar) {
        this.f1912a.k(nVar, q1Var, true, true);
    }

    @Override // com.google.firebase.auth.internal.g
    public final void e(Status status) {
        int b2 = status.b();
        if (b2 == 17011 || b2 == 17021 || b2 == 17005) {
            this.f1912a.f();
        }
    }
}
