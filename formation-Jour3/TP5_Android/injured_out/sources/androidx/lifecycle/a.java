package androidx.lifecycle;

import androidx.lifecycle.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
class a {

    /* renamed from: c  reason: collision with root package name */
    static a f880c = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, C0045a> f881a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Boolean> f882b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.lifecycle.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0045a {

        /* renamed from: a  reason: collision with root package name */
        final Map<e.a, List<b>> f883a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<b, e.a> f884b;

        C0045a(Map<b, e.a> map) {
            this.f884b = map;
            for (Map.Entry<b, e.a> entry : map.entrySet()) {
                e.a value = entry.getValue();
                List<b> list = this.f883a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f883a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void b(List<b> list, j jVar, e.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(jVar, aVar, obj);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(j jVar, e.a aVar, Object obj) {
            b(this.f883a.get(aVar), jVar, aVar, obj);
            b(this.f883a.get(e.a.ON_ANY), jVar, aVar, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f885a;

        /* renamed from: b  reason: collision with root package name */
        final Method f886b;

        b(int i, Method method) {
            this.f885a = i;
            this.f886b = method;
            method.setAccessible(true);
        }

        void a(j jVar, e.a aVar, Object obj) {
            try {
                int i = this.f885a;
                if (i == 0) {
                    this.f886b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f886b.invoke(obj, jVar);
                } else if (i != 2) {
                } else {
                    this.f886b.invoke(obj, jVar, aVar);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f885a == bVar.f885a && this.f886b.getName().equals(bVar.f886b.getName());
        }

        public int hashCode() {
            return (this.f885a * 31) + this.f886b.getName().hashCode();
        }
    }

    a() {
    }

    private C0045a a(Class<?> cls, Method[] methodArr) {
        int i;
        C0045a c2;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c2 = c(superclass)) != null) {
            hashMap.putAll(c2.f884b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, e.a> entry : c(cls2).f884b.entrySet()) {
                e(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            q qVar = (q) method.getAnnotation(q.class);
            if (qVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (!parameterTypes[0].isAssignableFrom(j.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i = 1;
                }
                e.a value = qVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(e.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != e.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(hashMap, new b(i, method), value, cls);
                z = true;
            }
        }
        C0045a c0045a = new C0045a(hashMap);
        this.f881a.put(cls, c0045a);
        this.f882b.put(cls, Boolean.valueOf(z));
        return c0045a;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    private void e(Map<b, e.a> map, b bVar, e.a aVar, Class<?> cls) {
        e.a aVar2 = map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        Method method = bVar.f886b;
        throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0045a c(Class<?> cls) {
        C0045a c0045a = this.f881a.get(cls);
        return c0045a != null ? c0045a : a(cls, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Class<?> cls) {
        Boolean bool = this.f882b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b2 = b(cls);
        for (Method method : b2) {
            if (((q) method.getAnnotation(q.class)) != null) {
                a(cls, b2);
                return true;
            }
        }
        this.f882b.put(cls, Boolean.FALSE);
        return false;
    }
}
