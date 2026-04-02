package d.p;

import d.p.d;
import d.s.c.p;
import d.s.d.g;
import java.io.Serializable;
/* loaded from: classes.dex */
public final class e implements d, Serializable {
    public static final e f = new e();

    private e() {
    }

    @Override // d.p.d
    public <R> R fold(R r, p<? super R, ? super d.b, ? extends R> pVar) {
        g.e(pVar, "operation");
        return r;
    }

    @Override // d.p.d
    public <E extends d.b> E get(d.c<E> cVar) {
        g.e(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // d.p.d
    public d minusKey(d.c<?> cVar) {
        g.e(cVar, "key");
        return this;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
