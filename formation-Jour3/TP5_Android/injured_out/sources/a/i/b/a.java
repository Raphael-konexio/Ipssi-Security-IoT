package a.i.b;

import a.d.h;
import a.g.k.b0.d;
import a.g.k.b0.e;
import a.g.k.s;
import a.i.b.b;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a extends a.g.k.a {
    private static final Rect n = new Rect(Reader.READ_DONE, Reader.READ_DONE, RecyclerView.UNDEFINED_DURATION, RecyclerView.UNDEFINED_DURATION);
    private static final b.a<a.g.k.b0.c> o = new C0017a();
    private static final b.InterfaceC0018b<h<a.g.k.b0.c>, a.g.k.b0.c> p = new b();
    private final AccessibilityManager h;
    private final View i;
    private c j;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f296d = new Rect();
    private final Rect e = new Rect();
    private final Rect f = new Rect();
    private final int[] g = new int[2];
    int k = RecyclerView.UNDEFINED_DURATION;
    int l = RecyclerView.UNDEFINED_DURATION;
    private int m = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: a.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0017a implements b.a<a.g.k.b0.c> {
        C0017a() {
        }

        @Override // a.i.b.b.a
        /* renamed from: b */
        public void a(a.g.k.b0.c cVar, Rect rect) {
            cVar.l(rect);
        }
    }

    /* loaded from: classes.dex */
    class b implements b.InterfaceC0018b<h<a.g.k.b0.c>, a.g.k.b0.c> {
        b() {
        }

        @Override // a.i.b.b.InterfaceC0018b
        /* renamed from: c */
        public a.g.k.b0.c a(h<a.g.k.b0.c> hVar, int i) {
            return hVar.m(i);
        }

        @Override // a.i.b.b.InterfaceC0018b
        /* renamed from: d */
        public int b(h<a.g.k.b0.c> hVar) {
            return hVar.l();
        }
    }

    /* loaded from: classes.dex */
    private class c extends d {
        c() {
        }

        @Override // a.g.k.b0.d
        public a.g.k.b0.c b(int i) {
            return a.g.k.b0.c.M(a.this.H(i));
        }

        @Override // a.g.k.b0.d
        public a.g.k.b0.c d(int i) {
            int i2 = i == 2 ? a.this.k : a.this.l;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i2);
        }

        @Override // a.g.k.b0.d
        public boolean f(int i, int i2, Bundle bundle) {
            return a.this.P(i, i2, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.i = view;
        this.h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (s.u(view) == 0) {
            s.p0(view, 1);
        }
    }

    private static Rect D(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } else {
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    private boolean E(Rect rect) {
        if (rect == null || rect.isEmpty() || this.i.getWindowVisibility() != 0) {
            return false;
        }
        View view = this.i;
        do {
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                return parent != null;
            }
            view = (View) parent;
            if (view.getAlpha() <= 0.0f) {
                break;
            }
        } while (view.getVisibility() == 0);
        return false;
    }

    private static int F(int i) {
        if (i != 19) {
            if (i != 21) {
                return i != 22 ? 130 : 66;
            }
            return 17;
        }
        return 33;
    }

    private boolean G(int i, Rect rect) {
        Object d2;
        h<a.g.k.b0.c> y = y();
        int i2 = this.l;
        int i3 = RecyclerView.UNDEFINED_DURATION;
        a.g.k.b0.c e = i2 == Integer.MIN_VALUE ? null : y.e(i2);
        if (i == 1 || i == 2) {
            d2 = a.i.b.b.d(y, p, o, e, i, s.w(this.i) == 1, false);
        } else if (i != 17 && i != 33 && i != 66 && i != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } else {
            Rect rect2 = new Rect();
            int i4 = this.l;
            if (i4 != Integer.MIN_VALUE) {
                z(i4, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.i, i, rect2);
            }
            d2 = a.i.b.b.c(y, p, o, e, rect2, i);
        }
        a.g.k.b0.c cVar = (a.g.k.b0.c) d2;
        if (cVar != null) {
            i3 = y.h(y.g(cVar));
        }
        return T(i3);
    }

    private boolean Q(int i, int i2, Bundle bundle) {
        return i2 != 1 ? i2 != 2 ? i2 != 64 ? i2 != 128 ? J(i, i2, bundle) : n(i) : S(i) : o(i) : T(i);
    }

    private boolean R(int i, Bundle bundle) {
        return s.W(this.i, i, bundle);
    }

    private boolean S(int i) {
        int i2;
        if (this.h.isEnabled() && this.h.isTouchExplorationEnabled() && (i2 = this.k) != i) {
            if (i2 != Integer.MIN_VALUE) {
                n(i2);
            }
            this.k = i;
            this.i.invalidate();
            U(i, 32768);
            return true;
        }
        return false;
    }

    private void V(int i) {
        int i2 = this.m;
        if (i2 == i) {
            return;
        }
        this.m = i;
        U(i, 128);
        U(i2, 256);
    }

    private boolean n(int i) {
        if (this.k == i) {
            this.k = RecyclerView.UNDEFINED_DURATION;
            this.i.invalidate();
            U(i, 65536);
            return true;
        }
        return false;
    }

    private boolean p() {
        int i = this.l;
        return i != Integer.MIN_VALUE && J(i, 16, null);
    }

    private AccessibilityEvent q(int i, int i2) {
        return i != -1 ? r(i, i2) : s(i2);
    }

    private AccessibilityEvent r(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        a.g.k.b0.c H = H(i);
        obtain.getText().add(H.v());
        obtain.setContentDescription(H.q());
        obtain.setScrollable(H.H());
        obtain.setPassword(H.G());
        obtain.setEnabled(H.C());
        obtain.setChecked(H.A());
        L(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(H.o());
        e.c(obtain, this.i, i);
        obtain.setPackageName(this.i.getContext().getPackageName());
        return obtain;
    }

    private AccessibilityEvent s(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.i.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private a.g.k.b0.c t(int i) {
        a.g.k.b0.c K = a.g.k.b0.c.K();
        K.d0(true);
        K.f0(true);
        K.W("android.view.View");
        K.S(n);
        K.T(n);
        K.l0(this.i);
        N(i, K);
        if (K.v() == null && K.q() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        K.l(this.e);
        if (this.e.equals(n)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int j = K.j();
        if ((j & 64) == 0) {
            if ((j & 128) == 0) {
                K.j0(this.i.getContext().getPackageName());
                K.q0(this.i, i);
                if (this.k == i) {
                    K.Q(true);
                    K.a(128);
                } else {
                    K.Q(false);
                    K.a(64);
                }
                boolean z = this.l == i;
                if (z) {
                    K.a(2);
                } else if (K.D()) {
                    K.a(1);
                }
                K.g0(z);
                this.i.getLocationOnScreen(this.g);
                K.m(this.f296d);
                if (this.f296d.equals(n)) {
                    K.l(this.f296d);
                    if (K.f244b != -1) {
                        a.g.k.b0.c K2 = a.g.k.b0.c.K();
                        for (int i2 = K.f244b; i2 != -1; i2 = K2.f244b) {
                            K2.m0(this.i, -1);
                            K2.S(n);
                            N(i2, K2);
                            K2.l(this.e);
                            Rect rect = this.f296d;
                            Rect rect2 = this.e;
                            rect.offset(rect2.left, rect2.top);
                        }
                        K2.O();
                    }
                    this.f296d.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
                }
                if (this.i.getLocalVisibleRect(this.f)) {
                    this.f.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
                    if (this.f296d.intersect(this.f)) {
                        K.T(this.f296d);
                        if (E(this.f296d)) {
                            K.t0(true);
                        }
                    }
                }
                return K;
            }
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }

    private a.g.k.b0.c u() {
        a.g.k.b0.c L = a.g.k.b0.c.L(this.i);
        s.U(this.i, L);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (L.n() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                L.c(this.i, ((Integer) arrayList.get(i)).intValue());
            }
            return L;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private h<a.g.k.b0.c> y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        h<a.g.k.b0.c> hVar = new h<>();
        for (int i = 0; i < arrayList.size(); i++) {
            hVar.i(arrayList.get(i).intValue(), t(arrayList.get(i).intValue()));
        }
        return hVar;
    }

    private void z(int i, Rect rect) {
        H(i).l(rect);
    }

    public final int A() {
        return this.l;
    }

    protected abstract int B(float f, float f2);

    protected abstract void C(List<Integer> list);

    a.g.k.b0.c H(int i) {
        return i == -1 ? u() : t(i);
    }

    public final void I(boolean z, int i, Rect rect) {
        int i2 = this.l;
        if (i2 != Integer.MIN_VALUE) {
            o(i2);
        }
        if (z) {
            G(i, rect);
        }
    }

    protected abstract boolean J(int i, int i2, Bundle bundle);

    protected void K(AccessibilityEvent accessibilityEvent) {
    }

    protected void L(int i, AccessibilityEvent accessibilityEvent) {
    }

    protected void M(a.g.k.b0.c cVar) {
    }

    protected abstract void N(int i, a.g.k.b0.c cVar);

    protected void O(int i, boolean z) {
    }

    boolean P(int i, int i2, Bundle bundle) {
        return i != -1 ? Q(i, i2, bundle) : R(i2, bundle);
    }

    public final boolean T(int i) {
        int i2;
        if ((this.i.isFocused() || this.i.requestFocus()) && (i2 = this.l) != i) {
            if (i2 != Integer.MIN_VALUE) {
                o(i2);
            }
            if (i == Integer.MIN_VALUE) {
                return false;
            }
            this.l = i;
            O(i, true);
            U(i, 8);
            return true;
        }
        return false;
    }

    public final boolean U(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = this.i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.i, q(i, i2));
    }

    @Override // a.g.k.a
    public d b(View view) {
        if (this.j == null) {
            this.j = new c();
        }
        return this.j;
    }

    @Override // a.g.k.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        K(accessibilityEvent);
    }

    @Override // a.g.k.a
    public void g(View view, a.g.k.b0.c cVar) {
        super.g(view, cVar);
        M(cVar);
    }

    public final boolean o(int i) {
        if (this.l != i) {
            return false;
        }
        this.l = RecyclerView.UNDEFINED_DURATION;
        O(i, false);
        U(i, 8);
        return true;
    }

    public final boolean v(MotionEvent motionEvent) {
        if (this.h.isEnabled() && this.h.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                int B = B(motionEvent.getX(), motionEvent.getY());
                V(B);
                return B != Integer.MIN_VALUE;
            } else if (action == 10 && this.m != Integer.MIN_VALUE) {
                V(RecyclerView.UNDEFINED_DURATION);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public final boolean w(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return G(2, null);
                }
                if (keyEvent.hasModifiers(1)) {
                    return G(1, null);
                }
                return false;
            }
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (keyEvent.hasNoModifiers()) {
                            int F = F(keyCode);
                            int repeatCount = keyEvent.getRepeatCount() + 1;
                            boolean z = false;
                            while (i < repeatCount && G(F, null)) {
                                i++;
                                z = true;
                            }
                            return z;
                        }
                        return false;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                p();
                return true;
            }
            return false;
        }
        return false;
    }

    public final int x() {
        return this.k;
    }
}
