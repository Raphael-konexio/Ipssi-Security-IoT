package com.google.firebase.database.p.g0;

import com.google.firebase.database.p.q;
import com.google.firebase.database.p.x;
import java.lang.Thread;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public abstract class c implements q {

    /* renamed from: a  reason: collision with root package name */
    private ScheduledThreadPoolExecutor f2174a;

    /* loaded from: classes.dex */
    class a extends ScheduledThreadPoolExecutor {
        a(int i, ThreadFactory threadFactory) {
            super(i, threadFactory);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            if (th == null && (runnable instanceof Future)) {
                Future future = (Future) runnable;
                try {
                    if (future.isDone()) {
                        future.get();
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                } catch (CancellationException unused2) {
                } catch (ExecutionException e) {
                    th = e.getCause();
                }
            }
            if (th != null) {
                c.this.f(th);
            }
        }
    }

    /* loaded from: classes.dex */
    private class b implements ThreadFactory {

        /* loaded from: classes.dex */
        class a implements Thread.UncaughtExceptionHandler {
            a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                c.this.f(th);
            }
        }

        private b() {
        }

        /* synthetic */ b(c cVar, a aVar) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = c.this.d().newThread(runnable);
            x e = c.this.e();
            e.a(newThread, "FirebaseDatabaseWorker");
            e.b(newThread, true);
            e.c(newThread, new a());
            return newThread;
        }
    }

    public c() {
        a aVar = new a(1, new b(this, null));
        this.f2174a = aVar;
        aVar.setKeepAliveTime(3L, TimeUnit.SECONDS);
    }

    public static String g(Throwable th) {
        if (th instanceof OutOfMemoryError) {
            return "Firebase Database encountered an OutOfMemoryError. You may need to reduce the amount of data you are syncing to the client (e.g. by using queries or syncing a deeper path). See https://firebase.google.com/docs/database/ios/structure-data#best_practices_for_data_structure and https://firebase.google.com/docs/database/android/retrieve-data#filtering_data";
        }
        if (th instanceof NoClassDefFoundError) {
            return "A symbol that the Firebase Database SDK depends on failed to load. This usually indicates that your project includes an incompatible version of another Firebase dependency. If updating your dependencies to the latest version does not resolve this issue, please file a report at https://github.com/firebase/firebase-android-sdk";
        }
        if (th instanceof com.google.firebase.database.c) {
            return "";
        }
        return "Uncaught exception in Firebase Database runloop (" + com.google.firebase.database.f.e() + "). If you are not already on the latest version of the Firebase SDKs, try updating your dependencies. Should this problem persist, please file a report at https://github.com/firebase/firebase-android-sdk";
    }

    @Override // com.google.firebase.database.p.q
    public void a() {
        this.f2174a.setCorePoolSize(1);
    }

    @Override // com.google.firebase.database.p.q
    public void b(Runnable runnable) {
        this.f2174a.execute(runnable);
    }

    public ScheduledExecutorService c() {
        return this.f2174a;
    }

    protected ThreadFactory d() {
        return Executors.defaultThreadFactory();
    }

    protected x e() {
        return x.f2339a;
    }

    public abstract void f(Throwable th);
}
