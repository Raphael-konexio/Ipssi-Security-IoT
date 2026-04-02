package com.google.android.gms.common.api.internal;

import android.os.Bundle;
/* loaded from: classes.dex */
final class t0 implements Runnable {
    private final /* synthetic */ LifecycleCallback f;
    private final /* synthetic */ String g;
    private final /* synthetic */ s0 h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t0(s0 s0Var, LifecycleCallback lifecycleCallback, String str) {
        this.h = s0Var;
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
        i = this.h.c0;
        if (i > 0) {
            LifecycleCallback lifecycleCallback = this.f;
            bundle = this.h.d0;
            if (bundle != null) {
                bundle3 = this.h.d0;
                bundle2 = bundle3.getBundle(this.g);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.e(bundle2);
        }
        i2 = this.h.c0;
        if (i2 >= 2) {
            this.f.i();
        }
        i3 = this.h.c0;
        if (i3 >= 3) {
            this.f.g();
        }
        i4 = this.h.c0;
        if (i4 >= 4) {
            this.f.j();
        }
        i5 = this.h.c0;
        if (i5 >= 5) {
            this.f.f();
        }
    }
}
