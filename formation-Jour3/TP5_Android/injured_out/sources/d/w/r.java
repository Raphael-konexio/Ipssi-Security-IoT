package d.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends q {
    public static final String H(String str, int i) {
        int b2;
        d.s.d.g.e(str, "$this$drop");
        if (i >= 0) {
            b2 = d.t.f.b(i, str.length());
            String substring = str.substring(b2);
            d.s.d.g.d(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }
}
