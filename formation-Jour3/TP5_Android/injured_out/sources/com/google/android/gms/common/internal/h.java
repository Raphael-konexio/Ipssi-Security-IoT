package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.c;
import java.util.Collections;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class h<T extends IInterface> extends c<T> implements a.f {
    private final Set<Scope> v;
    private final Account w;

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public h(Context context, Looper looper, int i, d dVar, com.google.android.gms.common.api.f fVar, com.google.android.gms.common.api.g gVar) {
        this(context, looper, i, dVar, (com.google.android.gms.common.api.internal.d) fVar, (com.google.android.gms.common.api.internal.i) gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(android.content.Context r10, android.os.Looper r11, int r12, com.google.android.gms.common.internal.d r13, com.google.android.gms.common.api.internal.d r14, com.google.android.gms.common.api.internal.i r15) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.i r3 = com.google.android.gms.common.internal.i.a(r10)
            b.c.a.a.b.d r4 = b.c.a.a.b.d.l()
            com.google.android.gms.common.internal.r.h(r14)
            r7 = r14
            com.google.android.gms.common.api.internal.d r7 = (com.google.android.gms.common.api.internal.d) r7
            com.google.android.gms.common.internal.r.h(r15)
            r8 = r15
            com.google.android.gms.common.api.internal.i r8 = (com.google.android.gms.common.api.internal.i) r8
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.h.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.d, com.google.android.gms.common.api.internal.d, com.google.android.gms.common.api.internal.i):void");
    }

    protected h(Context context, Looper looper, i iVar, b.c.a.a.b.d dVar, int i, d dVar2, com.google.android.gms.common.api.internal.d dVar3, com.google.android.gms.common.api.internal.i iVar2) {
        super(context, looper, iVar, dVar, i, h0(dVar3), i0(iVar2), dVar2.e());
        this.w = dVar2.a();
        Set<Scope> c2 = dVar2.c();
        j0(c2);
        this.v = c2;
    }

    private static c.a h0(com.google.android.gms.common.api.internal.d dVar) {
        if (dVar == null) {
            return null;
        }
        return new y(dVar);
    }

    private static c.b i0(com.google.android.gms.common.api.internal.i iVar) {
        if (iVar == null) {
            return null;
        }
        return new z(iVar);
    }

    private final Set<Scope> j0(Set<Scope> set) {
        g0(set);
        for (Scope scope : set) {
            if (!set.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return set;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final Set<Scope> B() {
        return this.v;
    }

    @Override // com.google.android.gms.common.api.a.f
    public Set<Scope> e() {
        return q() ? this.v : Collections.emptySet();
    }

    protected Set<Scope> g0(Set<Scope> set) {
        return set;
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public int k() {
        return super.k();
    }

    @Override // com.google.android.gms.common.internal.c
    public final Account v() {
        return this.w;
    }
}
