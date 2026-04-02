package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class j0 implements androidx.appcompat.view.menu.p {
    private static Method K;
    private static Method L;
    private static Method M;
    private AdapterView.OnItemSelectedListener A;
    final f B;
    private final e C;
    private final d D;
    private final b E;
    final Handler F;
    private final Rect G;
    private Rect H;
    private boolean I;
    PopupWindow J;
    private Context f;
    private ListAdapter g;
    f0 h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private boolean r;
    private boolean s;
    int t;
    private View u;
    private int v;
    private DataSetObserver w;
    private View x;
    private Drawable y;
    private AdapterView.OnItemClickListener z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            f0 f0Var;
            if (i == -1 || (f0Var = j0.this.h) == null) {
                return;
            }
            f0Var.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends DataSetObserver {
        c() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (j0.this.c()) {
                j0.this.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            j0.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements AbsListView.OnScrollListener {
        d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || j0.this.w() || j0.this.J.getContentView() == null) {
                return;
            }
            j0 j0Var = j0.this;
            j0Var.F.removeCallbacks(j0Var.B);
            j0.this.B.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements View.OnTouchListener {
        e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = j0.this.J) != null && popupWindow.isShowing() && x >= 0 && x < j0.this.J.getWidth() && y >= 0 && y < j0.this.J.getHeight()) {
                j0 j0Var = j0.this;
                j0Var.F.postDelayed(j0Var.B, 250L);
                return false;
            } else if (action == 1) {
                j0 j0Var2 = j0.this;
                j0Var2.F.removeCallbacks(j0Var2.B);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f0 f0Var = j0.this.h;
            if (f0Var == null || !a.g.k.s.L(f0Var) || j0.this.h.getCount() <= j0.this.h.getChildCount()) {
                return;
            }
            int childCount = j0.this.h.getChildCount();
            j0 j0Var = j0.this;
            if (childCount <= j0Var.t) {
                j0Var.J.setInputMethodMode(2);
                j0.this.a();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                K = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                M = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                L = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public j0(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public j0(Context context, AttributeSet attributeSet, int i, int i2) {
        this.i = -2;
        this.j = -2;
        this.m = 1002;
        this.q = 0;
        this.r = false;
        this.s = false;
        this.t = Reader.READ_DONE;
        this.v = 0;
        this.B = new f();
        this.C = new e();
        this.D = new d();
        this.E = new b();
        this.G = new Rect();
        this.f = context;
        this.F = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.a.j.ListPopupWindow, i, i2);
        this.k = obtainStyledAttributes.getDimensionPixelOffset(a.a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(a.a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.l = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.n = true;
        }
        obtainStyledAttributes.recycle();
        q qVar = new q(context, attributeSet, i, i2);
        this.J = qVar;
        qVar.setInputMethodMode(1);
    }

    private void J(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            this.J.setIsClippedToScreen(z);
            return;
        }
        Method method = K;
        if (method != null) {
            try {
                method.invoke(this.J, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int q() {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j0.q():int");
    }

    private int u(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = L;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(this.J, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            return this.J.getMaxAvailableHeight(view, i);
        }
        return this.J.getMaxAvailableHeight(view, i, z);
    }

    private void y() {
        View view = this.u;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.u);
            }
        }
    }

    public void A(int i) {
        this.J.setAnimationStyle(i);
    }

    public void B(int i) {
        Drawable background = this.J.getBackground();
        if (background == null) {
            M(i);
            return;
        }
        background.getPadding(this.G);
        Rect rect = this.G;
        this.j = rect.left + rect.right + i;
    }

    public void C(int i) {
        this.q = i;
    }

    public void D(Rect rect) {
        this.H = rect != null ? new Rect(rect) : null;
    }

    public void E(int i) {
        this.J.setInputMethodMode(i);
    }

    public void F(boolean z) {
        this.I = z;
        this.J.setFocusable(z);
    }

    public void G(PopupWindow.OnDismissListener onDismissListener) {
        this.J.setOnDismissListener(onDismissListener);
    }

    public void H(AdapterView.OnItemClickListener onItemClickListener) {
        this.z = onItemClickListener;
    }

    public void I(boolean z) {
        this.p = true;
        this.o = z;
    }

    public void K(int i) {
        this.v = i;
    }

    public void L(int i) {
        f0 f0Var = this.h;
        if (!c() || f0Var == null) {
            return;
        }
        f0Var.setListSelectionHidden(false);
        f0Var.setSelection(i);
        if (f0Var.getChoiceMode() != 0) {
            f0Var.setItemChecked(i, true);
        }
    }

    public void M(int i) {
        this.j = i;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a() {
        int q = q();
        boolean w = w();
        androidx.core.widget.h.b(this.J, this.m);
        boolean z = true;
        if (this.J.isShowing()) {
            if (a.g.k.s.L(t())) {
                int i = this.j;
                if (i == -1) {
                    i = -1;
                } else if (i == -2) {
                    i = t().getWidth();
                }
                int i2 = this.i;
                if (i2 == -1) {
                    if (!w) {
                        q = -1;
                    }
                    if (w) {
                        this.J.setWidth(this.j == -1 ? -1 : 0);
                        this.J.setHeight(0);
                    } else {
                        this.J.setWidth(this.j == -1 ? -1 : 0);
                        this.J.setHeight(-1);
                    }
                } else if (i2 != -2) {
                    q = i2;
                }
                this.J.setOutsideTouchable((this.s || this.r) ? false : false);
                this.J.update(t(), this.k, this.l, i < 0 ? -1 : i, q < 0 ? -1 : q);
                return;
            }
            return;
        }
        int i3 = this.j;
        if (i3 == -1) {
            i3 = -1;
        } else if (i3 == -2) {
            i3 = t().getWidth();
        }
        int i4 = this.i;
        if (i4 == -1) {
            q = -1;
        } else if (i4 != -2) {
            q = i4;
        }
        this.J.setWidth(i3);
        this.J.setHeight(q);
        J(true);
        this.J.setOutsideTouchable((this.s || this.r) ? false : true);
        this.J.setTouchInterceptor(this.C);
        if (this.p) {
            androidx.core.widget.h.a(this.J, this.o);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = M;
            if (method != null) {
                try {
                    method.invoke(this.J, this.H);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.J.setEpicenterBounds(this.H);
        }
        androidx.core.widget.h.c(this.J, t(), this.k, this.l, this.q);
        this.h.setSelection(-1);
        if (!this.I || this.h.isInTouchMode()) {
            r();
        }
        if (this.I) {
            return;
        }
        this.F.post(this.E);
    }

    public void b(Drawable drawable) {
        this.J.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean c() {
        return this.J.isShowing();
    }

    public int d() {
        return this.k;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        this.J.dismiss();
        y();
        this.J.setContentView(null);
        this.h = null;
        this.F.removeCallbacks(this.B);
    }

    public Drawable g() {
        return this.J.getBackground();
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView h() {
        return this.h;
    }

    public void j(int i) {
        this.l = i;
        this.n = true;
    }

    public void l(int i) {
        this.k = i;
    }

    public int n() {
        if (this.n) {
            return this.l;
        }
        return 0;
    }

    public void p(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.w;
        if (dataSetObserver == null) {
            this.w = new c();
        } else {
            ListAdapter listAdapter2 = this.g;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.g = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.w);
        }
        f0 f0Var = this.h;
        if (f0Var != null) {
            f0Var.setAdapter(this.g);
        }
    }

    public void r() {
        f0 f0Var = this.h;
        if (f0Var != null) {
            f0Var.setListSelectionHidden(true);
            f0Var.requestLayout();
        }
    }

    f0 s(Context context, boolean z) {
        return new f0(context, z);
    }

    public View t() {
        return this.x;
    }

    public int v() {
        return this.j;
    }

    public boolean w() {
        return this.J.getInputMethodMode() == 2;
    }

    public boolean x() {
        return this.I;
    }

    public void z(View view) {
        this.x = view;
    }
}
