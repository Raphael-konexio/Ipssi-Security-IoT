package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.l0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q extends k implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, m, View.OnKeyListener {
    private static final int A = a.a.g.abc_popup_menu_item_layout;
    private final Context g;
    private final g h;
    private final f i;
    private final boolean j;
    private final int k;
    private final int l;
    private final int m;
    final l0 n;
    private PopupWindow.OnDismissListener q;
    private View r;
    View s;
    private m.a t;
    ViewTreeObserver u;
    private boolean v;
    private boolean w;
    private int x;
    private boolean z;
    final ViewTreeObserver.OnGlobalLayoutListener o = new a();
    private final View.OnAttachStateChangeListener p = new b();
    private int y = 0;

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!q.this.c() || q.this.n.x()) {
                return;
            }
            View view = q.this.s;
            if (view == null || !view.isShown()) {
                q.this.dismiss();
            } else {
                q.this.n.a();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = q.this.u;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.u = view.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.u.removeGlobalOnLayoutListener(qVar.o);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i, int i2, boolean z) {
        this.g = context;
        this.h = gVar;
        this.j = z;
        this.i = new f(gVar, LayoutInflater.from(context), this.j, A);
        this.l = i;
        this.m = i2;
        Resources resources = context.getResources();
        this.k = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.a.d.abc_config_prefDialogWidth));
        this.r = view;
        this.n = new l0(this.g, null, this.l, this.m);
        gVar.c(this, context);
    }

    private boolean z() {
        View view;
        if (c()) {
            return true;
        }
        if (this.v || (view = this.r) == null) {
            return false;
        }
        this.s = view;
        this.n.G(this);
        this.n.H(this);
        this.n.F(true);
        View view2 = this.s;
        boolean z = this.u == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.u = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.o);
        }
        view2.addOnAttachStateChangeListener(this.p);
        this.n.z(view2);
        this.n.C(this.y);
        if (!this.w) {
            this.x = k.o(this.i, null, this.g, this.k);
            this.w = true;
        }
        this.n.B(this.x);
        this.n.E(2);
        this.n.D(n());
        this.n.a();
        ListView h = this.n.h();
        h.setOnKeyListener(this);
        if (this.z && this.h.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.g).inflate(a.a.g.abc_popup_menu_header_item_layout, (ViewGroup) h, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.h.x());
            }
            frameLayout.setEnabled(false);
            h.addHeaderView(frameLayout, null, false);
        }
        this.n.p(this.i);
        this.n.a();
        return true;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        if (gVar != this.h) {
            return;
        }
        dismiss();
        m.a aVar = this.t;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean c() {
        return !this.v && this.n.c();
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        if (c()) {
            this.n.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e(r rVar) {
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.g, rVar, this.s, this.j, this.l, this.m);
            lVar.j(this.t);
            lVar.g(k.x(rVar));
            lVar.i(this.q);
            this.q = null;
            this.h.e(false);
            int d2 = this.n.d();
            int n = this.n.n();
            if ((Gravity.getAbsoluteGravity(this.y, a.g.k.s.w(this.r)) & 7) == 5) {
                d2 += this.r.getWidth();
            }
            if (lVar.n(d2, n)) {
                m.a aVar = this.t;
                if (aVar != null) {
                    aVar.c(rVar);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void f(boolean z) {
        this.w = false;
        f fVar = this.i;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean g() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView h() {
        return this.n.h();
    }

    @Override // androidx.appcompat.view.menu.m
    public void k(m.a aVar) {
        this.t = aVar;
    }

    @Override // androidx.appcompat.view.menu.k
    public void l(g gVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.v = true;
        this.h.close();
        ViewTreeObserver viewTreeObserver = this.u;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.u = this.s.getViewTreeObserver();
            }
            this.u.removeGlobalOnLayoutListener(this.o);
            this.u = null;
        }
        this.s.removeOnAttachStateChangeListener(this.p);
        PopupWindow.OnDismissListener onDismissListener = this.q;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    public void p(View view) {
        this.r = view;
    }

    @Override // androidx.appcompat.view.menu.k
    public void r(boolean z) {
        this.i.d(z);
    }

    @Override // androidx.appcompat.view.menu.k
    public void s(int i) {
        this.y = i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void t(int i) {
        this.n.l(i);
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.q = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(boolean z) {
        this.z = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(int i) {
        this.n.j(i);
    }
}
