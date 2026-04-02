package com.google.android.material.textfield;

import a.g.k.s;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.w0;
import androidx.appcompat.widget.z;
import b.c.a.b.a0.k;
import b.c.a.b.i;
import b.c.a.b.j;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    private static final int w0 = j.Widget_Design_TextInputLayout;
    private final int A;
    private int B;
    private final int C;
    private final int D;
    private int E;
    private int F;
    private final Rect G;
    private final Rect H;
    private final RectF I;
    private Typeface J;
    private final CheckableImageButton K;
    private ColorStateList L;
    private boolean M;
    private PorterDuff.Mode N;
    private boolean O;
    private Drawable P;
    private View.OnLongClickListener Q;
    private final LinkedHashSet<f> R;
    private int S;
    private final SparseArray<com.google.android.material.textfield.e> T;
    private final CheckableImageButton U;
    private final LinkedHashSet<g> V;
    private ColorStateList W;
    private boolean a0;
    private PorterDuff.Mode b0;
    private boolean c0;
    private Drawable d0;
    private Drawable e0;
    private final FrameLayout f;
    private final CheckableImageButton f0;
    private final FrameLayout g;
    private View.OnLongClickListener g0;
    EditText h;
    private ColorStateList h0;
    private CharSequence i;
    private ColorStateList i0;
    private final com.google.android.material.textfield.f j;
    private final int j0;
    boolean k;
    private final int k0;
    private int l;
    private int l0;
    private boolean m;
    private int m0;
    private TextView n;
    private final int n0;
    private int o;
    private final int o0;
    private int p;
    private final int p0;
    private ColorStateList q;
    private boolean q0;
    private ColorStateList r;
    final com.google.android.material.internal.a r0;
    private boolean s;
    private boolean s0;
    private CharSequence t;
    private ValueAnimator t0;
    private boolean u;
    private boolean u0;
    private b.c.a.b.a0.g v;
    private boolean v0;
    private b.c.a.b.a0.g w;
    private k x;
    private final int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.c0(!textInputLayout.v0);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.k) {
                textInputLayout2.V(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.U.performClick();
            TextInputLayout.this.U.jumpDrawablesToCurrentState();
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.h.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.r0.O(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public static class e extends a.g.k.a {

        /* renamed from: d  reason: collision with root package name */
        private final TextInputLayout f1834d;

        public e(TextInputLayout textInputLayout) {
            this.f1834d = textInputLayout;
        }

        @Override // a.g.k.a
        public void g(View view, a.g.k.b0.c cVar) {
            super.g(view, cVar);
            EditText editText = this.f1834d.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f1834d.getHint();
            CharSequence error = this.f1834d.getError();
            CharSequence counterOverflowDescription = this.f1834d.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                cVar.s0(text);
            } else if (z2) {
                cVar.s0(hint);
            }
            if (z2) {
                cVar.i0(hint);
                if (!z && z2) {
                    z4 = true;
                }
                cVar.p0(z4);
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                cVar.e0(error);
                cVar.b0(true);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(TextInputLayout textInputLayout, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h extends a.i.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();
        CharSequence h;
        boolean i;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public h[] newArray(int i) {
                return new h[i];
            }
        }

        h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.i = parcel.readInt() == 1;
        }

        h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.h) + "}";
        }

        @Override // a.i.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.h, parcel, i);
            parcel.writeInt(this.i ? 1 : 0);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.c.a.b.b.textInputStyle);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(com.google.android.material.internal.g.f(context, attributeSet, i, w0), attributeSet, i);
        int colorForState;
        this.j = new com.google.android.material.textfield.f(this);
        this.G = new Rect();
        this.H = new Rect();
        this.I = new RectF();
        this.R = new LinkedHashSet<>();
        this.S = 0;
        this.T = new SparseArray<>();
        this.V = new LinkedHashSet<>();
        this.r0 = new com.google.android.material.internal.a(this);
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(this.f);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.g = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 8388629));
        this.f.addView(this.g);
        this.r0.T(b.c.a.b.l.a.f1340a);
        this.r0.Q(b.c.a.b.l.a.f1340a);
        this.r0.F(8388659);
        w0 l = com.google.android.material.internal.g.l(context2, attributeSet, b.c.a.b.k.TextInputLayout, i, w0, b.c.a.b.k.TextInputLayout_counterTextAppearance, b.c.a.b.k.TextInputLayout_counterOverflowTextAppearance, b.c.a.b.k.TextInputLayout_errorTextAppearance, b.c.a.b.k.TextInputLayout_helperTextTextAppearance, b.c.a.b.k.TextInputLayout_hintTextAppearance);
        this.s = l.a(b.c.a.b.k.TextInputLayout_hintEnabled, true);
        setHint(l.p(b.c.a.b.k.TextInputLayout_android_hint));
        this.s0 = l.a(b.c.a.b.k.TextInputLayout_hintAnimationEnabled, true);
        this.x = k.e(context2, attributeSet, i, w0).m();
        this.y = context2.getResources().getDimensionPixelOffset(b.c.a.b.d.mtrl_textinput_box_label_cutout_padding);
        this.A = l.e(b.c.a.b.k.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.C = l.f(b.c.a.b.k.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(b.c.a.b.d.mtrl_textinput_box_stroke_width_default));
        this.D = l.f(b.c.a.b.k.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(b.c.a.b.d.mtrl_textinput_box_stroke_width_focused));
        this.B = this.C;
        float d2 = l.d(b.c.a.b.k.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float d3 = l.d(b.c.a.b.k.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float d4 = l.d(b.c.a.b.k.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float d5 = l.d(b.c.a.b.k.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        k.b v = this.x.v();
        if (d2 >= 0.0f) {
            v.z(d2);
        }
        if (d3 >= 0.0f) {
            v.D(d3);
        }
        if (d4 >= 0.0f) {
            v.v(d4);
        }
        if (d5 >= 0.0f) {
            v.r(d5);
        }
        this.x = v.m();
        ColorStateList b2 = b.c.a.b.x.c.b(context2, l, b.c.a.b.k.TextInputLayout_boxBackgroundColor);
        if (b2 != null) {
            int defaultColor = b2.getDefaultColor();
            this.m0 = defaultColor;
            this.F = defaultColor;
            if (b2.isStateful()) {
                this.n0 = b2.getColorForState(new int[]{-16842910}, -1);
                colorForState = b2.getColorForState(new int[]{16843623}, -1);
            } else {
                ColorStateList c2 = a.a.k.a.a.c(context2, b.c.a.b.c.mtrl_filled_background_color);
                this.n0 = c2.getColorForState(new int[]{-16842910}, -1);
                colorForState = c2.getColorForState(new int[]{16843623}, -1);
            }
            this.o0 = colorForState;
        } else {
            this.F = 0;
            this.m0 = 0;
            this.n0 = 0;
            this.o0 = 0;
        }
        if (l.r(b.c.a.b.k.TextInputLayout_android_textColorHint)) {
            ColorStateList c3 = l.c(b.c.a.b.k.TextInputLayout_android_textColorHint);
            this.i0 = c3;
            this.h0 = c3;
        }
        ColorStateList b3 = b.c.a.b.x.c.b(context2, l, b.c.a.b.k.TextInputLayout_boxStrokeColor);
        if (b3 == null || !b3.isStateful()) {
            this.l0 = l.b(b.c.a.b.k.TextInputLayout_boxStrokeColor, 0);
            this.j0 = androidx.core.content.a.b(context2, b.c.a.b.c.mtrl_textinput_default_box_stroke_color);
            this.p0 = androidx.core.content.a.b(context2, b.c.a.b.c.mtrl_textinput_disabled_color);
            this.k0 = androidx.core.content.a.b(context2, b.c.a.b.c.mtrl_textinput_hovered_box_stroke_color);
        } else {
            this.j0 = b3.getDefaultColor();
            this.p0 = b3.getColorForState(new int[]{-16842910}, -1);
            this.k0 = b3.getColorForState(new int[]{16843623}, -1);
            this.l0 = b3.getColorForState(new int[]{16842908}, -1);
        }
        if (l.n(b.c.a.b.k.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(l.n(b.c.a.b.k.TextInputLayout_hintTextAppearance, 0));
        }
        int n = l.n(b.c.a.b.k.TextInputLayout_errorTextAppearance, 0);
        boolean a2 = l.a(b.c.a.b.k.TextInputLayout_errorEnabled, false);
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(b.c.a.b.h.design_text_input_end_icon, (ViewGroup) this.f, false);
        this.f0 = checkableImageButton;
        this.f.addView(checkableImageButton);
        this.f0.setVisibility(8);
        if (l.r(b.c.a.b.k.TextInputLayout_errorIconDrawable)) {
            setErrorIconDrawable(l.g(b.c.a.b.k.TextInputLayout_errorIconDrawable));
        }
        if (l.r(b.c.a.b.k.TextInputLayout_errorIconTint)) {
            setErrorIconTintList(b.c.a.b.x.c.b(context2, l, b.c.a.b.k.TextInputLayout_errorIconTint));
        }
        if (l.r(b.c.a.b.k.TextInputLayout_errorIconTintMode)) {
            setErrorIconTintMode(com.google.android.material.internal.h.c(l.k(b.c.a.b.k.TextInputLayout_errorIconTintMode, -1), null));
        }
        this.f0.setContentDescription(getResources().getText(i.error_icon_content_description));
        s.p0(this.f0, 2);
        this.f0.setClickable(false);
        this.f0.setPressable(false);
        this.f0.setFocusable(false);
        int n2 = l.n(b.c.a.b.k.TextInputLayout_helperTextTextAppearance, 0);
        boolean a3 = l.a(b.c.a.b.k.TextInputLayout_helperTextEnabled, false);
        CharSequence p = l.p(b.c.a.b.k.TextInputLayout_helperText);
        boolean a4 = l.a(b.c.a.b.k.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(l.k(b.c.a.b.k.TextInputLayout_counterMaxLength, -1));
        this.p = l.n(b.c.a.b.k.TextInputLayout_counterTextAppearance, 0);
        this.o = l.n(b.c.a.b.k.TextInputLayout_counterOverflowTextAppearance, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(b.c.a.b.h.design_text_input_start_icon, (ViewGroup) this.f, false);
        this.K = checkableImageButton2;
        this.f.addView(checkableImageButton2);
        this.K.setVisibility(8);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (l.r(b.c.a.b.k.TextInputLayout_startIconDrawable)) {
            setStartIconDrawable(l.g(b.c.a.b.k.TextInputLayout_startIconDrawable));
            if (l.r(b.c.a.b.k.TextInputLayout_startIconContentDescription)) {
                setStartIconContentDescription(l.p(b.c.a.b.k.TextInputLayout_startIconContentDescription));
            }
            setStartIconCheckable(l.a(b.c.a.b.k.TextInputLayout_startIconCheckable, true));
        }
        if (l.r(b.c.a.b.k.TextInputLayout_startIconTint)) {
            setStartIconTintList(b.c.a.b.x.c.b(context2, l, b.c.a.b.k.TextInputLayout_startIconTint));
        }
        if (l.r(b.c.a.b.k.TextInputLayout_startIconTintMode)) {
            setStartIconTintMode(com.google.android.material.internal.h.c(l.k(b.c.a.b.k.TextInputLayout_startIconTintMode, -1), null));
        }
        setHelperTextEnabled(a3);
        setHelperText(p);
        setHelperTextTextAppearance(n2);
        setErrorEnabled(a2);
        setErrorTextAppearance(n);
        setCounterTextAppearance(this.p);
        setCounterOverflowTextAppearance(this.o);
        if (l.r(b.c.a.b.k.TextInputLayout_errorTextColor)) {
            setErrorTextColor(l.c(b.c.a.b.k.TextInputLayout_errorTextColor));
        }
        if (l.r(b.c.a.b.k.TextInputLayout_helperTextTextColor)) {
            setHelperTextColor(l.c(b.c.a.b.k.TextInputLayout_helperTextTextColor));
        }
        if (l.r(b.c.a.b.k.TextInputLayout_hintTextColor)) {
            setHintTextColor(l.c(b.c.a.b.k.TextInputLayout_hintTextColor));
        }
        if (l.r(b.c.a.b.k.TextInputLayout_counterTextColor)) {
            setCounterTextColor(l.c(b.c.a.b.k.TextInputLayout_counterTextColor));
        }
        if (l.r(b.c.a.b.k.TextInputLayout_counterOverflowTextColor)) {
            setCounterOverflowTextColor(l.c(b.c.a.b.k.TextInputLayout_counterOverflowTextColor));
        }
        setCounterEnabled(a4);
        setBoxBackgroundMode(l.k(b.c.a.b.k.TextInputLayout_boxBackgroundMode, 0));
        CheckableImageButton checkableImageButton3 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(b.c.a.b.h.design_text_input_end_icon, (ViewGroup) this.g, false);
        this.U = checkableImageButton3;
        this.g.addView(checkableImageButton3);
        this.U.setVisibility(8);
        this.T.append(-1, new com.google.android.material.textfield.b(this));
        this.T.append(0, new com.google.android.material.textfield.g(this));
        this.T.append(1, new com.google.android.material.textfield.h(this));
        this.T.append(2, new com.google.android.material.textfield.a(this));
        this.T.append(3, new com.google.android.material.textfield.d(this));
        if (l.r(b.c.a.b.k.TextInputLayout_endIconMode)) {
            setEndIconMode(l.k(b.c.a.b.k.TextInputLayout_endIconMode, 0));
            if (l.r(b.c.a.b.k.TextInputLayout_endIconDrawable)) {
                setEndIconDrawable(l.g(b.c.a.b.k.TextInputLayout_endIconDrawable));
            }
            if (l.r(b.c.a.b.k.TextInputLayout_endIconContentDescription)) {
                setEndIconContentDescription(l.p(b.c.a.b.k.TextInputLayout_endIconContentDescription));
            }
            setEndIconCheckable(l.a(b.c.a.b.k.TextInputLayout_endIconCheckable, true));
        } else if (l.r(b.c.a.b.k.TextInputLayout_passwordToggleEnabled)) {
            setEndIconMode(l.a(b.c.a.b.k.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
            setEndIconDrawable(l.g(b.c.a.b.k.TextInputLayout_passwordToggleDrawable));
            setEndIconContentDescription(l.p(b.c.a.b.k.TextInputLayout_passwordToggleContentDescription));
            if (l.r(b.c.a.b.k.TextInputLayout_passwordToggleTint)) {
                setEndIconTintList(b.c.a.b.x.c.b(context2, l, b.c.a.b.k.TextInputLayout_passwordToggleTint));
            }
            if (l.r(b.c.a.b.k.TextInputLayout_passwordToggleTintMode)) {
                setEndIconTintMode(com.google.android.material.internal.h.c(l.k(b.c.a.b.k.TextInputLayout_passwordToggleTintMode, -1), null));
            }
        }
        if (!l.r(b.c.a.b.k.TextInputLayout_passwordToggleEnabled)) {
            if (l.r(b.c.a.b.k.TextInputLayout_endIconTint)) {
                setEndIconTintList(b.c.a.b.x.c.b(context2, l, b.c.a.b.k.TextInputLayout_endIconTint));
            }
            if (l.r(b.c.a.b.k.TextInputLayout_endIconTintMode)) {
                setEndIconTintMode(com.google.android.material.internal.h.c(l.k(b.c.a.b.k.TextInputLayout_endIconTintMode, -1), null));
            }
        }
        l.v();
        s.p0(this, 2);
    }

    private void A(Canvas canvas) {
        if (this.s) {
            this.r0.i(canvas);
        }
    }

    private void B(boolean z) {
        ValueAnimator valueAnimator = this.t0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.t0.cancel();
        }
        if (z && this.s0) {
            e(0.0f);
        } else {
            this.r0.O(0.0f);
        }
        if (w() && ((com.google.android.material.textfield.c) this.v).g0()) {
            u();
        }
        this.q0 = true;
    }

    private boolean C() {
        return this.S != 0;
    }

    private boolean D() {
        return getStartIconDrawable() != null;
    }

    private boolean H() {
        return this.z == 1 && (Build.VERSION.SDK_INT < 16 || this.h.getMinLines() <= 1);
    }

    private void J() {
        l();
        M();
        e0();
        if (this.z != 0) {
            b0();
        }
    }

    private void K() {
        if (w()) {
            RectF rectF = this.I;
            this.r0.k(rectF);
            h(rectF);
            rectF.offset(-getPaddingLeft(), 0.0f);
            ((com.google.android.material.textfield.c) this.v).m0(rectF);
        }
    }

    private static void L(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                L((ViewGroup) childAt, z);
            }
        }
    }

    private void M() {
        if (R()) {
            s.i0(this.h, this.v);
        }
    }

    private static void N(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean H = s.H(checkableImageButton);
        boolean z = false;
        boolean z2 = onLongClickListener != null;
        z = (H || z2) ? true : true;
        checkableImageButton.setFocusable(z);
        checkableImageButton.setClickable(H);
        checkableImageButton.setPressable(H);
        checkableImageButton.setLongClickable(z2);
        s.p0(checkableImageButton, z ? 1 : 2);
    }

    private static void O(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        N(checkableImageButton, onLongClickListener);
    }

    private static void P(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        N(checkableImageButton, onLongClickListener);
    }

    private boolean R() {
        EditText editText = this.h;
        return (editText == null || this.v == null || editText.getBackground() != null || this.z == 0) ? false : true;
    }

    private void S(boolean z) {
        if (!z || getEndIconDrawable() == null) {
            i();
            return;
        }
        Drawable mutate = androidx.core.graphics.drawable.a.r(getEndIconDrawable()).mutate();
        androidx.core.graphics.drawable.a.n(mutate, this.j.n());
        this.U.setImageDrawable(mutate);
    }

    private void T(Rect rect) {
        b.c.a.b.a0.g gVar = this.w;
        if (gVar != null) {
            int i = rect.bottom;
            gVar.setBounds(rect.left, i - this.D, rect.right, i);
        }
    }

    private void U() {
        if (this.n != null) {
            EditText editText = this.h;
            V(editText == null ? 0 : editText.getText().length());
        }
    }

    private static void W(Context context, TextView textView, int i, int i2, boolean z) {
        textView.setContentDescription(context.getString(z ? i.character_counter_overflowed_content_description : i.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    private void X() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.n;
        if (textView != null) {
            Q(textView, this.m ? this.o : this.p);
            if (!this.m && (colorStateList2 = this.q) != null) {
                this.n.setTextColor(colorStateList2);
            }
            if (!this.m || (colorStateList = this.r) == null) {
                return;
            }
            this.n.setTextColor(colorStateList);
        }
    }

    private boolean Z() {
        int max;
        if (this.h != null && this.h.getMeasuredHeight() < (max = Math.max(this.U.getMeasuredHeight(), this.K.getMeasuredHeight()))) {
            this.h.setMinimumHeight(max);
            return true;
        }
        return false;
    }

    private boolean a0() {
        boolean z;
        if (this.h == null) {
            return false;
        }
        boolean z2 = true;
        if (D() && I() && this.K.getMeasuredWidth() > 0) {
            if (this.P == null) {
                this.P = new ColorDrawable();
                this.P.setBounds(0, 0, (this.K.getMeasuredWidth() - this.h.getPaddingLeft()) + a.g.k.g.a((ViewGroup.MarginLayoutParams) this.K.getLayoutParams()), 1);
            }
            Drawable[] a2 = androidx.core.widget.i.a(this.h);
            Drawable drawable = a2[0];
            Drawable drawable2 = this.P;
            if (drawable != drawable2) {
                androidx.core.widget.i.i(this.h, drawable2, a2[1], a2[2], a2[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.P != null) {
                Drawable[] a3 = androidx.core.widget.i.a(this.h);
                androidx.core.widget.i.i(this.h, null, a3[1], a3[2], a3[3]);
                this.P = null;
                z = true;
            }
            z = false;
        }
        CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
        if (endIconToUpdateDummyDrawable != null && endIconToUpdateDummyDrawable.getMeasuredWidth() > 0) {
            if (this.d0 == null) {
                this.d0 = new ColorDrawable();
                this.d0.setBounds(0, 0, (endIconToUpdateDummyDrawable.getMeasuredWidth() - this.h.getPaddingRight()) + a.g.k.g.b((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams()), 1);
            }
            Drawable[] a4 = androidx.core.widget.i.a(this.h);
            Drawable drawable3 = a4[2];
            Drawable drawable4 = this.d0;
            if (drawable3 != drawable4) {
                this.e0 = a4[2];
                androidx.core.widget.i.i(this.h, a4[0], a4[1], drawable4, a4[3]);
            } else {
                z2 = z;
            }
        } else if (this.d0 == null) {
            return z;
        } else {
            Drawable[] a5 = androidx.core.widget.i.a(this.h);
            if (a5[2] == this.d0) {
                androidx.core.widget.i.i(this.h, a5[0], a5[1], this.e0, a5[3]);
            } else {
                z2 = z;
            }
            this.d0 = null;
        }
        return z2;
    }

    private void b0() {
        if (this.z != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            int r = r();
            if (r != layoutParams.topMargin) {
                layoutParams.topMargin = r;
                this.f.requestLayout();
            }
        }
    }

    private void d0(boolean z, boolean z2) {
        ColorStateList colorStateList;
        com.google.android.material.internal.a aVar;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.h;
        boolean z3 = true;
        boolean z4 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.h;
        z3 = (editText2 == null || !editText2.hasFocus()) ? false : false;
        boolean k = this.j.k();
        ColorStateList colorStateList2 = this.h0;
        if (colorStateList2 != null) {
            this.r0.E(colorStateList2);
            this.r0.K(this.h0);
        }
        if (!isEnabled) {
            this.r0.E(ColorStateList.valueOf(this.p0));
            this.r0.K(ColorStateList.valueOf(this.p0));
        } else if (k) {
            this.r0.E(this.j.o());
        } else {
            if (this.m && (textView = this.n) != null) {
                aVar = this.r0;
                colorStateList = textView.getTextColors();
            } else if (z3 && (colorStateList = this.i0) != null) {
                aVar = this.r0;
            }
            aVar.E(colorStateList);
        }
        if (z4 || (isEnabled() && (z3 || k))) {
            if (z2 || this.q0) {
                v(z);
            }
        } else if (z2 || !this.q0) {
            B(z);
        }
    }

    private void f() {
        b.c.a.b.a0.g gVar = this.v;
        if (gVar == null) {
            return;
        }
        gVar.setShapeAppearanceModel(this.x);
        if (s()) {
            this.v.Z(this.B, this.E);
        }
        int m = m();
        this.F = m;
        this.v.T(ColorStateList.valueOf(m));
        if (this.S == 3) {
            this.h.getBackground().invalidateSelf();
        }
        g();
        invalidate();
    }

    private void g() {
        if (this.w == null) {
            return;
        }
        if (t()) {
            this.w.T(ColorStateList.valueOf(this.E));
        }
        invalidate();
    }

    private com.google.android.material.textfield.e getEndIconDelegate() {
        com.google.android.material.textfield.e eVar = this.T.get(this.S);
        return eVar != null ? eVar : this.T.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.f0.getVisibility() == 0) {
            return this.f0;
        }
        if (C() && E()) {
            return this.U;
        }
        return null;
    }

    private void h(RectF rectF) {
        float f2 = rectF.left;
        int i = this.y;
        rectF.left = f2 - i;
        rectF.top -= i;
        rectF.right += i;
        rectF.bottom += i;
    }

    private void i() {
        j(this.U, this.a0, this.W, this.c0, this.b0);
    }

    private void j(CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            if (z) {
                androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            }
            if (z2) {
                androidx.core.graphics.drawable.a.p(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void k() {
        j(this.K, this.M, this.L, this.O, this.N);
    }

    private void l() {
        int i = this.z;
        if (i == 0) {
            this.v = null;
        } else if (i == 1) {
            this.v = new b.c.a.b.a0.g(this.x);
            this.w = new b.c.a.b.a0.g();
            return;
        } else if (i != 2) {
            throw new IllegalArgumentException(this.z + " is illegal; only @BoxBackgroundMode constants are supported.");
        } else {
            this.v = (!this.s || (this.v instanceof com.google.android.material.textfield.c)) ? new b.c.a.b.a0.g(this.x) : new com.google.android.material.textfield.c(this.x);
        }
        this.w = null;
    }

    private int m() {
        return this.z == 1 ? b.c.a.b.q.a.e(b.c.a.b.q.a.d(this, b.c.a.b.b.colorSurface, 0), this.F) : this.F;
    }

    private Rect n(Rect rect) {
        int i;
        int i2;
        int i3;
        EditText editText = this.h;
        if (editText != null) {
            Rect rect2 = this.H;
            rect2.bottom = rect.bottom;
            int i4 = this.z;
            if (i4 == 1) {
                rect2.left = rect.left + editText.getCompoundPaddingLeft();
                i = rect.top + this.A;
            } else if (i4 == 2) {
                rect2.left = rect.left + editText.getPaddingLeft();
                rect2.top = rect.top - r();
                i2 = rect.right;
                i3 = this.h.getPaddingRight();
                rect2.right = i2 - i3;
                return rect2;
            } else {
                rect2.left = rect.left + editText.getCompoundPaddingLeft();
                i = getPaddingTop();
            }
            rect2.top = i;
            i2 = rect.right;
            i3 = this.h.getCompoundPaddingRight();
            rect2.right = i2 - i3;
            return rect2;
        }
        throw new IllegalStateException();
    }

    private int o(Rect rect, Rect rect2, float f2) {
        return this.z == 1 ? (int) (rect2.top + f2) : rect.bottom - this.h.getCompoundPaddingBottom();
    }

    private int p(Rect rect, float f2) {
        return H() ? (int) (rect.centerY() - (f2 / 2.0f)) : rect.top + this.h.getCompoundPaddingTop();
    }

    private Rect q(Rect rect) {
        if (this.h != null) {
            Rect rect2 = this.H;
            float q = this.r0.q();
            rect2.left = rect.left + this.h.getCompoundPaddingLeft();
            rect2.top = p(rect, q);
            rect2.right = rect.right - this.h.getCompoundPaddingRight();
            rect2.bottom = o(rect, rect2, q);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private int r() {
        float m;
        if (this.s) {
            int i = this.z;
            if (i == 0 || i == 1) {
                m = this.r0.m();
            } else if (i != 2) {
                return 0;
            } else {
                m = this.r0.m() / 2.0f;
            }
            return (int) m;
        }
        return 0;
    }

    private boolean s() {
        return this.z == 2 && t();
    }

    private void setEditText(EditText editText) {
        if (this.h != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.S != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.h = editText;
        J();
        setTextInputAccessibilityDelegate(new e(this));
        this.r0.U(this.h.getTypeface());
        this.r0.M(this.h.getTextSize());
        int gravity = this.h.getGravity();
        this.r0.F((gravity & (-113)) | 48);
        this.r0.L(gravity);
        this.h.addTextChangedListener(new a());
        if (this.h0 == null) {
            this.h0 = this.h.getHintTextColors();
        }
        if (this.s) {
            if (TextUtils.isEmpty(this.t)) {
                CharSequence hint = this.h.getHint();
                this.i = hint;
                setHint(hint);
                this.h.setHint((CharSequence) null);
            }
            this.u = true;
        }
        if (this.n != null) {
            V(this.h.getText().length());
        }
        Y();
        this.j.e();
        this.K.bringToFront();
        this.g.bringToFront();
        this.f0.bringToFront();
        x();
        d0(false, true);
    }

    private void setErrorIconVisible(boolean z) {
        this.f0.setVisibility(z ? 0 : 8);
        this.g.setVisibility(z ? 8 : 0);
        if (C()) {
            return;
        }
        a0();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.t)) {
            return;
        }
        this.t = charSequence;
        this.r0.S(charSequence);
        if (this.q0) {
            return;
        }
        K();
    }

    private boolean t() {
        return this.B > -1 && this.E != 0;
    }

    private void u() {
        if (w()) {
            ((com.google.android.material.textfield.c) this.v).j0();
        }
    }

    private void v(boolean z) {
        ValueAnimator valueAnimator = this.t0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.t0.cancel();
        }
        if (z && this.s0) {
            e(1.0f);
        } else {
            this.r0.O(1.0f);
        }
        this.q0 = false;
        if (w()) {
            K();
        }
    }

    private boolean w() {
        return this.s && !TextUtils.isEmpty(this.t) && (this.v instanceof com.google.android.material.textfield.c);
    }

    private void x() {
        Iterator<f> it = this.R.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void y(int i) {
        Iterator<g> it = this.V.iterator();
        while (it.hasNext()) {
            it.next().a(this, i);
        }
    }

    private void z(Canvas canvas) {
        b.c.a.b.a0.g gVar = this.w;
        if (gVar != null) {
            Rect bounds = gVar.getBounds();
            bounds.top = bounds.bottom - this.B;
            this.w.draw(canvas);
        }
    }

    public boolean E() {
        return this.g.getVisibility() == 0 && this.U.getVisibility() == 0;
    }

    public boolean F() {
        return this.j.w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G() {
        return this.u;
    }

    public boolean I() {
        return this.K.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Q(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.i.n(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = b.c.a.b.j.TextAppearance_AppCompat_Caption
            androidx.core.widget.i.n(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = b.c.a.b.c.design_error
            int r4 = androidx.core.content.a.b(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.Q(android.widget.TextView, int):void");
    }

    void V(int i) {
        boolean z = this.m;
        if (this.l == -1) {
            this.n.setText(String.valueOf(i));
            this.n.setContentDescription(null);
            this.m = false;
        } else {
            if (s.k(this.n) == 1) {
                s.h0(this.n, 0);
            }
            this.m = i > this.l;
            W(getContext(), this.n, i, this.l, this.m);
            if (z != this.m) {
                X();
                if (this.m) {
                    s.h0(this.n, 1);
                }
            }
            this.n.setText(getContext().getString(i.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.l)));
        }
        if (this.h == null || z == this.m) {
            return;
        }
        c0(false);
        e0();
        Y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.h;
        if (editText == null || this.z != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (e0.a(background)) {
            background = background.mutate();
        }
        if (this.j.k()) {
            currentTextColor = this.j.n();
        } else if (!this.m || (textView = this.n) == null) {
            androidx.core.graphics.drawable.a.c(background);
            this.h.refreshDrawableState();
            return;
        } else {
            currentTextColor = textView.getCurrentTextColor();
        }
        background.setColorFilter(androidx.appcompat.widget.j.e(currentTextColor, PorterDuff.Mode.SRC_IN));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f.addView(view, layoutParams2);
        this.f.setLayoutParams(layoutParams);
        b0();
        setEditText((EditText) view);
    }

    public void c(f fVar) {
        this.R.add(fVar);
        if (this.h != null) {
            fVar.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c0(boolean z) {
        d0(z, false);
    }

    public void d(g gVar) {
        this.V.add(gVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText;
        if (this.i == null || (editText = this.h) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        boolean z = this.u;
        this.u = false;
        CharSequence hint = editText.getHint();
        this.h.setHint(this.i);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.h.setHint(hint);
            this.u = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.v0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.v0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        A(canvas);
        z(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.u0) {
            return;
        }
        boolean z = true;
        this.u0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.a aVar = this.r0;
        boolean R = aVar != null ? aVar.R(drawableState) | false : false;
        c0((s.M(this) && isEnabled()) ? false : false);
        Y();
        e0();
        if (R) {
            invalidate();
        }
        this.u0 = false;
    }

    void e(float f2) {
        if (this.r0.r() == f2) {
            return;
        }
        if (this.t0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.t0 = valueAnimator;
            valueAnimator.setInterpolator(b.c.a.b.l.a.f1341b);
            this.t0.setDuration(167L);
            this.t0.addUpdateListener(new d());
        }
        this.t0.setFloatValues(this.r0.r(), f2);
        this.t0.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.v == null || this.z == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.h) != null && editText2.hasFocus());
        boolean z3 = isHovered() || ((editText = this.h) != null && editText.isHovered());
        this.E = !isEnabled() ? this.p0 : this.j.k() ? this.j.n() : (!this.m || (textView = this.n) == null) ? z2 ? this.l0 : z3 ? this.k0 : this.j0 : textView.getCurrentTextColor();
        S(this.j.k() && getEndIconDelegate().c());
        if (getErrorIconDrawable() != null && this.j.v() && this.j.k()) {
            z = true;
        }
        setErrorIconVisible(z);
        this.B = ((z3 || z2) && isEnabled()) ? this.D : this.C;
        if (this.z == 1) {
            this.F = !isEnabled() ? this.n0 : z3 ? this.o0 : this.m0;
        }
        f();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.h;
        return editText != null ? editText.getBaseline() + getPaddingTop() + r() : super.getBaseline();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b.c.a.b.a0.g getBoxBackground() {
        int i = this.z;
        if (i == 1 || i == 2) {
            return this.v;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.F;
    }

    public int getBoxBackgroundMode() {
        return this.z;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.v.r();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.v.s();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.v.F();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.v.E();
    }

    public int getBoxStrokeColor() {
        return this.l0;
    }

    public int getCounterMaxLength() {
        return this.l;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.k && this.m && (textView = this.n) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.q;
    }

    public ColorStateList getCounterTextColor() {
        return this.q;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.h0;
    }

    public EditText getEditText() {
        return this.h;
    }

    public CharSequence getEndIconContentDescription() {
        return this.U.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.U.getDrawable();
    }

    public int getEndIconMode() {
        return this.S;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckableImageButton getEndIconView() {
        return this.U;
    }

    public CharSequence getError() {
        if (this.j.v()) {
            return this.j.m();
        }
        return null;
    }

    public int getErrorCurrentTextColors() {
        return this.j.n();
    }

    public Drawable getErrorIconDrawable() {
        return this.f0.getDrawable();
    }

    final int getErrorTextCurrentColor() {
        return this.j.n();
    }

    public CharSequence getHelperText() {
        if (this.j.w()) {
            return this.j.p();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.j.q();
    }

    public CharSequence getHint() {
        if (this.s) {
            return this.t;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.r0.m();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.r0.n();
    }

    public ColorStateList getHintTextColor() {
        return this.i0;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.U.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.U.getDrawable();
    }

    public CharSequence getStartIconContentDescription() {
        return this.K.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.K.getDrawable();
    }

    public Typeface getTypeface() {
        return this.J;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.h;
        if (editText != null) {
            Rect rect = this.G;
            com.google.android.material.internal.b.a(this, editText, rect);
            T(rect);
            if (this.s) {
                this.r0.C(n(rect));
                this.r0.J(q(rect));
                this.r0.z();
                if (!w() || this.q0) {
                    return;
                }
                K();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        boolean Z = Z();
        boolean a0 = a0();
        if (Z || a0) {
            this.h.post(new c());
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.a());
        setError(hVar.h);
        if (hVar.i) {
            this.U.post(new b());
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.j.k()) {
            hVar.h = getError();
        }
        hVar.i = C() && this.U.isChecked();
        return hVar;
    }

    public void setBoxBackgroundColor(int i) {
        if (this.F != i) {
            this.F = i;
            this.m0 = i;
            f();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(androidx.core.content.a.b(getContext(), i));
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.z) {
            return;
        }
        this.z = i;
        if (this.h != null) {
            J();
        }
    }

    public void setBoxStrokeColor(int i) {
        if (this.l0 != i) {
            this.l0 = i;
            e0();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.k != z) {
            if (z) {
                z zVar = new z(getContext());
                this.n = zVar;
                zVar.setId(b.c.a.b.f.textinput_counter);
                Typeface typeface = this.J;
                if (typeface != null) {
                    this.n.setTypeface(typeface);
                }
                this.n.setMaxLines(1);
                this.j.d(this.n, 2);
                X();
                U();
            } else {
                this.j.x(this.n, 2);
                this.n = null;
            }
            this.k = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.l != i) {
            if (i <= 0) {
                i = -1;
            }
            this.l = i;
            if (this.k) {
                U();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.o != i) {
            this.o = i;
            X();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.r != colorStateList) {
            this.r = colorStateList;
            X();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.p != i) {
            this.p = i;
            X();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.q != colorStateList) {
            this.q = colorStateList;
            X();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.h0 = colorStateList;
        this.i0 = colorStateList;
        if (this.h != null) {
            c0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        L(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.U.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.U.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.U.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? a.a.k.a.a.d(getContext(), i) : null);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.U.setImageDrawable(drawable);
    }

    public void setEndIconMode(int i) {
        int i2 = this.S;
        this.S = i;
        setEndIconVisible(i != 0);
        if (getEndIconDelegate().b(this.z)) {
            getEndIconDelegate().a();
            i();
            y(i2);
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.z + " is not supported by the end icon mode " + i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        O(this.U, onClickListener, this.g0);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.g0 = onLongClickListener;
        P(this.U, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.W != colorStateList) {
            this.W = colorStateList;
            this.a0 = true;
            i();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.b0 != mode) {
            this.b0 = mode;
            this.c0 = true;
            i();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (E() != z) {
            this.U.setVisibility(z ? 0 : 4);
            a0();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.j.v()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.j.r();
        } else {
            this.j.J(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        this.j.z(z);
    }

    public void setErrorIconDrawable(int i) {
        setErrorIconDrawable(i != 0 ? a.a.k.a.a.d(getContext(), i) : null);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.j.v());
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f0.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        }
        if (this.f0.getDrawable() != drawable) {
            this.f0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f0.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
            androidx.core.graphics.drawable.a.p(drawable, mode);
        }
        if (this.f0.getDrawable() != drawable) {
            this.f0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i) {
        this.j.A(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.j.B(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (F()) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!F()) {
            setHelperTextEnabled(true);
        }
        this.j.K(charSequence);
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.j.E(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.j.D(z);
    }

    public void setHelperTextTextAppearance(int i) {
        this.j.C(i);
    }

    public void setHint(CharSequence charSequence) {
        if (this.s) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.s0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.s) {
            this.s = z;
            if (z) {
                CharSequence hint = this.h.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.t)) {
                        setHint(hint);
                    }
                    this.h.setHint((CharSequence) null);
                }
                this.u = true;
            } else {
                this.u = false;
                if (!TextUtils.isEmpty(this.t) && TextUtils.isEmpty(this.h.getHint())) {
                    this.h.setHint(this.t);
                }
                setHintInternal(null);
            }
            if (this.h != null) {
                b0();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.r0.D(i);
        this.i0 = this.r0.l();
        if (this.h != null) {
            c0(false);
            b0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.i0 != colorStateList) {
            if (this.h0 == null) {
                this.r0.E(colorStateList);
            }
            this.i0 = colorStateList;
            if (this.h != null) {
                c0(false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.U.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? a.a.k.a.a.d(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.U.setImageDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.S != 1) {
            setEndIconMode(1);
        } else if (z) {
        } else {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.W = colorStateList;
        this.a0 = true;
        i();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.b0 = mode;
        this.c0 = true;
        i();
    }

    public void setStartIconCheckable(boolean z) {
        this.K.setCheckable(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.K.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? a.a.k.a.a.d(getContext(), i) : null);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.K.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            k();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        O(this.K, onClickListener, this.Q);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.Q = onLongClickListener;
        P(this.K, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.L != colorStateList) {
            this.L = colorStateList;
            this.M = true;
            k();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.N != mode) {
            this.N = mode;
            this.O = true;
            k();
        }
    }

    public void setStartIconVisible(boolean z) {
        if (I() != z) {
            this.K.setVisibility(z ? 0 : 8);
            a0();
        }
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.h;
        if (editText != null) {
            s.f0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.J) {
            this.J = typeface;
            this.r0.U(typeface);
            this.j.G(typeface);
            TextView textView = this.n;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }
}
