package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.b;
import b.c.a.b.a0.g;
import b.c.a.b.l.h;
import b.c.a.b.x.d;
import com.google.android.material.internal.f;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* loaded from: classes.dex */
public class a extends g implements b, Drawable.Callback, f.b {
    private static final int[] K0 = {16842910};
    private static final ShapeDrawable L0 = new ShapeDrawable(new OvalShape());
    private ColorStateList A0;
    private ColorStateList B;
    private PorterDuff.Mode B0;
    private ColorStateList C;
    private int[] C0;
    private float D;
    private boolean D0;
    private float E;
    private ColorStateList E0;
    private ColorStateList F;
    private WeakReference<InterfaceC0081a> F0;
    private float G;
    private TextUtils.TruncateAt G0;
    private ColorStateList H;
    private boolean H0;
    private CharSequence I;
    private int I0;
    private boolean J;
    private boolean J0;
    private Drawable K;
    private ColorStateList L;
    private float M;
    private boolean N;
    private boolean O;
    private Drawable P;
    private Drawable Q;
    private ColorStateList R;
    private float S;
    private CharSequence T;
    private boolean U;
    private boolean V;
    private Drawable W;
    private h X;
    private h Y;
    private float Z;
    private float a0;
    private float b0;
    private float c0;
    private float d0;
    private float e0;
    private float f0;
    private float g0;
    private final Context h0;
    private final Paint i0;
    private final Paint j0;
    private final Paint.FontMetrics k0;
    private final RectF l0;
    private final PointF m0;
    private final Path n0;
    private final f o0;
    private int p0;
    private int q0;
    private int r0;
    private int s0;
    private int t0;
    private int u0;
    private boolean v0;
    private int w0;
    private int x0;
    private ColorFilter y0;
    private PorterDuffColorFilter z0;

