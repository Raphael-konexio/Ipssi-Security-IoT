package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class h<S> extends p<S> {
    static final Object m0 = "MONTHS_VIEW_GROUP_TAG";
    static final Object n0 = "NAVIGATION_PREV_TAG";
    static final Object o0 = "NAVIGATION_NEXT_TAG";
    static final Object p0 = "SELECTOR_TOGGLE_TAG";
    private int c0;
    private com.google.android.material.datepicker.d<S> d0;
    private com.google.android.material.datepicker.a e0;
    private com.google.android.material.datepicker.l f0;
    private k g0;
    private com.google.android.material.datepicker.c h0;
    private RecyclerView i0;
    private RecyclerView j0;
    private View k0;
    private View l0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ int f;

        a(int i) {
            this.f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.j0.smoothScrollToPosition(this.f);
        }
    }

    /* loaded from: classes.dex */
    class b extends a.g.k.a {
        b(h hVar) {
        }

        @Override // a.g.k.a
        public void g(View view, a.g.k.b0.c cVar) {
            super.g(view, cVar);
            cVar.Y(null);
        }
    }

    /* loaded from: classes.dex */
    class c extends q {
        final /* synthetic */ int I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.I = i2;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void M1(RecyclerView.a0 a0Var, int[] iArr) {
            if (this.I == 0) {
                iArr[0] = h.this.j0.getWidth();
                iArr[1] = h.this.j0.getWidth();
                return;
            }
            iArr[0] = h.this.j0.getHeight();
            iArr[1] = h.this.j0.getHeight();
        }
    }

    /* loaded from: classes.dex */
    class d implements l {
        d() {
        }

        @Override // com.google.android.material.datepicker.h.l
        public void a(long j) {
            if (h.this.e0.j().g(j)) {
                h.this.d0.s(j);
                Iterator<o<S>> it = h.this.b0.iterator();
                while (it.hasNext()) {
                    it.next().a((S) h.this.d0.m());
                }
                h.this.j0.getAdapter().h();
                if (h.this.i0 != null) {
                    h.this.i0.getAdapter().h();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends RecyclerView.n {

        /* renamed from: a  reason: collision with root package name */
        private final Calendar f1727a = r.k();

        /* renamed from: b  reason: collision with root package name */
        private final Calendar f1728b = r.k();

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            if ((recyclerView.getAdapter() instanceof s) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                s sVar = (s) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (a.g.j.e<Long, Long> eVar : h.this.d0.f()) {
                    Long l = eVar.f217a;
                    if (l != null && eVar.f218b != null) {
                        this.f1727a.setTimeInMillis(l.longValue());
                        this.f1728b.setTimeInMillis(eVar.f218b.longValue());
                        int w = sVar.w(this.f1727a.get(1));
                        int w2 = sVar.w(this.f1728b.get(1));
                        View C = gridLayoutManager.C(w);
                        View C2 = gridLayoutManager.C(w2);
                        int X2 = w / gridLayoutManager.X2();
                        int X22 = w2 / gridLayoutManager.X2();
                        int i = X2;
                        while (i <= X22) {
                            View C3 = gridLayoutManager.C(gridLayoutManager.X2() * i);
                            if (C3 != null) {
                                canvas.drawRect(i == X2 ? C.getLeft() + (C.getWidth() / 2) : 0, C3.getTop() + h.this.h0.f1725d.c(), i == X22 ? C2.getLeft() + (C2.getWidth() / 2) : recyclerView.getWidth(), C3.getBottom() - h.this.h0.f1725d.b(), h.this.h0.h);
                            }
                            i++;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends a.g.k.a {
        f() {
        }

        @Override // a.g.k.a
        public void g(View view, a.g.k.b0.c cVar) {
            h hVar;
            int i;
            super.g(view, cVar);
            if (h.this.l0.getVisibility() == 0) {
                hVar = h.this;
                i = b.c.a.b.i.mtrl_picker_toggle_to_year_selection;
            } else {
                hVar = h.this;
                i = b.c.a.b.i.mtrl_picker_toggle_to_day_selection;
            }
            cVar.i0(hVar.K(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends RecyclerView.t {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f1731a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MaterialButton f1732b;

        g(n nVar, MaterialButton materialButton) {
            this.f1731a = nVar;
            this.f1732b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            if (i == 0) {
                CharSequence text = this.f1732b.getText();
                if (Build.VERSION.SDK_INT >= 16) {
                    recyclerView.announceForAccessibility(text);
                } else {
                    recyclerView.sendAccessibilityEvent(2048);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            LinearLayoutManager G1 = h.this.G1();
            int Z1 = i < 0 ? G1.Z1() : G1.c2();
            h.this.f0 = this.f1731a.v(Z1);
            this.f1732b.setText(this.f1731a.w(Z1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.datepicker.h$h  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0083h implements View.OnClickListener {
        View$OnClickListenerC0083h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.L1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        final /* synthetic */ n f;

        i(n nVar) {
            this.f = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int Z1 = h.this.G1().Z1() + 1;
            if (Z1 < h.this.j0.getAdapter().c()) {
                h.this.J1(this.f.v(Z1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {
        final /* synthetic */ n f;

        j(n nVar) {
            this.f = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int c2 = h.this.G1().c2() - 1;
            if (c2 >= 0) {
                h.this.J1(this.f.v(c2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum k {
        DAY,
        YEAR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface l {
        void a(long j);
    }

    private RecyclerView.n A1() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F1(Context context) {
        return context.getResources().getDimensionPixelSize(b.c.a.b.d.mtrl_calendar_day_height);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> h<T> H1(com.google.android.material.datepicker.d<T> dVar, int i2, com.google.android.material.datepicker.a aVar) {
        h<T> hVar = new h<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", aVar.o());
        hVar.j1(bundle);
        return hVar;
    }

    private void I1(int i2) {
        this.j0.post(new a(i2));
    }

    private void z1(View view, n nVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(b.c.a.b.f.month_navigation_fragment_toggle);
        materialButton.setTag(p0);
        a.g.k.s.f0(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(b.c.a.b.f.month_navigation_previous);
        materialButton2.setTag(n0);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(b.c.a.b.f.month_navigation_next);
        materialButton3.setTag(o0);
        this.k0 = view.findViewById(b.c.a.b.f.mtrl_calendar_year_selector_frame);
        this.l0 = view.findViewById(b.c.a.b.f.mtrl_calendar_day_selector_frame);
        K1(k.DAY);
        materialButton.setText(this.f0.B());
        this.j0.addOnScrollListener(new g(nVar, materialButton));
        materialButton.setOnClickListener(new View$OnClickListenerC0083h());
        materialButton3.setOnClickListener(new i(nVar));
        materialButton2.setOnClickListener(new j(nVar));
    }

    @Override // androidx.fragment.app.Fragment
    public void A0(Bundle bundle) {
        super.A0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.c0);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.d0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.e0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.a B1() {
        return this.e0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.c C1() {
        return this.h0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.l D1() {
        return this.f0;
    }

    public com.google.android.material.datepicker.d<S> E1() {
        return this.d0;
    }

    LinearLayoutManager G1() {
        return (LinearLayoutManager) this.j0.getLayoutManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J1(com.google.android.material.datepicker.l lVar) {
        RecyclerView recyclerView;
        int i2;
        n nVar = (n) this.j0.getAdapter();
        int x = nVar.x(lVar);
        int x2 = x - nVar.x(this.f0);
        boolean z = Math.abs(x2) > 3;
        boolean z2 = x2 > 0;
        this.f0 = lVar;
        if (!z || !z2) {
            if (z) {
                recyclerView = this.j0;
                i2 = x + 3;
            }
            I1(x);
        }
        recyclerView = this.j0;
        i2 = x - 3;
        recyclerView.scrollToPosition(i2);
        I1(x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K1(k kVar) {
        this.g0 = kVar;
        if (kVar == k.YEAR) {
            this.i0.getLayoutManager().x1(((s) this.i0.getAdapter()).w(this.f0.i));
            this.k0.setVisibility(0);
            this.l0.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.k0.setVisibility(8);
            this.l0.setVisibility(0);
            J1(this.f0);
        }
    }

    void L1() {
        k kVar;
        k kVar2 = this.g0;
        if (kVar2 == k.YEAR) {
            kVar = k.DAY;
        } else if (kVar2 != k.DAY) {
            return;
        } else {
            kVar = k.YEAR;
        }
        K1(kVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void e0(Bundle bundle) {
        super.e0(bundle);
        if (bundle == null) {
            bundle = p();
        }
        this.c0 = bundle.getInt("THEME_RES_ID_KEY");
        this.d0 = (com.google.android.material.datepicker.d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.e0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f0 = (com.google.android.material.datepicker.l) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(r(), this.c0);
        this.h0 = new com.google.android.material.datepicker.c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        com.google.android.material.datepicker.l p = this.e0.p();
        if (com.google.android.material.datepicker.i.Q1(contextThemeWrapper)) {
            i2 = b.c.a.b.h.mtrl_calendar_vertical;
            i3 = 1;
        } else {
            i2 = b.c.a.b.h.mtrl_calendar_horizontal;
            i3 = 0;
        }
        View inflate = cloneInContext.inflate(i2, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(b.c.a.b.f.mtrl_calendar_days_of_week);
        a.g.k.s.f0(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new com.google.android.material.datepicker.g());
        gridView.setNumColumns(p.j);
        gridView.setEnabled(false);
        this.j0 = (RecyclerView) inflate.findViewById(b.c.a.b.f.mtrl_calendar_months);
        this.j0.setLayoutManager(new c(r(), i3, false, i3));
        this.j0.setTag(m0);
        n nVar = new n(contextThemeWrapper, this.d0, this.e0, new d());
        this.j0.setAdapter(nVar);
        int integer = contextThemeWrapper.getResources().getInteger(b.c.a.b.g.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(b.c.a.b.f.mtrl_calendar_year_selector_frame);
        this.i0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.i0.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.i0.setAdapter(new s(this));
            this.i0.addItemDecoration(A1());
        }
        if (inflate.findViewById(b.c.a.b.f.month_navigation_fragment_toggle) != null) {
            z1(inflate, nVar);
        }
        if (!com.google.android.material.datepicker.i.Q1(contextThemeWrapper)) {
            new androidx.recyclerview.widget.h().b(this.j0);
        }
        this.j0.scrollToPosition(nVar.x(this.f0));
        return inflate;
    }
}
