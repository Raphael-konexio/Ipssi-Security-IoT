package com.google.firebase.database.p.h0;

import java.util.Map;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.firebase.database.p.l f2218a;

    /* renamed from: b  reason: collision with root package name */
    private final h f2219b;

    public i(com.google.firebase.database.p.l lVar, h hVar) {
        this.f2218a = lVar;
        this.f2219b = hVar;
    }

    public static i a(com.google.firebase.database.p.l lVar) {
        return new i(lVar, h.i);
    }

    public static i b(com.google.firebase.database.p.l lVar, Map<String, Object> map) {
        return new i(lVar, h.a(map));
    }

    public com.google.firebase.database.r.h c() {
        return this.f2219b.b();
    }

    public h d() {
        return this.f2219b;
    }

    public com.google.firebase.database.p.l e() {
        return this.f2218a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f2218a.equals(iVar.f2218a) && this.f2219b.equals(iVar.f2219b);
    }

    public boolean f() {
        return this.f2219b.m();
    }

    public boolean g() {
        return this.f2219b.o();
    }

    public int hashCode() {
        return (this.f2218a.hashCode() * 31) + this.f2219b.hashCode();
    }

    public String toString() {
        return this.f2218a + ":" + this.f2219b;
    }
}
