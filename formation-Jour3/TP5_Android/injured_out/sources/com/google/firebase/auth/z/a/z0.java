package com.google.firebase.auth.z.a;

import b.c.a.a.d.c.k1;
import b.c.a.a.d.c.m1;
import b.c.a.a.d.c.q1;
import b.c.a.a.d.c.x1;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class z0<ResultT, CallbackT> implements e<n0, ResultT> {

    /* renamed from: a  reason: collision with root package name */
    protected final int f1959a;

    /* renamed from: c  reason: collision with root package name */
    protected b.c.c.c f1961c;

    /* renamed from: d  reason: collision with root package name */
    protected com.google.firebase.auth.n f1962d;
    protected CallbackT e;
    protected com.google.firebase.auth.internal.g f;
    protected a1<ResultT> g;
    protected Executor i;
    protected q1 j;
    protected m1 k;
    protected k1 l;
    protected x1 m;
    protected String n;
    protected String o;
    protected com.google.firebase.auth.b p;
    protected String q;
    protected String r;
    protected b.c.a.a.d.c.h1 s;
    protected boolean t;
    protected boolean u;
    private boolean v;
    boolean w;
    private ResultT x;

    /* renamed from: b  reason: collision with root package name */
    final b1 f1960b = new b1(this);
    protected final List<com.google.firebase.auth.v> h = new ArrayList();

    public z0(int i) {
        this.f1959a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean l(z0 z0Var, boolean z) {
        z0Var.v = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Status status) {
        com.google.firebase.auth.internal.g gVar = this.f;
        if (gVar != null) {
            gVar.e(status);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        o();
        com.google.android.gms.common.internal.r.k(this.v, "no success or failure set on method implementation");
    }

    @Override // com.google.firebase.auth.z.a.e
    public final e<n0, ResultT> b() {
        this.t = true;
        return this;
    }

    @Override // com.google.firebase.auth.z.a.e
    public final e<n0, ResultT> d() {
        this.u = true;
        return this;
    }

    public final z0<ResultT, CallbackT> e(b.c.c.c cVar) {
        com.google.android.gms.common.internal.r.i(cVar, "firebaseApp cannot be null");
        this.f1961c = cVar;
        return this;
    }

    public final z0<ResultT, CallbackT> f(com.google.firebase.auth.n nVar) {
        com.google.android.gms.common.internal.r.i(nVar, "firebaseUser cannot be null");
        this.f1962d = nVar;
        return this;
    }

    public final z0<ResultT, CallbackT> g(com.google.firebase.auth.internal.g gVar) {
        com.google.android.gms.common.internal.r.i(gVar, "external failure callback cannot be null");
        this.f = gVar;
        return this;
    }

    public final z0<ResultT, CallbackT> h(CallbackT callbackt) {
        com.google.android.gms.common.internal.r.i(callbackt, "external callback cannot be null");
        this.e = callbackt;
        return this;
    }

    public final void i(Status status) {
        this.v = true;
        this.g.a(null, status);
    }

    public final void n(ResultT resultt) {
        this.v = true;
        this.x = resultt;
        this.g.a(resultt, null);
    }

    public abstract void o();
}
