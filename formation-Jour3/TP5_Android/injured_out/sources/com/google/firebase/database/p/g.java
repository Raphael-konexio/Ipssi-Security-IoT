package com.google.firebase.database.p;

import com.google.firebase.database.o.c;
import com.google.firebase.database.o.h;
import com.google.firebase.database.p.a;
import com.google.firebase.database.q.d;
import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    protected com.google.firebase.database.q.d f2168a;

    /* renamed from: b  reason: collision with root package name */
    protected k f2169b;

    /* renamed from: c  reason: collision with root package name */
    protected com.google.firebase.database.p.a f2170c;

    /* renamed from: d  reason: collision with root package name */
    protected q f2171d;
    protected String e;
    protected List<String> f;
    protected String g;
    protected boolean i;
    protected b.c.c.c k;
    private com.google.firebase.database.p.f0.e l;
    private m o;
    protected d.a h = d.a.INFO;
    protected long j = 10485760;
    private boolean m = false;
    private boolean n = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements a.InterfaceC0100a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ScheduledExecutorService f2172a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c.a f2173b;

        a(ScheduledExecutorService scheduledExecutorService, c.a aVar) {
            this.f2172a = scheduledExecutorService;
            this.f2173b = aVar;
        }

        @Override // com.google.firebase.database.p.a.InterfaceC0100a
        public void a(String str) {
            this.f2172a.execute(e.a(this.f2173b, str));
        }

        @Override // com.google.firebase.database.p.a.InterfaceC0100a
        public void b(String str) {
            this.f2172a.execute(f.a(this.f2173b, str));
        }
    }

    private void D() {
        this.f2169b.a();
        this.f2171d.a();
    }

    private static com.google.firebase.database.o.c E(com.google.firebase.database.p.a aVar, ScheduledExecutorService scheduledExecutorService) {
        return d.b(aVar, scheduledExecutorService);
    }

    private String b(String str) {
        return "Firebase/5/" + com.google.firebase.database.f.e() + "/" + str;
    }

    private void c() {
        com.google.android.gms.common.internal.r.i(this.f2170c, "You must register an authTokenProvider before initializing Context.");
    }

    private void d() {
        if (this.f2169b == null) {
            this.f2169b = r().c(this);
        }
    }

    private void e() {
        if (this.f2168a == null) {
            this.f2168a = r().e(this, this.h, this.f);
        }
    }

    private void f() {
        if (this.f2171d == null) {
            this.f2171d = this.o.g(this);
        }
    }

    private void g() {
        if (this.e == null) {
            this.e = "default";
        }
    }

    private void h() {
        if (this.g == null) {
            this.g = b(r().b(this));
        }
    }

    private ScheduledExecutorService m() {
        q s = s();
        if (s instanceof com.google.firebase.database.p.g0.c) {
            return ((com.google.firebase.database.p.g0.c) s).c();
        }
        throw new RuntimeException("Custom run loops are not supported!");
    }

    private m r() {
        if (this.o == null) {
            x();
        }
        return this.o;
    }

    private void w() {
        e();
        r();
        h();
        d();
        f();
        g();
        c();
    }

    private synchronized void x() {
        this.o = new com.google.firebase.database.m.h(this.k);
    }

    public com.google.firebase.database.o.h B(com.google.firebase.database.o.f fVar, h.a aVar) {
        return r().f(this, k(), fVar, aVar);
    }

    public void C() {
        if (this.n) {
            D();
            this.n = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (y()) {
            throw new com.google.firebase.database.c("Modifications to DatabaseConfig objects must occur before they are in use");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void i() {
        if (!this.m) {
            this.m = true;
            w();
        }
    }

    public com.google.firebase.database.p.a j() {
        return this.f2170c;
    }

    public com.google.firebase.database.o.d k() {
        return new com.google.firebase.database.o.d(o(), E(j(), m()), m(), z(), com.google.firebase.database.f.e(), v(), t().getAbsolutePath());
    }

    public k l() {
        return this.f2169b;
    }

    public com.google.firebase.database.q.c n(String str) {
        return new com.google.firebase.database.q.c(this.f2168a, str);
    }

    public com.google.firebase.database.q.d o() {
        return this.f2168a;
    }

    public long p() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.firebase.database.p.f0.e q(String str) {
        com.google.firebase.database.p.f0.e eVar = this.l;
        if (eVar != null) {
            return eVar;
        }
        if (this.i) {
            com.google.firebase.database.p.f0.e a2 = this.o.a(this, str);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("You have enabled persistence, but persistence is not supported on this platform.");
        }
        return new com.google.firebase.database.p.f0.d();
    }

    public q s() {
        return this.f2171d;
    }

    public File t() {
        return r().d();
    }

    public String u() {
        return this.e;
    }

    public String v() {
        return this.g;
    }

    public boolean y() {
        return this.m;
    }

    public boolean z() {
        return this.i;
    }
}
