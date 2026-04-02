package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import b.c.a.a.d.c.g2;
/* loaded from: classes.dex */
public final class d {
    private static b.c.a.a.b.k.a h = new b.c.a.a.b.k.a("TokenRefresher", "FirebaseAuth:");

    /* renamed from: a  reason: collision with root package name */
    private final b.c.c.c f1888a;

    /* renamed from: b  reason: collision with root package name */
    volatile long f1889b;

    /* renamed from: c  reason: collision with root package name */
    volatile long f1890c;

    /* renamed from: d  reason: collision with root package name */
    private long f1891d;
    private HandlerThread e;
    private Handler f;
    private Runnable g;

    public d(b.c.c.c cVar) {
        h.f("Initializing TokenRefresher", new Object[0]);
        com.google.android.gms.common.internal.r.h(cVar);
        this.f1888a = cVar;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.e = handlerThread;
        handlerThread.start();
        this.f = new g2(this.e.getLooper());
        this.g = new n0(this, this.f1888a.m());
        this.f1891d = 300000L;
    }

    public final void a() {
        b.c.a.a.b.k.a aVar = h;
        long j = this.f1889b - this.f1891d;
        StringBuilder sb = new StringBuilder(43);
        sb.append("Scheduling refresh for ");
        sb.append(j);
        aVar.f(sb.toString(), new Object[0]);
        c();
        this.f1890c = Math.max((this.f1889b - com.google.android.gms.common.util.f.b().a()) - this.f1891d, 0L) / 1000;
        this.f.postDelayed(this.g, this.f1890c * 1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        int i = (int) this.f1890c;
        this.f1890c = (i == 30 || i == 60 || i == 120 || i == 240 || i == 480) ? 2 * this.f1890c : i != 960 ? 30L : 960L;
        this.f1889b = com.google.android.gms.common.util.f.b().a() + (this.f1890c * 1000);
        b.c.a.a.b.k.a aVar = h;
        long j = this.f1889b;
        StringBuilder sb = new StringBuilder(43);
        sb.append("Scheduling refresh for ");
        sb.append(j);
        aVar.f(sb.toString(), new Object[0]);
        this.f.postDelayed(this.g, this.f1890c * 1000);
    }

    public final void c() {
        this.f.removeCallbacks(this.g);
    }
}
