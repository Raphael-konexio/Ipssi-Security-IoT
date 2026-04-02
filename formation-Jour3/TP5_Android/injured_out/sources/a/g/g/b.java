package a.g.g;

import android.os.Build;
import android.os.CancellationSignal;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f150a;

    /* renamed from: b  reason: collision with root package name */
    private a f151b;

    /* renamed from: c  reason: collision with root package name */
    private Object f152c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f153d;

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    private void d() {
        while (this.f153d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            if (this.f150a) {
                return;
            }
            this.f150a = true;
            this.f153d = true;
            a aVar = this.f151b;
            Object obj = this.f152c;
            if (aVar != null) {
                try {
                    aVar.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f153d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.f153d = false;
                notifyAll();
            }
        }
    }

    public boolean b() {
        boolean z;
        synchronized (this) {
            z = this.f150a;
        }
        return z;
    }

    public void c(a aVar) {
        synchronized (this) {
            d();
            if (this.f151b == aVar) {
                return;
            }
            this.f151b = aVar;
            if (this.f150a && aVar != null) {
                aVar.a();
            }
        }
    }
}
