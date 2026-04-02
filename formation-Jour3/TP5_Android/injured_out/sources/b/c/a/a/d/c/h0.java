package b.c.a.a.d.c;

import java.util.AbstractMap;
import java.util.Map;
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes.dex */
final class h0<K, V> extends w<Map.Entry<K, V>> {
    private final /* synthetic */ e0 h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(e0 e0Var) {
        this.h = e0Var;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        int i2;
        Object[] objArr;
        Object[] objArr2;
        i2 = this.h.j;
        m.a(i, i2);
        objArr = this.h.i;
        int i3 = i * 2;
        e0 e0Var = this.h;
        Object obj = objArr[i3];
        objArr2 = e0Var.i;
        return new AbstractMap.SimpleImmutableEntry(obj, objArr2[i3 + 1]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.h.j;
        return i;
    }
}
