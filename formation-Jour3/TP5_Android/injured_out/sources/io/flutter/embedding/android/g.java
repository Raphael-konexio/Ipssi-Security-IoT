package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import android.view.View;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes.dex */
public class g extends View implements io.flutter.embedding.engine.renderer.c {
    private ImageReader f;
    private Queue<Image> g;
    private Image h;
    private Bitmap i;
    private io.flutter.embedding.engine.renderer.a j;
    private b k;
    private boolean l;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2449a;

        static {
            int[] iArr = new int[b.values().length];
            f2449a = iArr;
            try {
                iArr[b.background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2449a[b.overlay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        background,
        overlay
    }

    public g(Context context, int i, int i2, b bVar) {
        this(context, e(i, i2), bVar);
    }

    g(Context context, ImageReader imageReader, b bVar) {
        super(context, null);
        this.l = false;
        this.f = imageReader;
        this.k = bVar;
        this.g = new LinkedList();
        f();
    }

    private static ImageReader e(int i, int i2) {
        return Build.VERSION.SDK_INT >= 29 ? ImageReader.newInstance(i, i2, 1, 3, 768L) : ImageReader.newInstance(i, i2, 1, 3);
    }

    private void f() {
        setAlpha(0.0f);
    }

    private void h() {
        if (Build.VERSION.SDK_INT >= 29) {
            HardwareBuffer hardwareBuffer = this.h.getHardwareBuffer();
            this.i = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
            hardwareBuffer.close();
            return;
        }
        Image.Plane[] planes = this.h.getPlanes();
        if (planes.length != 1) {
            return;
        }
        Image.Plane plane = planes[0];
        int rowStride = plane.getRowStride() / plane.getPixelStride();
        int height = this.h.getHeight();
        Bitmap bitmap = this.i;
        if (bitmap == null || bitmap.getWidth() != rowStride || this.i.getHeight() != height) {
            this.i = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
        }
        this.i.copyPixelsFromBuffer(plane.getBuffer());
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void a() {
        if (this.l) {
            setAlpha(0.0f);
            d();
            this.i = null;
            for (Image image : this.g) {
                image.close();
            }
            this.g.clear();
            Image image2 = this.h;
            if (image2 != null) {
                image2.close();
                this.h = null;
            }
            invalidate();
            this.l = false;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void b(io.flutter.embedding.engine.renderer.a aVar) {
        if (this.l) {
            return;
        }
        if (a.f2449a[this.k.ordinal()] == 1) {
            aVar.r(this.f.getSurface());
        }
        setAlpha(1.0f);
        this.j = aVar;
        this.l = true;
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void c() {
    }

    public boolean d() {
        Image acquireLatestImage;
        if (this.l) {
            int size = this.g.size();
            if (this.h != null) {
                size++;
            }
            if (size < this.f.getMaxImages() && (acquireLatestImage = this.f.acquireLatestImage()) != null) {
                this.g.add(acquireLatestImage);
            }
            invalidate();
            return !this.g.isEmpty();
        }
        return false;
    }

    public void g(int i, int i2) {
        if (this.j == null) {
            return;
        }
        if (i == this.f.getWidth() && i2 == this.f.getHeight()) {
            return;
        }
        this.g.clear();
        this.h = null;
        this.f.close();
        this.f = e(i, i2);
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public io.flutter.embedding.engine.renderer.a getAttachedRenderer() {
        return this.j;
    }

    public Surface getSurface() {
        return this.f.getSurface();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.g.isEmpty()) {
            Image image = this.h;
            if (image != null) {
                image.close();
            }
            this.h = this.g.poll();
            h();
        }
        Bitmap bitmap = this.i;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!(i == this.f.getWidth() && i2 == this.f.getHeight()) && this.k == b.background && this.l) {
            g(i, i2);
            this.j.r(this.f.getSurface());
        }
    }
}
