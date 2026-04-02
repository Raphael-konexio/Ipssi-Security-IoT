package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.c0;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.r;
import java.util.Collections;
/* loaded from: classes.dex */
public class e<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1525a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.gms.common.api.a<O> f1526b;

    /* renamed from: c  reason: collision with root package name */
    private final O f1527c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.gms.common.api.internal.b<O> f1528d;
    private final int e;
    private final com.google.android.gms.common.api.internal.l f;
    protected final com.google.android.gms.common.api.internal.e g;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final com.google.android.gms.common.api.internal.l f1529a;

        /* renamed from: b  reason: collision with root package name */
        public final Looper f1530b;

        /* renamed from: com.google.android.gms.common.api.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0077a {

            /* renamed from: a  reason: collision with root package name */
            private com.google.android.gms.common.api.internal.l f1531a;

            /* renamed from: b  reason: collision with root package name */
            private Looper f1532b;

            public a a() {
                if (this.f1531a == null) {
                    this.f1531a = new com.google.android.gms.common.api.internal.a();
                }
                if (this.f1532b == null) {
                    this.f1532b = Looper.getMainLooper();
                }
                return new a(this.f1531a, this.f1532b);
            }

            public C0077a b(com.google.android.gms.common.api.internal.l lVar) {
                r.i(lVar, "StatusExceptionMapper must not be null.");
                this.f1531a = lVar;
                return this;
            }
        }

        static {
            new C0077a().a();
        }

        private a(com.google.android.gms.common.api.internal.l lVar, Account account, Looper looper) {
            this.f1529a = lVar;
            this.f1530b = looper;
        }
    }

    public e(Context context, com.google.android.gms.common.api.a<O> aVar, O o, a aVar2) {
        r.i(context, "Null context is not permitted.");
        r.i(aVar, "Api must not be null.");
        r.i(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f1525a = context.getApplicationContext();
        this.f1526b = aVar;
        this.f1527c = o;
        Looper looper = aVar2.f1530b;
        this.f1528d = com.google.android.gms.common.api.internal.b.b(aVar, o);
        com.google.android.gms.common.api.internal.e f = com.google.android.gms.common.api.internal.e.f(this.f1525a);
        this.g = f;
        this.e = f.h();
        this.f = aVar2.f1529a;
        this.g.c(this);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(android.content.Context r2, com.google.android.gms.common.api.a<O> r3, O r4, com.google.android.gms.common.api.internal.l r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.e$a$a r0 = new com.google.android.gms.common.api.e$a$a
            r0.<init>()
            r0.b(r5)
            com.google.android.gms.common.api.e$a r5 = r0.a()
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.e.<init>(android.content.Context, com.google.android.gms.common.api.a, com.google.android.gms.common.api.a$d, com.google.android.gms.common.api.internal.l):void");
    }

    private final <TResult, A extends a.b> b.c.a.a.f.g<TResult> i(int i, com.google.android.gms.common.api.internal.m<A, TResult> mVar) {
        b.c.a.a.f.h hVar = new b.c.a.a.f.h();
        this.g.d(this, i, mVar, hVar, this.f);
        return hVar.a();
    }

    protected d.a a() {
        Account c2;
        GoogleSignInAccount a2;
        GoogleSignInAccount a3;
        d.a aVar = new d.a();
        O o = this.f1527c;
        if (!(o instanceof a.d.b) || (a3 = ((a.d.b) o).a()) == null) {
            O o2 = this.f1527c;
            c2 = o2 instanceof a.d.InterfaceC0076a ? ((a.d.InterfaceC0076a) o2).c() : null;
        } else {
            c2 = a3.b();
        }
        aVar.c(c2);
        O o3 = this.f1527c;
        aVar.a((!(o3 instanceof a.d.b) || (a2 = ((a.d.b) o3).a()) == null) ? Collections.emptySet() : a2.q());
        aVar.d(this.f1525a.getClass().getName());
        aVar.e(this.f1525a.getPackageName());
        return aVar;
    }

    public <TResult, A extends a.b> b.c.a.a.f.g<TResult> b(com.google.android.gms.common.api.internal.m<A, TResult> mVar) {
        return i(0, mVar);
    }

    public <TResult, A extends a.b> b.c.a.a.f.g<TResult> c(com.google.android.gms.common.api.internal.m<A, TResult> mVar) {
        return i(1, mVar);
    }

    public com.google.android.gms.common.api.internal.b<O> d() {
        return this.f1528d;
    }

    public O e() {
        return this.f1527c;
    }

    public final int f() {
        return this.e;
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [com.google.android.gms.common.api.a$f] */
    public a.f g(Looper looper, e.a<O> aVar) {
        return this.f1526b.b().a(this.f1525a, looper, a().b(), this.f1527c, aVar, aVar);
    }

    public c0 h(Context context, Handler handler) {
        return new c0(context, handler, a().b());
    }
}
