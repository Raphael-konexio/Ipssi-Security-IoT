package com.google.android.material.internal;

import a.g.k.s;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.i0;
import androidx.appcompat.widget.y0;
/* loaded from: classes.dex */
public class NavigationMenuItemView extends d implements n.a {
    private static final int[] K = {16842912};
    private int A;
    private boolean B;
    boolean C;
    private final CheckedTextView D;
    private FrameLayout E;
    private androidx.appcompat.view.menu.i F;
    private ColorStateList G;
    private boolean H;
    private Drawable I;
    private final a.g.k.a J;

    /* loaded from: classes.dex */
    class a extends a.g.k.a {
        a() {
        }

        @Override // a.g.k.a
        public void g(View view, a.g.k.b0.c cVar) {
            super.g(view, cVar);
            cVar.U(NavigationMenuItemView.this.C);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.J = new a();
        setOrientation(0);
        LayoutInflater.from(context).inflate(b.c.a.b.h.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(b.c.a.b.d.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(b.c.a.b.f.design_menu_item_text);
        this.D = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        s.f0(this.D, this.J);
    }

    private void B() {
        i0.a aVar;
        int i;
        if (D()) {
            this.D.setVisibility(8);
            FrameLayout frameLayout = this.E;
            if (frameLayout == null) {
                return;
            }
            aVar = (i0.a) frameLayout.getLayoutParams();
            i = -1;
        } else {
            this.D.setVisibility(0);
            FrameLayout frameLayout2 = this.E;
            if (frameLayout2 == null) {
                return;
            }
            aVar = (i0.a) frameLayout2.getLayoutParams();
            i = -2;
        }
        ((ViewGroup.MarginLayoutParams) aVar).width = i;
        this.E.setLayoutParams(aVar);
    }

    private StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(a.a.a.colorControlHighlight, typedValue, true)) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(K, new ColorDrawable(typedValue.data));
            stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            return stateListDrawable;
        }
        return null;
    }

    private boolean D() {
        return this.F.getTitle() == null && this.F.getIcon() == null && this.F.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.E == null) {
                this.E = (FrameLayout) ((ViewStub) findViewById(b.c.a.b.f.design_menu_item_action_area_stub)).inflate();
            }
            this.E.removeAllViews();
            this.E.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void e(androidx.appcompat.view.menu.i iVar, int i) {
        this.F = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            s.i0(this, C());
        }
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setTitle(iVar.getTitle());
        setIcon(iVar.getIcon());
        setActionView(iVar.getActionView());
        setContentDescription(iVar.getContentDescription());
        y0.a(this, iVar.getTooltipText());
        B();
    }

    @Override // androidx.appcompat.view.menu.n.a
    public androidx.appcompat.view.menu.i getItemData() {
        return this.F;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        androidx.appcompat.view.menu.i iVar = this.F;
        if (iVar != null && iVar.isCheckable() && this.F.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, K);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.C != z) {
            this.C = z;
            this.J.l(this.D, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.D.setChecked(z);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.H) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
                androidx.core.graphics.drawable.a.o(drawable, this.G);
            }
            int i = this.A;
            drawable.setBounds(0, 0, i, i);
        } else if (this.B) {
            if (this.I == null) {
                Drawable d2 = androidx.core.content.d.f.d(getResources(), b.c.a.b.e.navigation_empty_icon, getContext().getTheme());
                this.I = d2;
                if (d2 != null) {
                    int i2 = this.A;
                    d2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.I;
        }
        androidx.core.widget.i.i(this.D, drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.D.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.A = i;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.G = colorStateList;
        this.H = colorStateList != null;
        androidx.appcompat.view.menu.i iVar = this.F;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.D.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.B = z;
    }

    public void setTextAppearance(int i) {
        androidx.core.widget.i.n(this.D, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.D.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.D.setText(charSequence);
    }
}
