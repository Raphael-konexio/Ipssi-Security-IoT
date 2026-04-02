package com.google.firebase.auth.z.a;

import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
final class e1 implements g1 {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Status f1930a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e1(b1 b1Var, Status status) {
        this.f1930a = status;
    }

    @Override // com.google.firebase.auth.z.a.g1
    public final void a(com.google.firebase.auth.v vVar, Object... objArr) {
        vVar.d(o0.a(this.f1930a));
    }
}
