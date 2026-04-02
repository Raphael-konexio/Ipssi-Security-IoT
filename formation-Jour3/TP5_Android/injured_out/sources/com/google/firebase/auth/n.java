package com.google.firebase.auth;

import b.c.a.a.d.c.q1;
import java.util.List;
/* loaded from: classes.dex */
public abstract class n extends com.google.android.gms.common.internal.w.a implements y {
    public abstract List<? extends y> b();

    public abstract String c();

    public abstract boolean h();

    public b.c.a.a.f.g<Object> j(b bVar) {
        com.google.android.gms.common.internal.r.h(bVar);
        return FirebaseAuth.getInstance(t()).r(this, bVar);
    }

    public b.c.a.a.f.g<Object> k(b bVar) {
        com.google.android.gms.common.internal.r.h(bVar);
        return FirebaseAuth.getInstance(t()).n(this, bVar);
    }

    public abstract n n(List<? extends y> list);

    public abstract List<String> o();

    public abstract void p(q1 q1Var);

    public abstract n q();

    public abstract void r(List<u0> list);

    public abstract b.c.c.c t();

    public abstract String v();

    public abstract q1 w();

    public abstract String x();

    public abstract String y();

    public abstract v0 z();
}
