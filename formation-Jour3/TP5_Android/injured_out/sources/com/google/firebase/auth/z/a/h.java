package com.google.firebase.auth.z.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [ResultT] */
/* loaded from: classes.dex */
public final class h<ResultT> implements b.c.a.a.f.a<ResultT, b.c.a.a.f.g<ResultT>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ e f1933a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i f1934b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar, e eVar) {
        this.f1934b = iVar;
        this.f1933a = eVar;
    }

    @Override // b.c.a.a.f.a
    public final /* synthetic */ Object a(b.c.a.a.f.g gVar) {
        if (gVar.i() instanceof com.google.android.gms.common.api.m) {
            i iVar = this.f1934b;
            e eVar = this.f1933a;
            eVar.b();
            return iVar.b(eVar);
        }
        return gVar;
    }
}
