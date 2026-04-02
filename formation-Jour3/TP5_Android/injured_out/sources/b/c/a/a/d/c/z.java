package b.c.a.a.d.c;
/* loaded from: classes.dex */
final class z<E> extends s<E> {
    private final w<E> h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w<E> wVar, int i) {
        super(wVar.size(), i);
        this.h = wVar;
    }

    @Override // b.c.a.a.d.c.s
    protected final E a(int i) {
        return this.h.get(i);
    }
}
