package d.w;

import d.o.v;
import java.util.Collection;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends n {
    public static final boolean f(CharSequence charSequence) {
        boolean z;
        d.s.d.g.e(charSequence, "$this$isBlank");
        if (charSequence.length() != 0) {
            d.t.c j = p.j(charSequence);
            if (!(j instanceof Collection) || !((Collection) j).isEmpty()) {
                Iterator<Integer> it = j.iterator();
                while (it.hasNext()) {
                    if (!a.a(charSequence.charAt(((v) it).b()))) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static final boolean g(String str, int i, String str2, int i2, int i3, boolean z) {
        d.s.d.g.e(str, "$this$regionMatches");
        d.s.d.g.e(str2, "other");
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }
}
