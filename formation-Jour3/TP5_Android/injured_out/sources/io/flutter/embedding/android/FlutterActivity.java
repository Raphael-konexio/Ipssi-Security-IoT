package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.e;
import androidx.recyclerview.widget.RecyclerView;
import io.flutter.embedding.android.e;
import io.flutter.embedding.android.f;
/* loaded from: classes.dex */
public class FlutterActivity extends Activity implements e.b, androidx.lifecycle.j {
    protected e f;
    private androidx.lifecycle.k g = new androidx.lifecycle.k(this);

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Class<? extends FlutterActivity> f2423a;

        /* renamed from: b  reason: collision with root package name */
        private String f2424b = "/";

        /* renamed from: c  reason: collision with root package name */
        private String f2425c = f.f2448a;

        public a(Class<? extends FlutterActivity> cls) {
            this.f2423a = cls;
        }

        public Intent a(Context context) {
            return new Intent(context, this.f2423a).putExtra("route", this.f2424b).putExtra("background_mode", this.f2425c).putExtra("destroy_engine_with_activity", true);
        }

        public a b(String str) {
            this.f2424b = str;
            return this;
        }
    }

    private void B() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(RecyclerView.UNDEFINED_DURATION);
            window.setStatusBarColor(1073741824);
            window.getDecorView().setSystemUiVisibility(1280);
        }
    }

    private void C() {
        if (E() == f.a.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    private View D() {
        return this.f.m(null, null, null);
    }

    private Drawable H() {
        try {
            Bundle G = G();
            int i = G != null ? G.getInt("io.flutter.embedding.android.SplashScreenDrawable") : 0;
            if (i != 0) {
                return Build.VERSION.SDK_INT > 21 ? getResources().getDrawable(i, getTheme()) : getResources().getDrawable(i);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private boolean I() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    private void J() {
        this.f.n();
        this.f.o();
        this.f.A();
        this.f = null;
    }

    private boolean K(String str) {
        if (this.f == null) {
            c.a.b.d("FlutterActivity", "FlutterActivity " + hashCode() + " " + str + " called after release.");
            return false;
        }
        return true;
    }

    private void L() {
        try {
            Bundle G = G();
            if (G != null) {
                int i = G.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i != -1) {
                    setTheme(i);
                }
            } else {
                c.a.b.d("FlutterActivity", "Using the launch theme as normal theme.");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            c.a.b.b("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    public static a M() {
        return new a(FlutterActivity.class);
    }

    @Override // io.flutter.embedding.android.e.b
    public void A(io.flutter.embedding.engine.a aVar) {
        io.flutter.embedding.engine.h.h.a.a(aVar);
    }

    protected f.a E() {
        return getIntent().hasExtra("background_mode") ? f.a.valueOf(getIntent().getStringExtra("background_mode")) : f.a.opaque;
    }

    protected io.flutter.embedding.engine.a F() {
        return this.f.e();
    }

    protected Bundle G() {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    @Override // io.flutter.embedding.android.e.b, androidx.lifecycle.j
    public androidx.lifecycle.e a() {
        return this.g;
    }

    @Override // io.flutter.plugin.platform.d.c
    public boolean b() {
        return false;
    }

    @Override // io.flutter.embedding.android.e.b
    public Context c() {
        return this;
    }

    @Override // io.flutter.embedding.android.e.b
    public void d() {
    }

    @Override // io.flutter.embedding.android.e.b
    public Activity e() {
        return this;
    }

    @Override // io.flutter.embedding.android.e.b
    public void f() {
        c.a.b.d("FlutterActivity", "FlutterActivity " + this + " connection to the engine " + F() + " evicted by another attaching activity");
        J();
    }

    @Override // io.flutter.embedding.android.e.b
    public void g() {
        if (Build.VERSION.SDK_INT >= 21) {
            reportFullyDrawn();
        }
    }

    @Override // io.flutter.embedding.android.e.b
    public String h() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle G = G();
            if (G != null) {
                return G.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // io.flutter.embedding.android.e.b
    public boolean k() {
        return true;
    }

    @Override // io.flutter.embedding.android.e.b
    public boolean l() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        return (m() != null || this.f.h()) ? booleanExtra : getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    @Override // io.flutter.embedding.android.e.b
    public String m() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    @Override // io.flutter.embedding.android.e.b
    public boolean n() {
        return getIntent().hasExtra("enable_state_restoration") ? getIntent().getBooleanExtra("enable_state_restoration", false) : m() == null;
    }

    @Override // io.flutter.embedding.android.e.b
    public String o() {
        try {
            Bundle G = G();
            String string = G != null ? G.getString("io.flutter.Entrypoint") : null;
            return string != null ? string : "main";
        } catch (PackageManager.NameNotFoundException unused) {
            return "main";
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (K("onActivityResult")) {
            this.f.j(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (K("onBackPressed")) {
            this.f.l();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        L();
        super.onCreate(bundle);
        e eVar = new e(this);
        this.f = eVar;
        eVar.k(this);
        this.f.t(bundle);
        this.g.i(e.a.ON_CREATE);
        C();
        setContentView(D());
        B();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (K("onDestroy")) {
            J();
        }
        this.g.i(e.a.ON_DESTROY);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (K("onNewIntent")) {
            this.f.p(intent);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f.q();
        this.g.i(e.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.f.r();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (K("onRequestPermissionsResult")) {
            this.f.s(i, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.g.i(e.a.ON_RESUME);
        this.f.u();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (K("onSaveInstanceState")) {
            this.f.v(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.g.i(e.a.ON_START);
        this.f.w();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (K("onStop")) {
            this.f.x();
        }
        this.g.i(e.a.ON_STOP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (K("onTrimMemory")) {
            this.f.y(i);
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        if (K("onUserLeaveHint")) {
            this.f.z();
        }
    }

    @Override // io.flutter.embedding.android.e.b
    public void p(io.flutter.embedding.engine.a aVar) {
    }

    @Override // io.flutter.embedding.android.e.b
    public io.flutter.plugin.platform.d q(Activity activity, io.flutter.embedding.engine.a aVar) {
        e();
        return new io.flutter.plugin.platform.d(this, aVar.n(), this);
    }

    @Override // io.flutter.embedding.android.e.b
    public void r(h hVar) {
    }

    @Override // io.flutter.embedding.android.e.b
    public String s() {
        String dataString;
        if (I() && "android.intent.action.RUN".equals(getIntent().getAction()) && (dataString = getIntent().getDataString()) != null) {
            return dataString;
        }
        return null;
    }

    @Override // io.flutter.embedding.android.e.b
    public boolean t() {
        try {
            Bundle G = G();
            if (G != null) {
                return G.getBoolean("flutter_deeplinking_enabled");
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // io.flutter.embedding.android.e.b
    public io.flutter.embedding.engine.d u() {
        return io.flutter.embedding.engine.d.a(getIntent());
    }

    @Override // io.flutter.embedding.android.e.b
    public l v() {
        return E() == f.a.opaque ? l.surface : l.texture;
    }

    @Override // io.flutter.embedding.android.e.b
    public n w() {
        Drawable H = H();
        if (H != null) {
            return new c(H);
        }
        return null;
    }

    @Override // io.flutter.embedding.android.e.b
    public io.flutter.embedding.engine.a x(Context context) {
        return null;
    }

    @Override // io.flutter.embedding.android.e.b
    public o y() {
        return E() == f.a.opaque ? o.opaque : o.transparent;
    }

    @Override // io.flutter.embedding.android.e.b
    public void z(i iVar) {
    }
}
