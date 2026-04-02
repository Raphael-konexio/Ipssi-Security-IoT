package io.flutter.view;

import android.view.Choreographer;
import android.view.WindowManager;
import io.flutter.embedding.engine.FlutterJNI;
/* loaded from: classes.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static f f2689c;

    /* renamed from: a  reason: collision with root package name */
    private final WindowManager f2690a;

    /* renamed from: b  reason: collision with root package name */
    private final FlutterJNI.b f2691b = new a();

    /* loaded from: classes.dex */
    class a implements FlutterJNI.b {

        /* renamed from: io.flutter.view.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class Choreographer$FrameCallbackC0131a implements Choreographer.FrameCallback {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ long f2693a;

            Choreographer$FrameCallbackC0131a(long j) {
                this.f2693a = j;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                FlutterJNI.nativeOnVsync(j, j + ((long) (1.0E9d / f.this.f2690a.getDefaultDisplay().getRefreshRate())), this.f2693a);
            }
        }

        a() {
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.b
        public void a(long j) {
            Choreographer.getInstance().postFrameCallback(new Choreographer$FrameCallbackC0131a(j));
        }
    }

    private f(WindowManager windowManager) {
        this.f2690a = windowManager;
    }

    public static f b(WindowManager windowManager) {
        if (f2689c == null) {
            f2689c = new f(windowManager);
        }
        return f2689c;
    }

    public void c() {
        FlutterJNI.setAsyncWaitForVsyncDelegate(this.f2691b);
        FlutterJNI.setRefreshRateFPS(this.f2690a.getDefaultDisplay().getRefreshRate());
    }
}
