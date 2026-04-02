package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u implements Runnable {
    private final /* synthetic */ e.a f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(e.a aVar) {
        this.f = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f.u();
    }
}
