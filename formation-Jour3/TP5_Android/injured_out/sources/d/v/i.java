package d.v;

import d.s.c.l;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class i<T, R> implements b<R> {

    /* renamed from: a  reason: collision with root package name */
    private final b<T> f2416a;

    /* renamed from: b  reason: collision with root package name */
    private final l<T, R> f2417b;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<R> {
        private final Iterator<T> f;

        a() {
            this.f = i.this.f2416a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) i.this.f2417b.c(this.f.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(b<? extends T> bVar, l<? super T, ? extends R> lVar) {
        d.s.d.g.e(bVar, "sequence");
        d.s.d.g.e(lVar, "transformer");
        this.f2416a = bVar;
        this.f2417b = lVar;
    }

    @Override // d.v.b
    public Iterator<R> iterator() {
        return new a();
    }
}
