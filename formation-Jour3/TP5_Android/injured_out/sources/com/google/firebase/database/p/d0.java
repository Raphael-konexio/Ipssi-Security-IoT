package com.google.firebase.database.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class d0 implements j {

    /* renamed from: b  reason: collision with root package name */
    private static d0 f2136b = new d0();

    /* renamed from: a  reason: collision with root package name */
    final HashMap<i, List<i>> f2137a = new HashMap<>();

    private d0() {
    }

    public static d0 b() {
        return f2136b;
    }

    private void d(i iVar) {
        i a2;
        List<i> list;
        synchronized (this.f2137a) {
            List<i> list2 = this.f2137a.get(iVar);
            int i = 0;
            if (list2 != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list2.size()) {
                        break;
                    } else if (list2.get(i2) == iVar) {
                        list2.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                if (list2.isEmpty()) {
                    this.f2137a.remove(iVar);
                }
            }
            if (!iVar.e().f() && (list = this.f2137a.get((a2 = iVar.a(com.google.firebase.database.p.h0.i.a(iVar.e().e()))))) != null) {
                while (true) {
                    if (i >= list.size()) {
                        break;
                    } else if (list.get(i) == iVar) {
                        list.remove(i);
                        break;
                    } else {
                        i++;
                    }
                }
                if (list.isEmpty()) {
                    this.f2137a.remove(a2);
                }
            }
        }
    }

    @Override // com.google.firebase.database.p.j
    public void a(i iVar) {
        d(iVar);
    }

    public void c(i iVar) {
        synchronized (this.f2137a) {
            List<i> list = this.f2137a.get(iVar);
            if (list == null) {
                list = new ArrayList<>();
                this.f2137a.put(iVar, list);
            }
            list.add(iVar);
            if (!iVar.e().f()) {
                i a2 = iVar.a(com.google.firebase.database.p.h0.i.a(iVar.e().e()));
                List<i> list2 = this.f2137a.get(a2);
                if (list2 == null) {
                    list2 = new ArrayList<>();
                    this.f2137a.put(a2, list2);
                }
                list2.add(iVar);
            }
            iVar.i(true);
            iVar.j(this);
        }
    }

    public void e(i iVar) {
        synchronized (this.f2137a) {
            List<i> list = this.f2137a.get(iVar);
            if (list != null && !list.isEmpty()) {
                if (iVar.e().f()) {
                    HashSet hashSet = new HashSet();
                    for (int size = list.size() - 1; size >= 0; size--) {
                        i iVar2 = list.get(size);
                        if (!hashSet.contains(iVar2.e())) {
                            hashSet.add(iVar2.e());
                            iVar2.k();
                        }
                    }
                } else {
                    list.get(0).k();
                }
            }
        }
    }
}
