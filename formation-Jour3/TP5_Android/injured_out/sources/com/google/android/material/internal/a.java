package com.google.android.material.internal;

import a.g.k.s;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import b.c.a.b.x.a;
/* loaded from: classes.dex */
public final class a {
    private static final boolean V;
    private static final Paint W;
    private boolean A;
    private Bitmap B;
    private Paint C;
    private float D;
    private float E;
    private float F;
    private float G;
    private int[] H;
    private boolean I;
    private TimeInterpolator L;
    private TimeInterpolator M;
    private float N;
    private float O;
    private float P;
    private ColorStateList Q;
    private float R;
    private float S;
    private float T;
    private ColorStateList U;

    /* renamed from: a  reason: collision with root package name */
    private final View f1778a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1779b;

    /* renamed from: c  reason: collision with root package name */
    private float f1780c;
    private ColorStateList k;
    private ColorStateList l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private Typeface s;
    private Typeface t;
    private Typeface u;
    private b.c.a.b.x.a v;
    private b.c.a.b.x.a w;
    private CharSequence x;
    private CharSequence y;
    private boolean z;
    private int g = 16;
    private int h = 16;
    private float i = 15.0f;
    private float j = 15.0f;
    private final TextPaint J = new TextPaint(129);
    private final TextPaint K = new TextPaint(this.J);
    private final Rect e = new Rect();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f1781d = new Rect();
    private final RectF f = new RectF();

