package a.g.k;

import a.g.k.b0.c;
import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final View.AccessibilityDelegate f222c = new View.AccessibilityDelegate();

    /* renamed from: a  reason: collision with root package name */
    private final View.AccessibilityDelegate f223a;

    /* renamed from: b  reason: collision with root package name */
    private final View.AccessibilityDelegate f224b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a.g.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0011a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        final a f225a;

        C0011a(a aVar) {
            this.f225a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f225a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            a.g.k.b0.d b2 = this.f225a.b(view);
            if (b2 != null) {
                return (AccessibilityNodeProvider) b2.e();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f225a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            a.g.k.b0.c v0 = a.g.k.b0.c.v0(accessibilityNodeInfo);
            v0.n0(s.P(view));
            v0.h0(s.K(view));
            v0.k0(s.l(view));
            v0.r0(s.D(view));
            this.f225a.g(view, v0);
            v0.e(accessibilityNodeInfo.getText(), view);
            List<c.a> c2 = a.c(view);
            for (int i = 0; i < c2.size(); i++) {
                v0.b(c2.get(i));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f225a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f225a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f225a.j(view, i, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.f225a.l(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f225a.m(view, accessibilityEvent);
        }
    }

    public a() {
        this(f222c);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f223a = accessibilityDelegate;
        this.f224b = new C0011a(this);
    }

    static List<c.a> c(View view) {
        List<c.a> list = (List) view.getTag(a.g.b.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] p = a.g.k.b0.c.p(view.createAccessibilityNodeInfo().getText());
            for (int i = 0; p != null && i < p.length; i++) {
                if (clickableSpan.equals(p[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean k(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(a.g.b.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (e(clickableSpan, view)) {
            clickableSpan.onClick(view);
            return true;
        }
        return false;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f223a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public a.g.k.b0.d b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.f223a.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new a.g.k.b0.d(accessibilityNodeProvider);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.AccessibilityDelegate d() {
        return this.f224b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f223a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, a.g.k.b0.c cVar) {
        this.f223a.onInitializeAccessibilityNodeInfo(view, cVar.u0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f223a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f223a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i, Bundle bundle) {
        List<c.a> c2 = c(view);
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= c2.size()) {
                break;
            }
            c.a aVar = c2.get(i2);
            if (aVar.b() == i) {
                z = aVar.d(view, bundle);
                break;
            }
            i2++;
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = this.f223a.performAccessibilityAction(view, i, bundle);
        }
        return (z || i != a.g.b.accessibility_action_clickable_span) ? z : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i) {
        this.f223a.sendAccessibilityEvent(view, i);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f223a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
