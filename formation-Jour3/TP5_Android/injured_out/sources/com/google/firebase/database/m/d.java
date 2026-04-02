package com.google.firebase.database.m;

import com.google.firebase.database.p.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {
    private final a.b f;
    private final b.c.c.m.b g;

    private d(a.b bVar, b.c.c.m.b bVar2) {
        this.f = bVar;
        this.g = bVar2;
    }

    public static Runnable a(a.b bVar, b.c.c.m.b bVar2) {
        return new d(bVar, bVar2);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f.a(this.g.a());
    }
}
