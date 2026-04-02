package a.g.k;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
/* loaded from: classes.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    private final l f226a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Field f227a;

        /* renamed from: b  reason: collision with root package name */
        private static Field f228b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f229c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f230d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f227a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f228b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f229c = declaredField3;
                declaredField3.setAccessible(true);
                f230d = true;
            } catch (ReflectiveOperationException e) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
            }
        }

        public static a0 a(View view) {
            if (f230d && view.isAttachedToWindow()) {
                try {
                    Object obj = f227a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f228b.get(obj);
                        Rect rect2 = (Rect) f229c.get(obj);
                        if (rect != null && rect2 != null) {
                            b bVar = new b();
                            bVar.b(a.g.d.b.c(rect));
                            bVar.c(a.g.d.b.c(rect2));
                            a0 a2 = bVar.a();
                            a2.p(a2);
                            a2.d(view.getRootView());
                            return a2;
                        }
                    }
                } catch (IllegalAccessException e) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final f f231a;

        public b() {
            int i = Build.VERSION.SDK_INT;
            this.f231a = i >= 30 ? new e() : i >= 29 ? new d() : i >= 20 ? new c() : new f();
        }

        public b(a0 a0Var) {
            int i = Build.VERSION.SDK_INT;
            this.f231a = i >= 30 ? new e(a0Var) : i >= 29 ? new d(a0Var) : i >= 20 ? new c(a0Var) : new f(a0Var);
        }

        public a0 a() {
            return this.f231a.b();
        }

        @Deprecated
        public b b(a.g.d.b bVar) {
            this.f231a.d(bVar);
            return this;
        }

        @Deprecated
        public b c(a.g.d.b bVar) {
            this.f231a.f(bVar);
            return this;
        }
    }

    /* loaded from: classes.dex */
    private static class c extends f {
        private static Field e = null;
        private static boolean f = false;
        private static Constructor<WindowInsets> g = null;
        private static boolean h = false;

        /* renamed from: c  reason: collision with root package name */
        private WindowInsets f232c;

        /* renamed from: d  reason: collision with root package name */
        private a.g.d.b f233d;

        c() {
            this.f232c = h();
        }

        c(a0 a0Var) {
            super(a0Var);
            this.f232c = a0Var.r();
        }

        private static WindowInsets h() {
            if (!f) {
                try {
                    e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f = true;
            }
            Field field = e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!h) {
                try {
                    g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                h = true;
            }
            Constructor<WindowInsets> constructor = g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        @Override // a.g.k.a0.f
        a0 b() {
            a();
            a0 s = a0.s(this.f232c);
            s.n(this.f236b);
            s.q(this.f233d);
            return s;
        }

        @Override // a.g.k.a0.f
        void d(a.g.d.b bVar) {
            this.f233d = bVar;
        }

        @Override // a.g.k.a0.f
        void f(a.g.d.b bVar) {
            WindowInsets windowInsets = this.f232c;
            if (windowInsets != null) {
                this.f232c = windowInsets.replaceSystemWindowInsets(bVar.f132a, bVar.f133b, bVar.f134c, bVar.f135d);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class d extends f {

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets.Builder f234c;

        d() {
            this.f234c = new WindowInsets.Builder();
        }

        d(a0 a0Var) {
            super(a0Var);
            WindowInsets r = a0Var.r();
            this.f234c = r != null ? new WindowInsets.Builder(r) : new WindowInsets.Builder();
        }

        @Override // a.g.k.a0.f
        a0 b() {
            a();
            a0 s = a0.s(this.f234c.build());
            s.n(this.f236b);
            return s;
        }

        @Override // a.g.k.a0.f
        void c(a.g.d.b bVar) {
            this.f234c.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // a.g.k.a0.f
        void d(a.g.d.b bVar) {
            this.f234c.setStableInsets(bVar.e());
        }

        @Override // a.g.k.a0.f
        void e(a.g.d.b bVar) {
            this.f234c.setSystemGestureInsets(bVar.e());
        }

        @Override // a.g.k.a0.f
        void f(a.g.d.b bVar) {
            this.f234c.setSystemWindowInsets(bVar.e());
        }

        @Override // a.g.k.a0.f
        void g(a.g.d.b bVar) {
            this.f234c.setTappableElementInsets(bVar.e());
        }
    }

    /* loaded from: classes.dex */
    private static class e extends d {
        e() {
        }

        e(a0 a0Var) {
            super(a0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private final a0 f235a;

        /* renamed from: b  reason: collision with root package name */
        a.g.d.b[] f236b;

        f() {
            this(new a0((a0) null));
        }

        f(a0 a0Var) {
            this.f235a = a0Var;
        }

        protected final void a() {
            a.g.d.b[] bVarArr = this.f236b;
            if (bVarArr != null) {
                a.g.d.b bVar = bVarArr[m.a(1)];
                a.g.d.b bVar2 = this.f236b[m.a(2)];
                if (bVar2 == null) {
                    bVar2 = this.f235a.f(2);
                }
                if (bVar == null) {
                    bVar = this.f235a.f(1);
                }
                f(a.g.d.b.a(bVar, bVar2));
                a.g.d.b bVar3 = this.f236b[m.a(16)];
                if (bVar3 != null) {
                    e(bVar3);
                }
                a.g.d.b bVar4 = this.f236b[m.a(32)];
                if (bVar4 != null) {
                    c(bVar4);
                }
                a.g.d.b bVar5 = this.f236b[m.a(64)];
                if (bVar5 != null) {
                    g(bVar5);
                }
            }
        }

        a0 b() {
            a();
            return this.f235a;
        }

        void c(a.g.d.b bVar) {
        }

        void d(a.g.d.b bVar) {
        }

        void e(a.g.d.b bVar) {
        }

        void f(a.g.d.b bVar) {
        }

        void g(a.g.d.b bVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g extends l {
        private static boolean h = false;
        private static Method i;
        private static Class<?> j;
        private static Class<?> k;
        private static Field l;
        private static Field m;

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets f237c;

        /* renamed from: d  reason: collision with root package name */
        private a.g.d.b[] f238d;
        private a.g.d.b e;
        private a0 f;
        a.g.d.b g;

        g(a0 a0Var, g gVar) {
            this(a0Var, new WindowInsets(gVar.f237c));
        }

        g(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var);
            this.e = null;
            this.f237c = windowInsets;
        }

        private a.g.d.b s(int i2, boolean z) {
            a.g.d.b bVar = a.g.d.b.e;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    bVar = a.g.d.b.a(bVar, t(i3, z));
                }
            }
            return bVar;
        }

        private a.g.d.b u() {
            a0 a0Var = this.f;
            return a0Var != null ? a0Var.g() : a.g.d.b.e;
        }

        private a.g.d.b v(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!h) {
                    w();
                }
                Method method = i;
                if (method != null && k != null && l != null) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) l.get(m.get(invoke));
                        if (rect != null) {
                            return a.g.d.b.c(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        private static void w() {
            try {
                i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                j = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                k = cls;
                l = cls.getDeclaredField("mVisibleInsets");
                m = j.getDeclaredField("mAttachInfo");
                l.setAccessible(true);
                m.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
            h = true;
        }

        @Override // a.g.k.a0.l
        void d(View view) {
            a.g.d.b v = v(view);
            if (v == null) {
                v = a.g.d.b.e;
            }
            p(v);
        }

        @Override // a.g.k.a0.l
        void e(a0 a0Var) {
            a0Var.p(this.f);
            a0Var.o(this.g);
        }

        @Override // a.g.k.a0.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.g, ((g) obj).g);
            }
            return false;
        }

        @Override // a.g.k.a0.l
        public a.g.d.b g(int i2) {
            return s(i2, false);
        }

        @Override // a.g.k.a0.l
        final a.g.d.b k() {
            if (this.e == null) {
                this.e = a.g.d.b.b(this.f237c.getSystemWindowInsetLeft(), this.f237c.getSystemWindowInsetTop(), this.f237c.getSystemWindowInsetRight(), this.f237c.getSystemWindowInsetBottom());
            }
            return this.e;
        }

        @Override // a.g.k.a0.l
        boolean n() {
            return this.f237c.isRound();
        }

        @Override // a.g.k.a0.l
        public void o(a.g.d.b[] bVarArr) {
            this.f238d = bVarArr;
        }

        @Override // a.g.k.a0.l
        void p(a.g.d.b bVar) {
            this.g = bVar;
        }

        @Override // a.g.k.a0.l
        void q(a0 a0Var) {
            this.f = a0Var;
        }

        protected a.g.d.b t(int i2, boolean z) {
            a.g.d.b g;
            int i3;
            if (i2 == 1) {
                return z ? a.g.d.b.b(0, Math.max(u().f133b, k().f133b), 0, 0) : a.g.d.b.b(0, k().f133b, 0, 0);
            }
            if (i2 == 2) {
                if (z) {
                    a.g.d.b u = u();
                    a.g.d.b i4 = i();
                    return a.g.d.b.b(Math.max(u.f132a, i4.f132a), 0, Math.max(u.f134c, i4.f134c), Math.max(u.f135d, i4.f135d));
                }
                a.g.d.b k2 = k();
                a0 a0Var = this.f;
                g = a0Var != null ? a0Var.g() : null;
                int i5 = k2.f135d;
                if (g != null) {
                    i5 = Math.min(i5, g.f135d);
                }
                return a.g.d.b.b(k2.f132a, 0, k2.f134c, i5);
            } else if (i2 != 8) {
                if (i2 != 16) {
                    if (i2 != 32) {
                        if (i2 != 64) {
                            if (i2 != 128) {
                                return a.g.d.b.e;
                            }
                            a0 a0Var2 = this.f;
                            a.g.k.c e = a0Var2 != null ? a0Var2.e() : f();
                            return e != null ? a.g.d.b.b(e.b(), e.d(), e.c(), e.a()) : a.g.d.b.e;
                        }
                        return l();
                    }
                    return h();
                }
                return j();
            } else {
                a.g.d.b[] bVarArr = this.f238d;
                g = bVarArr != null ? bVarArr[m.a(8)] : null;
                if (g != null) {
                    return g;
                }
                a.g.d.b k3 = k();
                a.g.d.b u2 = u();
                int i6 = k3.f135d;
                if (i6 > u2.f135d) {
                    return a.g.d.b.b(0, 0, 0, i6);
                }
                a.g.d.b bVar = this.g;
                return (bVar == null || bVar.equals(a.g.d.b.e) || (i3 = this.g.f135d) <= u2.f135d) ? a.g.d.b.e : a.g.d.b.b(0, 0, 0, i3);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class h extends g {
        private a.g.d.b n;

        h(a0 a0Var, h hVar) {
            super(a0Var, hVar);
            this.n = null;
            this.n = hVar.n;
        }

        h(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var, windowInsets);
            this.n = null;
        }

        @Override // a.g.k.a0.l
        a0 b() {
            return a0.s(this.f237c.consumeStableInsets());
        }

        @Override // a.g.k.a0.l
        a0 c() {
            return a0.s(this.f237c.consumeSystemWindowInsets());
        }

        @Override // a.g.k.a0.l
        final a.g.d.b i() {
            if (this.n == null) {
                this.n = a.g.d.b.b(this.f237c.getStableInsetLeft(), this.f237c.getStableInsetTop(), this.f237c.getStableInsetRight(), this.f237c.getStableInsetBottom());
            }
            return this.n;
        }

        @Override // a.g.k.a0.l
        boolean m() {
            return this.f237c.isConsumed();
        }

        @Override // a.g.k.a0.l
        public void r(a.g.d.b bVar) {
            this.n = bVar;
        }
    }

    /* loaded from: classes.dex */
    private static class i extends h {
        i(a0 a0Var, i iVar) {
            super(a0Var, iVar);
        }

        i(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var, windowInsets);
        }

        @Override // a.g.k.a0.l
        a0 a() {
            return a0.s(this.f237c.consumeDisplayCutout());
        }

        @Override // a.g.k.a0.g, a.g.k.a0.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof i) {
                i iVar = (i) obj;
                return Objects.equals(this.f237c, iVar.f237c) && Objects.equals(this.g, iVar.g);
            }
            return false;
        }

        @Override // a.g.k.a0.l
        a.g.k.c f() {
            return a.g.k.c.e(this.f237c.getDisplayCutout());
        }

        @Override // a.g.k.a0.l
        public int hashCode() {
            return this.f237c.hashCode();
        }
    }

    /* loaded from: classes.dex */
    private static class j extends i {
        private a.g.d.b o;
        private a.g.d.b p;
        private a.g.d.b q;

        j(a0 a0Var, j jVar) {
            super(a0Var, jVar);
            this.o = null;
            this.p = null;
            this.q = null;
        }

        j(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var, windowInsets);
            this.o = null;
            this.p = null;
            this.q = null;
        }

        @Override // a.g.k.a0.l
        a.g.d.b h() {
            if (this.p == null) {
                this.p = a.g.d.b.d(this.f237c.getMandatorySystemGestureInsets());
            }
            return this.p;
        }

        @Override // a.g.k.a0.l
        a.g.d.b j() {
            if (this.o == null) {
                this.o = a.g.d.b.d(this.f237c.getSystemGestureInsets());
            }
            return this.o;
        }

        @Override // a.g.k.a0.l
        a.g.d.b l() {
            if (this.q == null) {
                this.q = a.g.d.b.d(this.f237c.getTappableElementInsets());
            }
            return this.q;
        }

        @Override // a.g.k.a0.h, a.g.k.a0.l
        public void r(a.g.d.b bVar) {
        }
    }

    /* loaded from: classes.dex */
    private static class k extends j {
        static final a0 r = a0.s(WindowInsets.CONSUMED);

        k(a0 a0Var, k kVar) {
            super(a0Var, kVar);
        }

        k(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var, windowInsets);
        }

        @Override // a.g.k.a0.g, a.g.k.a0.l
        final void d(View view) {
        }

        @Override // a.g.k.a0.g, a.g.k.a0.l
        public a.g.d.b g(int i) {
            return a.g.d.b.d(this.f237c.getInsets(n.a(i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: b  reason: collision with root package name */
        static final a0 f239b = new b().a().a().b().c();

        /* renamed from: a  reason: collision with root package name */
        final a0 f240a;

        l(a0 a0Var) {
            this.f240a = a0Var;
        }

        a0 a() {
            return this.f240a;
        }

        a0 b() {
            return this.f240a;
        }

        a0 c() {
            return this.f240a;
        }

        void d(View view) {
        }

        void e(a0 a0Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof l) {
                l lVar = (l) obj;
                return n() == lVar.n() && m() == lVar.m() && a.g.j.d.a(k(), lVar.k()) && a.g.j.d.a(i(), lVar.i()) && a.g.j.d.a(f(), lVar.f());
            }
            return false;
        }

        a.g.k.c f() {
            return null;
        }

        a.g.d.b g(int i) {
            return a.g.d.b.e;
        }

        a.g.d.b h() {
            return k();
        }

        public int hashCode() {
            return a.g.j.d.b(Boolean.valueOf(n()), Boolean.valueOf(m()), k(), i(), f());
        }

        a.g.d.b i() {
            return a.g.d.b.e;
        }

        a.g.d.b j() {
            return k();
        }

        a.g.d.b k() {
            return a.g.d.b.e;
        }

        a.g.d.b l() {
            return k();
        }

        boolean m() {
            return false;
        }

        boolean n() {
            return false;
        }

        public void o(a.g.d.b[] bVarArr) {
        }

        void p(a.g.d.b bVar) {
        }

        void q(a0 a0Var) {
        }

        public void r(a.g.d.b bVar) {
        }
    }

    /* loaded from: classes.dex */
    public static final class m {
        static int a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 8) {
                            if (i != 16) {
                                if (i != 32) {
                                    if (i != 64) {
                                        if (i != 128) {
                                            if (i == 256) {
                                                return 8;
                                            }
                                            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
                                        }
                                        return 7;
                                    }
                                    return 6;
                                }
                                return 5;
                            }
                            return 4;
                        }
                        return 3;
                    }
                    return 2;
                }
                return 1;
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    private static final class n {
        static int a(int i) {
            int statusBars;
            int i2 = 0;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i & i3) != 0) {
                    if (i3 == 1) {
                        statusBars = WindowInsets.Type.statusBars();
                    } else if (i3 == 2) {
                        statusBars = WindowInsets.Type.navigationBars();
                    } else if (i3 == 4) {
                        statusBars = WindowInsets.Type.captionBar();
                    } else if (i3 == 8) {
                        statusBars = WindowInsets.Type.ime();
                    } else if (i3 == 16) {
                        statusBars = WindowInsets.Type.systemGestures();
                    } else if (i3 == 32) {
                        statusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i3 == 64) {
                        statusBars = WindowInsets.Type.tappableElement();
                    } else if (i3 == 128) {
                        statusBars = WindowInsets.Type.displayCutout();
                    }
                    i2 |= statusBars;
                }
            }
            return i2;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            a0 a0Var = k.r;
        } else {
            a0 a0Var2 = l.f239b;
        }
    }

    public a0(a0 a0Var) {
        if (a0Var == null) {
            this.f226a = new l(this);
            return;
        }
        l lVar = a0Var.f226a;
        this.f226a = (Build.VERSION.SDK_INT < 30 || !(lVar instanceof k)) ? (Build.VERSION.SDK_INT < 29 || !(lVar instanceof j)) ? (Build.VERSION.SDK_INT < 28 || !(lVar instanceof i)) ? (Build.VERSION.SDK_INT < 21 || !(lVar instanceof h)) ? (Build.VERSION.SDK_INT < 20 || !(lVar instanceof g)) ? new l(this) : new g(this, (g) lVar) : new h(this, (h) lVar) : new i(this, (i) lVar) : new j(this, (j) lVar) : new k(this, (k) lVar);
        lVar.e(this);
    }

    private a0(WindowInsets windowInsets) {
        l gVar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            gVar = new k(this, windowInsets);
        } else if (i2 >= 29) {
            gVar = new j(this, windowInsets);
        } else if (i2 >= 28) {
            gVar = new i(this, windowInsets);
        } else if (i2 >= 21) {
            gVar = new h(this, windowInsets);
        } else if (i2 < 20) {
            this.f226a = new l(this);
            return;
        } else {
            gVar = new g(this, windowInsets);
        }
        this.f226a = gVar;
    }

    public static a0 s(WindowInsets windowInsets) {
        return t(windowInsets, null);
    }

    public static a0 t(WindowInsets windowInsets, View view) {
        a.g.j.i.c(windowInsets);
        a0 a0Var = new a0(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            a0Var.p(s.C(view));
            a0Var.d(view.getRootView());
        }
        return a0Var;
    }

    @Deprecated
    public a0 a() {
        return this.f226a.a();
    }

    @Deprecated
    public a0 b() {
        return this.f226a.b();
    }

    @Deprecated
    public a0 c() {
        return this.f226a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view) {
        this.f226a.d(view);
    }

    public a.g.k.c e() {
        return this.f226a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a0) {
            return a.g.j.d.a(this.f226a, ((a0) obj).f226a);
        }
        return false;
    }

    public a.g.d.b f(int i2) {
        return this.f226a.g(i2);
    }

    @Deprecated
    public a.g.d.b g() {
        return this.f226a.i();
    }

    @Deprecated
    public int h() {
        return this.f226a.k().f135d;
    }

    public int hashCode() {
        l lVar = this.f226a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f226a.k().f132a;
    }

    @Deprecated
    public int j() {
        return this.f226a.k().f134c;
    }

    @Deprecated
    public int k() {
        return this.f226a.k().f133b;
    }

    public boolean l() {
        return this.f226a.m();
    }

    @Deprecated
    public a0 m(int i2, int i3, int i4, int i5) {
        b bVar = new b(this);
        bVar.c(a.g.d.b.b(i2, i3, i4, i5));
        return bVar.a();
    }

    void n(a.g.d.b[] bVarArr) {
        this.f226a.o(bVarArr);
    }

    void o(a.g.d.b bVar) {
        this.f226a.p(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(a0 a0Var) {
        this.f226a.q(a0Var);
    }

    void q(a.g.d.b bVar) {
        this.f226a.r(bVar);
    }

    public WindowInsets r() {
        l lVar = this.f226a;
        if (lVar instanceof g) {
            return ((g) lVar).f237c;
        }
        return null;
    }
}
