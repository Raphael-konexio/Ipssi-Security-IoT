package b.c.a.a.d.c;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
abstract class c<T> implements Iterator<T> {
    private int f = e.f1247b;
    private T g;

    protected abstract T a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final T b() {
        this.f = e.f1248c;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f != e.f1249d) {
            int i = b.f1245a[this.f - 1];
            if (i != 1) {
                if (i != 2) {
                    this.f = e.f1249d;
                    this.g = a();
                    if (this.f != e.f1248c) {
                        this.f = e.f1246a;
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f = e.f1247b;
            T t = this.g;
            this.g = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
