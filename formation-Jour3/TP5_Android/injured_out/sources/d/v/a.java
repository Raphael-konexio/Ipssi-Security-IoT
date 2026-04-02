package d.v;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<b<T>> f2415a;

    public a(b<? extends T> bVar) {
        d.s.d.g.e(bVar, "sequence");
        this.f2415a = new AtomicReference<>(bVar);
    }

    @Override // d.v.b
    public Iterator<T> iterator() {
        b<T> andSet = this.f2415a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
