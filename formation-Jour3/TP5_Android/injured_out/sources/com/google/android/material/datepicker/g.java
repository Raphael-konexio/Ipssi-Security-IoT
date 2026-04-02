package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes.dex */
class g extends BaseAdapter {
    private static final int i;
    private final Calendar f;
    private final int g;
    private final int h;

    static {
        i = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public g() {
        Calendar k = r.k();
        this.f = k;
        this.g = k.getMaximum(7);
        this.h = this.f.getFirstDayOfWeek();
    }

    private int b(int i2) {
        int i3 = i2 + this.h;
        int i4 = this.g;
        return i3 > i4 ? i3 - i4 : i3;
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public Integer getItem(int i2) {
        if (i2 >= this.g) {
            return null;
        }
        return Integer.valueOf(b(i2));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.g;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(b.c.a.b.h.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f.set(7, b(i2));
        textView.setText(this.f.getDisplayName(7, i, Locale.getDefault()));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(b.c.a.b.i.mtrl_picker_day_of_week_column_header), this.f.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
