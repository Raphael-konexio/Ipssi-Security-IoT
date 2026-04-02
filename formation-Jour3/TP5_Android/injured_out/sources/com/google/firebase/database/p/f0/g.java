package com.google.firebase.database.p.f0;

import com.google.firebase.database.p.g0.d;
import com.google.firebase.database.p.l;
/* loaded from: classes.dex */
public class g {

    /* renamed from: b  reason: collision with root package name */
    private static final com.google.firebase.database.p.g0.i<Boolean> f2154b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static final com.google.firebase.database.p.g0.i<Boolean> f2155c = new b();

    /* renamed from: d  reason: collision with root package name */
    private static final com.google.firebase.database.p.g0.d<Boolean> f2156d = new com.google.firebase.database.p.g0.d<>(Boolean.TRUE);
    private static final com.google.firebase.database.p.g0.d<Boolean> e = new com.google.firebase.database.p.g0.d<>(Boolean.FALSE);

    /* renamed from: a  reason: collision with root package name */
    private final com.google.firebase.database.p.g0.d<Boolean> f2157a;

    /* loaded from: classes.dex */
    class a implements com.google.firebase.database.p.g0.i<Boolean> {
        a() {
        }

        @Override // com.google.firebase.database.p.g0.i
        /* renamed from: b */
        public boolean a(Boolean bool) {
            return !bool.booleanValue();
        }
    }

    /* loaded from: classes.dex */
    class b implements com.google.firebase.database.p.g0.i<Boolean> {
        b() {
        }

        @Override // com.google.firebase.database.p.g0.i
        /* renamed from: b */
        public boolean a(Boolean bool) {
            return bool.booleanValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    class c<T> implements d.c<Boolean, T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d.c f2158a;

        c(g gVar, d.c cVar) {
            this.f2158a = cVar;
        }

        @Override // com.google.firebase.database.p.g0.d.c
        /* renamed from: b */
        public T a(l lVar, Boolean bool, T t) {
            return !bool.booleanValue() ? (T) this.f2158a.a(lVar, null, t) : t;
        }
    }

    public g() {
        this.f2157a = com.google.firebase.database.p.g0.d.e();
    }

    private g(com.google.firebase.database.p.g0.d<Boolean> dVar) {
        this.f2157a = dVar;
    }

    public g a(com.google.firebase.database.r.b bVar) {
        com.google.firebase.database.p.g0.d<Boolean> u = this.f2157a.u(bVar);
        if (u == null) {
            u = new com.google.firebase.database.p.g0.d<>(this.f2157a.getValue());
        } else if (u.getValue() == null && this.f2157a.getValue() != null) {
            u = u.B(l.w(), this.f2157a.getValue());
        }
        return new g(u);
    }

    public <T> T b(T t, d.c<Void, T> cVar) {
        return (T) this.f2157a.l(t, new c(this, cVar));
    }

    public g c(l lVar) {
        return this.f2157a.A(lVar, f2154b) != null ? this : new g(this.f2157a.C(lVar, e));
    }

    public g d(l lVar) {
        if (this.f2157a.A(lVar, f2154b) == null) {
            return this.f2157a.A(lVar, f2155c) != null ? this : new g(this.f2157a.C(lVar, f2156d));
        }
        throw new IllegalArgumentException("Can't prune path that was kept previously!");
    }

    public boolean e() {
        return this.f2157a.d(f2155c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && this.f2157a.equals(((g) obj).f2157a);
    }

    public boolean f(l lVar) {
        Boolean x = this.f2157a.x(lVar);
        return (x == null || x.booleanValue()) ? false : true;
    }

    public boolean g(l lVar) {
        Boolean x = this.f2157a.x(lVar);
        return x != null && x.booleanValue();
    }

    public int hashCode() {
        return this.f2157a.hashCode();
    }

    public String toString() {
        return "{PruneForest:" + this.f2157a.toString() + "}";
    }
}
