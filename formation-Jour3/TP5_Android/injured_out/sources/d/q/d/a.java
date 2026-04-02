package d.q.d;

import d.s.d.g;
/* loaded from: classes.dex */
public class a extends d.q.a {
    @Override // d.q.a
    public void a(Throwable th, Throwable th2) {
        g.e(th, "cause");
        g.e(th2, "exception");
        th.addSuppressed(th2);
    }
}
