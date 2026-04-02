package b.c.a.b.n;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import b.c.a.b.a0.h;
import b.c.a.b.a0.k;
import b.c.a.b.a0.n;
/* loaded from: classes.dex */
public class a extends a.c.a.a implements Checkable, n {
    private static final int[] p = {16842911};
    private static final int[] q = {16842912};
    private static final int[] r = {b.c.a.b.b.state_dragged};
    private final b k;
    private boolean l;
    private boolean m;
    private boolean n;
    private InterfaceC0059a o;

    /* renamed from: b.c.a.b.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
        void a(a aVar, boolean z);
    }

    private void d() {
        if (Build.VERSION.SDK_INT > 26) {
            this.k.a();
        }
    }

    public boolean e() {
        b bVar = this.k;
        return bVar != null && bVar.o();
    }

    public boolean f() {
        return this.n;
    }

    @Override // a.c.a.a
    public ColorStateList getCardBackgroundColor() {
        return this.k.c();
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.k.d();
    }

    public ColorStateList getCheckedIconTint() {
        return this.k.e();
    }

    @Override // a.c.a.a
    public int getContentPaddingBottom() {
        return this.k.m().bottom;
    }

    @Override // a.c.a.a
    public int getContentPaddingLeft() {
        return this.k.m().left;
    }

    @Override // a.c.a.a
    public int getContentPaddingRight() {
        return this.k.m().right;
    }

    @Override // a.c.a.a
    public int getContentPaddingTop() {
        return this.k.m().top;
    }

    public float getProgress() {
        return this.k.g();
    }

    @Override // a.c.a.a
    public float getRadius() {
        return this.k.f();
    }

    public ColorStateList getRippleColor() {
        return this.k.h();
    }

    public k getShapeAppearanceModel() {
        return this.k.i();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.k.j();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.k.k();
    }

    public int getStrokeWidth() {
        return this.k.l();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.m;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, this.k.b());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (e()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, p);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, q);
        }
        if (f()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, r);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(a.c.a.a.class.getName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(a.c.a.a.class.getName());
        accessibilityNodeInfo.setCheckable(e());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // a.c.a.a, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.k.p(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.l) {
            if (!this.k.n()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.k.q(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // a.c.a.a
    public void setCardBackgroundColor(int i) {
        this.k.r(ColorStateList.valueOf(i));
    }

    @Override // a.c.a.a
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.k.r(colorStateList);
    }

    @Override // a.c.a.a
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        this.k.D();
    }

    public void setCheckable(boolean z) {
        this.k.s(z);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.m != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.k.t(drawable);
    }

    public void setCheckedIconResource(int i) {
        this.k.t(a.a.k.a.a.d(getContext(), i));
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.k.u(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        this.k.B();
    }

    public void setDragged(boolean z) {
        if (this.n != z) {
            this.n = z;
            refreshDrawableState();
            d();
            invalidate();
        }
    }

    @Override // a.c.a.a
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.k.E();
    }

    public void setOnCheckedChangeListener(InterfaceC0059a interfaceC0059a) {
        this.o = interfaceC0059a;
    }

    @Override // a.c.a.a
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.k.E();
        this.k.C();
    }

    public void setProgress(float f) {
        this.k.w(f);
    }

    @Override // a.c.a.a
    public void setRadius(float f) {
        super.setRadius(f);
        this.k.v(f);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.k.x(colorStateList);
    }

    public void setRippleColorResource(int i) {
        this.k.x(a.a.k.a.a.c(getContext(), i));
    }

    @Override // b.c.a.b.a0.n
    public void setShapeAppearanceModel(k kVar) {
        this.k.y(kVar);
    }

    public void setStrokeColor(int i) {
        this.k.z(ColorStateList.valueOf(i));
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.k.z(colorStateList);
    }

    public void setStrokeWidth(int i) {
        this.k.A(i);
    }

    @Override // a.c.a.a
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.k.E();
        this.k.C();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (e() && isEnabled()) {
            this.m = !this.m;
            refreshDrawableState();
            d();
            InterfaceC0059a interfaceC0059a = this.o;
            if (interfaceC0059a != null) {
                interfaceC0059a.a(this, this.m);
            }
        }
    }
}
