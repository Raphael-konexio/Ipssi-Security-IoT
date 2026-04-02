package com.google.firebase.auth.z.a;

import android.text.TextUtils;
import com.google.android.gms.common.api.internal.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends z0<com.google.firebase.auth.p, com.google.firebase.auth.internal.c> {
    private final b.c.a.a.d.c.m0 y;

    public k(String str) {
        super(1);
        com.google.android.gms.common.internal.r.g(str, "refresh token cannot be null");
        this.y = new b.c.a.a.d.c.m0(str);
    }

    @Override // com.google.firebase.auth.z.a.e
    public final com.google.android.gms.common.api.internal.m<n0, com.google.firebase.auth.p> a() {
        m.a a2 = com.google.android.gms.common.api.internal.m.a();
        a2.c(false);
        a2.d((this.t || this.u) ? null : new b.c.a.a.b.c[]{b.c.a.a.d.c.f1.f1252b});
        a2.b(new com.google.android.gms.common.api.internal.k(this) { // from class: com.google.firebase.auth.z.a.j

            /* renamed from: a  reason: collision with root package name */
            private final k f1940a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1940a = this;
            }

            @Override // com.google.android.gms.common.api.internal.k
            public final void accept(Object obj, Object obj2) {
                this.f1940a.q((n0) obj, (b.c.a.a.f.h) obj2);
            }
        });
        return a2.a();
    }

    @Override // com.google.firebase.auth.z.a.e
    public final String c() {
        return "getAccessToken";
    }

    @Override // com.google.firebase.auth.z.a.z0
    public final void o() {
        if (TextUtils.isEmpty(this.j.j())) {
            this.j.b(this.y.b());
        }
        ((com.google.firebase.auth.internal.c) this.e).a(this.j, this.f1962d);
        n(com.google.firebase.auth.internal.k.a(this.j.k()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void q(n0 n0Var, b.c.a.a.f.h hVar) {
        this.g = new i1(this, hVar);
        boolean z = this.t;
        s0 c2 = n0Var.c();
        if (z) {
            c2.L(this.y.b(), this.f1960b);
        } else {
            c2.M(this.y, this.f1960b);
        }
    }
}
