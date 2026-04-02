package kotlinx.coroutines;

import d.p.d;
import d.s.d.g;
import java.util.concurrent.CancellationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class c {
    public static final void a(d dVar, CancellationException cancellationException) {
        g.f(dVar, "$this$cancel");
        a aVar = (a) dVar.get(a.e);
        if (aVar != null) {
            aVar.a(cancellationException);
        }
    }

    public static /* synthetic */ void b(d dVar, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        b.a(dVar, cancellationException);
    }
}
