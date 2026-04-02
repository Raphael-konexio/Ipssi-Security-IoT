package androidx.lifecycle;

import androidx.lifecycle.e;
import kotlinx.coroutines.a;
/* loaded from: classes.dex */
final class LifecycleController$observer$1 implements h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f859a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ kotlinx.coroutines.a f860b;

    @Override // androidx.lifecycle.h
    public final void d(j jVar, e.a aVar) {
        e.b bVar;
        b bVar2;
        b bVar3;
        d.s.d.g.f(jVar, "source");
        d.s.d.g.f(aVar, "<anonymous parameter 1>");
        e a2 = jVar.a();
        d.s.d.g.b(a2, "source.lifecycle");
        if (a2.b() == e.b.DESTROYED) {
            f fVar = this.f859a;
            a.C0132a.a(this.f860b, null, 1, null);
            fVar.c();
            throw null;
        }
        e a3 = jVar.a();
        d.s.d.g.b(a3, "source.lifecycle");
        e.b b2 = a3.b();
        bVar = this.f859a.f887a;
        if (b2.compareTo(bVar) < 0) {
            bVar3 = this.f859a.f888b;
            bVar3.a();
            throw null;
        }
        bVar2 = this.f859a.f888b;
        bVar2.b();
        throw null;
    }
}
