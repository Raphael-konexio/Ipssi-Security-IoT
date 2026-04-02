package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    final b f1722a;

    /* renamed from: b  reason: collision with root package name */
    final b f1723b;

    /* renamed from: c  reason: collision with root package name */
    final b f1724c;

    /* renamed from: d  reason: collision with root package name */
    final b f1725d;
    final b e;
    final b f;
    final b g;
    final Paint h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(b.c.a.b.x.b.c(context, b.c.a.b.b.materialCalendarStyle, h.class.getCanonicalName()), b.c.a.b.k.MaterialCalendar);
        this.f1722a = b.a(context, obtainStyledAttributes.getResourceId(b.c.a.b.k.MaterialCalendar_dayStyle, 0));
        this.g = b.a(context, obtainStyledAttributes.getResourceId(b.c.a.b.k.MaterialCalendar_dayInvalidStyle, 0));
        this.f1723b = b.a(context, obtainStyledAttributes.getResourceId(b.c.a.b.k.MaterialCalendar_daySelectedStyle, 0));
        this.f1724c = b.a(context, obtainStyledAttributes.getResourceId(b.c.a.b.k.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList a2 = b.c.a.b.x.c.a(context, obtainStyledAttributes, b.c.a.b.k.MaterialCalendar_rangeFillColor);
        this.f1725d = b.a(context, obtainStyledAttributes.getResourceId(b.c.a.b.k.MaterialCalendar_yearStyle, 0));
        this.e = b.a(context, obtainStyledAttributes.getResourceId(b.c.a.b.k.MaterialCalendar_yearSelectedStyle, 0));
        this.f = b.a(context, obtainStyledAttributes.getResourceId(b.c.a.b.k.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(a2.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
