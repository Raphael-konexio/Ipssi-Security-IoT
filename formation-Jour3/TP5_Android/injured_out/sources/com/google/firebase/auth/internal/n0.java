package com.google.firebase.auth.internal;

import com.google.firebase.auth.FirebaseAuth;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n0 implements Runnable {
    private final String f;
    final /* synthetic */ d g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n0(d dVar, String str) {
        this.g = dVar;
        com.google.android.gms.common.internal.r.f(str);
        this.f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.c.a.a.b.k.a aVar;
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(b.c.c.c.l(this.f));
        if (firebaseAuth.c() != null) {
            b.c.a.a.f.g<com.google.firebase.auth.p> b2 = firebaseAuth.b(true);
            aVar = d.h;
            aVar.f("Token refreshing started", new Object[0]);
            b2.d(new e(this));
        }
    }
}
