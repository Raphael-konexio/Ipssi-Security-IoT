package d.w;

import java.io.Serializable;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class e implements Serializable {
    private final Pattern f;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            d.s.d.g.e(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            d.s.d.g.d(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.w.e.<init>(java.lang.String):void");
    }

    public e(Pattern pattern) {
        d.s.d.g.e(pattern, "nativePattern");
        this.f = pattern;
    }

    public final String a(CharSequence charSequence, String str) {
        d.s.d.g.e(charSequence, "input");
        d.s.d.g.e(str, "replacement");
        String replaceAll = this.f.matcher(charSequence).replaceAll(str);
        d.s.d.g.d(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public String toString() {
        String pattern = this.f.toString();
        d.s.d.g.d(pattern, "nativePattern.toString()");
        return pattern;
    }
}
