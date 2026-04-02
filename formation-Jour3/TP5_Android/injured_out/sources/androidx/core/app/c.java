package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes.dex */
final class c {
    private static final Handler g = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    protected static final Class<?> f703a = a();

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f704b = b();

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f705c = f();

    /* renamed from: d  reason: collision with root package name */
    protected static final Method f706d = d(f703a);
    protected static final Method e = c(f703a);
    protected static final Method f = e(f703a);

    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ d f;
        final /* synthetic */ Object g;

        a(d dVar, Object obj) {
            this.f = dVar;
            this.g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f.f = this.g;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        final /* synthetic */ Application f;
        final /* synthetic */ d g;

        b(Application application, d dVar) {
            this.f = application;
            this.g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f.unregisterActivityLifecycleCallbacks(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.core.app.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0039c implements Runnable {
        final /* synthetic */ Object f;
        final /* synthetic */ Object g;

        RunnableC0039c(Object obj, Object obj2) {
            this.f = obj;
            this.g = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c.f706d != null) {
                    c.f706d.invoke(this.f, this.g, Boolean.FALSE, "AppCompat recreation");
                } else {
                    c.e.invoke(this.f, this.g, Boolean.FALSE);
                }
            } catch (RuntimeException e) {
                if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                    throw e;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class d implements Application.ActivityLifecycleCallbacks {
        Object f;
        private Activity g;
        private final int h;
        private boolean i = false;
        private boolean j = false;
        private boolean k = false;

        d(Activity activity) {
            this.g = activity;
            this.h = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.g == activity) {
                this.g = null;
                this.j = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.j || this.k || this.i || !c.h(this.f, this.h, activity)) {
                return;
            }
            this.k = true;
            this.f = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.g == activity) {
                this.i = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    protected static boolean h(Object obj, int i, Activity activity) {
        try {
            Object obj2 = f705c.get(activity);
            if (obj2 == obj && activity.hashCode() == i) {
                g.postAtFrontOfQueue(new RunnableC0039c(f704b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (g() && f == null) {
            return false;
        } else {
            if (e == null && f706d == null) {
                return false;
            }
            try {
                Object obj2 = f705c.get(activity);
                if (obj2 == null || (obj = f704b.get(activity)) == null) {
                    return false;
                }
                Application application = activity.getApplication();
                d dVar = new d(activity);
                application.registerActivityLifecycleCallbacks(dVar);
                g.post(new a(dVar, obj2));
                if (g()) {
                    f.invoke(obj, obj2, null, null, 0, Boolean.FALSE, null, null, Boolean.FALSE, Boolean.FALSE);
                } else {
                    activity.recreate();
                }
                g.post(new b(application, dVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
