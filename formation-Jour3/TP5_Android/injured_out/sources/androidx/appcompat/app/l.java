package androidx.appcompat.app;

import a.a.n.b;
import a.g.k.s;
import a.g.k.w;
import a.g.k.x;
import a.g.k.y;
import a.g.k.z;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.p0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {
    private static final Interpolator B = new AccelerateInterpolator();
    private static final Interpolator C = new DecelerateInterpolator();
    final z A;

    /* renamed from: a  reason: collision with root package name */
    Context f530a;

    /* renamed from: b  reason: collision with root package name */
    private Context f531b;

    /* renamed from: c  reason: collision with root package name */
    ActionBarOverlayLayout f532c;

    /* renamed from: d  reason: collision with root package name */
    ActionBarContainer f533d;
    d0 e;
    ActionBarContextView f;
    View g;
    p0 h;
    private boolean i;
    d j;
    a.a.n.b k;
    b.a l;
    private boolean m;
    private ArrayList<a.b> n;
    private boolean o;
    private int p;
    boolean q;
    boolean r;
    boolean s;
    private boolean t;
    private boolean u;
    a.a.n.h v;
    private boolean w;
    boolean x;
    final x y;
    final x z;

    /* loaded from: classes.dex */
    class a extends y {
        a() {
        }

        @Override // a.g.k.x
        public void b(View view) {
            View view2;
            l lVar = l.this;
            if (lVar.q && (view2 = lVar.g) != null) {
                view2.setTranslationY(0.0f);
                l.this.f533d.setTranslationY(0.0f);
            }
            l.this.f533d.setVisibility(8);
            l.this.f533d.setTransitioning(false);
            l lVar2 = l.this;
            lVar2.v = null;
            lVar2.x();
            ActionBarOverlayLayout actionBarOverlayLayout = l.this.f532c;
            if (actionBarOverlayLayout != null) {
                s.d0(actionBarOverlayLayout);
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends y {
        b() {
        }

        @Override // a.g.k.x
        public void b(View view) {
            l lVar = l.this;
            lVar.v = null;
            lVar.f533d.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    class c implements z {
        c() {
        }

        @Override // a.g.k.z
        public void a(View view) {
            ((View) l.this.f533d.getParent()).invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class d extends a.a.n.b implements g.a {
        private final Context h;
        private final androidx.appcompat.view.menu.g i;
        private b.a j;
        private WeakReference<View> k;

        public d(Context context, b.a aVar) {
            this.h = context;
            this.j = aVar;
            androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
            gVar.S(1);
            this.i = gVar;
            gVar.R(this);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            b.a aVar = this.j;
            if (aVar != null) {
                return aVar.c(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            if (this.j == null) {
                return;
            }
            k();
            l.this.f.l();
        }

        @Override // a.a.n.b
        public void c() {
            l lVar = l.this;
            if (lVar.j != this) {
                return;
            }
            if (l.w(lVar.r, lVar.s, false)) {
                this.j.b(this);
            } else {
                l lVar2 = l.this;
                lVar2.k = this;
                lVar2.l = this.j;
            }
            this.j = null;
            l.this.v(false);
            l.this.f.g();
            l.this.e.m().sendAccessibilityEvent(32);
            l lVar3 = l.this;
            lVar3.f532c.setHideOnContentScrollEnabled(lVar3.x);
            l.this.j = null;
        }

        @Override // a.a.n.b
        public View d() {
            WeakReference<View> weakReference = this.k;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // a.a.n.b
        public Menu e() {
            return this.i;
        }

        @Override // a.a.n.b
        public MenuInflater f() {
            return new a.a.n.g(this.h);
        }

        @Override // a.a.n.b
        public CharSequence g() {
            return l.this.f.getSubtitle();
        }

        @Override // a.a.n.b
        public CharSequence i() {
            return l.this.f.getTitle();
        }

        @Override // a.a.n.b
        public void k() {
            if (l.this.j != this) {
                return;
            }
            this.i.d0();
            try {
                this.j.a(this, this.i);
            } finally {
                this.i.c0();
            }
        }

        @Override // a.a.n.b
        public boolean l() {
            return l.this.f.j();
        }

        @Override // a.a.n.b
        public void m(View view) {
            l.this.f.setCustomView(view);
            this.k = new WeakReference<>(view);
        }

        @Override // a.a.n.b
        public void n(int i) {
            o(l.this.f530a.getResources().getString(i));
        }

        @Override // a.a.n.b
        public void o(CharSequence charSequence) {
            l.this.f.setSubtitle(charSequence);
        }

        @Override // a.a.n.b
        public void q(int i) {
            r(l.this.f530a.getResources().getString(i));
        }

        @Override // a.a.n.b
        public void r(CharSequence charSequence) {
            l.this.f.setTitle(charSequence);
        }

        @Override // a.a.n.b
        public void s(boolean z) {
            super.s(z);
            l.this.f.setTitleOptional(z);
        }

        public boolean t() {
            this.i.d0();
            try {
                return this.j.d(this, this.i);
            } finally {
                this.i.c0();
            }
        }
    }

    public l(Activity activity, boolean z) {
        new ArrayList();
        this.n = new ArrayList<>();
        this.p = 0;
        this.q = true;
        this.u = true;
        this.y = new a();
        this.z = new b();
        this.A = new c();
        View decorView = activity.getWindow().getDecorView();
        D(decorView);
        if (z) {
            return;
        }
        this.g = decorView.findViewById(16908290);
    }

    public l(Dialog dialog) {
        new ArrayList();
        this.n = new ArrayList<>();
        this.p = 0;
        this.q = true;
        this.u = true;
        this.y = new a();
        this.z = new b();
        this.A = new c();
        D(dialog.getWindow().getDecorView());
    }

    private d0 A(View view) {
        if (view instanceof d0) {
            return (d0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void C() {
        if (this.t) {
            this.t = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f532c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            M(false);
        }
    }

    private void D(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(a.a.f.decor_content_parent);
        this.f532c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.e = A(view.findViewById(a.a.f.action_bar));
        this.f = (ActionBarContextView) view.findViewById(a.a.f.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(a.a.f.action_bar_container);
        this.f533d = actionBarContainer;
        d0 d0Var = this.e;
        if (d0Var == null || this.f == null || actionBarContainer == null) {
            throw new IllegalStateException(l.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f530a = d0Var.c();
        boolean z = (this.e.q() & 4) != 0;
        if (z) {
            this.i = true;
        }
        a.a.n.a b2 = a.a.n.a.b(this.f530a);
        J(b2.a() || z);
        H(b2.g());
        TypedArray obtainStyledAttributes = this.f530a.obtainStyledAttributes(null, a.a.j.ActionBar, a.a.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(a.a.j.ActionBar_hideOnContentScroll, false)) {
            I(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a.a.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            G(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void H(boolean z) {
        this.o = z;
        if (z) {
            this.f533d.setTabContainer(null);
            this.e.l(this.h);
        } else {
            this.e.l(null);
            this.f533d.setTabContainer(this.h);
        }
        boolean z2 = true;
        boolean z3 = B() == 2;
        p0 p0Var = this.h;
        if (p0Var != null) {
            if (z3) {
                p0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f532c;
                if (actionBarOverlayLayout != null) {
                    s.d0(actionBarOverlayLayout);
                }
            } else {
                p0Var.setVisibility(8);
            }
        }
        this.e.x(!this.o && z3);
        this.f532c.setHasNonEmbeddedTabs((this.o || !z3) ? false : false);
    }

    private boolean K() {
        return s.M(this.f533d);
    }

    private void L() {
        if (this.t) {
            return;
        }
        this.t = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f532c;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        M(false);
    }

    private void M(boolean z) {
        if (w(this.r, this.s, this.t)) {
            if (this.u) {
                return;
            }
            this.u = true;
            z(z);
        } else if (this.u) {
            this.u = false;
            y(z);
        }
    }

    static boolean w(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    public int B() {
        return this.e.t();
    }

    public void E(boolean z) {
        F(z ? 4 : 0, 4);
    }

    public void F(int i, int i2) {
        int q = this.e.q();
        if ((i2 & 4) != 0) {
            this.i = true;
        }
        this.e.p((i & i2) | ((~i2) & q));
    }

    public void G(float f) {
        s.m0(this.f533d, f);
    }

    public void I(boolean z) {
        if (z && !this.f532c.w()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.x = z;
        this.f532c.setHideOnContentScrollEnabled(z);
    }

    public void J(boolean z) {
        this.e.n(z);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.s) {
            this.s = false;
            M(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
        a.a.n.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
            this.v = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(int i) {
        this.p = i;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e(boolean z) {
        this.q = z;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
        if (this.s) {
            return;
        }
        this.s = true;
        M(true);
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        d0 d0Var = this.e;
        if (d0Var == null || !d0Var.o()) {
            return false;
        }
        this.e.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z) {
        if (z == this.m) {
            return;
        }
        this.m = z;
        int size = this.n.size();
        for (int i = 0; i < size; i++) {
            this.n.get(i).a(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.e.q();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        if (this.f531b == null) {
            TypedValue typedValue = new TypedValue();
            this.f530a.getTheme().resolveAttribute(a.a.a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f531b = new ContextThemeWrapper(this.f530a, i);
            } else {
                this.f531b = this.f530a;
            }
        }
        return this.f531b;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        H(a.a.n.a.b(this.f530a).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i, KeyEvent keyEvent) {
        Menu e;
        d dVar = this.j;
        if (dVar == null || (e = dVar.e()) == null) {
            return false;
        }
        e.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return e.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
        if (this.i) {
            return;
        }
        E(z);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
        a.a.n.h hVar;
        this.w = z;
        if (z || (hVar = this.v) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.a
    public void t(CharSequence charSequence) {
        this.e.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public a.a.n.b u(b.a aVar) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.c();
        }
        this.f532c.setHideOnContentScrollEnabled(false);
        this.f.k();
        d dVar2 = new d(this.f.getContext(), aVar);
        if (dVar2.t()) {
            this.j = dVar2;
            dVar2.k();
            this.f.h(dVar2);
            v(true);
            this.f.sendAccessibilityEvent(32);
            return dVar2;
        }
        return null;
    }

    public void v(boolean z) {
        w u;
        w f;
        if (z) {
            L();
        } else {
            C();
        }
        if (!K()) {
            if (z) {
                this.e.k(4);
                this.f.setVisibility(0);
                return;
            }
            this.e.k(0);
            this.f.setVisibility(8);
            return;
        }
        if (z) {
            f = this.e.u(4, 100L);
            u = this.f.f(0, 200L);
        } else {
            u = this.e.u(0, 200L);
            f = this.f.f(8, 100L);
        }
        a.a.n.h hVar = new a.a.n.h();
        hVar.d(f, u);
        hVar.h();
    }

    void x() {
        b.a aVar = this.l;
        if (aVar != null) {
            aVar.b(this.k);
            this.k = null;
            this.l = null;
        }
    }

    public void y(boolean z) {
        View view;
        int[] iArr;
        a.a.n.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        if (this.p != 0 || (!this.w && !z)) {
            this.y.b(null);
            return;
        }
        this.f533d.setAlpha(1.0f);
        this.f533d.setTransitioning(true);
        a.a.n.h hVar2 = new a.a.n.h();
        float f = -this.f533d.getHeight();
        if (z) {
            this.f533d.getLocationInWindow(new int[]{0, 0});
            f -= iArr[1];
        }
        w c2 = s.c(this.f533d);
        c2.k(f);
        c2.i(this.A);
        hVar2.c(c2);
        if (this.q && (view = this.g) != null) {
            w c3 = s.c(view);
            c3.k(f);
            hVar2.c(c3);
        }
        hVar2.f(B);
        hVar2.e(250L);
        hVar2.g(this.y);
        this.v = hVar2;
        hVar2.h();
    }

    public void z(boolean z) {
        View view;
        View view2;
        int[] iArr;
        a.a.n.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        this.f533d.setVisibility(0);
        if (this.p == 0 && (this.w || z)) {
            this.f533d.setTranslationY(0.0f);
            float f = -this.f533d.getHeight();
            if (z) {
                this.f533d.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            this.f533d.setTranslationY(f);
            a.a.n.h hVar2 = new a.a.n.h();
            w c2 = s.c(this.f533d);
            c2.k(0.0f);
            c2.i(this.A);
            hVar2.c(c2);
            if (this.q && (view2 = this.g) != null) {
                view2.setTranslationY(f);
                w c3 = s.c(this.g);
                c3.k(0.0f);
                hVar2.c(c3);
            }
            hVar2.f(C);
            hVar2.e(250L);
            hVar2.g(this.z);
            this.v = hVar2;
            hVar2.h();
        } else {
            this.f533d.setAlpha(1.0f);
            this.f533d.setTranslationY(0.0f);
            if (this.q && (view = this.g) != null) {
                view.setTranslationY(0.0f);
            }
            this.z.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f532c;
        if (actionBarOverlayLayout != null) {
            s.d0(actionBarOverlayLayout);
        }
    }
}
