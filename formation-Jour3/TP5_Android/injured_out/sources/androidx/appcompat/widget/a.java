package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {
    protected final C0034a f;
    protected final Context g;
    protected ActionMenuView h;
    protected c i;
    protected int j;
    protected a.g.k.w k;
    private boolean l;
    private boolean m;

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected class C0034a implements a.g.k.x {

        /* renamed from: a  reason: collision with root package name */
        private boolean f583a = false;

        /* renamed from: b  reason: collision with root package name */
        int f584b;

        protected C0034a() {
        }

        @Override // a.g.k.x
        public void a(View view) {
            this.f583a = true;
        }

        @Override // a.g.k.x
        public void b(View view) {
            if (this.f583a) {
                return;
            }
            a aVar = a.this;
            aVar.k = null;
            a.super.setVisibility(this.f584b);
        }

        @Override // a.g.k.x
        public void c(View view) {
            a.super.setVisibility(0);
            this.f583a = false;
        }

        public C0034a d(a.g.k.w wVar, int i) {
            a.this.k = wVar;
            this.f584b = i;
            return this;
        }
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new C0034a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(a.a.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.g = context;
        } else {
            this.g = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int d(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, RecyclerView.UNDEFINED_DURATION), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public a.g.k.w f(int i, long j) {
        a.g.k.w wVar = this.k;
        if (wVar != null) {
            wVar.b();
        }
        if (i != 0) {
            a.g.k.w c2 = a.g.k.s.c(this);
            c2.a(0.0f);
            c2.d(j);
            C0034a c0034a = this.f;
            c0034a.d(c2, i);
            c2.f(c0034a);
            return c2;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        a.g.k.w c3 = a.g.k.s.c(this);
        c3.a(1.0f);
        c3.d(j);
        C0034a c0034a2 = this.f;
        c0034a2.d(c3, i);
        c3.f(c0034a2);
        return c3;
    }

    public int getAnimatedVisibility() {
        return this.k != null ? this.f.f584b : getVisibility();
    }

    public int getContentHeight() {
        return this.j;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, a.a.j.ActionBar, a.a.a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(a.a.j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.i;
        if (cVar != null) {
            cVar.E(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.m = false;
        }
        if (!this.m) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.m = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.m = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.l = false;
        }
        if (!this.l) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.l = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.l = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            a.g.k.w wVar = this.k;
            if (wVar != null) {
                wVar.b();
            }
            super.setVisibility(i);
        }
    }
}
