package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: c  reason: collision with root package name */
    private static k f2457c;

    /* renamed from: a  reason: collision with root package name */
    private final LongSparseArray<MotionEvent> f2458a = new LongSparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private final PriorityQueue<Long> f2459b = new PriorityQueue<>();

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        private static final AtomicLong f2460b = new AtomicLong(0);

        /* renamed from: a  reason: collision with root package name */
        private final long f2461a;

        private a(long j) {
            this.f2461a = j;
        }

        public static a b() {
            return c(f2460b.incrementAndGet());
        }

        public static a c(long j) {
            return new a(j);
        }

        public long d() {
            return this.f2461a;
        }
    }

    private k() {
    }

    public static k a() {
        if (f2457c == null) {
            f2457c = new k();
        }
        return f2457c;
    }

    public MotionEvent b(a aVar) {
        while (!this.f2459b.isEmpty() && this.f2459b.peek().longValue() < aVar.f2461a) {
            this.f2458a.remove(this.f2459b.poll().longValue());
        }
        if (!this.f2459b.isEmpty() && this.f2459b.peek().longValue() == aVar.f2461a) {
            this.f2459b.poll();
        }
        MotionEvent motionEvent = this.f2458a.get(aVar.f2461a);
        this.f2458a.remove(aVar.f2461a);
        return motionEvent;
    }

    public a c(MotionEvent motionEvent) {
        a b2 = a.b();
        this.f2458a.put(b2.f2461a, MotionEvent.obtain(motionEvent));
        this.f2459b.add(Long.valueOf(b2.f2461a));
        return b2;
    }
}
