package com.google.android.material.textfield;

import a.g.k.s;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import b.c.a.b.a0.k;
import com.google.android.material.textfield.TextInputLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.google.android.material.textfield.e {
    private static final boolean o;

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f1841d;
    private final TextInputLayout.e e;
    private final TextInputLayout.f f;
    private boolean g;
    private boolean h;
    private long i;
    private StateListDrawable j;
    private b.c.a.b.a0.g k;
    private AccessibilityManager l;
    private ValueAnimator m;
    private ValueAnimator n;

    /* loaded from: classes.dex */
    class a implements TextWatcher {

        /* renamed from: com.google.android.material.textfield.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0089a implements Runnable {
            final /* synthetic */ AutoCompleteTextView f;

            RunnableC0089a(AutoCompleteTextView autoCompleteTextView) {
                this.f = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.f.isPopupShowing();
                d.this.z(isPopupShowing);
                d.this.g = isPopupShowing;
            }
        }

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d dVar = d.this;
            AutoCompleteTextView u = dVar.u(dVar.f1846a.getEditText());
            u.post(new RunnableC0089a(u));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes.dex */
    class b extends TextInputLayout.e {
        b(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, a.g.k.a
        public void g(View view, a.g.k.b0.c cVar) {
            super.g(view, cVar);
            cVar.W(Spinner.class.getName());
            if (cVar.J()) {
                cVar.i0(null);
            }
        }

        @Override // a.g.k.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            d dVar = d.this;
            AutoCompleteTextView u = dVar.u(dVar.f1846a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.l.isTouchExplorationEnabled()) {
                d.this.C(u);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements TextInputLayout.f {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView u = d.this.u(textInputLayout.getEditText());
            d.this.A(u);
            d.this.r(u);
            d.this.B(u);
            u.setThreshold(0);
            u.removeTextChangedListener(d.this.f1841d);
            u.addTextChangedListener(d.this.f1841d);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            textInputLayout.setTextInputAccessibilityDelegate(d.this.e);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* renamed from: com.google.android.material.textfield.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnClickListenerC0090d implements View.OnClickListener {
        View$OnClickListenerC0090d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.C((AutoCompleteTextView) d.this.f1846a.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements View.OnTouchListener {
        final /* synthetic */ AutoCompleteTextView f;

        e(AutoCompleteTextView autoCompleteTextView) {
            this.f = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.y()) {
                    d.this.g = false;
                }
                d.this.C(this.f);
                view.performClick();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements View.OnFocusChangeListener {
        f() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            d.this.f1846a.setEndIconActivated(z);
            if (z) {
                return;
            }
            d.this.z(false);
            d.this.g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements AutoCompleteTextView.OnDismissListener {
        g() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.g = true;
            d.this.i = System.currentTimeMillis();
            d.this.z(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.f1848c.setChecked(dVar.h);
            d.this.n.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.f1848c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    static {
        o = Build.VERSION.SDK_INT >= 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f1841d = new a();
        this.e = new b(this.f1846a);
        this.f = new c();
        this.g = false;
        this.h = false;
        this.i = Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(AutoCompleteTextView autoCompleteTextView) {
        Drawable drawable;
        if (o) {
            int boxBackgroundMode = this.f1846a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                drawable = this.k;
            } else if (boxBackgroundMode != 1) {
                return;
            } else {
                drawable = this.j;
            }
            autoCompleteTextView.setDropDownBackgroundDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new e(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(new f());
        if (o) {
            autoCompleteTextView.setOnDismissListener(new g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (y()) {
            this.g = false;
        }
        if (this.g) {
            this.g = false;
            return;
        }
        if (o) {
            z(!this.h);
        } else {
            this.h = !this.h;
            this.f1848c.toggle();
        }
        if (!this.h) {
            autoCompleteTextView.dismissDropDown();
            return;
        }
        autoCompleteTextView.requestFocus();
        autoCompleteTextView.showDropDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView.getKeyListener() != null) {
            return;
        }
        int boxBackgroundMode = this.f1846a.getBoxBackgroundMode();
        b.c.a.b.a0.g boxBackground = this.f1846a.getBoxBackground();
        int c2 = b.c.a.b.q.a.c(autoCompleteTextView, b.c.a.b.b.colorControlHighlight);
        int[][] iArr = {new int[]{16842919}, new int[0]};
        if (boxBackgroundMode == 2) {
            t(autoCompleteTextView, c2, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            s(autoCompleteTextView, c2, iArr, boxBackground);
        }
    }

    private void s(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, b.c.a.b.a0.g gVar) {
        int boxBackgroundColor = this.f1846a.getBoxBackgroundColor();
        int[] iArr2 = {b.c.a.b.q.a.f(i2, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (o) {
            s.i0(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), gVar, gVar));
            return;
        }
        b.c.a.b.a0.g gVar2 = new b.c.a.b.a0.g(gVar.B());
        gVar2.T(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar, gVar2});
        int B = s.B(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int A = s.A(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        s.i0(autoCompleteTextView, layerDrawable);
        s.s0(autoCompleteTextView, B, paddingTop, A, paddingBottom);
    }

    private void t(AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, b.c.a.b.a0.g gVar) {
        LayerDrawable layerDrawable;
        int c2 = b.c.a.b.q.a.c(autoCompleteTextView, b.c.a.b.b.colorSurface);
        b.c.a.b.a0.g gVar2 = new b.c.a.b.a0.g(gVar.B());
        int f2 = b.c.a.b.q.a.f(i2, c2, 0.1f);
        gVar2.T(new ColorStateList(iArr, new int[]{f2, 0}));
        if (o) {
            gVar2.setTint(c2);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{f2, c2});
            b.c.a.b.a0.g gVar3 = new b.c.a.b.a0.g(gVar.B());
            gVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar2, gVar3), gVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar});
        }
        s.i0(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AutoCompleteTextView u(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator v(int i2, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(b.c.a.b.l.a.f1340a);
        ofFloat.setDuration(i2);
        ofFloat.addUpdateListener(new i());
        return ofFloat;
    }

    private b.c.a.b.a0.g w(float f2, float f3, float f4, int i2) {
        k.b a2 = k.a();
        a2.z(f2);
        a2.D(f2);
        a2.r(f3);
        a2.v(f3);
        k m = a2.m();
        b.c.a.b.a0.g l = b.c.a.b.a0.g.l(this.f1847b, f4);
        l.setShapeAppearanceModel(m);
        l.V(0, i2, 0, i2);
        return l;
    }

    private void x() {
        this.n = v(67, 0.0f, 1.0f);
        ValueAnimator v = v(50, 1.0f, 0.0f);
        this.m = v;
        v.addListener(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        long currentTimeMillis = System.currentTimeMillis() - this.i;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z) {
        if (this.h != z) {
            this.h = z;
            this.n.cancel();
            this.m.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        float dimensionPixelOffset = this.f1847b.getResources().getDimensionPixelOffset(b.c.a.b.d.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f1847b.getResources().getDimensionPixelOffset(b.c.a.b.d.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f1847b.getResources().getDimensionPixelOffset(b.c.a.b.d.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        b.c.a.b.a0.g w = w(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        b.c.a.b.a0.g w2 = w(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.k = w;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.j = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, w);
        this.j.addState(new int[0], w2);
        this.f1846a.setEndIconDrawable(a.a.k.a.a.d(this.f1847b, o ? b.c.a.b.e.mtrl_dropdown_arrow : b.c.a.b.e.mtrl_ic_arrow_drop_down));
        TextInputLayout textInputLayout = this.f1846a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(b.c.a.b.i.exposed_dropdown_menu_content_description));
        this.f1846a.setEndIconOnClickListener(new View$OnClickListenerC0090d());
        this.f1846a.c(this.f);
        x();
        s.p0(this.f1848c, 2);
        this.l = (AccessibilityManager) this.f1847b.getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean b(int i2) {
        return i2 != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean c() {
        return true;
    }
}
