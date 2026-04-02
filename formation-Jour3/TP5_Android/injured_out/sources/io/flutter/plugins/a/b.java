package io.flutter.plugins.a;

import android.content.Context;
import c.a.c.a.i;
import io.flutter.embedding.engine.h.a;
/* loaded from: classes.dex */
public class b implements io.flutter.embedding.engine.h.a {

    /* renamed from: a  reason: collision with root package name */
    private i f2663a;

    private void a(c.a.c.a.b bVar, Context context) {
        this.f2663a = new i(bVar, "plugins.flutter.io/shared_preferences");
        this.f2663a.e(new a(context));
    }

    private void b() {
        this.f2663a.e(null);
        this.f2663a = null;
    }

    @Override // io.flutter.embedding.engine.h.a
    public void c(a.b bVar) {
        a(bVar.b(), bVar.a());
    }

    @Override // io.flutter.embedding.engine.h.a
    public void f(a.b bVar) {
        b();
    }
}
