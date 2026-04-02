package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.Calendar;
/* loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {
    private final Calendar f;

    /* loaded from: classes.dex */
    class a extends a.g.k.a {
        a(MaterialCalendarGridView materialCalendarGridView) {
        }

        @Override // a.g.k.a
        public void g(View view, a.g.k.b0.c cVar) {
            super.g(view, cVar);
            cVar.Y(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = r.k();
        if (i.Q1(getContext())) {
            setNextFocusLeftId(b.c.a.b.f.cancel_button);
            setNextFocusRightId(b.c.a.b.f.confirm_button);
        }
        a.g.k.s.f0(this, new a(this));
    }

    private void a(int i, Rect rect) {
        int b2;
        if (i == 33) {
            b2 = getAdapter2().h();
        } else if (i != 130) {
            super.onFocusChanged(true, i, rect);
            return;
        } else {
            b2 = getAdapter2().b();
        }
        setSelection(b2);
    }

    private static int c(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean d(Long l, Long l2, Long l3, Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: b */
    public m getAdapter2() {
        return (m) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter2().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int a2;
        int c2;
        int a3;
        int c3;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        m adapter2 = getAdapter2();
        d<?> dVar = adapter2.g;
        c cVar = adapter2.h;
        Long item = adapter2.getItem(adapter2.b());
        Long item2 = adapter2.getItem(adapter2.h());
        for (a.g.j.e<Long, Long> eVar : dVar.f()) {
            Long l = eVar.f217a;
            if (l != null) {
                if (eVar.f218b == null) {
                    continue;
                } else {
                    long longValue = l.longValue();
                    long longValue2 = eVar.f218b.longValue();
                    if (d(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                        return;
                    }
                    if (longValue < item.longValue()) {
                        a2 = adapter2.b();
                        c2 = adapter2.f(a2) ? 0 : materialCalendarGridView.getChildAt(a2 - 1).getRight();
                    } else {
                        materialCalendarGridView.f.setTimeInMillis(longValue);
                        a2 = adapter2.a(materialCalendarGridView.f.get(5));
                        c2 = c(materialCalendarGridView.getChildAt(a2));
                    }
                    if (longValue2 > item2.longValue()) {
                        a3 = adapter2.h();
                        c3 = adapter2.g(a3) ? getWidth() : materialCalendarGridView.getChildAt(a3).getRight();
                    } else {
                        materialCalendarGridView.f.setTimeInMillis(longValue2);
                        a3 = adapter2.a(materialCalendarGridView.f.get(5));
                        c3 = c(materialCalendarGridView.getChildAt(a3));
                    }
                    int itemId = (int) adapter2.getItemId(a2);
                    int itemId2 = (int) adapter2.getItemId(a3);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (getNumColumns() + numColumns) - 1;
                        View childAt = materialCalendarGridView.getChildAt(numColumns);
                        canvas.drawRect(numColumns > a2 ? 0 : c2, childAt.getTop() + cVar.f1722a.c(), a3 > numColumns2 ? getWidth() : c3, childAt.getBottom() - cVar.f1722a.b(), cVar.h);
                        itemId++;
                        materialCalendarGridView = this;
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            a(i, rect);
        } else {
            super.onFocusChanged(false, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (super.onKeyDown(i, keyEvent)) {
            if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter2().b()) {
                return true;
            }
            if (19 == i) {
                setSelection(getAdapter2().b());
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof m)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), m.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        if (i < getAdapter2().b()) {
            i = getAdapter2().b();
        }
        super.setSelection(i);
    }
}
