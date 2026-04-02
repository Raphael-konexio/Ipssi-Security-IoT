package a.c.a;

import android.content.res.ColorStateList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements f {
    private g n(e eVar) {
        return (g) eVar.f();
    }

    @Override // a.c.a.f
    public float a(e eVar) {
        return n(eVar).c();
    }

    @Override // a.c.a.f
    public ColorStateList b(e eVar) {
        return n(eVar).b();
    }

    @Override // a.c.a.f
    public void c(e eVar, float f) {
        n(eVar).h(f);
    }

    @Override // a.c.a.f
    public float d(e eVar) {
        return eVar.b().getElevation();
    }

    @Override // a.c.a.f
    public void e() {
    }

    @Override // a.c.a.f
    public float f(e eVar) {
        return n(eVar).d();
    }

    @Override // a.c.a.f
    public float g(e eVar) {
        return f(eVar) * 2.0f;
    }

    @Override // a.c.a.f
    public float h(e eVar) {
        return f(eVar) * 2.0f;
    }

    @Override // a.c.a.f
    public void i(e eVar) {
        m(eVar, a(eVar));
    }

    @Override // a.c.a.f
    public void j(e eVar, float f) {
        eVar.b().setElevation(f);
    }

    @Override // a.c.a.f
    public void k(e eVar) {
        m(eVar, a(eVar));
    }

    @Override // a.c.a.f
    public void l(e eVar, ColorStateList colorStateList) {
        n(eVar).f(colorStateList);
    }

    @Override // a.c.a.f
    public void m(e eVar, float f) {
        n(eVar).g(f, eVar.e(), eVar.d());
        o(eVar);
    }

    public void o(e eVar) {
        if (!eVar.e()) {
            eVar.a(0, 0, 0, 0);
            return;
        }
        float a2 = a(eVar);
        float f = f(eVar);
        int ceil = (int) Math.ceil(h.c(a2, f, eVar.d()));
        int ceil2 = (int) Math.ceil(h.d(a2, f, eVar.d()));
        eVar.a(ceil, ceil2, ceil, ceil2);
    }
}
