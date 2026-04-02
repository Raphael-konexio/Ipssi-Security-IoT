package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    private int f1676a;

    /* renamed from: b  reason: collision with root package name */
    private int f1677b;

    /* renamed from: c  reason: collision with root package name */
    private int f1678c;

    /* renamed from: d  reason: collision with root package name */
    private ViewPropertyAnimator f1679d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f1679d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f1676a = 0;
        this.f1677b = 2;
        this.f1678c = 0;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1676a = 0;
        this.f1677b = 2;
        this.f1678c = 0;
    }

    private void F(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.f1679d = v.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new a());
    }

    public void G(V v, int i) {
        this.f1678c = i;
        if (this.f1677b == 1) {
            v.setTranslationY(this.f1676a + i);
        }
    }

    public void H(V v) {
        if (this.f1677b == 1) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f1679d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f1677b = 1;
        F(v, this.f1676a + this.f1678c, 175L, b.c.a.b.l.a.f1342c);
    }

    public void I(V v) {
        if (this.f1677b == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f1679d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f1677b = 2;
        F(v, 0, 225L, b.c.a.b.l.a.f1343d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.f1676a = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        return super.l(coordinatorLayout, v, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void r(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        if (i2 > 0) {
            H(v);
        } else if (i2 < 0) {
            I(v);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean z(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        return i == 2;
    }
}
