package b.c.a.a.d.c;

import java.util.Map;
/* loaded from: classes.dex */
final class e0<K, V> extends d0<Map.Entry<K, V>> {
    private final transient b0<K, V> h;
    private final transient Object[] i;
    private final transient int j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(b0<K, V> b0Var, Object[] objArr, int i, int i2) {
        this.h = b0Var;
        this.i = objArr;
        this.j = i2;
    }

    @Override // b.c.a.a.d.c.x, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.h.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // b.c.a.a.d.c.x
    final int d(Object[] objArr, int i) {
        return m().d(objArr, i);
    }

    @Override // b.c.a.a.d.c.d0, b.c.a.a.d.c.x, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: e */
    public final l0<Map.Entry<K, V>> iterator() {
        return (l0) m().iterator();
    }

    @Override // b.c.a.a.d.c.d0
    final w<Map.Entry<K, V>> l() {
        return new h0(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.j;
    }
}
