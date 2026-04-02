package com.google.android.material.transformation;

import a.g.k.s;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* renamed from: a  reason: collision with root package name */
    private int f1859a;

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View f;
        final /* synthetic */ int g;
        final /* synthetic */ b.c.a.b.u.a h;

        a(View view, int i, b.c.a.b.u.a aVar) {
            this.f = view;
            this.g = i;
            this.h = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f1859a == this.g) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                b.c.a.b.u.a aVar = this.h;
                expandableBehavior.H((View) aVar, this.f, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f1859a = 0;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1859a = 0;
    }

    private boolean F(boolean z) {
        if (!z) {
            return this.f1859a == 1;
        }
        int i = this.f1859a;
        return i == 0 || i == 2;
    }

    protected b.c.a.b.u.a G(CoordinatorLayout coordinatorLayout, View view) {
        List<View> r = coordinatorLayout.r(view);
        int size = r.size();
        for (int i = 0; i < size; i++) {
            View view2 = r.get(i);
            if (e(coordinatorLayout, view, view2)) {
                return (b.c.a.b.u.a) view2;
            }
        }
        return null;
    }

    protected abstract boolean H(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b.c.a.b.u.a aVar = (b.c.a.b.u.a) view2;
        if (F(aVar.a())) {
            this.f1859a = aVar.a() ? 1 : 2;
            return H((View) aVar, view, aVar.a(), true);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        b.c.a.b.u.a G;
        if (s.M(view) || (G = G(coordinatorLayout, view)) == null || !F(G.a())) {
            return false;
        }
        int i2 = G.a() ? 1 : 2;
        this.f1859a = i2;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i2, G));
        return false;
    }
}
