package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.m;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final Context f564a;

    /* renamed from: b  reason: collision with root package name */
    private final g f565b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f566c;

    /* renamed from: d  reason: collision with root package name */
    private final int f567d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private m.a i;
    private k j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l;

    /* loaded from: classes.dex */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            l.this.e();
        }
    }

    public l(Context context, g gVar, View view, boolean z, int i) {
        this(context, gVar, view, z, i, 0);
    }

    public l(Context context, g gVar, View view, boolean z, int i, int i2) {
        this.g = 8388611;
        this.l = new a();
        this.f564a = context;
        this.f565b = gVar;
        this.f = view;
        this.f566c = z;
        this.f567d = i;
        this.e = i2;
    }

    private k a() {
        Display defaultDisplay = ((WindowManager) this.f564a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        k dVar = Math.min(point.x, point.y) >= this.f564a.getResources().getDimensionPixelSize(a.a.d.abc_cascading_menus_min_smallest_width) ? new d(this.f564a, this.f, this.f567d, this.e, this.f566c) : new q(this.f564a, this.f565b, this.f, this.f567d, this.e, this.f566c);
        dVar.l(this.f565b);
        dVar.u(this.l);
        dVar.p(this.f);
        dVar.k(this.i);
        dVar.r(this.h);
        dVar.s(this.g);
        return dVar;
    }

    private void l(int i, int i2, boolean z, boolean z2) {
        k c2 = c();
        c2.v(z2);
        if (z) {
            if ((a.g.k.d.b(this.g, a.g.k.s.w(this.f)) & 7) == 5) {
                i -= this.f.getWidth();
            }
            c2.t(i);
            c2.w(i2);
            int i3 = (int) ((this.f564a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c2.q(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        c2.a();
    }

    public void b() {
        if (d()) {
            this.j.dismiss();
        }
    }

    public k c() {
        if (this.j == null) {
            this.j = a();
        }
        return this.j;
    }

    public boolean d() {
        k kVar = this.j;
        return kVar != null && kVar.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f = view;
    }

    public void g(boolean z) {
        this.h = z;
        k kVar = this.j;
        if (kVar != null) {
            kVar.r(z);
        }
    }

    public void h(int i) {
        this.g = i;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public void j(m.a aVar) {
        this.i = aVar;
        k kVar = this.j;
        if (kVar != null) {
            kVar.k(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i, int i2) {
        if (d()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        l(i, i2, true, true);
        return true;
    }
}
