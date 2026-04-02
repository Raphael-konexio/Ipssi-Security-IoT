package a.c.a;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class a extends FrameLayout {
    private static final f j;
    private boolean f;
    private boolean g;
    final Rect h;
    private final e i;

    static {
        int i = Build.VERSION.SDK_INT;
        j = i >= 21 ? new c() : i >= 17 ? new b() : new d();
        j.e();
    }

    public ColorStateList getCardBackgroundColor() {
        return j.b(this.i);
    }

    public float getCardElevation() {
        return j.d(this.i);
    }

    public int getContentPaddingBottom() {
        return this.h.bottom;
    }

    public int getContentPaddingLeft() {
        return this.h.left;
    }

    public int getContentPaddingRight() {
        return this.h.right;
    }

    public int getContentPaddingTop() {
        return this.h.top;
    }

    public float getMaxCardElevation() {
        return j.a(this.i);
    }

    public boolean getPreventCornerOverlap() {
        return this.g;
    }

    public float getRadius() {
        return j.f(this.i);
    }

    public boolean getUseCompatPadding() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (!(j instanceof c)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(j.h(this.i)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(j.g(this.i)), View.MeasureSpec.getSize(i2)), mode2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        j.l(this.i, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        j.l(this.i, colorStateList);
    }

    public void setCardElevation(float f) {
        j.j(this.i, f);
    }

    public void setMaxCardElevation(float f) {
        j.m(this.i, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.g) {
            this.g = z;
            j.k(this.i);
        }
    }

    public void setRadius(float f) {
        j.c(this.i, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f != z) {
            this.f = z;
            j.i(this.i);
        }
    }
}
