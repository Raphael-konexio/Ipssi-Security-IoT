package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
/* loaded from: classes.dex */
public class i extends ImageButton {
    private int f;

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = getVisibility();
    }

    public final void b(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        b(i, true);
    }
}
