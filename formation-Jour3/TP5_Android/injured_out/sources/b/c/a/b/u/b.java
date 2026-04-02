package b.c.a.b.u;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final View f1374a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1375b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f1376c = 0;

    public b(a aVar) {
        this.f1374a = (View) aVar;
    }

    private void a() {
        ViewParent parent = this.f1374a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).g(this.f1374a);
        }
    }

    public int b() {
        return this.f1376c;
    }

    public boolean c() {
        return this.f1375b;
    }

    public void d(Bundle bundle) {
        this.f1375b = bundle.getBoolean("expanded", false);
        this.f1376c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f1375b) {
            a();
        }
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f1375b);
        bundle.putInt("expandedComponentIdHint", this.f1376c);
        return bundle;
    }

    public void f(int i) {
        this.f1376c = i;
    }
}
