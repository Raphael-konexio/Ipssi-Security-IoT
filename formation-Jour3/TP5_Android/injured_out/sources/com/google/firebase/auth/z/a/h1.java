package com.google.firebase.auth.z.a;
/* loaded from: classes.dex */
final class h1 implements Runnable {
    private final /* synthetic */ g1 f;
    private final /* synthetic */ b1 g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h1(b1 b1Var, g1 g1Var) {
        this.g = b1Var;
        this.f = g1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.g.f1923a.h) {
            if (!this.g.f1923a.h.isEmpty()) {
                this.f.a(this.g.f1923a.h.get(0), new Object[0]);
            }
        }
    }
}
