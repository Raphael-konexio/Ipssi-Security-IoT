package androidx.recyclerview.widget;

import a.g.k.s;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class k extends a.g.k.a {

    /* renamed from: d  reason: collision with root package name */
    final RecyclerView f1108d;
    private final a e;

    /* loaded from: classes.dex */
    public static class a extends a.g.k.a {

        /* renamed from: d  reason: collision with root package name */
        final k f1109d;
        private Map<View, a.g.k.a> e = new WeakHashMap();

        public a(k kVar) {
            this.f1109d = kVar;
        }

        @Override // a.g.k.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            a.g.k.a aVar = this.e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Override // a.g.k.a
        public a.g.k.b0.d b(View view) {
            a.g.k.a aVar = this.e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // a.g.k.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            a.g.k.a aVar = this.e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // a.g.k.a
        public void g(View view, a.g.k.b0.c cVar) {
            if (!this.f1109d.o() && this.f1109d.f1108d.getLayoutManager() != null) {
                this.f1109d.f1108d.getLayoutManager().O0(view, cVar);
                a.g.k.a aVar = this.e.get(view);
                if (aVar != null) {
                    aVar.g(view, cVar);
                    return;
                }
            }
            super.g(view, cVar);
        }

        @Override // a.g.k.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            a.g.k.a aVar = this.e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // a.g.k.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            a.g.k.a aVar = this.e.get(viewGroup);
            return aVar != null ? aVar.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // a.g.k.a
        public boolean j(View view, int i, Bundle bundle) {
            if (this.f1109d.o() || this.f1109d.f1108d.getLayoutManager() == null) {
                return super.j(view, i, bundle);
            }
            a.g.k.a aVar = this.e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i, bundle)) {
                    return true;
                }
            } else if (super.j(view, i, bundle)) {
                return true;
            }
            return this.f1109d.f1108d.getLayoutManager().i1(view, i, bundle);
        }

        @Override // a.g.k.a
        public void l(View view, int i) {
            a.g.k.a aVar = this.e.get(view);
            if (aVar != null) {
                aVar.l(view, i);
            } else {
                super.l(view, i);
            }
        }

        @Override // a.g.k.a
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            a.g.k.a aVar = this.e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a.g.k.a n(View view) {
            return this.e.remove(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void o(View view) {
            a.g.k.a h = s.h(view);
            if (h == null || h == this) {
                return;
            }
            this.e.put(view, h);
        }
    }

    public k(RecyclerView recyclerView) {
        this.f1108d = recyclerView;
        a.g.k.a n = n();
        this.e = (n == null || !(n instanceof a)) ? new a(this) : (a) n;
    }

    @Override // a.g.k.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().K0(accessibilityEvent);
        }
    }

    @Override // a.g.k.a
    public void g(View view, a.g.k.b0.c cVar) {
        super.g(view, cVar);
        if (o() || this.f1108d.getLayoutManager() == null) {
            return;
        }
        this.f1108d.getLayoutManager().M0(cVar);
    }

    @Override // a.g.k.a
    public boolean j(View view, int i, Bundle bundle) {
        if (super.j(view, i, bundle)) {
            return true;
        }
        if (o() || this.f1108d.getLayoutManager() == null) {
            return false;
        }
        return this.f1108d.getLayoutManager().g1(i, bundle);
    }

    public a.g.k.a n() {
        return this.e;
    }

    boolean o() {
        return this.f1108d.hasPendingAdapterUpdates();
    }
}
