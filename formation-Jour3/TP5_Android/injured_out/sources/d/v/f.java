package d.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends e {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> b<T> a(b<? extends T> bVar) {
        d.s.d.g.e(bVar, "$this$constrainOnce");
        return bVar instanceof a ? bVar : new a(bVar);
    }
}
