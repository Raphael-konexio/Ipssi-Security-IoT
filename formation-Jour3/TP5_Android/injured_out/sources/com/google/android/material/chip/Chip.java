package com.google.android.material.chip;

import a.g.k.b0.c;
import a.g.k.s;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.g;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.b.a0.n;
import b.c.a.b.i;
import b.c.a.b.j;
import b.c.a.b.k;
import b.c.a.b.x.d;
import b.c.a.b.x.f;
import com.google.android.material.chip.a;
import com.google.android.material.internal.h;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes.dex */
public class Chip extends g implements a.InterfaceC0081a, n {
    private com.google.android.material.chip.a i;
    private InsetDrawable j;
    private RippleDrawable k;
    private View.OnClickListener l;
    private CompoundButton.OnCheckedChangeListener m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private final c u;
    private final Rect v;
    private final RectF w;
    private final f x;
    private static final Rect y = new Rect();
    private static final int[] z = {16842913};
    private static final int[] A = {16842911};

    /* loaded from: classes.dex */
    class a extends f {
        a() {
        }

        @Override // b.c.a.b.x.f
        public void a(int i) {
        }

        @Override // b.c.a.b.x.f
        public void b(Typeface typeface, boolean z) {
            Chip chip = Chip.this;
            chip.setText(chip.i.C2() ? Chip.this.i.a1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (Chip.this.i != null) {
                Chip.this.i.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends a.i.b.a {
        c(Chip chip) {
            super(chip);
        }

        @Override // a.i.b.a
        protected int B(float f, float f2) {
            return (Chip.this.m() && Chip.this.getCloseIconTouchBounds().contains(f, f2)) ? 1 : 0;
        }

        @Override // a.i.b.a
        protected void C(List<Integer> list) {
            list.add(0);
            if (Chip.this.m() && Chip.this.r()) {
                list.add(1);
            }
        }

        @Override // a.i.b.a
        protected boolean J(int i, int i2, Bundle bundle) {
            if (i2 == 16) {
                if (i == 0) {
                    return Chip.this.performClick();
                }
                if (i == 1) {
                    return Chip.this.s();
                }
                return false;
            }
            return false;
        }

        @Override // a.i.b.a
        protected void M(a.g.k.b0.c cVar) {
            cVar.U(Chip.this.q());
            cVar.X(Chip.this.isClickable());
            cVar.W((Chip.this.q() || Chip.this.isClickable()) ? Chip.this.q() ? "android.widget.CompoundButton" : "android.widget.Button" : "android.view.View");
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                cVar.s0(text);
            } else {
                cVar.a0(text);
            }
        }

        @Override // a.i.b.a
        protected void N(int i, a.g.k.b0.c cVar) {
            if (i != 1) {
                cVar.a0("");
                cVar.S(Chip.y);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription == null) {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i2 = i.mtrl_chip_close_icon_content_description;
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(text) ? "" : text;
                closeIconContentDescription = context.getString(i2, objArr).trim();
            }
            cVar.a0(closeIconContentDescription);
            cVar.S(Chip.this.getCloseIconTouchBoundsInt());
            cVar.b(c.a.e);
            cVar.d0(Chip.this.isEnabled());
        }

        @Override // a.i.b.a
        protected void O(int i, boolean z) {
            if (i == 1) {
                Chip.this.q = z;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.c.a.b.b.chipStyle);
    }

    public Chip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.v = new Rect();
        this.w = new RectF();
        this.x = new a();
        B(attributeSet);
        com.google.android.material.chip.a r0 = com.google.android.material.chip.a.r0(context, attributeSet, i, j.Widget_MaterialComponents_Chip_Action);
        n(context, attributeSet, i);
        setChipDrawable(r0);
        r0.S(s.r(this));
        TypedArray k = com.google.android.material.internal.g.k(context, attributeSet, k.Chip, i, j.Widget_MaterialComponents_Chip_Action, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(b.c.a.b.x.c.a(context, k, k.Chip_android_textColor));
        }
        boolean hasValue = k.hasValue(k.Chip_shapeAppearance);
        k.recycle();
        c cVar = new c(this);
        this.u = cVar;
        if (Build.VERSION.SDK_INT >= 24) {
            s.f0(this, cVar);
        } else {
            w();
        }
        if (!hasValue) {
            o();
        }
        setChecked(this.n);
        setText(r0.a1());
        setEllipsize(r0.U0());
        setIncludeFontPadding(false);
        A();
        if (!this.i.C2()) {
            setSingleLine();
        }
        setGravity(8388627);
        z();
        if (u()) {
            setMinHeight(this.t);
        }
        this.s = s.w(this);
    }

    private void A() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.i(getContext(), paint, this.x);
        }
    }

