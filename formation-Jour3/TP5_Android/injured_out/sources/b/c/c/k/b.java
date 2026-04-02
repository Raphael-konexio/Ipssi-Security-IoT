package b.c.c.k;

import android.content.Context;
import com.google.firebase.components.d;
import com.google.firebase.components.e;
import com.google.firebase.components.n;
/* loaded from: classes.dex */
public class b implements c {
    private b(Context context) {
        d.a(context);
    }

    public static com.google.firebase.components.d<c> a() {
        d.b a2 = com.google.firebase.components.d.a(c.class);
        a2.b(n.g(Context.class));
        a2.e(a.b());
        return a2.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ c b(e eVar) {
        return new b((Context) eVar.a(Context.class));
    }
}
