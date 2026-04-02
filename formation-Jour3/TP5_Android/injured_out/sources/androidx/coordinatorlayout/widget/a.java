package androidx.coordinatorlayout.widget;

import a.g.j.f;
import a.g.j.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final f<ArrayList<T>> f692a = new g(10);

    /* renamed from: b  reason: collision with root package name */
    private final a.d.g<T, ArrayList<T>> f693b = new a.d.g<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f694c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<T> f695d = new HashSet<>();

    private void e(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (hashSet.contains(t)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t);
        ArrayList<T> arrayList2 = this.f693b.get(t);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                e(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }

    private ArrayList<T> f() {
        ArrayList<T> b2 = this.f692a.b();
        return b2 == null ? new ArrayList<>() : b2;
    }

    private void k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f692a.a(arrayList);
    }

    public void a(T t, T t2) {
        if (!this.f693b.containsKey(t) || !this.f693b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayList = this.f693b.get(t);
        if (arrayList == null) {
            arrayList = f();
            this.f693b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    public void b(T t) {
        if (this.f693b.containsKey(t)) {
            return;
        }
        this.f693b.put(t, null);
    }

    public void c() {
        int size = this.f693b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> m = this.f693b.m(i);
            if (m != null) {
                k(m);
            }
        }
        this.f693b.clear();
    }

    public boolean d(T t) {
        return this.f693b.containsKey(t);
    }

    public List g(T t) {
        return this.f693b.get(t);
    }

    public List<T> h(T t) {
        int size = this.f693b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList<T> m = this.f693b.m(i);
            if (m != null && m.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f693b.i(i));
            }
        }
        return arrayList;
    }

    public ArrayList<T> i() {
        this.f694c.clear();
        this.f695d.clear();
        int size = this.f693b.size();
        for (int i = 0; i < size; i++) {
            e(this.f693b.i(i), this.f694c, this.f695d);
        }
        return this.f694c;
    }

    public boolean j(T t) {
        int size = this.f693b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> m = this.f693b.m(i);
            if (m != null && m.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
