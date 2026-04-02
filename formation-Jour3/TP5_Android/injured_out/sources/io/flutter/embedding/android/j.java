package io.flutter.embedding.android;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import c.a.c.c.a;
import io.flutter.embedding.android.g;
import io.flutter.embedding.engine.i.k;
import io.flutter.embedding.engine.renderer.a;
import io.flutter.view.c;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class j extends FrameLayout implements a.c {
    private h f;
    private i g;
    private g h;
    private io.flutter.embedding.engine.renderer.c i;
    private io.flutter.embedding.engine.renderer.c j;
    private final Set<io.flutter.embedding.engine.renderer.b> k;
    private boolean l;
    private io.flutter.embedding.engine.a m;
    private final Set<d> n;
    private c.a.c.c.a o;
    private io.flutter.plugin.editing.d p;
    private c.a.c.b.a q;
    private io.flutter.embedding.android.a r;
    private io.flutter.embedding.android.b s;
    private io.flutter.view.c t;
    private final a.c u;
    private final c.i v;
    private final io.flutter.embedding.engine.renderer.b w;

    /* loaded from: classes.dex */
    class a implements c.i {
        a() {
        }

        @Override // io.flutter.view.c.i
        public void a(boolean z, boolean z2) {
            j.this.u(z, z2);
        }
    }

    /* loaded from: classes.dex */
    class b implements io.flutter.embedding.engine.renderer.b {
        b() {
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void d() {
            j.this.l = false;
            for (io.flutter.embedding.engine.renderer.b bVar : j.this.k) {
                bVar.d();
            }
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void g() {
            j.this.l = true;
            for (io.flutter.embedding.engine.renderer.b bVar : j.this.k) {
                bVar.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements io.flutter.embedding.engine.renderer.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ io.flutter.embedding.engine.renderer.a f2454a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Runnable f2455b;

        c(io.flutter.embedding.engine.renderer.a aVar, Runnable runnable) {
            this.f2454a = aVar;
            this.f2455b = runnable;
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void d() {
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void g() {
            this.f2454a.l(this);
            this.f2455b.run();
            j.this.h.a();
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b(io.flutter.embedding.engine.a aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum e {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    private j(Context context, AttributeSet attributeSet, h hVar) {
        super(context, attributeSet);
        this.k = new HashSet();
        this.n = new HashSet();
        this.u = new a.c();
        this.v = new a();
        this.w = new b();
        this.f = hVar;
        this.i = hVar;
        q();
    }

    private j(Context context, AttributeSet attributeSet, i iVar) {
        super(context, attributeSet);
        this.k = new HashSet();
        this.n = new HashSet();
        this.u = new a.c();
        this.v = new a();
        this.w = new b();
        this.g = iVar;
        this.i = iVar;
        q();
    }

    public j(Context context, h hVar) {
        this(context, (AttributeSet) null, hVar);
    }

    public j(Context context, i iVar) {
        this(context, (AttributeSet) null, iVar);
    }

    private e k() {
        Context context = getContext();
        int i = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (i == 2) {
            if (rotation == 1) {
                return e.RIGHT;
            }
            if (rotation == 3) {
                return Build.VERSION.SDK_INT >= 23 ? e.LEFT : e.RIGHT;
            } else if (rotation == 0 || rotation == 2) {
                return e.BOTH;
            }
        }
        return e.NONE;
    }

    private int o(WindowInsets windowInsets) {
        if (windowInsets.getSystemWindowInsetBottom() < getRootView().getHeight() * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    private void q() {
        View view;
        c.a.b.d("FlutterView", "Initializing FlutterView");
        if (this.f != null) {
            c.a.b.d("FlutterView", "Internally using a FlutterSurfaceView.");
            view = this.f;
        } else if (this.g != null) {
            c.a.b.d("FlutterView", "Internally using a FlutterTextureView.");
            view = this.g;
        } else {
            c.a.b.d("FlutterView", "Internally using a FlutterImageView.");
            view = this.h;
        }
        addView(view);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z, boolean z2) {
        boolean z3 = false;
        if (!this.m.q().i() && !z && !z2) {
            z3 = true;
        }
        setWillNotDraw(z3);
    }

    private void x() {
        if (!r()) {
            c.a.b.e("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.u.f2608a = getResources().getDisplayMetrics().density;
        this.m.q().n(this.u);
    }

    @Override // c.a.c.c.a.c
    public PointerIcon a(int i) {
        return PointerIcon.getSystemIcon(getContext(), i);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.p.i(sparseArray);
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        io.flutter.embedding.engine.a aVar = this.m;
        return aVar != null ? aVar.o().x(view) : super.checkInputConnectionProxy(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        return (r() && this.r.d(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean f() {
        g gVar = this.h;
        if (gVar != null) {
            return gVar.d();
        }
        return false;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT <= 19) {
            a.c cVar = this.u;
            cVar.f2611d = rect.top;
            cVar.e = rect.right;
            cVar.f = 0;
            cVar.g = rect.left;
            cVar.h = 0;
            cVar.i = 0;
            cVar.j = rect.bottom;
            cVar.k = 0;
            c.a.b.d("FlutterView", "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.u.f2611d + ", Left: " + this.u.g + ", Right: " + this.u.e + "\nKeyboard insets: Bottom: " + this.u.j + ", Left: " + this.u.k + ", Right: " + this.u.i);
            x();
            return true;
        }
        return super.fitSystemWindows(rect);
    }

    public void g(d dVar) {
        this.n.add(dVar);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        io.flutter.view.c cVar = this.t;
        if (cVar == null || !cVar.w()) {
            return null;
        }
        return this.t;
    }

    public io.flutter.embedding.engine.a getAttachedFlutterEngine() {
        return this.m;
    }

    public void h(io.flutter.embedding.engine.renderer.b bVar) {
        this.k.add(bVar);
    }

    public void i(g gVar) {
        io.flutter.embedding.engine.a aVar = this.m;
        if (aVar != null) {
            gVar.b(aVar.q());
        }
    }

    public void j(io.flutter.embedding.engine.a aVar) {
        c.a.b.d("FlutterView", "Attaching to a FlutterEngine: " + aVar);
        if (r()) {
            if (aVar == this.m) {
                c.a.b.d("FlutterView", "Already attached to this engine. Doing nothing.");
                return;
            } else {
                c.a.b.d("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
                n();
            }
        }
        this.m = aVar;
        io.flutter.embedding.engine.renderer.a q = aVar.q();
        this.l = q.h();
        this.i.b(q);
        q.f(this.w);
        if (Build.VERSION.SDK_INT >= 24) {
            this.o = new c.a.c.c.a(this, this.m.l());
        }
        this.p = new io.flutter.plugin.editing.d(this, this.m.u(), this.m.o());
        this.q = this.m.k();
        this.r = new io.flutter.embedding.android.a(this, this.m.i(), this.p);
        this.s = new io.flutter.embedding.android.b(this.m.q(), false);
        io.flutter.view.c cVar = new io.flutter.view.c(this, aVar.f(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.m.o());
        this.t = cVar;
        cVar.K(this.v);
        u(this.t.w(), this.t.x());
        this.m.o().a(this.t);
        this.m.o().v(this.m.q());
        this.p.n().restartInput(this);
        w();
        this.q.b(getResources().getConfiguration());
        x();
        aVar.o().w(this);
        for (d dVar : this.n) {
            dVar.b(aVar);
        }
        if (this.l) {
            this.w.g();
        }
    }

    public void l() {
        this.i.c();
        g gVar = this.h;
        if (gVar == null) {
            g m = m();
            this.h = m;
            addView(m);
        } else {
            gVar.g(getWidth(), getHeight());
        }
        this.j = this.i;
        g gVar2 = this.h;
        this.i = gVar2;
        io.flutter.embedding.engine.a aVar = this.m;
        if (aVar != null) {
            gVar2.b(aVar.q());
        }
    }

    public g m() {
        return new g(getContext(), getWidth(), getHeight(), g.b.background);
    }

    public void n() {
        c.a.b.d("FlutterView", "Detaching from a FlutterEngine: " + this.m);
        if (!r()) {
            c.a.b.d("FlutterView", "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        for (d dVar : this.n) {
            dVar.a();
        }
        this.m.o().C();
        this.m.o().b();
        this.t.E();
        this.t = null;
        this.p.n().restartInput(this);
        this.p.m();
        this.r.b();
        c.a.c.c.a aVar = this.o;
        if (aVar != null) {
            aVar.c();
        }
        io.flutter.embedding.engine.renderer.a q = this.m.q();
        this.l = false;
        q.l(this.w);
        q.p();
        q.m(false);
        this.i.a();
        this.h = null;
        this.j = null;
        this.m = null;
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        if (Build.VERSION.SDK_INT == 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            a.c cVar = this.u;
            cVar.l = systemGestureInsets.top;
            cVar.m = systemGestureInsets.right;
            cVar.n = systemGestureInsets.bottom;
            cVar.o = systemGestureInsets.left;
        }
        boolean z = (getWindowSystemUiVisibility() & 4) == 0;
        boolean z2 = (getWindowSystemUiVisibility() & 2) == 0;
        if (Build.VERSION.SDK_INT >= 30) {
            int navigationBars = z2 ? 0 | WindowInsets.Type.navigationBars() : 0;
            if (z) {
                navigationBars |= WindowInsets.Type.statusBars();
            }
            Insets insets = windowInsets.getInsets(navigationBars);
            a.c cVar2 = this.u;
            cVar2.f2611d = insets.top;
            cVar2.e = insets.right;
            cVar2.f = insets.bottom;
            cVar2.g = insets.left;
            Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
            a.c cVar3 = this.u;
            cVar3.h = insets2.top;
            cVar3.i = insets2.right;
            cVar3.j = insets2.bottom;
            cVar3.k = insets2.left;
            Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            a.c cVar4 = this.u;
            cVar4.l = insets3.top;
            cVar4.m = insets3.right;
            cVar4.n = insets3.bottom;
            cVar4.o = insets3.left;
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                a.c cVar5 = this.u;
                cVar5.f2611d = Math.max(Math.max(cVar5.f2611d, waterfallInsets.top), displayCutout.getSafeInsetTop());
                a.c cVar6 = this.u;
                cVar6.e = Math.max(Math.max(cVar6.e, waterfallInsets.right), displayCutout.getSafeInsetRight());
                a.c cVar7 = this.u;
                cVar7.f = Math.max(Math.max(cVar7.f, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                a.c cVar8 = this.u;
                cVar8.g = Math.max(Math.max(cVar8.g, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            e eVar = e.NONE;
            if (!z2) {
                eVar = k();
            }
            this.u.f2611d = z ? windowInsets.getSystemWindowInsetTop() : 0;
            this.u.e = (eVar == e.RIGHT || eVar == e.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.u.f = (z2 && o(windowInsets) == 0) ? windowInsets.getSystemWindowInsetBottom() : 0;
            this.u.g = (eVar == e.LEFT || eVar == e.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            a.c cVar9 = this.u;
            cVar9.h = 0;
            cVar9.i = 0;
            cVar9.j = o(windowInsets);
            this.u.k = 0;
        }
        c.a.b.d("FlutterView", "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.u.f2611d + ", Left: " + this.u.g + ", Right: " + this.u.e + "\nKeyboard insets: Bottom: " + this.u.j + ", Left: " + this.u.k + ", Right: " + this.u.i + "System Gesture Insets - Left: " + this.u.o + ", Top: " + this.u.l + ", Right: " + this.u.m + ", Bottom: " + this.u.j);
        x();
        return onApplyWindowInsets;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.m != null) {
            c.a.b.d("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
            this.q.b(configuration);
            w();
        }
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return !r() ? super.onCreateInputConnection(editorInfo) : this.p.l(this, editorInfo);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (r() && this.s.d(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return !r() ? super.onHoverEvent(motionEvent) : this.t.B(motionEvent);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        super.onProvideAutofillVirtualStructure(viewStructure, i);
        this.p.x(viewStructure, i);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        c.a.b.d("FlutterView", "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i3 + " x " + i4 + ", it is now " + i + " x " + i2);
        a.c cVar = this.u;
        cVar.f2609b = i;
        cVar.f2610c = i2;
        x();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (r()) {
            if (Build.VERSION.SDK_INT >= 21) {
                requestUnbufferedDispatch(motionEvent);
            }
            return this.s.e(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean p() {
        return this.l;
    }

    public boolean r() {
        io.flutter.embedding.engine.a aVar = this.m;
        return aVar != null && aVar.q() == this.i.getAttachedRenderer();
    }

    public void s(d dVar) {
        this.n.remove(dVar);
    }

    public void t(io.flutter.embedding.engine.renderer.b bVar) {
        this.k.remove(bVar);
    }

    public void v(Runnable runnable) {
        g gVar = this.h;
        if (gVar == null) {
            c.a.b.d("FlutterView", "Tried to revert the image view, but no image view is used.");
            return;
        }
        io.flutter.embedding.engine.renderer.c cVar = this.j;
        if (cVar == null) {
            c.a.b.d("FlutterView", "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.i = cVar;
        this.j = null;
        io.flutter.embedding.engine.a aVar = this.m;
        if (aVar == null) {
            gVar.a();
            runnable.run();
            return;
        }
        io.flutter.embedding.engine.renderer.a q = aVar.q();
        if (q == null) {
            this.h.a();
            runnable.run();
            return;
        }
        this.i.b(q);
        q.f(new c(q, runnable));
    }

    void w() {
        k.b bVar = (getResources().getConfiguration().uiMode & 48) == 32 ? k.b.dark : k.b.light;
        k.a a2 = this.m.s().a();
        a2.c(getResources().getConfiguration().fontScale);
        a2.d(DateFormat.is24HourFormat(getContext()));
        a2.b(bVar);
        a2.a();
    }
}
