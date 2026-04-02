package a.p;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static m f401a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static ThreadLocal<WeakReference<a.d.a<ViewGroup, ArrayList<m>>>> f402b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    static ArrayList<ViewGroup> f403c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        m f;
        ViewGroup g;

        /* renamed from: a.p.o$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0028a extends n {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a.d.a f404a;

            C0028a(a.d.a aVar) {
                this.f404a = aVar;
            }

            @Override // a.p.m.f
            public void e(m mVar) {
                ((ArrayList) this.f404a.get(a.this.g)).remove(mVar);
                mVar.P(this);
            }
        }

        a(m mVar, ViewGroup viewGroup) {
            this.f = mVar;
            this.g = viewGroup;
        }

        private void a() {
            this.g.getViewTreeObserver().removeOnPreDrawListener(this);
            this.g.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (o.f403c.remove(this.g)) {
                a.d.a<ViewGroup, ArrayList<m>> b2 = o.b();
                ArrayList<m> arrayList = b2.get(this.g);
                ArrayList arrayList2 = null;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    b2.put(this.g, arrayList);
                } else if (arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                }
                arrayList.add(this.f);
                this.f.a(new C0028a(b2));
                this.f.k(this.g, false);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((m) it.next()).R(this.g);
                    }
                }
                this.f.O(this.g);
                return true;
            }
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            o.f403c.remove(this.g);
            ArrayList<m> arrayList = o.b().get(this.g);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().R(this.g);
                }
            }
            this.f.l(true);
        }
    }

    public static void a(ViewGroup viewGroup, m mVar) {
        if (f403c.contains(viewGroup) || !a.g.k.s.M(viewGroup)) {
            return;
        }
        f403c.add(viewGroup);
        if (mVar == null) {
            mVar = f401a;
        }
        m clone = mVar.clone();
        d(viewGroup, clone);
        l.c(viewGroup, null);
        c(viewGroup, clone);
    }

    static a.d.a<ViewGroup, ArrayList<m>> b() {
        a.d.a<ViewGroup, ArrayList<m>> aVar;
        WeakReference<a.d.a<ViewGroup, ArrayList<m>>> weakReference = f402b.get();
        if (weakReference == null || (aVar = weakReference.get()) == null) {
            a.d.a<ViewGroup, ArrayList<m>> aVar2 = new a.d.a<>();
            f402b.set(new WeakReference<>(aVar2));
            return aVar2;
        }
        return aVar;
    }

    private static void c(ViewGroup viewGroup, m mVar) {
        if (mVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(mVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, m mVar) {
        ArrayList<m> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().N(viewGroup);
            }
        }
        if (mVar != null) {
            mVar.k(viewGroup, true);
        }
        l b2 = l.b(viewGroup);
        if (b2 != null) {
            b2.a();
        }
    }
}
