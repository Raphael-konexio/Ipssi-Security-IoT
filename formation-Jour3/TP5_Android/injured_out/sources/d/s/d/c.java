package d.s.d;

import d.o.y;
import d.o.z;
import d.s.c.p;
import d.s.c.q;
import d.s.c.r;
import d.s.c.s;
import d.s.c.t;
import d.s.c.u;
import d.s.c.v;
import d.s.c.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class c implements d.u.b<Object>, b {

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Class<? extends Object<?>>, Integer> f2407b;

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, String> f2408c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, String> f2409d;
    private static final HashMap<String, String> e;

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f2410a;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List d2;
        int g;
        Map<Class<? extends Object<?>>, Integer> g2;
        int a2;
        String G;
        String G2;
        int i = 0;
        d2 = d.o.i.d(d.s.c.a.class, d.s.c.l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, d.s.c.b.class, d.s.c.c.class, d.s.c.d.class, d.s.c.e.class, d.s.c.f.class, d.s.c.g.class, d.s.c.h.class, d.s.c.i.class, d.s.c.j.class, d.s.c.k.class, d.s.c.m.class, d.s.c.n.class, d.s.c.o.class);
        g = d.o.j.g(d2, 10);
        ArrayList arrayList = new ArrayList(g);
        for (Object obj : d2) {
            int i2 = i + 1;
            if (i < 0) {
                d.o.g.f();
                throw null;
            } else {
                arrayList.add(d.k.a((Class) obj, Integer.valueOf(i)));
                i = i2;
            }
        }
        g2 = z.g(arrayList);
        f2407b = g2;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f2408c = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f2409d = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(f2408c);
        hashMap3.putAll(f2409d);
        Collection<String> values = f2408c.values();
        g.d(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            g.d(str, "kotlinName");
            G2 = d.w.p.G(str, '.', null, 2, null);
            sb.append(G2);
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            d.i a3 = d.k.a(sb2, str + ".Companion");
            hashMap3.put(a3.c(), a3.d());
        }
        for (Map.Entry<Class<? extends Object<?>>, Integer> entry : f2407b.entrySet()) {
            int intValue = entry.getValue().intValue();
            String name = entry.getKey().getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        e = hashMap3;
        a2 = y.a(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(a2);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            G = d.w.p.G((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key, G);
        }
    }

    public c(Class<?> cls) {
        g.e(cls, "jClass");
        this.f2410a = cls;
    }

    @Override // d.s.d.b
    public Class<?> a() {
        return this.f2410a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && g.a(d.s.a.a(this), d.s.a.a((d.u.b) obj));
    }

    public int hashCode() {
        return d.s.a.a(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
