package androidx.lifecycle;

import androidx.lifecycle.e;
/* loaded from: classes.dex */
public abstract class LiveData<T> {
    static final Object i = new Object();
    private boolean g;
    private boolean h;

    /* renamed from: a  reason: collision with root package name */
    final Object f864a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private a.b.a.b.b<p<? super T>, LiveData<T>.a> f865b = new a.b.a.b.b<>();

    /* renamed from: c  reason: collision with root package name */
    int f866c = 0;
    volatile Object e = i;

    /* renamed from: d  reason: collision with root package name */
    private volatile Object f867d = i;
    private int f = -1;

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.a implements h {
        final j e;

        LifecycleBoundObserver(j jVar, p<? super T> pVar) {
            super(pVar);
            this.e = jVar;
        }

        @Override // androidx.lifecycle.h
        public void d(j jVar, e.a aVar) {
            if (this.e.a().b() == e.b.DESTROYED) {
                LiveData.this.i(this.f868a);
            } else {
                h(k());
            }
        }

        @Override // androidx.lifecycle.LiveData.a
        void i() {
            this.e.a().c(this);
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean j(j jVar) {
            return this.e == jVar;
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean k() {
            return this.e.a().b().d(e.b.STARTED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class a {

        /* renamed from: a  reason: collision with root package name */
        final p<? super T> f868a;

        /* renamed from: b  reason: collision with root package name */
        boolean f869b;

        /* renamed from: c  reason: collision with root package name */
        int f870c = -1;

        a(p<? super T> pVar) {
            this.f868a = pVar;
        }

        void h(boolean z) {
            if (z == this.f869b) {
                return;
            }
            this.f869b = z;
            boolean z2 = LiveData.this.f866c == 0;
            LiveData.this.f866c += this.f869b ? 1 : -1;
            if (z2 && this.f869b) {
                LiveData.this.g();
            }
            LiveData liveData = LiveData.this;
            if (liveData.f866c == 0 && !this.f869b) {
                liveData.h();
            }
            if (this.f869b) {
                LiveData.this.c(this);
            }
        }

        void i() {
        }

        boolean j(j jVar) {
            return false;
        }

        abstract boolean k();
    }

    static void a(String str) {
        if (a.b.a.a.a.b().a()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void b(LiveData<T>.a aVar) {
        if (aVar.f869b) {
            if (!aVar.k()) {
                aVar.h(false);
                return;
            }
            int i2 = aVar.f870c;
            int i3 = this.f;
            if (i2 >= i3) {
                return;
            }
            aVar.f870c = i3;
            aVar.f868a.a((Object) this.f867d);
        }
    }

    void c(LiveData<T>.a aVar) {
        if (this.g) {
            this.h = true;
            return;
        }
        this.g = true;
        do {
            this.h = false;
            if (aVar == null) {
                a.b.a.b.b<p<? super T>, LiveData<T>.a>.d g = this.f865b.g();
                while (g.hasNext()) {
                    b((a) g.next().getValue());
                    if (this.h) {
                        break;
                    }
                }
            } else {
                b(aVar);
                aVar = null;
            }
        } while (this.h);
        this.g = false;
    }

    public T d() {
        T t = (T) this.f867d;
        if (t != i) {
            return t;
        }
        return null;
    }

    public boolean e() {
        return this.f866c > 0;
    }

    public void f(j jVar, p<? super T> pVar) {
        a("observe");
        if (jVar.a().b() == e.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(jVar, pVar);
        LiveData<T>.a m = this.f865b.m(pVar, lifecycleBoundObserver);
        if (m != null && !m.j(jVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (m != null) {
            return;
        }
        jVar.a().a(lifecycleBoundObserver);
    }

    protected void g() {
    }

    protected void h() {
    }

    public void i(p<? super T> pVar) {
        a("removeObserver");
        LiveData<T>.a s = this.f865b.s(pVar);
        if (s == null) {
            return;
        }
        s.i();
        s.h(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(T t) {
        a("setValue");
        this.f++;
        this.f867d = t;
        c(null);
    }
}
