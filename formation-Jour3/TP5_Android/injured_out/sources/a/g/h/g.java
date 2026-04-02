package a.g.h;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
class g {

    /* loaded from: classes.dex */
    private static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private String f183a;

        /* renamed from: b  reason: collision with root package name */
        private int f184b;

        /* renamed from: a.g.h.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0007a extends Thread {
            private final int f;

            C0007a(Runnable runnable, String str, int i) {
                super(runnable, str);
                this.f = i;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f);
                super.run();
            }
        }

        a(String str, int i) {
            this.f183a = str;
            this.f184b = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0007a(runnable, this.f183a, this.f184b);
        }
    }

    /* loaded from: classes.dex */
    private static class b<T> implements Runnable {
        private Callable<T> f;
        private a.g.j.a<T> g;
        private Handler h;

        /* loaded from: classes.dex */
        class a implements Runnable {
            final /* synthetic */ a.g.j.a f;
            final /* synthetic */ Object g;

            a(b bVar, a.g.j.a aVar, Object obj) {
                this.f = aVar;
                this.g = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.f.a(this.g);
            }
        }

        b(Handler handler, Callable<T> callable, a.g.j.a<T> aVar) {
            this.f = callable;
            this.g = aVar;
            this.h = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            T t;
            try {
                t = this.f.call();
            } catch (Exception unused) {
                t = null;
            }
            this.h.post(new a(this, this.g, t));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadPoolExecutor a(String str, int i, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i2, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void b(Executor executor, Callable<T> callable, a.g.j.a<T> aVar) {
        executor.execute(new b(a.g.h.b.a(), callable, aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T c(ExecutorService executorService, Callable<T> callable, int i) {
        try {
            return executorService.submit(callable).get(i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw e;
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
