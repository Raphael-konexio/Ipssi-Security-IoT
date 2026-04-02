package androidx.appcompat.app;

import a.a.n.b;
import a.a.n.f;
import a.g.k.a0;
import a.g.k.e;
import a.g.k.s;
import a.g.k.w;
import a.g.k.y;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.b1;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.c1;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.w0;
import androidx.lifecycle.e;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends androidx.appcompat.app.e implements g.a, LayoutInflater.Factory2 {
    private static final Map<Class<?>, Integer> f0 = new a.d.a();
    private static final boolean g0;
    private static final int[] h0;
    private static boolean i0;
    private static final boolean j0;
    private ViewGroup A;
    private TextView B;
    private View C;
    private boolean D;
    private boolean E;
    boolean F;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    private boolean K;
    private o[] L;
    private o M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    boolean R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private l W;
    private l X;
    boolean Y;
    int Z;
    private final Runnable a0;
    private boolean b0;
    private Rect c0;
    private Rect d0;
    private AppCompatViewInflater e0;
    final Object i;
    final Context j;
    Window k;
    private j l;
    final androidx.appcompat.app.d m;
    androidx.appcompat.app.a n;
    MenuInflater o;
    private CharSequence p;
    private c0 q;
    private h r;
    private p s;
    a.a.n.b t;
    ActionBarContextView u;
    PopupWindow v;
    Runnable w;
    w x;
    private boolean y;
    private boolean z;

    /* loaded from: classes.dex */
    static class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f489a;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f489a = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (!a(th)) {
                this.f489a.uncaughtException(thread, th);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            this.f489a.uncaughtException(thread, notFoundException);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            if ((fVar.Z & 1) != 0) {
                fVar.V(0);
            }
            f fVar2 = f.this;
            if ((fVar2.Z & 4096) != 0) {
                fVar2.V(108);
            }
            f fVar3 = f.this;
            fVar3.Y = false;
            fVar3.Z = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements a.g.k.p {
        c() {
        }

        @Override // a.g.k.p
        public a0 a(View view, a0 a0Var) {
            int k = a0Var.k();
            int L0 = f.this.L0(k);
            if (k != L0) {
                a0Var = a0Var.m(a0Var.i(), L0, a0Var.j(), a0Var.h());
            }
            return s.T(view, a0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements g0.a {
        d() {
        }

        @Override // androidx.appcompat.widget.g0.a
        public void a(Rect rect) {
            rect.top = f.this.L0(rect.top);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements ContentFrameLayout.a {
        e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            f.this.T();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.appcompat.app.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0032f implements Runnable {

        /* renamed from: androidx.appcompat.app.f$f$a */
        /* loaded from: classes.dex */
        class a extends y {
            a() {
            }

            @Override // a.g.k.x
            public void b(View view) {
                f.this.u.setAlpha(1.0f);
                f.this.x.f(null);
                f.this.x = null;
            }

            @Override // a.g.k.y, a.g.k.x
            public void c(View view) {
                f.this.u.setVisibility(0);
            }
        }

        RunnableC0032f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.v.showAtLocation(fVar.u, 55, 0, 0);
            f.this.W();
            if (!f.this.D0()) {
                f.this.u.setAlpha(1.0f);
                f.this.u.setVisibility(0);
                return;
            }
            f.this.u.setAlpha(0.0f);
            f fVar2 = f.this;
            w c2 = s.c(fVar2.u);
            c2.a(1.0f);
            fVar2.x = c2;
            f.this.x.f(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends y {
        g() {
        }

        @Override // a.g.k.x
        public void b(View view) {
            f.this.u.setAlpha(1.0f);
            f.this.x.f(null);
            f.this.x = null;
        }

        @Override // a.g.k.y, a.g.k.x
        public void c(View view) {
            f.this.u.setVisibility(0);
            f.this.u.sendAccessibilityEvent(32);
            if (f.this.u.getParent() instanceof View) {
                s.d0((View) f.this.u.getParent());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class h implements m.a {
        h() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            f.this.N(gVar);
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback f0 = f.this.f0();
            if (f0 != null) {
                f0.onMenuOpened(108, gVar);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private b.a f495a;

        /* loaded from: classes.dex */
        class a extends y {
            a() {
            }

            @Override // a.g.k.x
            public void b(View view) {
                f.this.u.setVisibility(8);
                f fVar = f.this;
                PopupWindow popupWindow = fVar.v;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (fVar.u.getParent() instanceof View) {
                    s.d0((View) f.this.u.getParent());
                }
                f.this.u.removeAllViews();
                f.this.x.f(null);
                f.this.x = null;
            }
        }

        public i(b.a aVar) {
            this.f495a = aVar;
        }

        @Override // a.a.n.b.a
        public boolean a(a.a.n.b bVar, Menu menu) {
            return this.f495a.a(bVar, menu);
        }

        @Override // a.a.n.b.a
        public void b(a.a.n.b bVar) {
            this.f495a.b(bVar);
            f fVar = f.this;
            if (fVar.v != null) {
                fVar.k.getDecorView().removeCallbacks(f.this.w);
            }
            f fVar2 = f.this;
            if (fVar2.u != null) {
                fVar2.W();
                f fVar3 = f.this;
                w c2 = s.c(fVar3.u);
                c2.a(0.0f);
                fVar3.x = c2;
                f.this.x.f(new a());
            }
            f fVar4 = f.this;
            androidx.appcompat.app.d dVar = fVar4.m;
            if (dVar != null) {
                dVar.d(fVar4.t);
            }
            f.this.t = null;
        }

        @Override // a.a.n.b.a
        public boolean c(a.a.n.b bVar, MenuItem menuItem) {
            return this.f495a.c(bVar, menuItem);
        }

        @Override // a.a.n.b.a
        public boolean d(a.a.n.b bVar, Menu menu) {
            return this.f495a.d(bVar, menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends a.a.n.i {
        j(Window.Callback callback) {
            super(callback);
        }

        final ActionMode b(ActionMode.Callback callback) {
            f.a aVar = new f.a(f.this.j, callback);
            a.a.n.b F0 = f.this.F0(aVar);
            if (F0 != null) {
                return aVar.e(F0);
            }
            return null;
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.U(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || f.this.r0(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            f.this.u0(i);
            return true;
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            f.this.v0(i);
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.a0(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (gVar != null) {
                gVar.a0(false);
            }
            return onPreparePanel;
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            androidx.appcompat.view.menu.g gVar;
            o d0 = f.this.d0(0, true);
            if (d0 == null || (gVar = d0.j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, gVar, i);
            }
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return f.this.m0() ? b(callback) : super.onWindowStartingActionMode(callback);
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return (f.this.m0() && i == 0) ? b(callback) : super.onWindowStartingActionMode(callback, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class k extends l {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f498c;

        k(Context context) {
            super();
            this.f498c = (PowerManager) context.getSystemService("power");
        }

        @Override // androidx.appcompat.app.f.l
        IntentFilter b() {
            if (Build.VERSION.SDK_INT >= 21) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            }
            return null;
        }

        @Override // androidx.appcompat.app.f.l
        public int c() {
            return (Build.VERSION.SDK_INT < 21 || !this.f498c.isPowerSaveMode()) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.f.l
        public void d() {
            f.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class l {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f500a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                l.this.d();
            }
        }

        l() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f500a;
            if (broadcastReceiver != null) {
                try {
                    f.this.j.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f500a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter b2 = b();
            if (b2 == null || b2.countActions() == 0) {
                return;
            }
            if (this.f500a == null) {
                this.f500a = new a();
            }
            f.this.j.registerReceiver(this.f500a, b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class m extends l {

        /* renamed from: c  reason: collision with root package name */
        private final androidx.appcompat.app.k f503c;

        m(androidx.appcompat.app.k kVar) {
            super();
            this.f503c = kVar;
        }

        @Override // androidx.appcompat.app.f.l
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.f.l
        public int c() {
            return this.f503c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.f.l
        public void d() {
            f.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class n extends ContentFrameLayout {
        public n(Context context) {
            super(context);
        }

        private boolean c(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.U(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                f.this.P(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(a.a.k.a.a.d(getContext(), i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class o {

        /* renamed from: a  reason: collision with root package name */
        int f505a;

        /* renamed from: b  reason: collision with root package name */
        int f506b;

        /* renamed from: c  reason: collision with root package name */
        int f507c;

        /* renamed from: d  reason: collision with root package name */
        int f508d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        androidx.appcompat.view.menu.g j;
        androidx.appcompat.view.menu.e k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        o(int i) {
            this.f505a = i;
        }

        androidx.appcompat.view.menu.n a(m.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(this.l, a.a.g.abc_list_menu_item_layout);
                this.k = eVar;
                eVar.k(aVar);
                this.j.b(this.k);
            }
            return this.k.c(this.g);
        }

        public boolean b() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.j;
            if (gVar == gVar2) {
                return;
            }
            if (gVar2 != null) {
                gVar2.O(this.k);
            }
            this.j = gVar;
            if (gVar == null || (eVar = this.k) == null) {
                return;
            }
            gVar.b(eVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(a.a.a.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                newTheme.applyStyle(i, true);
            }
            newTheme.resolveAttribute(a.a.a.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 == 0) {
                i2 = a.a.i.Theme_AppCompat_CompactMenu;
            }
            newTheme.applyStyle(i2, true);
            a.a.n.d dVar = new a.a.n.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(a.a.j.AppCompatTheme);
            this.f506b = obtainStyledAttributes.getResourceId(a.a.j.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(a.a.j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class p implements m.a {
        p() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            androidx.appcompat.view.menu.g D = gVar.D();
            boolean z2 = D != gVar;
            f fVar = f.this;
            if (z2) {
                gVar = D;
            }
            o Z = fVar.Z(gVar);
            if (Z != null) {
                if (!z2) {
                    f.this.Q(Z, z);
                    return;
                }
                f.this.M(Z.f505a, Z, D);
                f.this.Q(Z, true);
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback f0;
            if (gVar == null) {
                f fVar = f.this;
                if (!fVar.F || (f0 = fVar.f0()) == null || f.this.R) {
                    return true;
                }
                f0.onMenuOpened(108, gVar);
                return true;
            }
            return true;
        }
    }

    static {
        boolean z = false;
        g0 = Build.VERSION.SDK_INT < 21;
        h0 = new int[]{16842836};
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21 && i2 <= 25) {
            z = true;
        }
        j0 = z;
        if (!g0 || i0) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        i0 = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Activity activity, androidx.appcompat.app.d dVar) {
        this(activity, null, dVar, activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Dialog dialog, androidx.appcompat.app.d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    private f(Context context, Window window, androidx.appcompat.app.d dVar, Object obj) {
        Integer num;
        androidx.appcompat.app.c I0;
        this.x = null;
        this.y = true;
        this.S = -100;
        this.a0 = new b();
        this.j = context;
        this.m = dVar;
        this.i = obj;
        if (this.S == -100 && (obj instanceof Dialog) && (I0 = I0()) != null) {
            this.S = I0.u().k();
        }
        if (this.S == -100 && (num = f0.get(this.i.getClass())) != null) {
            this.S = num.intValue();
            f0.remove(this.i.getClass());
        }
        if (window != null) {
            K(window);
        }
        androidx.appcompat.widget.j.h();
    }

    private boolean A0(o oVar, KeyEvent keyEvent) {
        c0 c0Var;
        c0 c0Var2;
        c0 c0Var3;
        if (this.R) {
            return false;
        }
        if (oVar.m) {
            return true;
        }
        o oVar2 = this.M;
        if (oVar2 != null && oVar2 != oVar) {
            Q(oVar2, false);
        }
        Window.Callback f02 = f0();
        if (f02 != null) {
            oVar.i = f02.onCreatePanelView(oVar.f505a);
        }
        int i2 = oVar.f505a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (c0Var3 = this.q) != null) {
            c0Var3.d();
        }
        if (oVar.i == null && (!z || !(y0() instanceof androidx.appcompat.app.i))) {
            if (oVar.j == null || oVar.r) {
                if (oVar.j == null && (!j0(oVar) || oVar.j == null)) {
                    return false;
                }
                if (z && this.q != null) {
                    if (this.r == null) {
                        this.r = new h();
                    }
                    this.q.a(oVar.j, this.r);
                }
                oVar.j.d0();
                if (!f02.onCreatePanelMenu(oVar.f505a, oVar.j)) {
                    oVar.c(null);
                    if (z && (c0Var = this.q) != null) {
                        c0Var.a(null, this.r);
                    }
                    return false;
                }
                oVar.r = false;
            }
            oVar.j.d0();
            Bundle bundle = oVar.s;
            if (bundle != null) {
                oVar.j.P(bundle);
                oVar.s = null;
            }
            if (!f02.onPreparePanel(0, oVar.i, oVar.j)) {
                if (z && (c0Var2 = this.q) != null) {
                    c0Var2.a(null, this.r);
                }
                oVar.j.c0();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            oVar.p = z2;
            oVar.j.setQwertyMode(z2);
            oVar.j.c0();
        }
        oVar.m = true;
        oVar.n = false;
        this.M = oVar;
        return true;
    }

    private void B0(androidx.appcompat.view.menu.g gVar, boolean z) {
        c0 c0Var = this.q;
        if (c0Var == null || !c0Var.h() || (ViewConfiguration.get(this.j).hasPermanentMenuKey() && !this.q.e())) {
            o d0 = d0(0, true);
            d0.q = true;
            Q(d0, false);
            x0(d0, null);
            return;
        }
        Window.Callback f02 = f0();
        if (this.q.b() && z) {
            this.q.f();
            if (this.R) {
                return;
            }
            f02.onPanelClosed(108, d0(0, true).j);
        } else if (f02 == null || this.R) {
        } else {
            if (this.Y && (this.Z & 1) != 0) {
                this.k.getDecorView().removeCallbacks(this.a0);
                this.a0.run();
            }
            o d02 = d0(0, true);
            androidx.appcompat.view.menu.g gVar2 = d02.j;
            if (gVar2 == null || d02.r || !f02.onPreparePanel(0, d02.i, gVar2)) {
                return;
            }
            f02.onMenuOpened(108, d02.j);
            this.q.g();
        }
    }

    private int C0(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i2 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        } else {
            return i2;
        }
    }

    private boolean E0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.k.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || s.L((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void H0() {
        if (this.z) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private boolean I(boolean z) {
        if (this.R) {
            return false;
        }
        int L = L();
        boolean J0 = J0(n0(L), z);
        if (L == 0) {
            c0().e();
        } else {
            l lVar = this.W;
            if (lVar != null) {
                lVar.a();
            }
        }
        if (L == 3) {
            b0().e();
        } else {
            l lVar2 = this.X;
            if (lVar2 != null) {
                lVar2.a();
            }
        }
        return J0;
    }

    private androidx.appcompat.app.c I0() {
        for (Context context = this.j; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof androidx.appcompat.app.c) {
                return (androidx.appcompat.app.c) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private void J() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.A.findViewById(16908290);
        View decorView = this.k.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.j.obtainStyledAttributes(a.a.j.AppCompatTheme);
        obtainStyledAttributes.getValue(a.a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(a.a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(a.a.j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(a.a.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(a.a.j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(a.a.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(a.a.j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(a.a.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(a.a.j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(a.a.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private boolean J0(int i2, boolean z) {
        int i3 = this.j.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        boolean z2 = true;
        int i4 = i2 != 1 ? i2 != 2 ? i3 : 32 : 16;
        boolean l0 = l0();
        boolean z3 = false;
        if ((j0 || i4 != i3) && !l0 && Build.VERSION.SDK_INT >= 17 && !this.O && (this.i instanceof ContextThemeWrapper)) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & (-49)) | i4;
            try {
                ((ContextThemeWrapper) this.i).applyOverrideConfiguration(configuration);
                z3 = true;
            } catch (IllegalStateException e2) {
                Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", e2);
            }
        }
        int i5 = this.j.getResources().getConfiguration().uiMode & 48;
        if (!z3 && i5 != i4 && z && !l0 && this.O && (Build.VERSION.SDK_INT >= 17 || this.P)) {
            Object obj = this.i;
            if (obj instanceof Activity) {
                androidx.core.app.a.l((Activity) obj);
                z3 = true;
            }
        }
        if (z3 || i5 == i4) {
            z2 = z3;
        } else {
            K0(i4, l0);
        }
        if (z2) {
            Object obj2 = this.i;
            if (obj2 instanceof androidx.appcompat.app.c) {
                ((androidx.appcompat.app.c) obj2).x(i2);
            }
        }
        return z2;
    }

    private void K(Window window) {
        if (this.k != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof j) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        j jVar = new j(callback);
        this.l = jVar;
        window.setCallback(jVar);
        w0 t = w0.t(this.j, null, h0);
        Drawable h2 = t.h(0);
        if (h2 != null) {
            window.setBackgroundDrawable(h2);
        }
        t.v();
        this.k = window;
    }

    private void K0(int i2, boolean z) {
        Resources resources = this.j.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration, null);
        if (Build.VERSION.SDK_INT < 26) {
            androidx.appcompat.app.h.a(resources);
        }
        int i3 = this.T;
        if (i3 != 0) {
            this.j.setTheme(i3);
            if (Build.VERSION.SDK_INT >= 23) {
                this.j.getTheme().applyStyle(this.T, true);
            }
        }
        if (z) {
            Object obj = this.i;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.j) {
                    if (!((androidx.lifecycle.j) activity).a().b().d(e.b.STARTED)) {
                        return;
                    }
                } else if (!this.Q) {
                    return;
                }
                activity.onConfigurationChanged(configuration);
            }
        }
    }

    private int L() {
        int i2 = this.S;
        return i2 != -100 ? i2 : androidx.appcompat.app.e.j();
    }

    private void O() {
        l lVar = this.W;
        if (lVar != null) {
            lVar.a();
        }
        l lVar2 = this.X;
        if (lVar2 != null) {
            lVar2.a();
        }
    }

    private ViewGroup R() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.j.obtainStyledAttributes(a.a.j.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(a.a.j.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(a.a.j.AppCompatTheme_windowNoTitle, false)) {
            A(1);
        } else if (obtainStyledAttributes.getBoolean(a.a.j.AppCompatTheme_windowActionBar, false)) {
            A(108);
        }
        if (obtainStyledAttributes.getBoolean(a.a.j.AppCompatTheme_windowActionBarOverlay, false)) {
            A(109);
        }
        if (obtainStyledAttributes.getBoolean(a.a.j.AppCompatTheme_windowActionModeOverlay, false)) {
            A(10);
        }
        this.I = obtainStyledAttributes.getBoolean(a.a.j.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        Y();
        this.k.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.j);
        if (this.J) {
            viewGroup = (ViewGroup) from.inflate(this.H ? a.a.g.abc_screen_simple_overlay_action_mode : a.a.g.abc_screen_simple, (ViewGroup) null);
            if (Build.VERSION.SDK_INT >= 21) {
                s.r0(viewGroup, new c());
            } else {
                ((g0) viewGroup).setOnFitSystemWindowsListener(new d());
            }
        } else if (this.I) {
            viewGroup = (ViewGroup) from.inflate(a.a.g.abc_dialog_title_material, (ViewGroup) null);
            this.G = false;
            this.F = false;
        } else if (this.F) {
            TypedValue typedValue = new TypedValue();
            this.j.getTheme().resolveAttribute(a.a.a.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new a.a.n.d(this.j, typedValue.resourceId) : this.j).inflate(a.a.g.abc_screen_toolbar, (ViewGroup) null);
            c0 c0Var = (c0) viewGroup.findViewById(a.a.f.decor_content_parent);
            this.q = c0Var;
            c0Var.setWindowCallback(f0());
            if (this.G) {
                this.q.k(109);
            }
            if (this.D) {
                this.q.k(2);
            }
            if (this.E) {
                this.q.k(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.F + ", windowActionBarOverlay: " + this.G + ", android:windowIsFloating: " + this.I + ", windowActionModeOverlay: " + this.H + ", windowNoTitle: " + this.J + " }");
        }
        if (this.q == null) {
            this.B = (TextView) viewGroup.findViewById(a.a.f.title);
        }
        c1.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(a.a.f.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.k.findViewById(16908290);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.k.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new e());
        return viewGroup;
    }

    private void X() {
        if (this.z) {
            return;
        }
        this.A = R();
        CharSequence e0 = e0();
        if (!TextUtils.isEmpty(e0)) {
            c0 c0Var = this.q;
            if (c0Var != null) {
                c0Var.setWindowTitle(e0);
            } else if (y0() != null) {
                y0().t(e0);
            } else {
                TextView textView = this.B;
                if (textView != null) {
                    textView.setText(e0);
                }
            }
        }
        J();
        w0(this.A);
        this.z = true;
        o d0 = d0(0, false);
        if (this.R) {
            return;
        }
        if (d0 == null || d0.j == null) {
            k0(108);
        }
    }

    private void Y() {
        if (this.k == null) {
            Object obj = this.i;
            if (obj instanceof Activity) {
                K(((Activity) obj).getWindow());
            }
        }
        if (this.k == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private l b0() {
        if (this.X == null) {
            this.X = new k(this.j);
        }
        return this.X;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g0() {
        /*
            r3 = this;
            r3.X()
            boolean r0 = r3.F
            if (r0 == 0) goto L37
            androidx.appcompat.app.a r0 = r3.n
            if (r0 == 0) goto Lc
            goto L37
        Lc:
            java.lang.Object r0 = r3.i
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L20
            androidx.appcompat.app.l r0 = new androidx.appcompat.app.l
            java.lang.Object r1 = r3.i
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r2 = r3.G
            r0.<init>(r1, r2)
        L1d:
            r3.n = r0
            goto L2e
        L20:
            boolean r0 = r0 instanceof android.app.Dialog
            if (r0 == 0) goto L2e
            androidx.appcompat.app.l r0 = new androidx.appcompat.app.l
            java.lang.Object r1 = r3.i
            android.app.Dialog r1 = (android.app.Dialog) r1
            r0.<init>(r1)
            goto L1d
        L2e:
            androidx.appcompat.app.a r0 = r3.n
            if (r0 == 0) goto L37
            boolean r1 = r3.b0
            r0.r(r1)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.g0():void");
    }

    private boolean h0(o oVar) {
        View view = oVar.i;
        if (view != null) {
            oVar.h = view;
            return true;
        } else if (oVar.j == null) {
            return false;
        } else {
            if (this.s == null) {
                this.s = new p();
            }
            View view2 = (View) oVar.a(this.s);
            oVar.h = view2;
            return view2 != null;
        }
    }

    private boolean i0(o oVar) {
        oVar.d(a0());
        oVar.g = new n(oVar.l);
        oVar.f507c = 81;
        return true;
    }

    private boolean j0(o oVar) {
        Context context = this.j;
        int i2 = oVar.f505a;
        if ((i2 == 0 || i2 == 108) && this.q != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(a.a.a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(a.a.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(a.a.a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                a.a.n.d dVar = new a.a.n.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.R(this);
        oVar.c(gVar);
        return true;
    }

    private void k0(int i2) {
        this.Z = (1 << i2) | this.Z;
        if (this.Y) {
            return;
        }
        s.Y(this.k.getDecorView(), this.a0);
        this.Y = true;
    }

    private boolean l0() {
        if (!this.V && (this.i instanceof Activity)) {
            PackageManager packageManager = this.j.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.j, this.i.getClass()), 0);
                this.U = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.U = false;
            }
        }
        this.V = true;
        return this.U;
    }

    private boolean q0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            o d0 = d0(i2, true);
            if (d0.o) {
                return false;
            }
            return A0(d0, keyEvent);
        }
        return false;
    }

    private boolean t0(int i2, KeyEvent keyEvent) {
        boolean z;
        c0 c0Var;
        if (this.t != null) {
            return false;
        }
        boolean z2 = true;
        o d0 = d0(i2, true);
        if (i2 != 0 || (c0Var = this.q) == null || !c0Var.h() || ViewConfiguration.get(this.j).hasPermanentMenuKey()) {
            if (d0.o || d0.n) {
                boolean z3 = d0.o;
                Q(d0, true);
                z2 = z3;
            } else {
                if (d0.m) {
                    if (d0.r) {
                        d0.m = false;
                        z = A0(d0, keyEvent);
                    } else {
                        z = true;
                    }
                    if (z) {
                        x0(d0, keyEvent);
                    }
                }
                z2 = false;
            }
        } else if (this.q.b()) {
            z2 = this.q.f();
        } else {
            if (!this.R && A0(d0, keyEvent)) {
                z2 = this.q.g();
            }
            z2 = false;
        }
        if (z2) {
            AudioManager audioManager = (AudioManager) this.j.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z2;
    }

    private void x0(o oVar, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (oVar.o || this.R) {
            return;
        }
        if (oVar.f505a == 0) {
            if ((this.j.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback f02 = f0();
        if (f02 != null && !f02.onMenuOpened(oVar.f505a, oVar.j)) {
            Q(oVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.j.getSystemService("window");
        if (windowManager != null && A0(oVar, keyEvent)) {
            if (oVar.g == null || oVar.q) {
                ViewGroup viewGroup = oVar.g;
                if (viewGroup == null) {
                    if (!i0(oVar) || oVar.g == null) {
                        return;
                    }
                } else if (oVar.q && viewGroup.getChildCount() > 0) {
                    oVar.g.removeAllViews();
                }
                if (!h0(oVar) || !oVar.b()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = oVar.h.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                oVar.g.setBackgroundResource(oVar.f506b);
                ViewParent parent = oVar.h.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(oVar.h);
                }
                oVar.g.addView(oVar.h, layoutParams2);
                if (!oVar.h.hasFocus()) {
                    oVar.h.requestFocus();
                }
            } else {
                View view = oVar.i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i2 = -1;
                    oVar.n = false;
                    WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, oVar.f508d, oVar.e, 1002, 8519680, -3);
                    layoutParams3.gravity = oVar.f507c;
                    layoutParams3.windowAnimations = oVar.f;
                    windowManager.addView(oVar.g, layoutParams3);
                    oVar.o = true;
                }
            }
            i2 = -2;
            oVar.n = false;
            WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, oVar.f508d, oVar.e, 1002, 8519680, -3);
            layoutParams32.gravity = oVar.f507c;
            layoutParams32.windowAnimations = oVar.f;
            windowManager.addView(oVar.g, layoutParams32);
            oVar.o = true;
        }
    }

    private boolean z0(o oVar, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.g gVar;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((oVar.m || A0(oVar, keyEvent)) && (gVar = oVar.j) != null) {
            z = gVar.performShortcut(i2, keyEvent, i3);
        }
        if (z && (i3 & 1) == 0 && this.q == null) {
            Q(oVar, true);
        }
        return z;
    }

    @Override // androidx.appcompat.app.e
    public boolean A(int i2) {
        int C0 = C0(i2);
        if (this.J && C0 == 108) {
            return false;
        }
        if (this.F && C0 == 1) {
            this.F = false;
        }
        if (C0 == 1) {
            H0();
            this.J = true;
            return true;
        } else if (C0 == 2) {
            H0();
            this.D = true;
            return true;
        } else if (C0 == 5) {
            H0();
            this.E = true;
            return true;
        } else if (C0 == 10) {
            H0();
            this.H = true;
            return true;
        } else if (C0 == 108) {
            H0();
            this.F = true;
            return true;
        } else if (C0 != 109) {
            return this.k.requestFeature(C0);
        } else {
            H0();
            this.G = true;
            return true;
        }
    }

    @Override // androidx.appcompat.app.e
    public void B(int i2) {
        X();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.j).inflate(i2, viewGroup);
        this.l.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void C(View view) {
        X();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.l.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void D(View view, ViewGroup.LayoutParams layoutParams) {
        X();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.l.a().onContentChanged();
    }

    final boolean D0() {
        ViewGroup viewGroup;
        return this.z && (viewGroup = this.A) != null && s.M(viewGroup);
    }

    @Override // androidx.appcompat.app.e
    public void F(Toolbar toolbar) {
        Window window;
        Window.Callback callback;
        if (this.i instanceof Activity) {
            androidx.appcompat.app.a m2 = m();
            if (m2 instanceof androidx.appcompat.app.l) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.o = null;
            if (m2 != null) {
                m2.n();
            }
            if (toolbar != null) {
                androidx.appcompat.app.i iVar = new androidx.appcompat.app.i(toolbar, e0(), this.l);
                this.n = iVar;
                window = this.k;
                callback = iVar.w();
            } else {
                this.n = null;
                window = this.k;
                callback = this.l;
            }
            window.setCallback(callback);
            o();
        }
    }

    public a.a.n.b F0(b.a aVar) {
        androidx.appcompat.app.d dVar;
        if (aVar != null) {
            a.a.n.b bVar = this.t;
            if (bVar != null) {
                bVar.c();
            }
            i iVar = new i(aVar);
            androidx.appcompat.app.a m2 = m();
            if (m2 != null) {
                a.a.n.b u = m2.u(iVar);
                this.t = u;
                if (u != null && (dVar = this.m) != null) {
                    dVar.c(u);
                }
            }
            if (this.t == null) {
                this.t = G0(iVar);
            }
            return this.t;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    @Override // androidx.appcompat.app.e
    public void G(int i2) {
        this.T = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    a.a.n.b G0(a.a.n.b.a r8) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.G0(a.a.n.b$a):a.a.n.b");
    }

    @Override // androidx.appcompat.app.e
    public final void H(CharSequence charSequence) {
        this.p = charSequence;
        c0 c0Var = this.q;
        if (c0Var != null) {
            c0Var.setWindowTitle(charSequence);
        } else if (y0() != null) {
            y0().t(charSequence);
        } else {
            TextView textView = this.B;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    int L0(int i2) {
        boolean z;
        boolean z2;
        ActionBarContextView actionBarContextView = this.u;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.u.getLayoutParams();
            if (this.u.isShown()) {
                if (this.c0 == null) {
                    this.c0 = new Rect();
                    this.d0 = new Rect();
                }
                Rect rect = this.c0;
                Rect rect2 = this.d0;
                rect.set(0, i2, 0, 0);
                c1.a(this.A, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i2 : 0)) {
                    marginLayoutParams.topMargin = i2;
                    View view = this.C;
                    if (view == null) {
                        View view2 = new View(this.j);
                        this.C = view2;
                        view2.setBackgroundColor(this.j.getResources().getColor(a.a.c.abc_input_method_navigation_guard));
                        this.A.addView(this.C, -1, new ViewGroup.LayoutParams(-1, i2));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i2) {
                            layoutParams.height = i2;
                            this.C.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                r3 = this.C != null;
                if (!this.H && r3) {
                    i2 = 0;
                }
                boolean z3 = r3;
                r3 = z2;
                z = z3;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                r3 = false;
            }
            if (r3) {
                this.u.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.C;
        if (view3 != null) {
            view3.setVisibility(z ? 0 : 8);
        }
        return i2;
    }

    void M(int i2, o oVar, Menu menu) {
        if (menu == null) {
            if (oVar == null && i2 >= 0) {
                o[] oVarArr = this.L;
                if (i2 < oVarArr.length) {
                    oVar = oVarArr[i2];
                }
            }
            if (oVar != null) {
                menu = oVar.j;
            }
        }
        if ((oVar == null || oVar.o) && !this.R) {
            this.l.a().onPanelClosed(i2, menu);
        }
    }

    void N(androidx.appcompat.view.menu.g gVar) {
        if (this.K) {
            return;
        }
        this.K = true;
        this.q.l();
        Window.Callback f02 = f0();
        if (f02 != null && !this.R) {
            f02.onPanelClosed(108, gVar);
        }
        this.K = false;
    }

    void P(int i2) {
        Q(d0(i2, true), true);
    }

    void Q(o oVar, boolean z) {
        ViewGroup viewGroup;
        c0 c0Var;
        if (z && oVar.f505a == 0 && (c0Var = this.q) != null && c0Var.b()) {
            N(oVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.j.getSystemService("window");
        if (windowManager != null && oVar.o && (viewGroup = oVar.g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                M(oVar.f505a, oVar, null);
            }
        }
        oVar.m = false;
        oVar.n = false;
        oVar.o = false;
        oVar.h = null;
        oVar.q = true;
        if (this.M == oVar) {
            this.M = null;
        }
    }

    public View S(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        AppCompatViewInflater appCompatViewInflater;
        boolean z2 = false;
        if (this.e0 == null) {
            String string = this.j.obtainStyledAttributes(a.a.j.AppCompatTheme).getString(a.a.j.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                appCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.e0 = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    appCompatViewInflater = new AppCompatViewInflater();
                }
            }
            this.e0 = appCompatViewInflater;
        }
        if (g0) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z2 = E0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z2 = true;
            }
            z = z2;
        } else {
            z = false;
        }
        return this.e0.createView(view, str, context, attributeSet, z, g0, true, b1.b());
    }

    void T() {
        androidx.appcompat.view.menu.g gVar;
        c0 c0Var = this.q;
        if (c0Var != null) {
            c0Var.l();
        }
        if (this.v != null) {
            this.k.getDecorView().removeCallbacks(this.w);
            if (this.v.isShowing()) {
                try {
                    this.v.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.v = null;
        }
        W();
        o d0 = d0(0, false);
        if (d0 == null || (gVar = d0.j) == null) {
            return;
        }
        gVar.close();
    }

    boolean U(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.i;
        if (((obj instanceof e.a) || (obj instanceof androidx.appcompat.app.g)) && (decorView = this.k.getDecorView()) != null && a.g.k.e.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.l.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? p0(keyCode, keyEvent) : s0(keyCode, keyEvent);
    }

    void V(int i2) {
        o d0;
        o d02 = d0(i2, true);
        if (d02.j != null) {
            Bundle bundle = new Bundle();
            d02.j.Q(bundle);
            if (bundle.size() > 0) {
                d02.s = bundle;
            }
            d02.j.d0();
            d02.j.clear();
        }
        d02.r = true;
        d02.q = true;
        if ((i2 != 108 && i2 != 0) || this.q == null || (d0 = d0(0, false)) == null) {
            return;
        }
        d0.m = false;
        A0(d0, null);
    }

    void W() {
        w wVar = this.x;
        if (wVar != null) {
            wVar.b();
        }
    }

    o Z(Menu menu) {
        o[] oVarArr = this.L;
        int length = oVarArr != null ? oVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            o oVar = oVarArr[i2];
            if (oVar != null && oVar.j == menu) {
                return oVar;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        o Z;
        Window.Callback f02 = f0();
        if (f02 == null || this.R || (Z = Z(gVar.D())) == null) {
            return false;
        }
        return f02.onMenuItemSelected(Z.f505a, menuItem);
    }

    final Context a0() {
        androidx.appcompat.app.a m2 = m();
        Context k2 = m2 != null ? m2.k() : null;
        return k2 == null ? this.j : k2;
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(androidx.appcompat.view.menu.g gVar) {
        B0(gVar, true);
    }

    @Override // androidx.appcompat.app.e
    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        X();
        ((ViewGroup) this.A.findViewById(16908290)).addView(view, layoutParams);
        this.l.a().onContentChanged();
    }

    final l c0() {
        if (this.W == null) {
            this.W = new m(androidx.appcompat.app.k.a(this.j));
        }
        return this.W;
    }

    @Override // androidx.appcompat.app.e
    public boolean d() {
        return I(true);
    }

    protected o d0(int i2, boolean z) {
        o[] oVarArr = this.L;
        if (oVarArr == null || oVarArr.length <= i2) {
            o[] oVarArr2 = new o[i2 + 1];
            if (oVarArr != null) {
                System.arraycopy(oVarArr, 0, oVarArr2, 0, oVarArr.length);
            }
            this.L = oVarArr2;
            oVarArr = oVarArr2;
        }
        o oVar = oVarArr[i2];
        if (oVar == null) {
            o oVar2 = new o(i2);
            oVarArr[i2] = oVar2;
            return oVar2;
        }
        return oVar;
    }

    final CharSequence e0() {
        Object obj = this.i;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.p;
    }

    @Override // androidx.appcompat.app.e
    public void f(Context context) {
        I(false);
        this.O = true;
    }

    final Window.Callback f0() {
        return this.k.getCallback();
    }

    @Override // androidx.appcompat.app.e
    public <T extends View> T i(int i2) {
        X();
        return (T) this.k.findViewById(i2);
    }

    @Override // androidx.appcompat.app.e
    public int k() {
        return this.S;
    }

    @Override // androidx.appcompat.app.e
    public MenuInflater l() {
        if (this.o == null) {
            g0();
            androidx.appcompat.app.a aVar = this.n;
            this.o = new a.a.n.g(aVar != null ? aVar.k() : this.j);
        }
        return this.o;
    }

    @Override // androidx.appcompat.app.e
    public androidx.appcompat.app.a m() {
        g0();
        return this.n;
    }

    public boolean m0() {
        return this.y;
    }

    @Override // androidx.appcompat.app.e
    public void n() {
        LayoutInflater from = LayoutInflater.from(this.j);
        if (from.getFactory() == null) {
            a.g.k.f.b(from, this);
        } else if (from.getFactory2() instanceof f) {
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    int n0(int i2) {
        l c0;
        if (i2 != -100) {
            if (i2 != -1) {
                if (i2 != 0) {
                    if (i2 != 1 && i2 != 2) {
                        if (i2 != 3) {
                            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                        }
                        c0 = b0();
                    }
                } else if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) this.j.getSystemService(UiModeManager.class)).getNightMode() == 0) {
                    return -1;
                } else {
                    c0 = c0();
                }
                return c0.c();
            }
            return i2;
        }
        return -1;
    }

    @Override // androidx.appcompat.app.e
    public void o() {
        androidx.appcompat.app.a m2 = m();
        if (m2 == null || !m2.l()) {
            k0(0);
        }
    }

    boolean o0() {
        a.a.n.b bVar = this.t;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a m2 = m();
        return m2 != null && m2.h();
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return S(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    boolean p0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.N = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            q0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void r(Configuration configuration) {
        androidx.appcompat.app.a m2;
        if (this.F && this.z && (m2 = m()) != null) {
            m2.m(configuration);
        }
        androidx.appcompat.widget.j.b().g(this.j);
        I(false);
    }

    boolean r0(int i2, KeyEvent keyEvent) {
        androidx.appcompat.app.a m2 = m();
        if (m2 == null || !m2.o(i2, keyEvent)) {
            o oVar = this.M;
            if (oVar != null && z0(oVar, keyEvent.getKeyCode(), keyEvent, 1)) {
                o oVar2 = this.M;
                if (oVar2 != null) {
                    oVar2.n = true;
                }
                return true;
            }
            if (this.M == null) {
                o d0 = d0(0, true);
                A0(d0, keyEvent);
                boolean z0 = z0(d0, keyEvent.getKeyCode(), keyEvent, 1);
                d0.m = false;
                if (z0) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.app.e
    public void s(Bundle bundle) {
        this.O = true;
        I(false);
        Y();
        Object obj = this.i;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.f.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                androidx.appcompat.app.a y0 = y0();
                if (y0 == null) {
                    this.b0 = true;
                } else {
                    y0.r(true);
                }
            }
        }
        this.P = true;
    }

    boolean s0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z = this.N;
            this.N = false;
            o d0 = d0(0, false);
            if (d0 != null && d0.o) {
                if (!z) {
                    Q(d0, true);
                }
                return true;
            } else if (o0()) {
                return true;
            }
        } else if (i2 == 82) {
            t0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void t() {
        androidx.appcompat.app.e.q(this);
        if (this.Y) {
            this.k.getDecorView().removeCallbacks(this.a0);
        }
        this.Q = false;
        this.R = true;
        androidx.appcompat.app.a aVar = this.n;
        if (aVar != null) {
            aVar.n();
        }
        O();
    }

    @Override // androidx.appcompat.app.e
    public void u(Bundle bundle) {
        X();
    }

    void u0(int i2) {
        androidx.appcompat.app.a m2;
        if (i2 != 108 || (m2 = m()) == null) {
            return;
        }
        m2.i(true);
    }

    @Override // androidx.appcompat.app.e
    public void v() {
        androidx.appcompat.app.a m2 = m();
        if (m2 != null) {
            m2.s(true);
        }
    }

    void v0(int i2) {
        if (i2 == 108) {
            androidx.appcompat.app.a m2 = m();
            if (m2 != null) {
                m2.i(false);
            }
        } else if (i2 == 0) {
            o d0 = d0(i2, true);
            if (d0.o) {
                Q(d0, false);
            }
        }
    }

    @Override // androidx.appcompat.app.e
    public void w(Bundle bundle) {
        if (this.S != -100) {
            f0.put(this.i.getClass(), Integer.valueOf(this.S));
        }
    }

    void w0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.e
    public void x() {
        this.Q = true;
        d();
        androidx.appcompat.app.e.p(this);
    }

    @Override // androidx.appcompat.app.e
    public void y() {
        this.Q = false;
        androidx.appcompat.app.e.q(this);
        androidx.appcompat.app.a m2 = m();
        if (m2 != null) {
            m2.s(false);
        }
        if (this.i instanceof Dialog) {
            O();
        }
    }

    final androidx.appcompat.app.a y0() {
        return this.n;
    }
}
