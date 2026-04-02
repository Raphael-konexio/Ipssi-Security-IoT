package b.c.a.a.f;
/* loaded from: classes.dex */
final class r implements Runnable {
    private final /* synthetic */ g f;
    private final /* synthetic */ q g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, g gVar) {
        this.g = qVar;
        this.f = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        d dVar;
        d dVar2;
        obj = this.g.f1283b;
        synchronized (obj) {
            dVar = this.g.f1284c;
            if (dVar != null) {
                dVar2 = this.g.f1284c;
                dVar2.d(this.f.i());
            }
        }
    }
}
