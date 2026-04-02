package com.google.firebase.database.p.e0;

import com.google.firebase.database.p.e0.d;
import com.google.firebase.database.p.l;
import com.google.firebase.database.r.n;
/* loaded from: classes.dex */
public class f extends d {

    /* renamed from: d  reason: collision with root package name */
    private final n f2147d;

    public f(e eVar, l lVar, n nVar) {
        super(d.a.Overwrite, eVar, lVar);
        this.f2147d = nVar;
    }

    @Override // com.google.firebase.database.p.e0.d
    public d d(com.google.firebase.database.r.b bVar) {
        return this.f2142c.isEmpty() ? new f(this.f2141b, l.w(), this.f2147d.b(bVar)) : new f(this.f2141b, this.f2142c.A(), this.f2147d);
    }

    public n e() {
        return this.f2147d;
    }

    public String toString() {
        return String.format("Overwrite { path=%s, source=%s, snapshot=%s }", a(), b(), this.f2147d);
    }
}
