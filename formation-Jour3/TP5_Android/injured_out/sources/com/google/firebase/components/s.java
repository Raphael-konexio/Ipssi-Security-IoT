package com.google.firebase.components;
/* loaded from: classes.dex */
public class s<T> implements b.c.c.l.a<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f1994c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile Object f1995a = f1994c;

    /* renamed from: b  reason: collision with root package name */
    private volatile b.c.c.l.a<T> f1996b;

    public s(b.c.c.l.a<T> aVar) {
        this.f1996b = aVar;
    }

    @Override // b.c.c.l.a
    public T get() {
        T t = (T) this.f1995a;
        if (t == f1994c) {
            synchronized (this) {
                t = this.f1995a;
                if (t == f1994c) {
                    t = this.f1996b.get();
                    this.f1995a = t;
                    this.f1996b = null;
                }
            }
        }
        return t;
    }
}
