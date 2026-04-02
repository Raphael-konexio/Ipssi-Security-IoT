package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.e;
/* loaded from: classes.dex */
public final class k0<ResultT> extends r {

    /* renamed from: a  reason: collision with root package name */
    private final m<a.b, ResultT> f1566a;

    /* renamed from: b  reason: collision with root package name */
    private final b.c.a.a.f.h<ResultT> f1567b;

    /* renamed from: c  reason: collision with root package name */
    private final l f1568c;

    public k0(int i, m<a.b, ResultT> mVar, b.c.a.a.f.h<ResultT> hVar, l lVar) {
        super(i);
        this.f1567b = hVar;
        this.f1566a = mVar;
        this.f1568c = lVar;
    }

    @Override // com.google.android.gms.common.api.internal.a0
    public final void b(Status status) {
        this.f1567b.d(this.f1568c.a(status));
    }

    @Override // com.google.android.gms.common.api.internal.a0
    public final void c(p0 p0Var, boolean z) {
        p0Var.a(this.f1567b, z);
    }

    @Override // com.google.android.gms.common.api.internal.a0
    public final void d(RuntimeException runtimeException) {
        this.f1567b.d(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.a0
    public final void f(e.a<?> aVar) {
        Status a2;
        try {
            this.f1566a.b(aVar.o(), this.f1567b);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            a2 = a0.a(e2);
            b(a2);
        } catch (RuntimeException e3) {
            d(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.r
    public final b.c.a.a.b.c[] g(e.a<?> aVar) {
        return this.f1566a.d();
    }

    @Override // com.google.android.gms.common.api.internal.r
    public final boolean h(e.a<?> aVar) {
        return this.f1566a.c();
    }
}
