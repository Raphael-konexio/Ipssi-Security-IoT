package b.c.a.a.f;

import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k<TResult, TContinuationResult> implements b, d, e<TContinuationResult>, u<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1273a;

    /* renamed from: b  reason: collision with root package name */
    private final a<TResult, g<TContinuationResult>> f1274b;

    /* renamed from: c  reason: collision with root package name */
    private final x<TContinuationResult> f1275c;

    public k(Executor executor, a<TResult, g<TContinuationResult>> aVar, x<TContinuationResult> xVar) {
        this.f1273a = executor;
        this.f1274b = aVar;
        this.f1275c = xVar;
    }

    @Override // b.c.a.a.f.u
    public final void a(g<TResult> gVar) {
        this.f1273a.execute(new l(this, gVar));
    }

    @Override // b.c.a.a.f.b
    public final void b() {
        this.f1275c.s();
    }

    @Override // b.c.a.a.f.e
    public final void c(TContinuationResult tcontinuationresult) {
        this.f1275c.p(tcontinuationresult);
    }

    @Override // b.c.a.a.f.u
    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    @Override // b.c.a.a.f.d
    public final void d(Exception exc) {
        this.f1275c.o(exc);
    }
}
