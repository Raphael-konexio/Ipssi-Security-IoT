package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
class m {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final d<?> f1984a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<b> f1985b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Set<b> f1986c = new HashSet();

        b(d<?> dVar) {
            this.f1984a = dVar;
        }

        void a(b bVar) {
            this.f1985b.add(bVar);
        }

        void b(b bVar) {
            this.f1986c.add(bVar);
        }

        d<?> c() {
            return this.f1984a;
        }

        Set<b> d() {
            return this.f1985b;
        }

        boolean e() {
            return this.f1985b.isEmpty();
        }

        boolean f() {
            return this.f1986c.isEmpty();
        }

        void g(b bVar) {
            this.f1986c.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private final Class<?> f1987a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f1988b;

        private c(Class<?> cls, boolean z) {
            this.f1987a = cls;
            this.f1988b = z;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return cVar.f1987a.equals(this.f1987a) && cVar.f1988b == this.f1988b;
            }
            return false;
        }

        public int hashCode() {
            return ((this.f1987a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f1988b).hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(List<d<?>> list) {
        Set<b> c2 = c(list);
        Set<b> b2 = b(c2);
        int i = 0;
        while (!b2.isEmpty()) {
            b next = b2.iterator().next();
            b2.remove(next);
            i++;
            for (b bVar : next.d()) {
                bVar.g(next);
                if (bVar.f()) {
                    b2.add(bVar);
                }
            }
        }
        if (i == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : c2) {
            if (!bVar2.f() && !bVar2.e()) {
                arrayList.add(bVar2.c());
            }
        }
        throw new o(arrayList);
    }

    private static Set<b> b(Set<b> set) {
        HashSet hashSet = new HashSet();
        for (b bVar : set) {
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    private static Set<b> c(List<d<?>> list) {
        Set<b> set;
        HashMap hashMap = new HashMap(list.size());
        for (d<?> dVar : list) {
            b bVar = new b(dVar);
            for (Class<? super Object> cls : dVar.e()) {
                c cVar = new c(cls, !dVar.k());
                if (!hashMap.containsKey(cVar)) {
                    hashMap.put(cVar, new HashSet());
                }
                Set set2 = (Set) hashMap.get(cVar);
                if (!set2.isEmpty() && !cVar.f1988b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(bVar);
            }
        }
        for (Set<b> set3 : hashMap.values()) {
            for (b bVar2 : set3) {
                for (n nVar : bVar2.c().c()) {
                    if (nVar.b() && (set = (Set) hashMap.get(new c(nVar.a(), nVar.d()))) != null) {
                        for (b bVar3 : set) {
                            bVar2.a(bVar3);
                            bVar3.b(bVar2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set set4 : hashMap.values()) {
            hashSet.addAll(set4);
        }
        return hashSet;
    }
}
