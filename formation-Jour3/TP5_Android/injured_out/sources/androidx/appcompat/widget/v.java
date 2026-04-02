package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
/* loaded from: classes.dex */
class v extends r {

    /* renamed from: d  reason: collision with root package name */
    private final SeekBar f654d;
    private Drawable e;
    private ColorStateList f;
    private PorterDuff.Mode g;
    private boolean h;
    private boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SeekBar seekBar) {
        super(seekBar);
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = false;
        this.f654d = seekBar;
    }

    private void f() {
        if (this.e != null) {
            if (this.h || this.i) {
                Drawable r = androidx.core.graphics.drawable.a.r(this.e.mutate());
                this.e = r;
                if (this.h) {
                    androidx.core.graphics.drawable.a.o(r, this.f);
                }
                if (this.i) {
                    androidx.core.graphics.drawable.a.p(this.e, this.g);
                }
                if (this.e.isStateful()) {
                    this.e.setState(this.f654d.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.r
    public void c(AttributeSet attributeSet, int i) {
        super.c(attributeSet, i);
        w0 u = w0.u(this.f654d.getContext(), attributeSet, a.a.j.AppCompatSeekBar, i, 0);
        Drawable h = u.h(a.a.j.AppCompatSeekBar_android_thumb);
        if (h != null) {
            this.f654d.setThumb(h);
        }
        j(u.g(a.a.j.AppCompatSeekBar_tickMark));
        if (u.r(a.a.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.g = e0.d(u.k(a.a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.g);
            this.i = true;
        }
        if (u.r(a.a.j.AppCompatSeekBar_tickMarkTint)) {
            this.f = u.c(a.a.j.AppCompatSeekBar_tickMarkTint);
            this.h = true;
        }
        u.v();
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        if (this.e != null) {
            int max = this.f654d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.e.getIntrinsicWidth();
                int intrinsicHeight = this.e.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.e.setBounds(-i, -i2, i, i2);
                float width = ((this.f654d.getWidth() - this.f654d.getPaddingLeft()) - this.f654d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f654d.getPaddingLeft(), this.f654d.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f654d.getDrawableState())) {
            this.f654d.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f654d);
            androidx.core.graphics.drawable.a.m(drawable, a.g.k.s.w(this.f654d));
            if (drawable.isStateful()) {
                drawable.setState(this.f654d.getDrawableState());
            }
            f();
        }
        this.f654d.invalidate();
    }
}
