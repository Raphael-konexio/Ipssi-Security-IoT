package com.google.android.material.appbar;

import a.g.k.s;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import b.c.a.b.a0.h;
import b.c.a.b.j;
import com.google.android.material.internal.g;
/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    private static final int U = j.Widget_MaterialComponents_Toolbar;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.c.a.b.b.toolbarStyle);
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet, int i) {
        super(g.f(context, attributeSet, i, U), attributeSet, i);
        P(getContext());
    }

    private void P(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            b.c.a.b.a0.g gVar = new b.c.a.b.a0.g();
            gVar.T(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            gVar.L(context);
            gVar.S(s.r(this));
            s.i0(this, gVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        h.d(this, f);
    }
}
