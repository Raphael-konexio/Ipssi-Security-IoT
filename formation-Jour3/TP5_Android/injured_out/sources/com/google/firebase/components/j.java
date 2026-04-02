package com.google.firebase.components;

import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements b.c.c.l.a {

    /* renamed from: a  reason: collision with root package name */
    private final Set f1978a;

    private j(Set set) {
        this.f1978a = set;
    }

    public static b.c.c.l.a a(Set set) {
        return new j(set);
    }

    @Override // b.c.c.l.a
    public Object get() {
        return l.g(this.f1978a);
    }
}
