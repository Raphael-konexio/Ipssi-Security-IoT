package a.b.a.b;

import a.b.a.b.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {
    private HashMap<K, b.c<K, V>> j = new HashMap<>();

    public boolean contains(K k) {
        return this.j.containsKey(k);
    }

    @Override // a.b.a.b.b
    protected b.c<K, V> f(K k) {
        return this.j.get(k);
    }

    @Override // a.b.a.b.b
    public V m(K k, V v) {
        b.c<K, V> f = f(k);
        if (f != null) {
            return f.g;
        }
        this.j.put(k, l(k, v));
        return null;
    }

    @Override // a.b.a.b.b
    public V s(K k) {
        V v = (V) super.s(k);
        this.j.remove(k);
        return v;
    }

    public Map.Entry<K, V> u(K k) {
        if (contains(k)) {
            return this.j.get(k).i;
        }
        return null;
    }
}
