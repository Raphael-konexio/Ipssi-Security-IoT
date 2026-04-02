package com.google.firebase.auth.z.a;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.dynamite.DynamiteModule;
/* loaded from: classes.dex */
public final class p0 extends com.google.android.gms.common.internal.h<s0> implements n0 {
    private static b.c.a.a.b.k.a z = new b.c.a.a.b.k.a("FirebaseAuth", "FirebaseAuth:");
    private final Context x;
    private final v0 y;

    public p0(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, v0 v0Var, com.google.android.gms.common.api.internal.d dVar2, com.google.android.gms.common.api.internal.i iVar) {
        super(context, looper, 112, dVar, dVar2, iVar);
        com.google.android.gms.common.internal.r.h(context);
        this.x = context;
        this.y = v0Var;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String D() {
        if (this.y.f) {
            z.d("Preparing to create service connection to fallback implementation", new Object[0]);
            return this.x.getPackageName();
        }
        z.d("Preparing to create service connection to gms implementation", new Object[0]);
        return "com.google.android.gms";
    }

    @Override // com.google.firebase.auth.z.a.n0
    public final /* synthetic */ s0 c() {
        return (s0) super.C();
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String f() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final /* synthetic */ IInterface h(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
        return queryLocalInterface instanceof s0 ? (s0) queryLocalInterface : new t0(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final boolean j() {
        return DynamiteModule.a(this.x, "com.google.firebase.auth") == 0;
    }

    @Override // com.google.android.gms.common.internal.h, com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final int k() {
        return b.c.a.a.b.g.f1220a;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String r() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    @Override // com.google.android.gms.common.internal.c
    public final b.c.a.a.b.c[] w() {
        return b.c.a.a.d.c.f1.f1254d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    public final Bundle z() {
        Bundle z2 = super.z();
        if (z2 == null) {
            z2 = new Bundle();
        }
        v0 v0Var = this.y;
        if (v0Var != null) {
            z2.putString("com.google.firebase.auth.API_KEY", v0Var.d());
        }
        z2.putString("com.google.firebase.auth.LIBRARY_VERSION", x0.a());
        return z2;
    }
}
