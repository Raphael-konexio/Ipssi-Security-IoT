package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    private final View f599a;

    /* renamed from: d  reason: collision with root package name */
    private u0 f602d;
    private u0 e;
    private u0 f;

    /* renamed from: c  reason: collision with root package name */
    private int f601c = -1;

    /* renamed from: b  reason: collision with root package name */
    private final j f600b = j.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(View view) {
        this.f599a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f == null) {
            this.f = new u0();
        }
        u0 u0Var = this.f;
        u0Var.a();
        ColorStateList n = a.g.k.s.n(this.f599a);
        if (n != null) {
            u0Var.f653d = true;
            u0Var.f650a = n;
        }
        PorterDuff.Mode o = a.g.k.s.o(this.f599a);
        if (o != null) {
            u0Var.f652c = true;
            u0Var.f651b = o;
        }
        if (u0Var.f653d || u0Var.f652c) {
            j.i(drawable, u0Var, this.f599a.getDrawableState());
            return true;
        }
        return false;
    }

    private boolean k() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f602d != null : i == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f599a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            u0 u0Var = this.e;
            if (u0Var != null) {
                j.i(background, u0Var, this.f599a.getDrawableState());
                return;
            }
            u0 u0Var2 = this.f602d;
            if (u0Var2 != null) {
                j.i(background, u0Var2, this.f599a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        u0 u0Var = this.e;
        if (u0Var != null) {
            return u0Var.f650a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        u0 u0Var = this.e;
        if (u0Var != null) {
            return u0Var.f651b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i) {
        w0 u = w0.u(this.f599a.getContext(), attributeSet, a.a.j.ViewBackgroundHelper, i, 0);
        try {
            if (u.r(a.a.j.ViewBackgroundHelper_android_background)) {
                this.f601c = u.n(a.a.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList f = this.f600b.f(this.f599a.getContext(), this.f601c);
                if (f != null) {
                    h(f);
                }
            }
            if (u.r(a.a.j.ViewBackgroundHelper_backgroundTint)) {
                a.g.k.s.j0(this.f599a, u.c(a.a.j.ViewBackgroundHelper_backgroundTint));
            }
            if (u.r(a.a.j.ViewBackgroundHelper_backgroundTintMode)) {
                a.g.k.s.k0(this.f599a, e0.d(u.k(a.a.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            u.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f601c = -1;
        h(null);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i) {
        this.f601c = i;
        j jVar = this.f600b;
        h(jVar != null ? jVar.f(this.f599a.getContext(), i) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f602d == null) {
                this.f602d = new u0();
            }
            u0 u0Var = this.f602d;
            u0Var.f650a = colorStateList;
            u0Var.f653d = true;
        } else {
            this.f602d = null;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new u0();
        }
        u0 u0Var = this.e;
        u0Var.f650a = colorStateList;
        u0Var.f653d = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new u0();
        }
        u0 u0Var = this.e;
        u0Var.f651b = mode;
        u0Var.f652c = true;
        b();
    }
}
