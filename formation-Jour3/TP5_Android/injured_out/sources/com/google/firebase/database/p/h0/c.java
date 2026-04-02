package com.google.firebase.database.p.h0;

import com.google.firebase.database.p.h0.e;
import com.google.firebase.database.r.n;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final e.a f2202a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.database.r.i f2203b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.database.r.i f2204c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.firebase.database.r.b f2205d;

    private c(e.a aVar, com.google.firebase.database.r.i iVar, com.google.firebase.database.r.b bVar, com.google.firebase.database.r.b bVar2, com.google.firebase.database.r.i iVar2) {
        this.f2202a = aVar;
        this.f2203b = iVar;
        this.f2205d = bVar;
        this.f2204c = iVar2;
    }

    public static c b(com.google.firebase.database.r.b bVar, com.google.firebase.database.r.i iVar) {
        return new c(e.a.CHILD_ADDED, iVar, bVar, null, null);
    }

    public static c c(com.google.firebase.database.r.b bVar, n nVar) {
        return b(bVar, com.google.firebase.database.r.i.e(nVar));
    }

    public static c d(com.google.firebase.database.r.b bVar, com.google.firebase.database.r.i iVar, com.google.firebase.database.r.i iVar2) {
        return new c(e.a.CHILD_CHANGED, iVar, bVar, null, iVar2);
    }

    public static c e(com.google.firebase.database.r.b bVar, n nVar, n nVar2) {
        return d(bVar, com.google.firebase.database.r.i.e(nVar), com.google.firebase.database.r.i.e(nVar2));
    }

    public static c f(com.google.firebase.database.r.b bVar, com.google.firebase.database.r.i iVar) {
        return new c(e.a.CHILD_MOVED, iVar, bVar, null, null);
    }

    public static c g(com.google.firebase.database.r.b bVar, com.google.firebase.database.r.i iVar) {
        return new c(e.a.CHILD_REMOVED, iVar, bVar, null, null);
    }

    public static c h(com.google.firebase.database.r.b bVar, n nVar) {
        return g(bVar, com.google.firebase.database.r.i.e(nVar));
    }

    public static c m(com.google.firebase.database.r.i iVar) {
        return new c(e.a.VALUE, iVar, null, null, null);
    }

    public c a(com.google.firebase.database.r.b bVar) {
        return new c(this.f2202a, this.f2203b, this.f2205d, bVar, this.f2204c);
    }

    public com.google.firebase.database.r.b i() {
        return this.f2205d;
    }

    public e.a j() {
        return this.f2202a;
    }

    public com.google.firebase.database.r.i k() {
        return this.f2203b;
    }

    public com.google.firebase.database.r.i l() {
        return this.f2204c;
    }

    public String toString() {
        return "Change: " + this.f2202a + " " + this.f2205d;
    }
}
