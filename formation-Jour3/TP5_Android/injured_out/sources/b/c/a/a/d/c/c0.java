package b.c.a.a.d.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c0<E> extends w<E> {
    static final w<Object> j = new c0(new Object[0], 0);
    private final transient Object[] h;
    private final transient int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(Object[] objArr, int i) {
        this.h = objArr;
        this.i = i;
    }

    @Override // b.c.a.a.d.c.w, b.c.a.a.d.c.x
    final int d(Object[] objArr, int i) {
        System.arraycopy(this.h, 0, objArr, i, this.i);
        return i + this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b.c.a.a.d.c.x
    public final Object[] f() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b.c.a.a.d.c.x
    public final int g() {
        return 0;
    }

    @Override // java.util.List
    public final E get(int i) {
        m.a(i, this.i);
        return (E) this.h[i];
    }

    @Override // b.c.a.a.d.c.x
    final int i() {
        return this.i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.i;
    }
}
