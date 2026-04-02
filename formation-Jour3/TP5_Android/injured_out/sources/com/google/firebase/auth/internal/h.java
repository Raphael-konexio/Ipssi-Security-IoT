package com.google.firebase.auth.internal;

import android.content.Context;
import com.google.firebase.auth.FirebaseAuth;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: b  reason: collision with root package name */
    private static final h f1895b = new h();

    /* renamed from: a  reason: collision with root package name */
    private final n f1896a;

    private h() {
        this(n.a(), f.a());
    }

    private h(n nVar, f fVar) {
        this.f1896a = nVar;
    }

    public static h a() {
        return f1895b;
    }

    public final void b(Context context) {
        this.f1896a.b(context);
    }

    public final void c(FirebaseAuth firebaseAuth) {
        this.f1896a.f(firebaseAuth);
    }
}
