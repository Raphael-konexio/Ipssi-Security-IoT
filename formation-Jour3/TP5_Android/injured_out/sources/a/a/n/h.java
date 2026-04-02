package a.a.n;

import a.g.k.w;
import a.g.k.x;
import a.g.k.y;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class h {

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f40c;

    /* renamed from: d  reason: collision with root package name */
    x f41d;
    private boolean e;

    /* renamed from: b  reason: collision with root package name */
    private long f39b = -1;
    private final y f = new a();

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<w> f38a = new ArrayList<>();

    /* loaded from: classes.dex */
    class a extends y {

        /* renamed from: a  reason: collision with root package name */
        private boolean f42a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f43b = 0;

        a() {
        }

        @Override // a.g.k.x
        public void b(View view) {
            int i = this.f43b + 1;
            this.f43b = i;
            if (i == h.this.f38a.size()) {
                x xVar = h.this.f41d;
                if (xVar != null) {
                    xVar.b(null);
                }
                d();
            }
        }

        @Override // a.g.k.y, a.g.k.x
        public void c(View view) {
            if (this.f42a) {
                return;
            }
            this.f42a = true;
            x xVar = h.this.f41d;
            if (xVar != null) {
                xVar.c(null);
            }
        }

        void d() {
            this.f43b = 0;
            this.f42a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.e) {
            Iterator<w> it = this.f38a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.e = false;
        }
    }

    void b() {
        this.e = false;
    }

    public h c(w wVar) {
        if (!this.e) {
            this.f38a.add(wVar);
        }
        return this;
    }

    public h d(w wVar, w wVar2) {
        this.f38a.add(wVar);
        wVar2.h(wVar.c());
        this.f38a.add(wVar2);
        return this;
    }

    public h e(long j) {
        if (!this.e) {
            this.f39b = j;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.e) {
            this.f40c = interpolator;
        }
        return this;
    }

    public h g(x xVar) {
        if (!this.e) {
            this.f41d = xVar;
        }
        return this;
    }

    public void h() {
        if (this.e) {
            return;
        }
        Iterator<w> it = this.f38a.iterator();
        while (it.hasNext()) {
            w next = it.next();
            long j = this.f39b;
            if (j >= 0) {
                next.d(j);
            }
            Interpolator interpolator = this.f40c;
            if (interpolator != null) {
                next.e(interpolator);
            }
            if (this.f41d != null) {
                next.f(this.f);
            }
            next.j();
        }
        this.e = true;
    }
}
