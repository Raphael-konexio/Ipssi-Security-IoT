package io.flutter.embedding.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/* loaded from: classes.dex */
public class h extends SurfaceView implements io.flutter.embedding.engine.renderer.c {
    private final boolean f;
    private boolean g;
    private boolean h;
    private io.flutter.embedding.engine.renderer.a i;
    private final SurfaceHolder.Callback j;
    private final io.flutter.embedding.engine.renderer.b k;

    /* loaded from: classes.dex */
    class a implements SurfaceHolder.Callback {
        a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            c.a.b.d("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceChanged()");
            if (h.this.h) {
                h.this.j(i2, i3);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            c.a.b.d("FlutterSurfaceView", "SurfaceHolder.Callback.startRenderingToSurface()");
            h.this.g = true;
            if (h.this.h) {
                h.this.k();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            c.a.b.d("FlutterSurfaceView", "SurfaceHolder.Callback.stopRenderingToSurface()");
            h.this.g = false;
            if (h.this.h) {
                h.this.l();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements io.flutter.embedding.engine.renderer.b {
        b() {
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void d() {
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void g() {
            c.a.b.d("FlutterSurfaceView", "onFlutterUiDisplayed()");
            h.this.setAlpha(1.0f);
            if (h.this.i != null) {
                h.this.i.l(this);
            }
        }
    }

    private h(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.g = false;
        this.h = false;
        this.j = new a();
        this.k = new b();
        this.f = z;
        m();
    }

    public h(Context context, boolean z) {
        this(context, null, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, int i2) {
        if (this.i == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        c.a.b.d("FlutterSurfaceView", "Notifying FlutterRenderer that Android surface size has changed to " + i + " x " + i2);
        this.i.q(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.i == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        this.i.o(getHolder().getSurface());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        io.flutter.embedding.engine.renderer.a aVar = this.i;
        if (aVar == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        aVar.p();
    }

    private void m() {
        if (this.f) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.j);
        setAlpha(0.0f);
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void a() {
        if (this.i == null) {
            c.a.b.e("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            c.a.b.d("FlutterSurfaceView", "Disconnecting FlutterRenderer from Android surface.");
            l();
        }
        setAlpha(0.0f);
        this.i.l(this.k);
        this.i = null;
        this.h = false;
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void b(io.flutter.embedding.engine.renderer.a aVar) {
        c.a.b.d("FlutterSurfaceView", "Attaching to FlutterRenderer.");
        if (this.i != null) {
            c.a.b.d("FlutterSurfaceView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.i.p();
            this.i.l(this.k);
        }
        this.i = aVar;
        this.h = true;
        aVar.f(this.k);
        if (this.g) {
            c.a.b.d("FlutterSurfaceView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            k();
        }
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void c() {
        if (this.i == null) {
            c.a.b.e("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
            return;
        }
        this.i = null;
        this.h = false;
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public io.flutter.embedding.engine.renderer.a getAttachedRenderer() {
        return this.i;
    }
}
