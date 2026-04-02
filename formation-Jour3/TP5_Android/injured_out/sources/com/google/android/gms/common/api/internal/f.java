package com.google.android.gms.common.api.internal;

import android.app.Activity;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1560a;

    public f(Activity activity) {
        com.google.android.gms.common.internal.r.i(activity, "Activity must not be null");
        this.f1560a = activity;
    }

    public Activity a() {
        return (Activity) this.f1560a;
    }

    public androidx.fragment.app.d b() {
        return (androidx.fragment.app.d) this.f1560a;
    }

    public boolean c() {
        return this.f1560a instanceof androidx.fragment.app.d;
    }

    public final boolean d() {
        return this.f1560a instanceof Activity;
    }
}
