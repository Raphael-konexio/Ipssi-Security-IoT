package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private final l f825a;

    /* renamed from: b  reason: collision with root package name */
    private final Fragment f826b;

    /* renamed from: c  reason: collision with root package name */
    private int f827c = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f828a;

        static {
            int[] iArr = new int[e.b.values().length];
            f828a = iArr;
            try {
                iArr[e.b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f828a[e.b.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f828a[e.b.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, Fragment fragment) {
        this.f825a = lVar;
        this.f826b = fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, Fragment fragment, q qVar) {
        this.f825a = lVar;
        this.f826b = fragment;
        fragment.h = null;
        fragment.v = 0;
        fragment.s = false;
        fragment.p = false;
        Fragment fragment2 = fragment.l;
        fragment.m = fragment2 != null ? fragment2.j : null;
        Fragment fragment3 = this.f826b;
        fragment3.l = null;
        Bundle bundle = qVar.r;
        fragment3.g = bundle == null ? new Bundle() : bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, ClassLoader classLoader, i iVar, q qVar) {
        this.f825a = lVar;
        this.f826b = iVar.a(classLoader, qVar.f);
        Bundle bundle = qVar.o;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        this.f826b.j1(qVar.o);
        Fragment fragment = this.f826b;
        fragment.j = qVar.g;
        fragment.r = qVar.h;
        fragment.t = true;
        fragment.A = qVar.i;
        fragment.B = qVar.j;
        fragment.C = qVar.k;
        fragment.F = qVar.l;
        fragment.q = qVar.m;
        fragment.E = qVar.n;
        fragment.D = qVar.p;
        fragment.U = e.b.values()[qVar.q];
        Bundle bundle2 = qVar.r;
        if (bundle2 != null) {
            this.f826b.g = bundle2;
        } else {
            this.f826b.g = new Bundle();
        }
        if (m.p0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f826b);
        }
    }

    private Bundle n() {
        Bundle bundle = new Bundle();
        this.f826b.Z0(bundle);
        this.f825a.j(this.f826b, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f826b.L != null) {
            p();
        }
        if (this.f826b.h != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f826b.h);
        }
        if (!this.f826b.N) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f826b.N);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f826b);
        }
        Fragment fragment = this.f826b;
        fragment.F0(fragment.g);
        l lVar = this.f825a;
        Fragment fragment2 = this.f826b;
        lVar.a(fragment2, fragment2.g, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j<?> jVar, m mVar, Fragment fragment) {
        Fragment fragment2 = this.f826b;
        fragment2.x = jVar;
        fragment2.z = fragment;
        fragment2.w = mVar;
        this.f825a.g(fragment2, jVar.g(), false);
        this.f826b.G0();
        Fragment fragment3 = this.f826b;
        Fragment fragment4 = fragment3.z;
        if (fragment4 == null) {
            jVar.k(fragment3);
        } else {
            fragment4.c0(fragment3);
        }
        this.f825a.b(this.f826b, jVar.g(), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        int i = this.f827c;
        Fragment fragment = this.f826b;
        if (fragment.r) {
            i = fragment.s ? Math.max(i, 1) : i < 2 ? Math.min(i, fragment.f) : Math.min(i, 1);
        }
        if (!this.f826b.p) {
            i = Math.min(i, 1);
        }
        Fragment fragment2 = this.f826b;
        if (fragment2.q) {
            i = fragment2.S() ? Math.min(i, 1) : Math.min(i, -1);
        }
        Fragment fragment3 = this.f826b;
        if (fragment3.M && fragment3.f < 3) {
            i = Math.min(i, 2);
        }
        int i2 = a.f828a[this.f826b.U.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? Math.min(i, -1) : Math.min(i, 1) : Math.min(i, 3) : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f826b);
        }
        Fragment fragment = this.f826b;
        if (fragment.T) {
            fragment.f1(fragment.g);
            this.f826b.f = 1;
            return;
        }
        this.f825a.h(fragment, fragment.g, false);
        Fragment fragment2 = this.f826b;
        fragment2.J0(fragment2.g);
        l lVar = this.f825a;
        Fragment fragment3 = this.f826b;
        lVar.c(fragment3, fragment3.g, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(f fVar) {
        String str;
        if (this.f826b.r) {
            return;
        }
        if (m.p0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f826b);
        }
        ViewGroup viewGroup = null;
        Fragment fragment = this.f826b;
        ViewGroup viewGroup2 = fragment.K;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = fragment.B;
            if (i != 0) {
                if (i == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f826b + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fVar.c(i);
                if (viewGroup == null) {
                    Fragment fragment2 = this.f826b;
                    if (!fragment2.t) {
                        try {
                            str = fragment2.E().getResourceName(this.f826b.B);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f826b.B) + " (" + str + ") for fragment " + this.f826b);
                    }
                }
            }
        }
        Fragment fragment3 = this.f826b;
        fragment3.K = viewGroup;
        fragment3.L0(fragment3.P0(fragment3.g), viewGroup, this.f826b.g);
        View view = this.f826b.L;
        if (view != null) {
            boolean z = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment4 = this.f826b;
            fragment4.L.setTag(a.j.b.fragment_container_view_tag, fragment4);
            if (viewGroup != null) {
                viewGroup.addView(this.f826b.L);
            }
            Fragment fragment5 = this.f826b;
            if (fragment5.D) {
                fragment5.L.setVisibility(8);
            }
            a.g.k.s.d0(this.f826b.L);
            Fragment fragment6 = this.f826b;
            fragment6.D0(fragment6.L, fragment6.g);
            l lVar = this.f825a;
            Fragment fragment7 = this.f826b;
            lVar.m(fragment7, fragment7.L, fragment7.g, false);
            Fragment fragment8 = this.f826b;
            if (fragment8.L.getVisibility() == 0 && this.f826b.K != null) {
                z = true;
            }
            fragment8.P = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(j<?> jVar, p pVar) {
        if (m.p0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f826b);
        }
        Fragment fragment = this.f826b;
        boolean z = true;
        boolean z2 = fragment.q && !fragment.S();
        if (!(z2 || pVar.n(this.f826b))) {
            this.f826b.f = 0;
            return;
        }
        if (jVar instanceof androidx.lifecycle.w) {
            z = pVar.l();
        } else if (jVar.g() instanceof Activity) {
            z = true ^ ((Activity) jVar.g()).isChangingConfigurations();
        }
        if (z2 || z) {
            pVar.f(this.f826b);
        }
        this.f826b.M0();
        this.f825a.d(this.f826b, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(p pVar) {
        if (m.p0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f826b);
        }
        this.f826b.O0();
        boolean z = false;
        this.f825a.e(this.f826b, false);
        Fragment fragment = this.f826b;
        fragment.f = -1;
        fragment.x = null;
        fragment.z = null;
        fragment.w = null;
        if (fragment.q && !fragment.S()) {
            z = true;
        }
        if (z || pVar.n(this.f826b)) {
            if (m.p0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f826b);
            }
            this.f826b.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        Fragment fragment = this.f826b;
        if (fragment.r && fragment.s && !fragment.u) {
            if (m.p0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f826b);
            }
            Fragment fragment2 = this.f826b;
            fragment2.L0(fragment2.P0(fragment2.g), null, this.f826b.g);
            View view = this.f826b.L;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f826b;
                fragment3.L.setTag(a.j.b.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f826b;
                if (fragment4.D) {
                    fragment4.L.setVisibility(8);
                }
                Fragment fragment5 = this.f826b;
                fragment5.D0(fragment5.L, fragment5.g);
                l lVar = this.f825a;
                Fragment fragment6 = this.f826b;
                lVar.m(fragment6, fragment6.L, fragment6.g, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment i() {
        return this.f826b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f826b);
        }
        this.f826b.U0();
        this.f825a.f(this.f826b, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ClassLoader classLoader) {
        Bundle bundle = this.f826b.g;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f826b;
        fragment.h = fragment.g.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f826b;
        fragment2.m = fragment2.g.getString("android:target_state");
        Fragment fragment3 = this.f826b;
        if (fragment3.m != null) {
            fragment3.n = fragment3.g.getInt("android:target_req_state", 0);
        }
        Fragment fragment4 = this.f826b;
        Boolean bool = fragment4.i;
        if (bool != null) {
            fragment4.N = bool.booleanValue();
            this.f826b.i = null;
        } else {
            fragment4.N = fragment4.g.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment5 = this.f826b;
        if (fragment5.N) {
            return;
        }
        fragment5.M = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this.f826b);
        }
        Fragment fragment = this.f826b;
        if (fragment.L != null) {
            fragment.g1(fragment.g);
        }
        this.f826b.g = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f826b);
        }
        this.f826b.Y0();
        this.f825a.i(this.f826b, false);
        Fragment fragment = this.f826b;
        fragment.g = null;
        fragment.h = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q o() {
        q qVar = new q(this.f826b);
        if (this.f826b.f <= -1 || qVar.r != null) {
            qVar.r = this.f826b.g;
        } else {
            Bundle n = n();
            qVar.r = n;
            if (this.f826b.m != null) {
                if (n == null) {
                    qVar.r = new Bundle();
                }
                qVar.r.putString("android:target_state", this.f826b.m);
                int i = this.f826b.n;
                if (i != 0) {
                    qVar.r.putInt("android:target_req_state", i);
                }
            }
        }
        return qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        if (this.f826b.L == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f826b.L.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f826b.h = sparseArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i) {
        this.f827c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f826b);
        }
        this.f826b.a1();
        this.f825a.k(this.f826b, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f826b);
        }
        this.f826b.b1();
        this.f825a.l(this.f826b, false);
    }
}
