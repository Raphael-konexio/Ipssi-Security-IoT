package a.p;

import a.g.g.b;
import a.p.m;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends androidx.fragment.app.w {

    /* loaded from: classes.dex */
    class a extends m.e {
        a(e eVar, Rect rect) {
        }
    }

    /* loaded from: classes.dex */
    class b implements m.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f361a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f362b;

        b(e eVar, View view, ArrayList arrayList) {
            this.f361a = view;
            this.f362b = arrayList;
        }

        @Override // a.p.m.f
        public void a(m mVar) {
            mVar.P(this);
            mVar.a(this);
        }

        @Override // a.p.m.f
        public void b(m mVar) {
        }

        @Override // a.p.m.f
        public void c(m mVar) {
        }

        @Override // a.p.m.f
        public void d(m mVar) {
        }

        @Override // a.p.m.f
        public void e(m mVar) {
            mVar.P(this);
            this.f361a.setVisibility(8);
            int size = this.f362b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f362b.get(i)).setVisibility(0);
            }
        }
    }

    /* loaded from: classes.dex */
    class c extends n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f363a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f364b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f365c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f366d;
        final /* synthetic */ Object e;
        final /* synthetic */ ArrayList f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f363a = obj;
            this.f364b = arrayList;
            this.f365c = obj2;
            this.f366d = arrayList2;
            this.e = obj3;
            this.f = arrayList3;
        }

        @Override // a.p.n, a.p.m.f
        public void a(m mVar) {
            Object obj = this.f363a;
            if (obj != null) {
                e.this.q(obj, this.f364b, null);
            }
            Object obj2 = this.f365c;
            if (obj2 != null) {
                e.this.q(obj2, this.f366d, null);
            }
            Object obj3 = this.e;
            if (obj3 != null) {
                e.this.q(obj3, this.f, null);
            }
        }

        @Override // a.p.m.f
        public void e(m mVar) {
            mVar.P(this);
        }
    }

    /* loaded from: classes.dex */
    class d implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f367a;

        d(e eVar, m mVar) {
            this.f367a = mVar;
        }

        @Override // a.g.g.b.a
        public void a() {
            this.f367a.f();
        }
    }

    /* renamed from: a.p.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0027e implements m.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f368a;

        C0027e(e eVar, Runnable runnable) {
            this.f368a = runnable;
        }

        @Override // a.p.m.f
        public void a(m mVar) {
        }

        @Override // a.p.m.f
        public void b(m mVar) {
        }

        @Override // a.p.m.f
        public void c(m mVar) {
        }

        @Override // a.p.m.f
        public void d(m mVar) {
        }

        @Override // a.p.m.f
        public void e(m mVar) {
            this.f368a.run();
        }
    }

    /* loaded from: classes.dex */
    class f extends m.e {
        f(e eVar, Rect rect) {
        }
    }

    private static boolean C(m mVar) {
        return (androidx.fragment.app.w.l(mVar.z()) && androidx.fragment.app.w.l(mVar.A()) && androidx.fragment.app.w.l(mVar.B())) ? false : true;
    }

    @Override // androidx.fragment.app.w
    public void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        q qVar = (q) obj;
        if (qVar != null) {
            qVar.C().clear();
            qVar.C().addAll(arrayList2);
            q(qVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.w
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        q qVar = new q();
        qVar.e0((m) obj);
        return qVar;
    }

    @Override // androidx.fragment.app.w
    public void a(Object obj, View view) {
        if (obj != null) {
            ((m) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.w
    public void b(Object obj, ArrayList<View> arrayList) {
        m mVar = (m) obj;
        if (mVar == null) {
            return;
        }
        int i = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int h0 = qVar.h0();
            while (i < h0) {
                b(qVar.g0(i), arrayList);
                i++;
            }
        } else if (C(mVar) || !androidx.fragment.app.w.l(mVar.C())) {
        } else {
            int size = arrayList.size();
            while (i < size) {
                mVar.b(arrayList.get(i));
                i++;
            }
        }
    }

    @Override // androidx.fragment.app.w
    public void c(ViewGroup viewGroup, Object obj) {
        o.a(viewGroup, (m) obj);
    }

    @Override // androidx.fragment.app.w
    public boolean e(Object obj) {
        return obj instanceof m;
    }

    @Override // androidx.fragment.app.w
    public Object g(Object obj) {
        if (obj != null) {
            return ((m) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.w
    public Object m(Object obj, Object obj2, Object obj3) {
        m mVar = (m) obj;
        m mVar2 = (m) obj2;
        m mVar3 = (m) obj3;
        if (mVar != null && mVar2 != null) {
            q qVar = new q();
            qVar.e0(mVar);
            qVar.e0(mVar2);
            qVar.m0(1);
            mVar = qVar;
        } else if (mVar == null) {
            mVar = mVar2 != null ? mVar2 : null;
        }
        if (mVar3 != null) {
            q qVar2 = new q();
            if (mVar != null) {
                qVar2.e0(mVar);
            }
            qVar2.e0(mVar3);
            return qVar2;
        }
        return mVar;
    }

    @Override // androidx.fragment.app.w
    public Object n(Object obj, Object obj2, Object obj3) {
        q qVar = new q();
        if (obj != null) {
            qVar.e0((m) obj);
        }
        if (obj2 != null) {
            qVar.e0((m) obj2);
        }
        if (obj3 != null) {
            qVar.e0((m) obj3);
        }
        return qVar;
    }

    @Override // androidx.fragment.app.w
    public void p(Object obj, View view) {
        if (obj != null) {
            ((m) obj).Q(view);
        }
    }

    @Override // androidx.fragment.app.w
    public void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        m mVar = (m) obj;
        int i = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int h0 = qVar.h0();
            while (i < h0) {
                q(qVar.g0(i), arrayList, arrayList2);
                i++;
            }
        } else if (!C(mVar)) {
            List<View> C = mVar.C();
            if (C.size() == arrayList.size() && C.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i < size) {
                    mVar.b(arrayList2.get(i));
                    i++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    mVar.Q(arrayList.get(size2));
                }
            }
        }
    }

    @Override // androidx.fragment.app.w
    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((m) obj).a(new b(this, view, arrayList));
    }

    @Override // androidx.fragment.app.w
    public void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((m) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.w
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((m) obj).V(new f(this, rect));
        }
    }

    @Override // androidx.fragment.app.w
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((m) obj).V(new a(this, rect));
        }
    }

    @Override // androidx.fragment.app.w
    public void w(Fragment fragment, Object obj, a.g.g.b bVar, Runnable runnable) {
        m mVar = (m) obj;
        bVar.c(new d(this, mVar));
        mVar.a(new C0027e(this, runnable));
    }

    @Override // androidx.fragment.app.w
    public void z(Object obj, View view, ArrayList<View> arrayList) {
        q qVar = (q) obj;
        List<View> C = qVar.C();
        C.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            androidx.fragment.app.w.d(C, arrayList.get(i));
        }
        C.add(view);
        arrayList.add(view);
        b(qVar, arrayList);
    }
}
