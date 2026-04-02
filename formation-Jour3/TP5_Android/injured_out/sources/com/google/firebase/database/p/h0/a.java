package com.google.firebase.database.p.h0;

import com.google.firebase.database.r.n;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.firebase.database.r.i f2196a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2197b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2198c;

    public a(com.google.firebase.database.r.i iVar, boolean z, boolean z2) {
        this.f2196a = iVar;
        this.f2197b = z;
        this.f2198c = z2;
    }

    public com.google.firebase.database.r.i a() {
        return this.f2196a;
    }

    public n b() {
        return this.f2196a.l();
    }

    public boolean c(com.google.firebase.database.r.b bVar) {
        return (f() && !this.f2198c) || this.f2196a.l().o(bVar);
    }

    public boolean d(com.google.firebase.database.p.l lVar) {
        return lVar.isEmpty() ? f() && !this.f2198c : c(lVar.x());
    }

    public boolean e() {
        return this.f2198c;
    }

    public boolean f() {
        return this.f2197b;
    }
}
