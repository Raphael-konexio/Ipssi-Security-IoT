package d.v;

import d.s.c.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends g {
    public static <T, R> b<R> b(b<? extends T> bVar, l<? super T, ? extends R> lVar) {
        d.s.d.g.e(bVar, "$this$map");
        d.s.d.g.e(lVar, "transform");
        return new i(bVar, lVar);
    }

    public static final <T, C extends Collection<? super T>> C c(b<? extends T> bVar, C c2) {
        d.s.d.g.e(bVar, "$this$toCollection");
        d.s.d.g.e(c2, "destination");
        for (T t : bVar) {
            c2.add(t);
        }
        return c2;
    }

    public static <T> List<T> d(b<? extends T> bVar) {
        List<T> e;
        d.s.d.g.e(bVar, "$this$toList");
        e = d.o.i.e(e(bVar));
        return e;
    }

    public static final <T> List<T> e(b<? extends T> bVar) {
        d.s.d.g.e(bVar, "$this$toMutableList");
        ArrayList arrayList = new ArrayList();
        c(bVar, arrayList);
        return arrayList;
    }
}
