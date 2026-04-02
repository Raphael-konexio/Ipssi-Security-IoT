package d.p;

import d.p.d;
import d.s.c.p;
import d.s.d.g;
import d.s.d.h;
import java.io.Serializable;
/* loaded from: classes.dex */
public final class b implements d, Serializable {
    private final d f;
    private final d.b g;

    /* loaded from: classes.dex */
    static final class a extends h implements p<String, d.b, String> {
        public static final a f = new a();

        a() {
            super(2);
        }

        @Override // d.s.c.p
        /* renamed from: d */
        public final String a(String str, d.b bVar) {
            g.e(str, "acc");
            g.e(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public b(d dVar, d.b bVar) {
        g.e(dVar, "left");
        g.e(bVar, "element");
        this.f = dVar;
        this.g = bVar;
    }

    private final boolean b(d.b bVar) {
        return g.a(get(bVar.getKey()), bVar);
    }

    private final boolean c(b bVar) {
        while (b(bVar.g)) {
            d dVar = bVar.f;
            if (!(dVar instanceof b)) {
                if (dVar != null) {
                    return b((d.b) dVar);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
            bVar = (b) dVar;
        }
        return false;
    }

    private final int d() {
        int i = 2;
        b bVar = this;
        while (true) {
            d dVar = bVar.f;
            if (!(dVar instanceof b)) {
                dVar = null;
            }
            bVar = (b) dVar;
            if (bVar == null) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (bVar.d() != d() || !bVar.c(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // d.p.d
    public <R> R fold(R r, p<? super R, ? super d.b, ? extends R> pVar) {
        g.e(pVar, "operation");
        return pVar.a((Object) this.f.fold(r, pVar), this.g);
    }

    @Override // d.p.d
    public <E extends d.b> E get(d.c<E> cVar) {
        g.e(cVar, "key");
        b bVar = this;
        while (true) {
            E e = (E) bVar.g.get(cVar);
            if (e != null) {
                return e;
            }
            d dVar = bVar.f;
            if (!(dVar instanceof b)) {
                return (E) dVar.get(cVar);
            }
            bVar = (b) dVar;
        }
    }

    public int hashCode() {
        return this.f.hashCode() + this.g.hashCode();
    }

    @Override // d.p.d
    public d minusKey(d.c<?> cVar) {
        g.e(cVar, "key");
        if (this.g.get(cVar) != null) {
            return this.f;
        }
        d minusKey = this.f.minusKey(cVar);
        return minusKey == this.f ? this : minusKey == e.f ? this.g : new b(minusKey, this.g);
    }

    public String toString() {
        return "[" + ((String) fold("", a.f)) + "]";
    }
}
