package com.google.firebase.database.p.e0;

import com.google.firebase.database.p.e0.d;
import com.google.firebase.database.p.l;
/* loaded from: classes.dex */
public class b extends d {
    public b(e eVar, l lVar) {
        super(d.a.ListenComplete, eVar, lVar);
    }

    @Override // com.google.firebase.database.p.e0.d
    public d d(com.google.firebase.database.r.b bVar) {
        return this.f2142c.isEmpty() ? new b(this.f2141b, l.w()) : new b(this.f2141b, this.f2142c.A());
    }

    public String toString() {
        return String.format("ListenComplete { path=%s, source=%s }", a(), b());
    }
}
