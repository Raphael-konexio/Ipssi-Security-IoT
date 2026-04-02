package com.google.android.material.button;

import a.g.k.s;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import b.c.a.b.a0.g;
import b.c.a.b.a0.k;
import b.c.a.b.a0.n;
import b.c.a.b.b;
import b.c.a.b.x.c;
import com.google.android.material.internal.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {
    private static final boolean s;

    /* renamed from: a  reason: collision with root package name */
    private final MaterialButton f1707a;

    /* renamed from: b  reason: collision with root package name */
    private k f1708b;

    /* renamed from: c  reason: collision with root package name */
    private int f1709c;

    /* renamed from: d  reason: collision with root package name */
    private int f1710d;
    private int e;
    private int f;
    private int g;
    private int h;
    private PorterDuff.Mode i;
    private ColorStateList j;
    private ColorStateList k;
    private ColorStateList l;
    private Drawable m;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q;
    private LayerDrawable r;

    static {
        s = Build.VERSION.SDK_INT >= 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MaterialButton materialButton, k kVar) {
        this.f1707a = materialButton;
        this.f1708b = kVar;
    }

    private void A(k kVar) {
        if (d() != null) {
            d().setShapeAppearanceModel(kVar);
        }
        if (l() != null) {
            l().setShapeAppearanceModel(kVar);
        }
        if (c() != null) {
            c().setShapeAppearanceModel(kVar);
        }
    }

    private void C() {
        g d2 = d();
        g l = l();
        if (d2 != null) {
            d2.a0(this.h, this.k);
            if (l != null) {
                l.Z(this.h, this.n ? b.c.a.b.q.a.c(this.f1707a, b.colorSurface) : 0);
            }
        }
    }

    private InsetDrawable D(Drawable drawable) {
        return new InsetDrawable(drawable, this.f1709c, this.e, this.f1710d, this.f);
    }

    private Drawable a() {
        g gVar = new g(this.f1708b);
        gVar.L(this.f1707a.getContext());
        androidx.core.graphics.drawable.a.o(gVar, this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            androidx.core.graphics.drawable.a.p(gVar, mode);
        }
        gVar.a0(this.h, this.k);
        g gVar2 = new g(this.f1708b);
        gVar2.setTint(0);
        gVar2.Z(this.h, this.n ? b.c.a.b.q.a.c(this.f1707a, b.colorSurface) : 0);
        if (s) {
            g gVar3 = new g(this.f1708b);
            this.m = gVar3;
            androidx.core.graphics.drawable.a.n(gVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(b.c.a.b.y.b.a(this.l), D(new LayerDrawable(new Drawable[]{gVar2, gVar})), this.m);
            this.r = rippleDrawable;
            return rippleDrawable;
        }
        b.c.a.b.y.a aVar = new b.c.a.b.y.a(this.f1708b);
        this.m = aVar;
        androidx.core.graphics.drawable.a.o(aVar, b.c.a.b.y.b.a(this.l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.m});
        this.r = layerDrawable;
        return D(layerDrawable);
    }

    private g e(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (g) (s ? (LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable() : this.r).getDrawable(!z ? 1 : 0);
    }

    private g l() {
        return e(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i, int i2) {
        Drawable drawable = this.m;
        if (drawable != null) {
            drawable.setBounds(this.f1709c, this.e, i2 - this.f1710d, i - this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.g;
    }

    public n c() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (n) (this.r.getNumberOfLayers() > 2 ? this.r.getDrawable(2) : this.r.getDrawable(1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g d() {
        return e(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k g() {
        return this.f1708b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList h() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(TypedArray typedArray) {
        this.f1709c = typedArray.getDimensionPixelOffset(b.c.a.b.k.MaterialButton_android_insetLeft, 0);
        this.f1710d = typedArray.getDimensionPixelOffset(b.c.a.b.k.MaterialButton_android_insetRight, 0);
        this.e = typedArray.getDimensionPixelOffset(b.c.a.b.k.MaterialButton_android_insetTop, 0);
        this.f = typedArray.getDimensionPixelOffset(b.c.a.b.k.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(b.c.a.b.k.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(b.c.a.b.k.MaterialButton_cornerRadius, -1);
            this.g = dimensionPixelSize;
            u(this.f1708b.w(dimensionPixelSize));
            this.p = true;
        }
        this.h = typedArray.getDimensionPixelSize(b.c.a.b.k.MaterialButton_strokeWidth, 0);
        this.i = h.c(typedArray.getInt(b.c.a.b.k.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.j = c.a(this.f1707a.getContext(), typedArray, b.c.a.b.k.MaterialButton_backgroundTint);
        this.k = c.a(this.f1707a.getContext(), typedArray, b.c.a.b.k.MaterialButton_strokeColor);
        this.l = c.a(this.f1707a.getContext(), typedArray, b.c.a.b.k.MaterialButton_rippleColor);
        this.q = typedArray.getBoolean(b.c.a.b.k.MaterialButton_android_checkable, false);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(b.c.a.b.k.MaterialButton_elevation, 0);
        int B = s.B(this.f1707a);
        int paddingTop = this.f1707a.getPaddingTop();
        int A = s.A(this.f1707a);
        int paddingBottom = this.f1707a.getPaddingBottom();
        this.f1707a.setInternalBackground(a());
        g d2 = d();
        if (d2 != null) {
            d2.S(dimensionPixelSize2);
        }
        s.s0(this.f1707a, B + this.f1709c, paddingTop + this.e, A + this.f1710d, paddingBottom + this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i) {
        if (d() != null) {
            d().setTint(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.o = true;
        this.f1707a.setSupportBackgroundTintList(this.j);
        this.f1707a.setSupportBackgroundTintMode(this.i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z) {
        this.q = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i) {
        if (this.p && this.g == i) {
            return;
        }
        this.g = i;
        this.p = true;
        u(this.f1708b.w(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            if (s && (this.f1707a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f1707a.getBackground()).setColor(b.c.a.b.y.b.a(colorStateList));
            } else if (s || !(this.f1707a.getBackground() instanceof b.c.a.b.y.a)) {
            } else {
                ((b.c.a.b.y.a) this.f1707a.getBackground()).setTintList(b.c.a.b.y.b.a(colorStateList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(k kVar) {
        this.f1708b = kVar;
        A(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(boolean z) {
        this.n = z;
        C();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            C();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(int i) {
        if (this.h != i) {
            this.h = i;
            C();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            if (d() != null) {
                androidx.core.graphics.drawable.a.o(d(), this.j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(PorterDuff.Mode mode) {
        if (this.i != mode) {
            this.i = mode;
            if (d() == null || this.i == null) {
                return;
            }
            androidx.core.graphics.drawable.a.p(d(), this.i);
        }
    }
}
