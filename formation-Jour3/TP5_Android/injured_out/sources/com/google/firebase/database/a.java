package com.google.firebase.database;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.firebase.database.r.i f2001a;

    /* renamed from: b  reason: collision with root package name */
    private final d f2002b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d dVar, com.google.firebase.database.r.i iVar) {
        this.f2001a = iVar;
        this.f2002b = dVar;
    }

    public String a() {
        return this.f2002b.i();
    }

    public d b() {
        return this.f2002b;
    }

    public Object c() {
        return this.f2001a.l().getValue();
    }

    public Object d(boolean z) {
        return this.f2001a.l().r(z);
    }

    public String toString() {
        return "DataSnapshot { key = " + this.f2002b.i() + ", value = " + this.f2001a.l().r(true) + " }";
    }
}
