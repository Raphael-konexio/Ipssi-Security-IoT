package com.google.firebase.database.m;

import com.google.firebase.database.p.a;
/* loaded from: classes.dex */
final /* synthetic */ class f implements Runnable {
    private final a.b f;

    private f(a.b bVar) {
        this.f = bVar;
    }

    public static Runnable a(a.b bVar) {
        return new f(bVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f.a(null);
    }
}
