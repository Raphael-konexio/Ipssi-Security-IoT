package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
/* loaded from: classes.dex */
public class i extends TextureView implements io.flutter.embedding.engine.renderer.c {
    private boolean f;
    private boolean g;
    private io.flutter.embedding.engine.renderer.a h;
    private Surface i;
    private final TextureView.SurfaceTextureListener j;

    /* loaded from: classes.dex */
    class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            c.a.b.d("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
            i.this.f = true;
            if (i.this.g) {
                i.this.j();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            c.a.b.d("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
            i.this.f = false;
            if (i.this.g) {
                i.this.k();
                return true;
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            c.a.b.d("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
            if (i.this.g) {
                i.this.i(i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public i(Context context) {
        this(context, null);
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.g = false;
        this.j = new a();
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, int i2) {
        if (this.h == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        c.a.b.d("FlutterTextureView", "Notifying FlutterRenderer that Android surface size has changed to " + i + " x " + i2);
        this.h.q(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.h == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        Surface surface = new Surface(getSurfaceTexture());
        this.i = surface;
        this.h.o(surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        io.flutter.embedding.engine.renderer.a aVar = this.h;
        if (aVar == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        aVar.p();
        Surface surface = this.i;
        if (surface != null) {
            surface.release();
            this.i = null;
        }
    }

    private void l() {
        setSurfaceTextureListener(this.j);
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void a() {
        if (this.h == null) {
            c.a.b.e("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            c.a.b.d("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
            k();
        }
        this.h = null;
        this.g = false;
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void b(io.flutter.embedding.engine.renderer.a aVar) {
        c.a.b.d("FlutterTextureView", "Attaching to FlutterRenderer.");
        if (this.h != null) {
            c.a.b.d("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.h.p();
        }
        this.h = aVar;
        this.g = true;
        if (this.f) {
            c.a.b.d("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            j();
        }
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void c() {
        if (this.h == null) {
            c.a.b.e("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
            return;
        }
        this.h = null;
        this.g = false;
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public io.flutter.embedding.engine.renderer.a getAttachedRenderer() {
        return this.h;
    }
}
