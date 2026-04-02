package b.c.a.a.f;

import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o<TResult> implements u<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1279a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f1280b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private c<TResult> f1281c;

    public o(Executor executor, c<TResult> cVar) {
        this.f1279a = executor;
        this.f1281c = cVar;
    }

    @Override // b.c.a.a.f.u
    public final void a(g<TResult> gVar) {
        synchronized (this.f1280b) {
            if (this.f1281c == null) {
                return;
            }
            this.f1279a.execute(new p(this, gVar));
        }
    }

    @Override // b.c.a.a.f.u
    public final void cancel() {
        synchronized (this.f1280b) {
            this.f1281c = null;
        }
    }
}
