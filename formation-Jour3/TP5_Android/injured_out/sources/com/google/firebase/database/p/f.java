package com.google.firebase.database.p;

import com.google.firebase.database.o.c;
/* loaded from: classes.dex */
final /* synthetic */ class f implements Runnable {
    private final c.a f;
    private final String g;

    private f(c.a aVar, String str) {
        this.f = aVar;
        this.g = str;
    }

    public static Runnable a(c.a aVar, String str) {
        return new f(aVar, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f.b(this.g);
    }
}
