package com.google.firebase.auth.z.a;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w extends z0<Object, com.google.firebase.auth.internal.c> {
    private final b.c.a.a.d.c.a1 y;

    public w(com.google.firebase.auth.c cVar) {
        super(2);
        com.google.android.gms.common.internal.r.i(cVar, "credential cannot be null or empty");
        this.y = new b.c.a.a.d.c.a1(cVar);
    }

    @Override // com.google.firebase.auth.z.a.e
    public final com.google.android.gms.common.api.internal.m<n0, Object> a() {
        m.a a2 = com.google.android.gms.common.api.internal.m.a();
        a2.c(false);
        a2.d((this.t || this.u) ? null : new b.c.a.a.b.c[]{b.c.a.a.d.c.f1.f1252b});
        a2.b(new com.google.android.gms.common.api.internal.k(this) { // from class: com.google.firebase.auth.z.a.v

            /* renamed from: a  reason: collision with root package name */
            private final w f1955a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1955a = this;
            }

            @Override // com.google.android.gms.common.api.internal.k
            public final void accept(Object obj, Object obj2) {
                this.f1955a.q((n0) obj, (b.c.a.a.f.h) obj2);
            }
        });
        return a2.a();
    }

    @Override // com.google.firebase.auth.z.a.e
    public final String c() {
        return "reauthenticateWithEmailLinkWithData";
    }

    @Override // com.google.firebase.auth.z.a.z0
    public final void o() {
        com.google.firebase.auth.internal.d0 n = i.n(this.f1961c, this.k);
        if (!this.f1962d.c().equalsIgnoreCase(n.c())) {
            i(new Status(17024));
            return;
        }
        ((com.google.firebase.auth.internal.c) this.e).a(this.j, n);
        n(new com.google.firebase.auth.internal.x(n));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void q(n0 n0Var, b.c.a.a.f.h hVar) {
        this.g = new i1(this, hVar);
        boolean z = this.t;
        s0 c2 = n0Var.c();
        if (z) {
            c2.W(this.y.b(), this.f1960b);
        } else {
            c2.K(this.y, this.f1960b);
        }
    }
}
