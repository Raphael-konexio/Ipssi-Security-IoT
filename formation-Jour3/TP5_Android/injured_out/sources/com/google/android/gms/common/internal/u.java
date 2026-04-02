package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.a;
/* loaded from: classes.dex */
public class u<T extends IInterface> extends h<T> {
    private final a.h<T> x;

    @Override // com.google.android.gms.common.internal.c
    protected void I(int i, T t) {
        this.x.s(i, t);
    }

    @Override // com.google.android.gms.common.internal.c
    protected String f() {
        return this.x.f();
    }

    @Override // com.google.android.gms.common.internal.c
    protected T h(IBinder iBinder) {
        return this.x.h(iBinder);
    }

    public a.h<T> k0() {
        return this.x;
    }

    @Override // com.google.android.gms.common.internal.c
    protected String r() {
        return this.x.r();
    }
}
