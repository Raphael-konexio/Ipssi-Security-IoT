package com.google.android.gms.common.api.internal;
/* loaded from: classes.dex */
final class e0 implements Runnable {
    private final /* synthetic */ b.c.a.a.e.b.l f;
    private final /* synthetic */ c0 g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(c0 c0Var, b.c.a.a.e.b.l lVar) {
        this.g = c0Var;
        this.f = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.g.d0(this.f);
    }
}
