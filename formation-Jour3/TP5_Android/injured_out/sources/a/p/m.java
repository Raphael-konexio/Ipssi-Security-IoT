package a.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class m implements Cloneable {
    private static final int[] L = {2, 1, 3, 4};
    private static final g M = new a();
    private static ThreadLocal<a.d.a<Animator, d>> N = new ThreadLocal<>();
    p H;
    private e I;
    private a.d.a<String, String> J;
    private ArrayList<s> y;
    private ArrayList<s> z;
    private String f = getClass().getName();
    private long g = -1;
    long h = -1;
    private TimeInterpolator i = null;
    ArrayList<Integer> j = new ArrayList<>();
    ArrayList<View> k = new ArrayList<>();
    private ArrayList<String> l = null;
    private ArrayList<Class<?>> m = null;
    private ArrayList<Integer> n = null;
    private ArrayList<View> o = null;
    private ArrayList<Class<?>> p = null;
    private ArrayList<String> q = null;
    private ArrayList<Integer> r = null;
    private ArrayList<View> s = null;
    private ArrayList<Class<?>> t = null;
    private t u = new t();
    private t v = new t();
    q w = null;
    private int[] x = L;
    boolean A = false;
    ArrayList<Animator> B = new ArrayList<>();
    private int C = 0;
    private boolean D = false;
    private boolean E = false;
    private ArrayList<f> F = null;
    private ArrayList<Animator> G = new ArrayList<>();
    private g K = M;

    /* loaded from: classes.dex */
    static class a extends g {
        a() {
        }

        @Override // a.p.g
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.d.a f394a;

        b(a.d.a aVar) {
            this.f394a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f394a.remove(animator);
            m.this.B.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            m.this.B.add(animator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m.this.p();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        View f397a;

        /* renamed from: b  reason: collision with root package name */
        String f398b;

        /* renamed from: c  reason: collision with root package name */
        s f399c;

        /* renamed from: d  reason: collision with root package name */
        m0 f400d;
        m e;

        d(View view, String str, m mVar, m0 m0Var, s sVar) {
            this.f397a = view;
            this.f398b = str;
            this.f399c = sVar;
            this.f400d = m0Var;
            this.e = mVar;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(m mVar);

        void b(m mVar);

        void c(m mVar);

        void d(m mVar);

        void e(m mVar);
    }

    private static boolean H(s sVar, s sVar2, String str) {
        Object obj = sVar.f411a.get(str);
        Object obj2 = sVar2.f411a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void I(a.d.a<View, s> aVar, a.d.a<View, s> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && G(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && G(view)) {
                s sVar = aVar.get(valueAt);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.y.add(sVar);
                    this.z.add(sVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void J(a.d.a<View, s> aVar, a.d.a<View, s> aVar2) {
        s remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View i = aVar.i(size);
            if (i != null && G(i) && (remove = aVar2.remove(i)) != null && G(remove.f412b)) {
                this.y.add(aVar.k(size));
                this.z.add(remove);
            }
        }
    }

    private void K(a.d.a<View, s> aVar, a.d.a<View, s> aVar2, a.d.d<View> dVar, a.d.d<View> dVar2) {
        View f2;
        int m = dVar.m();
        for (int i = 0; i < m; i++) {
            View n = dVar.n(i);
            if (n != null && G(n) && (f2 = dVar2.f(dVar.i(i))) != null && G(f2)) {
                s sVar = aVar.get(n);
                s sVar2 = aVar2.get(f2);
                if (sVar != null && sVar2 != null) {
                    this.y.add(sVar);
                    this.z.add(sVar2);
                    aVar.remove(n);
                    aVar2.remove(f2);
                }
            }
        }
    }

    private void L(a.d.a<View, s> aVar, a.d.a<View, s> aVar2, a.d.a<String, View> aVar3, a.d.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i = 0; i < size; i++) {
            View m = aVar3.m(i);
            if (m != null && G(m) && (view = aVar4.get(aVar3.i(i))) != null && G(view)) {
                s sVar = aVar.get(m);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.y.add(sVar);
                    this.z.add(sVar2);
                    aVar.remove(m);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void M(t tVar, t tVar2) {
        a.d.a<View, s> aVar = new a.d.a<>(tVar.f414a);
        a.d.a<View, s> aVar2 = new a.d.a<>(tVar2.f414a);
        int i = 0;
        while (true) {
            int[] iArr = this.x;
            if (i >= iArr.length) {
                c(aVar, aVar2);
                return;
            }
            int i2 = iArr[i];
            if (i2 == 1) {
                J(aVar, aVar2);
            } else if (i2 == 2) {
                L(aVar, aVar2, tVar.f417d, tVar2.f417d);
            } else if (i2 == 3) {
                I(aVar, aVar2, tVar.f415b, tVar2.f415b);
            } else if (i2 == 4) {
                K(aVar, aVar2, tVar.f416c, tVar2.f416c);
            }
            i++;
        }
    }

    private void S(Animator animator, a.d.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            e(animator);
        }
    }

    private void c(a.d.a<View, s> aVar, a.d.a<View, s> aVar2) {
        for (int i = 0; i < aVar.size(); i++) {
            s m = aVar.m(i);
            if (G(m.f412b)) {
                this.y.add(m);
                this.z.add(null);
            }
        }
        for (int i2 = 0; i2 < aVar2.size(); i2++) {
            s m2 = aVar2.m(i2);
            if (G(m2.f412b)) {
                this.z.add(m2);
                this.y.add(null);
            }
        }
    }

    private static void d(t tVar, View view, s sVar) {
        tVar.f414a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f415b.indexOfKey(id) >= 0) {
                tVar.f415b.put(id, null);
            } else {
                tVar.f415b.put(id, view);
            }
        }
        String E = a.g.k.s.E(view);
        if (E != null) {
            if (tVar.f417d.containsKey(E)) {
                tVar.f417d.put(E, null);
            } else {
                tVar.f417d.put(E, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f416c.h(itemIdAtPosition) < 0) {
                    a.g.k.s.o0(view, true);
                    tVar.f416c.j(itemIdAtPosition, view);
                    return;
                }
                View f2 = tVar.f416c.f(itemIdAtPosition);
                if (f2 != null) {
                    a.g.k.s.o0(f2, false);
                    tVar.f416c.j(itemIdAtPosition, null);
                }
            }
        }
    }

    private void h(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.n;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.o;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.p;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (this.p.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s(view);
                    if (z) {
                        j(sVar);
                    } else {
                        g(sVar);
                    }
                    sVar.f413c.add(this);
                    i(sVar);
                    d(z ? this.u : this.v, view, sVar);
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.r;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.s;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.t;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.t.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                h(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    private static a.d.a<Animator, d> x() {
        a.d.a<Animator, d> aVar = N.get();
        if (aVar == null) {
            a.d.a<Animator, d> aVar2 = new a.d.a<>();
            N.set(aVar2);
            return aVar2;
        }
        return aVar;
    }

    public List<String> A() {
        return this.l;
    }

    public List<Class<?>> B() {
        return this.m;
    }

    public List<View> C() {
        return this.k;
    }

    public String[] D() {
        return null;
    }

    public s E(View view, boolean z) {
        q qVar = this.w;
        if (qVar != null) {
            return qVar.E(view, z);
        }
        return (z ? this.u : this.v).f414a.get(view);
    }

    public boolean F(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] D = D();
        if (D == null) {
            for (String str : sVar.f411a.keySet()) {
                if (H(sVar, sVar2, str)) {
                }
            }
            return false;
        }
        for (String str2 : D) {
            if (!H(sVar, sVar2, str2)) {
            }
        }
        return false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.n;
        if (arrayList3 == null || !arrayList3.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList4 = this.o;
            if (arrayList4 == null || !arrayList4.contains(view)) {
                ArrayList<Class<?>> arrayList5 = this.p;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    for (int i = 0; i < size; i++) {
                        if (this.p.get(i).isInstance(view)) {
                            return false;
                        }
                    }
                }
                if (this.q == null || a.g.k.s.E(view) == null || !this.q.contains(a.g.k.s.E(view))) {
                    if ((this.j.size() == 0 && this.k.size() == 0 && (((arrayList = this.m) == null || arrayList.isEmpty()) && ((arrayList2 = this.l) == null || arrayList2.isEmpty()))) || this.j.contains(Integer.valueOf(id)) || this.k.contains(view)) {
                        return true;
                    }
                    ArrayList<String> arrayList6 = this.l;
                    if (arrayList6 == null || !arrayList6.contains(a.g.k.s.E(view))) {
                        if (this.m != null) {
                            for (int i2 = 0; i2 < this.m.size(); i2++) {
                                if (this.m.get(i2).isInstance(view)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public void N(View view) {
        if (this.E) {
            return;
        }
        a.d.a<Animator, d> x = x();
        int size = x.size();
        m0 d2 = c0.d(view);
        for (int i = size - 1; i >= 0; i--) {
            d m = x.m(i);
            if (m.f397a != null && d2.equals(m.f400d)) {
                a.p.a.b(x.i(i));
            }
        }
        ArrayList<f> arrayList = this.F;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.F.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((f) arrayList2.get(i2)).c(this);
            }
        }
        this.D = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(ViewGroup viewGroup) {
        d dVar;
        this.y = new ArrayList<>();
        this.z = new ArrayList<>();
        M(this.u, this.v);
        a.d.a<Animator, d> x = x();
        int size = x.size();
        m0 d2 = c0.d(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator i2 = x.i(i);
            if (i2 != null && (dVar = x.get(i2)) != null && dVar.f397a != null && d2.equals(dVar.f400d)) {
                s sVar = dVar.f399c;
                View view = dVar.f397a;
                s E = E(view, true);
                s t = t(view, true);
                if (E == null && t == null) {
                    t = this.v.f414a.get(view);
                }
                if (!(E == null && t == null) && dVar.e.F(sVar, t)) {
                    if (i2.isRunning() || i2.isStarted()) {
                        i2.cancel();
                    } else {
                        x.remove(i2);
                    }
                }
            }
        }
        o(viewGroup, this.u, this.v, this.y, this.z);
        T();
    }

    public m P(f fVar) {
        ArrayList<f> arrayList = this.F;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.F.size() == 0) {
            this.F = null;
        }
        return this;
    }

    public m Q(View view) {
        this.k.remove(view);
        return this;
    }

    public void R(View view) {
        if (this.D) {
            if (!this.E) {
                a.d.a<Animator, d> x = x();
                int size = x.size();
                m0 d2 = c0.d(view);
                for (int i = size - 1; i >= 0; i--) {
                    d m = x.m(i);
                    if (m.f397a != null && d2.equals(m.f400d)) {
                        a.p.a.c(x.i(i));
                    }
                }
                ArrayList<f> arrayList = this.F;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.F.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((f) arrayList2.get(i2)).d(this);
                    }
                }
            }
            this.D = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        a0();
        a.d.a<Animator, d> x = x();
        Iterator<Animator> it = this.G.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (x.containsKey(next)) {
                a0();
                S(next, x);
            }
        }
        this.G.clear();
        p();
    }

    public m U(long j) {
        this.h = j;
        return this;
    }

    public void V(e eVar) {
        this.I = eVar;
    }

    public m W(TimeInterpolator timeInterpolator) {
        this.i = timeInterpolator;
        return this;
    }

    public void X(g gVar) {
        if (gVar == null) {
            gVar = M;
        }
        this.K = gVar;
    }

    public void Y(p pVar) {
        this.H = pVar;
    }

    public m Z(long j) {
        this.g = j;
        return this;
    }

    public m a(f fVar) {
        if (this.F == null) {
            this.F = new ArrayList<>();
        }
        this.F.add(fVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0() {
        if (this.C == 0) {
            ArrayList<f> arrayList = this.F;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.F.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((f) arrayList2.get(i)).a(this);
                }
            }
            this.E = false;
        }
        this.C++;
    }

    public m b(View view) {
        this.k.add(view);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.h != -1) {
            str2 = str2 + "dur(" + this.h + ") ";
        }
        if (this.g != -1) {
            str2 = str2 + "dly(" + this.g + ") ";
        }
        if (this.i != null) {
            str2 = str2 + "interp(" + this.i + ") ";
        }
        if (this.j.size() > 0 || this.k.size() > 0) {
            String str3 = str2 + "tgts(";
            if (this.j.size() > 0) {
                for (int i = 0; i < this.j.size(); i++) {
                    if (i > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.j.get(i);
                }
            }
            if (this.k.size() > 0) {
                for (int i2 = 0; i2 < this.k.size(); i2++) {
                    if (i2 > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.k.get(i2);
                }
            }
            return str3 + ")";
        }
        return str2;
    }

    protected void e(Animator animator) {
        if (animator == null) {
            p();
            return;
        }
        if (q() >= 0) {
            animator.setDuration(q());
        }
        if (y() >= 0) {
            animator.setStartDelay(y() + animator.getStartDelay());
        }
        if (s() != null) {
            animator.setInterpolator(s());
        }
        animator.addListener(new c());
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        for (int size = this.B.size() - 1; size >= 0; size--) {
            this.B.get(size).cancel();
        }
        ArrayList<f> arrayList = this.F;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.F.clone();
        int size2 = arrayList2.size();
        for (int i = 0; i < size2; i++) {
            ((f) arrayList2.get(i)).b(this);
        }
    }

    public abstract void g(s sVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(s sVar) {
        String[] b2;
        if (this.H == null || sVar.f411a.isEmpty() || (b2 = this.H.b()) == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= b2.length) {
                z = true;
                break;
            } else if (!sVar.f411a.containsKey(b2[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        this.H.a(sVar);
    }

    public abstract void j(s sVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        a.d.a<String, String> aVar;
        l(z);
        if ((this.j.size() > 0 || this.k.size() > 0) && (((arrayList = this.l) == null || arrayList.isEmpty()) && ((arrayList2 = this.m) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.j.size(); i++) {
                View findViewById = viewGroup.findViewById(this.j.get(i).intValue());
                if (findViewById != null) {
                    s sVar = new s(findViewById);
                    if (z) {
                        j(sVar);
                    } else {
                        g(sVar);
                    }
                    sVar.f413c.add(this);
                    i(sVar);
                    d(z ? this.u : this.v, findViewById, sVar);
                }
            }
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                View view = this.k.get(i2);
                s sVar2 = new s(view);
                if (z) {
                    j(sVar2);
                } else {
                    g(sVar2);
                }
                sVar2.f413c.add(this);
                i(sVar2);
                d(z ? this.u : this.v, view, sVar2);
            }
        } else {
            h(viewGroup, z);
        }
        if (z || (aVar = this.J) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.u.f417d.remove(this.J.i(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.u.f417d.put(this.J.m(i4), view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(boolean z) {
        t tVar;
        if (z) {
            this.u.f414a.clear();
            this.u.f415b.clear();
            tVar = this.u;
        } else {
            this.v.f414a.clear();
            this.v.f415b.clear();
            tVar = this.v;
        }
        tVar.f416c.b();
    }

    @Override // 
    /* renamed from: m */
    public m clone() {
        try {
            m mVar = (m) super.clone();
            mVar.G = new ArrayList<>();
            mVar.u = new t();
            mVar.v = new t();
            mVar.y = null;
            mVar.z = null;
            return mVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        Animator n;
        int i;
        int i2;
        View view;
        Animator animator;
        s sVar;
        Animator animator2;
        s sVar2;
        a.d.a<Animator, d> x = x();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i3 = 0;
        while (i3 < size) {
            s sVar3 = arrayList.get(i3);
            s sVar4 = arrayList2.get(i3);
            if (sVar3 != null && !sVar3.f413c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f413c.contains(this)) {
                sVar4 = null;
            }
            if (sVar3 != null || sVar4 != null) {
                if ((sVar3 == null || sVar4 == null || F(sVar3, sVar4)) && (n = n(viewGroup, sVar3, sVar4)) != null) {
                    if (sVar4 != null) {
                        view = sVar4.f412b;
                        String[] D = D();
                        if (D != null && D.length > 0) {
                            sVar2 = new s(view);
                            i = size;
                            s sVar5 = tVar2.f414a.get(view);
                            if (sVar5 != null) {
                                int i4 = 0;
                                while (i4 < D.length) {
                                    sVar2.f411a.put(D[i4], sVar5.f411a.get(D[i4]));
                                    i4++;
                                    i3 = i3;
                                    sVar5 = sVar5;
                                }
                            }
                            i2 = i3;
                            int size2 = x.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size2) {
                                    animator2 = n;
                                    break;
                                }
                                d dVar = x.get(x.i(i5));
                                if (dVar.f399c != null && dVar.f397a == view && dVar.f398b.equals(u()) && dVar.f399c.equals(sVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i5++;
                            }
                        } else {
                            i = size;
                            i2 = i3;
                            animator2 = n;
                            sVar2 = null;
                        }
                        animator = animator2;
                        sVar = sVar2;
                    } else {
                        i = size;
                        i2 = i3;
                        view = sVar3.f412b;
                        animator = n;
                        sVar = null;
                    }
                    if (animator != null) {
                        p pVar = this.H;
                        if (pVar != null) {
                            long c2 = pVar.c(viewGroup, this, sVar3, sVar4);
                            sparseIntArray.put(this.G.size(), (int) c2);
                            j = Math.min(c2, j);
                        }
                        x.put(animator, new d(view, u(), this, c0.d(viewGroup), sVar));
                        this.G.add(animator);
                        j = j;
                    }
                    i3 = i2 + 1;
                    size = i;
                }
            }
            i = size;
            i2 = i3;
            i3 = i2 + 1;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator3 = this.G.get(sparseIntArray.keyAt(i6));
                animator3.setStartDelay((sparseIntArray.valueAt(i6) - j) + animator3.getStartDelay());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        int i = this.C - 1;
        this.C = i;
        if (i == 0) {
            ArrayList<f> arrayList = this.F;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.F.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((f) arrayList2.get(i2)).e(this);
                }
            }
            for (int i3 = 0; i3 < this.u.f416c.m(); i3++) {
                View n = this.u.f416c.n(i3);
                if (n != null) {
                    a.g.k.s.o0(n, false);
                }
            }
            for (int i4 = 0; i4 < this.v.f416c.m(); i4++) {
                View n2 = this.v.f416c.n(i4);
                if (n2 != null) {
                    a.g.k.s.o0(n2, false);
                }
            }
            this.E = true;
        }
    }

    public long q() {
        return this.h;
    }

    public e r() {
        return this.I;
    }

    public TimeInterpolator s() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s t(View view, boolean z) {
        q qVar = this.w;
        if (qVar != null) {
            return qVar.t(view, z);
        }
        ArrayList<s> arrayList = z ? this.y : this.z;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            s sVar = arrayList.get(i2);
            if (sVar == null) {
                return null;
            }
            if (sVar.f412b == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            return (z ? this.z : this.y).get(i);
        }
        return null;
    }

    public String toString() {
        return b0("");
    }

    public String u() {
        return this.f;
    }

    public g v() {
        return this.K;
    }

    public p w() {
        return this.H;
    }

    public long y() {
        return this.g;
    }

    public List<Integer> z() {
        return this.j;
    }
}
