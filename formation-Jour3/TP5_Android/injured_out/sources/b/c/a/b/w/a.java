package b.c.a.b.w;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.s;
import androidx.core.widget.c;
import b.c.a.b.b;
import b.c.a.b.j;
import b.c.a.b.k;
import com.google.android.material.internal.g;
/* loaded from: classes.dex */
public class a extends s {
    private static final int k = j.Widget_MaterialComponents_CompoundButton_RadioButton;
    private static final int[][] l = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    private ColorStateList i;
    private boolean j;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.radioButtonStyle);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(g.f(context, attributeSet, i, k), attributeSet, i);
        TypedArray k2 = g.k(getContext(), attributeSet, k.MaterialRadioButton, i, k, new int[0]);
        this.j = k2.getBoolean(k.MaterialRadioButton_useMaterialThemeColors, false);
        k2.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.i == null) {
            int c2 = b.c.a.b.q.a.c(this, b.colorControlActivated);
            int c3 = b.c.a.b.q.a.c(this, b.colorOnSurface);
            int c4 = b.c.a.b.q.a.c(this, b.colorSurface);
            int[] iArr = new int[l.length];
            iArr[0] = b.c.a.b.q.a.f(c4, c2, 1.0f);
            iArr[1] = b.c.a.b.q.a.f(c4, c3, 0.54f);
            iArr[2] = b.c.a.b.q.a.f(c4, c3, 0.38f);
            iArr[3] = b.c.a.b.q.a.f(c4, c3, 0.38f);
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
