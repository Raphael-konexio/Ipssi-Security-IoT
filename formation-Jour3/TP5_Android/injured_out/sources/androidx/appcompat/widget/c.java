package androidx.appcompat.widget;

import a.g.k.b;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends androidx.appcompat.view.menu.b implements b.a {
    private final SparseBooleanArray A;
    e B;
    a C;
    RunnableC0035c D;
    private b E;
    final f F;
    int G;
    d n;
    private Drawable o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.view.menu.l {
        public a(Context context, androidx.appcompat.view.menu.r rVar, View view) {
            super(context, rVar, view, false, a.a.a.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.i) rVar.getItem()).l()) {
                View view2 = c.this.n;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.b) c.this).m : view2);
            }
            j(c.this.F);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            c cVar = c.this;
            cVar.C = null;
            cVar.G = 0;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.p a() {
            a aVar = c.this.C;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.appcompat.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0035c implements Runnable {
        private e f;

        public RunnableC0035c(e eVar) {
            this.f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.b) c.this).h != null) {
                ((androidx.appcompat.view.menu.b) c.this).h.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.b) c.this).m;
            if (view != null && view.getWindowToken() != null && this.f.m()) {
                c.this.B = this.f;
            }
            c.this.D = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends o implements ActionMenuView.a {

        /* loaded from: classes.dex */
        class a extends h0 {
            a(View view, c cVar) {
                super(view);
            }

            @Override // androidx.appcompat.widget.h0
            public androidx.appcompat.view.menu.p b() {
                e eVar = c.this.B;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.h0
            public boolean c() {
                c.this.J();
                return true;
            }

            @Override // androidx.appcompat.widget.h0
            public boolean d() {
                c cVar = c.this;
                if (cVar.D != null) {
                    return false;
                }
                cVar.A();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, a.a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            y0.a(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.J();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends androidx.appcompat.view.menu.l {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z) {
            super(context, gVar, view, z, a.a.a.actionOverflowMenuStyle);
            h(8388613);
            j(c.this.F);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            if (((androidx.appcompat.view.menu.b) c.this).h != null) {
                ((androidx.appcompat.view.menu.b) c.this).h.close();
            }
            c.this.B = null;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class f implements m.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (gVar instanceof androidx.appcompat.view.menu.r) {
                gVar.D().e(false);
            }
            m.a m = c.this.m();
            if (m != null) {
                m.b(gVar, z);
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            if (gVar == null) {
                return false;
            }
            c.this.G = ((androidx.appcompat.view.menu.r) gVar).getItem().getItemId();
            m.a m = c.this.m();
            if (m != null) {
                return m.c(gVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context, a.a.g.abc_action_menu_layout, a.a.g.abc_action_menu_item_layout);
        this.A = new SparseBooleanArray();
        this.F = new f();
    }

    private View y(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.m;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean A() {
        androidx.appcompat.view.menu.n nVar;
        RunnableC0035c runnableC0035c = this.D;
        if (runnableC0035c != null && (nVar = this.m) != null) {
            ((View) nVar).removeCallbacks(runnableC0035c);
            this.D = null;
            return true;
        }
        e eVar = this.B;
        if (eVar != null) {
            eVar.b();
            return true;
        }
        return false;
    }

    public boolean B() {
        a aVar = this.C;
        if (aVar != null) {
            aVar.b();
            return true;
        }
        return false;
    }

    public boolean C() {
        return this.D != null || D();
    }

    public boolean D() {
        e eVar = this.B;
        return eVar != null && eVar.d();
    }

    public void E(Configuration configuration) {
        if (!this.v) {
            this.u = a.a.n.a.b(this.g).d();
        }
        androidx.appcompat.view.menu.g gVar = this.h;
        if (gVar != null) {
            gVar.K(true);
        }
    }

    public void F(boolean z) {
        this.y = z;
    }

    public void G(ActionMenuView actionMenuView) {
        this.m = actionMenuView;
        actionMenuView.b(this.h);
    }

    public void H(Drawable drawable) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.p = true;
        this.o = drawable;
    }

    public void I(boolean z) {
        this.q = z;
        this.r = true;
    }

    public boolean J() {
        androidx.appcompat.view.menu.g gVar;
        if (!this.q || D() || (gVar = this.h) == null || this.m == null || this.D != null || gVar.z().isEmpty()) {
            return false;
        }
        RunnableC0035c runnableC0035c = new RunnableC0035c(new e(this.g, this.h, this.n, true));
        this.D = runnableC0035c;
        ((View) this.m).post(runnableC0035c);
        super.e(null);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
        x();
        super.b(gVar, z);
    }

    @Override // androidx.appcompat.view.menu.b
    public void c(androidx.appcompat.view.menu.i iVar, n.a aVar) {
        aVar.e(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.m);
        if (this.E == null) {
            this.E = new b();
        }
        actionMenuItemView.setPopupCallback(this.E);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void d(Context context, androidx.appcompat.view.menu.g gVar) {
        super.d(context, gVar);
        Resources resources = context.getResources();
        a.a.n.a b2 = a.a.n.a.b(context);
        if (!this.r) {
            this.q = b2.h();
        }
        if (!this.x) {
            this.s = b2.c();
        }
        if (!this.v) {
            this.u = b2.d();
        }
        int i = this.s;
        if (this.q) {
            if (this.n == null) {
                d dVar = new d(this.f);
                this.n = dVar;
                if (this.p) {
                    dVar.setImageDrawable(this.o);
                    this.o = null;
                    this.p = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.n.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.n.getMeasuredWidth();
        } else {
            this.n = null;
        }
        this.t = i;
        this.z = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean e(androidx.appcompat.view.menu.r rVar) {
        boolean z = false;
        if (rVar.hasVisibleItems()) {
            androidx.appcompat.view.menu.r rVar2 = rVar;
            while (rVar2.e0() != this.h) {
                rVar2 = (androidx.appcompat.view.menu.r) rVar2.e0();
            }
            View y = y(rVar2.getItem());
            if (y == null) {
                return false;
            }
            rVar.getItem().getItemId();
            int size = rVar.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MenuItem item = rVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            a aVar = new a(this.g, rVar, y);
            this.C = aVar;
            aVar.g(z);
            this.C.k();
            super.e(rVar);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void f(boolean z) {
        super.f(z);
        ((View) this.m).requestLayout();
        androidx.appcompat.view.menu.g gVar = this.h;
        boolean z2 = false;
        if (gVar != null) {
            ArrayList<androidx.appcompat.view.menu.i> s = gVar.s();
            int size = s.size();
            for (int i = 0; i < size; i++) {
                a.g.k.b b2 = s.get(i).b();
                if (b2 != null) {
                    b2.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.g gVar2 = this.h;
        ArrayList<androidx.appcompat.view.menu.i> z3 = gVar2 != null ? gVar2.z() : null;
        if (this.q && z3 != null) {
            int size2 = z3.size();
            if (size2 == 1) {
                z2 = !z3.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        d dVar = this.n;
        if (z2) {
            if (dVar == null) {
                this.n = new d(this.f);
            }
            ViewGroup viewGroup = (ViewGroup) this.n.getParent();
            if (viewGroup != this.m) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.n);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.m;
                actionMenuView.addView(this.n, actionMenuView.F());
            }
        } else if (dVar != null) {
            ViewParent parent = dVar.getParent();
            androidx.appcompat.view.menu.n nVar = this.m;
            if (parent == nVar) {
                ((ViewGroup) nVar).removeView(this.n);
            }
        }
        ((ActionMenuView) this.m).setOverflowReserved(this.q);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean g() {
        ArrayList<androidx.appcompat.view.menu.i> arrayList;
        int i;
        int i2;
        int i3;
        int i4;
        c cVar = this;
        androidx.appcompat.view.menu.g gVar = cVar.h;
        View view = null;
        int i5 = 0;
        if (gVar != null) {
            arrayList = gVar.E();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = cVar.u;
        int i7 = cVar.t;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.m;
        boolean z = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            androidx.appcompat.view.menu.i iVar = arrayList.get(i10);
            if (iVar.o()) {
                i8++;
            } else if (iVar.n()) {
                i9++;
            } else {
                z = true;
            }
            if (cVar.y && iVar.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (cVar.q && (z || i9 + i8 > i6)) {
            i6--;
        }
        int i11 = i6 - i8;
        SparseBooleanArray sparseBooleanArray = cVar.A;
        sparseBooleanArray.clear();
        if (cVar.w) {
            int i12 = cVar.z;
            i3 = i7 / i12;
            i2 = i12 + ((i7 % i12) / i3);
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < i) {
            androidx.appcompat.view.menu.i iVar2 = arrayList.get(i13);
            if (iVar2.o()) {
                View n = cVar.n(iVar2, view, viewGroup);
                if (cVar.w) {
                    i3 -= ActionMenuView.L(n, i2, i3, makeMeasureSpec, i5);
                } else {
                    n.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = n.getMeasuredWidth();
                i7 -= measuredWidth;
                if (i14 == 0) {
                    i14 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.u(true);
                i4 = i;
            } else if (iVar2.n()) {
                int groupId2 = iVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i11 > 0 || z2) && i7 > 0 && (!cVar.w || i3 > 0);
                boolean z4 = z3;
                i4 = i;
                if (z3) {
                    View n2 = cVar.n(iVar2, null, viewGroup);
                    if (cVar.w) {
                        int L = ActionMenuView.L(n2, i2, i3, makeMeasureSpec, 0);
                        i3 -= L;
                        if (L == 0) {
                            z4 = false;
                        }
                    } else {
                        n2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z5 = z4;
                    int measuredWidth2 = n2.getMeasuredWidth();
                    i7 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z3 = z5 & (!cVar.w ? i7 + i14 <= 0 : i7 < 0);
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i15 = 0; i15 < i13; i15++) {
                        androidx.appcompat.view.menu.i iVar3 = arrayList.get(i15);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.l()) {
                                i11++;
                            }
                            iVar3.u(false);
                        }
                    }
                }
                if (z3) {
                    i11--;
                }
                iVar2.u(z3);
            } else {
                i4 = i;
                iVar2.u(false);
                i13++;
                view = null;
                cVar = this;
                i = i4;
                i5 = 0;
            }
            i13++;
            view = null;
            cVar = this;
            i = i4;
            i5 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean l(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.n) {
            return false;
        }
        return super.l(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.b
    public View n(androidx.appcompat.view.menu.i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.j()) {
            actionView = super.n(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.o(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.n o(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.n nVar = this.m;
        androidx.appcompat.view.menu.n o = super.o(viewGroup);
        if (nVar != o) {
            ((ActionMenuView) o).setPresenter(this);
        }
        return o;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean q(int i, androidx.appcompat.view.menu.i iVar) {
        return iVar.l();
    }

    public boolean x() {
        return A() | B();
    }

    public Drawable z() {
        d dVar = this.n;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.p) {
            return this.o;
        }
        return null;
    }
}
