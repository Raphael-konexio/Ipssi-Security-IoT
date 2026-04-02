package com.google.firebase.database.p.h0;
/* loaded from: classes.dex */
public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.firebase.database.p.l f2199a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.database.p.i f2200b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.database.b f2201c;

    public b(com.google.firebase.database.p.i iVar, com.google.firebase.database.b bVar, com.google.firebase.database.p.l lVar) {
        this.f2200b = iVar;
        this.f2199a = lVar;
        this.f2201c = bVar;
    }

    @Override // com.google.firebase.database.p.h0.e
    public void a() {
        this.f2200b.c(this.f2201c);
    }

    public com.google.firebase.database.p.l b() {
        return this.f2199a;
    }

    @Override // com.google.firebase.database.p.h0.e
    public String toString() {
        return b() + ":CANCEL";
    }
}
