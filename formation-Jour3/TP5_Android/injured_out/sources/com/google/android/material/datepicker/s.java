package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.h;
import java.util.Calendar;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends RecyclerView.g<b> {

    /* renamed from: c  reason: collision with root package name */
    private final h<?> f1738c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        final /* synthetic */ int f;

        a(int i) {
            this.f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s.this.f1738c.J1(l.x(this.f, s.this.f1738c.D1().h));
            s.this.f1738c.K1(h.k.DAY);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.d0 {
        final TextView t;

        b(TextView textView) {
            super(textView);
            this.t = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(h<?> hVar) {
        this.f1738c = hVar;
    }

    private View.OnClickListener v(int i) {
        return new a(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f1738c.B1().q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w(int i) {
        return i - this.f1738c.B1().p().i;
    }

    int x(int i) {
        return this.f1738c.B1().p().i + i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: y */
    public void j(b bVar, int i) {
        int x = x(i);
        String string = bVar.t.getContext().getString(b.c.a.b.i.mtrl_picker_navigate_to_year_description);
        bVar.t.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(x)));
        bVar.t.setContentDescription(String.format(string, Integer.valueOf(x)));
        c C1 = this.f1738c.C1();
        Calendar i2 = r.i();
        com.google.android.material.datepicker.b bVar2 = i2.get(1) == x ? C1.f : C1.f1725d;
        for (Long l : this.f1738c.E1().l()) {
            i2.setTimeInMillis(l.longValue());
            if (i2.get(1) == x) {
                bVar2 = C1.e;
            }
        }
        bVar2.d(bVar.t);
        bVar.t.setOnClickListener(v(x));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: z */
    public b l(ViewGroup viewGroup, int i) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(b.c.a.b.h.mtrl_calendar_year, viewGroup, false));
    }
}
