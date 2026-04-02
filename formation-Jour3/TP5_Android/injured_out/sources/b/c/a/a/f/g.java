package b.c.a.a.f;

import android.app.Activity;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class g<TResult> {
    public g<TResult> a(Executor executor, b bVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    public g<TResult> b(Activity activity, c<TResult> cVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public g<TResult> c(c<TResult> cVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract g<TResult> d(d dVar);

    public abstract g<TResult> e(Executor executor, d dVar);

    public abstract g<TResult> f(e<? super TResult> eVar);

    public abstract g<TResult> g(Executor executor, e<? super TResult> eVar);

    public <TContinuationResult> g<TContinuationResult> h(a<TResult, g<TContinuationResult>> aVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public abstract Exception i();

    public abstract TResult j();

    public abstract boolean k();

    public abstract boolean l();
}
