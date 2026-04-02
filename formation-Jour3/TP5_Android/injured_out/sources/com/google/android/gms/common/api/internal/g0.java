package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [A, ResultT] */
/* loaded from: classes.dex */
public final class g0<A, ResultT> extends m<A, ResultT> {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ m.a f1561c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(m.a aVar, b.c.a.a.b.c[] cVarArr, boolean z) {
        super(cVarArr, z);
        this.f1561c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect types in method signature: (TA;Lb/c/a/a/f/h<TResultT;>;)V */
    @Override // com.google.android.gms.common.api.internal.m
    public final void b(a.b bVar, b.c.a.a.f.h hVar) {
        k kVar;
        kVar = this.f1561c.f1572a;
        kVar.accept(bVar, hVar);
    }
}
