package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import io.flutter.embedding.engine.i.e;
import io.flutter.embedding.engine.i.f;
import io.flutter.embedding.engine.i.g;
import io.flutter.embedding.engine.i.h;
import io.flutter.embedding.engine.i.j;
import io.flutter.embedding.engine.i.k;
import io.flutter.embedding.engine.i.l;
import io.flutter.embedding.engine.i.m;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final FlutterJNI f2462a;

    /* renamed from: b  reason: collision with root package name */
    private final io.flutter.embedding.engine.renderer.a f2463b;

    /* renamed from: c  reason: collision with root package name */
    private final io.flutter.embedding.engine.e.a f2464c;

    /* renamed from: d  reason: collision with root package name */
    private final c f2465d;
    private final c.a.c.b.a e;
    private final io.flutter.embedding.engine.i.b f;
    private final io.flutter.embedding.engine.i.c g;
    private final io.flutter.embedding.engine.i.d h;
    private final e i;
    private final f j;
    private final g k;
    private final j l;
    private final h m;
    private final k n;
    private final l o;
    private final m p;
    private final io.flutter.plugin.platform.j q;
    private final Set<b> r;
    private final b s;

    /* renamed from: io.flutter.embedding.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0114a implements b {
        C0114a() {
        }

        @Override // io.flutter.embedding.engine.a.b
        public void a() {
            c.a.b.d("FlutterEngine", "onPreEngineRestart()");
            for (b bVar : a.this.r) {
                bVar.a();
            }
            a.this.q.S();
            a.this.l.g();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    public a(Context context, io.flutter.embedding.engine.g.c cVar, FlutterJNI flutterJNI, io.flutter.plugin.platform.j jVar, String[] strArr, boolean z, boolean z2) {
        AssetManager assets;
        this.r = new HashSet();
        this.s = new C0114a();
        try {
            assets = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assets = context.getAssets();
        }
        io.flutter.embedding.engine.e.a aVar = new io.flutter.embedding.engine.e.a(flutterJNI, assets);
        this.f2464c = aVar;
        aVar.j();
        this.f = new io.flutter.embedding.engine.i.b(this.f2464c, flutterJNI);
        this.g = new io.flutter.embedding.engine.i.c(this.f2464c);
        this.h = new io.flutter.embedding.engine.i.d(this.f2464c);
        this.i = new e(this.f2464c);
        this.j = new f(this.f2464c);
        this.k = new g(this.f2464c);
        this.m = new h(this.f2464c);
        this.l = new j(this.f2464c, z2);
        this.n = new k(this.f2464c);
        this.o = new l(this.f2464c);
        this.p = new m(this.f2464c);
        this.e = new c.a.c.b.a(context, this.i);
        this.f2462a = flutterJNI;
        cVar = cVar == null ? c.a.a.c().b() : cVar;
        cVar.f(context.getApplicationContext());
        cVar.c(context, strArr);
        flutterJNI.addEngineLifecycleListener(this.s);
        flutterJNI.setPlatformViewsController(jVar);
        flutterJNI.setLocalizationPlugin(this.e);
        flutterJNI.setDynamicFeatureManager(c.a.a.c().a());
        d();
        this.f2463b = new io.flutter.embedding.engine.renderer.a(flutterJNI);
        this.q = jVar;
        jVar.M();
        this.f2465d = new c(context.getApplicationContext(), this, cVar);
        if (z) {
            w();
        }
    }

    public a(Context context, String[] strArr, boolean z, boolean z2) {
        this(context, null, new FlutterJNI(), new io.flutter.plugin.platform.j(), strArr, z, z2);
    }

    private void d() {
        c.a.b.d("FlutterEngine", "Attaching to JNI.");
        this.f2462a.attachToNative(false);
        if (!v()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    private boolean v() {
        return this.f2462a.isAttached();
    }

    private void w() {
        try {
            Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", a.class).invoke(null, this);
        } catch (Exception unused) {
            c.a.b.e("FlutterEngine", "Tried to automatically register plugins with FlutterEngine (" + this + ") but could not find and invoke the GeneratedPluginRegistrant.");
        }
    }

    public void e() {
        c.a.b.d("FlutterEngine", "Destroying.");
        this.f2465d.m();
        this.q.O();
        this.f2464c.k();
        this.f2462a.removeEngineLifecycleListener(this.s);
        this.f2462a.setDynamicFeatureManager(null);
        this.f2462a.detachFromNativeAndReleaseResources();
        if (c.a.a.c().a() != null) {
            c.a.a.c().a().c();
        }
    }

    public io.flutter.embedding.engine.i.b f() {
        return this.f;
    }

    public io.flutter.embedding.engine.h.c.b g() {
        return this.f2465d;
    }

    public io.flutter.embedding.engine.e.a h() {
        return this.f2464c;
    }

    public io.flutter.embedding.engine.i.c i() {
        return this.g;
    }

    public io.flutter.embedding.engine.i.d j() {
        return this.h;
    }

    public c.a.c.b.a k() {
        return this.e;
    }

    public f l() {
        return this.j;
    }

    public g m() {
        return this.k;
    }

    public h n() {
        return this.m;
    }

    public io.flutter.plugin.platform.j o() {
        return this.q;
    }

    public io.flutter.embedding.engine.h.b p() {
        return this.f2465d;
    }

    public io.flutter.embedding.engine.renderer.a q() {
        return this.f2463b;
    }

    public j r() {
        return this.l;
    }

    public k s() {
        return this.n;
    }

    public l t() {
        return this.o;
    }

    public m u() {
        return this.p;
    }
}
