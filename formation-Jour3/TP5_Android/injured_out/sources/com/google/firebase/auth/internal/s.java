package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ p f1910a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.f1910a = pVar;
    }

    @Override // com.google.android.gms.common.api.internal.c.a
    public final void a(boolean z) {
        boolean g;
        d dVar;
        if (z) {
            this.f1910a.f1903c = true;
            this.f1910a.a();
            return;
        }
        this.f1910a.f1903c = false;
        g = this.f1910a.g();
        if (g) {
            dVar = this.f1910a.f1902b;
            dVar.a();
        }
    }
}
