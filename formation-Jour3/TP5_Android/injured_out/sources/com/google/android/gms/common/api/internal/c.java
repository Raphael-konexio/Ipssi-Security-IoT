package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final c j = new c();
    private final AtomicBoolean f = new AtomicBoolean();
    private final AtomicBoolean g = new AtomicBoolean();
    private final ArrayList<a> h = new ArrayList<>();
    private boolean i = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z);
    }

    private c() {
    }

    public static c b() {
        return j;
    }

    public static void c(Application application) {
        synchronized (j) {
            if (!j.i) {
                application.registerActivityLifecycleCallbacks(j);
                application.registerComponentCallbacks(j);
                j.i = true;
            }
        }
    }

    private final void e(boolean z) {
        synchronized (j) {
            ArrayList<a> arrayList = this.h;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                a aVar = arrayList.get(i);
                i++;
                aVar.a(z);
            }
        }
    }

    public final void a(a aVar) {
        synchronized (j) {
            this.h.add(aVar);
        }
    }

    public final boolean d() {
        return this.f.get();
    }

    public final boolean f(boolean z) {
        if (!this.g.get()) {
            if (!com.google.android.gms.common.util.i.c()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.g.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f.set(true);
            }
        }
        return d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f.compareAndSet(true, false);
        this.g.set(true);
        if (compareAndSet) {
            e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f.compareAndSet(true, false);
        this.g.set(true);
        if (compareAndSet) {
            e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20 && this.f.compareAndSet(false, true)) {
            this.g.set(true);
            e(true);
        }
    }
}
