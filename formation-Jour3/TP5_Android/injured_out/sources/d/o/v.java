package d.o;

import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class v implements Iterator<Integer> {
    @Override // java.util.Iterator
    /* renamed from: a */
    public final Integer next() {
        return Integer.valueOf(b());
    }

    public abstract int b();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
