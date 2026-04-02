package kotlinx.coroutines;

import d.p.d;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CoroutineExceptionHandler;
/* loaded from: classes.dex */
public interface a extends d.b {
    public static final b e = b.f2697a;

    /* renamed from: kotlinx.coroutines.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0132a {
        public static /* synthetic */ void a(a aVar, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            aVar.a(cancellationException);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements d.c<a> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f2697a = new b();

        static {
            CoroutineExceptionHandler.a aVar = CoroutineExceptionHandler.f2695d;
        }

        private b() {
        }
    }

    void a(CancellationException cancellationException);
}
