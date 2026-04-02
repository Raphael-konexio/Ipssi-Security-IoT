package io.flutter.plugin.editing;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.engine.i.m;
import io.flutter.plugin.editing.c;
import io.flutter.plugin.platform.j;
import java.util.HashMap;
/* loaded from: classes.dex */
public class d implements c.b {

    /* renamed from: a  reason: collision with root package name */
    private final View f2619a;

    /* renamed from: b  reason: collision with root package name */
    private final InputMethodManager f2620b;

    /* renamed from: c  reason: collision with root package name */
    private final AutofillManager f2621c;

    /* renamed from: d  reason: collision with root package name */
    private final m f2622d;
    private c e = new c(c.a.NO_TARGET, 0);
    private m.b f;
    private SparseArray<m.b> g;
    private io.flutter.plugin.editing.c h;
    private boolean i;
    private InputConnection j;
    private j k;
    private Rect l;
    private final boolean m;
    private ImeSyncDeferringInsetsCallback n;
    private io.flutter.embedding.android.a o;
    private m.e p;
    private boolean q;

    /* loaded from: classes.dex */
    class a implements m.f {
        a() {
        }

        @Override // io.flutter.embedding.engine.i.m.f
        public void a() {
            d dVar = d.this;
            dVar.E(dVar.f2619a);
        }

        @Override // io.flutter.embedding.engine.i.m.f
        public void b() {
            d.this.k();
        }

        @Override // io.flutter.embedding.engine.i.m.f
        public void c(int i, m.b bVar) {
            d.this.C(i, bVar);
        }

        @Override // io.flutter.embedding.engine.i.m.f
        public void d(m.e eVar) {
            d dVar = d.this;
            dVar.D(dVar.f2619a, eVar);
        }

        @Override // io.flutter.embedding.engine.i.m.f
        public void e(String str, Bundle bundle) {
            d.this.z(str, bundle);
        }

        @Override // io.flutter.embedding.engine.i.m.f
        public void f(int i) {
            d.this.B(i);
        }

        @Override // io.flutter.embedding.engine.i.m.f
        public void g(double d2, double d3, double[] dArr) {
            d.this.y(d2, d3, dArr);
        }

        @Override // io.flutter.embedding.engine.i.m.f
        public void h() {
            d.this.v();
        }

        @Override // io.flutter.embedding.engine.i.m.f
        public void i(boolean z) {
            if (Build.VERSION.SDK_INT < 26 || d.this.f2621c == null) {
                return;
            }
            if (z) {
                d.this.f2621c.commit();
            } else {
                d.this.f2621c.cancel();
            }
        }

