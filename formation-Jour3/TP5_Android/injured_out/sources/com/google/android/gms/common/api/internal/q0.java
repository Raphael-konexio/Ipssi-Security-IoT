package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class q0 extends Fragment implements g {
    private static WeakHashMap<Activity, WeakReference<q0>> i = new WeakHashMap<>();
    private Map<String, LifecycleCallback> f = new a.d.a();
    private int g = 0;
    private Bundle h;

    public static q0 d(Activity activity) {
        q0 q0Var;
        WeakReference<q0> weakReference = i.get(activity);
        if (weakReference == null || (q0Var = weakReference.get()) == null) {
            try {
                q0 q0Var2 = (q0) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                if (q0Var2 == null || q0Var2.isRemoving()) {
                    q0Var2 = new q0();
                    activity.getFragmentManager().beginTransaction().add(q0Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
                }
                i.put(activity, new WeakReference<>(q0Var2));
                return q0Var2;
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
            }
        }
        return q0Var;
    }

    @Override // com.google.android.gms.common.api.internal.g
    public final void b(String str, LifecycleCallback lifecycleCallback) {
        if (this.f.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
            sb.append("LifecycleCallback with tag ");
            sb.append(str);
            sb.append(" already added to this fragment.");
            throw new IllegalArgumentException(sb.toString());
        }
        this.f.put(str, lifecycleCallback);
        if (this.g > 0) {
            new b.c.a.a.d.b.d(Looper.getMainLooper()).post(new r0(this, lifecycleCallback, str));
        }
    }

    @Override // com.google.android.gms.common.api.internal.g
    public final <T extends LifecycleCallback> T c(String str, Class<T> cls) {
        return cls.cast(this.f.get(str));
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.f.values()) {
            lifecycleCallback.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (LifecycleCallback lifecycleCallback : this.f.values()) {
            lifecycleCallback.d(i2, i3, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g = 1;
        this.h = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f.entrySet()) {
            entry.getValue().e(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.g = 5;
        for (LifecycleCallback lifecycleCallback : this.f.values()) {
            lifecycleCallback.f();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.g = 3;
        for (LifecycleCallback lifecycleCallback : this.f.values()) {
            lifecycleCallback.g();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.f.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().h(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.g = 2;
        for (LifecycleCallback lifecycleCallback : this.f.values()) {
            lifecycleCallback.i();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.g = 4;
        for (LifecycleCallback lifecycleCallback : this.f.values()) {
            lifecycleCallback.j();
        }
    }
}
