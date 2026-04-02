package com.google.firebase.components;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements b.c.c.l.a {

    /* renamed from: a  reason: collision with root package name */
    private final l f1976a;

    /* renamed from: b  reason: collision with root package name */
    private final d f1977b;

    private i(l lVar, d dVar) {
        this.f1976a = lVar;
        this.f1977b = dVar;
    }

    public static b.c.c.l.a a(l lVar, d dVar) {
        return new i(lVar, dVar);
    }

    @Override // b.c.c.l.a
    public Object get() {
        Object a2;
        a2 = r1.d().a(new v(this.f1977b, this.f1976a));
        return a2;
    }
}
