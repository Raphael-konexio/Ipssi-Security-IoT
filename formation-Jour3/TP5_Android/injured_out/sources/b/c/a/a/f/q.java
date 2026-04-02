package b.c.a.a.f;

import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q<TResult> implements u<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1282a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f1283b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private d f1284c;

    public q(Executor executor, d dVar) {
        this.f1282a = executor;
        this.f1284c = dVar;
    }

    @Override // b.c.a.a.f.u
    public final void a(g<TResult> gVar) {
        if (gVar.l() || gVar.k()) {
            return;
        }
        synchronized (this.f1283b) {
            if (this.f1284c == null) {
                return;
            }
            this.f1282a.execute(new r(this, gVar));
        }
    }

    @Override // b.c.a.a.f.u
    public final void cancel() {
        synchronized (this.f1283b) {
            this.f1284c = null;
        }
    }
}
