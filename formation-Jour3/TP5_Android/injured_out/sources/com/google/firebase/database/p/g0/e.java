package com.google.firebase.database.p.g0;

import com.google.firebase.database.r.n;
import com.google.firebase.database.r.t;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    private static long a(com.google.firebase.database.r.k<?> kVar) {
        long j = 8;
        if (!(kVar instanceof com.google.firebase.database.r.f) && !(kVar instanceof com.google.firebase.database.r.l)) {
            if (kVar instanceof com.google.firebase.database.r.a) {
                j = 4;
            } else if (!(kVar instanceof t)) {
                throw new IllegalArgumentException("Unknown leaf node type: " + kVar.getClass());
            } else {
                j = ((String) kVar.getValue()).length() + 2;
            }
        }
        return kVar.c().isEmpty() ? j : j + 24 + a((com.google.firebase.database.r.k) kVar.c());
    }

    public static long b(n nVar) {
        if (nVar.isEmpty()) {
            return 4L;
        }
        if (nVar.k()) {
            return a((com.google.firebase.database.r.k) nVar);
        }
        long j = 1;
        for (com.google.firebase.database.r.m mVar : nVar) {
            j = j + mVar.c().e().length() + 4 + b(mVar.d());
        }
        return !nVar.c().isEmpty() ? j + 12 + a((com.google.firebase.database.r.k) nVar.c()) : j;
    }

    public static int c(n nVar) {
        int i = 0;
        if (nVar.isEmpty()) {
            return 0;
        }
        if (nVar.k()) {
            return 1;
        }
        Iterator<com.google.firebase.database.r.m> it = nVar.iterator();
        while (it.hasNext()) {
            i += c(it.next().d());
        }
        return i;
    }
}
