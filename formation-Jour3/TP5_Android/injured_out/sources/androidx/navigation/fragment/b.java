package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.g;
import androidx.fragment.app.t;
import androidx.navigation.NavController;
import androidx.navigation.fragment.a;
import androidx.navigation.m;
import androidx.navigation.q;
import androidx.navigation.r;
import androidx.navigation.u;
/* loaded from: classes.dex */
public class b extends Fragment {
    private m b0;
    private Boolean c0 = null;
    private View d0;
    private int e0;
    private boolean f0;

    public static NavController r1(Fragment fragment) {
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.B()) {
            if (fragment2 instanceof b) {
                return ((b) fragment2).t1();
            }
            Fragment j0 = fragment2.C().j0();
            if (j0 instanceof b) {
                return ((b) j0).t1();
            }
        }
        View N = fragment.N();
        if (N != null) {
            return q.a(N);
        }
        Dialog u1 = fragment instanceof androidx.fragment.app.c ? ((androidx.fragment.app.c) fragment).u1() : null;
        if (u1 == null || u1.getWindow() == null) {
            throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
        }
        return q.a(u1.getWindow().getDecorView());
    }

    private int s1() {
        int x = x();
        return (x == 0 || x == -1) ? c.nav_host_fragment_container : x;
    }

    @Override // androidx.fragment.app.Fragment
    public void A0(Bundle bundle) {
        super.A0(bundle);
        Bundle q = this.b0.q();
        if (q != null) {
            bundle.putBundle("android-support-nav:fragment:navControllerState", q);
        }
        if (this.f0) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
        int i = this.e0;
        if (i != 0) {
            bundle.putInt("android-support-nav:fragment:graphId", i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void D0(View view, Bundle bundle) {
        super.D0(view, bundle);
        if (!(view instanceof ViewGroup)) {
            throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
        }
        q.d(view, this.b0);
        if (view.getParent() != null) {
            View view2 = (View) view.getParent();
            this.d0 = view2;
            if (view2.getId() == x()) {
                q.d(this.d0, this.b0);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void b0(Context context) {
        super.b0(context);
        if (this.f0) {
            t i = C().i();
            i.r(this);
            i.h();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void c0(Fragment fragment) {
        super.c0(fragment);
        ((DialogFragmentNavigator) this.b0.i().d(DialogFragmentNavigator.class)).h(fragment);
    }

    @Override // androidx.fragment.app.Fragment
    public void e0(Bundle bundle) {
        Bundle bundle2;
        m mVar = new m(d1());
        this.b0 = mVar;
        mVar.u(this);
        this.b0.v(c1().i());
        m mVar2 = this.b0;
        Boolean bool = this.c0;
        mVar2.b(bool != null && bool.booleanValue());
        this.c0 = null;
        this.b0.w(f());
        u1(this.b0);
        if (bundle != null) {
            bundle2 = bundle.getBundle("android-support-nav:fragment:navControllerState");
            if (bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
                this.f0 = true;
                t i = C().i();
                i.r(this);
                i.h();
            }
            this.e0 = bundle.getInt("android-support-nav:fragment:graphId");
        } else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            this.b0.p(bundle2);
        }
        int i2 = this.e0;
        if (i2 != 0) {
            this.b0.r(i2);
        } else {
            Bundle p = p();
            int i3 = p != null ? p.getInt("android-support-nav:fragment:graphId") : 0;
            Bundle bundle3 = p != null ? p.getBundle("android-support-nav:fragment:startDestinationArgs") : null;
            if (i3 != 0) {
                this.b0.s(i3, bundle3);
            }
        }
        super.e0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        g gVar = new g(layoutInflater.getContext());
        gVar.setId(s1());
        return gVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void l0() {
        super.l0();
        View view = this.d0;
        if (view != null && q.a(view) == this.b0) {
            q.d(this.d0, null);
        }
        this.d0 = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void q0(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.q0(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u.NavHost);
        int resourceId = obtainStyledAttributes.getResourceId(u.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.e0 = resourceId;
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, d.NavHostFragment);
        if (obtainStyledAttributes2.getBoolean(d.NavHostFragment_defaultNavHost, false)) {
            this.f0 = true;
        }
        obtainStyledAttributes2.recycle();
    }

    @Deprecated
    protected r<? extends a.C0047a> q1() {
        return new a(d1(), q(), s1());
    }

    public final NavController t1() {
        m mVar = this.b0;
        if (mVar != null) {
            return mVar;
        }
        throw new IllegalStateException("NavController is not available before onCreate()");
    }

    protected void u1(NavController navController) {
        navController.i().a(new DialogFragmentNavigator(d1(), q()));
        navController.i().a(q1());
    }

    @Override // androidx.fragment.app.Fragment
    public void x0(boolean z) {
        m mVar = this.b0;
        if (mVar != null) {
            mVar.b(z);
        } else {
            this.c0 = Boolean.valueOf(z);
        }
    }
}