    /* renamed from: com.google.android.material.internal.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0086a implements a.InterfaceC0062a {
        C0086a() {
        }

        @Override // b.c.a.b.x.a.InterfaceC0062a
        public void a(Typeface typeface) {
            a.this.G(typeface);
        }
    }

    static {
        V = Build.VERSION.SDK_INT < 18;
        Paint paint = null;
        W = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            W.setColor(-65281);
        }
    }

    public a(View view) {
        this.f1778a = view;
    }

    private static boolean A(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    private boolean H(Typeface typeface) {
        b.c.a.b.x.a aVar = this.w;
        if (aVar != null) {
            aVar.c();
        }
        if (this.s != typeface) {
            this.s = typeface;
            return true;
        }
        return false;
    }

    private boolean N(Typeface typeface) {
        b.c.a.b.x.a aVar = this.v;
        if (aVar != null) {
            aVar.c();
        }
        if (this.t != typeface) {
            this.t = typeface;
            return true;
        }
        return false;
    }

    private void P(float f) {
        g(f);
        boolean z = V && this.F != 1.0f;
        this.A = z;
        if (z) {
            j();
        }
        s.X(this.f1778a);
    }

    private static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), (int) ((Color.red(i) * f2) + (Color.red(i2) * f)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f)), (int) ((Color.blue(i) * f2) + (Color.blue(i2) * f)));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.a.b():void");
    }

    private void d() {
        f(this.f1780c);
    }

    private boolean e(CharSequence charSequence) {
        return (s.w(this.f1778a) == 1 ? a.g.i.e.f209d : a.g.i.e.f208c).a(charSequence, 0, charSequence.length());
    }

    private void f(float f) {
        TextPaint textPaint;
        int n;
        u(f);
        this.q = x(this.o, this.p, f, this.L);
        this.r = x(this.m, this.n, f, this.L);
        P(x(this.i, this.j, f, this.M));
        if (this.l != this.k) {
            textPaint = this.J;
            n = a(p(), n(), f);
        } else {
            textPaint = this.J;
            n = n();
        }
        textPaint.setColor(n);
        this.J.setShadowLayer(x(this.R, this.N, f, null), x(this.S, this.O, f, null), x(this.T, this.P, f, null), a(o(this.U), o(this.Q), f));
        s.X(this.f1778a);
    }

    private void g(float f) {
        boolean z;
        float f2;
        boolean z2;
        if (this.x == null) {
            return;
        }
        float width = this.e.width();
        float width2 = this.f1781d.width();
        if (v(f, this.j)) {
            f2 = this.j;
            this.F = 1.0f;
            Typeface typeface = this.u;
            Typeface typeface2 = this.s;
            if (typeface != typeface2) {
                this.u = typeface2;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            float f3 = this.i;
            Typeface typeface3 = this.u;
            Typeface typeface4 = this.t;
            if (typeface3 != typeface4) {
                this.u = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (v(f, this.i)) {
                this.F = 1.0f;
            } else {
                this.F = f / this.i;
            }
            float f4 = this.j / this.i;
            width = width2 * f4 > width ? Math.min(width / f4, width2) : width2;
            f2 = f3;
            z2 = z;
        }
        if (width > 0.0f) {
            z2 = this.G != f2 || this.I || z2;
            this.G = f2;
            this.I = false;
        }
        if (this.y == null || z2) {
            this.J.setTextSize(this.G);
            this.J.setTypeface(this.u);
            this.J.setLinearText(this.F != 1.0f);
            CharSequence ellipsize = TextUtils.ellipsize(this.x, this.J, width, TextUtils.TruncateAt.END);
            if (TextUtils.equals(ellipsize, this.y)) {
                return;
            }
            this.y = ellipsize;
            this.z = e(ellipsize);
        }
    }

    private void h() {
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            bitmap.recycle();
            this.B = null;
        }
    }

    private void j() {
        if (this.B != null || this.f1781d.isEmpty() || TextUtils.isEmpty(this.y)) {
            return;
        }
        f(0.0f);
        this.D = this.J.ascent();
        this.E = this.J.descent();
        TextPaint textPaint = this.J;
        CharSequence charSequence = this.y;
        int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
        int round2 = Math.round(this.E - this.D);
        if (round <= 0 || round2 <= 0) {
            return;
        }
        this.B = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.B);
        CharSequence charSequence2 = this.y;
        canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, round2 - this.J.descent(), this.J);
        if (this.C == null) {
            this.C = new Paint(3);
        }
    }

    private int o(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.H;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    private int p() {
        return o(this.k);
    }

    private void s(TextPaint textPaint) {
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
    }

    private void t(TextPaint textPaint) {
        textPaint.setTextSize(this.i);
        textPaint.setTypeface(this.t);
    }

    private void u(float f) {
        this.f.left = x(this.f1781d.left, this.e.left, f, this.L);
        this.f.top = x(this.m, this.n, f, this.L);
        this.f.right = x(this.f1781d.right, this.e.right, f, this.L);
        this.f.bottom = x(this.f1781d.bottom, this.e.bottom, f, this.L);
    }

    private static boolean v(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    private static float x(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return b.c.a.b.l.a.a(f, f2, f3);
    }

    public void B(int i, int i2, int i3, int i4) {
        if (A(this.e, i, i2, i3, i4)) {
            return;
        }
        this.e.set(i, i2, i3, i4);
        this.I = true;
        y();
    }

    public void C(Rect rect) {
        B(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void D(int i) {
        b.c.a.b.x.d dVar = new b.c.a.b.x.d(this.f1778a.getContext(), i);
        ColorStateList colorStateList = dVar.f1381b;
        if (colorStateList != null) {
            this.l = colorStateList;
        }
        float f = dVar.f1380a;
        if (f != 0.0f) {
            this.j = f;
        }
        ColorStateList colorStateList2 = dVar.f;
        if (colorStateList2 != null) {
            this.Q = colorStateList2;
        }
        this.O = dVar.g;
        this.P = dVar.h;
        this.N = dVar.i;
        b.c.a.b.x.a aVar = this.w;
        if (aVar != null) {
            aVar.c();
        }
        this.w = new b.c.a.b.x.a(new C0086a(), dVar.e());
        dVar.h(this.f1778a.getContext(), this.w);
        z();
    }

    public void E(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            z();
        }
    }

    public void F(int i) {
        if (this.h != i) {
            this.h = i;
            z();
        }
    }

    public void G(Typeface typeface) {
        if (H(typeface)) {
            z();
        }
    }

    public void I(int i, int i2, int i3, int i4) {
        if (A(this.f1781d, i, i2, i3, i4)) {
            return;
        }
        this.f1781d.set(i, i2, i3, i4);
        this.I = true;
        y();
    }

    public void J(Rect rect) {
        I(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void K(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            z();
        }
    }

    public void L(int i) {
        if (this.g != i) {
            this.g = i;
            z();
        }
    }

    public void M(float f) {
        if (this.i != f) {
            this.i = f;
            z();
        }
    }

    public void O(float f) {
        float a2 = a.g.f.a.a(f, 0.0f, 1.0f);
        if (a2 != this.f1780c) {
            this.f1780c = a2;
            d();
        }
    }

    public void Q(TimeInterpolator timeInterpolator) {
        this.L = timeInterpolator;
        z();
    }

    public final boolean R(int[] iArr) {
        this.H = iArr;
        if (w()) {
            z();
            return true;
        }
        return false;
    }

    public void S(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.x, charSequence)) {
            this.x = charSequence;
            this.y = null;
            h();
            z();
        }
    }

    public void T(TimeInterpolator timeInterpolator) {
        this.M = timeInterpolator;
        z();
    }

    public void U(Typeface typeface) {
        boolean H = H(typeface);
        boolean N = N(typeface);
        if (H || N) {
            z();
        }
    }

    public float c() {
        if (this.x == null) {
            return 0.0f;
        }
        s(this.K);
        TextPaint textPaint = this.K;
        CharSequence charSequence = this.x;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void i(Canvas canvas) {
        float ascent;
        int save = canvas.save();
        if (this.y != null && this.f1779b) {
            float f = this.q;
            float f2 = this.r;
            boolean z = this.A && this.B != null;
            if (z) {
                ascent = this.D * this.F;
            } else {
                ascent = this.J.ascent() * this.F;
                this.J.descent();
            }
            if (z) {
                f2 += ascent;
            }
            float f3 = f2;
            float f4 = this.F;
            if (f4 != 1.0f) {
                canvas.scale(f4, f4, f, f3);
            }
            if (z) {
                canvas.drawBitmap(this.B, f, f3, this.C);
            } else {
                CharSequence charSequence = this.y;
                canvas.drawText(charSequence, 0, charSequence.length(), f, f3, this.J);
            }
        }
        canvas.restoreToCount(save);
    }

    public void k(RectF rectF) {
        boolean e = e(this.x);
        Rect rect = this.e;
        float c2 = !e ? rect.left : rect.right - c();
        rectF.left = c2;
        Rect rect2 = this.e;
        rectF.top = rect2.top;
        rectF.right = !e ? c2 + c() : rect2.right;
        rectF.bottom = this.e.top + m();
    }

    public ColorStateList l() {
        return this.l;
    }

    public float m() {
        s(this.K);
        return -this.K.ascent();
    }

    public int n() {
        return o(this.l);
    }

    public float q() {
        t(this.K);
        return -this.K.ascent();
    }

    public float r() {
        return this.f1780c;
    }

    public final boolean w() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.l;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.k) != null && colorStateList.isStateful());
    }

    void y() {
        this.f1779b = this.e.width() > 0 && this.e.height() > 0 && this.f1781d.width() > 0 && this.f1781d.height() > 0;
    }

    public void z() {
        if (this.f1778a.getHeight() <= 0 || this.f1778a.getWidth() <= 0) {
            return;
        }
        b();
        d();
    }
}
