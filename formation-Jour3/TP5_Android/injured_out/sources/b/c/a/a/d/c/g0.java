package b.c.a.a.d.c;
/* loaded from: classes.dex */
final class g0<K> extends d0<K> {
    private final transient b0<K, ?> h;
    private final transient w<K> i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g0(b0<K, ?> b0Var, w<K> wVar) {
        this.h = b0Var;
        this.i = wVar;
    }

    @Override // b.c.a.a.d.c.x, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.h.get(obj) != null;
    }

    @Override // b.c.a.a.d.c.x
    final int d(Object[] objArr, int i) {
        return m().d(objArr, i);
    }

    @Override // b.c.a.a.d.c.d0, b.c.a.a.d.c.x, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: e */
    public final l0<K> iterator() {
        return (l0) m().iterator();
    }

    @Override // b.c.a.a.d.c.d0
    public final w<K> m() {
        return this.i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.h.size();
    }
}
