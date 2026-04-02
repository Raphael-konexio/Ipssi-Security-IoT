package com.google.firebase.database.p;

import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    private final l f2132a;

    /* renamed from: b  reason: collision with root package name */
    private final b0 f2133b;

    public c0(l lVar, b0 b0Var) {
        this.f2132a = lVar;
        this.f2133b = b0Var;
    }

    public com.google.firebase.database.r.n a(com.google.firebase.database.r.b bVar, com.google.firebase.database.p.h0.a aVar) {
        return this.f2133b.c(this.f2132a, bVar, aVar);
    }

    public com.google.firebase.database.r.n b(com.google.firebase.database.r.n nVar) {
        return c(nVar, Collections.emptyList());
    }

    public com.google.firebase.database.r.n c(com.google.firebase.database.r.n nVar, List<Long> list) {
        return d(nVar, list, false);
    }

    public com.google.firebase.database.r.n d(com.google.firebase.database.r.n nVar, List<Long> list, boolean z) {
        return this.f2133b.d(this.f2132a, nVar, list, z);
    }

    public com.google.firebase.database.r.n e(com.google.firebase.database.r.n nVar) {
        return this.f2133b.e(this.f2132a, nVar);
    }

    public com.google.firebase.database.r.n f(l lVar, com.google.firebase.database.r.n nVar, com.google.firebase.database.r.n nVar2) {
        return this.f2133b.f(this.f2132a, lVar, nVar, nVar2);
    }

    public com.google.firebase.database.r.m g(com.google.firebase.database.r.n nVar, com.google.firebase.database.r.m mVar, boolean z, com.google.firebase.database.r.h hVar) {
        return this.f2133b.g(this.f2132a, nVar, mVar, z, hVar);
    }

    public c0 h(com.google.firebase.database.r.b bVar) {
        return new c0(this.f2132a.l(bVar), this.f2133b);
    }

    public com.google.firebase.database.r.n i(l lVar) {
        return this.f2133b.n(this.f2132a.i(lVar));
    }
}
