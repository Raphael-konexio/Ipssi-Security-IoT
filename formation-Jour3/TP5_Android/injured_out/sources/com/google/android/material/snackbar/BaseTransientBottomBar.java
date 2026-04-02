package com.google.android.material.snackbar;

import a.g.k.a0;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.b;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final Handler s;
    private static final boolean t;
    private static final int[] u;
    private static final String v;

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f1801a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f1802b;

    /* renamed from: c  reason: collision with root package name */
    protected final v f1803c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.material.snackbar.a f1804d;
    private int e;
    private boolean f;
    private View g;
    private Rect i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private List<r<B>> o;
    private Behavior p;
    private final AccessibilityManager q;
    private final Runnable h = new j();
    b.InterfaceC0087b r = new m();

    /* loaded from: classes.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {
        private final s k = new s(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void O(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.k.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean E(View view) {
            return this.k.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.k.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1806a;

        b(int i) {
            this.f1806a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.H(this.f1806a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f1803c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f1803c.setScaleX(floatValue);
            BaseTransientBottomBar.this.f1803c.setScaleY(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.I();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f1804d.a(70, 180);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private int f1811a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1812b;

        f(int i) {
            this.f1812b = i;
            this.f1811a = this.f1812b;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.t) {
                a.g.k.s.S(BaseTransientBottomBar.this.f1803c, intValue - this.f1811a);
            } else {
                BaseTransientBottomBar.this.f1803c.setTranslationY(intValue);
            }
            this.f1811a = intValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1814a;

        g(int i) {
            this.f1814a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.H(this.f1814a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f1804d.b(0, 180);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private int f1816a = 0;

        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.t) {
                a.g.k.s.S(BaseTransientBottomBar.this.f1803c, intValue - this.f1816a);
            } else {
                BaseTransientBottomBar.this.f1803c.setTranslationY(intValue);
            }
            this.f1816a = intValue;
        }
    }

    /* loaded from: classes.dex */
    static class i implements Handler.Callback {
        i() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ((BaseTransientBottomBar) message.obj).O();
                return true;
            } else if (i != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).E(message.arg1);
                return true;
            }
        }
    }

    /* loaded from: classes.dex */
    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int z;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f1803c == null || baseTransientBottomBar.f1802b == null || (z = (BaseTransientBottomBar.this.z() - BaseTransientBottomBar.this.C()) + ((int) BaseTransientBottomBar.this.f1803c.getTranslationY())) >= BaseTransientBottomBar.this.m) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f1803c.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.v, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.m - z;
            BaseTransientBottomBar.this.f1803c.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    class k implements a.g.k.p {
        k() {
        }

        @Override // a.g.k.p
        public a0 a(View view, a0 a0Var) {
            BaseTransientBottomBar.this.j = a0Var.h();
            BaseTransientBottomBar.this.k = a0Var.i();
            BaseTransientBottomBar.this.l = a0Var.j();
            BaseTransientBottomBar.this.U();
            return a0Var;
        }
    }

    /* loaded from: classes.dex */
    class l extends a.g.k.a {
        l() {
        }

        @Override // a.g.k.a
        public void g(View view, a.g.k.b0.c cVar) {
            super.g(view, cVar);
            cVar.a(1048576);
            cVar.c0(true);
        }

        @Override // a.g.k.a
        public boolean j(View view, int i, Bundle bundle) {
            if (i == 1048576) {
                BaseTransientBottomBar.this.t();
                return true;
            }
            return super.j(view, i, bundle);
        }
    }

    /* loaded from: classes.dex */
    class m implements b.InterfaceC0087b {
        m() {
        }

        @Override // com.google.android.material.snackbar.b.InterfaceC0087b
        public void a() {
            Handler handler = BaseTransientBottomBar.s;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.b.InterfaceC0087b
        public void b(int i) {
            Handler handler = BaseTransientBottomBar.s;
            handler.sendMessage(handler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n implements t {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseTransientBottomBar.this.H(3);
            }
        }

        n() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        public void onViewAttachedToWindow(View view) {
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = BaseTransientBottomBar.this.f1803c.getRootWindowInsets()) == null) {
                return;
            }
            BaseTransientBottomBar.this.m = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            BaseTransientBottomBar.this.U();
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        public void onViewDetachedFromWindow(View view) {
            if (BaseTransientBottomBar.this.F()) {
                BaseTransientBottomBar.s.post(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o implements u {
        o() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.u
        public void a(View view, int i, int i2, int i3, int i4) {
            BaseTransientBottomBar.this.f1803c.setOnLayoutChangeListener(null);
            BaseTransientBottomBar.this.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p implements SwipeDismissBehavior.b {
        p() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.b
        public void a(View view) {
            view.setVisibility(8);
            BaseTransientBottomBar.this.u(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.b
        public void b(int i) {
            if (i == 0) {
                com.google.android.material.snackbar.b.c().k(BaseTransientBottomBar.this.r);
            } else if (i == 1 || i == 2) {
                com.google.android.material.snackbar.b.c().j(BaseTransientBottomBar.this.r);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q implements Runnable {
        q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v vVar = BaseTransientBottomBar.this.f1803c;
            if (vVar == null) {
                return;
            }
            vVar.setVisibility(0);
            if (BaseTransientBottomBar.this.f1803c.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.Q();
            } else {
                BaseTransientBottomBar.this.S();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class r<B> {
        public void a(B b2, int i) {
        }

        public void b(B b2) {
        }
    }

    /* loaded from: classes.dex */
    public static class s {

        /* renamed from: a  reason: collision with root package name */
        private b.InterfaceC0087b f1824a;

        public s(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.L(0.1f);
            swipeDismissBehavior.J(0.6f);
            swipeDismissBehavior.M(0);
        }

        public boolean a(View view) {
            return view instanceof v;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.b.c().j(this.f1824a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.b.c().k(this.f1824a);
            }
        }

        public void c(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f1824a = baseTransientBottomBar.r;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface t {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface u {
        void a(View view, int i, int i2, int i3, int i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class v extends FrameLayout {
        private static final View.OnTouchListener k = new a();
        private u f;
        private t g;
        private int h;
        private final float i;
        private final float j;

        /* loaded from: classes.dex */
        static class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public v(Context context, AttributeSet attributeSet) {
            super(com.google.android.material.internal.g.f(context, attributeSet, 0, 0), attributeSet);
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.c.a.b.k.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(b.c.a.b.k.SnackbarLayout_elevation)) {
                a.g.k.s.m0(this, obtainStyledAttributes.getDimensionPixelSize(b.c.a.b.k.SnackbarLayout_elevation, 0));
            }
            this.h = obtainStyledAttributes.getInt(b.c.a.b.k.SnackbarLayout_animationMode, 0);
            this.i = obtainStyledAttributes.getFloat(b.c.a.b.k.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            this.j = obtainStyledAttributes.getFloat(b.c.a.b.k.SnackbarLayout_actionTextColorAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(k);
            setFocusable(true);
        }

        float getActionTextColorAlpha() {
            return this.j;
        }

        int getAnimationMode() {
            return this.h;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.i;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            t tVar = this.g;
            if (tVar != null) {
                tVar.onViewAttachedToWindow(this);
            }
            a.g.k.s.d0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            t tVar = this.g;
            if (tVar != null) {
                tVar.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            u uVar = this.f;
            if (uVar != null) {
                uVar.a(this, i, i2, i3, i4);
            }
        }

        void setAnimationMode(int i) {
            this.h = i;
        }

        void setOnAttachStateChangeListener(t tVar) {
            this.g = tVar;
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : k);
            super.setOnClickListener(onClickListener);
        }

        void setOnLayoutChangeListener(u uVar) {
            this.f = uVar;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        t = i2 >= 16 && i2 <= 19;
        u = new int[]{b.c.a.b.b.snackbarStyle};
        v = BaseTransientBottomBar.class.getSimpleName();
        s = new Handler(Looper.getMainLooper(), new i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseTransientBottomBar(ViewGroup viewGroup, View view, com.google.android.material.snackbar.a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f1801a = viewGroup;
        this.f1804d = aVar;
        Context context = viewGroup.getContext();
        this.f1802b = context;
        com.google.android.material.internal.g.a(context);
        v vVar = (v) LayoutInflater.from(this.f1802b).inflate(A(), this.f1801a, false);
        this.f1803c = vVar;
        if (vVar.getBackground() == null) {
            a.g.k.s.i0(this.f1803c, s());
        }
        if (view instanceof SnackbarContentLayout) {
            ((SnackbarContentLayout) view).c(this.f1803c.getActionTextColorAlpha());
        }
        this.f1803c.addView(view);
        ViewGroup.LayoutParams layoutParams = this.f1803c.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.i = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        a.g.k.s.h0(this.f1803c, 1);
        a.g.k.s.p0(this.f1803c, 1);
        a.g.k.s.n0(this.f1803c, true);
        a.g.k.s.r0(this.f1803c, new k());
        a.g.k.s.f0(this.f1803c, new l());
        this.q = (AccessibilityManager) this.f1802b.getSystemService("accessibility");
    }

    private int B() {
        int height = this.f1803c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f1803c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int C() {
        int[] iArr = new int[2];
        this.f1803c.getLocationOnScreen(iArr);
        return iArr[1] + this.f1803c.getHeight();
    }

    private boolean G() {
        ViewGroup.LayoutParams layoutParams = this.f1803c.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    private void K(CoordinatorLayout.f fVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.p;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = x();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).O(this);
        }
        swipeDismissBehavior.K(new p());
        fVar.o(swipeDismissBehavior);
        if (this.g == null) {
            fVar.g = 80;
        }
    }

    private boolean M() {
        return this.m > 0 && !this.f && G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        if (L()) {
            p();
            return;
        }
        this.f1803c.setVisibility(0);
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        ValueAnimator v2 = v(0.0f, 1.0f);
        ValueAnimator y = y(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(v2, y);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new a());
        animatorSet.start();
    }

    private void R(int i2) {
        ValueAnimator v2 = v(1.0f, 0.0f);
        v2.setDuration(75L);
        v2.addListener(new b(i2));
        v2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        int B = B();
        if (t) {
            a.g.k.s.S(this.f1803c, B);
        } else {
            this.f1803c.setTranslationY(B);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(B, 0);
        valueAnimator.setInterpolator(b.c.a.b.l.a.f1341b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new e());
        valueAnimator.addUpdateListener(new f(B));
        valueAnimator.start();
    }

    private void T(int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, B());
        valueAnimator.setInterpolator(b.c.a.b.l.a.f1341b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new g(i2));
        valueAnimator.addUpdateListener(new h());
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        ViewGroup.LayoutParams layoutParams = this.f1803c.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || this.i == null) {
            Log.w(v, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        int i2 = this.g != null ? this.n : this.j;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        Rect rect = this.i;
        marginLayoutParams.bottomMargin = rect.bottom + i2;
        marginLayoutParams.leftMargin = rect.left + this.k;
        marginLayoutParams.rightMargin = rect.right + this.l;
        this.f1803c.requestLayout();
        if (Build.VERSION.SDK_INT < 29 || !M()) {
            return;
        }
        this.f1803c.removeCallbacks(this.h);
        this.f1803c.post(this.h);
    }

    private void q(int i2) {
        if (this.f1803c.getAnimationMode() == 1) {
            R(i2);
        } else {
            T(i2);
        }
    }

    private int r() {
        View view = this.g;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        this.f1801a.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f1801a.getHeight()) - i2;
    }

    private Drawable s() {
        v vVar = this.f1803c;
        int g2 = b.c.a.b.q.a.g(vVar, b.c.a.b.b.colorSurface, b.c.a.b.b.colorOnSurface, vVar.getBackgroundOverlayColorAlpha());
        float dimension = this.f1803c.getResources().getDimension(b.c.a.b.d.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(g2);
        gradientDrawable.setCornerRadius(dimension);
        return gradientDrawable;
    }

    private ValueAnimator v(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(b.c.a.b.l.a.f1340a);
        ofFloat.addUpdateListener(new c());
        return ofFloat;
    }

    private ValueAnimator y(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(b.c.a.b.l.a.f1343d);
        ofFloat.addUpdateListener(new d());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int z() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f1802b.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    protected int A() {
        return D() ? b.c.a.b.h.mtrl_layout_snackbar : b.c.a.b.h.design_layout_snackbar;
    }

    protected boolean D() {
        TypedArray obtainStyledAttributes = this.f1802b.obtainStyledAttributes(u);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    final void E(int i2) {
        if (L() && this.f1803c.getVisibility() == 0) {
            q(i2);
        } else {
            H(i2);
        }
    }

    public boolean F() {
        return com.google.android.material.snackbar.b.c().e(this.r);
    }

    void H(int i2) {
        com.google.android.material.snackbar.b.c().h(this.r);
        List<r<B>> list = this.o;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.o.get(size).a(this, i2);
            }
        }
        ViewParent parent = this.f1803c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f1803c);
        }
    }

    void I() {
        com.google.android.material.snackbar.b.c().i(this.r);
        List<r<B>> list = this.o;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.o.get(size).b(this);
            }
        }
    }

    public B J(int i2) {
        this.e = i2;
        return this;
    }

    boolean L() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.q.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void N() {
        com.google.android.material.snackbar.b.c().m(w(), this.r);
    }

    final void O() {
        this.f1803c.setOnAttachStateChangeListener(new n());
        if (this.f1803c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f1803c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                K((CoordinatorLayout.f) layoutParams);
            }
            this.n = r();
            U();
            this.f1803c.setVisibility(4);
            this.f1801a.addView(this.f1803c);
        }
        if (a.g.k.s.M(this.f1803c)) {
            P();
        } else {
            this.f1803c.setOnLayoutChangeListener(new o());
        }
    }

    void p() {
        this.f1803c.post(new q());
    }

    public void t() {
        u(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(int i2) {
        com.google.android.material.snackbar.b.c().b(this.r, i2);
    }

    public int w() {
        return this.e;
    }

    protected SwipeDismissBehavior<? extends View> x() {
        return new Behavior();
    }
}
