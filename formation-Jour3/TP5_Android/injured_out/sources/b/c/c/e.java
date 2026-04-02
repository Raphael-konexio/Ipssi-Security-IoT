package b.c.c;

import com.google.android.gms.common.internal.r;
/* loaded from: classes.dex */
public class e extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str) {
        super(str);
        r.g(str, "Detail message must not be empty");
    }
}
