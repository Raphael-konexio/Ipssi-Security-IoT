package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.internal.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w implements c.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e.a f1586a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(e.a aVar) {
        this.f1586a = aVar;
    }

    @Override // com.google.android.gms.common.internal.c.e
    public final void a() {
        e.this.m.post(new v(this));
    }
}
