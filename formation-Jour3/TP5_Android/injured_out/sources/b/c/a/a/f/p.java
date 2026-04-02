package b.c.a.a.f;
/* loaded from: classes.dex */
final class p implements Runnable {
    private final /* synthetic */ g f;
    private final /* synthetic */ o g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, g gVar) {
        this.g = oVar;
        this.f = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        c cVar;
        c cVar2;
        obj = this.g.f1280b;
        synchronized (obj) {
            cVar = this.g.f1281c;
            if (cVar != null) {
                cVar2 = this.g.f1281c;
                cVar2.a(this.f);
            }
        }
    }
}
