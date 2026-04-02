package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class j0<T> extends r {

    /* renamed from: a  reason: collision with root package name */
    protected final b.c.a.a.f.h<T> f1565a;

    public j0(int i, b.c.a.a.f.h<T> hVar) {
        super(i);
        this.f1565a = hVar;
    }

    @Override // com.google.android.gms.common.api.internal.a0
    public void b(Status status) {
        this.f1565a.d(new com.google.android.gms.common.api.b(status));
    }

    @Override // com.google.android.gms.common.api.internal.a0
    public void d(RuntimeException runtimeException) {
        this.f1565a.d(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.a0
    public final void f(e.a<?> aVar) {
        Status a2;
        Status a3;
        try {
            i(aVar);
        } catch (DeadObjectException e) {
            a3 = a0.a(e);
            b(a3);
            throw e;
        } catch (RemoteException e2) {
            a2 = a0.a(e2);
            b(a2);
        } catch (RuntimeException e3) {
            d(e3);
        }
    }

    protected abstract void i(e.a<?> aVar);
}
