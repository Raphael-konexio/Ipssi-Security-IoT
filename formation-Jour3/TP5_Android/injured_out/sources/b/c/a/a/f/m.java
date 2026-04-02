package b.c.a.a.f;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
final class m<TResult> implements u<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1276a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f1277b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private b f1278c;

    public m(Executor executor, b bVar) {
        this.f1276a = executor;
        this.f1278c = bVar;
    }

    @Override // b.c.a.a.f.u
    public final void a(g gVar) {
        if (gVar.k()) {
            synchronized (this.f1277b) {
                if (this.f1278c == null) {
                    return;
                }
                this.f1276a.execute(new n(this));
            }
        }
    }

    @Override // b.c.a.a.f.u
    public final void cancel() {
        synchronized (this.f1277b) {
            this.f1278c = null;
        }
    }
}
