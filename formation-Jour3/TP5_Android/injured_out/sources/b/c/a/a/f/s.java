package b.c.a.a.f;

import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s<TResult> implements u<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1285a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f1286b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private e<? super TResult> f1287c;

    public s(Executor executor, e<? super TResult> eVar) {
        this.f1285a = executor;
        this.f1287c = eVar;
    }

    @Override // b.c.a.a.f.u
    public final void a(g<TResult> gVar) {
        if (gVar.l()) {
            synchronized (this.f1286b) {
                if (this.f1287c == null) {
                    return;
                }
                this.f1285a.execute(new t(this, gVar));
            }
        }
    }

    @Override // b.c.a.a.f.u
    public final void cancel() {
        synchronized (this.f1286b) {
            this.f1287c = null;
        }
    }
}
