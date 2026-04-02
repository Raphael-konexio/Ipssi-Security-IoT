package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
@KeepName
/* loaded from: classes.dex */
public abstract class BasePendingResult<R extends com.google.android.gms.common.api.k> extends com.google.android.gms.common.api.h<R> {
    private com.google.android.gms.common.api.l<? super R> e;
    private R g;
    private Status h;
    private volatile boolean i;
    private boolean j;
    private boolean k;
    @KeepName
    private b mResultGuardian;

    /* renamed from: a  reason: collision with root package name */
    private final Object f1533a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final CountDownLatch f1535c = new CountDownLatch(1);

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<h.a> f1536d = new ArrayList<>();
    private final AtomicReference<i0> f = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final a<R> f1534b = new a<>(Looper.getMainLooper());

    /* loaded from: classes.dex */
    public static class a<R extends com.google.android.gms.common.api.k> extends b.c.a.a.d.a.d {
        public a(Looper looper) {
            super(looper);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.google.android.gms.common.api.internal.BasePendingResult.h(com.google.android.gms.common.api.l):com.google.android.gms.common.api.l
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        public final void a(com.google.android.gms.common.api.l<? super R> r2, R r3) {
            /*
                r1 = this;
                com.google.android.gms.common.api.internal.BasePendingResult.h(r2)
                android.util.Pair r0 = new android.util.Pair
                r0.<init>(r2, r3)
                r2 = 1
                android.os.Message r2 = r1.obtainMessage(r2, r0)
                r1.sendMessage(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.a.a(com.google.android.gms.common.api.l, com.google.android.gms.common.api.k):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    ((BasePendingResult) message.obj).j(Status.k);
                    return;
                }
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
                return;
            }
            Pair pair = (Pair) message.obj;
            com.google.android.gms.common.api.l lVar = (com.google.android.gms.common.api.l) pair.first;
            com.google.android.gms.common.api.k kVar = (com.google.android.gms.common.api.k) pair.second;
            try {
                lVar.a(kVar);
            } catch (RuntimeException e) {
                BasePendingResult.i(kVar);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b {
        private b() {
        }

        /* synthetic */ b(BasePendingResult basePendingResult, o0 o0Var) {
            this();
        }

        protected final void finalize() {
            BasePendingResult.i(BasePendingResult.this.g);
            super.finalize();
        }
    }

    static {
        new o0();
    }

    @Deprecated
    BasePendingResult() {
        new WeakReference(null);
    }

    private final R b() {
        R r;
        synchronized (this.f1533a) {
            com.google.android.gms.common.internal.r.k(!this.i, "Result has already been consumed.");
            com.google.android.gms.common.internal.r.k(c(), "Result is not ready.");
            r = this.g;
            this.g = null;
            this.e = null;
            this.i = true;
        }
        i0 andSet = this.f.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }

    private static <R extends com.google.android.gms.common.api.k> com.google.android.gms.common.api.l<R> f(com.google.android.gms.common.api.l<R> lVar) {
        return lVar;
    }

    private final void g(R r) {
        this.g = r;
        this.f1535c.countDown();
        this.h = this.g.getStatus();
        if (this.j) {
            this.e = null;
        } else if (this.e != null) {
            this.f1534b.removeMessages(2);
            this.f1534b.a(this.e, b());
        } else if (this.g instanceof com.google.android.gms.common.api.i) {
            this.mResultGuardian = new b(this, null);
        }
        ArrayList<h.a> arrayList = this.f1536d;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            h.a aVar = arrayList.get(i);
            i++;
            aVar.a(this.h);
        }
        this.f1536d.clear();
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    static /* synthetic */ com.google.android.gms.common.api.l h(com.google.android.gms.common.api.l r0) {
        /*
            f(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.h(com.google.android.gms.common.api.l):com.google.android.gms.common.api.l");
    }

    public static void i(com.google.android.gms.common.api.k kVar) {
        if (kVar instanceof com.google.android.gms.common.api.i) {
            try {
                ((com.google.android.gms.common.api.i) kVar).a();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(kVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e);
            }
        }
    }

    protected abstract R a(Status status);

    public final boolean c() {
        return this.f1535c.getCount() == 0;
    }

    public final void d(R r) {
        synchronized (this.f1533a) {
            if (this.k || this.j) {
                i(r);
                return;
            }
            c();
            boolean z = true;
            com.google.android.gms.common.internal.r.k(!c(), "Results have already been set");
            if (this.i) {
                z = false;
            }
            com.google.android.gms.common.internal.r.k(z, "Result has already been consumed");
            g(r);
        }
    }

    public final void j(Status status) {
        synchronized (this.f1533a) {
            if (!c()) {
                d(a(status));
                this.k = true;
            }
        }
    }
}
