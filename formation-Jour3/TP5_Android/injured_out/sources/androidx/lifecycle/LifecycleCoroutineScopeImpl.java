package androidx.lifecycle;

import androidx.lifecycle.e;
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends g implements h {

    /* renamed from: a  reason: collision with root package name */
    private final e f861a;

    /* renamed from: b  reason: collision with root package name */
    private final d.p.d f862b;

    @Override // androidx.lifecycle.h
    public void d(j jVar, e.a aVar) {
        d.s.d.g.f(jVar, "source");
        d.s.d.g.f(aVar, "event");
        if (i().b().compareTo(e.b.DESTROYED) <= 0) {
            i().c(this);
            kotlinx.coroutines.c.b(h(), null, 1, null);
        }
    }

    public d.p.d h() {
        return this.f862b;
    }

    public e i() {
        return this.f861a;
    }
}
