package b.a.a;

import android.os.Process;
import b.a.a.b;
import b.a.a.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes.dex */
public class c extends Thread {
    private static final boolean l = u.f1172b;
    private final BlockingQueue<m<?>> f;
    private final BlockingQueue<m<?>> g;
    private final b.a.a.b h;
    private final p i;
    private volatile boolean j = false;
    private final b k = new b(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ m f;

        a(m mVar) {
            this.f = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.this.g.put(this.f);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements m.b {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, List<m<?>>> f1149a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final c f1150b;

        b(c cVar) {
            this.f1150b = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean d(m<?> mVar) {
            String y = mVar.y();
            if (!this.f1149a.containsKey(y)) {
                this.f1149a.put(y, null);
                mVar.U(this);
                if (u.f1172b) {
                    u.b("new request, sending to network %s", y);
                }
                return false;
            }
            List<m<?>> list = this.f1149a.get(y);
            if (list == null) {
                list = new ArrayList<>();
            }
            mVar.e("waiting-for-response");
            list.add(mVar);
            this.f1149a.put(y, list);
            if (u.f1172b) {
                u.b("Request for cacheKey=%s is in flight, putting on hold.", y);
            }
            return true;
        }

        @Override // b.a.a.m.b
        public synchronized void a(m<?> mVar) {
            String y = mVar.y();
            List<m<?>> remove = this.f1149a.remove(y);
            if (remove != null && !remove.isEmpty()) {
                if (u.f1172b) {
                    u.e("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), y);
                }
                m<?> remove2 = remove.remove(0);
                this.f1149a.put(y, remove);
                remove2.U(this);
                try {
                    this.f1150b.g.put(remove2);
                } catch (InterruptedException e) {
                    u.c("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    this.f1150b.e();
                }
            }
        }

        @Override // b.a.a.m.b
        public void b(m<?> mVar, o<?> oVar) {
            List<m<?>> remove;
            b.a aVar = oVar.f1168b;
            if (aVar == null || aVar.a()) {
                a(mVar);
                return;
            }
            String y = mVar.y();
            synchronized (this) {
                remove = this.f1149a.remove(y);
            }
            if (remove != null) {
                if (u.f1172b) {
                    u.e("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), y);
                }
                for (m<?> mVar2 : remove) {
                    this.f1150b.i.b(mVar2, oVar);
                }
            }
        }
    }

    public c(BlockingQueue<m<?>> blockingQueue, BlockingQueue<m<?>> blockingQueue2, b.a.a.b bVar, p pVar) {
        this.f = blockingQueue;
        this.g = blockingQueue2;
        this.h = bVar;
        this.i = pVar;
    }

    private void c() {
        d(this.f.take());
    }

    void d(m<?> mVar) {
        mVar.e("cache-queue-take");
        if (mVar.N()) {
            mVar.s("cache-discard-canceled");
            return;
        }
        b.a c2 = this.h.c(mVar.y());
        if (c2 == null) {
            mVar.e("cache-miss");
            if (this.k.d(mVar)) {
                return;
            }
            this.g.put(mVar);
        } else if (c2.a()) {
            mVar.e("cache-hit-expired");
            mVar.T(c2);
            if (this.k.d(mVar)) {
                return;
            }
            this.g.put(mVar);
        } else {
            mVar.e("cache-hit");
            o<?> S = mVar.S(new k(c2.f1145a, c2.g));
            mVar.e("cache-hit-parsed");
            if (c2.b()) {
                mVar.e("cache-hit-refresh-needed");
                mVar.T(c2);
                S.f1170d = true;
                if (!this.k.d(mVar)) {
                    this.i.c(mVar, S, new a(mVar));
                    return;
                }
            }
            this.i.b(mVar, S);
        }
    }

    public void e() {
        this.j = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (l) {
            u.e("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.h.a();
        while (true) {
            try {
                c();
            } catch (InterruptedException unused) {
                if (this.j) {
                    Thread.currentThread().interrupt();
                    return;
                }
                u.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
