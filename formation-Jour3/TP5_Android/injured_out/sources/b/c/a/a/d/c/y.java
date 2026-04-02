package b.c.a.a.d.c;
/* JADX INFO: Add missing generic type declarations: [E] */
/* loaded from: classes.dex */
final class y<E> extends w<E> {
    private final transient int h;
    private final transient int i;
    private final /* synthetic */ w j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar, int i, int i2) {
        this.j = wVar;
        this.h = i;
        this.i = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b.c.a.a.d.c.x
    public final Object[] f() {
        return this.j.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b.c.a.a.d.c.x
    public final int g() {
        return this.j.g() + this.h;
    }

    @Override // java.util.List
    public final E get(int i) {
        m.a(i, this.i);
        return this.j.get(i + this.h);
    }

    @Override // b.c.a.a.d.c.x
    final int i() {
        return this.j.g() + this.h + this.i;
    }

    @Override // b.c.a.a.d.c.w, java.util.List
    /* renamed from: m */
    public final w<E> subList(int i, int i2) {
        m.d(i, i2, this.i);
        w wVar = this.j;
        int i3 = this.h;
        return (w) wVar.subList(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.i;
    }
}
