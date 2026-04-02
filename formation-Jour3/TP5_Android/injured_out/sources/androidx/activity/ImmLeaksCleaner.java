package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
final class ImmLeaksCleaner implements h {

    /* renamed from: b  reason: collision with root package name */
    private static int f459b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f460c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f461d;
    private static Field e;

    /* renamed from: a  reason: collision with root package name */
    private Activity f462a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmLeaksCleaner(Activity activity) {
        this.f462a = activity;
    }

    private static void h() {
        try {
            f459b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f461d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f460c = declaredField3;
            declaredField3.setAccessible(true);
            f459b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.h
    public void d(j jVar, e.a aVar) {
        if (aVar != e.a.ON_DESTROY) {
            return;
        }
        if (f459b == 0) {
            h();
        }
        if (f459b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f462a.getSystemService("input_method");
            try {
                Object obj = f460c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f461d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
