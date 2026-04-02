package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import com.google.crypto.tink.shaded.protobuf.Reader;
/* loaded from: classes.dex */
class z0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static z0 o;
    private static z0 p;
    private final View f;
    private final CharSequence g;
    private final int h;
    private final Runnable i = new a();
    private final Runnable j = new b();
    private int k;
    private int l;
    private a1 m;
    private boolean n;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z0.this.g(false);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z0.this.c();
        }
    }

    private z0(View view, CharSequence charSequence) {
        this.f = view;
        this.g = charSequence;
        this.h = a.g.k.t.c(ViewConfiguration.get(view.getContext()));
        b();
        this.f.setOnLongClickListener(this);
        this.f.setOnHoverListener(this);
    }

    private void a() {
        this.f.removeCallbacks(this.i);
    }

    private void b() {
        this.k = Reader.READ_DONE;
        this.l = Reader.READ_DONE;
    }

    private void d() {
        this.f.postDelayed(this.i, ViewConfiguration.getLongPressTimeout());
    }

    private static void e(z0 z0Var) {
        z0 z0Var2 = o;
        if (z0Var2 != null) {
            z0Var2.a();
        }
        o = z0Var;
        if (z0Var != null) {
            z0Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        z0 z0Var = o;
        if (z0Var != null && z0Var.f == view) {
            e(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new z0(view, charSequence);
            return;
        }
        z0 z0Var2 = p;
        if (z0Var2 != null && z0Var2.f == view) {
            z0Var2.c();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean h(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.k) > this.h || Math.abs(y - this.l) > this.h) {
            this.k = x;
            this.l = y;
            return true;
        }
        return false;
    }

    void c() {
        if (p == this) {
            p = null;
            a1 a1Var = this.m;
            if (a1Var != null) {
                a1Var.c();
                this.m = null;
                b();
                this.f.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (o == this) {
            e(null);
        }
        this.f.removeCallbacks(this.j);
    }

    void g(boolean z) {
        long longPressTimeout;
        if (a.g.k.s.L(this.f)) {
            e(null);
            z0 z0Var = p;
            if (z0Var != null) {
                z0Var.c();
            }
            p = this;
            this.n = z;
            a1 a1Var = new a1(this.f.getContext());
            this.m = a1Var;
            a1Var.e(this.f, this.k, this.l, this.n, this.g);
            this.f.addOnAttachStateChangeListener(this);
            if (this.n) {
                longPressTimeout = 2500;
            } else {
                longPressTimeout = ((a.g.k.s.F(this.f) & 1) == 1 ? 3000L : 15000L) - ViewConfiguration.getLongPressTimeout();
            }
            this.f.removeCallbacks(this.j);
            this.f.postDelayed(this.j, longPressTimeout);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.m == null || !this.n) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.f.getContext().getSystemService("accessibility");
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action == 10) {
                    b();
                    c();
                }
            } else if (this.f.isEnabled() && this.m == null && h(motionEvent)) {
                e(this);
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.k = view.getWidth() / 2;
        this.l = view.getHeight() / 2;
        g(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
