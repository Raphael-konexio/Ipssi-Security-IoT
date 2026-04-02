package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.Looper;
import b.c.a.a.d.c.g2;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class r implements Executor {

    /* renamed from: b  reason: collision with root package name */
    private static r f1908b = new r();

    /* renamed from: a  reason: collision with root package name */
    private Handler f1909a = new g2(Looper.getMainLooper());

    private r() {
    }

    public static r a() {
        return f1908b;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f1909a.post(runnable);
    }
}
