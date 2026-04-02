package b.c.a.a.f;
/* loaded from: classes.dex */
final class l implements Runnable {
    private final /* synthetic */ g f;
    private final /* synthetic */ k g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, g gVar) {
        this.g = kVar;
        this.f = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar;
        x xVar2;
        x xVar3;
        a aVar;
        try {
            aVar = this.g.f1274b;
            g gVar = (g) aVar.a(this.f);
            if (gVar == null) {
                this.g.d(new NullPointerException("Continuation returned null"));
                return;
            }
            gVar.g(i.f1271b, this.g);
            gVar.e(i.f1271b, this.g);
            gVar.a(i.f1271b, this.g);
        } catch (f e) {
            if (e.getCause() instanceof Exception) {
                xVar3 = this.g.f1275c;
                xVar3.o((Exception) e.getCause());
                return;
            }
            xVar2 = this.g.f1275c;
            xVar2.o(e);
        } catch (Exception e2) {
            xVar = this.g.f1275c;
            xVar.o(e2);
        }
    }
}
