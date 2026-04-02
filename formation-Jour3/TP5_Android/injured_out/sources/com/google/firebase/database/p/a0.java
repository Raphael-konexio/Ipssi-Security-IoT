package com.google.firebase.database.p;

import com.google.firebase.database.p.h0.e;
/* loaded from: classes.dex */
public class a0 extends i {

    /* renamed from: d  reason: collision with root package name */
    private final n f2117d;
    private final com.google.firebase.database.l e;
    private final com.google.firebase.database.p.h0.i f;

    public a0(n nVar, com.google.firebase.database.l lVar, com.google.firebase.database.p.h0.i iVar) {
        this.f2117d = nVar;
        this.e = lVar;
        this.f = iVar;
    }

    @Override // com.google.firebase.database.p.i
    public i a(com.google.firebase.database.p.h0.i iVar) {
        return new a0(this.f2117d, this.e, iVar);
    }

    @Override // com.google.firebase.database.p.i
    public com.google.firebase.database.p.h0.d b(com.google.firebase.database.p.h0.c cVar, com.google.firebase.database.p.h0.i iVar) {
        return new com.google.firebase.database.p.h0.d(e.a.VALUE, this, com.google.firebase.database.h.a(com.google.firebase.database.h.c(this.f2117d, iVar.e()), cVar.k()), null);
    }

    @Override // com.google.firebase.database.p.i
    public void c(com.google.firebase.database.b bVar) {
        this.e.a(bVar);
    }

    @Override // com.google.firebase.database.p.i
    public void d(com.google.firebase.database.p.h0.d dVar) {
        if (g()) {
            return;
        }
        this.e.b(dVar.c());
    }

    @Override // com.google.firebase.database.p.i
    public com.google.firebase.database.p.h0.i e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a0) {
            a0 a0Var = (a0) obj;
            if (a0Var.e.equals(this.e) && a0Var.f2117d.equals(this.f2117d) && a0Var.f.equals(this.f)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.database.p.i
    public boolean f(i iVar) {
        return (iVar instanceof a0) && ((a0) iVar).e.equals(this.e);
    }

    @Override // com.google.firebase.database.p.i
    public boolean h(e.a aVar) {
        return aVar == e.a.VALUE;
    }

    public int hashCode() {
        return (((this.e.hashCode() * 31) + this.f2117d.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "ValueEventRegistration";
    }
}
