package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
/* loaded from: classes.dex */
public class x0 implements d0 {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f661a;

    /* renamed from: b  reason: collision with root package name */
    private int f662b;

    /* renamed from: c  reason: collision with root package name */
    private View f663c;

    /* renamed from: d  reason: collision with root package name */
    private View f664d;
    private Drawable e;
    private Drawable f;
    private Drawable g;
    private boolean h;
    CharSequence i;
    private CharSequence j;
    private CharSequence k;
    Window.Callback l;
    boolean m;
    private c n;
    private int o;
    private int p;
    private Drawable q;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        final androidx.appcompat.view.menu.a f;

        a() {
            this.f = new androidx.appcompat.view.menu.a(x0.this.f661a.getContext(), 0, 16908332, 0, 0, x0.this.i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            x0 x0Var = x0.this;
            Window.Callback callback = x0Var.l;
            if (callback == null || !x0Var.m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f);
        }
    }

    /* loaded from: classes.dex */
    class b extends a.g.k.y {

        /* renamed from: a  reason: collision with root package name */
        private boolean f665a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f666b;

        b(int i) {
            this.f666b = i;
        }

        @Override // a.g.k.y, a.g.k.x
        public void a(View view) {
            this.f665a = true;
        }

        @Override // a.g.k.x
        public void b(View view) {
            if (this.f665a) {
                return;
            }
            x0.this.f661a.setVisibility(this.f666b);
        }

        @Override // a.g.k.y, a.g.k.x
        public void c(View view) {
            x0.this.f661a.setVisibility(0);
        }
    }

    public x0(Toolbar toolbar, boolean z) {
        this(toolbar, z, a.a.h.abc_action_bar_up_description, a.a.e.abc_ic_ab_back_material);
    }

    public x0(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f661a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        w0 u = w0.u(toolbar.getContext(), null, a.a.j.ActionBar, a.a.a.actionBarStyle, 0);
        this.q = u.g(a.a.j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence p = u.p(a.a.j.ActionBar_title);
            if (!TextUtils.isEmpty(p)) {
                G(p);
            }
            CharSequence p2 = u.p(a.a.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(p2)) {
                F(p2);
            }
            Drawable g = u.g(a.a.j.ActionBar_logo);
            if (g != null) {
                B(g);
            }
            Drawable g2 = u.g(a.a.j.ActionBar_icon);
            if (g2 != null) {
                setIcon(g2);
            }
            if (this.g == null && (drawable = this.q) != null) {
                E(drawable);
            }
            p(u.k(a.a.j.ActionBar_displayOptions, 0));
            int n = u.n(a.a.j.ActionBar_customNavigationLayout, 0);
            if (n != 0) {
                z(LayoutInflater.from(this.f661a.getContext()).inflate(n, (ViewGroup) this.f661a, false));
                p(this.f662b | 16);
            }
            int m = u.m(a.a.j.ActionBar_height, 0);
            if (m > 0) {
                ViewGroup.LayoutParams layoutParams = this.f661a.getLayoutParams();
                layoutParams.height = m;
                this.f661a.setLayoutParams(layoutParams);
            }
            int e = u.e(a.a.j.ActionBar_contentInsetStart, -1);
            int e2 = u.e(a.a.j.ActionBar_contentInsetEnd, -1);
            if (e >= 0 || e2 >= 0) {
                this.f661a.H(Math.max(e, 0), Math.max(e2, 0));
            }
            int n2 = u.n(a.a.j.ActionBar_titleTextStyle, 0);
            if (n2 != 0) {
                Toolbar toolbar2 = this.f661a;
                toolbar2.L(toolbar2.getContext(), n2);
            }
            int n3 = u.n(a.a.j.ActionBar_subtitleTextStyle, 0);
            if (n3 != 0) {
                Toolbar toolbar3 = this.f661a;
                toolbar3.K(toolbar3.getContext(), n3);
            }
            int n4 = u.n(a.a.j.ActionBar_popupTheme, 0);
            if (n4 != 0) {
                this.f661a.setPopupTheme(n4);
            }
        } else {
            this.f662b = y();
        }
        u.v();
        A(i);
        this.k = this.f661a.getNavigationContentDescription();
        this.f661a.setNavigationOnClickListener(new a());
    }

