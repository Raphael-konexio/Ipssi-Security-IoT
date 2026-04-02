package com.google.firebase.auth.internal;
/* loaded from: classes.dex */
final class e implements b.c.a.a.f.d {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ n0 f1892a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(n0 n0Var) {
        this.f1892a = n0Var;
    }

    @Override // b.c.a.a.f.d
    public final void d(Exception exc) {
        b.c.a.a.b.k.a aVar;
        if (exc instanceof b.c.c.g) {
            aVar = d.h;
            aVar.f("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.f1892a.g.b();
        }
    }
}
