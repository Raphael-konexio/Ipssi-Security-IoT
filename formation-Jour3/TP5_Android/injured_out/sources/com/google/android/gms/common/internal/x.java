package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x extends f {
    private final /* synthetic */ Intent f;
    private final /* synthetic */ Activity g;
    private final /* synthetic */ int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Intent intent, Activity activity, int i) {
        this.f = intent;
        this.g = activity;
        this.h = i;
    }

    @Override // com.google.android.gms.common.internal.f
    public final void b() {
        Intent intent = this.f;
        if (intent != null) {
            this.g.startActivityForResult(intent, this.h);
        }
    }
}
