package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class LifecycleCallback {
    protected final g f;

    /* JADX INFO: Access modifiers changed from: protected */
    public LifecycleCallback(g gVar) {
        this.f = gVar;
    }

    public static g b(Activity activity) {
        return c(new f(activity));
    }

    protected static g c(f fVar) {
        if (fVar.c()) {
            return s0.r1(fVar.b());
        }
        if (fVar.d()) {
            return q0.d(fVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    private static g getChimeraLifecycleFragmentImpl(f fVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void d(int i, int i2, Intent intent) {
    }

    public void e(Bundle bundle) {
    }

    public void f() {
    }

    public void g() {
    }

    public void h(Bundle bundle) {
    }

    public void i() {
    }

    public void j() {
    }
}
