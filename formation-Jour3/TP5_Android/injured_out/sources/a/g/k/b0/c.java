package a.g.k.b0;

import a.g.k.b0.f;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    private static int f242d;

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityNodeInfo f243a;

    /* renamed from: b  reason: collision with root package name */
    public int f244b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f245c = -1;

    /* loaded from: classes.dex */
    public static class a {
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final a j;
        public static final a k;
        public static final a l;

        /* renamed from: a  reason: collision with root package name */
        final Object f246a;

        /* renamed from: b  reason: collision with root package name */
        private final int f247b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<? extends f.a> f248c;

        /* renamed from: d  reason: collision with root package name */
        protected final f f249d;

        static {
            new a(1, null);
            new a(2, null);
            new a(4, null);
            new a(8, null);
            e = new a(16, null);
            new a(32, null);
            new a(64, null);
            new a(128, null);
            new a(256, null, f.b.class);
            new a(512, null, f.b.class);
            new a(1024, null, f.c.class);
            new a(2048, null, f.c.class);
            f = new a(4096, null);
            g = new a(8192, null);
            new a(16384, null);
            new a(32768, null);
            new a(65536, null);
            new a(131072, null, f.g.class);
            h = new a(262144, null);
            i = new a(524288, null);
            j = new a(1048576, null);
            new a(2097152, null, f.h.class);
            new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, null, null, null);
            new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, null, null, f.e.class);
            k = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, null, null, null);
            new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, null, null, null);
            l = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, null, null, null);
            new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, null, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, null, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, null, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, null, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, null, null, null);
            new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, null, null, null);
            new a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, null, null, f.C0014f.class);
            new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, null, null, f.d.class);
            new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, null, null, null);
            new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, 16908357, null, null, null);
            new a(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, null, null, null);
            new a(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, 16908372, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        private a(int i2, CharSequence charSequence, Class<? extends f.a> cls) {
            this(null, i2, charSequence, null, cls);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        a(Object obj, int i2, CharSequence charSequence, f fVar, Class<? extends f.a> cls) {
            this.f247b = i2;
            this.f249d = fVar;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                obj = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            }
            this.f246a = obj;
            this.f248c = cls;
        }

        public a a(CharSequence charSequence, f fVar) {
            return new a(null, this.f247b, charSequence, fVar, this.f248c);
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f246a).getId();
            }
            return 0;
        }

        public CharSequence c() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f246a).getLabel();
            }
            return null;
        }

        public boolean d(View view, Bundle bundle) {
            f.a newInstance;
            if (this.f249d != null) {
                f.a aVar = null;
                Class<? extends f.a> cls = this.f248c;
                if (cls != null) {
                    try {
                        newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    } catch (Exception e2) {
                        e = e2;
                    }
                    try {
                        newInstance.a(bundle);
                        aVar = newInstance;
                    } catch (Exception e3) {
                        e = e3;
                        aVar = newInstance;
                        Class<? extends f.a> cls2 = this.f248c;
                        String name = cls2 == null ? "null" : cls2.getName();
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + name, e);
                        return this.f249d.a(view, aVar);
                    }
                }
                return this.f249d.a(view, aVar);
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof a)) {
                Object obj2 = this.f246a;
                Object obj3 = ((a) obj).f246a;
                return obj2 == null ? obj3 == null : obj2.equals(obj3);
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.f246a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f250a;

        b(Object obj) {
            this.f250a = obj;
        }

        public static b a(int i, int i2, boolean z, int i3) {
            int i4 = Build.VERSION.SDK_INT;
            return i4 >= 21 ? new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3)) : i4 >= 19 ? new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z)) : new b(null);
        }
    }

    /* renamed from: a.g.k.b0.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013c {

        /* renamed from: a  reason: collision with root package name */
        final Object f251a;

        C0013c(Object obj) {
            this.f251a = obj;
        }

        public static C0013c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            int i5 = Build.VERSION.SDK_INT;
            return i5 >= 21 ? new C0013c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2)) : i5 >= 19 ? new C0013c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z)) : new C0013c(null);
        }
    }

    private c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f243a = accessibilityNodeInfo;
    }

    public static c K() {
        return v0(AccessibilityNodeInfo.obtain());
    }

    public static c L(View view) {
        return v0(AccessibilityNodeInfo.obtain(view));
    }

    public static c M(c cVar) {
        return v0(AccessibilityNodeInfo.obtain(cVar.f243a));
    }

    private void P(View view) {
        SparseArray<WeakReference<ClickableSpan>> u = u(view);
        if (u != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < u.size(); i++) {
                if (u.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                u.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    private void R(int i, boolean z) {
        Bundle r = r();
        if (r != null) {
            int i2 = r.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            r.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }

    private void d(ClickableSpan clickableSpan, Spanned spanned, int i) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f243a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f243a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f243a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f243a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private List<Integer> g(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f243a.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            this.f243a.getExtras().putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    private static String i(int i) {
        if (i != 1) {
            if (i != 2) {
                switch (i) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case 256:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case 512:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case 8192:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case 131072:
                        return "ACTION_SET_SELECTION";
                    case 262144:
                        return "ACTION_EXPAND";
                    case 524288:
                        return "ACTION_COLLAPSE";
                    case 2097152:
                        return "ACTION_SET_TEXT";
                    case 16908354:
                        return "ACTION_MOVE_WINDOW";
                    case 16908372:
                        return "ACTION_IME_ENTER";
                    default:
                        switch (i) {
                            case 16908342:
                                return "ACTION_SHOW_ON_SCREEN";
                            case 16908343:
                                return "ACTION_SCROLL_TO_POSITION";
                            case 16908344:
                                return "ACTION_SCROLL_UP";
                            case 16908345:
                                return "ACTION_SCROLL_LEFT";
                            case 16908346:
                                return "ACTION_SCROLL_DOWN";
                            case 16908347:
                                return "ACTION_SCROLL_RIGHT";
                            case 16908348:
                                return "ACTION_CONTEXT_CLICK";
                            case 16908349:
                                return "ACTION_SET_PROGRESS";
                            default:
                                switch (i) {
                                    case 16908356:
                                        return "ACTION_SHOW_TOOLTIP";
                                    case 16908357:
                                        return "ACTION_HIDE_TOOLTIP";
                                    case 16908358:
                                        return "ACTION_PAGE_UP";
                                    case 16908359:
                                        return "ACTION_PAGE_DOWN";
                                    case 16908360:
                                        return "ACTION_PAGE_LEFT";
                                    case 16908361:
                                        return "ACTION_PAGE_RIGHT";
                                    case 16908362:
                                        return "ACTION_PRESS_AND_HOLD";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    private boolean k(int i) {
        Bundle r = r();
        return r != null && (r.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i) == i;
    }

    public static ClickableSpan[] p(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> s(View view) {
        SparseArray<WeakReference<ClickableSpan>> u = u(view);
        if (u == null) {
            SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
            view.setTag(a.g.b.tag_accessibility_clickable_spans, sparseArray);
            return sparseArray;
        }
        return u;
    }

    private SparseArray<WeakReference<ClickableSpan>> u(View view) {
        return (SparseArray) view.getTag(a.g.b.tag_accessibility_clickable_spans);
    }

    public static c v0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    private boolean x() {
        return !g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int y(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals(sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = f242d;
        f242d = i2 + 1;
        return i2;
    }

    public boolean A() {
        return this.f243a.isChecked();
    }

    public boolean B() {
        return this.f243a.isClickable();
    }

    public boolean C() {
        return this.f243a.isEnabled();
    }

    public boolean D() {
        return this.f243a.isFocusable();
    }

    public boolean E() {
        return this.f243a.isFocused();
    }

    public boolean F() {
        return this.f243a.isLongClickable();
    }

    public boolean G() {
        return this.f243a.isPassword();
    }

    public boolean H() {
        return this.f243a.isScrollable();
    }

    public boolean I() {
        return this.f243a.isSelected();
    }

    public boolean J() {
        return Build.VERSION.SDK_INT >= 26 ? this.f243a.isShowingHintText() : k(4);
    }

    public boolean N(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f243a.performAction(i, bundle);
        }
        return false;
    }

    public void O() {
        this.f243a.recycle();
    }

    public void Q(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f243a.setAccessibilityFocused(z);
        }
    }

    @Deprecated
    public void S(Rect rect) {
        this.f243a.setBoundsInParent(rect);
    }

    public void T(Rect rect) {
        this.f243a.setBoundsInScreen(rect);
    }

    public void U(boolean z) {
        this.f243a.setCheckable(z);
    }

    public void V(boolean z) {
        this.f243a.setChecked(z);
    }

    public void W(CharSequence charSequence) {
        this.f243a.setClassName(charSequence);
    }

    public void X(boolean z) {
        this.f243a.setClickable(z);
    }

    public void Y(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f243a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f250a);
        }
    }

    public void Z(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f243a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((C0013c) obj).f251a);
        }
    }

    public void a(int i) {
        this.f243a.addAction(i);
    }

    public void a0(CharSequence charSequence) {
        this.f243a.setContentDescription(charSequence);
    }

    public void b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f243a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f246a);
        }
    }

    public void b0(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f243a.setContentInvalid(z);
        }
    }

    public void c(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f243a.addChild(view, i);
        }
    }

    public void c0(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f243a.setDismissable(z);
        }
    }

    public void d0(boolean z) {
        this.f243a.setEnabled(z);
    }

    public void e(CharSequence charSequence, View view) {
        int i = Build.VERSION.SDK_INT;
        if (i < 19 || i >= 26) {
            return;
        }
        f();
        P(view);
        ClickableSpan[] p = p(charSequence);
        if (p == null || p.length <= 0) {
            return;
        }
        r().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", a.g.b.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> s = s(view);
        for (int i2 = 0; p != null && i2 < p.length; i2++) {
            int y = y(p[i2], s);
            s.put(y, new WeakReference<>(p[i2]));
            d(p[i2], (Spanned) charSequence, y);
        }
    }

    public void e0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f243a.setError(charSequence);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof c)) {
            c cVar = (c) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = this.f243a;
            if (accessibilityNodeInfo == null) {
                if (cVar.f243a != null) {
                    return false;
                }
            } else if (!accessibilityNodeInfo.equals(cVar.f243a)) {
                return false;
            }
            return this.f245c == cVar.f245c && this.f244b == cVar.f244b;
        }
        return false;
    }

    public void f0(boolean z) {
        this.f243a.setFocusable(z);
    }

    public void g0(boolean z) {
        this.f243a.setFocused(z);
    }

    public List<a> h() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f243a.getActionList() : null;
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            int size = actionList.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new a(actionList.get(i)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void h0(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f243a.setHeading(z);
        } else {
            R(2, z);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f243a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i0(CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.f243a.setHintText(charSequence);
        } else if (i >= 19) {
            this.f243a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public int j() {
        return this.f243a.getActions();
    }

    public void j0(CharSequence charSequence) {
        this.f243a.setPackageName(charSequence);
    }

    public void k0(CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            this.f243a.setPaneTitle(charSequence);
        } else if (i >= 19) {
            this.f243a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    @Deprecated
    public void l(Rect rect) {
        this.f243a.getBoundsInParent(rect);
    }

    public void l0(View view) {
        this.f244b = -1;
        this.f243a.setParent(view);
    }

    public void m(Rect rect) {
        this.f243a.getBoundsInScreen(rect);
    }

    public void m0(View view, int i) {
        this.f244b = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f243a.setParent(view, i);
        }
    }

    public int n() {
        return this.f243a.getChildCount();
    }

    public void n0(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f243a.setScreenReaderFocusable(z);
        } else {
            R(1, z);
        }
    }

    public CharSequence o() {
        return this.f243a.getClassName();
    }

    public void o0(boolean z) {
        this.f243a.setScrollable(z);
    }

    public void p0(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f243a.setShowingHintText(z);
        } else {
            R(4, z);
        }
    }

    public CharSequence q() {
        return this.f243a.getContentDescription();
    }

    public void q0(View view, int i) {
        this.f245c = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f243a.setSource(view, i);
        }
    }

    public Bundle r() {
        return Build.VERSION.SDK_INT >= 19 ? this.f243a.getExtras() : new Bundle();
    }

    public void r0(CharSequence charSequence) {
        if (a.g.g.a.a()) {
            this.f243a.setStateDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f243a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public void s0(CharSequence charSequence) {
        this.f243a.setText(charSequence);
    }

    public CharSequence t() {
        return this.f243a.getPackageName();
    }

    public void t0(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f243a.setVisibleToUser(z);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        l(rect);
        sb.append("; boundsInParent: " + rect);
        m(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(t());
        sb.append("; className: ");
        sb.append(o());
        sb.append("; text: ");
        sb.append(v());
        sb.append("; contentDescription: ");
        sb.append(q());
        sb.append("; viewId: ");
        sb.append(w());
        sb.append("; checkable: ");
        sb.append(z());
        sb.append("; checked: ");
        sb.append(A());
        sb.append("; focusable: ");
        sb.append(D());
        sb.append("; focused: ");
        sb.append(E());
        sb.append("; selected: ");
        sb.append(I());
        sb.append("; clickable: ");
        sb.append(B());
        sb.append("; longClickable: ");
        sb.append(F());
        sb.append("; enabled: ");
        sb.append(C());
        sb.append("; password: ");
        sb.append(G());
        sb.append("; scrollable: " + H());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> h = h();
            for (int i = 0; i < h.size(); i++) {
                a aVar = h.get(i);
                String i2 = i(aVar.b());
                if (i2.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                    i2 = aVar.c().toString();
                }
                sb.append(i2);
                if (i != h.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int j = j();
            while (j != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(j);
                j &= ~numberOfTrailingZeros;
                sb.append(i(numberOfTrailingZeros));
                if (j != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public AccessibilityNodeInfo u0() {
        return this.f243a;
    }

    public CharSequence v() {
        if (x()) {
            List<Integer> g = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List<Integer> g2 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List<Integer> g3 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List<Integer> g4 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.f243a.getText(), 0, this.f243a.getText().length()));
            for (int i = 0; i < g.size(); i++) {
                spannableString.setSpan(new a.g.k.b0.a(g4.get(i).intValue(), this, r().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), g.get(i).intValue(), g2.get(i).intValue(), g3.get(i).intValue());
            }
            return spannableString;
        }
        return this.f243a.getText();
    }

    public String w() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f243a.getViewIdResourceName();
        }
        return null;
    }

    public boolean z() {
        return this.f243a.isCheckable();
    }
}
