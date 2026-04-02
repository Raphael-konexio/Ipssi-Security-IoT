package d.t;

import d.o.v;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class b extends v {
    private final int f;
    private boolean g;
    private int h;
    private final int i;

    public b(int i, int i2, int i3) {
        this.i = i3;
        this.f = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.g = z;
        this.h = z ? i : this.f;
    }

    @Override // d.o.v
    public int b() {
        int i = this.h;
        if (i != this.f) {
            this.h = this.i + i;
        } else if (!this.g) {
            throw new NoSuchElementException();
        } else {
            this.g = false;
        }
        return i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.g;
    }
}
