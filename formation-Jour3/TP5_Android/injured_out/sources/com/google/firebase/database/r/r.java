package com.google.firebase.database.r;
/* loaded from: classes.dex */
public class r {
    public static n a() {
        return g.s();
    }

    public static boolean b(n nVar) {
        return nVar.c().isEmpty() && (nVar.isEmpty() || (nVar instanceof f) || (nVar instanceof t) || (nVar instanceof e));
    }

    public static n c(com.google.firebase.database.p.l lVar, Object obj) {
        String str;
        n a2 = o.a(obj);
        if (a2 instanceof l) {
            a2 = new f(Double.valueOf(((Long) a2.getValue()).longValue()), a());
        }
        if (b(a2)) {
            return a2;
        }
        StringBuilder sb = new StringBuilder();
        if (lVar != null) {
            str = "Path '" + lVar + "'";
        } else {
            str = "Node";
        }
        sb.append(str);
        sb.append(" contains invalid priority: Must be a string, double, ServerValue, or null");
        throw new com.google.firebase.database.c(sb.toString());
    }

    public static n d(Object obj) {
        return c(null, obj);
    }
}
