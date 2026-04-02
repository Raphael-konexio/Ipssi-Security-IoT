package io.flutter.embedding.engine.i;

import c.a.c.a.s;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.a<String> f2534a;

    public d(io.flutter.embedding.engine.e.a aVar) {
        this.f2534a = new c.a.c.a.a<>(aVar, "flutter/lifecycle", s.f1507b);
    }

    public void a() {
        c.a.b.d("LifecycleChannel", "Sending AppLifecycleState.detached message.");
        this.f2534a.c("AppLifecycleState.detached");
    }

    public void b() {
        c.a.b.d("LifecycleChannel", "Sending AppLifecycleState.inactive message.");
        this.f2534a.c("AppLifecycleState.inactive");
    }

    public void c() {
        c.a.b.d("LifecycleChannel", "Sending AppLifecycleState.paused message.");
        this.f2534a.c("AppLifecycleState.paused");
    }

    public void d() {
        c.a.b.d("LifecycleChannel", "Sending AppLifecycleState.resumed message.");
        this.f2534a.c("AppLifecycleState.resumed");
    }
}
