package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.e;
/* loaded from: classes.dex */
public final class l0 extends j0<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    private final h<?> f1569b;

    public l0(h<?> hVar, b.c.a.a.f.h<Boolean> hVar2) {
        super(4, hVar2);
        this.f1569b = hVar;
    }

    @Override // com.google.android.gms.common.api.internal.a0
    public final /* bridge */ /* synthetic */ void c(p0 p0Var, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.r
    public final b.c.a.a.b.c[] g(e.a<?> aVar) {
        z zVar = aVar.x().get(this.f1569b);
        if (zVar == null) {
            return null;
        }
        return zVar.f1590a.b();
    }

    @Override // com.google.android.gms.common.api.internal.r
    public final boolean h(e.a<?> aVar) {
        z zVar = aVar.x().get(this.f1569b);
        if (zVar == null) {
            return false;
        }
        zVar.f1590a.d();
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.j0
    public final void i(e.a<?> aVar) {
        z remove = aVar.x().remove(this.f1569b);
        if (remove == null) {
            this.f1565a.e(Boolean.FALSE);
            return;
        }
        remove.f1591b.a(aVar.o(), this.f1565a);
        remove.f1590a.a();
    }
}
