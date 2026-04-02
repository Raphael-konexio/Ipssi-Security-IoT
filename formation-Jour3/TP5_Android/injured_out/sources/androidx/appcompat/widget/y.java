package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.d.f;
import java.lang.ref.WeakReference;
import java.util.Locale;
/* loaded from: classes.dex */
class y {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f668a;

    /* renamed from: b  reason: collision with root package name */
    private u0 f669b;

    /* renamed from: c  reason: collision with root package name */
    private u0 f670c;

    /* renamed from: d  reason: collision with root package name */
    private u0 f671d;
    private u0 e;
    private u0 f;
    private u0 g;
    private u0 h;
    private final a0 i;
    private int j = 0;
    private int k = -1;
    private Typeface l;
    private boolean m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends f.c {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<y> f672a;

        /* renamed from: b  reason: collision with root package name */
        private final int f673b;

        /* renamed from: c  reason: collision with root package name */
        private final int f674c;

        /* renamed from: androidx.appcompat.widget.y$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private class RunnableC0036a implements Runnable {
            private final WeakReference<y> f;
            private final Typeface g;

            RunnableC0036a(a aVar, WeakReference<y> weakReference, Typeface typeface) {
                this.f = weakReference;
                this.g = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                y yVar = this.f.get();
                if (yVar == null) {
                    return;
                }
                yVar.B(this.g);
            }
        }

        a(y yVar, int i, int i2) {
            this.f672a = new WeakReference<>(yVar);
            this.f673b = i;
            this.f674c = i2;
        }

        @Override // androidx.core.content.d.f.c
        public void d(int i) {
        }

        @Override // androidx.core.content.d.f.c
        public void e(Typeface typeface) {
            int i;
            y yVar = this.f672a.get();
            if (yVar == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && (i = this.f673b) != -1) {
                typeface = Typeface.create(typeface, i, (this.f674c & 2) != 0);
            }
            yVar.q(new RunnableC0036a(this, this.f672a, typeface));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(TextView textView) {
        this.f668a = textView;
        this.i = new a0(this.f668a);
    }

    private void A(int i, float f) {
        this.i.y(i, f);
    }

    private void C(Context context, w0 w0Var) {
        String o;
        Typeface create;
        Typeface typeface;
        this.j = w0Var.k(a.a.j.TextAppearance_android_textStyle, this.j);
        if (Build.VERSION.SDK_INT >= 28) {
            int k = w0Var.k(a.a.j.TextAppearance_android_textFontWeight, -1);
            this.k = k;
            if (k != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        if (!w0Var.r(a.a.j.TextAppearance_android_fontFamily) && !w0Var.r(a.a.j.TextAppearance_fontFamily)) {
            if (w0Var.r(a.a.j.TextAppearance_android_typeface)) {
                this.m = false;
                int k2 = w0Var.k(a.a.j.TextAppearance_android_typeface, 1);
                if (k2 == 1) {
                    typeface = Typeface.SANS_SERIF;
                } else if (k2 == 2) {
                    typeface = Typeface.SERIF;
                } else if (k2 != 3) {
                    return;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
                this.l = typeface;
                return;
            }
            return;
        }
        this.l = null;
        int i = w0Var.r(a.a.j.TextAppearance_fontFamily) ? a.a.j.TextAppearance_fontFamily : a.a.j.TextAppearance_android_fontFamily;
        int i2 = this.k;
        int i3 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface j = w0Var.j(i, this.j, new a(this, i2, i3));
                if (j != null) {
                    if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
                        j = Typeface.create(Typeface.create(j, 0), this.k, (this.j & 2) != 0);
                    }
                    this.l = j;
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (o = w0Var.o(i)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
            create = Typeface.create(o, this.j);
        } else {
            create = Typeface.create(Typeface.create(o, 0), this.k, (this.j & 2) != 0);
        }
        this.l = create;
    }

    private void a(Drawable drawable, u0 u0Var) {
        if (drawable == null || u0Var == null) {
            return;
        }
        j.i(drawable, u0Var, this.f668a.getDrawableState());
    }

    private static u0 d(Context context, j jVar, int i) {
        ColorStateList f = jVar.f(context, i);
        if (f != null) {
            u0 u0Var = new u0();
            u0Var.f653d = true;
            u0Var.f650a = f;
            return u0Var;
        }
        return null;
    }

    private void x(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f668a.getCompoundDrawablesRelative();
            TextView textView = this.f668a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
        } else {
            if (Build.VERSION.SDK_INT >= 17) {
                Drawable[] compoundDrawablesRelative2 = this.f668a.getCompoundDrawablesRelative();
                if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                    TextView textView2 = this.f668a;
                    Drawable drawable7 = compoundDrawablesRelative2[0];
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative2[1];
                    }
                    Drawable drawable8 = compoundDrawablesRelative2[2];
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative2[3];
                    }
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                    return;
                }
            }
            Drawable[] compoundDrawables = this.f668a.getCompoundDrawables();
            TextView textView3 = this.f668a;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    private void y() {
        u0 u0Var = this.h;
        this.f669b = u0Var;
        this.f670c = u0Var;
        this.f671d = u0Var;
        this.e = u0Var;
        this.f = u0Var;
        this.g = u0Var;
    }

    public void B(Typeface typeface) {
        if (this.m) {
            this.f668a.setTypeface(typeface);
            this.l = typeface;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f669b != null || this.f670c != null || this.f671d != null || this.e != null) {
            Drawable[] compoundDrawables = this.f668a.getCompoundDrawables();
            a(compoundDrawables[0], this.f669b);
            a(compoundDrawables[1], this.f670c);
            a(compoundDrawables[2], this.f671d);
            a(compoundDrawables[3], this.e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f == null && this.g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.f668a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.i.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.i.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.i.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.i.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] h() {
        return this.i.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.i.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        u0 u0Var = this.h;
        if (u0Var != null) {
            return u0Var.f650a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        u0 u0Var = this.h;
        if (u0Var != null) {
            return u0Var.f651b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.i.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(AttributeSet attributeSet, int i) {
        String str;
        ColorStateList colorStateList;
        String str2;
        ColorStateList colorStateList2;
        boolean z;
        boolean z2;
        ColorStateList colorStateList3;
        j jVar;
        int i2;
        Context context = this.f668a.getContext();
        j b2 = j.b();
        w0 u = w0.u(context, attributeSet, a.a.j.AppCompatTextHelper, i, 0);
        int n = u.n(a.a.j.AppCompatTextHelper_android_textAppearance, -1);
        if (u.r(a.a.j.AppCompatTextHelper_android_drawableLeft)) {
            this.f669b = d(context, b2, u.n(a.a.j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (u.r(a.a.j.AppCompatTextHelper_android_drawableTop)) {
            this.f670c = d(context, b2, u.n(a.a.j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (u.r(a.a.j.AppCompatTextHelper_android_drawableRight)) {
            this.f671d = d(context, b2, u.n(a.a.j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (u.r(a.a.j.AppCompatTextHelper_android_drawableBottom)) {
            this.e = d(context, b2, u.n(a.a.j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (u.r(a.a.j.AppCompatTextHelper_android_drawableStart)) {
                this.f = d(context, b2, u.n(a.a.j.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (u.r(a.a.j.AppCompatTextHelper_android_drawableEnd)) {
                this.g = d(context, b2, u.n(a.a.j.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        u.v();
        boolean z3 = this.f668a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (n != -1) {
            w0 s = w0.s(context, n, a.a.j.TextAppearance);
            if (z3 || !s.r(a.a.j.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z = s.a(a.a.j.TextAppearance_textAllCaps, false);
                z2 = true;
            }
            C(context, s);
            if (Build.VERSION.SDK_INT < 23) {
                colorStateList3 = s.r(a.a.j.TextAppearance_android_textColor) ? s.c(a.a.j.TextAppearance_android_textColor) : null;
                colorStateList = s.r(a.a.j.TextAppearance_android_textColorHint) ? s.c(a.a.j.TextAppearance_android_textColorHint) : null;
                colorStateList2 = s.r(a.a.j.TextAppearance_android_textColorLink) ? s.c(a.a.j.TextAppearance_android_textColorLink) : null;
            } else {
                colorStateList = null;
                colorStateList2 = null;
                colorStateList3 = null;
            }
            str = s.r(a.a.j.TextAppearance_textLocale) ? s.o(a.a.j.TextAppearance_textLocale) : null;
            str2 = (Build.VERSION.SDK_INT < 26 || !s.r(a.a.j.TextAppearance_fontVariationSettings)) ? null : s.o(a.a.j.TextAppearance_fontVariationSettings);
            s.v();
        } else {
            str = null;
            colorStateList = null;
            str2 = null;
            colorStateList2 = null;
            z = false;
            z2 = false;
            colorStateList3 = null;
        }
        w0 u2 = w0.u(context, attributeSet, a.a.j.TextAppearance, i, 0);
        if (!z3 && u2.r(a.a.j.TextAppearance_textAllCaps)) {
            z = u2.a(a.a.j.TextAppearance_textAllCaps, false);
            z2 = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (u2.r(a.a.j.TextAppearance_android_textColor)) {
                colorStateList3 = u2.c(a.a.j.TextAppearance_android_textColor);
            }
            if (u2.r(a.a.j.TextAppearance_android_textColorHint)) {
                colorStateList = u2.c(a.a.j.TextAppearance_android_textColorHint);
            }
            if (u2.r(a.a.j.TextAppearance_android_textColorLink)) {
                colorStateList2 = u2.c(a.a.j.TextAppearance_android_textColorLink);
            }
        }
        if (u2.r(a.a.j.TextAppearance_textLocale)) {
            str = u2.o(a.a.j.TextAppearance_textLocale);
        }
        if (Build.VERSION.SDK_INT >= 26 && u2.r(a.a.j.TextAppearance_fontVariationSettings)) {
            str2 = u2.o(a.a.j.TextAppearance_fontVariationSettings);
        }
        if (Build.VERSION.SDK_INT >= 28 && u2.r(a.a.j.TextAppearance_android_textSize) && u2.f(a.a.j.TextAppearance_android_textSize, -1) == 0) {
            jVar = b2;
            this.f668a.setTextSize(0, 0.0f);
        } else {
            jVar = b2;
        }
        C(context, u2);
        u2.v();
        if (colorStateList3 != null) {
            this.f668a.setTextColor(colorStateList3);
        }
        if (colorStateList != null) {
            this.f668a.setHintTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.f668a.setLinkTextColor(colorStateList2);
        }
        if (!z3 && z2) {
            r(z);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                this.f668a.setTypeface(typeface, this.j);
            } else {
                this.f668a.setTypeface(typeface);
            }
        }
        if (str2 != null) {
            this.f668a.setFontVariationSettings(str2);
        }
        if (str != null) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 24) {
                this.f668a.setTextLocales(LocaleList.forLanguageTags(str));
            } else if (i3 >= 21) {
                this.f668a.setTextLocale(Locale.forLanguageTag(str.substring(0, str.indexOf(44))));
            }
        }
        this.i.t(attributeSet, i);
        if (androidx.core.widget.b.f771a && this.i.n() != 0) {
            int[] m = this.i.m();
            if (m.length > 0) {
                if (this.f668a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f668a.setAutoSizeTextTypeUniformWithConfiguration(this.i.k(), this.i.j(), this.i.l(), 0);
                } else {
                    this.f668a.setAutoSizeTextTypeUniformWithPresetSizes(m, 0);
                }
            }
        }
        w0 t = w0.t(context, attributeSet, a.a.j.AppCompatTextView);
        int n2 = t.n(a.a.j.AppCompatTextView_drawableLeftCompat, -1);
        j jVar2 = jVar;
        Drawable c2 = n2 != -1 ? jVar2.c(context, n2) : null;
        int n3 = t.n(a.a.j.AppCompatTextView_drawableTopCompat, -1);
        Drawable c3 = n3 != -1 ? jVar2.c(context, n3) : null;
        int n4 = t.n(a.a.j.AppCompatTextView_drawableRightCompat, -1);
        Drawable c4 = n4 != -1 ? jVar2.c(context, n4) : null;
        int n5 = t.n(a.a.j.AppCompatTextView_drawableBottomCompat, -1);
        Drawable c5 = n5 != -1 ? jVar2.c(context, n5) : null;
        int n6 = t.n(a.a.j.AppCompatTextView_drawableStartCompat, -1);
        Drawable c6 = n6 != -1 ? jVar2.c(context, n6) : null;
        int n7 = t.n(a.a.j.AppCompatTextView_drawableEndCompat, -1);
        x(c2, c3, c4, c5, c6, n7 != -1 ? jVar2.c(context, n7) : null);
        if (t.r(a.a.j.AppCompatTextView_drawableTint)) {
            androidx.core.widget.i.g(this.f668a, t.c(a.a.j.AppCompatTextView_drawableTint));
        }
        if (t.r(a.a.j.AppCompatTextView_drawableTintMode)) {
            i2 = -1;
            androidx.core.widget.i.h(this.f668a, e0.d(t.k(a.a.j.AppCompatTextView_drawableTintMode, -1), null));
        } else {
            i2 = -1;
        }
        int f = t.f(a.a.j.AppCompatTextView_firstBaselineToTopHeight, i2);
        int f2 = t.f(a.a.j.AppCompatTextView_lastBaselineToBottomHeight, i2);
        int f3 = t.f(a.a.j.AppCompatTextView_lineHeight, i2);
        t.v();
        if (f != i2) {
            androidx.core.widget.i.j(this.f668a, f);
        }
        if (f2 != i2) {
            androidx.core.widget.i.k(this.f668a, f2);
        }
        if (f3 != i2) {
            androidx.core.widget.i.l(this.f668a, f3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(boolean z, int i, int i2, int i3, int i4) {
        if (androidx.core.widget.b.f771a) {
            return;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Context context, int i) {
        String o;
        ColorStateList c2;
        w0 s = w0.s(context, i, a.a.j.TextAppearance);
        if (s.r(a.a.j.TextAppearance_textAllCaps)) {
            r(s.a(a.a.j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && s.r(a.a.j.TextAppearance_android_textColor) && (c2 = s.c(a.a.j.TextAppearance_android_textColor)) != null) {
            this.f668a.setTextColor(c2);
        }
        if (s.r(a.a.j.TextAppearance_android_textSize) && s.f(a.a.j.TextAppearance_android_textSize, -1) == 0) {
            this.f668a.setTextSize(0, 0.0f);
        }
        C(context, s);
        if (Build.VERSION.SDK_INT >= 26 && s.r(a.a.j.TextAppearance_fontVariationSettings) && (o = s.o(a.a.j.TextAppearance_fontVariationSettings)) != null) {
            this.f668a.setFontVariationSettings(o);
        }
        s.v();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.f668a.setTypeface(typeface, this.j);
        }
    }

    public void q(Runnable runnable) {
        this.f668a.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z) {
        this.f668a.setAllCaps(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i, int i2, int i3, int i4) {
        this.i.u(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int[] iArr, int i) {
        this.i.v(iArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i) {
        this.i.w(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new u0();
        }
        u0 u0Var = this.h;
        u0Var.f650a = colorStateList;
        u0Var.f653d = colorStateList != null;
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new u0();
        }
        u0 u0Var = this.h;
        u0Var.f651b = mode;
        u0Var.f652c = mode != null;
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(int i, float f) {
        if (androidx.core.widget.b.f771a || l()) {
            return;
        }
        A(i, f);
    }
}
