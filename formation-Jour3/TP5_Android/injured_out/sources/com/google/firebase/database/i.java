package com.google.firebase.database;

import com.google.firebase.database.p.s;
import com.google.firebase.database.p.z;
import com.google.firebase.database.r.n;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final s f2014a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.database.p.l f2015b;

    private i(s sVar, com.google.firebase.database.p.l lVar) {
        this.f2014a = sVar;
        this.f2015b = lVar;
        z.g(lVar, b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(n nVar) {
        this(new s(nVar), new com.google.firebase.database.p.l(""));
    }

    n a() {
        return this.f2014a.a(this.f2015b);
    }

    public Object b() {
        return a().getValue();
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.f2014a.equals(iVar.f2014a) && this.f2015b.equals(iVar.f2015b)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        com.google.firebase.database.r.b x = this.f2015b.x();
        StringBuilder sb = new StringBuilder();
        sb.append("MutableData { key = ");
        sb.append(x != null ? x.e() : "<none>");
        sb.append(", value = ");
        sb.append(this.f2014a.b().r(true));
        sb.append(" }");
        return sb.toString();
    }
}
