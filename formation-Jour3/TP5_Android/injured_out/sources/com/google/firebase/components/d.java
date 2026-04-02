package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Class<? super T>> f1965a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<n> f1966b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1967c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1968d;
    private final g<T> e;
    private final Set<Class<?>> f;

    /* loaded from: classes.dex */
    public static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Class<? super T>> f1969a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<n> f1970b;

        /* renamed from: c  reason: collision with root package name */
        private int f1971c;

        /* renamed from: d  reason: collision with root package name */
        private int f1972d;
        private g<T> e;
        private Set<Class<?>> f;

        @SafeVarargs
        private b(Class<T> cls, Class<? super T>... clsArr) {
            this.f1969a = new HashSet();
            this.f1970b = new HashSet();
            this.f1971c = 0;
            this.f1972d = 0;
            this.f = new HashSet();
            u.c(cls, "Null interface");
            this.f1969a.add(cls);
            for (Class<? super T> cls2 : clsArr) {
                u.c(cls2, "Null interface");
            }
            Collections.addAll(this.f1969a, clsArr);
        }

        /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
            */
        static /* synthetic */ com.google.firebase.components.d.b a(com.google.firebase.components.d.b r0) {
            /*
                r0.f()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.d.b.a(com.google.firebase.components.d$b):com.google.firebase.components.d$b");
        }

        private b<T> f() {
            this.f1972d = 1;
            return this;
        }

        private b<T> g(int i) {
            u.d(this.f1971c == 0, "Instantiation type has already been set.");
            this.f1971c = i;
            return this;
        }

        private void h(Class<?> cls) {
            u.a(!this.f1969a.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b<T> b(n nVar) {
            u.c(nVar, "Null dependency");
            h(nVar.a());
            this.f1970b.add(nVar);
            return this;
        }

        public d<T> c() {
            u.d(this.e != null, "Missing required property: factory.");
            return new d<>(new HashSet(this.f1969a), new HashSet(this.f1970b), this.f1971c, this.f1972d, this.e, this.f);
        }

        public b<T> d() {
            g(2);
            return this;
        }

        public b<T> e(g<T> gVar) {
            u.c(gVar, "Null factory");
            this.e = gVar;
            return this;
        }
    }

    private d(Set<Class<? super T>> set, Set<n> set2, int i, int i2, g<T> gVar, Set<Class<?>> set3) {
        this.f1965a = Collections.unmodifiableSet(set);
        this.f1966b = Collections.unmodifiableSet(set2);
        this.f1967c = i;
        this.f1968d = i2;
        this.e = gVar;
        this.f = Collections.unmodifiableSet(set3);
    }

    public static <T> b<T> a(Class<T> cls) {
        return new b<>(cls, new Class[0]);
    }

    @SafeVarargs
    public static <T> b<T> b(Class<T> cls, Class<? super T>... clsArr) {
        return new b<>(cls, clsArr);
    }

    public static <T> d<T> g(T t, Class<T> cls) {
        b h = h(cls);
        h.e(c.b(t));
        return h.c();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.google.firebase.components.d.b.a(com.google.firebase.components.d$b):com.google.firebase.components.d$b
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
        	... 1 more
        */
    public static <T> com.google.firebase.components.d.b<T> h(java.lang.Class<T> r0) {
        /*
            com.google.firebase.components.d$b r0 = a(r0)
            com.google.firebase.components.d.b.a(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.d.h(java.lang.Class):com.google.firebase.components.d$b");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object l(Object obj, e eVar) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object m(Object obj, e eVar) {
        return obj;
    }

    @SafeVarargs
    public static <T> d<T> n(T t, Class<T> cls, Class<? super T>... clsArr) {
        b b2 = b(cls, clsArr);
        b2.e(com.google.firebase.components.b.b(t));
        return b2.c();
    }

    public Set<n> c() {
        return this.f1966b;
    }

    public g<T> d() {
        return this.e;
    }

    public Set<Class<? super T>> e() {
        return this.f1965a;
    }

    public Set<Class<?>> f() {
        return this.f;
    }

    public boolean i() {
        return this.f1967c == 1;
    }

    public boolean j() {
        return this.f1967c == 2;
    }

    public boolean k() {
        return this.f1968d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f1965a.toArray()) + ">{" + this.f1967c + ", type=" + this.f1968d + ", deps=" + Arrays.toString(this.f1966b.toArray()) + "}";
    }
}
