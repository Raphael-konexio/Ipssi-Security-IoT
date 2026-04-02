package com.google.firebase.database.p.e0;

import com.google.firebase.database.p.e0.d;
import com.google.firebase.database.p.l;
/* loaded from: classes.dex */
public class a extends d {

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2138d;
    private final com.google.firebase.database.p.g0.d<Boolean> e;

    public a(l lVar, com.google.firebase.database.p.g0.d<Boolean> dVar, boolean z) {
        super(d.a.AckUserWrite, e.f2143d, lVar);
        this.e = dVar;
        this.f2138d = z;
    }

    @Override // com.google.firebase.database.p.e0.d
    public d d(com.google.firebase.database.r.b bVar) {
        if (!this.f2142c.isEmpty()) {
            com.google.firebase.database.p.g0.l.f(this.f2142c.x().equals(bVar), "operationForChild called for unrelated child.");
            return new a(this.f2142c.A(), this.e, this.f2138d);
        } else if (this.e.getValue() != null) {
            com.google.firebase.database.p.g0.l.f(this.e.w().isEmpty(), "affectedTree should not have overlapping affected paths.");
            return this;
        } else {
            return new a(l.w(), this.e.D(new l(bVar)), this.f2138d);
        }
    }

    public com.google.firebase.database.p.g0.d<Boolean> e() {
        return this.e;
    }

    public boolean f() {
        return this.f2138d;
    }

    public String toString() {
        return String.format("AckUserWrite { path=%s, revert=%s, affectedTree=%s }", a(), Boolean.valueOf(this.f2138d), this.e);
    }
}
