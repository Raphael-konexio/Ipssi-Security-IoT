package com.google.firebase.database.o.m;

import com.google.firebase.database.q.c;
import com.google.firebase.database.q.d;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f2109a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2110b;

    /* renamed from: c  reason: collision with root package name */
    private final long f2111c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2112d;
    private final double e;
    private final double f;
    private final Random g;
    private ScheduledFuture<?> h;
    private long i;
    private boolean j;

    /* renamed from: com.google.firebase.database.o.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0099a implements Runnable {
        final /* synthetic */ Runnable f;

        RunnableC0099a(Runnable runnable) {
            this.f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.h = null;
            this.f.run();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final ScheduledExecutorService f2113a;

        /* renamed from: b  reason: collision with root package name */
        private long f2114b = 1000;

        /* renamed from: c  reason: collision with root package name */
        private double f2115c = 0.5d;

        /* renamed from: d  reason: collision with root package name */
        private long f2116d = 30000;
        private double e = 1.3d;
        private final c f;

        public b(ScheduledExecutorService scheduledExecutorService, d dVar, String str) {
            this.f2113a = scheduledExecutorService;
            this.f = new c(dVar, str);
        }

        public a a() {
            return new a(this.f2113a, this.f, this.f2114b, this.f2116d, this.e, this.f2115c, null);
        }

        public b b(double d2) {
            if (d2 >= 0.0d && d2 <= 1.0d) {
                this.f2115c = d2;
                return this;
            }
            throw new IllegalArgumentException("Argument out of range: " + d2);
        }

        public b c(long j) {
            this.f2116d = j;
            return this;
        }

        public b d(long j) {
            this.f2114b = j;
            return this;
        }

        public b e(double d2) {
            this.e = d2;
            return this;
        }
    }

    private a(ScheduledExecutorService scheduledExecutorService, c cVar, long j, long j2, double d2, double d3) {
        this.g = new Random();
        this.j = true;
        this.f2109a = scheduledExecutorService;
        this.f2110b = cVar;
        this.f2111c = j;
        this.f2112d = j2;
        this.f = d2;
        this.e = d3;
    }

    /* synthetic */ a(ScheduledExecutorService scheduledExecutorService, c cVar, long j, long j2, double d2, double d3, RunnableC0099a runnableC0099a) {
        this(scheduledExecutorService, cVar, j, j2, d2, d3);
    }

    public void b() {
        if (this.h != null) {
            this.f2110b.b("Cancelling existing retry attempt", new Object[0]);
            this.h.cancel(false);
            this.h = null;
        } else {
            this.f2110b.b("No existing retry attempt to cancel", new Object[0]);
        }
        this.i = 0L;
    }

    public void c(Runnable runnable) {
        RunnableC0099a runnableC0099a = new RunnableC0099a(runnable);
        if (this.h != null) {
            this.f2110b.b("Cancelling previous scheduled retry", new Object[0]);
            this.h.cancel(false);
            this.h = null;
        }
        long j = 0;
        if (!this.j) {
            long j2 = this.i;
            this.i = j2 == 0 ? this.f2111c : Math.min((long) (j2 * this.f), this.f2112d);
            double d2 = this.e;
            long j3 = this.i;
            j = (long) (((1.0d - d2) * j3) + (d2 * j3 * this.g.nextDouble()));
        }
        this.j = false;
        this.f2110b.b("Scheduling retry in %dms", Long.valueOf(j));
        this.h = this.f2109a.schedule(runnableC0099a, j, TimeUnit.MILLISECONDS);
    }

    public void d() {
        this.i = this.f2112d;
    }

    public void e() {
        this.j = true;
        this.i = 0L;
    }
}