    private void B(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.w.setEmpty();
        if (m()) {
            this.i.T0(this.w);
        }
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.v.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.v;
    }

    private d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.b1();
        }
        return null;
    }

    private void h(com.google.android.material.chip.a aVar) {
        aVar.g2(this);
    }

    private int[] i() {
        int i = 0;
        int i2 = isEnabled() ? 1 : 0;
        if (this.q) {
            i2++;
        }
        if (this.p) {
            i2++;
        }
        if (this.o) {
            i2++;
        }
        if (isChecked()) {
            i2++;
        }
        int[] iArr = new int[i2];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i = 1;
        }
        if (this.q) {
            iArr[i] = 16842908;
            i++;
        }
        if (this.p) {
            iArr[i] = 16843623;
            i++;
        }
        if (this.o) {
            iArr[i] = 16842919;
            i++;
        }
        if (isChecked()) {
            iArr[i] = 16842913;
        }
        return iArr;
    }

    private void k() {
        if (getBackgroundDrawable() == this.j && this.i.getCallback() == null) {
            this.i.setCallback(this.j);
        }
    }

    private boolean l(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = a.i.b.a.class.getDeclaredField("m");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.u)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = a.i.b.a.class.getDeclaredMethod("V", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.u, Integer.valueOf((int) RecyclerView.UNDEFINED_DURATION));
                    return true;
                }
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        com.google.android.material.chip.a aVar = this.i;
        return (aVar == null || aVar.M0() == null) ? false : true;
    }

    private void n(Context context, AttributeSet attributeSet, int i) {
        TypedArray k = com.google.android.material.internal.g.k(context, attributeSet, k.Chip, i, j.Widget_MaterialComponents_Chip_Action, new int[0]);
        this.r = k.getBoolean(k.Chip_ensureMinTouchTargetSize, false);
        this.t = (int) Math.ceil(k.getDimension(k.Chip_chipMinTouchTargetSize, (float) Math.ceil(h.a(getContext(), 48))));
        k.recycle();
    }

    private void o() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b());
        }
    }

    private void p(int i, int i2, int i3, int i4) {
        this.j = new InsetDrawable((Drawable) this.i, i, i2, i3, i4);
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.p != z2) {
            this.p = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.o != z2) {
            this.o = z2;
            refreshDrawableState();
        }
    }

    private void t() {
        if (this.j != null) {
            this.j = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            x();
        }
    }

    private void v(com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.g2(null);
        }
    }

    private void w() {
        if (Build.VERSION.SDK_INT >= 24) {
            return;
        }
        s.f0(this, (m() && r()) ? this.u : null);
    }

    private void x() {
        if (b.c.a.b.y.b.f1392a) {
            y();
            return;
        }
        this.i.B2(true);
        s.i0(this, getBackgroundDrawable());
        k();
    }

    private void y() {
        this.k = new RippleDrawable(b.c.a.b.y.b.a(this.i.Y0()), getBackgroundDrawable(), null);
        this.i.B2(false);
        s.i0(this, this.k);
    }

    private void z() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.i) == null) {
            return;
        }
        s.s0(this, (int) (this.i.J0() + this.i.d1() + this.i.i0()), getPaddingTop(), (int) (aVar.E0() + this.i.c1() + this.i.m0()), getPaddingBottom());
    }

    @Override // com.google.android.material.chip.a.InterfaceC0081a
    public void a() {
        j(this.t);
        x();
        z();
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return l(motionEvent) || this.u.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.u.w(keyEvent) || this.u.A() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.g, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.i;
        if ((aVar == null || !aVar.i1()) ? false : this.i.c2(i())) {
            invalidate();
        }
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.j;
        return insetDrawable == null ? this.i : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.B0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.C0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.D0();
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.i;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.E0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.F0();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.G0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.H0();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.I0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.J0();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.K0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.L0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.M0();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.N0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.O0();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.P0();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.Q0();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.S0();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.U0();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.u.A() == 1 || this.u.x() == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public b.c.a.b.l.h getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.V0();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.W0();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.X0();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.Y0();
        }
        return null;
    }

    public b.c.a.b.a0.k getShapeAppearanceModel() {
        return this.i.B();
    }

    public b.c.a.b.l.h getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.Z0();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.c1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            return aVar.d1();
        }
        return 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006a, code lost:
        if (getMinWidth() != r6) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean j(int r6) {
        /*
            r5 = this;
            r5.t = r6
            boolean r0 = r5.u()
            r1 = 0
            if (r0 != 0) goto Ld
            r5.t()
            return r1
        Ld:
            com.google.android.material.chip.a r0 = r5.i
            int r0 = r0.getIntrinsicHeight()
            int r0 = r6 - r0
            int r0 = java.lang.Math.max(r1, r0)
            com.google.android.material.chip.a r2 = r5.i
            int r2 = r2.getIntrinsicWidth()
            int r2 = r6 - r2
            int r2 = java.lang.Math.max(r1, r2)
            if (r2 > 0) goto L2d
            if (r0 > 0) goto L2d
            r5.t()
            return r1
        L2d:
            if (r2 <= 0) goto L32
            int r2 = r2 / 2
            goto L33
        L32:
            r2 = 0
        L33:
            if (r0 <= 0) goto L37
            int r1 = r0 / 2
        L37:
            android.graphics.drawable.InsetDrawable r0 = r5.j
            r3 = 1
            if (r0 == 0) goto L57
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.graphics.drawable.InsetDrawable r4 = r5.j
            r4.getPadding(r0)
            int r4 = r0.top
            if (r4 != r1) goto L57
            int r4 = r0.bottom
            if (r4 != r1) goto L57
            int r4 = r0.left
            if (r4 != r2) goto L57
            int r0 = r0.right
            if (r0 != r2) goto L57
            return r3
        L57:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 16
            if (r0 < r4) goto L6d
            int r0 = r5.getMinHeight()
            if (r0 == r6) goto L66
            r5.setMinHeight(r6)
        L66:
            int r0 = r5.getMinWidth()
            if (r0 == r6) goto L73
            goto L70
        L6d:
            r5.setMinHeight(r6)
        L70:
            r5.setMinWidth(r6)
        L73:
            r5.p(r2, r1, r2, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.j(int):boolean");
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.c.a.b.a0.h.f(this, this.i);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, z);
        }
        if (q()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, A);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z2, int i, Rect rect) {
        super.onFocusChanged(z2, i, rect);
        this.u.I(z2, i, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        boolean contains;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                contains = false;
            }
            return super.onHoverEvent(motionEvent);
        }
        contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        setCloseIconHovered(contains);
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((q() || isClickable()) ? q() ? "android.widget.CompoundButton" : "android.widget.Button" : "android.view.View");
        accessibilityNodeInfo.setCheckable(q());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.s != i) {
            this.s = i;
            z();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r0 != 3) goto L16;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L39
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L34
            goto L40
        L21:
            boolean r0 = r5.o
            if (r0 == 0) goto L40
            if (r1 != 0) goto L3e
            r5.setCloseIconPressed(r2)
            goto L3e
        L2b:
            boolean r0 = r5.o
            if (r0 == 0) goto L34
            r5.s()
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            r5.setCloseIconPressed(r2)
            goto L41
        L39:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r3)
        L3e:
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L49
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
        L49:
            r2 = 1
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean q() {
        com.google.android.material.chip.a aVar = this.i;
        return aVar != null && aVar.h1();
    }

    public boolean r() {
        com.google.android.material.chip.a aVar = this.i;
        return aVar != null && aVar.j1();
    }

    public boolean s() {
        boolean z2 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.l;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z2 = true;
        }
        this.u.U(1, 1);
        return z2;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.k) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.g, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.k) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.g, android.view.View
    public void setBackgroundResource(int i) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z2) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.q1(z2);
        }
    }

    public void setCheckableResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.r1(i);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        com.google.android.material.chip.a aVar = this.i;
        if (aVar == null) {
            this.n = z2;
        } else if (aVar.h1()) {
            boolean isChecked = isChecked();
            super.setChecked(z2);
            if (isChecked == z2 || (onCheckedChangeListener = this.m) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z2);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.s1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.t1(i);
        }
    }

    public void setCheckedIconVisible(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.u1(i);
        }
    }

    public void setCheckedIconVisible(boolean z2) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.v1(z2);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.w1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.x1(i);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.y1(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.z1(i);
        }
    }

    public void setChipDrawable(com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.i;
        if (aVar2 != aVar) {
            v(aVar2);
            this.i = aVar;
            aVar.r2(false);
            h(this.i);
            j(this.t);
            x();
        }
    }

    public void setChipEndPadding(float f) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.A1(f);
        }
    }

    public void setChipEndPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.B1(i);
        }
    }

    public void setChipIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.C1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.D1(i);
        }
    }

    public void setChipIconSize(float f) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.E1(f);
        }
    }

    public void setChipIconSizeResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.F1(i);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.G1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.H1(i);
        }
    }

    public void setChipIconVisible(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.I1(i);
        }
    }

    public void setChipIconVisible(boolean z2) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.J1(z2);
        }
    }

    public void setChipMinHeight(float f) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.K1(f);
        }
    }

    public void setChipMinHeightResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.L1(i);
        }
    }

    public void setChipStartPadding(float f) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.M1(f);
        }
    }

    public void setChipStartPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.N1(i);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.O1(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.P1(i);
        }
    }

    public void setChipStrokeWidth(float f) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.Q1(f);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.R1(i);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.T1(drawable);
        }
        w();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.U1(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.V1(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.W1(i);
        }
    }

    public void setCloseIconResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.X1(i);
        }
        w();
    }

    public void setCloseIconSize(float f) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.Y1(f);
        }
    }

    public void setCloseIconSizeResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.Z1(i);
        }
    }

    public void setCloseIconStartPadding(float f) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.a2(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.b2(i);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.d2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.e2(i);
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    public void setCloseIconVisible(boolean z2) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.f2(z2);
        }
        w();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.S(f);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.i == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.h2(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        this.r = z2;
        j(this.t);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(b.c.a.b.l.h hVar) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.i2(hVar);
        }
    }

    public void setHideMotionSpecResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.j2(i);
        }
    }

    public void setIconEndPadding(float f) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.k2(f);
        }
    }

    public void setIconEndPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.l2(i);
        }
    }

    public void setIconStartPadding(float f) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.m2(f);
        }
    }

    public void setIconStartPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.n2(i);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.i != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.o2(i);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.m = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.p2(colorStateList);
        }
        if (this.i.f1()) {
            return;
        }
        y();
    }

    public void setRippleColorResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.q2(i);
            if (this.i.f1()) {
                return;
            }
            y();
        }
    }

    @Override // b.c.a.b.a0.n
    public void setShapeAppearanceModel(b.c.a.b.a0.k kVar) {
        this.i.setShapeAppearanceModel(kVar);
    }

    public void setShowMotionSpec(b.c.a.b.l.h hVar) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.s2(hVar);
        }
    }

    public void setShowMotionSpecResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.t2(i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z2) {
        if (!z2) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z2);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.i == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(this.i.C2() ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.u2(charSequence);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.w2(i);
        }
        A();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.w2(i);
        }
        A();
    }

    public void setTextAppearance(d dVar) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.v2(dVar);
        }
        A();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.x2(f);
        }
    }

    public void setTextEndPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.y2(i);
        }
    }

    public void setTextStartPadding(float f) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.z2(f);
        }
    }

    public void setTextStartPaddingResource(int i) {
        com.google.android.material.chip.a aVar = this.i;
        if (aVar != null) {
            aVar.A2(i);
        }
    }

    public boolean u() {
        return this.r;
    }
}
