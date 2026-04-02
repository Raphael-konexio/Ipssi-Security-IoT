package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.e;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.j, androidx.lifecycle.w, androidx.savedstate.b {
    static final Object a0 = new Object();
    int A;
    int B;
    String C;
    boolean D;
    boolean E;
    boolean F;
    boolean G;
    boolean H;
    private boolean J;
    ViewGroup K;
    View L;
    boolean M;
    c O;
    boolean P;
    boolean Q;
    float R;
    LayoutInflater S;
    boolean T;
    androidx.lifecycle.k V;
    x W;
    androidx.savedstate.a Y;
    private int Z;
    Bundle g;
    SparseArray<Parcelable> h;
    Boolean i;
    Bundle k;
    Fragment l;
    int n;
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    int v;
    m w;
    j<?> x;
    Fragment z;
    int f = -1;
    String j = UUID.randomUUID().toString();
    String m = null;
    private Boolean o = null;
    m y = new n();
    boolean I = true;
    boolean N = true;
    e.b U = e.b.RESUMED;
    androidx.lifecycle.o<androidx.lifecycle.j> X = new androidx.lifecycle.o<>();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.d();
        }
    }

    /* loaded from: classes.dex */
    class b extends f {
        b() {
        }

        @Override // androidx.fragment.app.f
        public View c(int i) {
            View view = Fragment.this.L;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment " + this + " does not have a view");
        }

        @Override // androidx.fragment.app.f
        public boolean d() {
            return Fragment.this.L != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        View f784a;

        /* renamed from: b  reason: collision with root package name */
        Animator f785b;

        /* renamed from: c  reason: collision with root package name */
        int f786c;

        /* renamed from: d  reason: collision with root package name */
        int f787d;
        int e;
        Object f = null;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        Boolean l;
        Boolean m;
        androidx.core.app.m n;
        androidx.core.app.m o;
        boolean p;
        e q;
        boolean r;

        c() {
            Object obj = Fragment.a0;
            this.g = obj;
            this.h = null;
            this.i = obj;
            this.j = null;
            this.k = obj;
            this.n = null;
            this.o = null;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends RuntimeException {
        public d(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void a();

        void b();
    }

    public Fragment() {
        O();
    }

    private void O() {
        this.V = new androidx.lifecycle.k(this);
        this.Y = androidx.savedstate.a.a(this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.V.a(new androidx.lifecycle.h() { // from class: androidx.fragment.app.Fragment.2
                @Override // androidx.lifecycle.h
                public void d(androidx.lifecycle.j jVar, e.a aVar) {
                    View view;
                    if (aVar != e.a.ON_STOP || (view = Fragment.this.L) == null) {
                        return;
                    }
                    view.cancelPendingInputEvents();
                }
            });
        }
    }

    @Deprecated
    public static Fragment Q(Context context, String str, Bundle bundle) {
        try {
            Fragment newInstance = i.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.j1(bundle);
            }
            return newInstance;
        } catch (IllegalAccessException e2) {
            throw new d("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new d("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new d("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new d("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    private c g() {
        if (this.O == null) {
            this.O = new c();
        }
        return this.O;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int A() {
        c cVar = this.O;
        if (cVar == null) {
            return 0;
        }
        return cVar.e;
    }

    public void A0(Bundle bundle) {
    }

    public final Fragment B() {
        return this.z;
    }

    public void B0() {
        this.J = true;
    }

    public final m C() {
        m mVar = this.w;
        if (mVar != null) {
            return mVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public void C0() {
        this.J = true;
    }

    public Object D() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.i;
        return obj == a0 ? u() : obj;
    }

    public void D0(View view, Bundle bundle) {
    }

    public final Resources E() {
        return d1().getResources();
    }

    public void E0(Bundle bundle) {
        this.J = true;
    }

    public final boolean F() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F0(Bundle bundle) {
        this.y.B0();
        this.f = 2;
        this.J = false;
        Y(bundle);
        if (this.J) {
            this.y.r();
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public Object G() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.g;
        return obj == a0 ? s() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G0() {
        this.y.g(this.x, new b(), this);
        this.f = 0;
        this.J = false;
        b0(this.x.g());
        if (this.J) {
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onAttach()");
    }

    public Object H() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        return cVar.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H0(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.y.s(configuration);
    }

    public Object I() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        Object obj = cVar.k;
        return obj == a0 ? H() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean I0(MenuItem menuItem) {
        if (this.D) {
            return false;
        }
        return d0(menuItem) || this.y.t(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int J() {
        c cVar = this.O;
        if (cVar == null) {
            return 0;
        }
        return cVar.f786c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J0(Bundle bundle) {
        this.y.B0();
        this.f = 1;
        this.J = false;
        this.Y.c(bundle);
        e0(bundle);
        this.T = true;
        if (this.J) {
            this.V.i(e.a.ON_CREATE);
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onCreate()");
    }

    public final String K(int i) {
        return E().getString(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean K0(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.D) {
            return false;
        }
        if (this.H && this.I) {
            z = true;
            h0(menu, menuInflater);
        }
        return z | this.y.v(menu, menuInflater);
    }

    public final String L() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.y.B0();
        this.u = true;
        this.W = new x();
        View i0 = i0(layoutInflater, viewGroup, bundle);
        this.L = i0;
        if (i0 != null) {
            this.W.c();
            this.X.j(this.W);
        } else if (this.W.d()) {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        } else {
            this.W = null;
        }
    }

    public final Fragment M() {
        String str;
        Fragment fragment = this.l;
        if (fragment != null) {
            return fragment;
        }
        m mVar = this.w;
        if (mVar == null || (str = this.m) == null) {
            return null;
        }
        return mVar.V(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M0() {
        this.y.w();
        this.V.i(e.a.ON_DESTROY);
        this.f = 0;
        this.J = false;
        this.T = false;
        j0();
        if (this.J) {
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onDestroy()");
    }

    public View N() {
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N0() {
        this.y.x();
        if (this.L != null) {
            this.W.b(e.a.ON_DESTROY);
        }
        this.f = 1;
        this.J = false;
        l0();
        if (this.J) {
            a.l.a.a.b(this).c();
            this.u = false;
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0() {
        this.f = -1;
        this.J = false;
        m0();
        this.S = null;
        if (this.J) {
            if (this.y.o0()) {
                return;
            }
            this.y.w();
            this.y = new n();
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onDetach()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P() {
        O();
        this.j = UUID.randomUUID().toString();
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.v = 0;
        this.w = null;
        this.y = new n();
        this.x = null;
        this.A = 0;
        this.B = 0;
        this.C = null;
        this.D = false;
        this.E = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater P0(Bundle bundle) {
        LayoutInflater n0 = n0(bundle);
        this.S = n0;
        return n0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q0() {
        onLowMemory();
        this.y.y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean R() {
        c cVar = this.O;
        if (cVar == null) {
            return false;
        }
        return cVar.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R0(boolean z) {
        r0(z);
        this.y.z(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean S() {
        return this.v > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean S0(MenuItem menuItem) {
        if (this.D) {
            return false;
        }
        return (this.H && this.I && s0(menuItem)) || this.y.A(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean T() {
        c cVar = this.O;
        if (cVar == null) {
            return false;
        }
        return cVar.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T0(Menu menu) {
        if (this.D) {
            return;
        }
        if (this.H && this.I) {
            t0(menu);
        }
        this.y.B(menu);
    }

    public final boolean U() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U0() {
        this.y.D();
        if (this.L != null) {
            this.W.b(e.a.ON_PAUSE);
        }
        this.V.i(e.a.ON_PAUSE);
        this.f = 3;
        this.J = false;
        u0();
        if (this.J) {
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onPause()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean V() {
        Fragment B = B();
        return B != null && (B.U() || B.V());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V0(boolean z) {
        v0(z);
        this.y.E(z);
    }

    public final boolean W() {
        m mVar = this.w;
        if (mVar == null) {
            return false;
        }
        return mVar.t0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean W0(Menu menu) {
        boolean z = false;
        if (this.D) {
            return false;
        }
        if (this.H && this.I) {
            z = true;
            w0(menu);
        }
        return z | this.y.F(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X() {
        this.y.B0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X0() {
        boolean r0 = this.w.r0(this);
        Boolean bool = this.o;
        if (bool == null || bool.booleanValue() != r0) {
            this.o = Boolean.valueOf(r0);
            x0(r0);
            this.y.G();
        }
    }

    public void Y(Bundle bundle) {
        this.J = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y0() {
        this.y.B0();
        this.y.Q(true);
        this.f = 4;
        this.J = false;
        z0();
        if (this.J) {
            this.V.i(e.a.ON_RESUME);
            if (this.L != null) {
                this.W.b(e.a.ON_RESUME);
            }
            this.y.H();
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onResume()");
    }

    public void Z(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z0(Bundle bundle) {
        A0(bundle);
        this.Y.d(bundle);
        Parcelable Q0 = this.y.Q0();
        if (Q0 != null) {
            bundle.putParcelable("android:support:fragments", Q0);
        }
    }

    @Override // androidx.lifecycle.j
    public androidx.lifecycle.e a() {
        return this.V;
    }

    @Deprecated
    public void a0(Activity activity) {
        this.J = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a1() {
        this.y.B0();
        this.y.Q(true);
        this.f = 3;
        this.J = false;
        B0();
        if (this.J) {
            this.V.i(e.a.ON_START);
            if (this.L != null) {
                this.W.b(e.a.ON_START);
            }
            this.y.I();
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onStart()");
    }

    public void b0(Context context) {
        this.J = true;
        j<?> jVar = this.x;
        Activity e2 = jVar == null ? null : jVar.e();
        if (e2 != null) {
            this.J = false;
            a0(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b1() {
        this.y.K();
        if (this.L != null) {
            this.W.b(e.a.ON_STOP);
        }
        this.V.i(e.a.ON_STOP);
        this.f = 2;
        this.J = false;
        C0();
        if (this.J) {
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onStop()");
    }

    public void c0(Fragment fragment) {
    }

    public final androidx.fragment.app.d c1() {
        androidx.fragment.app.d k = k();
        if (k != null) {
            return k;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    void d() {
        c cVar = this.O;
        e eVar = null;
        if (cVar != null) {
            cVar.p = false;
            e eVar2 = cVar.q;
            cVar.q = null;
            eVar = eVar2;
        }
        if (eVar != null) {
            eVar.a();
        }
    }

    public boolean d0(MenuItem menuItem) {
        return false;
    }

    public final Context d1() {
        Context r = r();
        if (r != null) {
            return r;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.A));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.B));
        printWriter.print(" mTag=");
        printWriter.println(this.C);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f);
        printWriter.print(" mWho=");
        printWriter.print(this.j);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.v);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.p);
        printWriter.print(" mRemoving=");
        printWriter.print(this.q);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.r);
        printWriter.print(" mInLayout=");
        printWriter.println(this.s);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.D);
        printWriter.print(" mDetached=");
        printWriter.print(this.E);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.I);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.H);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.F);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.N);
        if (this.w != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.w);
        }
        if (this.x != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.x);
        }
        if (this.z != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.z);
        }
        if (this.k != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.k);
        }
        if (this.g != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.g);
        }
        if (this.h != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.h);
        }
        Fragment M = M();
        if (M != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(M);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.n);
        }
        if (z() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(z());
        }
        if (this.K != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.K);
        }
        if (this.L != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.L);
        }
        if (n() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(n());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(J());
        }
        if (r() != null) {
            a.l.a.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.y + ":");
        m mVar = this.y;
        mVar.M(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public void e0(Bundle bundle) {
        this.J = true;
        f1(bundle);
        if (this.y.s0(1)) {
            return;
        }
        this.y.u();
    }

    public final View e1() {
        View N = N();
        if (N != null) {
            return N;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // androidx.lifecycle.w
    public androidx.lifecycle.v f() {
        m mVar = this.w;
        if (mVar != null) {
            return mVar.l0(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public Animation f0(int i, boolean z, int i2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f1(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.y.O0(parcelable);
        this.y.u();
    }

    public Animator g0(int i, boolean z, int i2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.h;
        if (sparseArray != null) {
            this.L.restoreHierarchyState(sparseArray);
            this.h = null;
        }
        this.J = false;
        E0(bundle);
        if (this.J) {
            if (this.L != null) {
                this.W.b(e.a.ON_CREATE);
                return;
            }
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment h(String str) {
        return str.equals(this.j) ? this : this.y.Y(str);
    }

    public void h0(Menu menu, MenuInflater menuInflater) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h1(View view) {
        g().f784a = view;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public View i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.Z;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i1(Animator animator) {
        g().f785b = animator;
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry j() {
        return this.Y.b();
    }

    public void j0() {
        this.J = true;
    }

    public void j1(Bundle bundle) {
        if (this.w != null && W()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.k = bundle;
    }

    public final androidx.fragment.app.d k() {
        j<?> jVar = this.x;
        if (jVar == null) {
            return null;
        }
        return (androidx.fragment.app.d) jVar.e();
    }

    public void k0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k1(boolean z) {
        g().r = z;
    }

    public boolean l() {
        Boolean bool;
        c cVar = this.O;
        if (cVar == null || (bool = cVar.m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void l0() {
        this.J = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l1(int i) {
        if (this.O == null && i == 0) {
            return;
        }
        g().f787d = i;
    }

    public boolean m() {
        Boolean bool;
        c cVar = this.O;
        if (cVar == null || (bool = cVar.l) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void m0() {
        this.J = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m1(int i) {
        if (this.O == null && i == 0) {
            return;
        }
        g();
        this.O.e = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View n() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        return cVar.f784a;
    }

    public LayoutInflater n0(Bundle bundle) {
        return y(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n1(e eVar) {
        g();
        e eVar2 = this.O.q;
        if (eVar == eVar2) {
            return;
        }
        if (eVar != null && eVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        c cVar = this.O;
        if (cVar.p) {
            cVar.q = eVar;
        }
        if (eVar != null) {
            eVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Animator o() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        return cVar.f785b;
    }

    public void o0(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o1(int i) {
        g().f786c = i;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.J = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        c1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.J = true;
    }

    public final Bundle p() {
        return this.k;
    }

    @Deprecated
    public void p0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.J = true;
    }

    public void p1() {
        m mVar = this.w;
        if (mVar == null || mVar.o == null) {
            g().p = false;
        } else if (Looper.myLooper() != this.w.o.h().getLooper()) {
            this.w.o.h().postAtFrontOfQueue(new a());
        } else {
            d();
        }
    }

    public final m q() {
        if (this.x != null) {
            return this.y;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public void q0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.J = true;
        j<?> jVar = this.x;
        Activity e2 = jVar == null ? null : jVar.e();
        if (e2 != null) {
            this.J = false;
            p0(e2, attributeSet, bundle);
        }
    }

    public Context r() {
        j<?> jVar = this.x;
        if (jVar == null) {
            return null;
        }
        return jVar.g();
    }

    public void r0(boolean z) {
    }

    public Object s() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        return cVar.f;
    }

    public boolean s0(MenuItem menuItem) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.core.app.m t() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        return cVar.n;
    }

    public void t0(Menu menu) {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.j);
        sb.append(")");
        if (this.A != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.A));
        }
        if (this.C != null) {
            sb.append(" ");
            sb.append(this.C);
        }
        sb.append('}');
        return sb.toString();
    }

    public Object u() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        return cVar.h;
    }

    public void u0() {
        this.J = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.core.app.m v() {
        c cVar = this.O;
        if (cVar == null) {
            return null;
        }
        return cVar.o;
    }

    public void v0(boolean z) {
    }

    public final Object w() {
        j<?> jVar = this.x;
        if (jVar == null) {
            return null;
        }
        return jVar.l();
    }

    public void w0(Menu menu) {
    }

    public final int x() {
        return this.A;
    }

    public void x0(boolean z) {
    }

    @Deprecated
    public LayoutInflater y(Bundle bundle) {
        j<?> jVar = this.x;
        if (jVar != null) {
            LayoutInflater m = jVar.m();
            a.g.k.f.b(m, this.y.g0());
            return m;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void y0(int i, String[] strArr, int[] iArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int z() {
        c cVar = this.O;
        if (cVar == null) {
            return 0;
        }
        return cVar.f787d;
    }

    public void z0() {
        this.J = true;
    }
}
