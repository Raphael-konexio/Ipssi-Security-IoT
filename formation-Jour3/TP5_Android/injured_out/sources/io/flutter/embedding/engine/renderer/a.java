package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.e;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private final FlutterJNI f2598a;

    /* renamed from: c  reason: collision with root package name */
    private Surface f2600c;
    private final io.flutter.embedding.engine.renderer.b e;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicLong f2599b = new AtomicLong(0);

    /* renamed from: d  reason: collision with root package name */
    private boolean f2601d = false;

    /* renamed from: io.flutter.embedding.engine.renderer.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0124a implements io.flutter.embedding.engine.renderer.b {
        C0124a() {
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void d() {
            a.this.f2601d = false;
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void g() {
            a.this.f2601d = true;
        }
    }

    /* loaded from: classes.dex */
    final class b implements e.a {

        /* renamed from: a  reason: collision with root package name */
        private final long f2603a;

        /* renamed from: b  reason: collision with root package name */
        private final SurfaceTextureWrapper f2604b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2605c;

        /* renamed from: d  reason: collision with root package name */
        private SurfaceTexture.OnFrameAvailableListener f2606d = new C0125a();

        /* renamed from: io.flutter.embedding.engine.renderer.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0125a implements SurfaceTexture.OnFrameAvailableListener {
            C0125a() {
            }

            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (b.this.f2605c || !a.this.f2598a.isAttached()) {
                    return;
                }
                b bVar = b.this;
                a.this.j(bVar.f2603a);
            }
        }

        b(long j, SurfaceTexture surfaceTexture) {
            this.f2603a = j;
            this.f2604b = new SurfaceTextureWrapper(surfaceTexture);
            if (Build.VERSION.SDK_INT >= 21) {
                b().setOnFrameAvailableListener(this.f2606d, new Handler());
            } else {
                b().setOnFrameAvailableListener(this.f2606d);
            }
        }

        @Override // io.flutter.view.e.a
        public void a() {
            if (this.f2605c) {
                return;
            }
            c.a.b.d("FlutterRenderer", "Releasing a SurfaceTexture (" + this.f2603a + ").");
            this.f2604b.release();
            a.this.s(this.f2603a);
            this.f2605c = true;
        }

        @Override // io.flutter.view.e.a
        public SurfaceTexture b() {
            return this.f2604b.surfaceTexture();
        }

        @Override // io.flutter.view.e.a
        public long c() {
            return this.f2603a;
        }

        public SurfaceTextureWrapper f() {
            return this.f2604b;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public float f2608a = 1.0f;

        /* renamed from: b  reason: collision with root package name */
        public int f2609b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f2610c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f2611d = 0;
        public int e = 0;
        public int f = 0;
        public int g = 0;
        public int h = 0;
        public int i = 0;
        public int j = 0;
        public int k = 0;
        public int l = 0;
        public int m = 0;
        public int n = 0;
        public int o = 0;
    }

    public a(FlutterJNI flutterJNI) {
        C0124a c0124a = new C0124a();
        this.e = c0124a;
        this.f2598a = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(c0124a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j) {
        this.f2598a.markTextureFrameAvailable(j);
    }

    private void k(long j, SurfaceTextureWrapper surfaceTextureWrapper) {
        this.f2598a.registerTexture(j, surfaceTextureWrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j) {
        this.f2598a.unregisterTexture(j);
    }

    @Override // io.flutter.view.e
    public e.a a() {
        c.a.b.d("FlutterRenderer", "Creating a SurfaceTexture.");
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.detachFromGLContext();
        b bVar = new b(this.f2599b.getAndIncrement(), surfaceTexture);
        c.a.b.d("FlutterRenderer", "New SurfaceTexture ID: " + bVar.c());
        k(bVar.c(), bVar.f());
        return bVar;
    }

    public void f(io.flutter.embedding.engine.renderer.b bVar) {
        this.f2598a.addIsDisplayingFlutterUiListener(bVar);
        if (this.f2601d) {
            bVar.g();
        }
    }

    public void g(ByteBuffer byteBuffer, int i) {
        this.f2598a.dispatchPointerDataPacket(byteBuffer, i);
    }

    public boolean h() {
        return this.f2601d;
    }

    public boolean i() {
        return this.f2598a.getIsSoftwareRenderingEnabled();
    }

    public void l(io.flutter.embedding.engine.renderer.b bVar) {
        this.f2598a.removeIsDisplayingFlutterUiListener(bVar);
    }

    public void m(boolean z) {
        this.f2598a.setSemanticsEnabled(z);
    }

    public void n(c cVar) {
        c.a.b.d("FlutterRenderer", "Setting viewport metrics\nSize: " + cVar.f2609b + " x " + cVar.f2610c + "\nPadding - L: " + cVar.g + ", T: " + cVar.f2611d + ", R: " + cVar.e + ", B: " + cVar.f + "\nInsets - L: " + cVar.k + ", T: " + cVar.h + ", R: " + cVar.i + ", B: " + cVar.j + "\nSystem Gesture Insets - L: " + cVar.o + ", T: " + cVar.l + ", R: " + cVar.m + ", B: " + cVar.j);
        this.f2598a.setViewportMetrics(cVar.f2608a, cVar.f2609b, cVar.f2610c, cVar.f2611d, cVar.e, cVar.f, cVar.g, cVar.h, cVar.i, cVar.j, cVar.k, cVar.l, cVar.m, cVar.n, cVar.o);
    }

    public void o(Surface surface) {
        if (this.f2600c != null) {
            p();
        }
        this.f2600c = surface;
        this.f2598a.onSurfaceCreated(surface);
    }

    public void p() {
        this.f2598a.onSurfaceDestroyed();
        this.f2600c = null;
        if (this.f2601d) {
            this.e.d();
        }
        this.f2601d = false;
    }

    public void q(int i, int i2) {
        this.f2598a.onSurfaceChanged(i, i2);
    }

    public void r(Surface surface) {
        this.f2600c = surface;
        this.f2598a.onSurfaceWindowChanged(surface);
    }
}
