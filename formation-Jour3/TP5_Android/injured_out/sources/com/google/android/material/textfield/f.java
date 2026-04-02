package com.google.android.material.textfield;

import a.g.k.s;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.z;
import androidx.core.widget.i;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1849a;

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f1850b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f1851c;

    /* renamed from: d  reason: collision with root package name */
    private int f1852d;
    private FrameLayout e;
    private int f;
    private Animator g;
    private final float h;
    private int i;
    private int j;
    private CharSequence k;
    private boolean l;
    private TextView m;
    private int n;
    private ColorStateList o;
    private CharSequence p;
    private boolean q;
    private TextView r;
    private int s;
    private ColorStateList t;
    private Typeface u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1853a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f1854b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f1855c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TextView f1856d;

        a(int i, TextView textView, int i2, TextView textView2) {
            this.f1853a = i;
            this.f1854b = textView;
            this.f1855c = i2;
            this.f1856d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.i = this.f1853a;
            f.this.g = null;
            TextView textView = this.f1854b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f1855c == 1 && f.this.m != null) {
                    f.this.m.setText((CharSequence) null);
                }
                TextView textView2 = this.f1856d;
                if (textView2 != null) {
                    textView2.setTranslationY(0.0f);
                    this.f1856d.setAlpha(1.0f);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f1856d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public f(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f1849a = context;
        this.f1850b = textInputLayout;
        this.h = context.getResources().getDimensionPixelSize(b.c.a.b.d.design_textinput_caption_translate_y);
    }

    private void F(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void H(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean I(TextView textView, CharSequence charSequence) {
        return s.M(this.f1850b) && this.f1850b.isEnabled() && !(this.j == this.i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void L(int i, int i2, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.g = animatorSet;
            ArrayList arrayList = new ArrayList();
            h(arrayList, this.q, this.r, 2, i, i2);
            h(arrayList, this.l, this.m, 1, i, i2);
            b.c.a.b.l.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i2, l(i), i, l(i2)));
            animatorSet.start();
        } else {
            y(i, i2);
        }
        this.f1850b.Y();
        this.f1850b.c0(z);
        this.f1850b.e0();
    }

    private boolean f() {
        return (this.f1851c == null || this.f1850b.getEditText() == null) ? false : true;
    }

    private void h(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            list.add(i(textView, i3 == i));
            if (i3 == i) {
                list.add(j(textView));
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, z ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(b.c.a.b.l.a.f1340a);
        return ofFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.h, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(b.c.a.b.l.a.f1343d);
        return ofFloat;
    }

    private TextView l(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return this.r;
        }
        return this.m;
    }

    private boolean t(int i) {
        return (i != 1 || this.m == null || TextUtils.isEmpty(this.k)) ? false : true;
    }

    private void y(int i, int i2) {
        TextView l;
        TextView l2;
        if (i == i2) {
            return;
        }
        if (i2 != 0 && (l2 = l(i2)) != null) {
            l2.setVisibility(0);
            l2.setAlpha(1.0f);
        }
        if (i != 0 && (l = l(i)) != null) {
            l.setVisibility(4);
            if (i == 1) {
                l.setText((CharSequence) null);
            }
        }
        this.i = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(int i) {
        this.n = i;
        TextView textView = this.m;
        if (textView != null) {
            this.f1850b.Q(textView, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(ColorStateList colorStateList) {
        this.o = colorStateList;
        TextView textView = this.m;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(int i) {
        this.s = i;
        TextView textView = this.r;
        if (textView != null) {
            i.n(textView, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(boolean z) {
        if (this.q == z) {
            return;
        }
        g();
        if (z) {
            z zVar = new z(this.f1849a);
            this.r = zVar;
            zVar.setId(b.c.a.b.f.textinput_helper_text);
            Typeface typeface = this.u;
            if (typeface != null) {
                this.r.setTypeface(typeface);
            }
            this.r.setVisibility(4);
            s.h0(this.r, 1);
            C(this.s);
            E(this.t);
            d(this.r, 1);
        } else {
            s();
            x(this.r, 1);
            this.r = null;
            this.f1850b.Y();
            this.f1850b.e0();
        }
        this.q = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(ColorStateList colorStateList) {
        this.t = colorStateList;
        TextView textView = this.r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(Typeface typeface) {
        if (typeface != this.u) {
            this.u = typeface;
            F(this.m, typeface);
            F(this.r, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(CharSequence charSequence) {
        g();
        this.k = charSequence;
        this.m.setText(charSequence);
        if (this.i != 1) {
            this.j = 1;
        }
        L(this.i, this.j, I(this.m, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(CharSequence charSequence) {
        g();
        this.p = charSequence;
        this.r.setText(charSequence);
        if (this.i != 2) {
            this.j = 2;
        }
        L(this.i, this.j, I(this.r, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TextView textView, int i) {
        if (this.f1851c == null && this.e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f1849a);
            this.f1851c = linearLayout;
            linearLayout.setOrientation(0);
            this.f1850b.addView(this.f1851c, -1, -2);
            FrameLayout frameLayout = new FrameLayout(this.f1849a);
            this.e = frameLayout;
            this.f1851c.addView(frameLayout, -1, new FrameLayout.LayoutParams(-2, -2));
            this.f1851c.addView(new Space(this.f1849a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f1850b.getEditText() != null) {
                e();
            }
        }
        if (u(i)) {
            this.e.setVisibility(0);
            this.e.addView(textView);
            this.f++;
        } else {
            this.f1851c.addView(textView, i);
        }
        this.f1851c.setVisibility(0);
        this.f1852d++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (f()) {
            s.s0(this.f1851c, s.B(this.f1850b.getEditText()), 0, s.A(this.f1850b.getEditText()), 0);
        }
    }

    void g() {
        Animator animator = this.g;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return t(this.j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence m() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList o() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence p() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        TextView textView = this.r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.k = null;
        g();
        if (this.i == 1) {
            this.j = (!this.q || TextUtils.isEmpty(this.p)) ? 0 : 2;
        }
        L(this.i, this.j, I(this.m, null));
    }

    void s() {
        g();
        if (this.i == 2) {
            this.j = 0;
        }
        L(this.i, this.j, I(this.r, null));
    }

    boolean u(int i) {
        return i == 0 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.f1851c == null) {
            return;
        }
        if (!u(i) || (frameLayout = this.e) == null) {
            this.f1851c.removeView(textView);
        } else {
            int i2 = this.f - 1;
            this.f = i2;
            H(frameLayout, i2);
            this.e.removeView(textView);
        }
        int i3 = this.f1852d - 1;
        this.f1852d = i3;
        H(this.f1851c, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(boolean z) {
        if (this.l == z) {
            return;
        }
        g();
        if (z) {
            z zVar = new z(this.f1849a);
            this.m = zVar;
            zVar.setId(b.c.a.b.f.textinput_error);
            Typeface typeface = this.u;
            if (typeface != null) {
                this.m.setTypeface(typeface);
            }
            A(this.n);
            B(this.o);
            this.m.setVisibility(4);
            s.h0(this.m, 1);
            d(this.m, 0);
        } else {
            r();
            x(this.m, 0);
            this.m = null;
            this.f1850b.Y();
            this.f1850b.e0();
        }
        this.l = z;
    }
}
