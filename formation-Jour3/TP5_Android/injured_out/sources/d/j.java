package d;

import java.io.Serializable;
/* loaded from: classes.dex */
final class j<T> implements e<T>, Serializable {
    private d.s.c.a<? extends T> f;
    private volatile Object g;
    private final Object h;

    public j(d.s.c.a<? extends T> aVar, Object obj) {
        d.s.d.g.e(aVar, "initializer");
        this.f = aVar;
        this.g = l.f2400a;
        this.h = obj == null ? this : obj;
    }

    public /* synthetic */ j(d.s.c.a aVar, Object obj, int i, d.s.d.e eVar) {
        this(aVar, (i & 2) != 0 ? null : obj);
    }

    public boolean a() {
        return this.g != l.f2400a;
    }

    @Override // d.e
    public T getValue() {
        T t;
        T t2 = (T) this.g;
        if (t2 != l.f2400a) {
            return t2;
        }
        synchronized (this.h) {
            t = (T) this.g;
            if (t == l.f2400a) {
                d.s.c.a<? extends T> aVar = this.f;
                d.s.d.g.c(aVar);
                t = aVar.invoke();
                this.g = t;
                this.f = null;
            }
        }
        return t;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
