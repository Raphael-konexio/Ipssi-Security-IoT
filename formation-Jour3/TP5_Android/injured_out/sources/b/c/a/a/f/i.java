package b.c.a.a.f;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f1270a = new a();

    /* renamed from: b  reason: collision with root package name */
    static final Executor f1271b = new w();

    /* loaded from: classes.dex */
    private static final class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f1272a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f1272a.post(runnable);
        }
    }
}
