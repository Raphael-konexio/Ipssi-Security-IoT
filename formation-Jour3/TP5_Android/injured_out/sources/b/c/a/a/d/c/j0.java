package b.c.a.a.d.c;
/* loaded from: classes.dex */
final class j0 extends w<Object> {
    private final transient Object[] h;
    private final transient int i;
    private final transient int j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(Object[] objArr, int i, int i2) {
        this.h = objArr;
        this.i = i;
        this.j = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        m.a(i, this.j);
        return this.h[(i * 2) + this.i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.j;
    }
}
