package io.flutter.embedding.engine.e;

import android.content.res.AssetManager;
import c.a.c.a.b;
import c.a.c.a.s;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a implements c.a.c.a.b {

    /* renamed from: a  reason: collision with root package name */
    private final FlutterJNI f2478a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f2479b;

    /* renamed from: c  reason: collision with root package name */
    private final io.flutter.embedding.engine.e.b f2480c;

    /* renamed from: d  reason: collision with root package name */
    private final c.a.c.a.b f2481d;
    private String f;
    private d g;
    private boolean e = false;
    private final b.a h = new C0116a();

    /* renamed from: io.flutter.embedding.engine.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0116a implements b.a {
        C0116a() {
        }

        @Override // c.a.c.a.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0071b interfaceC0071b) {
            a.this.f = s.f1507b.b(byteBuffer);
            if (a.this.g != null) {
                a.this.g.a(a.this.f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f2483a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2484b;

        public b(String str, String str2) {
            this.f2483a = str;
            this.f2484b = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f2483a.equals(bVar.f2483a)) {
                return this.f2484b.equals(bVar.f2484b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f2483a.hashCode() * 31) + this.f2484b.hashCode();
        }

        public String toString() {
            return "DartEntrypoint( bundle path: " + this.f2483a + ", function: " + this.f2484b + " )";
        }
    }

    /* loaded from: classes.dex */
    private static class c implements c.a.c.a.b {

        /* renamed from: a  reason: collision with root package name */
        private final io.flutter.embedding.engine.e.b f2485a;

        private c(io.flutter.embedding.engine.e.b bVar) {
            this.f2485a = bVar;
        }

        /* synthetic */ c(io.flutter.embedding.engine.e.b bVar, C0116a c0116a) {
            this(bVar);
        }

        @Override // c.a.c.a.b
        public void a(String str, ByteBuffer byteBuffer, b.InterfaceC0071b interfaceC0071b) {
            this.f2485a.a(str, byteBuffer, interfaceC0071b);
        }

        @Override // c.a.c.a.b
        public void b(String str, b.a aVar) {
            this.f2485a.b(str, aVar);
        }
    }

    /* loaded from: classes.dex */
    interface d {
        void a(String str);
    }

    public a(FlutterJNI flutterJNI, AssetManager assetManager) {
        this.f2478a = flutterJNI;
        this.f2479b = assetManager;
        io.flutter.embedding.engine.e.b bVar = new io.flutter.embedding.engine.e.b(flutterJNI);
        this.f2480c = bVar;
        bVar.b("flutter/isolate", this.h);
        this.f2481d = new c(this.f2480c, null);
    }

    @Override // c.a.c.a.b
    @Deprecated
    public void a(String str, ByteBuffer byteBuffer, b.InterfaceC0071b interfaceC0071b) {
        this.f2481d.a(str, byteBuffer, interfaceC0071b);
    }

    @Override // c.a.c.a.b
    @Deprecated
    public void b(String str, b.a aVar) {
        this.f2481d.b(str, aVar);
    }

    public void f(b bVar) {
        if (this.e) {
            c.a.b.e("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        c.a.b.d("DartExecutor", "Executing Dart entrypoint: " + bVar);
        this.f2478a.runBundleAndSnapshotFromLibrary(bVar.f2483a, bVar.f2484b, null, this.f2479b);
        this.e = true;
    }

    public String g() {
        return this.f;
    }

    public boolean h() {
        return this.e;
    }

    public void i() {
        if (this.f2478a.isAttached()) {
            this.f2478a.notifyLowMemoryWarning();
        }
    }

    public void j() {
        c.a.b.d("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.f2478a.setPlatformMessageHandler(this.f2480c);
    }

    public void k() {
        c.a.b.d("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.f2478a.setPlatformMessageHandler(null);
    }
}
