package com.google.firebase.database.p.h0;

import com.google.firebase.database.r.n;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final a f2226a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2227b;

    public k(a aVar, a aVar2) {
        this.f2226a = aVar;
        this.f2227b = aVar2;
    }

    public n a() {
        if (this.f2226a.f()) {
            return this.f2226a.b();
        }
        return null;
    }

    public n b() {
        if (this.f2227b.f()) {
            return this.f2227b.b();
        }
        return null;
    }

    public a c() {
        return this.f2226a;
    }

    public a d() {
        return this.f2227b;
    }

    public k e(com.google.firebase.database.r.i iVar, boolean z, boolean z2) {
        return new k(new a(iVar, z, z2), this.f2227b);
    }

    public k f(com.google.firebase.database.r.i iVar, boolean z, boolean z2) {
        return new k(this.f2226a, new a(iVar, z, z2));
    }
}
