package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p0 implements Runnable {
    private final /* synthetic */ FirebaseAuth f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p0(FirebaseAuth firebaseAuth) {
        this.f = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<FirebaseAuth.a> list;
        list = this.f.f1881d;
        for (FirebaseAuth.a aVar : list) {
            aVar.a(this.f);
        }
    }
}
