package com.google.android.gms.common.api.internal;

import android.os.Bundle;
/* loaded from: classes.dex */
final class r0 implements Runnable {
    private final /* synthetic */ LifecycleCallback f;
    private final /* synthetic */ String g;
    private final /* synthetic */ q0 h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0(q0 q0Var, LifecycleCallback lifecycleCallback, String str) {
        this.h = q0Var;
        this.f = lifecycleCallback;
        this.g = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        i = this.h.g;
        if (i > 0) {
            LifecycleCallback lifecycleCallback = this.f;
            bundle = this.h.h;
            if (bundle != null) {
                bundle3 = this.h.h;
                bundle2 = bundle3.getBundle(this.g);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.e(bundle2);
        }
        i2 = this.h.g;
        if (i2 >= 2) {
            this.f.i();
        }
        i3 = this.h.g;
        if (i3 >= 3) {
            this.f.g();
        }
        i4 = this.h.g;
        if (i4 >= 4) {
            this.f.j();
        }
        i5 = this.h.g;
        if (i5 >= 5) {
            this.f.f();
        }
    }
}
