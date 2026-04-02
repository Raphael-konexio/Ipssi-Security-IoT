package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class s0 extends Fragment implements g {
    private static WeakHashMap<androidx.fragment.app.d, WeakReference<s0>> e0 = new WeakHashMap<>();
    private Map<String, LifecycleCallback> b0 = new a.d.a();
    private int c0 = 0;
    private Bundle d0;

    public static s0 r1(androidx.fragment.app.d dVar) {
        s0 s0Var;
        WeakReference<s0> weakReference = e0.get(dVar);
        if (weakReference == null || (s0Var = weakReference.get()) == null) {
            try {
                s0 s0Var2 = (s0) dVar.n().X("SupportLifecycleFragmentImpl");
                if (s0Var2 == null || s0Var2.U()) {
                    s0Var2 = new s0();
                    androidx.fragment.app.t i = dVar.n().i();
                    i.d(s0Var2, "SupportLifecycleFragmentImpl");
                    i.i();
                }
                e0.put(dVar, new WeakReference<>(s0Var2));
                return s0Var2;
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
            }
        }
        return s0Var;
    }

    @Override // androidx.fragment.app.Fragment
    public final void A0(Bundle bundle) {
        super.A0(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.b0.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().h(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void B0() {
        super.B0();
        this.c0 = 2;
        for (LifecycleCallback lifecycleCallback : this.b0.values()) {
            lifecycleCallback.i();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void C0() {
        super.C0();
        this.c0 = 4;
        for (LifecycleCallback lifecycleCallback : this.b0.values()) {
            lifecycleCallback.j();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void Z(int i, int i2, Intent intent) {
        super.Z(i, i2, intent);
        for (LifecycleCallback lifecycleCallback : this.b0.values()) {
            lifecycleCallback.d(i, i2, intent);
        }
    }

    @Override // com.google.android.gms.common.api.internal.g
    public final void b(String str, LifecycleCallback lifecycleCallback) {
        if (this.b0.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
            sb.append("LifecycleCallback with tag ");
            sb.append(str);
            sb.append(" already added to this fragment.");
            throw new IllegalArgumentException(sb.toString());
        }
        this.b0.put(str, lifecycleCallback);
        if (this.c0 > 0) {
            new b.c.a.a.d.b.d(Looper.getMainLooper()).post(new t0(this, lifecycleCallback, str));
        }
    }

    @Override // com.google.android.gms.common.api.internal.g
    public final <T extends LifecycleCallback> T c(String str, Class<T> cls) {
        return cls.cast(this.b0.get(str));
    }

    @Override // androidx.fragment.app.Fragment
    public final void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.e(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.b0.values()) {
            lifecycleCallback.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void e0(Bundle bundle) {
        super.e0(bundle);
        this.c0 = 1;
        this.d0 = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.b0.entrySet()) {
            entry.getValue().e(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void j0() {
        super.j0();
        this.c0 = 5;
        for (LifecycleCallback lifecycleCallback : this.b0.values()) {
            lifecycleCallback.f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void z0() {
        super.z0();
        this.c0 = 3;
        for (LifecycleCallback lifecycleCallback : this.b0.values()) {
            lifecycleCallback.g();
        }
    }
}
