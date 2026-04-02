package com.google.firebase.auth.z.a;

import android.content.Context;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l0 implements Callable<a<v0>> {

    /* renamed from: a  reason: collision with root package name */
    private final v0 f1943a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f1944b;

    public l0(v0 v0Var, Context context) {
        this.f1943a = v0Var;
        this.f1944b = context;
    }

    private final com.google.android.gms.common.api.e<v0> a(boolean z, Context context) {
        v0 v0Var = (v0) this.f1943a.clone();
        v0Var.f = z;
        return new f(context, u0.f1954c, v0Var, new b.c.c.f());
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
        if (r0 == (-1)) goto L15;
     */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ com.google.firebase.auth.z.a.a<com.google.firebase.auth.z.a.v0> call() {
        /*
            r6 = this;
            int r0 = com.google.firebase.auth.z.a.m0.b()
            r1 = 0
            r2 = 1
            r3 = -1
            if (r0 == r3) goto Lf
            int r0 = com.google.firebase.auth.z.a.m0.d()
            if (r0 != r3) goto L3d
        Lf:
            android.content.Context r0 = r6.f1944b
            java.lang.String r3 = "com.google.firebase.auth"
            int r0 = com.google.android.gms.dynamite.DynamiteModule.a(r0, r3)
            if (r0 != 0) goto L1b
            r3 = 1
            goto L37
        L1b:
            b.c.a.a.b.d r3 = b.c.a.a.b.d.l()
            android.content.Context r4 = r6.f1944b
            r5 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r3 = r3.g(r4, r5)
            if (r3 == 0) goto L2f
            r4 = 2
            if (r3 == r4) goto L2f
            r3 = 0
            goto L37
        L2f:
            android.content.Context r3 = r6.f1944b
            java.lang.String r4 = "com.google.android.gms.firebase_auth"
            int r3 = com.google.android.gms.dynamite.DynamiteModule.b(r3, r4)
        L37:
            com.google.firebase.auth.z.a.m0.a(r3)
            com.google.firebase.auth.z.a.m0.c(r0)
        L3d:
            int r0 = com.google.firebase.auth.z.a.m0.d()
            r3 = 0
            if (r0 == 0) goto L4b
            android.content.Context r0 = r6.f1944b
            com.google.android.gms.common.api.e r0 = r6.a(r2, r0)
            goto L4c
        L4b:
            r0 = r3
        L4c:
            int r2 = com.google.firebase.auth.z.a.m0.b()
            if (r2 != 0) goto L53
            goto L59
        L53:
            android.content.Context r2 = r6.f1944b
            com.google.android.gms.common.api.e r3 = r6.a(r1, r2)
        L59:
            com.google.firebase.auth.z.a.c r1 = new com.google.firebase.auth.z.a.c
            int r2 = com.google.firebase.auth.z.a.m0.b()
            int r4 = com.google.firebase.auth.z.a.m0.d()
            java.util.Map r5 = java.util.Collections.emptyMap()
            r1.<init>(r2, r4, r5)
            com.google.firebase.auth.z.a.a r2 = new com.google.firebase.auth.z.a.a
            r2.<init>(r3, r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.z.a.l0.call():java.lang.Object");
    }
}
