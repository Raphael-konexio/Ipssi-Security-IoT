package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n0 implements Runnable {
    private final /* synthetic */ b.c.c.m.b f;
    private final /* synthetic */ FirebaseAuth g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n0(FirebaseAuth firebaseAuth, b.c.c.m.b bVar) {
        this.g = firebaseAuth;
        this.f = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<com.google.firebase.auth.internal.a> list;
        List<FirebaseAuth.b> list2;
        list = this.g.f1880c;
        for (com.google.firebase.auth.internal.a aVar : list) {
            aVar.a(this.f);
        }
        list2 = this.g.f1879b;
        for (FirebaseAuth.b bVar : list2) {
            bVar.a(this.g);
        }
    }
}
