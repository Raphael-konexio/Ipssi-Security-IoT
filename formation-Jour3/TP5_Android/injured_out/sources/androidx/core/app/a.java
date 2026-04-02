package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
/* loaded from: classes.dex */
public class a extends androidx.core.content.a {

    /* renamed from: c  reason: collision with root package name */
    private static b f702c;

    /* renamed from: androidx.core.app.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0038a implements Runnable {
        final /* synthetic */ Activity f;

        RunnableC0038a(Activity activity) {
            this.f = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f.isFinishing() || c.i(this.f)) {
                return;
            }
            this.f.recreate();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(Activity activity, int i, int i2, Intent intent);
    }

    public static void j(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static b k() {
        return f702c;
    }

    public static void l(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            if (i <= 23) {
                new Handler(activity.getMainLooper()).post(new RunnableC0038a(activity));
                return;
            } else if (c.i(activity)) {
                return;
            }
        }
        activity.recreate();
    }
}
