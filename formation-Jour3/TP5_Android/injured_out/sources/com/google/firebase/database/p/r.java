package com.google.firebase.database.p;

import com.google.firebase.database.r.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class r {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends c.AbstractC0104c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.r.n f2280a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f2281b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ s f2282c;

        a(com.google.firebase.database.r.n nVar, Map map, s sVar) {
            this.f2280a = nVar;
            this.f2281b = map;
            this.f2282c = sVar;
        }

        @Override // com.google.firebase.database.r.c.AbstractC0104c
        public void b(com.google.firebase.database.r.b bVar, com.google.firebase.database.r.n nVar) {
            com.google.firebase.database.r.n f = r.f(nVar, this.f2280a.b(bVar), this.f2281b);
            if (f != nVar) {
                this.f2282c.c(new l(bVar.e()), f);
            }
        }
    }

    private static boolean a(Number number) {
        return ((number instanceof Double) || (number instanceof Float)) ? false : true;
    }

    public static Map<String, Object> b(com.google.firebase.database.p.g0.a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(aVar.a()));
        return hashMap;
    }

    static Object c(Map<String, Object> map, com.google.firebase.database.r.n nVar, Map<String, Object> map2) {
        if (map.containsKey("increment")) {
            Object obj = map.get("increment");
            if (obj instanceof Number) {
                Number number = (Number) obj;
                if (nVar.k() && (nVar.getValue() instanceof Number)) {
                    Number number2 = (Number) nVar.getValue();
                    if (a(number) && a(number2)) {
                        long longValue = number.longValue();
                        long longValue2 = number2.longValue();
                        long j = longValue + longValue2;
                        if (((longValue ^ j) & (longValue2 ^ j)) >= 0) {
                            return Long.valueOf(j);
                        }
                    }
                    return Double.valueOf(number.doubleValue() + number2.doubleValue());
                }
                return number;
            }
            return null;
        }
        return null;
    }

    public static Object d(Object obj, com.google.firebase.database.r.n nVar, Map<String, Object> map) {
        if (obj instanceof Map) {
            Map map2 = (Map) obj;
            if (map2.containsKey(".sv")) {
                Object obj2 = map2.get(".sv");
                Object obj3 = null;
                if (obj2 instanceof String) {
                    obj3 = g((String) obj2, nVar, map);
                } else if (obj2 instanceof Map) {
                    obj3 = c((Map) obj2, nVar, map);
                }
                return obj3 == null ? obj : obj3;
            }
            return obj;
        }
        return obj;
    }

    public static b e(b bVar, com.google.firebase.database.r.n nVar, Map<String, Object> map) {
        b s = b.s();
        Iterator<Map.Entry<l, com.google.firebase.database.r.n>> it = bVar.iterator();
        while (it.hasNext()) {
            Map.Entry<l, com.google.firebase.database.r.n> next = it.next();
            s = s.d(next.getKey(), f(next.getValue(), nVar.h(next.getKey()), map));
        }
        return s;
    }

    public static com.google.firebase.database.r.n f(com.google.firebase.database.r.n nVar, com.google.firebase.database.r.n nVar2, Map<String, Object> map) {
        com.google.firebase.database.r.n d2 = com.google.firebase.database.r.r.d(d(nVar.c().getValue(), nVar2.c(), map));
        if (nVar.k()) {
            Object d3 = d(nVar.getValue(), nVar2, map);
            return (d3.equals(nVar.getValue()) && d2.equals(nVar.c())) ? nVar : com.google.firebase.database.r.o.b(d3, d2);
        } else if (nVar.isEmpty()) {
            return nVar;
        } else {
            com.google.firebase.database.r.c cVar = (com.google.firebase.database.r.c) nVar;
            s sVar = new s(cVar);
            cVar.f(new a(nVar2, map, sVar));
            return !sVar.b().c().equals(d2) ? sVar.b().j(d2) : sVar.b();
        }
    }

    static Object g(String str, com.google.firebase.database.r.n nVar, Map<String, Object> map) {
        if ("timestamp".equals(str) && map.containsKey(str)) {
            return map.get(str);
        }
        return null;
    }
}
