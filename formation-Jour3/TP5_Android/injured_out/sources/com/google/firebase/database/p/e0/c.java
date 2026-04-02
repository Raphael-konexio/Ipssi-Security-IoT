package com.google.firebase.database.p.e0;

import com.google.firebase.database.p.e0.d;
import com.google.firebase.database.p.l;
/* loaded from: classes.dex */
public class c extends d {

    /* renamed from: d  reason: collision with root package name */
    private final com.google.firebase.database.p.b f2139d;

    public c(e eVar, l lVar, com.google.firebase.database.p.b bVar) {
        super(d.a.Merge, eVar, lVar);
        this.f2139d = bVar;
    }

    @Override // com.google.firebase.database.p.e0.d
    public d d(com.google.firebase.database.r.b bVar) {
        if (!this.f2142c.isEmpty()) {
            if (this.f2142c.x().equals(bVar)) {
                return new c(this.f2141b, this.f2142c.A(), this.f2139d);
            }
            return null;
        }
        com.google.firebase.database.p.b l = this.f2139d.l(new l(bVar));
        if (l.isEmpty()) {
            return null;
        }
        return l.C() != null ? new f(this.f2141b, l.w(), l.C()) : new c(this.f2141b, l.w(), l);
    }

    public com.google.firebase.database.p.b e() {
        return this.f2139d;
    }

    public String toString() {
        return String.format("Merge { path=%s, source=%s, children=%s }", a(), b(), this.f2139d);
    }
}
