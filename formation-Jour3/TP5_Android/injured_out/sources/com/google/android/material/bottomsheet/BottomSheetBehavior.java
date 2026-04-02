package com.google.android.material.bottomsheet;

import a.g.k.b0.c;
import a.g.k.b0.f;
import a.g.k.s;
import a.i.b.c;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.c.a.b.a0.k;
import b.c.a.b.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    private static final int K = j.Widget_Design_BottomSheet_Modal;
    int A;
    WeakReference<V> B;
    WeakReference<View> C;
    private final ArrayList<e> D;
    private VelocityTracker E;
    int F;
    private int G;
    boolean H;
    private Map<View, Integer> I;
    private final c.AbstractC0019c J;

    /* renamed from: a  reason: collision with root package name */
    private int f1699a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1700b;

    /* renamed from: c  reason: collision with root package name */
    private float f1701c;

    /* renamed from: d  reason: collision with root package name */
    private int f1702d;
    private boolean e;
    private int f;
    private boolean g;
    private b.c.a.b.a0.g h;
    private k i;
    private boolean j;
    private BottomSheetBehavior<V>.g k;
    private ValueAnimator l;
    int m;
    int n;
    int o;
    float p;
    int q;
    float r;
    boolean s;
    private boolean t;
    int u;
    a.i.b.c v;
    private boolean w;
    private int x;
    private boolean y;
    int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ View f;
        final /* synthetic */ int g;

        a(View view, int i) {
            this.f = view;
            this.g = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.f0(this.f, this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.h != null) {
                BottomSheetBehavior.this.h.U(floatValue);
            }
        }
    }

    /* loaded from: classes.dex */
    class c extends c.AbstractC0019c {
        c() {
        }

        @Override // a.i.b.c.AbstractC0019c
        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // a.i.b.c.AbstractC0019c
        public int b(View view, int i, int i2) {
            int R = BottomSheetBehavior.this.R();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return a.g.f.a.b(i, R, bottomSheetBehavior.s ? bottomSheetBehavior.A : bottomSheetBehavior.q);
        }

        @Override // a.i.b.c.AbstractC0019c
        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.s ? bottomSheetBehavior.A : bottomSheetBehavior.q;
        }

        @Override // a.i.b.c.AbstractC0019c
        public void j(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.e0(1);
            }
        }

        @Override // a.i.b.c.AbstractC0019c
        public void k(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.P(i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0084, code lost:
            if (java.lang.Math.abs(r8 - r6.f1704a.o) < java.lang.Math.abs(r8 - r6.f1704a.q)) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00ab, code lost:
            if (java.lang.Math.abs(r8 - r6.f1704a.n) < java.lang.Math.abs(r8 - r6.f1704a.q)) goto L5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00d4, code lost:
            if (java.lang.Math.abs(r8 - r0) < java.lang.Math.abs(r8 - r6.f1704a.q)) goto L33;
         */
        @Override // a.i.b.c.AbstractC0019c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l(android.view.View r7, float r8, float r9) {
            /*
                Method dump skipped, instructions count: 222
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.c.l(android.view.View, float, float):void");
        }

        @Override // a.i.b.c.AbstractC0019c
        public boolean m(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.u;
            if (i2 == 1 || bottomSheetBehavior.H) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.F == i) {
                WeakReference<View> weakReference = bottomSheetBehavior.C;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.B;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements a.g.k.b0.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1705a;

        d(int i) {
            this.f1705a = i;
        }

        @Override // a.g.k.b0.f
        public boolean a(View view, f.a aVar) {
            BottomSheetBehavior.this.d0(this.f1705a);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {
        public abstract void a(View view, float f);

        public abstract void b(View view, int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class f extends a.i.a.a {
        public static final Parcelable.Creator<f> CREATOR = new a();
        final int h;
        int i;
        boolean j;
        boolean k;
        boolean l;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<f> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public f[] newArray(int i) {
                return new f[i];
            }
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.h = parcel.readInt();
            this.i = parcel.readInt();
            this.j = parcel.readInt() == 1;
            this.k = parcel.readInt() == 1;
            this.l = parcel.readInt() == 1;
        }

        public f(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.h = bottomSheetBehavior.u;
            this.i = ((BottomSheetBehavior) bottomSheetBehavior).f1702d;
            this.j = ((BottomSheetBehavior) bottomSheetBehavior).f1700b;
            this.k = bottomSheetBehavior.s;
            this.l = ((BottomSheetBehavior) bottomSheetBehavior).t;
        }

        @Override // a.i.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeInt(this.k ? 1 : 0);
            parcel.writeInt(this.l ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        private final View f;
        private boolean g;
        int h;

        g(View view, int i) {
            this.f = view;
            this.h = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.i.b.c cVar = BottomSheetBehavior.this.v;
            if (cVar == null || !cVar.k(true)) {
                BottomSheetBehavior.this.e0(this.h);
            } else {
                s.Y(this.f, this);
            }
            this.g = false;
        }
    }

    public BottomSheetBehavior() {
        this.f1699a = 0;
        this.f1700b = true;
        this.k = null;
        this.p = 0.5f;
        this.r = -1.0f;
        this.u = 4;
        this.D = new ArrayList<>();
        this.J = new c();
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int dimensionPixelSize;
        this.f1699a = 0;
        this.f1700b = true;
        this.k = null;
        this.p = 0.5f;
        this.r = -1.0f;
        this.u = 4;
        this.D = new ArrayList<>();
        this.J = new c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.c.a.b.k.BottomSheetBehavior_Layout);
        this.g = obtainStyledAttributes.hasValue(b.c.a.b.k.BottomSheetBehavior_Layout_shapeAppearance);
        boolean hasValue = obtainStyledAttributes.hasValue(b.c.a.b.k.BottomSheetBehavior_Layout_backgroundTint);
        if (hasValue) {
            N(context, attributeSet, hasValue, b.c.a.b.x.c.a(context, obtainStyledAttributes, b.c.a.b.k.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            M(context, attributeSet, hasValue);
        }
        O();
        if (Build.VERSION.SDK_INT >= 21) {
            this.r = obtainStyledAttributes.getDimension(b.c.a.b.k.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(b.c.a.b.k.BottomSheetBehavior_Layout_behavior_peekHeight);
        Z((peekValue == null || (dimensionPixelSize = peekValue.data) != -1) ? obtainStyledAttributes.getDimensionPixelSize(b.c.a.b.k.BottomSheetBehavior_Layout_behavior_peekHeight, -1) : dimensionPixelSize);
        Y(obtainStyledAttributes.getBoolean(b.c.a.b.k.BottomSheetBehavior_Layout_behavior_hideable, false));
        W(obtainStyledAttributes.getBoolean(b.c.a.b.k.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        c0(obtainStyledAttributes.getBoolean(b.c.a.b.k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        b0(obtainStyledAttributes.getInt(b.c.a.b.k.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        X(obtainStyledAttributes.getFloat(b.c.a.b.k.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        V(obtainStyledAttributes.getInt(b.c.a.b.k.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        obtainStyledAttributes.recycle();
        this.f1701c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void J(V v, c.a aVar, int i) {
        s.c0(v, aVar, null, new d(i));
    }

    private void K() {
        int max = this.e ? Math.max(this.f, this.A - ((this.z * 9) / 16)) : this.f1702d;
        if (this.f1700b) {
            this.q = Math.max(this.A - max, this.n);
        } else {
            this.q = this.A - max;
        }
    }

    private void L() {
        this.o = (int) (this.A * (1.0f - this.p));
    }

    private void M(Context context, AttributeSet attributeSet, boolean z) {
        N(context, attributeSet, z, null);
    }

    private void N(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.g) {
            this.i = k.e(context, attributeSet, b.c.a.b.b.bottomSheetStyle, K).m();
            b.c.a.b.a0.g gVar = new b.c.a.b.a0.g(this.i);
            this.h = gVar;
            gVar.L(context);
            if (z && colorStateList != null) {
                this.h.T(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.h.setTint(typedValue.data);
        }
    }

    private void O() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.l = ofFloat;
        ofFloat.setDuration(500L);
        this.l.addUpdateListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int R() {
        return this.f1700b ? this.n : this.m;
    }

    private float S() {
        VelocityTracker velocityTracker = this.E;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f1701c);
        return this.E.getYVelocity(this.F);
    }

    private void T() {
        this.F = -1;
        VelocityTracker velocityTracker = this.E;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.E = null;
        }
    }

    private void U(f fVar) {
        int i = this.f1699a;
        if (i == 0) {
            return;
        }
        if (i == -1 || (i & 1) == 1) {
            this.f1702d = fVar.i;
        }
        int i2 = this.f1699a;
        if (i2 == -1 || (i2 & 2) == 2) {
            this.f1700b = fVar.j;
        }
        int i3 = this.f1699a;
        if (i3 == -1 || (i3 & 4) == 4) {
            this.s = fVar.k;
        }
        int i4 = this.f1699a;
        if (i4 == -1 || (i4 & 8) == 8) {
            this.t = fVar.l;
        }
    }

    private void g0(int i) {
        V v = this.B.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && s.L(v)) {
            v.post(new a(v, i));
        } else {
            f0(v, i);
        }
    }

    private void j0() {
        V v;
        int i;
        c.a aVar;
        WeakReference<V> weakReference = this.B;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        s.a0(v, 524288);
        s.a0(v, 262144);
        s.a0(v, 1048576);
        if (this.s && this.u != 5) {
            J(v, c.a.j, 5);
        }
        int i2 = this.u;
        if (i2 == 3) {
            i = this.f1700b ? 4 : 6;
            aVar = c.a.i;
        } else if (i2 != 4) {
            if (i2 != 6) {
                return;
            }
            J(v, c.a.i, 4);
            J(v, c.a.h, 3);
            return;
        } else {
            i = this.f1700b ? 3 : 6;
            aVar = c.a.h;
        }
        J(v, aVar, i);
    }

    private void k0(int i) {
        ValueAnimator valueAnimator;
        if (i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.j != z) {
            this.j = z;
            if (this.h == null || (valueAnimator = this.l) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.l.reverse();
                return;
            }
            float f2 = z ? 0.0f : 1.0f;
            this.l.setFloatValues(1.0f - f2, f2);
            this.l.start();
        }
    }

    private void l0(boolean z) {
        int intValue;
        WeakReference<V> weakReference = this.B;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.I != null) {
                    return;
                }
                this.I = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.B.get()) {
                    if (!z) {
                        Map<View, Integer> map = this.I;
                        intValue = (map != null && map.containsKey(childAt)) ? this.I.get(childAt).intValue() : 4;
                    } else if (Build.VERSION.SDK_INT >= 16) {
                        this.I.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    }
                    s.p0(childAt, intValue);
                }
            }
            if (z) {
                return;
            }
            this.I = null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.x = 0;
        this.y = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.q)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0099, code lost:
        if (java.lang.Math.abs(r3 - r2.o) < java.lang.Math.abs(r3 - r2.q)) goto L35;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(androidx.coordinatorlayout.widget.CoordinatorLayout r3, V r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.R()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.e0(r0)
            return
        Lf:
            java.lang.ref.WeakReference<android.view.View> r3 = r2.C
            if (r3 == 0) goto La4
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto La4
            boolean r3 = r2.y
            if (r3 != 0) goto L1f
            goto La4
        L1f:
            int r3 = r2.x
            r5 = 6
            r6 = 4
            if (r3 <= 0) goto L2b
            int r3 = r2.R()
            goto L9e
        L2b:
            boolean r3 = r2.s
            if (r3 == 0) goto L3d
            float r3 = r2.S()
            boolean r3 = r2.h0(r4, r3)
            if (r3 == 0) goto L3d
            int r3 = r2.A
            r0 = 5
            goto L9e
        L3d:
            int r3 = r2.x
            if (r3 != 0) goto L7e
            int r3 = r4.getTop()
            boolean r1 = r2.f1700b
            if (r1 == 0) goto L5d
            int r5 = r2.n
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.q
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L82
            int r3 = r2.n
            goto L9e
        L5d:
            int r1 = r2.o
            if (r3 >= r1) goto L6e
            int r6 = r2.q
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            if (r3 >= r6) goto L9b
            int r3 = r2.m
            goto L9e
        L6e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.q
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L82
            goto L9b
        L7e:
            boolean r3 = r2.f1700b
            if (r3 == 0) goto L86
        L82:
            int r3 = r2.q
            r0 = 4
            goto L9e
        L86:
            int r3 = r4.getTop()
            int r0 = r2.o
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.q
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L82
        L9b:
            int r3 = r2.o
            r0 = 6
        L9e:
            r5 = 0
            r2.i0(r4, r0, r3, r5)
            r2.y = r5
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.C(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (v.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (this.u == 1 && actionMasked == 0) {
                return true;
            }
            a.i.b.c cVar = this.v;
            if (cVar != null) {
                cVar.z(motionEvent);
            }
            if (actionMasked == 0) {
                T();
            }
            if (this.E == null) {
                this.E = VelocityTracker.obtain();
            }
            this.E.addMovement(motionEvent);
            if (actionMasked == 2 && !this.w && Math.abs(this.G - motionEvent.getY()) > this.v.u()) {
                this.v.b(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            return !this.w;
        }
        return false;
    }

    void P(int i) {
        float f2;
        float R;
        V v = this.B.get();
        if (v == null || this.D.isEmpty()) {
            return;
        }
        int i2 = this.q;
        if (i > i2) {
            f2 = i2 - i;
            R = this.A - i2;
        } else {
            f2 = i2 - i;
            R = i2 - R();
        }
        float f3 = f2 / R;
        for (int i3 = 0; i3 < this.D.size(); i3++) {
            this.D.get(i3).a(v, f3);
        }
    }

    View Q(View view) {
        if (s.N(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View Q = Q(viewGroup.getChildAt(i));
                if (Q != null) {
                    return Q;
                }
            }
            return null;
        }
        return null;
    }

    public void V(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.m = i;
    }

    public void W(boolean z) {
        if (this.f1700b == z) {
            return;
        }
        this.f1700b = z;
        if (this.B != null) {
            K();
        }
        e0((this.f1700b && this.u == 6) ? 3 : this.u);
        j0();
    }

    public void X(float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.p = f2;
    }

    public void Y(boolean z) {
        if (this.s != z) {
            this.s = z;
            if (!z && this.u == 5) {
                d0(4);
            }
            j0();
        }
    }

    public void Z(int i) {
        a0(i, false);
    }

    public final void a0(int i, boolean z) {
        V v;
        boolean z2 = true;
        if (i == -1) {
            if (!this.e) {
                this.e = true;
            }
            z2 = false;
        } else {
            if (this.e || this.f1702d != i) {
                this.e = false;
                this.f1702d = Math.max(0, i);
            }
            z2 = false;
        }
        if (!z2 || this.B == null) {
            return;
        }
        K();
        if (this.u != 4 || (v = this.B.get()) == null) {
            return;
        }
        if (z) {
            g0(this.u);
        } else {
            v.requestLayout();
        }
    }

    public void b0(int i) {
        this.f1699a = i;
    }

    public void c0(boolean z) {
        this.t = z;
    }

    public void d0(int i) {
        if (i == this.u) {
            return;
        }
        if (this.B != null) {
            g0(i);
        } else if (i == 4 || i == 3 || i == 6 || (this.s && i == 5)) {
            this.u = i;
        }
    }

    void e0(int i) {
        V v;
        if (this.u == i) {
            return;
        }
        this.u = i;
        WeakReference<V> weakReference = this.B;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i == 6 || i == 3) {
            l0(true);
        } else if (i == 5 || i == 4) {
            l0(false);
        }
        k0(i);
        for (int i2 = 0; i2 < this.D.size(); i2++) {
            this.D.get(i2).b(v, i);
        }
        j0();
    }

    void f0(View view, int i) {
        int i2;
        int i3;
        if (i == 4) {
            i2 = this.q;
        } else if (i == 6) {
            int i4 = this.o;
            if (!this.f1700b || i4 > (i3 = this.n)) {
                i2 = i4;
            } else {
                i2 = i3;
                i = 3;
            }
        } else if (i == 3) {
            i2 = R();
        } else if (!this.s || i != 5) {
            throw new IllegalArgumentException("Illegal state argument: " + i);
        } else {
            i2 = this.A;
        }
        i0(view, i, i2, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        super.g(fVar);
        this.B = null;
        this.v = null;
    }

    boolean h0(View view, float f2) {
        if (this.t) {
            return true;
        }
        return view.getTop() >= this.q && Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.q)) / ((float) this.f1702d) > 0.5f;
    }

    void i0(View view, int i, int i2, boolean z) {
        if (!(z ? this.v.F(view.getLeft(), i2) : this.v.H(view, view.getLeft(), i2))) {
            e0(i);
            return;
        }
        e0(2);
        k0(i);
        if (this.k == null) {
            this.k = new g(view, i);
        }
        if (((g) this.k).g) {
            this.k.h = i;
            return;
        }
        BottomSheetBehavior<V>.g gVar = this.k;
        gVar.h = i;
        s.Y(view, gVar);
        ((g) this.k).g = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void j() {
        super.j();
        this.B = null;
        this.v = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        a.i.b.c cVar;
        if (!v.isShown()) {
            this.w = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            T();
        }
        if (this.E == null) {
            this.E = VelocityTracker.obtain();
        }
        this.E.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.G = (int) motionEvent.getY();
            if (this.u != 2) {
                WeakReference<View> weakReference = this.C;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.B(view, x, this.G)) {
                    this.F = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.H = true;
                }
            }
            this.w = this.F == -1 && !coordinatorLayout.B(v, x, this.G);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.H = false;
            this.F = -1;
            if (this.w) {
                this.w = false;
                return false;
            }
        }
        if (this.w || (cVar = this.v) == null || !cVar.G(motionEvent)) {
            WeakReference<View> weakReference2 = this.C;
            View view2 = weakReference2 != null ? weakReference2.get() : null;
            return (actionMasked != 2 || view2 == null || this.w || this.u == 1 || coordinatorLayout.B(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.v == null || Math.abs(((float) this.G) - motionEvent.getY()) <= ((float) this.v.u())) ? false : true;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i) {
        int i2;
        b.c.a.b.a0.g gVar;
        if (s.t(coordinatorLayout) && !s.t(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.B == null) {
            this.f = coordinatorLayout.getResources().getDimensionPixelSize(b.c.a.b.d.design_bottom_sheet_peek_height_min);
            this.B = new WeakReference<>(v);
            if (this.g && (gVar = this.h) != null) {
                s.i0(v, gVar);
            }
            b.c.a.b.a0.g gVar2 = this.h;
            if (gVar2 != null) {
                float f2 = this.r;
                if (f2 == -1.0f) {
                    f2 = s.r(v);
                }
                gVar2.S(f2);
                boolean z = this.u == 3;
                this.j = z;
                this.h.U(z ? 0.0f : 1.0f);
            }
            j0();
            if (s.u(v) == 0) {
                s.p0(v, 1);
            }
        }
        if (this.v == null) {
            this.v = a.i.b.c.m(coordinatorLayout, this.J);
        }
        int top = v.getTop();
        coordinatorLayout.I(v, i);
        this.z = coordinatorLayout.getWidth();
        int height = coordinatorLayout.getHeight();
        this.A = height;
        this.n = Math.max(0, height - v.getHeight());
        L();
        K();
        int i3 = this.u;
        if (i3 == 3) {
            i2 = R();
        } else if (i3 == 6) {
            i2 = this.o;
        } else if (this.s && i3 == 5) {
            i2 = this.A;
        } else {
            int i4 = this.u;
            if (i4 != 4) {
                if (i4 == 1 || i4 == 2) {
                    s.S(v, top - v.getTop());
                }
                this.C = new WeakReference<>(Q(v));
                return true;
            }
            i2 = this.q;
        }
        s.S(v, i2);
        this.C = new WeakReference<>(Q(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.C;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.u != 3 || super.o(coordinatorLayout, v, view, f2, f3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void q(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        int i4;
        if (i3 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.C;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i5 = top - i2;
        if (i2 > 0) {
            if (i5 < R()) {
                iArr[1] = top - R();
                s.S(v, -iArr[1]);
                i4 = 3;
                e0(i4);
            } else {
                iArr[1] = i2;
                s.S(v, -i2);
                e0(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i6 = this.q;
            if (i5 <= i6 || this.s) {
                iArr[1] = i2;
                s.S(v, -i2);
                e0(1);
            } else {
                iArr[1] = top - i6;
                s.S(v, -iArr[1]);
                i4 = 4;
                e0(i4);
            }
        }
        P(v.getTop());
        this.x = i2;
        this.y = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        f fVar = (f) parcelable;
        super.x(coordinatorLayout, v, fVar.a());
        U(fVar);
        int i = fVar.h;
        this.u = (i == 1 || i == 2) ? 4 : 4;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable y(CoordinatorLayout coordinatorLayout, V v) {
        return new f(super.y(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }
}
