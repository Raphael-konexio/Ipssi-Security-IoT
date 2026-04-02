package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.app.e;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.lifecycle.k;
import androidx.lifecycle.r;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.savedstate.SavedStateRegistry;
/* loaded from: classes.dex */
public class ComponentActivity extends e implements j, w, androidx.savedstate.b, c {
    private v i;
    private int k;
    private final k g = new k(this);
    private final androidx.savedstate.a h = androidx.savedstate.a.a(this);
    private final OnBackPressedDispatcher j = new OnBackPressedDispatcher(new a());

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        Object f457a;

        /* renamed from: b  reason: collision with root package name */
        v f458b;

        b() {
        }
    }

    public ComponentActivity() {
        if (a() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            a().a(new h() { // from class: androidx.activity.ComponentActivity.2
                @Override // androidx.lifecycle.h
                public void d(j jVar, e.a aVar) {
                    if (aVar == e.a.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView != null) {
                            peekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        a().a(new h() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.h
            public void d(j jVar, e.a aVar) {
                if (aVar != e.a.ON_DESTROY || ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                ComponentActivity.this.f().a();
            }
        });
        int i = Build.VERSION.SDK_INT;
        if (19 > i || i > 23) {
            return;
        }
        a().a(new ImmLeaksCleaner(this));
    }

    @Override // androidx.lifecycle.j
    public androidx.lifecycle.e a() {
        return this.g;
    }

    @Override // androidx.lifecycle.w
    public v f() {
        if (getApplication() != null) {
            if (this.i == null) {
                b bVar = (b) getLastNonConfigurationInstance();
                if (bVar != null) {
                    this.i = bVar.f458b;
                }
                if (this.i == null) {
                    this.i = new v();
                }
            }
            return this.i;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // androidx.activity.c
    public final OnBackPressedDispatcher i() {
        return this.j;
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry j() {
        return this.h.b();
    }

    @Deprecated
    public Object k() {
        return null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.j.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h.c(bundle);
        r.f(this);
        int i = this.k;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        b bVar;
        Object k = k();
        v vVar = this.i;
        if (vVar == null && (bVar = (b) getLastNonConfigurationInstance()) != null) {
            vVar = bVar.f458b;
        }
        if (vVar == null && k == null) {
            return null;
        }
        b bVar2 = new b();
        bVar2.f457a = k;
        bVar2.f458b = vVar;
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.e, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.e a2 = a();
        if (a2 instanceof k) {
            ((k) a2).p(e.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.h.d(bundle);
    }
}
