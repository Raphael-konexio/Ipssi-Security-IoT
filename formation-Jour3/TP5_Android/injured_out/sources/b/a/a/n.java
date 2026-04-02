package b.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f1163a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<m<?>> f1164b;

    /* renamed from: c  reason: collision with root package name */
    private final PriorityBlockingQueue<m<?>> f1165c;

    /* renamed from: d  reason: collision with root package name */
    private final PriorityBlockingQueue<m<?>> f1166d;
    private final b e;
    private final h f;
    private final p g;
    private final i[] h;
    private c i;
    private final List<a> j;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(m<T> mVar);
    }

    public n(b bVar, h hVar) {
        this(bVar, hVar, 4);
    }

    public n(b bVar, h hVar, int i) {
        this(bVar, hVar, i, new f(new Handler(Looper.getMainLooper())));
    }

    public n(b bVar, h hVar, int i, p pVar) {
        this.f1163a = new AtomicInteger();
        this.f1164b = new HashSet();
        this.f1165c = new PriorityBlockingQueue<>();
        this.f1166d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.e = bVar;
        this.f = hVar;
        this.h = new i[i];
        this.g = pVar;
    }

    public <T> m<T> a(m<T> mVar) {
        mVar.V(this);
        synchronized (this.f1164b) {
            this.f1164b.add(mVar);
        }
        mVar.X(c());
        mVar.e("add-to-queue");
        (!mVar.Y() ? this.f1166d : this.f1165c).add(mVar);
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void b(m<T> mVar) {
        synchronized (this.f1164b) {
            this.f1164b.remove(mVar);
        }
        synchronized (this.j) {
            for (a aVar : this.j) {
                aVar.a(mVar);
            }
        }
    }

    public int c() {
        return this.f1163a.incrementAndGet();
    }

    public void d() {
        e();
        c cVar = new c(this.f1165c, this.f1166d, this.e, this.g);
        this.i = cVar;
        cVar.start();
        for (int i = 0; i < this.h.length; i++) {
            i iVar = new i(this.f1166d, this.f, this.e, this.g);
            this.h[i] = iVar;
            iVar.start();
        }
    }

    public void e() {
        i[] iVarArr;
        c cVar = this.i;
        if (cVar != null) {
            cVar.e();
        }
        for (i iVar : this.h) {
            if (iVar != null) {
                iVar.e();
            }
        }
    }
}
