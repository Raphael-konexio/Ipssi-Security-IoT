package a.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends m {
    private static final String[] R = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> S = new b(PointF.class, "boundsOrigin");
    private static final Property<k, PointF> T = new C0026c(PointF.class, "topLeft");
    private static final Property<k, PointF> U = new d(PointF.class, "bottomRight");
    private static final Property<View, PointF> V = new e(PointF.class, "bottomRight");
    private static final Property<View, PointF> W = new f(PointF.class, "topLeft");
    private static final Property<View, PointF> X = new g(PointF.class, "position");
    private static a.p.k Y = new a.p.k();
    private int[] O = new int[2];
    private boolean P = false;
    private boolean Q = false;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f340a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f341b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f342c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f343d;

        a(c cVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
            this.f340a = viewGroup;
            this.f341b = bitmapDrawable;
            this.f342c = view;
            this.f343d = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c0.b(this.f340a).d(this.f341b);
            c0.g(this.f342c, this.f343d);
        }
    }

    /* loaded from: classes.dex */
    static class b extends Property<Drawable, PointF> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f344a;

        b(Class cls, String str) {
            super(cls, str);
            this.f344a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f344a);
            Rect rect = this.f344a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f344a);
            this.f344a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f344a);
        }
    }

    /* renamed from: a.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0026c extends Property<k, PointF> {
        C0026c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    /* loaded from: classes.dex */
    static class d extends Property<k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* loaded from: classes.dex */
    static class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, PointF pointF) {
            c0.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* loaded from: classes.dex */
    static class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, PointF pointF) {
            c0.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* loaded from: classes.dex */
    static class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            c0.f(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* loaded from: classes.dex */
    class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f345a;
        private k mViewBounds;

        h(c cVar, k kVar) {
            this.f345a = kVar;
            this.mViewBounds = this.f345a;
        }
    }

    /* loaded from: classes.dex */
    class i extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f346a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f347b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Rect f348c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f349d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;

        i(c cVar, View view, Rect rect, int i, int i2, int i3, int i4) {
            this.f347b = view;
            this.f348c = rect;
            this.f349d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f346a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f346a) {
                return;
            }
            a.g.k.s.l0(this.f347b, this.f348c);
            c0.f(this.f347b, this.f349d, this.e, this.f, this.g);
        }
    }

    /* loaded from: classes.dex */
    class j extends n {

        /* renamed from: a  reason: collision with root package name */
        boolean f350a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f351b;

        j(c cVar, ViewGroup viewGroup) {
            this.f351b = viewGroup;
        }

        @Override // a.p.n, a.p.m.f
        public void b(m mVar) {
            x.c(this.f351b, false);
            this.f350a = true;
        }

        @Override // a.p.n, a.p.m.f
        public void c(m mVar) {
            x.c(this.f351b, false);
        }

        @Override // a.p.n, a.p.m.f
        public void d(m mVar) {
            x.c(this.f351b, true);
        }

        @Override // a.p.m.f
        public void e(m mVar) {
            if (!this.f350a) {
                x.c(this.f351b, false);
            }
            mVar.P(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        private int f352a;

        /* renamed from: b  reason: collision with root package name */
        private int f353b;

        /* renamed from: c  reason: collision with root package name */
        private int f354c;

        /* renamed from: d  reason: collision with root package name */
        private int f355d;
        private View e;
        private int f;
        private int g;

        k(View view) {
            this.e = view;
        }

        private void b() {
            c0.f(this.e, this.f352a, this.f353b, this.f354c, this.f355d);
            this.f = 0;
            this.g = 0;
        }

        void a(PointF pointF) {
            this.f354c = Math.round(pointF.x);
            this.f355d = Math.round(pointF.y);
            int i = this.g + 1;
            this.g = i;
            if (this.f == i) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f352a = Math.round(pointF.x);
            this.f353b = Math.round(pointF.y);
            int i = this.f + 1;
            this.f = i;
            if (i == this.g) {
                b();
            }
        }
    }

    private void c0(s sVar) {
        View view = sVar.f412b;
        if (!a.g.k.s.M(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.f411a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.f411a.put("android:changeBounds:parent", sVar.f412b.getParent());
        if (this.Q) {
            sVar.f412b.getLocationInWindow(this.O);
            sVar.f411a.put("android:changeBounds:windowX", Integer.valueOf(this.O[0]));
            sVar.f411a.put("android:changeBounds:windowY", Integer.valueOf(this.O[1]));
        }
        if (this.P) {
            sVar.f411a.put("android:changeBounds:clip", a.g.k.s.p(view));
        }
    }

    private boolean d0(View view, View view2) {
        if (this.Q) {
            s t = t(view, true);
            if (t == null) {
                if (view == view2) {
                    return true;
                }
            } else if (view2 == t.f412b) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // a.p.m
    public String[] D() {
        return R;
    }

    @Override // a.p.m
    public void g(s sVar) {
        c0(sVar);
    }

    @Override // a.p.m
    public void j(s sVar) {
        c0(sVar);
    }

    @Override // a.p.m
    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        int i2;
        View view;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator c2;
        Path a2;
        Property<View, PointF> property;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map<String, Object> map = sVar.f411a;
        Map<String, Object> map2 = sVar2.f411a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.f412b;
        if (!d0(viewGroup2, viewGroup3)) {
            int intValue = ((Integer) sVar.f411a.get("android:changeBounds:windowX")).intValue();
            int intValue2 = ((Integer) sVar.f411a.get("android:changeBounds:windowY")).intValue();
            int intValue3 = ((Integer) sVar2.f411a.get("android:changeBounds:windowX")).intValue();
            int intValue4 = ((Integer) sVar2.f411a.get("android:changeBounds:windowY")).intValue();
            if (intValue == intValue3 && intValue2 == intValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.O);
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(createBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
            float c3 = c0.c(view2);
            c0.g(view2, 0.0f);
            c0.b(viewGroup).b(bitmapDrawable);
            a.p.g v = v();
            int[] iArr = this.O;
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, a.p.i.a(S, v.a(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
            ofPropertyValuesHolder.addListener(new a(this, viewGroup, bitmapDrawable, view2, c3));
            return ofPropertyValuesHolder;
        }
        Rect rect2 = (Rect) sVar.f411a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) sVar2.f411a.get("android:changeBounds:bounds");
        int i4 = rect2.left;
        int i5 = rect3.left;
        int i6 = rect2.top;
        int i7 = rect3.top;
        int i8 = rect2.right;
        int i9 = rect3.right;
        int i10 = rect2.bottom;
        int i11 = rect3.bottom;
        int i12 = i8 - i4;
        int i13 = i10 - i6;
        int i14 = i9 - i5;
        int i15 = i11 - i7;
        Rect rect4 = (Rect) sVar.f411a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) sVar2.f411a.get("android:changeBounds:clip");
        if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
            i2 = 0;
        } else {
            i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
            if (i8 != i9 || i10 != i11) {
                i2++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i2++;
        }
        if (i2 > 0) {
            if (this.P) {
                view = view2;
                c0.f(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                ObjectAnimator a3 = (i4 == i5 && i6 == i7) ? null : a.p.f.a(view, X, v().a(i4, i6, i5, i7));
                if (rect4 == null) {
                    i3 = 0;
                    rect = new Rect(0, 0, i12, i13);
                } else {
                    i3 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
                if (rect.equals(rect6)) {
                    objectAnimator = null;
                } else {
                    a.g.k.s.l0(view, rect);
                    a.p.k kVar = Y;
                    Object[] objArr = new Object[2];
                    objArr[i3] = rect;
                    objArr[1] = rect6;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", kVar, objArr);
                    ofObject.addListener(new i(this, view, rect5, i5, i7, i9, i11));
                    objectAnimator = ofObject;
                }
                c2 = r.c(a3, objectAnimator);
            } else {
                view = view2;
                c0.f(view, i4, i6, i8, i10);
                if (i2 == 2) {
                    if (i12 == i14 && i13 == i15) {
                        a2 = v().a(i4, i6, i5, i7);
                        property = X;
                    } else {
                        k kVar2 = new k(view);
                        ObjectAnimator a4 = a.p.f.a(kVar2, T, v().a(i4, i6, i5, i7));
                        ObjectAnimator a5 = a.p.f.a(kVar2, U, v().a(i8, i10, i9, i11));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(a4, a5);
                        animatorSet.addListener(new h(this, kVar2));
                        c2 = animatorSet;
                    }
                } else if (i4 == i5 && i6 == i7) {
                    a2 = v().a(i8, i10, i9, i11);
                    property = V;
                } else {
                    a2 = v().a(i4, i6, i5, i7);
                    property = W;
                }
                c2 = a.p.f.a(view, property, a2);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                x.c(viewGroup4, true);
                a(new j(this, viewGroup4));
            }
            return c2;
        }
        return null;
    }
}