    private void H(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.f662b & 8) != 0) {
            this.f661a.setTitle(charSequence);
        }
    }

    private void I() {
        if ((this.f662b & 4) != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.f661a.setNavigationContentDescription(this.p);
            } else {
                this.f661a.setNavigationContentDescription(this.k);
            }
        }
    }

    private void J() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.f662b & 4) != 0) {
            toolbar = this.f661a;
            drawable = this.g;
            if (drawable == null) {
                drawable = this.q;
            }
        } else {
            toolbar = this.f661a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void K() {
        Drawable drawable;
        int i = this.f662b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f) == null) {
            drawable = this.e;
        }
        this.f661a.setLogo(drawable);
    }

    private int y() {
        if (this.f661a.getNavigationIcon() != null) {
            this.q = this.f661a.getNavigationIcon();
            return 15;
        }
        return 11;
    }

    public void A(int i) {
        if (i == this.p) {
            return;
        }
        this.p = i;
        if (TextUtils.isEmpty(this.f661a.getNavigationContentDescription())) {
            C(this.p);
        }
    }

    public void B(Drawable drawable) {
        this.f = drawable;
        K();
    }

    public void C(int i) {
        D(i == 0 ? null : c().getString(i));
    }

    public void D(CharSequence charSequence) {
        this.k = charSequence;
        I();
    }

    public void E(Drawable drawable) {
        this.g = drawable;
        J();
    }

    public void F(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.f662b & 8) != 0) {
            this.f661a.setSubtitle(charSequence);
        }
    }

    public void G(CharSequence charSequence) {
        this.h = true;
        H(charSequence);
    }

    @Override // androidx.appcompat.widget.d0
    public void a(Menu menu, m.a aVar) {
        if (this.n == null) {
            c cVar = new c(this.f661a.getContext());
            this.n = cVar;
            cVar.p(a.a.f.action_menu_presenter);
        }
        this.n.k(aVar);
        this.f661a.I((androidx.appcompat.view.menu.g) menu, this.n);
    }

    @Override // androidx.appcompat.widget.d0
    public boolean b() {
        return this.f661a.A();
    }

    @Override // androidx.appcompat.widget.d0
    public Context c() {
        return this.f661a.getContext();
    }

    @Override // androidx.appcompat.widget.d0
    public void collapseActionView() {
        this.f661a.e();
    }

    @Override // androidx.appcompat.widget.d0
    public void d() {
        this.m = true;
    }

    @Override // androidx.appcompat.widget.d0
    public boolean e() {
        return this.f661a.z();
    }

    @Override // androidx.appcompat.widget.d0
    public boolean f() {
        return this.f661a.w();
    }

    @Override // androidx.appcompat.widget.d0
    public boolean g() {
        return this.f661a.O();
    }

    @Override // androidx.appcompat.widget.d0
    public CharSequence getTitle() {
        return this.f661a.getTitle();
    }

    @Override // androidx.appcompat.widget.d0
    public boolean h() {
        return this.f661a.d();
    }

    @Override // androidx.appcompat.widget.d0
    public void i() {
        this.f661a.f();
    }

    @Override // androidx.appcompat.widget.d0
    public void j(m.a aVar, g.a aVar2) {
        this.f661a.J(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.d0
    public void k(int i) {
        this.f661a.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.d0
    public void l(p0 p0Var) {
        View view = this.f663c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f661a;
            if (parent == toolbar) {
                toolbar.removeView(this.f663c);
            }
        }
        this.f663c = p0Var;
        if (p0Var == null || this.o != 2) {
            return;
        }
        this.f661a.addView(p0Var, 0);
        Toolbar.e eVar = (Toolbar.e) this.f663c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) eVar).width = -2;
        ((ViewGroup.MarginLayoutParams) eVar).height = -2;
        eVar.f486a = 8388691;
        p0Var.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.d0
    public ViewGroup m() {
        return this.f661a;
    }

    @Override // androidx.appcompat.widget.d0
    public void n(boolean z) {
    }

    @Override // androidx.appcompat.widget.d0
    public boolean o() {
        return this.f661a.v();
    }

    @Override // androidx.appcompat.widget.d0
    public void p(int i) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i2 = this.f662b ^ i;
        this.f662b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    I();
                }
                J();
            }
            if ((i2 & 3) != 0) {
                K();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f661a.setTitle(this.i);
                    toolbar = this.f661a;
                    charSequence = this.j;
                } else {
                    charSequence = null;
                    this.f661a.setTitle((CharSequence) null);
                    toolbar = this.f661a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i2 & 16) == 0 || (view = this.f664d) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f661a.addView(view);
            } else {
                this.f661a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.d0
    public int q() {
        return this.f662b;
    }

    @Override // androidx.appcompat.widget.d0
    public Menu r() {
        return this.f661a.getMenu();
    }

    @Override // androidx.appcompat.widget.d0
    public void s(int i) {
        B(i != 0 ? a.a.k.a.a.d(c(), i) : null);
    }

    @Override // androidx.appcompat.widget.d0
    public void setIcon(int i) {
        setIcon(i != 0 ? a.a.k.a.a.d(c(), i) : null);
    }

    @Override // androidx.appcompat.widget.d0
    public void setIcon(Drawable drawable) {
        this.e = drawable;
        K();
    }

    @Override // androidx.appcompat.widget.d0
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override // androidx.appcompat.widget.d0
    public void setWindowTitle(CharSequence charSequence) {
        if (this.h) {
            return;
        }
        H(charSequence);
    }

    @Override // androidx.appcompat.widget.d0
    public int t() {
        return this.o;
    }

    @Override // androidx.appcompat.widget.d0
    public a.g.k.w u(int i, long j) {
        a.g.k.w c2 = a.g.k.s.c(this.f661a);
        c2.a(i == 0 ? 1.0f : 0.0f);
        c2.d(j);
        c2.f(new b(i));
        return c2;
    }

    @Override // androidx.appcompat.widget.d0
    public void v() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.d0
    public void w() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.d0
    public void x(boolean z) {
        this.f661a.setCollapsible(z);
    }

    public void z(View view) {
        View view2 = this.f664d;
        if (view2 != null && (this.f662b & 16) != 0) {
            this.f661a.removeView(view2);
        }
        this.f664d = view;
        if (view == null || (this.f662b & 16) == 0) {
            return;
        }
        this.f661a.addView(view);
    }
}
