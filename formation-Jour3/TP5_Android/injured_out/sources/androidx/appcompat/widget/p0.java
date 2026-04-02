package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.i0;
/* loaded from: classes.dex */
public class p0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    Runnable f;
    private c g;
    i0 h;
    private Spinner i;
    private boolean j;
    int k;
    int l;
    private int m;
    private int n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ View f;

        a(View view) {
            this.f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            p0.this.smoothScrollTo(this.f.getLeft() - ((p0.this.getWidth() - this.f.getWidth()) / 2), 0);
            p0.this.f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return p0.this.h.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((d) p0.this.h.getChildAt(i)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return p0.this.c((a.c) getItem(i), true);
            }
            ((d) view).a((a.c) getItem(i));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = p0.this.h.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = p0.this.h.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends LinearLayout {
        private final int[] f;
        private a.c g;
        private TextView h;
        private ImageView i;
        private View j;

        public d(Context context, a.c cVar, boolean z) {
            super(context, null, a.a.a.actionBarTabStyle);
            int[] iArr = {16842964};
            this.f = iArr;
            this.g = cVar;
            w0 u = w0.u(context, null, iArr, a.a.a.actionBarTabStyle, 0);
            if (u.r(0)) {
                setBackgroundDrawable(u.g(0));
            }
            u.v();
            if (z) {
                setGravity(8388627);
            }
            c();
        }

        public void a(a.c cVar) {
            this.g = cVar;
            c();
        }

        public a.c b() {
            return this.g;
        }

        public void c() {
            a.c cVar = this.g;
            View b2 = cVar.b();
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.j = b2;
                TextView textView = this.h;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.i;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.i.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.j;
            if (view != null) {
                removeView(view);
                this.j = null;
            }
            Drawable c2 = cVar.c();
            CharSequence d2 = cVar.d();
            if (c2 != null) {
                if (this.i == null) {
                    o oVar = new o(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    oVar.setLayoutParams(layoutParams);
                    addView(oVar, 0);
                    this.i = oVar;
                }
                this.i.setImageDrawable(c2);
                this.i.setVisibility(0);
            } else {
                ImageView imageView2 = this.i;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.i.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(d2);
            if (z) {
                if (this.h == null) {
                    z zVar = new z(getContext(), null, a.a.a.actionBarTabTextStyle);
                    zVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    zVar.setLayoutParams(layoutParams2);
                    addView(zVar);
                    this.h = zVar;
                }
                this.h.setText(d2);
                this.h.setVisibility(0);
            } else {
                TextView textView2 = this.h;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.h.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.i;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            y0.a(this, z ? null : cVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (p0.this.k > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = p0.this.k;
                if (measuredWidth > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    static {
        new DecelerateInterpolator();
    }

    private Spinner b() {
        w wVar = new w(getContext(), null, a.a.a.actionDropDownStyle);
        wVar.setLayoutParams(new i0.a(-2, -1));
        wVar.setOnItemSelectedListener(this);
        return wVar;
    }

    private boolean d() {
        Spinner spinner = this.i;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (d()) {
            return;
        }
        if (this.i == null) {
            this.i = b();
        }
        removeView(this.h);
        addView(this.i, new ViewGroup.LayoutParams(-2, -1));
        if (this.i.getAdapter() == null) {
            this.i.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f = null;
        }
        this.i.setSelection(this.n);
    }

    private boolean f() {
        if (d()) {
            removeView(this.i);
            addView(this.h, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.i.getSelectedItemPosition());
            return false;
        }
        return false;
    }

    public void a(int i) {
        View childAt = this.h.getChildAt(i);
        Runnable runnable = this.f;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f = aVar;
        post(aVar);
    }

    d c(a.c cVar, boolean z) {
        d dVar = new d(getContext(), cVar, z);
        if (z) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.m));
        } else {
            dVar.setFocusable(true);
            if (this.g == null) {
                this.g = new c();
            }
            dVar.setOnClickListener(this.g);
        }
        return dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a.a.n.a b2 = a.a.n.a.b(getContext());
        setContentHeight(b2.f());
        this.l = b2.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((d) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.h.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            i3 = -1;
        } else {
            if (childCount > 2) {
                this.k = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.k = View.MeasureSpec.getSize(i) / 2;
            }
            i3 = Math.min(this.k, this.l);
        }
        this.k = i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.m, 1073741824);
        if ((z2 || !this.j) ? false : false) {
            this.h.measure(0, makeMeasureSpec);
            if (this.h.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                e();
                int measuredWidth = getMeasuredWidth();
                super.onMeasure(i, makeMeasureSpec);
                int measuredWidth2 = getMeasuredWidth();
                if (z2 || measuredWidth == measuredWidth2) {
                }
                setTabSelected(this.n);
                return;
            }
        }
        f();
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth22 = getMeasuredWidth();
        if (z2) {
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.j = z;
    }

    public void setContentHeight(int i) {
        this.m = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.n = i;
        int childCount = this.h.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.h.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
            i2++;
        }
        Spinner spinner = this.i;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }
}
