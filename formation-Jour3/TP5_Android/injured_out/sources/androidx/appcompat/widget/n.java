package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f624a;

    /* renamed from: b  reason: collision with root package name */
    private u0 f625b;

    /* renamed from: c  reason: collision with root package name */
    private u0 f626c;

    /* renamed from: d  reason: collision with root package name */
    private u0 f627d;

    public n(ImageView imageView) {
        this.f624a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f627d == null) {
            this.f627d = new u0();
        }
        u0 u0Var = this.f627d;
        u0Var.a();
        ColorStateList a2 = androidx.core.widget.e.a(this.f624a);
        if (a2 != null) {
            u0Var.f653d = true;
            u0Var.f650a = a2;
        }
        PorterDuff.Mode b2 = androidx.core.widget.e.b(this.f624a);
        if (b2 != null) {
            u0Var.f652c = true;
            u0Var.f651b = b2;
        }
        if (u0Var.f653d || u0Var.f652c) {
            j.i(drawable, u0Var, this.f624a.getDrawableState());
            return true;
        }
        return false;
    }

    private boolean j() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f625b != null : i == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.f624a.getDrawable();
        if (drawable != null) {
            e0.b(drawable);
        }
        if (drawable != null) {
            if (j() && a(drawable)) {
                return;
            }
            u0 u0Var = this.f626c;
            if (u0Var != null) {
                j.i(drawable, u0Var, this.f624a.getDrawableState());
                return;
            }
            u0 u0Var2 = this.f625b;
            if (u0Var2 != null) {
                j.i(drawable, u0Var2, this.f624a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        u0 u0Var = this.f626c;
        if (u0Var != null) {
            return u0Var.f650a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        u0 u0Var = this.f626c;
        if (u0Var != null) {
            return u0Var.f651b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return Build.VERSION.SDK_INT < 21 || !(this.f624a.getBackground() instanceof RippleDrawable);
    }

    public void f(AttributeSet attributeSet, int i) {
        int n;
        w0 u = w0.u(this.f624a.getContext(), attributeSet, a.a.j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f624a.getDrawable();
            if (drawable == null && (n = u.n(a.a.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = a.a.k.a.a.d(this.f624a.getContext(), n)) != null) {
                this.f624a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                e0.b(drawable);
            }
            if (u.r(a.a.j.AppCompatImageView_tint)) {
                androidx.core.widget.e.c(this.f624a, u.c(a.a.j.AppCompatImageView_tint));
            }
            if (u.r(a.a.j.AppCompatImageView_tintMode)) {
                androidx.core.widget.e.d(this.f624a, e0.d(u.k(a.a.j.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            u.v();
        }
    }

    public void g(int i) {
        if (i != 0) {
            Drawable d2 = a.a.k.a.a.d(this.f624a.getContext(), i);
            if (d2 != null) {
                e0.b(d2);
            }
            this.f624a.setImageDrawable(d2);
        } else {
            this.f624a.setImageDrawable(null);
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (this.f626c == null) {
            this.f626c = new u0();
        }
        u0 u0Var = this.f626c;
        u0Var.f650a = colorStateList;
        u0Var.f653d = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(PorterDuff.Mode mode) {
        if (this.f626c == null) {
            this.f626c = new u0();
        }
        u0 u0Var = this.f626c;
        u0Var.f651b = mode;
        u0Var.f652c = true;
        b();
    }
}
