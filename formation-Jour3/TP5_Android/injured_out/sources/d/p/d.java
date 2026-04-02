package d.p;

import d.s.c.p;
import d.s.d.g;
import d.s.d.h;
/* loaded from: classes.dex */
public interface d {

    /* loaded from: classes.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: d.p.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0109a extends h implements p<d, b, d> {
            public static final C0109a f = new C0109a();

            C0109a() {
                super(2);
            }

            @Override // d.s.c.p
            /* renamed from: d */
            public final d a(d dVar, b bVar) {
                g.e(dVar, "acc");
                g.e(bVar, "element");
                d minusKey = dVar.minusKey(bVar.getKey());
                if (minusKey == e.f) {
                    return bVar;
                }
                d.p.c cVar = (d.p.c) minusKey.get(d.p.c.f2402c);
                if (cVar == null) {
                    return new d.p.b(minusKey, bVar);
                }
                d minusKey2 = minusKey.minusKey(d.p.c.f2402c);
                return minusKey2 == e.f ? new d.p.b(bVar, cVar) : new d.p.b(new d.p.b(minusKey2, bVar), cVar);
            }
        }

        public static d a(d dVar, d dVar2) {
            g.e(dVar2, "context");
            return dVar2 == e.f ? dVar : (d) dVar2.fold(dVar, C0109a.f);
        }
    }

    /* loaded from: classes.dex */
    public interface b extends d {

        /* loaded from: classes.dex */
        public static final class a {
            public static <R> R a(b bVar, R r, p<? super R, ? super b, ? extends R> pVar) {
                g.e(pVar, "operation");
                return pVar.a(r, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b bVar, c<E> cVar) {
                g.e(cVar, "key");
                if (g.a(bVar.getKey(), cVar)) {
                    if (bVar != 0) {
                        return bVar;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type E");
                }
                return null;
            }

            public static d c(b bVar, c<?> cVar) {
                g.e(cVar, "key");
                return g.a(bVar.getKey(), cVar) ? e.f : bVar;
            }

            public static d d(b bVar, d dVar) {
                g.e(dVar, "context");
                return a.a(bVar, dVar);
            }
        }

        @Override // d.p.d
        <E extends b> E get(c<E> cVar);

        c<?> getKey();
    }

    /* loaded from: classes.dex */
    public interface c<E extends b> {
    }

    <R> R fold(R r, p<? super R, ? super b, ? extends R> pVar);

    <E extends b> E get(c<E> cVar);

    d minusKey(c<?> cVar);
}
