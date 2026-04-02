package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import b.c.a.b.a0.k;
/* loaded from: classes.dex */
class c extends b.c.a.b.a0.g {
    private final Paint B;
    private final RectF C;
    private int D;

    c() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(k kVar) {
        super(kVar == null ? new k() : kVar);
        this.B = new Paint(1);
        n0();
        this.C = new RectF();
    }

    private void h0(Canvas canvas) {
        if (o0(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.D);
    }

    private void i0(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (!o0(callback)) {
            k0(canvas);
            return;
        }
        View view = (View) callback;
        if (view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    private void k0(Canvas canvas) {
        this.D = Build.VERSION.SDK_INT >= 21 ? canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null) : canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
    }

    private void n0() {
        this.B.setStyle(Paint.Style.FILL_AND_STROKE);
        this.B.setColor(-1);
        this.B.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean o0(Drawable.Callback callback) {
        return callback instanceof View;
    }

    @Override // b.c.a.b.a0.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        i0(canvas);
        super.draw(canvas);
        canvas.drawRect(this.C, this.B);
        h0(canvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g0() {
        return !this.C.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j0() {
        l0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void l0(float f, float f2, float f3, float f4) {
        RectF rectF = this.C;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        this.C.set(f, f2, f3, f4);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m0(RectF rectF) {
        l0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
