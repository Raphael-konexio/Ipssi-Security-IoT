package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.flutter.embedding.engine.e.a;
import io.flutter.plugin.platform.d;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements d<Activity> {

    /* renamed from: a  reason: collision with root package name */
    private b f2443a;

    /* renamed from: b  reason: collision with root package name */
    private io.flutter.embedding.engine.a f2444b;

    /* renamed from: c  reason: collision with root package name */
    private FlutterSplashView f2445c;

    /* renamed from: d  reason: collision with root package name */
    private j f2446d;
    private io.flutter.plugin.platform.d e;
    private boolean f;
    private final io.flutter.embedding.engine.renderer.b g = new a();

    /* loaded from: classes.dex */
    class a implements io.flutter.embedding.engine.renderer.b {
        a() {
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void d() {
            e.this.f2443a.d();
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void g() {
            e.this.f2443a.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b extends d.c {
        void A(io.flutter.embedding.engine.a aVar);

        androidx.lifecycle.e a();

        Context c();

        void d();

        Activity e();

        void f();

        void g();

        String h();

        boolean k();

        boolean l();

        String m();

        boolean n();

        String o();

        void p(io.flutter.embedding.engine.a aVar);

        io.flutter.plugin.platform.d q(Activity activity, io.flutter.embedding.engine.a aVar);

        void r(h hVar);

        String s();

        boolean t();

        io.flutter.embedding.engine.d u();

        l v();

        n w();

        io.flutter.embedding.engine.a x(Context context);

        o y();

        void z(i iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.f2443a = bVar;
    }

    private void b() {
        if (this.f2443a.m() == null && !this.f2444b.h().h()) {
            String h = this.f2443a.h();
            if (h == null && (h = i(this.f2443a.e().getIntent())) == null) {
                h = "/";
            }
            c.a.b.d("FlutterActivityAndFragmentDelegate", "Executing Dart entrypoint: " + this.f2443a.o() + ", and sending initial route: " + h);
            this.f2444b.m().c(h);
            String s = this.f2443a.s();
            if (s == null || s.isEmpty()) {
                s = c.a.a.c().b().d();
            }
            this.f2444b.h().f(new a.b(s, this.f2443a.o()));
        }
    }

    private void c() {
        if (this.f2443a == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    private String i(Intent intent) {
        Uri data;
        if (!this.f2443a.t() || (data = intent.getData()) == null || data.toString().isEmpty()) {
            return null;
        }
        return data.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        this.f2443a = null;
        this.f2444b = null;
        this.f2446d = null;
        this.e = null;
    }

    void B() {
        c.a.b.d("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
        String m = this.f2443a.m();
        if (m != null) {
            io.flutter.embedding.engine.a a2 = io.flutter.embedding.engine.b.b().a(m);
            this.f2444b = a2;
            this.f = true;
            if (a2 != null) {
                return;
            }
            throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + m + "'");
        }
        b bVar = this.f2443a;
        io.flutter.embedding.engine.a x = bVar.x(bVar.c());
        this.f2444b = x;
        if (x != null) {
            this.f = true;
            return;
        }
        c.a.b.d("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
        this.f2444b = new io.flutter.embedding.engine.a(this.f2443a.c(), this.f2443a.u().b(), false, this.f2443a.n());
        this.f = false;
    }

    @Override // io.flutter.embedding.android.d
    /* renamed from: d */
    public Activity g() {
        Activity e = this.f2443a.e();
        if (e != null) {
            return e;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public io.flutter.embedding.engine.a e() {
        return this.f2444b;
    }

    @Override // io.flutter.embedding.android.d
    public void f() {
        if (!this.f2443a.l()) {
            this.f2443a.f();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f2443a + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(int i, int i2, Intent intent) {
        c();
        if (this.f2444b == null) {
            c.a.b.e("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        c.a.b.d("FlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i + "\nresultCode: " + i2 + "\ndata: " + intent);
        this.f2444b.g().a(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Context context) {
        c();
        if (this.f2444b == null) {
            B();
        }
        if (this.f2443a.k()) {
            c.a.b.d("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.f2444b.g().g(this, this.f2443a.a());
        }
        b bVar = this.f2443a;
        this.e = bVar.q(bVar.e(), this.f2444b);
        this.f2443a.A(this.f2444b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        c();
        if (this.f2444b == null) {
            c.a.b.e("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
            return;
        }
        c.a.b.d("FlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.");
        this.f2444b.m().a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View m(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j jVar;
        c.a.b.d("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
        c();
        if (this.f2443a.v() == l.surface) {
            h hVar = new h(this.f2443a.e(), this.f2443a.y() == o.transparent);
            this.f2443a.r(hVar);
            jVar = new j(this.f2443a.e(), hVar);
        } else {
            i iVar = new i(this.f2443a.e());
            this.f2443a.z(iVar);
            jVar = new j(this.f2443a.e(), iVar);
        }
        this.f2446d = jVar;
        this.f2446d.h(this.g);
        FlutterSplashView flutterSplashView = new FlutterSplashView(this.f2443a.c());
        this.f2445c = flutterSplashView;
        flutterSplashView.setId(Build.VERSION.SDK_INT >= 17 ? View.generateViewId() : 486947586);
        this.f2445c.g(this.f2446d, this.f2443a.w());
        c.a.b.d("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
        this.f2446d.j(this.f2444b);
        return this.f2445c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        c.a.b.d("FlutterActivityAndFragmentDelegate", "onDestroyView()");
        c();
        this.f2446d.n();
        this.f2446d.t(this.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        c.a.b.d("FlutterActivityAndFragmentDelegate", "onDetach()");
        c();
        this.f2443a.p(this.f2444b);
        if (this.f2443a.k()) {
            c.a.b.d("FlutterActivityAndFragmentDelegate", "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.f2443a.e().isChangingConfigurations()) {
                this.f2444b.g().h();
            } else {
                this.f2444b.g().i();
            }
        }
        io.flutter.plugin.platform.d dVar = this.e;
        if (dVar != null) {
            dVar.j();
            this.e = null;
        }
        this.f2444b.j().a();
        if (this.f2443a.l()) {
            this.f2444b.e();
            if (this.f2443a.m() != null) {
                io.flutter.embedding.engine.b.b().d(this.f2443a.m());
            }
            this.f2444b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Intent intent) {
        c();
        if (this.f2444b == null) {
            c.a.b.e("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        c.a.b.d("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine and sending pushRoute message.");
        this.f2444b.g().c(intent);
        String i = i(intent);
        if (i == null || i.isEmpty()) {
            return;
        }
        this.f2444b.m().b(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        c.a.b.d("FlutterActivityAndFragmentDelegate", "onPause()");
        c();
        this.f2444b.j().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        c.a.b.d("FlutterActivityAndFragmentDelegate", "onPostResume()");
        c();
        if (this.f2444b == null) {
            c.a.b.e("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        io.flutter.plugin.platform.d dVar = this.e;
        if (dVar != null) {
            dVar.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i, String[] strArr, int[] iArr) {
        c();
        if (this.f2444b == null) {
            c.a.b.e("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        c.a.b.d("FlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
        this.f2444b.g().b(i, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Bundle bundle) {
        Bundle bundle2;
        c.a.b.d("FlutterActivityAndFragmentDelegate", "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        c();
        byte[] bArr = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle("plugins");
            bArr = bundle.getByteArray("framework");
            bundle2 = bundle3;
        } else {
            bundle2 = null;
        }
        if (this.f2443a.n()) {
            this.f2444b.r().j(bArr);
        }
        if (this.f2443a.k()) {
            this.f2444b.g().d(bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        c.a.b.d("FlutterActivityAndFragmentDelegate", "onResume()");
        c();
        this.f2444b.j().d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(Bundle bundle) {
        c.a.b.d("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        c();
        if (this.f2443a.n()) {
            bundle.putByteArray("framework", this.f2444b.r().h());
        }
        if (this.f2443a.k()) {
            Bundle bundle2 = new Bundle();
            this.f2444b.g().e(bundle2);
            bundle.putBundle("plugins", bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        c.a.b.d("FlutterActivityAndFragmentDelegate", "onStart()");
        c();
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        c.a.b.d("FlutterActivityAndFragmentDelegate", "onStop()");
        c();
        this.f2444b.j().c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(int i) {
        c();
        io.flutter.embedding.engine.a aVar = this.f2444b;
        if (aVar == null) {
            c.a.b.e("FlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        aVar.h().i();
        if (i == 10) {
            c.a.b.d("FlutterActivityAndFragmentDelegate", "Forwarding onTrimMemory() to FlutterEngine. Level: " + i);
            this.f2444b.t().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        c();
        if (this.f2444b == null) {
            c.a.b.e("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        c.a.b.d("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
        this.f2444b.g().f();
    }
}
