package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ e f1585a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(e eVar) {
        this.f1585a = eVar;
    }

    @Override // com.google.android.gms.common.api.internal.c.a
    public final void a(boolean z) {
        this.f1585a.m.sendMessage(this.f1585a.m.obtainMessage(1, Boolean.valueOf(z)));
    }
}
