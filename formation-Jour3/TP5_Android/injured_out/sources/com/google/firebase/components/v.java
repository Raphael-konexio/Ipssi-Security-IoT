package com.google.firebase.components;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends com.google.firebase.components.a {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Class<?>> f1997a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Class<?>> f1998b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Class<?>> f1999c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<Class<?>> f2000d;
    private final Set<Class<?>> e;
    private final e f;

    /* loaded from: classes.dex */
    private static class a implements b.c.c.j.c {
        public a(Set<Class<?>> set, b.c.c.j.c cVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(d<?> dVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (n nVar : dVar.c()) {
            if (nVar.b()) {
                boolean d2 = nVar.d();
                Class<?> a2 = nVar.a();
                if (d2) {
                    hashSet3.add(a2);
                } else {
                    hashSet.add(a2);
                }
            } else {
                boolean d3 = nVar.d();
                Class<?> a3 = nVar.a();
                if (d3) {
                    hashSet4.add(a3);
                } else {
                    hashSet2.add(a3);
                }
            }
        }
        if (!dVar.f().isEmpty()) {
            hashSet.add(b.c.c.j.c.class);
        }
        this.f1997a = Collections.unmodifiableSet(hashSet);
        this.f1998b = Collections.unmodifiableSet(hashSet2);
        this.f1999c = Collections.unmodifiableSet(hashSet3);
        this.f2000d = Collections.unmodifiableSet(hashSet4);
        this.e = dVar.f();
        this.f = eVar;
    }

    @Override // com.google.firebase.components.a, com.google.firebase.components.e
    public <T> T a(Class<T> cls) {
        if (this.f1997a.contains(cls)) {
            T t = (T) this.f.a(cls);
            return !cls.equals(b.c.c.j.c.class) ? t : (T) new a(this.e, (b.c.c.j.c) t);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", cls));
    }

    @Override // com.google.firebase.components.a, com.google.firebase.components.e
    public <T> Set<T> b(Class<T> cls) {
        if (this.f1999c.contains(cls)) {
            return this.f.b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }

    @Override // com.google.firebase.components.e
    public <T> b.c.c.l.a<T> c(Class<T> cls) {
        if (this.f1998b.contains(cls)) {
            return this.f.c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // com.google.firebase.components.e
    public <T> b.c.c.l.a<Set<T>> d(Class<T> cls) {
        if (this.f2000d.contains(cls)) {
            return this.f.d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }
}
