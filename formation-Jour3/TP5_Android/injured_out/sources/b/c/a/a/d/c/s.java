package b.c.a.a.d.c;

import java.util.NoSuchElementException;
/* loaded from: classes.dex */
abstract class s<E> extends k0<E> {
    private final int f;
    private int g;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(int i, int i2) {
        m.e(i2, i);
        this.f = i;
        this.g = i2;
    }

    protected abstract E a(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.g < this.f;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.g > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i = this.g;
            this.g = i + 1;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.g;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i = this.g - 1;
            this.g = i;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.g - 1;
    }
}
