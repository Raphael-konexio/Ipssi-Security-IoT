package b.c.a.a.f;
/* loaded from: classes.dex */
final class n implements Runnable {
    private final /* synthetic */ m f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.f = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        b bVar;
        b bVar2;
        obj = this.f.f1277b;
        synchronized (obj) {
            bVar = this.f.f1278c;
            if (bVar != null) {
                bVar2 = this.f.f1278c;
                bVar2.b();
            }
        }
    }
}
