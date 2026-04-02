package io.flutter.embedding.engine.i;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.i f2540a;

    public g(io.flutter.embedding.engine.e.a aVar) {
        this.f2540a = new c.a.c.a.i(aVar, "flutter/navigation", c.a.c.a.e.f1489a);
    }

    public void a() {
        c.a.b.d("NavigationChannel", "Sending message to pop route.");
        this.f2540a.c("popRoute", null);
    }

    public void b(String str) {
        c.a.b.d("NavigationChannel", "Sending message to push route '" + str + "'");
        this.f2540a.c("pushRoute", str);
    }

    public void c(String str) {
        c.a.b.d("NavigationChannel", "Sending message to set initial route to '" + str + "'");
        this.f2540a.c("setInitialRoute", str);
    }
}
