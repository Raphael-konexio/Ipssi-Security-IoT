package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f839a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    private static final w f840b;

    /* renamed from: c  reason: collision with root package name */
    private static final w f841c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        final /* synthetic */ g f;
        final /* synthetic */ Fragment g;
        final /* synthetic */ a.g.g.b h;

        a(g gVar, Fragment fragment, a.g.g.b bVar) {
            this.f = gVar;
            this.g = fragment;
            this.h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f.a(this.g, this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        final /* synthetic */ ArrayList f;

        b(ArrayList arrayList) {
            this.f = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            u.B(this.f, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements Runnable {
        final /* synthetic */ g f;
        final /* synthetic */ Fragment g;
        final /* synthetic */ a.g.g.b h;

        c(g gVar, Fragment fragment, a.g.g.b bVar) {
            this.f = gVar;
            this.g = fragment;
            this.h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f.a(this.g, this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d implements Runnable {
        final /* synthetic */ Object f;
        final /* synthetic */ w g;
        final /* synthetic */ View h;
        final /* synthetic */ Fragment i;
        final /* synthetic */ ArrayList j;
        final /* synthetic */ ArrayList k;
        final /* synthetic */ ArrayList l;
        final /* synthetic */ Object m;

        d(Object obj, w wVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f = obj;
            this.g = wVar;
            this.h = view;
            this.i = fragment;
            this.j = arrayList;
            this.k = arrayList2;
            this.l = arrayList3;
            this.m = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f;
            if (obj != null) {
                this.g.p(obj, this.h);
                this.k.addAll(u.k(this.g, this.f, this.i, this.j, this.h));
            }
            if (this.l != null) {
                if (this.m != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.h);
                    this.g.q(this.m, this.l, arrayList);
                }
                this.l.clear();
                this.l.add(this.h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e implements Runnable {
        final /* synthetic */ Fragment f;
        final /* synthetic */ Fragment g;
        final /* synthetic */ boolean h;
        final /* synthetic */ a.d.a i;
        final /* synthetic */ View j;
        final /* synthetic */ w k;
        final /* synthetic */ Rect l;

        e(Fragment fragment, Fragment fragment2, boolean z, a.d.a aVar, View view, w wVar, Rect rect) {
            this.f = fragment;
            this.g = fragment2;
            this.h = z;
            this.i = aVar;
            this.j = view;
            this.k = wVar;
            this.l = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            u.f(this.f, this.g, this.h, this.i, false);
            View view = this.j;
            if (view != null) {
                this.k.k(view, this.l);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f implements Runnable {
        final /* synthetic */ w f;
        final /* synthetic */ a.d.a g;
        final /* synthetic */ Object h;
        final /* synthetic */ h i;
        final /* synthetic */ ArrayList j;
        final /* synthetic */ View k;
        final /* synthetic */ Fragment l;
        final /* synthetic */ Fragment m;
        final /* synthetic */ boolean n;
        final /* synthetic */ ArrayList o;
        final /* synthetic */ Object p;
        final /* synthetic */ Rect q;

        f(w wVar, a.d.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f = wVar;
            this.g = aVar;
            this.h = obj;
            this.i = hVar;
            this.j = arrayList;
            this.k = view;
            this.l = fragment;
            this.m = fragment2;
            this.n = z;
            this.o = arrayList2;
            this.p = obj2;
            this.q = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.d.a<String, View> h = u.h(this.f, this.g, this.h, this.i);
            if (h != null) {
                this.j.addAll(h.values());
                this.j.add(this.k);
            }
            u.f(this.l, this.m, this.n, h, false);
            Object obj = this.h;
            if (obj != null) {
                this.f.A(obj, this.o, this.j);
                View t = u.t(h, this.i, this.p, this.n);
                if (t != null) {
                    this.f.k(t, this.q);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface g {
        void a(Fragment fragment, a.g.g.b bVar);

        void b(Fragment fragment, a.g.g.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f842a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f843b;

        /* renamed from: c  reason: collision with root package name */
        public androidx.fragment.app.a f844c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f845d;
        public boolean e;
        public androidx.fragment.app.a f;

        h() {
        }
    }

    static {
        f840b = Build.VERSION.SDK_INT >= 21 ? new v() : null;
        f841c = x();
    }

    private static void A(w wVar, Object obj, Object obj2, a.d.a<String, View> aVar, boolean z, androidx.fragment.app.a aVar2) {
        ArrayList<String> arrayList = aVar2.n;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = aVar.get((z ? aVar2.o : aVar2.n).get(0));
        wVar.v(obj, view);
        if (obj2 != null) {
            wVar.v(obj2, view);
        }
    }

    static void B(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void C(m mVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z, g gVar) {
        if (mVar.n < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            androidx.fragment.app.a aVar = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                e(aVar, sparseArray, z);
            } else {
                c(aVar, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(mVar.o.g());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = sparseArray.keyAt(i4);
                a.d.a<String, String> d2 = d(keyAt, arrayList, arrayList2, i, i2);
                h hVar = (h) sparseArray.valueAt(i4);
                if (z) {
                    o(mVar, keyAt, hVar, view, d2, gVar);
                } else {
                    n(mVar, keyAt, hVar, view, d2, gVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean D() {
        return (f840b == null && f841c == null) ? false : true;
    }

    private static void a(ArrayList<View> arrayList, a.d.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View m = aVar.m(size);
            if (collection.contains(a.g.k.s.E(m))) {
                arrayList.add(m);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0039, code lost:
        if (r0.p != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x006e, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0088, code lost:
        if (r0.D == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x008a, code lost:
        r9 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00d7 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void b(androidx.fragment.app.a r8, androidx.fragment.app.t.a r9, android.util.SparseArray<androidx.fragment.app.u.h> r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.u.b(androidx.fragment.app.a, androidx.fragment.app.t$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z) {
        int size = aVar.f831a.size();
        for (int i = 0; i < size; i++) {
            b(aVar, aVar.f831a.get(i), sparseArray, false, z);
        }
    }

    private static a.d.a<String, String> d(int i, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        a.d.a<String, String> aVar = new a.d.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i4);
            if (aVar2.B(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = aVar2.n;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.n;
                        arrayList4 = aVar2.o;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.n;
                        arrayList3 = aVar2.o;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(androidx.fragment.app.a aVar, SparseArray<h> sparseArray, boolean z) {
        if (aVar.r.p.d()) {
            for (int size = aVar.f831a.size() - 1; size >= 0; size--) {
                b(aVar, aVar.f831a.get(size), sparseArray, true, z);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z, a.d.a<String, View> aVar, boolean z2) {
        androidx.core.app.m t = z ? fragment2.t() : fragment.t();
        if (t != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.i(i));
                arrayList.add(aVar.m(i));
            }
            if (z2) {
                t.c(arrayList2, arrayList, null);
            } else {
                t.b(arrayList2, arrayList, null);
            }
        }
    }

    private static boolean g(w wVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!wVar.e(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    static a.d.a<String, View> h(w wVar, a.d.a<String, String> aVar, Object obj, h hVar) {
        androidx.core.app.m t;
        ArrayList<String> arrayList;
        String q;
        Fragment fragment = hVar.f842a;
        View N = fragment.N();
        if (aVar.isEmpty() || obj == null || N == null) {
            aVar.clear();
            return null;
        }
        a.d.a<String, View> aVar2 = new a.d.a<>();
        wVar.j(aVar2, N);
        androidx.fragment.app.a aVar3 = hVar.f844c;
        if (hVar.f843b) {
            t = fragment.v();
            arrayList = aVar3.n;
        } else {
            t = fragment.t();
            arrayList = aVar3.o;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
            aVar2.o(aVar.values());
        }
        if (t != null) {
            t.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    String q2 = q(aVar, str);
                    if (q2 != null) {
                        aVar.remove(q2);
                    }
                } else if (!str.equals(a.g.k.s.E(view)) && (q = q(aVar, str)) != null) {
                    aVar.put(q, a.g.k.s.E(view));
                }
            }
        } else {
            y(aVar, aVar2);
        }
        return aVar2;
    }

    private static a.d.a<String, View> i(w wVar, a.d.a<String, String> aVar, Object obj, h hVar) {
        androidx.core.app.m v;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = hVar.f845d;
        a.d.a<String, View> aVar2 = new a.d.a<>();
        wVar.j(aVar2, fragment.e1());
        androidx.fragment.app.a aVar3 = hVar.f;
        if (hVar.e) {
            v = fragment.t();
            arrayList = aVar3.o;
        } else {
            v = fragment.v();
            arrayList = aVar3.n;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
        }
        if (v != null) {
            v.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(a.g.k.s.E(view))) {
                    aVar.put(a.g.k.s.E(view), aVar.remove(str));
                }
            }
        } else {
            aVar.o(aVar2.keySet());
        }
        return aVar2;
    }

    private static w j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object u = fragment.u();
            if (u != null) {
                arrayList.add(u);
            }
            Object G = fragment.G();
            if (G != null) {
                arrayList.add(G);
            }
            Object I = fragment.I();
            if (I != null) {
                arrayList.add(I);
            }
        }
        if (fragment2 != null) {
            Object s = fragment2.s();
            if (s != null) {
                arrayList.add(s);
            }
            Object D = fragment2.D();
            if (D != null) {
                arrayList.add(D);
            }
            Object H = fragment2.H();
            if (H != null) {
                arrayList.add(H);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        w wVar = f840b;
        if (wVar == null || !g(wVar, arrayList)) {
            w wVar2 = f841c;
            if (wVar2 == null || !g(wVar2, arrayList)) {
                if (f840b == null && f841c == null) {
                    return null;
                }
                throw new IllegalArgumentException("Invalid Transition types");
            }
            return f841c;
        }
        return f840b;
    }

    static ArrayList<View> k(w wVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj != null) {
            ArrayList<View> arrayList2 = new ArrayList<>();
            View N = fragment.N();
            if (N != null) {
                wVar.f(arrayList2, N);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (arrayList2.isEmpty()) {
                return arrayList2;
            }
            arrayList2.add(view);
            wVar.b(obj, arrayList2);
            return arrayList2;
        }
        return null;
    }

    private static Object l(w wVar, ViewGroup viewGroup, View view, a.d.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object u;
        a.d.a<String, String> aVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = hVar.f842a;
        Fragment fragment2 = hVar.f845d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.f843b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            u = null;
        } else {
            u = u(wVar, fragment, fragment2, z);
            aVar2 = aVar;
        }
        a.d.a<String, View> i = i(wVar, aVar2, u, hVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(i.values());
            obj3 = u;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, i, true);
        if (obj3 != null) {
            rect = new Rect();
            wVar.z(obj3, view, arrayList);
            A(wVar, obj3, obj2, i, hVar.e, hVar.f);
            if (obj != null) {
                wVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        a.g.k.q.a(viewGroup, new f(wVar, aVar, obj3, hVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    private static Object m(w wVar, ViewGroup viewGroup, View view, a.d.a<String, String> aVar, h hVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = hVar.f842a;
        Fragment fragment2 = hVar.f845d;
        if (fragment != null) {
            fragment.e1().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = hVar.f843b;
        Object u = aVar.isEmpty() ? null : u(wVar, fragment, fragment2, z);
        a.d.a<String, View> i = i(wVar, aVar, u, hVar);
        a.d.a<String, View> h2 = h(wVar, aVar, u, hVar);
        if (aVar.isEmpty()) {
            if (i != null) {
                i.clear();
            }
            if (h2 != null) {
                h2.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, i, aVar.keySet());
            a(arrayList2, h2, aVar.values());
            obj3 = u;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, i, true);
        if (obj3 != null) {
            arrayList2.add(view);
            wVar.z(obj3, view, arrayList);
            A(wVar, obj3, obj2, i, hVar.e, hVar.f);
            Rect rect2 = new Rect();
            View t = t(h2, hVar, obj, z);
            if (t != null) {
                wVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = t;
        } else {
            view2 = null;
            rect = null;
        }
        a.g.k.q.a(viewGroup, new e(fragment, fragment2, z, h2, view2, wVar, rect));
        return obj3;
    }

    private static void n(m mVar, int i, h hVar, View view, a.d.a<String, String> aVar, g gVar) {
        Fragment fragment;
        Fragment fragment2;
        w j;
        Object obj;
        ViewGroup viewGroup = mVar.p.d() ? (ViewGroup) mVar.p.c(i) : null;
        if (viewGroup == null || (j = j((fragment2 = hVar.f845d), (fragment = hVar.f842a))) == null) {
            return;
        }
        boolean z = hVar.f843b;
        boolean z2 = hVar.e;
        Object r = r(j, fragment, z);
        Object s = s(j, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object l = l(j, viewGroup, view, aVar, hVar, arrayList, arrayList2, r, s);
        if (r == null && l == null) {
            obj = s;
            if (obj == null) {
                return;
            }
        } else {
            obj = s;
        }
        ArrayList<View> k = k(j, obj, fragment2, arrayList, view);
        Object obj2 = (k == null || k.isEmpty()) ? null : obj;
        j.a(r, view);
        Object v = v(j, r, obj2, l, fragment, hVar.f843b);
        if (fragment2 != null && k != null && (k.size() > 0 || arrayList.size() > 0)) {
            a.g.g.b bVar = new a.g.g.b();
            gVar.b(fragment2, bVar);
            j.w(fragment2, v, bVar, new c(gVar, fragment2, bVar));
        }
        if (v != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            j.t(v, r, arrayList3, obj2, k, l, arrayList2);
            z(j, viewGroup, fragment, view, arrayList2, r, arrayList3, obj2, k);
            j.x(viewGroup, arrayList2, aVar);
            j.c(viewGroup, v);
            j.s(viewGroup, arrayList2, aVar);
        }
    }

    private static void o(m mVar, int i, h hVar, View view, a.d.a<String, String> aVar, g gVar) {
        Fragment fragment;
        Fragment fragment2;
        w j;
        Object obj;
        ViewGroup viewGroup = mVar.p.d() ? (ViewGroup) mVar.p.c(i) : null;
        if (viewGroup == null || (j = j((fragment2 = hVar.f845d), (fragment = hVar.f842a))) == null) {
            return;
        }
        boolean z = hVar.f843b;
        boolean z2 = hVar.e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object r = r(j, fragment, z);
        Object s = s(j, fragment2, z2);
        Object m = m(j, viewGroup, view, aVar, hVar, arrayList2, arrayList, r, s);
        if (r == null && m == null) {
            obj = s;
            if (obj == null) {
                return;
            }
        } else {
            obj = s;
        }
        ArrayList<View> k = k(j, obj, fragment2, arrayList2, view);
        ArrayList<View> k2 = k(j, r, fragment, arrayList, view);
        B(k2, 4);
        Object v = v(j, r, obj, m, fragment, z);
        if (fragment2 != null && k != null && (k.size() > 0 || arrayList2.size() > 0)) {
            a.g.g.b bVar = new a.g.g.b();
            gVar.b(fragment2, bVar);
            j.w(fragment2, v, bVar, new a(gVar, fragment2, bVar));
        }
        if (v != null) {
            w(j, obj, fragment2, k);
            ArrayList<String> o = j.o(arrayList);
            j.t(v, r, k2, obj, k, m, arrayList);
            j.c(viewGroup, v);
            j.y(viewGroup, arrayList2, arrayList, o, aVar);
            B(k2, 0);
            j.A(m, arrayList2, arrayList);
        }
    }

    private static h p(h hVar, SparseArray<h> sparseArray, int i) {
        if (hVar == null) {
            h hVar2 = new h();
            sparseArray.put(i, hVar2);
            return hVar2;
        }
        return hVar;
    }

    private static String q(a.d.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.m(i))) {
                return aVar.i(i);
            }
        }
        return null;
    }

    private static Object r(w wVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return wVar.g(z ? fragment.D() : fragment.s());
    }

    private static Object s(w wVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return wVar.g(z ? fragment.G() : fragment.u());
    }

    static View t(a.d.a<String, View> aVar, h hVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        androidx.fragment.app.a aVar2 = hVar.f844c;
        if (obj == null || aVar == null || (arrayList = aVar2.n) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get((z ? aVar2.n : aVar2.o).get(0));
    }

    private static Object u(w wVar, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return wVar.B(wVar.g(z ? fragment2.I() : fragment.H()));
    }

    private static Object v(w wVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        return (obj == null || obj2 == null || fragment == null) ? true : z ? fragment.m() : fragment.l() ? wVar.n(obj2, obj, obj3) : wVar.m(obj2, obj, obj3);
    }

    private static void w(w wVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.p && fragment.D && fragment.Q) {
            fragment.k1(true);
            wVar.r(obj, fragment.N(), arrayList);
            a.g.k.q.a(fragment.K, new b(arrayList));
        }
    }

    private static w x() {
        try {
            return (w) Class.forName("a.p.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void y(a.d.a<String, String> aVar, a.d.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.m(size))) {
                aVar.k(size);
            }
        }
    }

    private static void z(w wVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        a.g.k.q.a(viewGroup, new d(obj, wVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }
}
