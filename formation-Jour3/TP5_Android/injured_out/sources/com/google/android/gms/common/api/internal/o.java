package com.google.android.gms.common.api.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [TResult] */
/* loaded from: classes.dex */
public final class o<TResult> implements b.c.a.a.f.c<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ b.c.a.a.f.h f1579a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ p0 f1580b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(p0 p0Var, b.c.a.a.f.h hVar) {
        this.f1580b = p0Var;
        this.f1579a = hVar;
    }

    @Override // b.c.a.a.f.c
    public final void a(b.c.a.a.f.g<TResult> gVar) {
        Map map;
        map = this.f1580b.f1582b;
        map.remove(this.f1579a);
    }
}
