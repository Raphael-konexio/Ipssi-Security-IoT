package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.fragment.app.t;
import java.io.PrintWriter;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends t implements m.h {
    final m r;
    boolean s;
    int t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(androidx.fragment.app.m r3) {
        /*
            r2 = this;
            androidx.fragment.app.i r0 = r3.e0()
            androidx.fragment.app.j<?> r1 = r3.o
            if (r1 == 0) goto L11
            android.content.Context r1 = r1.g()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            goto L12
        L11:
            r1 = 0
        L12:
            r2.<init>(r0, r1)
            r0 = -1
            r2.t = r0
            r2.r = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.<init>(androidx.fragment.app.m):void");
    }

    private static boolean D(t.a aVar) {
        Fragment fragment = aVar.f836b;
        return (fragment == null || !fragment.p || fragment.L == null || fragment.E || fragment.D || !fragment.T()) ? false : true;
    }

    public String A() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B(int i) {
        int size = this.f831a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f831a.get(i2).f836b;
            int i3 = fragment != null ? fragment.B : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C(ArrayList<a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f831a.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f831a.get(i4).f836b;
            int i5 = fragment != null ? fragment.B : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar = arrayList.get(i6);
                    int size2 = aVar.f831a.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = aVar.f831a.get(i7).f836b;
                        if ((fragment2 != null ? fragment2.B : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E() {
        for (int i = 0; i < this.f831a.size(); i++) {
            if (D(this.f831a.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void F() {
        if (this.q != null) {
            for (int i = 0; i < this.q.size(); i++) {
                this.q.get(i).run();
            }
            this.q = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(Fragment.e eVar) {
        for (int i = 0; i < this.f831a.size(); i++) {
            t.a aVar = this.f831a.get(i);
            if (D(aVar)) {
                aVar.f836b.n1(eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment H(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f831a.size() - 1; size >= 0; size--) {
            t.a aVar = this.f831a.get(size);
            int i = aVar.f835a;
            if (i != 1) {
                if (i != 3) {
                    switch (i) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f836b;
                            break;
                        case 10:
                            aVar.h = aVar.g;
                            break;
                    }
                }
                arrayList.add(aVar.f836b);
            }
            arrayList.remove(aVar.f836b);
        }
        return fragment;
    }

    @Override // androidx.fragment.app.m.h
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (m.p0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.g) {
            this.r.b(this);
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.t
    public int h() {
        return u(false);
    }

    @Override // androidx.fragment.app.t
    public int i() {
        return u(true);
    }

    @Override // androidx.fragment.app.t
    public void j() {
        l();
        this.r.R(this, false);
    }

    @Override // androidx.fragment.app.t
    public void k() {
        l();
        this.r.R(this, true);
    }

    @Override // androidx.fragment.app.t
    void m(int i, Fragment fragment, String str, int i2) {
        super.m(i, fragment, str, i2);
        fragment.w = this.r;
    }

    @Override // androidx.fragment.app.t
    public t n(Fragment fragment) {
        m mVar = fragment.w;
        if (mVar == null || mVar == this.r) {
            super.n(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.t
    public t r(Fragment fragment) {
        m mVar;
        if (fragment == null || (mVar = fragment.w) == null || mVar == this.r) {
            super.r(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i) {
        t.a aVar;
        if (this.g) {
            if (m.p0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f831a.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = this.f831a.get(i2).f836b;
                if (fragment != null) {
                    fragment.v += i;
                    if (m.p0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f836b + " to " + aVar.f836b.v);
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.t >= 0) {
            sb.append(" #");
            sb.append(this.t);
        }
        if (this.i != null) {
            sb.append(" ");
            sb.append(this.i);
        }
        sb.append("}");
        return sb.toString();
    }

    int u(boolean z) {
        if (this.s) {
            throw new IllegalStateException("commit already called");
        }
        if (m.p0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new a.g.j.c("FragmentManager"));
            v("  ", printWriter);
            printWriter.close();
        }
        this.s = true;
        this.t = this.g ? this.r.f() : -1;
        this.r.O(this, z);
        return this.t;
    }

    public void v(String str, PrintWriter printWriter) {
        w(str, printWriter, true);
    }

    public void w(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.i);
            printWriter.print(" mIndex=");
            printWriter.print(this.t);
            printWriter.print(" mCommitted=");
            printWriter.println(this.s);
            if (this.f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f));
            }
            if (this.f832b != 0 || this.f833c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f832b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f833c));
            }
            if (this.f834d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f834d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.j != 0 || this.k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.k);
            }
            if (this.l != 0 || this.m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.m);
            }
        }
        if (this.f831a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f831a.size();
        for (int i = 0; i < size; i++) {
            t.a aVar = this.f831a.get(i);
            switch (aVar.f835a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f835a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f836b);
            if (z) {
                if (aVar.f837c != 0 || aVar.f838d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f837c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f838d));
                }
                if (aVar.e != 0 || aVar.f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        int size = this.f831a.size();
        for (int i = 0; i < size; i++) {
            t.a aVar = this.f831a.get(i);
            Fragment fragment = aVar.f836b;
            if (fragment != null) {
                fragment.m1(this.f);
            }
            switch (aVar.f835a) {
                case 1:
                    fragment.l1(aVar.f837c);
                    this.r.S0(fragment, false);
                    this.r.d(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f835a);
                case 3:
                    fragment.l1(aVar.f838d);
                    this.r.K0(fragment);
                    break;
                case 4:
                    fragment.l1(aVar.f838d);
                    this.r.n0(fragment);
                    break;
                case 5:
                    fragment.l1(aVar.f837c);
                    this.r.S0(fragment, false);
                    this.r.W0(fragment);
                    break;
                case 6:
                    fragment.l1(aVar.f838d);
                    this.r.q(fragment);
                    break;
                case 7:
                    fragment.l1(aVar.f837c);
                    this.r.S0(fragment, false);
                    this.r.h(fragment);
                    break;
                case 8:
                    this.r.U0(fragment);
                    break;
                case 9:
                    this.r.U0(null);
                    break;
                case 10:
                    this.r.T0(fragment, aVar.h);
                    break;
            }
            if (!this.p && aVar.f835a != 1 && fragment != null) {
                this.r.x0(fragment);
            }
        }
        if (this.p) {
            return;
        }
        m mVar = this.r;
        mVar.y0(mVar.n, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(boolean z) {
        for (int size = this.f831a.size() - 1; size >= 0; size--) {
            t.a aVar = this.f831a.get(size);
            Fragment fragment = aVar.f836b;
            if (fragment != null) {
                fragment.m1(m.P0(this.f));
            }
            switch (aVar.f835a) {
                case 1:
                    fragment.l1(aVar.f);
                    this.r.S0(fragment, true);
                    this.r.K0(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f835a);
                case 3:
                    fragment.l1(aVar.e);
                    this.r.d(fragment);
                    break;
                case 4:
                    fragment.l1(aVar.e);
                    this.r.W0(fragment);
                    break;
                case 5:
                    fragment.l1(aVar.f);
                    this.r.S0(fragment, true);
                    this.r.n0(fragment);
                    break;
                case 6:
                    fragment.l1(aVar.e);
                    this.r.h(fragment);
                    break;
                case 7:
                    fragment.l1(aVar.f);
                    this.r.S0(fragment, true);
                    this.r.q(fragment);
                    break;
                case 8:
                    this.r.U0(null);
                    break;
                case 9:
                    this.r.U0(fragment);
                    break;
                case 10:
                    this.r.T0(fragment, aVar.g);
                    break;
            }
            if (!this.p && aVar.f835a != 3 && fragment != null) {
                this.r.x0(fragment);
            }
        }
        if (this.p || !z) {
            return;
        }
        m mVar = this.r;
        mVar.y0(mVar.n, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment z(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.f831a.size()) {
            t.a aVar = this.f831a.get(i);
            int i2 = aVar.f835a;
            if (i2 != 1) {
                if (i2 == 2) {
                    Fragment fragment3 = aVar.f836b;
                    int i3 = fragment3.B;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList.get(size);
                        if (fragment4.B == i3) {
                            if (fragment4 == fragment3) {
                                z = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f831a.add(i, new t.a(9, fragment4));
                                    i++;
                                    fragment2 = null;
                                }
                                t.a aVar2 = new t.a(3, fragment4);
                                aVar2.f837c = aVar.f837c;
                                aVar2.e = aVar.e;
                                aVar2.f838d = aVar.f838d;
                                aVar2.f = aVar.f;
                                this.f831a.add(i, aVar2);
                                arrayList.remove(fragment4);
                                i++;
                            }
                        }
                    }
                    if (z) {
                        this.f831a.remove(i);
                        i--;
                    } else {
                        aVar.f835a = 1;
                        arrayList.add(fragment3);
                    }
                } else if (i2 == 3 || i2 == 6) {
                    arrayList.remove(aVar.f836b);
                    Fragment fragment5 = aVar.f836b;
                    if (fragment5 == fragment2) {
                        this.f831a.add(i, new t.a(9, fragment5));
                        i++;
                        fragment2 = null;
                    }
                } else if (i2 != 7) {
                    if (i2 == 8) {
                        this.f831a.add(i, new t.a(9, fragment2));
                        i++;
                        fragment2 = aVar.f836b;
                    }
                }
                i++;
            }
            arrayList.add(aVar.f836b);
            i++;
        }
        return fragment2;
    }
}
