package com.google.firebase.database.r;

import com.google.firebase.database.n.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class o {
    public static n a(Object obj) {
        return b(obj, r.a());
    }

    public static n b(Object obj, n nVar) {
        HashMap hashMap;
        try {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.containsKey(".priority")) {
                    nVar = r.d(map.get(".priority"));
                }
                if (map.containsKey(".value")) {
                    obj = map.get(".value");
                }
            }
            if (obj == null) {
                return g.s();
            }
            if (obj instanceof String) {
                return new t((String) obj, nVar);
            }
            if (obj instanceof Long) {
                return new l((Long) obj, nVar);
            }
            if (obj instanceof Integer) {
                return new l(Long.valueOf(((Integer) obj).intValue()), nVar);
            }
            if (obj instanceof Double) {
                return new f((Double) obj, nVar);
            }
            if (obj instanceof Boolean) {
                return new a((Boolean) obj, nVar);
            }
            if (!(obj instanceof Map) && !(obj instanceof List)) {
                throw new com.google.firebase.database.c("Failed to parse node with class " + obj.getClass().toString());
            }
            if (obj instanceof Map) {
                Map map2 = (Map) obj;
                if (map2.containsKey(".sv")) {
                    return new e(map2, nVar);
                }
                hashMap = new HashMap(map2.size());
                for (String str : map2.keySet()) {
                    if (!str.startsWith(".")) {
                        n a2 = a(map2.get(str));
                        if (!a2.isEmpty()) {
                            hashMap.put(b.g(str), a2);
                        }
                    }
                }
            } else {
                List list = (List) obj;
                hashMap = new HashMap(list.size());
                for (int i = 0; i < list.size(); i++) {
                    String str2 = "" + i;
                    n a3 = a(list.get(i));
                    if (!a3.isEmpty()) {
                        hashMap.put(b.g(str2), a3);
                    }
                }
            }
            return hashMap.isEmpty() ? g.s() : new c(c.a.c(hashMap, c.i), nVar);
        } catch (ClassCastException e) {
            throw new com.google.firebase.database.c("Failed to parse node", e);
        }
    }

    public static int c(b bVar, n nVar, b bVar2, n nVar2) {
        int compareTo = nVar.compareTo(nVar2);
        return compareTo != 0 ? compareTo : bVar.compareTo(bVar2);
    }
}
