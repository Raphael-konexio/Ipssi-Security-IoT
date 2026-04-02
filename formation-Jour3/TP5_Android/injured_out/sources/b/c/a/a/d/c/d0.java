package b.c.a.a.d.c;

import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class d0<E> extends x<E> implements Set<E> {
    private transient w<E> g;

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return i0.b(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return i0.a(this);
    }

    @Override // b.c.a.a.d.c.x, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    w<E> l() {
        return w.u(toArray());
    }

    public w<E> m() {
        w<E> wVar = this.g;
        if (wVar == null) {
            w<E> l = l();
            this.g = l;
            return l;
        }
        return wVar;
    }
}
