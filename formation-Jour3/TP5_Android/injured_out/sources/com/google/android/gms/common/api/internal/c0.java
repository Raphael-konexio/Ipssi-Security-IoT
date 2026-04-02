package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import java.util.Set;
/* loaded from: classes.dex */
public final class c0 extends b.c.a.a.e.b.e implements com.google.android.gms.common.api.f, com.google.android.gms.common.api.g {
    private static a.AbstractC0075a<? extends b.c.a.a.e.e, b.c.a.a.e.a> h = b.c.a.a.e.d.f1267c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f1542a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f1543b;

    /* renamed from: c  reason: collision with root package name */
    private final a.AbstractC0075a<? extends b.c.a.a.e.e, b.c.a.a.e.a> f1544c;

    /* renamed from: d  reason: collision with root package name */
    private Set<Scope> f1545d;
    private com.google.android.gms.common.internal.d e;
    private b.c.a.a.e.e f;
    private d0 g;

    public c0(Context context, Handler handler, com.google.android.gms.common.internal.d dVar) {
        this(context, handler, dVar, h);
    }

    public c0(Context context, Handler handler, com.google.android.gms.common.internal.d dVar, a.AbstractC0075a<? extends b.c.a.a.e.e, b.c.a.a.e.a> abstractC0075a) {
        this.f1542a = context;
        this.f1543b = handler;
        com.google.android.gms.common.internal.r.i(dVar, "ClientSettings must not be null");
        this.e = dVar;
        this.f1545d = dVar.g();
        this.f1544c = abstractC0075a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(b.c.a.a.e.b.l lVar) {
        b.c.a.a.b.a b2 = lVar.b();
        if (b2.k()) {
            com.google.android.gms.common.internal.t c2 = lVar.c();
            b2 = c2.c();
            if (b2.k()) {
                this.g.c(c2.b(), this.f1545d);
                this.f.p();
            }
            String valueOf = String.valueOf(b2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
            sb.append("Sign-in succeeded with resolve account failure: ");
            sb.append(valueOf);
            Log.wtf("SignInCoordinator", sb.toString(), new Exception());
        }
        this.g.b(b2);
        this.f.p();
    }

    @Override // b.c.a.a.e.b.d
    public final void D(b.c.a.a.e.b.l lVar) {
        this.f1543b.post(new e0(this, lVar));
    }

    public final void b0(d0 d0Var) {
        b.c.a.a.e.e eVar = this.f;
        if (eVar != null) {
            eVar.p();
        }
        this.e.i(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0075a<? extends b.c.a.a.e.e, b.c.a.a.e.a> abstractC0075a = this.f1544c;
        Context context = this.f1542a;
        Looper looper = this.f1543b.getLooper();
        com.google.android.gms.common.internal.d dVar = this.e;
        this.f = abstractC0075a.a(context, looper, dVar, dVar.h(), this, this);
        this.g = d0Var;
        Set<Scope> set = this.f1545d;
        if (set == null || set.isEmpty()) {
            this.f1543b.post(new b0(this));
        } else {
            this.f.a();
        }
    }

    public final void c0() {
        b.c.a.a.e.e eVar = this.f;
        if (eVar != null) {
            eVar.p();
        }
    }

    @Override // com.google.android.gms.common.api.internal.d
    public final void d(int i) {
        this.f.p();
    }

    @Override // com.google.android.gms.common.api.internal.i
    public final void g(b.c.a.a.b.a aVar) {
        this.g.b(aVar);
    }

    @Override // com.google.android.gms.common.api.internal.d
    public final void h(Bundle bundle) {
        this.f.i(this);
    }
}
