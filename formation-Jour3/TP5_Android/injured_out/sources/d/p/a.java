package d.p;

import d.p.d;
import d.s.c.p;
import d.s.d.g;
/* loaded from: classes.dex */
public abstract class a implements d.b {
    private final d.c<?> key;

    public a(d.c<?> cVar) {
        g.e(cVar, "key");
        this.key = cVar;
    }

    @Override // d.p.d
    public <R> R fold(R r, p<? super R, ? super d.b, ? extends R> pVar) {
        g.e(pVar, "operation");
        return (R) d.b.a.a(this, r, pVar);
    }

    @Override // d.p.d.b, d.p.d
    public <E extends d.b> E get(d.c<E> cVar) {
        g.e(cVar, "key");
        return (E) d.b.a.b(this, cVar);
    }

    @Override // d.p.d.b
    public d.c<?> getKey() {
        return this.key;
    }

    @Override // d.p.d
    public d minusKey(d.c<?> cVar) {
        g.e(cVar, "key");
        return d.b.a.c(this, cVar);
    }

    public d plus(d dVar) {
        g.e(dVar, "context");
        return d.b.a.d(this, dVar);
    }
}
