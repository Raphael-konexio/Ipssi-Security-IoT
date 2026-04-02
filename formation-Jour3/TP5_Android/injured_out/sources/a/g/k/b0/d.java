package a.g.k.b0;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final Object f252a;

    /* loaded from: classes.dex */
    static class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        final d f253a;

        a(d dVar) {
            this.f253a = dVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            a.g.k.b0.c b2 = this.f253a.b(i);
            if (b2 == null) {
                return null;
            }
            return b2.u0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<a.g.k.b0.c> c2 = this.f253a.c(str, i);
            if (c2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(c2.get(i2).u0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f253a.f(i, i2, bundle);
        }
    }

    /* loaded from: classes.dex */
    static class b extends a {
        b(d dVar) {
            super(dVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            a.g.k.b0.c d2 = this.f253a.d(i);
            if (d2 == null) {
                return null;
            }
            return d2.u0();
        }
    }

    /* loaded from: classes.dex */
    static class c extends b {
        c(d dVar) {
            super(dVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f253a.a(i, a.g.k.b0.c.v0(accessibilityNodeInfo), str, bundle);
        }
    }

    public d() {
        int i = Build.VERSION.SDK_INT;
        this.f252a = i >= 26 ? new c(this) : i >= 19 ? new b(this) : i >= 16 ? new a(this) : null;
    }

    public d(Object obj) {
        this.f252a = obj;
    }

    public void a(int i, a.g.k.b0.c cVar, String str, Bundle bundle) {
    }

    public a.g.k.b0.c b(int i) {
        return null;
    }

    public List<a.g.k.b0.c> c(String str, int i) {
        return null;
    }

    public a.g.k.b0.c d(int i) {
        return null;
    }

    public Object e() {
        return this.f252a;
    }

    public boolean f(int i, int i2, Bundle bundle) {
        return false;
    }
}