    /* renamed from: com.google.android.material.chip.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0081a {
        void a();
    }

    private a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.i0 = new Paint(1);
        this.k0 = new Paint.FontMetrics();
        this.l0 = new RectF();
        this.m0 = new PointF();
        this.n0 = new Path();
        this.x0 = 255;
        this.B0 = PorterDuff.Mode.SRC_IN;
        Paint paint = null;
        this.F0 = new WeakReference<>(null);
        L(context);
        this.h0 = context;
        f fVar = new f(this);
        this.o0 = fVar;
        this.I = "";
        fVar.e().density = context.getResources().getDisplayMetrics().density;
        this.j0 = null;
        if (0 != 0) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(K0);
        c2(K0);
        this.H0 = true;
        if (b.c.a.b.y.b.f1392a) {
            L0.setTint(-1);
        }
    }

    private void A0(Canvas canvas, Rect rect) {
        if (this.I != null) {
            Paint.Align p0 = p0(rect, this.m0);
            n0(rect, this.l0);
            if (this.o0.d() != null) {
                this.o0.e().drawableState = getState();
                this.o0.j(this.h0);
            }
            this.o0.e().setTextAlign(p0);
            int i = 0;
            boolean z = Math.round(this.o0.f(a1().toString())) > Math.round(this.l0.width());
            if (z) {
                i = canvas.save();
                canvas.clipRect(this.l0);
            }
            CharSequence charSequence = this.I;
            if (z && this.G0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.o0.e(), this.l0.width(), this.G0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.m0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.o0.e());
            if (z) {
                canvas.restoreToCount(i);
            }
        }
    }

    private boolean D2() {
        return this.V && this.W != null && this.v0;
    }

    private boolean E2() {
        return this.J && this.K != null;
    }

    private boolean F2() {
        return this.O && this.P != null;
    }

    private void G2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void H2() {
        this.E0 = this.D0 ? b.c.a.b.y.b.a(this.H) : null;
    }

    private void I2() {
        this.Q = new RippleDrawable(b.c.a.b.y.b.a(Y0()), this.P, L0);
    }

    private void S1(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            onStateChange(getState());
        }
    }

    private ColorFilter e1() {
        ColorFilter colorFilter = this.y0;
        return colorFilter != null ? colorFilter : this.z0;
    }

    private void g0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        androidx.core.graphics.drawable.a.m(drawable, androidx.core.graphics.drawable.a.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.P) {
            if (drawable.isStateful()) {
                drawable.setState(R0());
            }
            androidx.core.graphics.drawable.a.o(drawable, this.R);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.K;
        if (drawable == drawable2 && this.N) {
            androidx.core.graphics.drawable.a.o(drawable2, this.L);
        }
    }

    private static boolean g1(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private void h0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (E2() || D2()) {
            float f = this.Z + this.a0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f2 = rect.left + f;
                rectF.left = f2;
                rectF.right = f2 + this.M;
            } else {
                float f3 = rect.right - f;
                rectF.right = f3;
                rectF.left = f3 - this.M;
            }
            float exactCenterY = rect.exactCenterY();
            float f4 = this.M;
            float f5 = exactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    private void j0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (F2()) {
            float f = this.g0 + this.f0 + this.S + this.e0 + this.d0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.right = rect.right - f;
            } else {
                rectF.left = rect.left + f;
            }
        }
    }

    private void k0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (F2()) {
            float f = this.g0 + this.f0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f2 = rect.right - f;
                rectF.right = f2;
                rectF.left = f2 - this.S;
            } else {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + this.S;
            }
            float exactCenterY = rect.exactCenterY();
            float f4 = this.S;
            float f5 = exactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    private static boolean k1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private void l0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (F2()) {
            float f = this.g0 + this.f0 + this.S + this.e0 + this.d0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f2 = rect.right;
                rectF.right = f2;
                rectF.left = f2 - f;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean l1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean m1(d dVar) {
        ColorStateList colorStateList;
        return (dVar == null || (colorStateList = dVar.f1381b) == null || !colorStateList.isStateful()) ? false : true;
    }

    private void n0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.I != null) {
            float i0 = this.Z + i0() + this.c0;
            float m0 = this.g0 + m0() + this.d0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.left = rect.left + i0;
                rectF.right = rect.right - m0;
            } else {
                rectF.left = rect.left + m0;
                rectF.right = rect.right - i0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void n1(android.util.AttributeSet r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.a.n1(android.util.AttributeSet, int, int):void");
    }

    private float o0() {
        this.o0.e().getFontMetrics(this.k0);
        Paint.FontMetrics fontMetrics = this.k0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean p1(int[] r7, int[] r8) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.a.p1(int[], int[]):boolean");
    }

    private boolean q0() {
        return this.V && this.W != null && this.U;
    }

    public static a r0(Context context, AttributeSet attributeSet, int i, int i2) {
        a aVar = new a(context, attributeSet, i, i2);
        aVar.n1(attributeSet, i, i2);
        return aVar;
    }

    private void s0(Canvas canvas, Rect rect) {
        if (D2()) {
            h0(rect, this.l0);
            RectF rectF = this.l0;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.W.setBounds(0, 0, (int) this.l0.width(), (int) this.l0.height());
            this.W.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void t0(Canvas canvas, Rect rect) {
        if (this.J0) {
            return;
        }
        this.i0.setColor(this.q0);
        this.i0.setStyle(Paint.Style.FILL);
        this.i0.setColorFilter(e1());
        this.l0.set(rect);
        canvas.drawRoundRect(this.l0, D0(), D0(), this.i0);
    }

    private void u0(Canvas canvas, Rect rect) {
        if (E2()) {
            h0(rect, this.l0);
            RectF rectF = this.l0;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.K.setBounds(0, 0, (int) this.l0.width(), (int) this.l0.height());
            this.K.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void v0(Canvas canvas, Rect rect) {
        if (this.G <= 0.0f || this.J0) {
            return;
        }
        this.i0.setColor(this.s0);
        this.i0.setStyle(Paint.Style.STROKE);
        if (!this.J0) {
            this.i0.setColorFilter(e1());
        }
        RectF rectF = this.l0;
        float f = this.G;
        rectF.set(rect.left + (f / 2.0f), rect.top + (f / 2.0f), rect.right - (f / 2.0f), rect.bottom - (f / 2.0f));
        float f2 = this.E - (this.G / 2.0f);
        canvas.drawRoundRect(this.l0, f2, f2, this.i0);
    }

    private void w0(Canvas canvas, Rect rect) {
        if (this.J0) {
            return;
        }
        this.i0.setColor(this.p0);
        this.i0.setStyle(Paint.Style.FILL);
        this.l0.set(rect);
        canvas.drawRoundRect(this.l0, D0(), D0(), this.i0);
    }

    private void x0(Canvas canvas, Rect rect) {
        Drawable drawable;
        if (F2()) {
            k0(rect, this.l0);
            RectF rectF = this.l0;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.P.setBounds(0, 0, (int) this.l0.width(), (int) this.l0.height());
            if (b.c.a.b.y.b.f1392a) {
                this.Q.setBounds(this.P.getBounds());
                this.Q.jumpToCurrentState();
                drawable = this.Q;
            } else {
                drawable = this.P;
            }
            drawable.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void y0(Canvas canvas, Rect rect) {
        this.i0.setColor(this.t0);
        this.i0.setStyle(Paint.Style.FILL);
        this.l0.set(rect);
        if (!this.J0) {
            canvas.drawRoundRect(this.l0, D0(), D0(), this.i0);
            return;
        }
        g(new RectF(rect), this.n0);
        super.o(canvas, this.i0, this.n0, t());
    }

    private void z0(Canvas canvas, Rect rect) {
        Paint paint = this.j0;
        if (paint != null) {
            paint.setColor(a.g.d.a.d(-16777216, 127));
            canvas.drawRect(rect, this.j0);
            if (E2() || D2()) {
                h0(rect, this.l0);
                canvas.drawRect(this.l0, this.j0);
            }
            if (this.I != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.j0);
            }
            if (F2()) {
                k0(rect, this.l0);
                canvas.drawRect(this.l0, this.j0);
            }
            this.j0.setColor(a.g.d.a.d(-65536, 127));
            j0(rect, this.l0);
            canvas.drawRect(this.l0, this.j0);
            this.j0.setColor(a.g.d.a.d(-16711936, 127));
            l0(rect, this.l0);
            canvas.drawRect(this.l0, this.j0);
        }
    }

    public void A1(float f) {
        if (this.g0 != f) {
            this.g0 = f;
            invalidateSelf();
            o1();
        }
    }

    public void A2(int i) {
        z2(this.h0.getResources().getDimension(i));
    }

    public Drawable B0() {
        return this.W;
    }

    public void B1(int i) {
        A1(this.h0.getResources().getDimension(i));
    }

    public void B2(boolean z) {
        if (this.D0 != z) {
            this.D0 = z;
            H2();
            onStateChange(getState());
        }
    }

    public ColorStateList C0() {
        return this.C;
    }

    public void C1(Drawable drawable) {
        Drawable F0 = F0();
        if (F0 != drawable) {
            float i0 = i0();
            this.K = drawable != null ? androidx.core.graphics.drawable.a.r(drawable).mutate() : null;
            float i02 = i0();
            G2(F0);
            if (E2()) {
                g0(this.K);
            }
            invalidateSelf();
            if (i0 != i02) {
                o1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C2() {
        return this.H0;
    }

    public float D0() {
        return this.J0 ? E() : this.E;
    }

    public void D1(int i) {
        C1(a.a.k.a.a.d(this.h0, i));
    }

    public float E0() {
        return this.g0;
    }

    public void E1(float f) {
        if (this.M != f) {
            float i0 = i0();
            this.M = f;
            float i02 = i0();
            invalidateSelf();
            if (i0 != i02) {
                o1();
            }
        }
    }

    public Drawable F0() {
        Drawable drawable = this.K;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void F1(int i) {
        E1(this.h0.getResources().getDimension(i));
    }

    public float G0() {
        return this.M;
    }

    public void G1(ColorStateList colorStateList) {
        this.N = true;
        if (this.L != colorStateList) {
            this.L = colorStateList;
            if (E2()) {
                androidx.core.graphics.drawable.a.o(this.K, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public ColorStateList H0() {
        return this.L;
    }

    public void H1(int i) {
        G1(a.a.k.a.a.c(this.h0, i));
    }

    public float I0() {
        return this.D;
    }

    public void I1(int i) {
        J1(this.h0.getResources().getBoolean(i));
    }

    public float J0() {
        return this.Z;
    }

    public void J1(boolean z) {
        if (this.J != z) {
            boolean E2 = E2();
            this.J = z;
            boolean E22 = E2();
            if (E2 != E22) {
                if (E22) {
                    g0(this.K);
                } else {
                    G2(this.K);
                }
                invalidateSelf();
                o1();
            }
        }
    }

    public ColorStateList K0() {
        return this.F;
    }

    public void K1(float f) {
        if (this.D != f) {
            this.D = f;
            invalidateSelf();
            o1();
        }
    }

    public float L0() {
        return this.G;
    }

    public void L1(int i) {
        K1(this.h0.getResources().getDimension(i));
    }

    public Drawable M0() {
        Drawable drawable = this.P;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void M1(float f) {
        if (this.Z != f) {
            this.Z = f;
            invalidateSelf();
            o1();
        }
    }

    public CharSequence N0() {
        return this.T;
    }

    public void N1(int i) {
        M1(this.h0.getResources().getDimension(i));
    }

    public float O0() {
        return this.f0;
    }

    public void O1(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            if (this.J0) {
                b0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float P0() {
        return this.S;
    }

    public void P1(int i) {
        O1(a.a.k.a.a.c(this.h0, i));
    }

    public float Q0() {
        return this.e0;
    }

    public void Q1(float f) {
        if (this.G != f) {
            this.G = f;
            this.i0.setStrokeWidth(f);
            if (this.J0) {
                super.c0(f);
            }
            invalidateSelf();
        }
    }

    public int[] R0() {
        return this.C0;
    }

    public void R1(int i) {
        Q1(this.h0.getResources().getDimension(i));
    }

    public ColorStateList S0() {
        return this.R;
    }

    public void T0(RectF rectF) {
        l0(getBounds(), rectF);
    }

    public void T1(Drawable drawable) {
        Drawable M0 = M0();
        if (M0 != drawable) {
            float m0 = m0();
            this.P = drawable != null ? androidx.core.graphics.drawable.a.r(drawable).mutate() : null;
            if (b.c.a.b.y.b.f1392a) {
                I2();
            }
            float m02 = m0();
            G2(M0);
            if (F2()) {
                g0(this.P);
            }
            invalidateSelf();
            if (m0 != m02) {
                o1();
            }
        }
    }

    public TextUtils.TruncateAt U0() {
        return this.G0;
    }

    public void U1(CharSequence charSequence) {
        if (this.T != charSequence) {
            this.T = a.g.i.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    public h V0() {
        return this.Y;
    }

    public void V1(float f) {
        if (this.f0 != f) {
            this.f0 = f;
            invalidateSelf();
            if (F2()) {
                o1();
            }
        }
    }

    public float W0() {
        return this.b0;
    }

    public void W1(int i) {
        V1(this.h0.getResources().getDimension(i));
    }

    public float X0() {
        return this.a0;
    }

    public void X1(int i) {
        T1(a.a.k.a.a.d(this.h0, i));
    }

    public ColorStateList Y0() {
        return this.H;
    }

    public void Y1(float f) {
        if (this.S != f) {
            this.S = f;
            invalidateSelf();
            if (F2()) {
                o1();
            }
        }
    }

    public h Z0() {
        return this.X;
    }

    public void Z1(int i) {
        Y1(this.h0.getResources().getDimension(i));
    }

    @Override // com.google.android.material.internal.f.b
    public void a() {
        o1();
        invalidateSelf();
    }

    public CharSequence a1() {
        return this.I;
    }

    public void a2(float f) {
        if (this.e0 != f) {
            this.e0 = f;
            invalidateSelf();
            if (F2()) {
                o1();
            }
        }
    }

    public d b1() {
        return this.o0.d();
    }

    public void b2(int i) {
        a2(this.h0.getResources().getDimension(i));
    }

    public float c1() {
        return this.d0;
    }

    public boolean c2(int[] iArr) {
        if (Arrays.equals(this.C0, iArr)) {
            return false;
        }
        this.C0 = iArr;
        if (F2()) {
            return p1(getState(), iArr);
        }
        return false;
    }

    public float d1() {
        return this.c0;
    }

    public void d2(ColorStateList colorStateList) {
        if (this.R != colorStateList) {
            this.R = colorStateList;
            if (F2()) {
                androidx.core.graphics.drawable.a.o(this.P, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // b.c.a.b.a0.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i = this.x0;
        int a2 = i < 255 ? b.c.a.b.m.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i) : 0;
        w0(canvas, bounds);
        t0(canvas, bounds);
        if (this.J0) {
            super.draw(canvas);
        }
        v0(canvas, bounds);
        y0(canvas, bounds);
        u0(canvas, bounds);
        s0(canvas, bounds);
        if (this.H0) {
            A0(canvas, bounds);
        }
        x0(canvas, bounds);
        z0(canvas, bounds);
        if (this.x0 < 255) {
            canvas.restoreToCount(a2);
        }
    }

    public void e2(int i) {
        d2(a.a.k.a.a.c(this.h0, i));
    }

    public boolean f1() {
        return this.D0;
    }

    public void f2(boolean z) {
        if (this.O != z) {
            boolean F2 = F2();
            this.O = z;
            boolean F22 = F2();
            if (F2 != F22) {
                if (F22) {
                    g0(this.P);
                } else {
                    G2(this.P);
                }
                invalidateSelf();
                o1();
            }
        }
    }

    public void g2(InterfaceC0081a interfaceC0081a) {
        this.F0 = new WeakReference<>(interfaceC0081a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.x0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.y0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.D;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.Z + i0() + this.c0 + this.o0.f(a1().toString()) + this.d0 + m0() + this.g0), this.I0);
    }

    @Override // b.c.a.b.a0.g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // b.c.a.b.a0.g, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.J0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.E);
        } else {
            outline.setRoundRect(bounds, this.E);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public boolean h1() {
        return this.U;
    }

    public void h2(TextUtils.TruncateAt truncateAt) {
        this.G0 = truncateAt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i0() {
        if (E2() || D2()) {
            return this.a0 + this.M + this.b0;
        }
        return 0.0f;
    }

    public boolean i1() {
        return l1(this.P);
    }

    public void i2(h hVar) {
        this.Y = hVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // b.c.a.b.a0.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return k1(this.B) || k1(this.C) || k1(this.F) || (this.D0 && k1(this.E0)) || m1(this.o0.d()) || q0() || l1(this.K) || l1(this.W) || k1(this.A0);
    }

    public boolean j1() {
        return this.O;
    }

    public void j2(int i) {
        i2(h.c(this.h0, i));
    }

    public void k2(float f) {
        if (this.b0 != f) {
            float i0 = i0();
            this.b0 = f;
            float i02 = i0();
            invalidateSelf();
            if (i0 != i02) {
                o1();
            }
        }
    }

    public void l2(int i) {
        k2(this.h0.getResources().getDimension(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float m0() {
        if (F2()) {
            return this.e0 + this.S + this.f0;
        }
        return 0.0f;
    }

    public void m2(float f) {
        if (this.a0 != f) {
            float i0 = i0();
            this.a0 = f;
            float i02 = i0();
            invalidateSelf();
            if (i0 != i02) {
                o1();
            }
        }
    }

    public void n2(int i) {
        m2(this.h0.getResources().getDimension(i));
    }

    protected void o1() {
        InterfaceC0081a interfaceC0081a = this.F0.get();
        if (interfaceC0081a != null) {
            interfaceC0081a.a();
        }
    }

    public void o2(int i) {
        this.I0 = i;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (E2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.K, i);
        }
        if (D2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.W, i);
        }
        if (F2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.P, i);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (E2()) {
            onLevelChange |= this.K.setLevel(i);
        }
        if (D2()) {
            onLevelChange |= this.W.setLevel(i);
        }
        if (F2()) {
            onLevelChange |= this.P.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // b.c.a.b.a0.g, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.J0) {
            super.onStateChange(iArr);
        }
        return p1(iArr, R0());
    }

    Paint.Align p0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.I != null) {
            float i0 = this.Z + i0() + this.c0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                pointF.x = rect.left + i0;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - i0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - o0();
        }
        return align;
    }

    public void p2(ColorStateList colorStateList) {
        if (this.H != colorStateList) {
            this.H = colorStateList;
            H2();
            onStateChange(getState());
        }
    }

    public void q1(boolean z) {
        if (this.U != z) {
            this.U = z;
            float i0 = i0();
            if (!z && this.v0) {
                this.v0 = false;
            }
            float i02 = i0();
            invalidateSelf();
            if (i0 != i02) {
                o1();
            }
        }
    }

    public void q2(int i) {
        p2(a.a.k.a.a.c(this.h0, i));
    }

    public void r1(int i) {
        q1(this.h0.getResources().getBoolean(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r2(boolean z) {
        this.H0 = z;
    }

    public void s1(Drawable drawable) {
        if (this.W != drawable) {
            float i0 = i0();
            this.W = drawable;
            float i02 = i0();
            G2(this.W);
            g0(this.W);
            invalidateSelf();
            if (i0 != i02) {
                o1();
            }
        }
    }

    public void s2(h hVar) {
        this.X = hVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // b.c.a.b.a0.g, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.x0 != i) {
            this.x0 = i;
            invalidateSelf();
        }
    }

    @Override // b.c.a.b.a0.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.y0 != colorFilter) {
            this.y0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // b.c.a.b.a0.g, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        if (this.A0 != colorStateList) {
            this.A0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // b.c.a.b.a0.g, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.B0 != mode) {
            this.B0 = mode;
            this.z0 = b.c.a.b.s.a.a(this, this.A0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (E2()) {
            visible |= this.K.setVisible(z, z2);
        }
        if (D2()) {
            visible |= this.W.setVisible(z, z2);
        }
        if (F2()) {
            visible |= this.P.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t1(int i) {
        s1(a.a.k.a.a.d(this.h0, i));
    }

    public void t2(int i) {
        s2(h.c(this.h0, i));
    }

    public void u1(int i) {
        v1(this.h0.getResources().getBoolean(i));
    }

    public void u2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.I, charSequence)) {
            return;
        }
        this.I = charSequence;
        this.o0.i(true);
        invalidateSelf();
        o1();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v1(boolean z) {
        if (this.V != z) {
            boolean D2 = D2();
            this.V = z;
            boolean D22 = D2();
            if (D2 != D22) {
                if (D22) {
                    g0(this.W);
                } else {
                    G2(this.W);
                }
                invalidateSelf();
                o1();
            }
        }
    }

    public void v2(d dVar) {
        this.o0.h(dVar, this.h0);
    }

    public void w1(ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            onStateChange(getState());
        }
    }

    public void w2(int i) {
        v2(new d(this.h0, i));
    }

    public void x1(int i) {
        w1(a.a.k.a.a.c(this.h0, i));
    }

    public void x2(float f) {
        if (this.d0 != f) {
            this.d0 = f;
            invalidateSelf();
            o1();
        }
    }

    @Deprecated
    public void y1(float f) {
        if (this.E != f) {
            this.E = f;
            setShapeAppearanceModel(B().w(f));
        }
    }

    public void y2(int i) {
        x2(this.h0.getResources().getDimension(i));
    }

    @Deprecated
    public void z1(int i) {
        y1(this.h0.getResources().getDimension(i));
    }

    public void z2(float f) {
        if (this.c0 != f) {
            this.c0 = f;
            invalidateSelf();
            o1();
        }
    }
}
