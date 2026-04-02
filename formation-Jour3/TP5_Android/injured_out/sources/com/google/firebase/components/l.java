package com.google.firebase.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class l extends a {
    private static final b.c.c.l.a<Set<Object>> e = k.a();

    /* renamed from: a  reason: collision with root package name */
    private final Map<d<?>, s<?>> f1980a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, s<?>> f1981b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, s<Set<?>>> f1982c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final r f1983d;

    public l(Executor executor, Iterable<h> iterable, d<?>... dVarArr) {
        this.f1983d = new r(executor);
        ArrayList<d<?>> arrayList = new ArrayList();
        arrayList.add(d.n(this.f1983d, r.class, b.c.c.j.d.class, b.c.c.j.c.class));
        for (h hVar : iterable) {
            arrayList.addAll(hVar.getComponents());
        }
        for (d<?> dVar : dVarArr) {
            if (dVar != null) {
                arrayList.add(dVar);
            }
        }
        m.a(arrayList);
        for (d<?> dVar2 : arrayList) {
            this.f1980a.put(dVar2, new s<>(i.a(this, dVar2)));
        }
        h();
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Set g(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((s) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private void h() {
        for (Map.Entry<d<?>, s<?>> entry : this.f1980a.entrySet()) {
            d<?> key = entry.getKey();
            if (key.k()) {
                s<?> value = entry.getValue();
                for (Class<? super Object> cls : key.e()) {
                    this.f1981b.put(cls, value);
                }
            }
        }
        j();
    }

    private void i() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<d<?>, s<?>> entry : this.f1980a.entrySet()) {
            d<?> key = entry.getKey();
            if (!key.k()) {
                s<?> value = entry.getValue();
                for (Class<? super Object> cls : key.e()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            this.f1982c.put((Class) entry2.getKey(), new s<>(j.a((Set) entry2.getValue())));
        }
    }

    private void j() {
        for (d<?> dVar : this.f1980a.keySet()) {
            for (n nVar : dVar.c()) {
                if (nVar.c() && !this.f1981b.containsKey(nVar.a())) {
                    throw new t(String.format("Unsatisfied dependency for component %s: %s", dVar, nVar.a()));
                }
            }
        }
    }

    @Override // com.google.firebase.components.e
    public <T> b.c.c.l.a<T> c(Class<T> cls) {
        u.c(cls, "Null interface requested.");
        return this.f1981b.get(cls);
    }

    @Override // com.google.firebase.components.e
    public <T> b.c.c.l.a<Set<T>> d(Class<T> cls) {
        s<Set<?>> sVar = this.f1982c.get(cls);
        return sVar != null ? sVar : (b.c.c.l.a<Set<T>>) e;
    }

    public void e(boolean z) {
        for (Map.Entry<d<?>, s<?>> entry : this.f1980a.entrySet()) {
            d<?> key = entry.getKey();
            s<?> value = entry.getValue();
            if (key.i() || (key.j() && z)) {
                value.get();
            }
        }
        this.f1983d.a();
    }
}
