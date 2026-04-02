package d.o;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends c {
    public static <T> List<T> a(T[] tArr) {
        d.s.d.g.e(tArr, "$this$asList");
        List<T> a2 = f.a(tArr);
        d.s.d.g.d(a2, "ArraysUtilJVM.asList(this)");
        return a2;
    }
}
