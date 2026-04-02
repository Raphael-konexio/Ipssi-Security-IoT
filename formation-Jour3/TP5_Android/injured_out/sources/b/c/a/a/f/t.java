package b.c.a.a.f;
/* loaded from: classes.dex */
final class t implements Runnable {
    private final /* synthetic */ g f;
    private final /* synthetic */ s g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, g gVar) {
        this.g = sVar;
        this.f = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        e eVar;
        e eVar2;
        obj = this.g.f1286b;
        synchronized (obj) {
            eVar = this.g.f1287c;
            if (eVar != null) {
                eVar2 = this.g.f1287c;
                eVar2.c(this.f.j());
            }
        }
    }
}
