package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import b.c.a.a.d.c.q1;
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f1901a;

    /* renamed from: b  reason: collision with root package name */
    private final d f1902b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f1903c;

    private p(Context context, d dVar) {
        this.f1903c = false;
        this.f1901a = 0;
        this.f1902b = dVar;
        com.google.android.gms.common.api.internal.c.c((Application) context.getApplicationContext());
        com.google.android.gms.common.api.internal.c.b().a(new s(this));
    }

    public p(b.c.c.c cVar) {
        this(cVar.j(), new d(cVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g() {
        return this.f1901a > 0 && !this.f1903c;
    }

    public final void a() {
        this.f1902b.c();
    }

    public final void b(int i) {
        if (i > 0 && this.f1901a == 0) {
            this.f1901a = i;
            if (g()) {
                this.f1902b.a();
            }
        } else if (i == 0 && this.f1901a != 0) {
            this.f1902b.c();
        }
        this.f1901a = i;
    }

    public final void c(q1 q1Var) {
        if (q1Var == null) {
            return;
        }
        long n = q1Var.n();
        if (n <= 0) {
            n = 3600;
        }
        d dVar = this.f1902b;
        dVar.f1889b = q1Var.o() + (n * 1000);
        dVar.f1890c = -1L;
        if (g()) {
            this.f1902b.a();
        }
    }
}
