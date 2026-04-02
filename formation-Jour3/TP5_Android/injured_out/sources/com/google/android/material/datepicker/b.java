package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f1718a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f1719b;

    /* renamed from: c  reason: collision with root package name */
    private final ColorStateList f1720c;

    /* renamed from: d  reason: collision with root package name */
    private final ColorStateList f1721d;
    private final int e;
    private final b.c.a.b.a0.k f;

    private b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, b.c.a.b.a0.k kVar, Rect rect) {
        a.g.j.i.b(rect.left);
        a.g.j.i.b(rect.top);
        a.g.j.i.b(rect.right);
        a.g.j.i.b(rect.bottom);
        this.f1718a = rect;
        this.f1719b = colorStateList2;
        this.f1720c = colorStateList;
        this.f1721d = colorStateList3;
        this.e = i;
        this.f = kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(Context context, int i) {
        a.g.j.i.a(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, b.c.a.b.k.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(b.c.a.b.k.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(b.c.a.b.k.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(b.c.a.b.k.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(b.c.a.b.k.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList a2 = b.c.a.b.x.c.a(context, obtainStyledAttributes, b.c.a.b.k.MaterialCalendarItem_itemFillColor);
        ColorStateList a3 = b.c.a.b.x.c.a(context, obtainStyledAttributes, b.c.a.b.k.MaterialCalendarItem_itemTextColor);
        ColorStateList a4 = b.c.a.b.x.c.a(context, obtainStyledAttributes, b.c.a.b.k.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(b.c.a.b.k.MaterialCalendarItem_itemStrokeWidth, 0);
        b.c.a.b.a0.k m = b.c.a.b.a0.k.b(context, obtainStyledAttributes.getResourceId(b.c.a.b.k.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(b.c.a.b.k.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        obtainStyledAttributes.recycle();
        return new b(a2, a3, a4, dimensionPixelSize, m, rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1718a.bottom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f1718a.top;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TextView textView) {
        b.c.a.b.a0.g gVar = new b.c.a.b.a0.g();
        b.c.a.b.a0.g gVar2 = new b.c.a.b.a0.g();
        gVar.setShapeAppearanceModel(this.f);
        gVar2.setShapeAppearanceModel(this.f);
        gVar.T(this.f1720c);
        gVar.a0(this.e, this.f1721d);
        textView.setTextColor(this.f1719b);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.f1719b.withAlpha(30), gVar, gVar2) : gVar;
        Rect rect = this.f1718a;
        a.g.k.s.i0(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
