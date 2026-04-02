package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.e;
/* loaded from: classes.dex */
final class t implements Runnable {
    private final /* synthetic */ e.a f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(e.a aVar) {
        this.f = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f.t();
    }
}
