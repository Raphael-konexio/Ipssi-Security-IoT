package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends RecyclerView.g<b> {

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.material.datepicker.a f1736c;

    /* renamed from: d  reason: collision with root package name */
    private final d<?> f1737d;
    private final h.l e;
    private final int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {
        final /* synthetic */ MaterialCalendarGridView f;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f.getAdapter2().j(i)) {
                n.this.e.a(this.f.getAdapter2().getItem(i).longValue());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.d0 {
        final TextView t;
        final MaterialCalendarGridView u;

        b(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(b.c.a.b.f.month_title);
            this.t = textView;
            a.g.k.s.g0(textView, true);
            this.u = (MaterialCalendarGridView) linearLayout.findViewById(b.c.a.b.f.month_grid);
            if (z) {
                return;
            }
            this.t.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, d<?> dVar, com.google.android.material.datepicker.a aVar, h.l lVar) {
        l p = aVar.p();
        l k = aVar.k();
        l o = aVar.o();
        if (p.compareTo(o) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (o.compareTo(k) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f = (m.j * h.F1(context)) + (i.Q1(context) ? h.F1(context) : 0);
        this.f1736c = aVar;
        this.f1737d = dVar;
        this.e = lVar;
        s(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f1736c.n();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long d(int i) {
        return this.f1736c.p().D(i).C();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l v(int i) {
        return this.f1736c.p().D(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence w(int i) {
        return v(i).B();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x(l lVar) {
        return this.f1736c.p().E(lVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: y */
    public void j(b bVar, int i) {
        l D = this.f1736c.p().D(i);
        bVar.t.setText(D.B());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.u.findViewById(b.c.a.b.f.month_grid);
        if (materialCalendarGridView.getAdapter2() == null || !D.equals(materialCalendarGridView.getAdapter2().f)) {
            m mVar = new m(D, this.f1737d, this.f1736c);
            materialCalendarGridView.setNumColumns(D.j);
            materialCalendarGridView.setAdapter((ListAdapter) mVar);
        } else {
            materialCalendarGridView.getAdapter2().notifyDataSetChanged();
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: z */
    public b l(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(b.c.a.b.h.mtrl_calendar_month_labeled, viewGroup, false);
        if (i.Q1(viewGroup.getContext())) {
            linearLayout.setLayoutParams(new RecyclerView.p(-1, this.f));
            return new b(linearLayout, true);
        }
        return new b(linearLayout, false);
    }
}