        @Override // io.flutter.embedding.engine.i.m.f
        public void j() {
            d dVar = d.this;
            dVar.p(dVar.f2619a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements InterfaceC0126d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f2624a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ double[] f2625b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ double[] f2626c;

        b(d dVar, boolean z, double[] dArr, double[] dArr2) {
            this.f2624a = z;
            this.f2625b = dArr;
            this.f2626c = dArr2;
        }

        @Override // io.flutter.plugin.editing.d.InterfaceC0126d
        public void a(double d2, double d3) {
            double d4 = 1.0d;
            if (!this.f2624a) {
                double[] dArr = this.f2625b;
                d4 = 1.0d / (((dArr[3] * d2) + (dArr[7] * d3)) + dArr[15]);
            }
            double[] dArr2 = this.f2625b;
            double d5 = ((dArr2[0] * d2) + (dArr2[4] * d3) + dArr2[12]) * d4;
            double d6 = ((dArr2[1] * d2) + (dArr2[5] * d3) + dArr2[13]) * d4;
            double[] dArr3 = this.f2626c;
            if (d5 < dArr3[0]) {
                dArr3[0] = d5;
            } else if (d5 > dArr3[1]) {
                dArr3[1] = d5;
            }
            double[] dArr4 = this.f2626c;
            if (d6 < dArr4[2]) {
                dArr4[2] = d6;
            } else if (d6 > dArr4[3]) {
                dArr4[3] = d6;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        a f2627a;

        /* renamed from: b  reason: collision with root package name */
        int f2628b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum a {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            PLATFORM_VIEW
        }

        public c(a aVar, int i) {
            this.f2627a = aVar;
            this.f2628b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io.flutter.plugin.editing.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0126d {
        void a(double d2, double d3);
    }

    public d(View view, m mVar, j jVar) {
        this.f2619a = view;
        this.f2620b = (InputMethodManager) view.getContext().getSystemService("input_method");
        this.f2621c = Build.VERSION.SDK_INT >= 26 ? (AutofillManager) view.getContext().getSystemService(AutofillManager.class) : null;
        if (Build.VERSION.SDK_INT >= 30) {
            int navigationBars = (this.f2619a.getWindowSystemUiVisibility() & 2) == 0 ? 0 | WindowInsets.Type.navigationBars() : 0;
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view, (this.f2619a.getWindowSystemUiVisibility() & 4) == 0 ? navigationBars | WindowInsets.Type.statusBars() : navigationBars, WindowInsets.Type.ime());
            this.n = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
        }
        this.f2622d = mVar;
        mVar.l(new a());
        mVar.i();
        this.k = jVar;
        jVar.u(this);
        this.m = r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i) {
        this.f2619a.requestFocus();
        this.e = new c(c.a.PLATFORM_VIEW, i);
        this.f2620b.restartInput(this.f2619a);
        this.i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(View view) {
        view.requestFocus();
        this.f2620b.showSoftInput(view, 0);
    }

    private void G(m.b bVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (bVar == null || bVar.h == null) {
            this.g = null;
            return;
        }
        m.b[] bVarArr = bVar.i;
        SparseArray<m.b> sparseArray = new SparseArray<>();
        this.g = sparseArray;
        if (bVarArr == null) {
            sparseArray.put(bVar.h.f2587a.hashCode(), bVar);
            return;
        }
        for (m.b bVar2 : bVarArr) {
            m.b.a aVar = bVar2.h;
            if (aVar != null) {
                this.g.put(aVar.f2587a.hashCode(), bVar2);
                this.f2621c.notifyValueChanged(this.f2619a, aVar.f2587a.hashCode(), AutofillValue.forText(aVar.f2589c.f2593a));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(View view) {
        w();
        this.f2620b.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    private static int q(m.c cVar, boolean z, boolean z2, boolean z3, m.d dVar) {
        m.g gVar = cVar.f2590a;
        if (gVar == m.g.DATETIME) {
            return 4;
        }
        if (gVar == m.g.NUMBER) {
            int i = cVar.f2591b ? 4098 : 2;
            return cVar.f2592c ? i | 8192 : i;
        } else if (gVar == m.g.PHONE) {
            return 3;
        } else {
            int i2 = 1;
            if (gVar == m.g.MULTILINE) {
                i2 = 131073;
            } else if (gVar == m.g.EMAIL_ADDRESS) {
                i2 = 33;
            } else if (gVar == m.g.URL) {
                i2 = 17;
            } else if (gVar == m.g.VISIBLE_PASSWORD) {
                i2 = 145;
            } else if (gVar == m.g.NAME) {
                i2 = 97;
            } else if (gVar == m.g.POSTAL_ADDRESS) {
                i2 = 113;
            }
            if (z) {
                i2 = i2 | 524288 | 128;
            } else {
                if (z2) {
                    i2 |= 32768;
                }
                if (!z3) {
                    i2 |= 524288;
                }
            }
            return dVar == m.d.CHARACTERS ? i2 | 4096 : dVar == m.d.WORDS ? i2 | 8192 : dVar == m.d.SENTENCES ? i2 | 16384 : i2;
        }
    }

    private boolean r() {
        if (this.f2620b.getCurrentInputMethodSubtype() == null || Build.VERSION.SDK_INT < 21 || !Build.MANUFACTURER.equals("samsung")) {
            return false;
        }
        return Settings.Secure.getString(this.f2619a.getContext().getContentResolver(), "default_input_method").contains("Samsung");
    }

    private boolean t() {
        return this.g != null;
    }

    private void u(String str) {
        if (Build.VERSION.SDK_INT < 26 || this.f2621c == null || !t()) {
            return;
        }
        this.f2621c.notifyValueChanged(this.f2619a, this.f.h.f2587a.hashCode(), AutofillValue.forText(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (Build.VERSION.SDK_INT < 26 || this.f2621c == null || !t()) {
            return;
        }
        String str = this.f.h.f2587a;
        int[] iArr = new int[2];
        this.f2619a.getLocationOnScreen(iArr);
        Rect rect = new Rect(this.l);
        rect.offset(iArr[0], iArr[1]);
        this.f2621c.notifyViewEntered(this.f2619a, str.hashCode(), rect);
    }

    private void w() {
        m.b bVar;
        if (Build.VERSION.SDK_INT < 26 || this.f2621c == null || (bVar = this.f) == null || bVar.h == null || !t()) {
            return;
        }
        this.f2621c.notifyViewExited(this.f2619a, this.f.h.f2587a.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(double d2, double d3, double[] dArr) {
        double[] dArr2 = new double[4];
        boolean z = dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d;
        double d4 = dArr[12] / dArr[15];
        dArr2[1] = d4;
        dArr2[0] = d4;
        double d5 = dArr[13] / dArr[15];
        dArr2[3] = d5;
        dArr2[2] = d5;
        b bVar = new b(this, z, dArr, dArr2);
        bVar.a(d2, 0.0d);
        bVar.a(d2, d3);
        bVar.a(0.0d, d3);
        Float valueOf = Float.valueOf(this.f2619a.getContext().getResources().getDisplayMetrics().density);
        this.l = new Rect((int) (dArr2[0] * valueOf.floatValue()), (int) (dArr2[2] * valueOf.floatValue()), (int) Math.ceil(dArr2[1] * valueOf.floatValue()), (int) Math.ceil(dArr2[3] * valueOf.floatValue()));
    }

    public void A(io.flutter.embedding.android.a aVar) {
        this.o = aVar;
    }

    void C(int i, m.b bVar) {
        w();
        this.e = new c(c.a.FRAMEWORK_CLIENT, i);
        io.flutter.plugin.editing.c cVar = this.h;
        if (cVar != null) {
            cVar.j(this);
        }
        m.b.a aVar = bVar.h;
        this.h = new io.flutter.plugin.editing.c(aVar != null ? aVar.f2589c : null, this.f2619a);
        this.f = bVar;
        G(bVar);
        this.i = true;
        F();
        this.l = null;
        this.h.a(this);
    }

    void D(View view, m.e eVar) {
        this.p = eVar;
        this.h.l(eVar);
        if (this.m || this.i) {
            this.f2620b.restartInput(view);
            this.i = false;
        }
    }

    public void F() {
        this.q = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (r7 == r0.e) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // io.flutter.plugin.editing.c.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r9, boolean r10, boolean r11) {
        /*
            r8 = this;
            if (r9 == 0) goto Lb
            io.flutter.plugin.editing.c r9 = r8.h
            java.lang.String r9 = r9.toString()
            r8.u(r9)
        Lb:
            io.flutter.plugin.editing.c r9 = r8.h
            int r9 = r9.g()
            io.flutter.plugin.editing.c r10 = r8.h
            int r10 = r10.f()
            io.flutter.plugin.editing.c r11 = r8.h
            int r11 = r11.e()
            io.flutter.plugin.editing.c r0 = r8.h
            int r7 = r0.d()
            io.flutter.embedding.engine.i.m$e r0 = r8.p
            if (r0 == 0) goto L4c
            io.flutter.plugin.editing.c r0 = r8.h
            java.lang.String r0 = r0.toString()
            io.flutter.embedding.engine.i.m$e r1 = r8.p
            java.lang.String r1 = r1.f2593a
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4a
            io.flutter.embedding.engine.i.m$e r0 = r8.p
            int r1 = r0.f2594b
            if (r9 != r1) goto L4a
            int r1 = r0.f2595c
            if (r10 != r1) goto L4a
            int r1 = r0.f2596d
            if (r11 != r1) goto L4a
            int r0 = r0.e
            if (r7 != r0) goto L4a
            goto L4c
        L4a:
            r0 = 0
            goto L4d
        L4c:
            r0 = 1
        L4d:
            if (r0 != 0) goto L90
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "send EditingState to flutter: "
            r0.append(r1)
            io.flutter.plugin.editing.c r1 = r8.h
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TextInputPlugin"
            c.a.b.d(r1, r0)
            io.flutter.embedding.engine.i.m r0 = r8.f2622d
            io.flutter.plugin.editing.d$c r1 = r8.e
            int r1 = r1.f2628b
            io.flutter.plugin.editing.c r2 = r8.h
            java.lang.String r2 = r2.toString()
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r7
            r0.n(r1, r2, r3, r4, r5, r6)
            io.flutter.embedding.engine.i.m$e r6 = new io.flutter.embedding.engine.i.m$e
            io.flutter.plugin.editing.c r0 = r8.h
            java.lang.String r1 = r0.toString()
            r0 = r6
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r8.p = r6
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.d.a(boolean, boolean, boolean):void");
    }

    public void i(SparseArray<AutofillValue> sparseArray) {
        m.b.a aVar;
        m.b.a aVar2;
        if (Build.VERSION.SDK_INT >= 26 && (aVar = this.f.h) != null) {
            HashMap<String, m.e> hashMap = new HashMap<>();
            for (int i = 0; i < sparseArray.size(); i++) {
                m.b bVar = this.g.get(sparseArray.keyAt(i));
                if (bVar != null && (aVar2 = bVar.h) != null) {
                    String charSequence = sparseArray.valueAt(i).getTextValue().toString();
                    m.e eVar = new m.e(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                    if (aVar2.f2587a.equals(aVar.f2587a)) {
                        D(this.f2619a, eVar);
                    }
                    hashMap.put(aVar2.f2587a, eVar);
                }
            }
            this.f2622d.o(this.e.f2628b, hashMap);
        }
    }

    public void j(int i) {
        c cVar = this.e;
        if (cVar.f2627a == c.a.PLATFORM_VIEW && cVar.f2628b == i) {
            this.e = new c(c.a.NO_TARGET, 0);
            p(this.f2619a);
            this.f2620b.restartInput(this.f2619a);
            this.i = false;
        }
    }

    void k() {
        if (this.e.f2627a == c.a.PLATFORM_VIEW) {
            return;
        }
        this.h.j(this);
        w();
        G(null);
        this.e = new c(c.a.NO_TARGET, 0);
        F();
        this.l = null;
    }

    public InputConnection l(View view, EditorInfo editorInfo) {
        InputConnection onCreateInputConnection;
        c cVar = this.e;
        c.a aVar = cVar.f2627a;
        if (aVar == c.a.NO_TARGET) {
            onCreateInputConnection = null;
        } else if (aVar != c.a.PLATFORM_VIEW) {
            m.b bVar = this.f;
            int q = q(bVar.e, bVar.f2583a, bVar.f2584b, bVar.f2585c, bVar.f2586d);
            editorInfo.inputType = q;
            editorInfo.imeOptions = 33554432;
            Integer num = this.f.f;
            int intValue = num == null ? (q & 131072) != 0 ? 1 : 6 : num.intValue();
            String str = this.f.g;
            if (str != null) {
                editorInfo.actionLabel = str;
                editorInfo.actionId = intValue;
            }
            editorInfo.imeOptions = intValue | editorInfo.imeOptions;
            io.flutter.plugin.editing.b bVar2 = new io.flutter.plugin.editing.b(view, this.e.f2628b, this.f2622d, this.o, this.h, editorInfo);
            editorInfo.initialSelStart = this.h.g();
            editorInfo.initialSelEnd = this.h.f();
            this.j = bVar2;
            return bVar2;
        } else if (this.q) {
            return this.j;
        } else {
            onCreateInputConnection = this.k.d(Integer.valueOf(cVar.f2628b)).onCreateInputConnection(editorInfo);
        }
        this.j = onCreateInputConnection;
        return onCreateInputConnection;
    }

    public void m() {
        this.k.D();
        this.f2622d.l(null);
        w();
        io.flutter.plugin.editing.c cVar = this.h;
        if (cVar != null) {
            cVar.j(this);
        }
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.n;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    public InputMethodManager n() {
        return this.f2620b;
    }

    public InputConnection o() {
        return this.j;
    }

    public void s() {
        if (this.e.f2627a == c.a.PLATFORM_VIEW) {
            this.q = true;
        }
    }

    public void x(ViewStructure viewStructure, int i) {
        ViewStructure viewStructure2;
        CharSequence charSequence;
        Rect rect;
        if (Build.VERSION.SDK_INT < 26 || !t()) {
            return;
        }
        String str = this.f.h.f2587a;
        AutofillId autofillId = viewStructure.getAutofillId();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            int keyAt = this.g.keyAt(i2);
            m.b.a aVar = this.g.valueAt(i2).h;
            if (aVar != null) {
                viewStructure.addChildCount(1);
                ViewStructure newChild = viewStructure.newChild(i2);
                newChild.setAutofillId(autofillId, keyAt);
                newChild.setAutofillHints(aVar.f2588b);
                newChild.setAutofillType(1);
                newChild.setVisibility(0);
                if (str.hashCode() != keyAt || (rect = this.l) == null) {
                    viewStructure2 = newChild;
                    viewStructure2.setDimens(0, 0, 0, 0, 1, 1);
                    charSequence = aVar.f2589c.f2593a;
                } else {
                    viewStructure2 = newChild;
                    newChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), this.l.height());
                    charSequence = this.h;
                }
                viewStructure2.setAutofillValue(AutofillValue.forText(charSequence));
            }
        }
    }

    public void z(String str, Bundle bundle) {
        this.f2620b.sendAppPrivateCommand(this.f2619a, str, bundle);
    }
}
