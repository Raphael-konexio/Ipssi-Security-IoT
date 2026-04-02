package b.c.a.b.o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.g;
import androidx.core.widget.c;
import b.c.a.b.b;
import b.c.a.b.j;
import b.c.a.b.k;
/* loaded from: classes.dex */
public class a extends g {
    private static final int k = j.Widget_MaterialComponents_CompoundButton_CheckBox;
    private static final int[][] l = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    private ColorStateList i;
    private boolean j;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.checkboxStyle);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(com.google.android.material.internal.g.f(context, attributeSet, i, k), attributeSet, i);
        Context context2 = getContext();
        TypedArray k2 = com.google.android.material.internal.g.k(context2, attributeSet, k.MaterialCheckBox, i, k, new int[0]);
        if (k2.hasValue(k.MaterialCheckBox_buttonTint)) {
            c.c(this, b.c.a.b.x.c.a(context2, k2, k.MaterialCheckBox_buttonTint));
        }
        this.j = k2.getBoolean(k.MaterialCheckBox_useMaterialThemeColors, false);
        k2.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.i == null) {
            int[] iArr = new int[l.length];
            int c2 = b.c.a.b.q.a.c(this, b.colorControlActivated);
            int c3 = b.c.a.b.q.a.c(this, b.colorSurface);
            int c4 = b.c.a.b.q.a.c(this, b.colorOnSurface);
            iArr[0] = b.c.a.b.q.a.f(c3, c2, 1.0f);
            iArr[1] = b.c.a.b.q.a.f(c3, c4, 0.54f);
            iArr[2] = b.c.a.b.q.a.f(c3, c4, 0.38f);
            iArr[3] = b.c.a.b.q.a.f(c3, c4, 0.38f);
            this.i = new ColorStateList(l, iArr);
        }
        return this.i;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.j && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.j = z;
        c.c(this, z ? getMaterialThemeColorsTintList() : null);
    }
}
