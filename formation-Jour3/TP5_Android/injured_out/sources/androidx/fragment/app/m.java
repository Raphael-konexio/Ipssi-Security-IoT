package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.u;
import androidx.lifecycle.e;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class m {
    private static boolean F = false;
    private ArrayList<Boolean> A;
    private ArrayList<Fragment> B;
    private ArrayList<j> C;
    private p D;

    /* renamed from: b  reason: collision with root package name */
    private boolean f806b;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f808d;
    private ArrayList<Fragment> e;
    private OnBackPressedDispatcher g;
    private ArrayList<g> j;
    androidx.fragment.app.j<?> o;
    androidx.fragment.app.f p;
    private Fragment q;
    Fragment r;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private ArrayList<androidx.fragment.app.a> z;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<h> f805a = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final s f807c = new s();
    private final k f = new k(this);
    private final androidx.activity.b h = new a(false);
    private final AtomicInteger i = new AtomicInteger();
    private ConcurrentHashMap<Fragment, HashSet<a.g.g.b>> k = new ConcurrentHashMap<>();
    private final u.g l = new b();
    private final l m = new l(this);
    int n = -1;
    private androidx.fragment.app.i s = null;
    private androidx.fragment.app.i t = new c();
    private Runnable E = new d();

    /* loaded from: classes.dex */
    class a extends androidx.activity.b {
        a(boolean z) {
            super(z);
        }

        @Override // androidx.activity.b
        public void b() {
            m.this.m0();
        }
    }

    /* loaded from: classes.dex */
    class b implements u.g {
        b() {
        }

        @Override // androidx.fragment.app.u.g
        public void a(Fragment fragment, a.g.g.b bVar) {
            if (bVar.b()) {
                return;
            }
            m.this.J0(fragment, bVar);
        }

        @Override // androidx.fragment.app.u.g
        public void b(Fragment fragment, a.g.g.b bVar) {
            m.this.c(fragment, bVar);
        }
    }

    /* loaded from: classes.dex */
    class c extends androidx.fragment.app.i {
        c() {
        }

        @Override // androidx.fragment.app.i
        public Fragment a(ClassLoader classLoader, String str) {
            androidx.fragment.app.j<?> jVar = m.this.o;
            return jVar.b(jVar.g(), str, null);
        }
    }

    /* loaded from: classes.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.Q(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f812a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f813b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f814c;

        e(m mVar, ViewGroup viewGroup, View view, Fragment fragment) {
            this.f812a = viewGroup;
            this.f813b = view;
            this.f814c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f812a.endViewTransition(this.f813b);
            animator.removeListener(this);
            Fragment fragment = this.f814c;
            View view = fragment.L;
            if (view == null || !fragment.D) {
                return;
            }
            view.setVisibility(8);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {
        public abstract void a(m mVar, Fragment fragment, Bundle bundle);

        public abstract void b(m mVar, Fragment fragment, Context context);

        public abstract void c(m mVar, Fragment fragment, Bundle bundle);

        public abstract void d(m mVar, Fragment fragment);

        public abstract void e(m mVar, Fragment fragment);

        public abstract void f(m mVar, Fragment fragment);

        public abstract void g(m mVar, Fragment fragment, Context context);

        public abstract void h(m mVar, Fragment fragment, Bundle bundle);

        public abstract void i(m mVar, Fragment fragment);

        public abstract void j(m mVar, Fragment fragment, Bundle bundle);

        public abstract void k(m mVar, Fragment fragment);

        public abstract void l(m mVar, Fragment fragment);

        public abstract void m(m mVar, Fragment fragment, View view, Bundle bundle);

        public abstract void n(m mVar, Fragment fragment);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface h {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: classes.dex */
    private class i implements h {

        /* renamed from: a  reason: collision with root package name */
        final String f815a;

        /* renamed from: b  reason: collision with root package name */
        final int f816b;

        /* renamed from: c  reason: collision with root package name */
        final int f817c;

        i(String str, int i, int i2) {
            this.f815a = str;
            this.f816b = i;
            this.f817c = i2;
        }

        @Override // androidx.fragment.app.m.h
        public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = m.this.r;
            if (fragment == null || this.f816b >= 0 || this.f815a != null || !fragment.q().F0()) {
                return m.this.H0(arrayList, arrayList2, this.f815a, this.f816b, this.f817c);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class j implements Fragment.e {

        /* renamed from: a  reason: collision with root package name */
        final boolean f819a;

        /* renamed from: b  reason: collision with root package name */
        final androidx.fragment.app.a f820b;

        /* renamed from: c  reason: collision with root package name */
        private int f821c;

        j(androidx.fragment.app.a aVar, boolean z) {
            this.f819a = z;
            this.f820b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.e
        public void a() {
            int i = this.f821c - 1;
            this.f821c = i;
            if (i != 0) {
                return;
            }
            this.f820b.r.R0();
        }

        @Override // androidx.fragment.app.Fragment.e
        public void b() {
            this.f821c++;
        }

        void c() {
            androidx.fragment.app.a aVar = this.f820b;
            aVar.r.n(aVar, this.f819a, false, false);
        }

        void d() {
            boolean z = this.f821c > 0;
            for (Fragment fragment : this.f820b.r.f0()) {
                fragment.n1(null);
                if (z && fragment.T()) {
                    fragment.p1();
                }
            }
            androidx.fragment.app.a aVar = this.f820b;
            aVar.r.n(aVar, this.f819a, !z, true);
        }

        public boolean e() {
            return this.f821c == 0;
        }
    }

    private void C(Fragment fragment) {
        if (fragment == null || !fragment.equals(V(fragment.j))) {
            return;
        }
        fragment.X0();
    }

    private boolean G0(String str, int i2, int i3) {
        Q(false);
        P(true);
        Fragment fragment = this.r;
        if (fragment == null || i2 >= 0 || str != null || !fragment.q().F0()) {
            boolean H0 = H0(this.z, this.A, str, i2, i3);
            if (H0) {
                this.f806b = true;
                try {
                    L0(this.z, this.A);
                } finally {
                    m();
                }
            }
            Y0();
            L();
            this.f807c.b();
            return H0;
        }
        return true;
    }

    private int I0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, a.d.b<Fragment> bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            androidx.fragment.app.a aVar = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (aVar.E() && !aVar.C(arrayList, i5 + 1, i3)) {
                if (this.C == null) {
                    this.C = new ArrayList<>();
                }
                j jVar = new j(aVar, booleanValue);
                this.C.add(jVar);
                aVar.G(jVar);
                if (booleanValue) {
                    aVar.x();
                } else {
                    aVar.y(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                a(bVar);
            }
        }
        return i4;
    }

    private void J(int i2) {
        try {
            this.f806b = true;
            this.f807c.d(i2);
            y0(i2, false);
            this.f806b = false;
            Q(true);
        } catch (Throwable th) {
            this.f806b = false;
            throw th;
        }
    }

    private void L() {
        if (this.y) {
            this.y = false;
            X0();
        }
    }

    private void L0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        U(arrayList, arrayList2);
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!arrayList.get(i2).p) {
                if (i3 != i2) {
                    T(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (arrayList2.get(i2).booleanValue()) {
                    while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).p) {
                        i3++;
                    }
                }
                T(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 != size) {
            T(arrayList, arrayList2, i3, size);
        }
    }

    private void N() {
        if (this.k.isEmpty()) {
            return;
        }
        for (Fragment fragment : this.k.keySet()) {
            j(fragment);
            A0(fragment, fragment.J());
        }
    }

    private void N0() {
        if (this.j != null) {
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                this.j.get(i2).a();
            }
        }
    }

    private void P(boolean z) {
        if (this.f806b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.o == null) {
            if (!this.x) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        } else if (Looper.myLooper() != this.o.h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                l();
            }
            if (this.z == null) {
                this.z = new ArrayList<>();
                this.A = new ArrayList<>();
            }
            this.f806b = true;
            try {
                U(null, null);
            } finally {
                this.f806b = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int P0(int i2) {
        if (i2 != 4097) {
            if (i2 != 4099) {
                return i2 != 8194 ? 0 : 4097;
            }
            return 4099;
        }
        return 8194;
    }

    private static void S(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            androidx.fragment.app.a aVar = arrayList.get(i2);
            if (arrayList2.get(i2).booleanValue()) {
                aVar.t(-1);
                aVar.y(i2 == i3 + (-1));
            } else {
                aVar.t(1);
                aVar.x();
            }
            i2++;
        }
    }

    private void T(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        int i5 = i2;
        boolean z = arrayList.get(i5).p;
        ArrayList<Fragment> arrayList3 = this.B;
        if (arrayList3 == null) {
            this.B = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.B.addAll(this.f807c.m());
        Fragment j0 = j0();
        boolean z2 = false;
        for (int i6 = i5; i6 < i3; i6++) {
            androidx.fragment.app.a aVar = arrayList.get(i6);
            j0 = !arrayList2.get(i6).booleanValue() ? aVar.z(this.B, j0) : aVar.H(this.B, j0);
            z2 = z2 || aVar.g;
        }
        this.B.clear();
        if (!z) {
            u.C(this, arrayList, arrayList2, i2, i3, false, this.l);
        }
        S(arrayList, arrayList2, i2, i3);
        if (z) {
            a.d.b<Fragment> bVar = new a.d.b<>();
            a(bVar);
            int I0 = I0(arrayList, arrayList2, i2, i3, bVar);
            w0(bVar);
            i4 = I0;
        } else {
            i4 = i3;
        }
        if (i4 != i5 && z) {
            u.C(this, arrayList, arrayList2, i2, i4, true, this.l);
            y0(this.n, true);
        }
        while (i5 < i3) {
            androidx.fragment.app.a aVar2 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && aVar2.t >= 0) {
                aVar2.t = -1;
            }
            aVar2.F();
            i5++;
        }
        if (z2) {
            N0();
        }
    }

    private void U(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<j> arrayList3 = this.C;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            j jVar = this.C.get(i2);
            if (arrayList == null || jVar.f819a || (indexOf2 = arrayList.indexOf(jVar.f820b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf2).booleanValue()) {
                if (jVar.e() || (arrayList != null && jVar.f820b.C(arrayList, 0, arrayList.size()))) {
                    this.C.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || jVar.f819a || (indexOf = arrayList.indexOf(jVar.f820b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                        jVar.d();
                    }
                }
                i2++;
            } else {
                this.C.remove(i2);
                i2--;
                size--;
            }
            jVar.c();
            i2++;
        }
    }

    private void V0(Fragment fragment) {
        ViewGroup d0 = d0(fragment);
        if (d0 != null) {
            if (d0.getTag(a.j.b.visible_removing_fragment_view_tag) == null) {
                d0.setTag(a.j.b.visible_removing_fragment_view_tag, fragment);
            }
            ((Fragment) d0.getTag(a.j.b.visible_removing_fragment_view_tag)).l1(fragment.z());
        }
    }

    private void X0() {
        for (Fragment fragment : this.f807c.k()) {
            if (fragment != null) {
                C0(fragment);
            }
        }
    }

    private void Y0() {
        synchronized (this.f805a) {
            boolean z = true;
            if (this.f805a.isEmpty()) {
                this.h.f((b0() <= 0 || !r0(this.q)) ? false : false);
            } else {
                this.h.f(true);
            }
        }
    }

    private void Z() {
        if (this.C != null) {
            while (!this.C.isEmpty()) {
                this.C.remove(0).d();
            }
        }
    }

    private void a(a.d.b<Fragment> bVar) {
        int i2 = this.n;
        if (i2 < 1) {
            return;
        }
        int min = Math.min(i2, 3);
        for (Fragment fragment : this.f807c.m()) {
            if (fragment.f < min) {
                A0(fragment, min);
                if (fragment.L != null && !fragment.D && fragment.P) {
                    bVar.add(fragment);
                }
            }
        }
    }

    private boolean a0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f805a) {
            if (this.f805a.isEmpty()) {
                return false;
            }
            int size = this.f805a.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                z |= this.f805a.get(i2).a(arrayList, arrayList2);
            }
            this.f805a.clear();
            this.o.h().removeCallbacks(this.E);
            return z;
        }
    }

    private p c0(Fragment fragment) {
        return this.D.h(fragment);
    }

    private ViewGroup d0(Fragment fragment) {
        if (fragment.B > 0 && this.p.d()) {
            View c2 = this.p.c(fragment.B);
            if (c2 instanceof ViewGroup) {
                return (ViewGroup) c2;
            }
        }
        return null;
    }

    private void j(Fragment fragment) {
        HashSet<a.g.g.b> hashSet = this.k.get(fragment);
        if (hashSet != null) {
            Iterator<a.g.g.b> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            p(fragment);
            this.k.remove(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Fragment k0(View view) {
        Object tag = view.getTag(a.j.b.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    private void l() {
        if (t0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void m() {
        this.f806b = false;
        this.A.clear();
        this.z.clear();
    }

    private void o(Fragment fragment) {
        Animator animator;
        if (fragment.L != null) {
            e.d b2 = androidx.fragment.app.e.b(this.o.g(), this.p, fragment, !fragment.D);
            if (b2 == null || (animator = b2.f798b) == null) {
                if (b2 != null) {
                    fragment.L.startAnimation(b2.f797a);
                    b2.f797a.start();
                }
                fragment.L.setVisibility((!fragment.D || fragment.R()) ? 0 : 8);
                if (fragment.R()) {
                    fragment.k1(false);
                }
            } else {
                animator.setTarget(fragment.L);
                if (!fragment.D) {
                    fragment.L.setVisibility(0);
                } else if (fragment.R()) {
                    fragment.k1(false);
                } else {
                    ViewGroup viewGroup = fragment.K;
                    View view = fragment.L;
                    viewGroup.startViewTransition(view);
                    b2.f798b.addListener(new e(this, viewGroup, view, fragment));
                }
                b2.f798b.start();
            }
        }
        if (fragment.p && q0(fragment)) {
            this.u = true;
        }
        fragment.Q = false;
        fragment.o0(fragment.D);
    }

    private void p(Fragment fragment) {
        fragment.N0();
        this.m.n(fragment, false);
        fragment.K = null;
        fragment.L = null;
        fragment.W = null;
        fragment.X.j(null);
        fragment.s = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean p0(int i2) {
        return F || Log.isLoggable("FragmentManager", i2);
    }

    private boolean q0(Fragment fragment) {
        return (fragment.H && fragment.I) || fragment.y.k();
    }

    private void v0(r rVar) {
        Fragment i2 = rVar.i();
        if (this.f807c.c(i2.j)) {
            if (p0(2)) {
                Log.v("FragmentManager", "Removed fragment from active set " + i2);
            }
            this.f807c.o(rVar);
            M0(i2);
        }
    }

    private void w0(a.d.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment s = bVar.s(i2);
            if (!s.p) {
                View e1 = s.e1();
                s.R = e1.getAlpha();
                e1.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A(MenuItem menuItem) {
        if (this.n < 1) {
            return false;
        }
        for (Fragment fragment : this.f807c.m()) {
            if (fragment != null && fragment.S0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        if (r2 != 3) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0(androidx.fragment.app.Fragment r13, int r14) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.m.A0(androidx.fragment.app.Fragment, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(Menu menu) {
        if (this.n < 1) {
            return;
        }
        for (Fragment fragment : this.f807c.m()) {
            if (fragment != null) {
                fragment.T0(menu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B0() {
        if (this.o == null) {
            return;
        }
        this.v = false;
        this.w = false;
        for (Fragment fragment : this.f807c.m()) {
            if (fragment != null) {
                fragment.X();
            }
        }
    }

    void C0(Fragment fragment) {
        if (fragment.M) {
            if (this.f806b) {
                this.y = true;
                return;
            }
            fragment.M = false;
            A0(fragment, this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D() {
        J(3);
    }

    public void D0(int i2, int i3) {
        if (i2 >= 0) {
            O(new i(null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(boolean z) {
        for (Fragment fragment : this.f807c.m()) {
            if (fragment != null) {
                fragment.V0(z);
            }
        }
    }

    public void E0(String str, int i2) {
        O(new i(str, -1, i2), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F(Menu menu) {
        boolean z = false;
        if (this.n < 1) {
            return false;
        }
        for (Fragment fragment : this.f807c.m()) {
            if (fragment != null && fragment.W0(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean F0() {
        return G0(null, -1, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G() {
        Y0();
        C(this.r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H() {
        this.v = false;
        this.w = false;
        J(4);
    }

    boolean H0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<androidx.fragment.app.a> arrayList3 = this.f808d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f808d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = this.f808d.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = this.f808d.get(size2);
                    if ((str != null && str.equals(aVar.A())) || (i2 >= 0 && i2 == aVar.t)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        androidx.fragment.app.a aVar2 = this.f808d.get(size2);
                        if (str == null || !str.equals(aVar2.A())) {
                            if (i2 < 0 || i2 != aVar2.t) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.f808d.size() - 1) {
                return false;
            }
            for (int size3 = this.f808d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f808d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I() {
        this.v = false;
        this.w = false;
        J(3);
    }

    void J0(Fragment fragment, a.g.g.b bVar) {
        HashSet<a.g.g.b> hashSet = this.k.get(fragment);
        if (hashSet != null && hashSet.remove(bVar) && hashSet.isEmpty()) {
            this.k.remove(fragment);
            if (fragment.f < 3) {
                p(fragment);
                A0(fragment, fragment.J());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K() {
        this.w = true;
        J(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K0(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.v);
        }
        boolean z = !fragment.S();
        if (!fragment.E || z) {
            this.f807c.p(fragment);
            if (q0(fragment)) {
                this.u = true;
            }
            fragment.q = true;
            V0(fragment);
        }
    }

    public void M(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f807c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.e.get(i2).toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.f808d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                androidx.fragment.app.a aVar = this.f808d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.v(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.f805a) {
            int size3 = this.f805a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i4 = 0; i4 < size3; i4++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(this.f805a.get(i4));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.p);
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.v);
        printWriter.print(" mStopped=");
        printWriter.print(this.w);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.x);
        if (this.u) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.u);
        }
    }

    void M0(Fragment fragment) {
        if (t0()) {
            if (p0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.D.m(fragment) && p0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(h hVar, boolean z) {
        if (!z) {
            if (this.o == null) {
                if (!this.x) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            l();
        }
        synchronized (this.f805a) {
            if (this.o == null) {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
                return;
            }
            this.f805a.add(hVar);
            R0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0(Parcelable parcelable) {
        r rVar;
        if (parcelable == null) {
            return;
        }
        o oVar = (o) parcelable;
        if (oVar.f == null) {
            return;
        }
        this.f807c.q();
        Iterator<q> it = oVar.f.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if (next != null) {
                Fragment g2 = this.D.g(next.g);
                if (g2 != null) {
                    if (p0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + g2);
                    }
                    rVar = new r(this.m, g2, next);
                } else {
                    rVar = new r(this.m, this.o.g().getClassLoader(), e0(), next);
                }
                Fragment i2 = rVar.i();
                i2.w = this;
                if (p0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + i2.j + "): " + i2);
                }
                rVar.k(this.o.g().getClassLoader());
                this.f807c.n(rVar);
                rVar.q(this.n);
            }
        }
        for (Fragment fragment : this.D.j()) {
            if (!this.f807c.c(fragment.j)) {
                if (p0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + oVar.f);
                }
                A0(fragment, 1);
                fragment.q = true;
                A0(fragment, -1);
            }
        }
        this.f807c.r(oVar.g);
        if (oVar.h != null) {
            this.f808d = new ArrayList<>(oVar.h.length);
            int i3 = 0;
            while (true) {
                androidx.fragment.app.b[] bVarArr = oVar.h;
                if (i3 >= bVarArr.length) {
                    break;
                }
                androidx.fragment.app.a a2 = bVarArr[i3].a(this);
                if (p0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i3 + " (index " + a2.t + "): " + a2);
                    PrintWriter printWriter = new PrintWriter(new a.g.j.c("FragmentManager"));
                    a2.w("  ", printWriter, false);
                    printWriter.close();
                }
                this.f808d.add(a2);
                i3++;
            }
        } else {
            this.f808d = null;
        }
        this.i.set(oVar.i);
        String str = oVar.j;
        if (str != null) {
            Fragment V = V(str);
            this.r = V;
            C(V);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Q(boolean z) {
        P(z);
        boolean z2 = false;
        while (a0(this.z, this.A)) {
            this.f806b = true;
            try {
                L0(this.z, this.A);
                m();
                z2 = true;
            } catch (Throwable th) {
                m();
                throw th;
            }
        }
        Y0();
        L();
        this.f807c.b();
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable Q0() {
        int size;
        Z();
        N();
        Q(true);
        this.v = true;
        ArrayList<q> s = this.f807c.s();
        androidx.fragment.app.b[] bVarArr = null;
        if (s.isEmpty()) {
            if (p0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> t = this.f807c.t();
        ArrayList<androidx.fragment.app.a> arrayList = this.f808d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            bVarArr = new androidx.fragment.app.b[size];
            for (int i2 = 0; i2 < size; i2++) {
                bVarArr[i2] = new androidx.fragment.app.b(this.f808d.get(i2));
                if (p0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f808d.get(i2));
                }
            }
        }
        o oVar = new o();
        oVar.f = s;
        oVar.g = t;
        oVar.h = bVarArr;
        oVar.i = this.i.get();
        Fragment fragment = this.r;
        if (fragment != null) {
            oVar.j = fragment.j;
        }
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(h hVar, boolean z) {
        if (z && (this.o == null || this.x)) {
            return;
        }
        P(z);
        if (hVar.a(this.z, this.A)) {
            this.f806b = true;
            try {
                L0(this.z, this.A);
            } finally {
                m();
            }
        }
        Y0();
        L();
        this.f807c.b();
    }

    void R0() {
        synchronized (this.f805a) {
            boolean z = (this.C == null || this.C.isEmpty()) ? false : true;
            boolean z2 = this.f805a.size() == 1;
            if (z || z2) {
                this.o.h().removeCallbacks(this.E);
                this.o.h().post(this.E);
                Y0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S0(Fragment fragment, boolean z) {
        ViewGroup d0 = d0(fragment);
        if (d0 == null || !(d0 instanceof androidx.fragment.app.g)) {
            return;
        }
        ((androidx.fragment.app.g) d0).setDrawDisappearingViewsLast(!z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T0(Fragment fragment, e.b bVar) {
        if (fragment.equals(V(fragment.j)) && (fragment.x == null || fragment.w == this)) {
            fragment.U = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U0(Fragment fragment) {
        if (fragment == null || (fragment.equals(V(fragment.j)) && (fragment.x == null || fragment.w == this))) {
            Fragment fragment2 = this.r;
            this.r = fragment;
            C(fragment2);
            C(this.r);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment V(String str) {
        return this.f807c.f(str);
    }

    public Fragment W(int i2) {
        return this.f807c.g(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W0(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.D) {
            fragment.D = false;
            fragment.Q = !fragment.Q;
        }
    }

    public Fragment X(String str) {
        return this.f807c.h(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment Y(String str) {
        return this.f807c.i(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(androidx.fragment.app.a aVar) {
        if (this.f808d == null) {
            this.f808d = new ArrayList<>();
        }
        this.f808d.add(aVar);
    }

    public int b0() {
        ArrayList<androidx.fragment.app.a> arrayList = this.f808d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    void c(Fragment fragment, a.g.g.b bVar) {
        if (this.k.get(fragment) == null) {
            this.k.put(fragment, new HashSet<>());
        }
        this.k.get(fragment).add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        u0(fragment);
        if (fragment.E) {
            return;
        }
        this.f807c.a(fragment);
        fragment.q = false;
        if (fragment.L == null) {
            fragment.Q = false;
        }
        if (q0(fragment)) {
            this.u = true;
        }
    }

    void e(Fragment fragment) {
        if (t0()) {
            if (p0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.D.e(fragment) && p0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public androidx.fragment.app.i e0() {
        androidx.fragment.app.i iVar = this.s;
        if (iVar != null) {
            return iVar;
        }
        Fragment fragment = this.q;
        return fragment != null ? fragment.w.e0() : this.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.i.getAndIncrement();
    }

    public List<Fragment> f0() {
        return this.f807c.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void g(androidx.fragment.app.j<?> jVar, androidx.fragment.app.f fVar, Fragment fragment) {
        if (this.o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.o = jVar;
        this.p = fVar;
        this.q = fragment;
        if (fragment != null) {
            Y0();
        }
        if (jVar instanceof androidx.activity.c) {
            androidx.activity.c cVar = (androidx.activity.c) jVar;
            this.g = cVar.i();
            Fragment fragment2 = cVar;
            if (fragment != null) {
                fragment2 = fragment;
            }
            this.g.a(fragment2, this.h);
        }
        this.D = fragment != null ? fragment.w.c0(fragment) : jVar instanceof androidx.lifecycle.w ? p.i(((androidx.lifecycle.w) jVar).f()) : new p(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 g0() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.E) {
            fragment.E = false;
            if (fragment.p) {
                return;
            }
            this.f807c.a(fragment);
            if (p0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (q0(fragment)) {
                this.u = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l h0() {
        return this.m;
    }

    public t i() {
        return new androidx.fragment.app.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment i0() {
        return this.q;
    }

    public Fragment j0() {
        return this.r;
    }

    boolean k() {
        boolean z = false;
        for (Fragment fragment : this.f807c.k()) {
            if (fragment != null) {
                z = q0(fragment);
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.lifecycle.v l0(Fragment fragment) {
        return this.D.k(fragment);
    }

    void m0() {
        Q(true);
        if (this.h.c()) {
            F0();
        } else {
            this.g.c();
        }
    }

    void n(androidx.fragment.app.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.y(z3);
        } else {
            aVar.x();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            u.C(this, arrayList, arrayList2, 0, 1, true, this.l);
        }
        if (z3) {
            y0(this.n, true);
        }
        for (Fragment fragment : this.f807c.k()) {
            if (fragment != null && fragment.L != null && fragment.P && aVar.B(fragment.B)) {
                float f2 = fragment.R;
                if (f2 > 0.0f) {
                    fragment.L.setAlpha(f2);
                }
                if (z3) {
                    fragment.R = 0.0f;
                } else {
                    fragment.R = -1.0f;
                    fragment.P = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n0(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.D) {
            return;
        }
        fragment.D = true;
        fragment.Q = true ^ fragment.Q;
        V0(fragment);
    }

    public boolean o0() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Fragment fragment) {
        if (p0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.E) {
            return;
        }
        fragment.E = true;
        if (fragment.p) {
            if (p0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f807c.p(fragment);
            if (q0(fragment)) {
                this.u = true;
            }
            V0(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.v = false;
        this.w = false;
        J(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        m mVar = fragment.w;
        return fragment.equals(mVar.j0()) && r0(mVar.q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Configuration configuration) {
        for (Fragment fragment : this.f807c.m()) {
            if (fragment != null) {
                fragment.H0(configuration);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s0(int i2) {
        return this.n >= i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(MenuItem menuItem) {
        if (this.n < 1) {
            return false;
        }
        for (Fragment fragment : this.f807c.m()) {
            if (fragment != null && fragment.I0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean t0() {
        return this.v || this.w;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.q;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            obj = this.q;
        } else {
            androidx.fragment.app.j<?> jVar = this.o;
            if (jVar == null) {
                sb.append("null");
                sb.append("}}");
                return sb.toString();
            }
            sb.append(jVar.getClass().getSimpleName());
            sb.append("{");
            obj = this.o;
        }
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}");
        sb.append("}}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        this.v = false;
        this.w = false;
        J(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u0(Fragment fragment) {
        if (this.f807c.c(fragment.j)) {
            return;
        }
        r rVar = new r(this.m, fragment);
        rVar.k(this.o.g().getClassLoader());
        this.f807c.n(rVar);
        if (fragment.G) {
            if (fragment.F) {
                e(fragment);
            } else {
                M0(fragment);
            }
            fragment.G = false;
        }
        rVar.q(this.n);
        if (p0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v(Menu menu, MenuInflater menuInflater) {
        if (this.n < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.f807c.m()) {
            if (fragment != null && fragment.K0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                Fragment fragment2 = this.e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.k0();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.x = true;
        Q(true);
        N();
        J(-1);
        this.o = null;
        this.p = null;
        this.q = null;
        if (this.g != null) {
            this.h.d();
            this.g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        J(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x0(Fragment fragment) {
        if (!this.f807c.c(fragment.j)) {
            if (p0(3)) {
                Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.n + "since it is not added to " + this);
                return;
            }
            return;
        }
        z0(fragment);
        if (fragment.L != null) {
            Fragment j2 = this.f807c.j(fragment);
            if (j2 != null) {
                View view = j2.L;
                ViewGroup viewGroup = fragment.K;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(fragment.L);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.L, indexOfChild);
                }
            }
            if (fragment.P && fragment.K != null) {
                float f2 = fragment.R;
                if (f2 > 0.0f) {
                    fragment.L.setAlpha(f2);
                }
                fragment.R = 0.0f;
                fragment.P = false;
                e.d b2 = androidx.fragment.app.e.b(this.o.g(), this.p, fragment, true);
                if (b2 != null) {
                    Animation animation = b2.f797a;
                    if (animation != null) {
                        fragment.L.startAnimation(animation);
                    } else {
                        b2.f798b.setTarget(fragment.L);
                        b2.f798b.start();
                    }
                }
            }
        }
        if (fragment.Q) {
            o(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        for (Fragment fragment : this.f807c.m()) {
            if (fragment != null) {
                fragment.Q0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y0(int i2, boolean z) {
        androidx.fragment.app.j<?> jVar;
        if (this.o == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i2 != this.n) {
            this.n = i2;
            for (Fragment fragment : this.f807c.m()) {
                x0(fragment);
            }
            for (Fragment fragment2 : this.f807c.k()) {
                if (fragment2 != null && !fragment2.P) {
                    x0(fragment2);
                }
            }
            X0();
            if (this.u && (jVar = this.o) != null && this.n == 4) {
                jVar.o();
                this.u = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(boolean z) {
        for (Fragment fragment : this.f807c.m()) {
            if (fragment != null) {
                fragment.R0(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z0(Fragment fragment) {
        A0(fragment, this.n);
    }
}
