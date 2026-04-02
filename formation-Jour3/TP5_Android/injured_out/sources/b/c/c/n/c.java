package b.c.c.n;

import com.google.firebase.components.d;
import com.google.firebase.components.n;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public class c implements h {
    c(Set<f> set, d dVar) {
        c(set);
    }

    public static com.google.firebase.components.d<h> a() {
        d.b a2 = com.google.firebase.components.d.a(h.class);
        a2.b(n.h(f.class));
        a2.e(b.b());
        return a2.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ h b(com.google.firebase.components.e eVar) {
        return new c(eVar.b(f.class), d.a());
    }

    private static String c(Set<f> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            f next = it.next();
            sb.append(next.b());
            sb.append('/');
            sb.append(next.c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
