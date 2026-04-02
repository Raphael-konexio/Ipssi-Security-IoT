package b.c.a.a.f;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x<TResult> extends g<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1291a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final v<TResult> f1292b = new v<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f1293c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f1294d;
    private TResult e;
    private Exception f;

    /* loaded from: classes.dex */
    private static class a extends LifecycleCallback {
        private final List<WeakReference<u<?>>> g;

        private a(com.google.android.gms.common.api.internal.g gVar) {
            super(gVar);
            this.g = new ArrayList();
            this.f.b("TaskOnStopCallback", this);
        }

        public static a k(Activity activity) {
            com.google.android.gms.common.api.internal.g b2 = LifecycleCallback.b(activity);
            a aVar = (a) b2.c("TaskOnStopCallback", a.class);
            return aVar == null ? new a(b2) : aVar;
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void j() {
            synchronized (this.g) {
                for (WeakReference<u<?>> weakReference : this.g) {
                    u<?> uVar = weakReference.get();
                    if (uVar != null) {
                        uVar.cancel();
                    }
                }
                this.g.clear();
            }
        }

        public final <T> void l(u<T> uVar) {
            synchronized (this.g) {
                this.g.add(new WeakReference<>(uVar));
            }
        }
    }

    private final void t() {
        com.google.android.gms.common.internal.r.k(this.f1293c, "Task is not yet complete");
    }

    private final void u() {
        com.google.android.gms.common.internal.r.k(!this.f1293c, "Task is already complete");
    }

    private final void v() {
        if (this.f1294d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void w() {
        synchronized (this.f1291a) {
            if (this.f1293c) {
                this.f1292b.a(this);
            }
        }
    }

    @Override // b.c.a.a.f.g
    public final g<TResult> a(Executor executor, b bVar) {
        this.f1292b.b(new m(executor, bVar));
        w();
        return this;
    }

    @Override // b.c.a.a.f.g
    public final g<TResult> b(Activity activity, c<TResult> cVar) {
        o oVar = new o(i.f1270a, cVar);
        this.f1292b.b(oVar);
        a.k(activity).l(oVar);
        w();
        return this;
    }

    @Override // b.c.a.a.f.g
    public final g<TResult> c(c<TResult> cVar) {
        m(i.f1270a, cVar);
        return this;
    }

    @Override // b.c.a.a.f.g
    public final g<TResult> d(d dVar) {
        e(i.f1270a, dVar);
        return this;
    }

    @Override // b.c.a.a.f.g
    public final g<TResult> e(Executor executor, d dVar) {
        this.f1292b.b(new q(executor, dVar));
        w();
        return this;
    }

    @Override // b.c.a.a.f.g
    public final g<TResult> f(e<? super TResult> eVar) {
        g(i.f1270a, eVar);
        return this;
    }

    @Override // b.c.a.a.f.g
    public final g<TResult> g(Executor executor, e<? super TResult> eVar) {
        this.f1292b.b(new s(executor, eVar));
        w();
        return this;
    }

    @Override // b.c.a.a.f.g
    public final <TContinuationResult> g<TContinuationResult> h(b.c.a.a.f.a<TResult, g<TContinuationResult>> aVar) {
        return n(i.f1270a, aVar);
    }

    @Override // b.c.a.a.f.g
    public final Exception i() {
        Exception exc;
        synchronized (this.f1291a) {
            exc = this.f;
        }
        return exc;
    }

    @Override // b.c.a.a.f.g
    public final TResult j() {
        TResult tresult;
        synchronized (this.f1291a) {
            t();
            v();
            if (this.f != null) {
                throw new f(this.f);
            }
            tresult = this.e;
        }
        return tresult;
    }

    @Override // b.c.a.a.f.g
    public final boolean k() {
        return this.f1294d;
    }

    @Override // b.c.a.a.f.g
    public final boolean l() {
        boolean z;
        synchronized (this.f1291a) {
            z = this.f1293c && !this.f1294d && this.f == null;
        }
        return z;
    }

    public final g<TResult> m(Executor executor, c<TResult> cVar) {
        this.f1292b.b(new o(executor, cVar));
        w();
        return this;
    }

    public final <TContinuationResult> g<TContinuationResult> n(Executor executor, b.c.a.a.f.a<TResult, g<TContinuationResult>> aVar) {
        x xVar = new x();
        this.f1292b.b(new k(executor, aVar, xVar));
        w();
        return xVar;
    }

    public final void o(Exception exc) {
        com.google.android.gms.common.internal.r.i(exc, "Exception must not be null");
        synchronized (this.f1291a) {
            u();
            this.f1293c = true;
            this.f = exc;
        }
        this.f1292b.a(this);
    }

    public final void p(TResult tresult) {
        synchronized (this.f1291a) {
            u();
            this.f1293c = true;
            this.e = tresult;
        }
        this.f1292b.a(this);
    }

    public final boolean q(Exception exc) {
        com.google.android.gms.common.internal.r.i(exc, "Exception must not be null");
        synchronized (this.f1291a) {
            if (this.f1293c) {
                return false;
            }
            this.f1293c = true;
            this.f = exc;
            this.f1292b.a(this);
            return true;
        }
    }

    public final boolean r(TResult tresult) {
        synchronized (this.f1291a) {
            if (this.f1293c) {
                return false;
            }
            this.f1293c = true;
            this.e = tresult;
            this.f1292b.a(this);
            return true;
        }
    }

    public final boolean s() {
        synchronized (this.f1291a) {
            if (this.f1293c) {
                return false;
            }
            this.f1293c = true;
            this.f1294d = true;
            this.f1292b.a(this);
            return true;
        }
    }
}
