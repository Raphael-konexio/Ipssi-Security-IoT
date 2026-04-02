package com.google.firebase.database.p.f0;

import com.google.firebase.database.p.g0.l;
import com.google.firebase.database.p.y;
import com.google.firebase.database.r.n;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class d implements e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2153a = false;

    private void p() {
        l.f(this.f2153a, "Transaction expected to already be in progress.");
    }

    @Override // com.google.firebase.database.p.f0.e
    public void a(long j) {
        p();
    }

    @Override // com.google.firebase.database.p.f0.e
    public void b(com.google.firebase.database.p.l lVar, com.google.firebase.database.p.b bVar, long j) {
        p();
    }

    @Override // com.google.firebase.database.p.f0.e
    public List<y> c() {
        return Collections.emptyList();
    }

    @Override // com.google.firebase.database.p.f0.e
    public void d(com.google.firebase.database.p.l lVar, n nVar, long j) {
        p();
    }

    @Override // com.google.firebase.database.p.f0.e
    public void e(com.google.firebase.database.p.h0.i iVar) {
        p();
    }

    @Override // com.google.firebase.database.p.f0.e
    public void f(com.google.firebase.database.p.h0.i iVar) {
        p();
    }

    @Override // com.google.firebase.database.p.f0.e
    public void g(com.google.firebase.database.p.h0.i iVar, Set<com.google.firebase.database.r.b> set, Set<com.google.firebase.database.r.b> set2) {
        p();
    }

    @Override // com.google.firebase.database.p.f0.e
    public void h(com.google.firebase.database.p.h0.i iVar, Set<com.google.firebase.database.r.b> set) {
        p();
    }

    @Override // com.google.firebase.database.p.f0.e
    public <T> T i(Callable<T> callable) {
        l.f(!this.f2153a, "runInTransaction called when an existing transaction is already in progress.");
        this.f2153a = true;
        try {
            return callable.call();
        } finally {
        }
    }

    @Override // com.google.firebase.database.p.f0.e
    public void j(com.google.firebase.database.p.h0.i iVar, n nVar) {
        p();
    }

    @Override // com.google.firebase.database.p.f0.e
    public void k(com.google.firebase.database.p.l lVar, n nVar) {
        p();
    }

    @Override // com.google.firebase.database.p.f0.e
    public void l(com.google.firebase.database.p.h0.i iVar) {
        p();
    }

    @Override // com.google.firebase.database.p.f0.e
    public void m(com.google.firebase.database.p.l lVar, com.google.firebase.database.p.b bVar) {
        p();
    }

    @Override // com.google.firebase.database.p.f0.e
    public void n(com.google.firebase.database.p.l lVar, com.google.firebase.database.p.b bVar) {
        p();
    }

    @Override // com.google.firebase.database.p.f0.e
    public com.google.firebase.database.p.h0.a o(com.google.firebase.database.p.h0.i iVar) {
        return new com.google.firebase.database.p.h0.a(com.google.firebase.database.r.i.f(com.google.firebase.database.r.g.s(), iVar.c()), false, false);
    }
}
