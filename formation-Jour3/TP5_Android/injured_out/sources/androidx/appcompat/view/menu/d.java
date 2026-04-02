package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.k0;
import androidx.appcompat.widget.l0;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends k implements m, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int G = a.a.g.abc_cascading_menu_item_layout;
    private boolean B;
    private m.a C;
    ViewTreeObserver D;
    private PopupWindow.OnDismissListener E;
    boolean F;
    private final Context g;
    private final int h;
    private final int i;
    private final int j;
    private final boolean k;
    final Handler l;
    private View t;
    View u;
    private boolean w;
    private boolean x;
    private int y;
    private int z;
    private final List<g> m = new ArrayList();
    final List<C0033d> n = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener o = new a();
    private final View.OnAttachStateChangeListener p = new b();
    private final k0 q = new c();
    private int r = 0;
    private int s = 0;
    private boolean A = false;
    private int v = D();

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d.this.c() || d.this.n.size() <= 0 || d.this.n.get(0).f544a.x()) {
                return;
            }
            View view = d.this.u;
            if (view == null || !view.isShown()) {
                d.this.dismiss();
                return;
            }
            for (C0033d c0033d : d.this.n) {
                c0033d.f544a.a();
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
            ViewTreeObserver viewTreeObserver = d.this.D;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.D = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.D.removeGlobalOnLayoutListener(dVar.o);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* loaded from: classes.dex */
    class c implements k0 {

        /* loaded from: classes.dex */
        class a implements Runnable {
            final /* synthetic */ C0033d f;
            final /* synthetic */ MenuItem g;
            final /* synthetic */ g h;

            a(C0033d c0033d, MenuItem menuItem, g gVar) {
                this.f = c0033d;
                this.g = menuItem;
                this.h = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0033d c0033d = this.f;
                if (c0033d != null) {
                    d.this.F = true;
                    c0033d.f545b.e(false);
                    d.this.F = false;
                }
                if (this.g.isEnabled() && this.g.hasSubMenu()) {
                    this.h.L(this.g, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.k0
        public void e(g gVar, MenuItem menuItem) {
            d.this.l.removeCallbacksAndMessages(null);
            int size = d.this.n.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (gVar == d.this.n.get(i).f545b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            d.this.l.postAtTime(new a(i2 < d.this.n.size() ? d.this.n.get(i2) : null, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.k0
        public void f(g gVar, MenuItem menuItem) {
            d.this.l.removeCallbacksAndMessages(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.appcompat.view.menu.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0033d {

        /* renamed from: a  reason: collision with root package name */
        public final l0 f544a;

        /* renamed from: b  reason: collision with root package name */
        public final g f545b;

        /* renamed from: c  reason: collision with root package name */
        public final int f546c;

        public C0033d(l0 l0Var, g gVar, int i) {
            this.f544a = l0Var;
            this.f545b = gVar;
            this.f546c = i;
        }

        public ListView a() {
            return this.f544a.h();
        }
    }

    public d(Context context, View view, int i, int i2, boolean z) {
        this.g = context;
        this.t = view;
        this.i = i;
        this.j = i2;
        this.k = z;
        Resources resources = context.getResources();
        this.h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.a.d.abc_config_prefDialogWidth));
        this.l = new Handler();
    }

    private int A(g gVar) {
        int size = this.n.size();
        for (int i = 0; i < size; i++) {
            if (gVar == this.n.get(i).f545b) {
                return i;
            }
        }
        return -1;
    }

    private MenuItem B(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = gVar.getItem(i);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View C(C0033d c0033d, g gVar) {
        f fVar;
        int i;
        int firstVisiblePosition;
        MenuItem B = B(c0033d.f545b, gVar);
        if (B == null) {
            return null;
        }
        ListView a2 = c0033d.a();
        ListAdapter adapter = a2.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            } else if (B == fVar.getItem(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - a2.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a2.getChildCount()) {
            return a2.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int D() {
        return a.g.k.s.w(this.t) == 1 ? 0 : 1;
    }

    private int E(int i) {
        List<C0033d> list = this.n;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.u.getWindowVisibleDisplayFrame(rect);
        return this.v == 1 ? (iArr[0] + a2.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    private void F(g gVar) {
        C0033d c0033d;
        View view;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.g);
        f fVar = new f(gVar, from, this.k, G);
        if (!c() && this.A) {
            fVar.d(true);
        } else if (c()) {
            fVar.d(k.x(gVar));
        }
        int o = k.o(fVar, null, this.g, this.h);
        l0 z = z();
        z.p(fVar);
        z.B(o);
        z.C(this.s);
        if (this.n.size() > 0) {
            List<C0033d> list = this.n;
            c0033d = list.get(list.size() - 1);
            view = C(c0033d, gVar);
        } else {
            c0033d = null;
            view = null;
        }
        if (view != null) {
            z.Q(false);
            z.N(null);
            int E = E(o);
            boolean z2 = E == 1;
            this.v = E;
            if (Build.VERSION.SDK_INT >= 26) {
                z.z(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.t.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.s & 7) == 5) {
                    iArr[0] = iArr[0] + this.t.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.s & 5) == 5) {
                if (!z2) {
                    o = view.getWidth();
                    i3 = i - o;
                }
                i3 = i + o;
            } else {
                if (z2) {
                    o = view.getWidth();
                    i3 = i + o;
                }
                i3 = i - o;
            }
            z.l(i3);
            z.I(true);
            z.j(i2);
        } else {
            if (this.w) {
                z.l(this.y);
            }
            if (this.x) {
                z.j(this.z);
            }
            z.D(n());
        }
        this.n.add(new C0033d(z, gVar, this.v));
        z.a();
        ListView h = z.h();
        h.setOnKeyListener(this);
        if (c0033d == null && this.B && gVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(a.a.g.abc_popup_menu_header_item_layout, (ViewGroup) h, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(gVar.x());
            h.addHeaderView(frameLayout, null, false);
            z.a();
        }
    }

    private l0 z() {
        l0 l0Var = new l0(this.g, null, this.i, this.j);
        l0Var.P(this.q);
        l0Var.H(this);
        l0Var.G(this);
        l0Var.z(this.t);
        l0Var.C(this.s);
        l0Var.F(true);
        l0Var.E(2);
        return l0Var;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a() {
        if (c()) {
            return;
        }
        for (g gVar : this.m) {
            F(gVar);
        }
        this.m.clear();
        View view = this.t;
        this.u = view;
        if (view != null) {
            boolean z = this.D == null;
            ViewTreeObserver viewTreeObserver = this.u.getViewTreeObserver();
            this.D = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.o);
            }
            this.u.addOnAttachStateChangeListener(this.p);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        int A = A(gVar);
        if (A < 0) {
            return;
        }
        int i = A + 1;
        if (i < this.n.size()) {
            this.n.get(i).f545b.e(false);
        }
        C0033d remove = this.n.remove(A);
        remove.f545b.O(this);
        if (this.F) {
            remove.f544a.O(null);
            remove.f544a.A(0);
        }
        remove.f544a.dismiss();
        int size = this.n.size();
        this.v = size > 0 ? this.n.get(size - 1).f546c : D();
        if (size != 0) {
            if (z) {
                this.n.get(0).f545b.e(false);
                return;
            }
            return;
        }
        dismiss();
        m.a aVar = this.C;
        if (aVar != null) {
            aVar.b(gVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.D;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.D.removeGlobalOnLayoutListener(this.o);
            }
            this.D = null;
        }
        this.u.removeOnAttachStateChangeListener(this.p);
        this.E.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean c() {
        return this.n.size() > 0 && this.n.get(0).f544a.c();
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        int size = this.n.size();
        if (size > 0) {
            C0033d[] c0033dArr = (C0033d[]) this.n.toArray(new C0033d[size]);
            for (int i = size - 1; i >= 0; i--) {
                C0033d c0033d = c0033dArr[i];
                if (c0033d.f544a.c()) {
                    c0033d.f544a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e(r rVar) {
        for (C0033d c0033d : this.n) {
            if (rVar == c0033d.f545b) {
                c0033d.a().requestFocus();
                return true;
            }
        }
        if (rVar.hasVisibleItems()) {
            l(rVar);
            m.a aVar = this.C;
            if (aVar != null) {
                aVar.c(rVar);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void f(boolean z) {
        for (C0033d c0033d : this.n) {
            k.y(c0033d.a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean g() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView h() {
        if (this.n.isEmpty()) {
            return null;
        }
        List<C0033d> list = this.n;
        return list.get(list.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.m
    public void k(m.a aVar) {
        this.C = aVar;
    }

    @Override // androidx.appcompat.view.menu.k
    public void l(g gVar) {
        gVar.c(this, this.g);
        if (c()) {
            F(gVar);
        } else {
            this.m.add(gVar);
        }
    }

    @Override // androidx.appcompat.view.menu.k
    protected boolean m() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C0033d c0033d;
        int size = this.n.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                c0033d = null;
                break;
            }
            c0033d = this.n.get(i);
            if (!c0033d.f544a.c()) {
                break;
            }
            i++;
        }
        if (c0033d != null) {
            c0033d.f545b.e(false);
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
        if (this.t != view) {
            this.t = view;
            this.s = a.g.k.d.b(this.r, a.g.k.s.w(view));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void r(boolean z) {
        this.A = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void s(int i) {
        if (this.r != i) {
            this.r = i;
            this.s = a.g.k.d.b(i, a.g.k.s.w(this.t));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void t(int i) {
        this.w = true;
        this.y = i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.E = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(boolean z) {
        this.B = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(int i) {
        this.x = true;
        this.z = i;
    }
}
