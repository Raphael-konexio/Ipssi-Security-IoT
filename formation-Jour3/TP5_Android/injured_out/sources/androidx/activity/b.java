package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f471a;

    /* renamed from: b  reason: collision with root package name */
    private CopyOnWriteArrayList<a> f472b = new CopyOnWriteArrayList<>();

    public b(boolean z) {
        this.f471a = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f472b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f471a;
    }

    public final void d() {
        Iterator<a> it = this.f472b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(a aVar) {
        this.f472b.remove(aVar);
    }

    public final void f(boolean z) {
        this.f471a = z;
    }
}
