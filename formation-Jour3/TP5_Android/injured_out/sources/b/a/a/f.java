package b.a.a;

import android.os.Handler;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class f implements p {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1155a;

    /* loaded from: classes.dex */
    class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Handler f1156a;

        a(f fVar, Handler handler) {
            this.f1156a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f1156a.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        private final m f;
        private final o g;
        private final Runnable h;

        public b(m mVar, o oVar, Runnable runnable) {
            this.f = mVar;
            this.g = oVar;
            this.h = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f.N()) {
                this.f.s("canceled-at-delivery");
                return;
            }
            if (this.g.b()) {
                this.f.i(this.g.f1167a);
            } else {
                this.f.g(this.g.f1169c);
            }
            if (this.g.f1170d) {
                this.f.e("intermediate-response");
            } else {
                this.f.s("done");
            }
            Runnable runnable = this.h;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public f(Handler handler) {
        this.f1155a = new a(this, handler);
    }

    @Override // b.a.a.p
    public void a(m<?> mVar, t tVar) {
        mVar.e("post-error");
        this.f1155a.execute(new b(mVar, o.a(tVar), null));
    }

    @Override // b.a.a.p
    public void b(m<?> mVar, o<?> oVar) {
        c(mVar, oVar, null);
    }

    @Override // b.a.a.p
    public void c(m<?> mVar, o<?> oVar, Runnable runnable) {
        mVar.O();
        mVar.e("post-response");
        this.f1155a.execute(new b(mVar, oVar, runnable));
    }
}
