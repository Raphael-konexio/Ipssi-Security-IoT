package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    static final int j = r.k().getMaximum(4);
    final l f;
    final d<?> g;
    c h;
    final a i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, d<?> dVar, a aVar) {
        this.f = lVar;
        this.g = dVar;
        this.i = aVar;
    }

    private void e(Context context) {
        if (this.h == null) {
            this.h = new c(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        return b() + (i - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f.z();
    }

    @Override // android.widget.Adapter
    /* renamed from: c */
    public Long getItem(int i) {
        if (i < this.f.z() || i > h()) {
            return null;
        }
        return Long.valueOf(this.f.A(i(i)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    @Override // android.widget.Adapter
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.e(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = b.c.a.b.h.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            r8 = 1
            if (r7 < 0) goto L5e
            com.google.android.material.datepicker.l r2 = r5.f
            int r3 = r2.k
            if (r7 < r3) goto L2e
            goto L5e
        L2e:
            int r7 = r7 + r8
            r0.setTag(r2)
            java.lang.String r2 = java.lang.String.valueOf(r7)
            r0.setText(r2)
            com.google.android.material.datepicker.l r2 = r5.f
            long r2 = r2.A(r7)
            com.google.android.material.datepicker.l r7 = r5.f
            int r7 = r7.i
            com.google.android.material.datepicker.l r4 = com.google.android.material.datepicker.l.F()
            int r4 = r4.i
            if (r7 != r4) goto L50
            java.lang.String r7 = com.google.android.material.datepicker.e.a(r2)
            goto L54
        L50:
            java.lang.String r7 = com.google.android.material.datepicker.e.c(r2)
        L54:
            r0.setContentDescription(r7)
            r0.setVisibility(r1)
            r0.setEnabled(r8)
            goto L66
        L5e:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L66:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L6d
            return r0
        L6d:
            com.google.android.material.datepicker.a r7 = r5.i
            com.google.android.material.datepicker.a$c r7 = r7.j()
            long r2 = r6.longValue()
            boolean r7 = r7.g(r2)
            if (r7 == 0) goto Lcc
            r0.setEnabled(r8)
            com.google.android.material.datepicker.d<?> r7 = r5.g
            java.util.Collection r7 = r7.l()
            java.util.Iterator r7 = r7.iterator()
        L8a:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lb2
            java.lang.Object r8 = r7.next()
            java.lang.Long r8 = (java.lang.Long) r8
            long r1 = r8.longValue()
            long r3 = r6.longValue()
            long r3 = com.google.android.material.datepicker.r.a(r3)
            long r1 = com.google.android.material.datepicker.r.a(r1)
            int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r8 != 0) goto L8a
            com.google.android.material.datepicker.c r6 = r5.h
            com.google.android.material.datepicker.b r6 = r6.f1723b
        Lae:
            r6.d(r0)
            return r0
        Lb2:
            java.util.Calendar r7 = com.google.android.material.datepicker.r.i()
            long r7 = r7.getTimeInMillis()
            long r1 = r6.longValue()
            int r6 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r6 != 0) goto Lc7
            com.google.android.material.datepicker.c r6 = r5.h
            com.google.android.material.datepicker.b r6 = r6.f1724c
            goto Lae
        Lc7:
            com.google.android.material.datepicker.c r6 = r5.h
            com.google.android.material.datepicker.b r6 = r6.f1722a
            goto Lae
        Lcc:
            r0.setEnabled(r1)
            com.google.android.material.datepicker.c r6 = r5.h
            com.google.android.material.datepicker.b r6 = r6.g
            goto Lae
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.m.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(int i) {
        return i % this.f.j == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i) {
        return (i + 1) % this.f.j == 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f.k + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.f.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return (this.f.z() + this.f.k) - 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    int i(int i) {
        return (i - this.f.z()) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j(int i) {
        return i >= b() && i <= h();
    }
}
