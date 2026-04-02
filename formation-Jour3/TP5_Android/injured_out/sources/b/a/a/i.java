package b.a.a;

import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;
/* loaded from: classes.dex */
public class i extends Thread {
    private final BlockingQueue<m<?>> f;
    private final h g;
    private final b h;
    private final p i;
    private volatile boolean j = false;

    public i(BlockingQueue<m<?>> blockingQueue, h hVar, b bVar, p pVar) {
        this.f = blockingQueue;
        this.g = hVar;
        this.h = bVar;
        this.i = pVar;
    }

    private void a(m<?> mVar) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(mVar.K());
        }
    }

    private void b(m<?> mVar, t tVar) {
        mVar.R(tVar);
        this.i.a(mVar, tVar);
    }

    private void c() {
        d(this.f.take());
    }

    void d(m<?> mVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            mVar.e("network-queue-take");
            if (mVar.N()) {
                mVar.s("network-discard-cancelled");
                mVar.P();
                return;
            }
            a(mVar);
            k a2 = this.g.a(mVar);
            mVar.e("network-http-complete");
            if (a2.f1162d && mVar.M()) {
                mVar.s("not-modified");
                mVar.P();
                return;
            }
            o<?> S = mVar.S(a2);
            mVar.e("network-parse-complete");
            if (mVar.Y() && S.f1168b != null) {
                this.h.b(mVar.y(), S.f1168b);
                mVar.e("network-cache-written");
            }
            mVar.O();
            this.i.b(mVar, S);
            mVar.Q(S);
        } catch (t e) {
            e.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            b(mVar, e);
            mVar.P();
        } catch (Exception e2) {
            u.d(e2, "Unhandled exception %s", e2.toString());
            t tVar = new t(e2);
            tVar.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.i.a(mVar, tVar);
            mVar.P();
        }
    }

    public void e() {
        this.j = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                c();
            } catch (InterruptedException unused) {
                if (this.j) {
                    Thread.currentThread().interrupt();
                    return;
                }
                u.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
