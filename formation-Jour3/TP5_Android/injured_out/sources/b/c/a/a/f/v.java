package b.c.a.a.f;

import java.util.ArrayDeque;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1288a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private Queue<u<TResult>> f1289b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1290c;

    public final void a(g<TResult> gVar) {
        u<TResult> poll;
        synchronized (this.f1288a) {
            if (this.f1289b != null && !this.f1290c) {
                this.f1290c = true;
                while (true) {
                    synchronized (this.f1288a) {
                        poll = this.f1289b.poll();
                        if (poll == null) {
                            this.f1290c = false;
                            return;
                        }
                    }
                    poll.a(gVar);
                }
            }
        }
    }

    public final void b(u<TResult> uVar) {
        synchronized (this.f1288a) {
            if (this.f1289b == null) {
                this.f1289b = new ArrayDeque();
            }
            this.f1289b.add(uVar);
        }
    }
}
