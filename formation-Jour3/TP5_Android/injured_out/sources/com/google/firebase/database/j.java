package com.google.firebase.database;

import com.google.firebase.database.p.a0;
import com.google.firebase.database.p.d0;
import com.google.firebase.database.p.n;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    protected final n f2016a;

    /* renamed from: b  reason: collision with root package name */
    protected final com.google.firebase.database.p.l f2017b;

    /* renamed from: c  reason: collision with root package name */
    protected final com.google.firebase.database.p.h0.h f2018c = com.google.firebase.database.p.h0.h.i;

    /* loaded from: classes.dex */
    class a implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f2019a;

        a(l lVar) {
            this.f2019a = lVar;
        }

        @Override // com.google.firebase.database.l
        public void a(com.google.firebase.database.b bVar) {
            this.f2019a.a(bVar);
        }

        @Override // com.google.firebase.database.l
        public void b(com.google.firebase.database.a aVar) {
            j.this.f(this);
            this.f2019a.b(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        final /* synthetic */ com.google.firebase.database.p.i f;

        b(com.google.firebase.database.p.i iVar) {
            this.f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f2016a.O(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        final /* synthetic */ com.google.firebase.database.p.i f;

        c(com.google.firebase.database.p.i iVar) {
            this.f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f2016a.C(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(n nVar, com.google.firebase.database.p.l lVar) {
        this.f2016a = nVar;
        this.f2017b = lVar;
    }

    private void a(com.google.firebase.database.p.i iVar) {
        d0.b().c(iVar);
        this.f2016a.T(new c(iVar));
    }

    private void g(com.google.firebase.database.p.i iVar) {
        d0.b().e(iVar);
        this.f2016a.T(new b(iVar));
    }

    public void b(l lVar) {
        a(new a0(this.f2016a, new a(lVar), e()));
    }

    public l c(l lVar) {
        a(new a0(this.f2016a, lVar, e()));
        return lVar;
    }

    public com.google.firebase.database.p.l d() {
        return this.f2017b;
    }

    public com.google.firebase.database.p.h0.i e() {
        return new com.google.firebase.database.p.h0.i(this.f2017b, this.f2018c);
    }

    public void f(l lVar) {
        if (lVar == null) {
            throw new NullPointerException("listener must not be null");
        }
        g(new a0(this.f2016a, lVar, e()));
    }
}
