package d.o;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends h {
    public static final <T> List<T> b() {
        return s.f;
    }

    public static <T> int c(List<? extends T> list) {
        d.s.d.g.e(list, "$this$lastIndex");
        return list.size() - 1;
    }

    public static <T> List<T> d(T... tArr) {
        List<T> a2;
        d.s.d.g.e(tArr, "elements");
        if (tArr.length > 0) {
            a2 = d.a(tArr);
            return a2;
        }
        return b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> e(List<? extends T> list) {
        d.s.d.g.e(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        return size != 0 ? size != 1 ? list : h.a(list.get(0)) : b();
    }

    public static void f() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
