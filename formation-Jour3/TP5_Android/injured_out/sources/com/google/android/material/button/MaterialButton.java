package com.google.android.material.button;

import a.g.k.s;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.f;
import androidx.core.widget.i;
import b.c.a.b.a0.n;
import b.c.a.b.j;
import b.c.a.b.k;
import b.c.a.b.x.c;
import com.google.android.material.internal.g;
import com.google.android.material.internal.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes.dex */
public class MaterialButton extends f implements Checkable, n {
    private static final int[] t = {16842911};
    private static final int[] u = {16842912};
    private static final int v = j.Widget_MaterialComponents_Button;
    private final com.google.android.material.button.a h;
    private final LinkedHashSet<a> i;
    private b j;
    private PorterDuff.Mode k;
    private ColorStateList l;
    private Drawable m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private int s;

    /* loaded from: classes.dex */
    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    /* loaded from: classes.dex */
    interface b {
        void a(MaterialButton materialButton, boolean z);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.c.a.b.b.materialButtonStyle);
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        super(g.f(context, attributeSet, i, v), attributeSet, i);
        this.i = new LinkedHashSet<>();
        this.q = false;
        this.r = false;
        Context context2 = getContext();
        TypedArray k = g.k(context2, attributeSet, k.MaterialButton, i, v, new int[0]);
        this.p = k.getDimensionPixelSize(k.MaterialButton_iconPadding, 0);
        this.k = h.c(k.getInt(k.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.l = c.a(getContext(), k, k.MaterialButton_iconTint);
        this.m = c.d(getContext(), k, k.MaterialButton_icon);
        this.s = k.getInteger(k.MaterialButton_iconGravity, 1);
        this.n = k.getDimensionPixelSize(k.MaterialButton_iconSize, 0);
        com.google.android.material.button.a aVar = new com.google.android.material.button.a(this, b.c.a.b.a0.k.e(context2, attributeSet, i, v).m());
        this.h = aVar;
        aVar.o(k);
        k.recycle();
        setCompoundDrawablePadding(this.p);
        e(this.m != null);
    }

    private boolean b() {
        return s.w(this) == 1;
    }

    private boolean c() {
        com.google.android.material.button.a aVar = this.h;
        return (aVar == null || aVar.m()) ? false : true;
    }

    private void d(boolean z) {
        if (z) {
            i.i(this, this.m, null, null, null);
        } else {
            i.i(this, null, null, this.m, null);
        }
    }

    private void e(boolean z) {
        Drawable drawable = this.m;
        boolean z2 = false;
        if (drawable != null) {
            Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.m = mutate;
            androidx.core.graphics.drawable.a.o(mutate, this.l);
            PorterDuff.Mode mode = this.k;
            if (mode != null) {
                androidx.core.graphics.drawable.a.p(this.m, mode);
            }
            int i = this.n;
            if (i == 0) {
                i = this.m.getIntrinsicWidth();
            }
            int i2 = this.n;
            if (i2 == 0) {
                i2 = this.m.getIntrinsicHeight();
            }
            Drawable drawable2 = this.m;
            int i3 = this.o;
            drawable2.setBounds(i3, 0, i + i3, i2);
        }
        int i4 = this.s;
        boolean z3 = i4 == 1 || i4 == 2;
        if (z) {
            d(z3);
            return;
        }
        Drawable[] a2 = i.a(this);
        Drawable drawable3 = a2[0];
        Drawable drawable4 = a2[2];
        if ((z3 && drawable3 != this.m) || (!z3 && drawable4 != this.m)) {
            z2 = true;
        }
        if (z2) {
            d(z3);
        }
    }

    private void f() {
        if (this.m == null || getLayout() == null) {
            return;
        }
        int i = this.s;
        if (i == 1 || i == 3) {
            this.o = 0;
            e(false);
            return;
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        int min = Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
        int i2 = this.n;
        if (i2 == 0) {
            i2 = this.m.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - min) - s.A(this)) - i2) - this.p) - s.B(this)) / 2;
        if (b() != (this.s == 4)) {
            measuredWidth = -measuredWidth;
        }
        if (this.o != measuredWidth) {
            this.o = measuredWidth;
            e(false);
        }
    }

    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    public boolean a() {
        com.google.android.material.button.a aVar = this.h;
        return aVar != null && aVar.n();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (c()) {
            return this.h.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.m;
    }

    public int getIconGravity() {
        return this.s;
    }

    public int getIconPadding() {
        return this.p;
    }

    public int getIconSize() {
        return this.n;
    }

    public ColorStateList getIconTint() {
        return this.l;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.k;
    }

    public ColorStateList getRippleColor() {
        if (c()) {
            return this.h.f();
        }
        return null;
    }

    public b.c.a.b.a0.k getShapeAppearanceModel() {
        if (c()) {
            return this.h.g();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (c()) {
            return this.h.h();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (c()) {
            return this.h.i();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.f, a.g.k.r
    public ColorStateList getSupportBackgroundTintList() {
        return c() ? this.h.j() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.f, a.g.k.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return c() ? this.h.k() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.c.a.b.a0.h.f(this, this.h.d());
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (a()) {
            Button.mergeDrawableStates(onCreateDrawableState, t);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, u);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.google.android.material.button.a aVar;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT != 21 || (aVar = this.h) == null) {
            return;
        }
        aVar.B(i4 - i2, i3 - i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        f();
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        f();
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (c()) {
            this.h.p(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (c()) {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            } else {
                Log.w("MaterialButton", "Do not set the background; MaterialButton manages its own background drawable.");
                this.h.q();
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? a.a.k.a.a.d(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (c()) {
            this.h.r(z);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (a() && isEnabled() && this.q != z) {
            this.q = z;
            refreshDrawableState();
            if (this.r) {
                return;
            }
            this.r = true;
            Iterator<a> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.q);
            }
            this.r = false;
        }
    }

    public void setCornerRadius(int i) {
        if (c()) {
            this.h.s(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (c()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (c()) {
            this.h.d().S(f);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.m != drawable) {
            this.m = drawable;
            e(true);
        }
    }

    public void setIconGravity(int i) {
        if (this.s != i) {
            this.s = i;
            f();
        }
    }

    public void setIconPadding(int i) {
        if (this.p != i) {
            this.p = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? a.a.k.a.a.d(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.n != i) {
            this.n = i;
            e(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            e(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.k != mode) {
            this.k = mode;
            e(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(a.a.k.a.a.c(getContext(), i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    void setOnPressedChangeListenerInternal(b bVar) {
        this.j = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        b bVar = this.j;
        if (bVar != null) {
            bVar.a(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (c()) {
            this.h.t(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (c()) {
            setRippleColor(a.a.k.a.a.c(getContext(), i));
        }
    }

    @Override // b.c.a.b.a0.n
    public void setShapeAppearanceModel(b.c.a.b.a0.k kVar) {
        if (!c()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.h.u(kVar);
    }

    void setShouldDrawSurfaceColorStroke(boolean z) {
        if (c()) {
            this.h.v(z);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (c()) {
            this.h.w(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (c()) {
            setStrokeColor(a.a.k.a.a.c(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (c()) {
            this.h.x(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (c()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.f, a.g.k.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (c()) {
            this.h.y(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.f, a.g.k.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (c()) {
            this.h.z(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.q);
    }
}
