package io.flutter.plugin.platform;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import io.flutter.plugin.platform.SingleViewPresentation;
import io.flutter.view.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2654a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2655b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2656c;

    /* renamed from: d  reason: collision with root package name */
    private final e.a f2657d;
    private final View.OnFocusChangeListener e;
    private VirtualDisplay f;
    SingleViewPresentation g;
    private Surface h;

    /* loaded from: classes.dex */
    class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ View f;
        final /* synthetic */ Runnable g;

        /* renamed from: io.flutter.plugin.platform.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0128a implements Runnable {
            RunnableC0128a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.f.postDelayed(aVar.g, 128L);
            }
        }

        a(k kVar, View view, Runnable runnable) {
            this.f = view;
            this.g = runnable;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b.a(this.f, new RunnableC0128a());
            this.f.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: classes.dex */
    static class b implements ViewTreeObserver.OnDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final View f2658a;

        /* renamed from: b  reason: collision with root package name */
        Runnable f2659b;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f2658a.getViewTreeObserver().removeOnDrawListener(b.this);
            }
        }

        b(View view, Runnable runnable) {
            this.f2658a = view;
            this.f2659b = runnable;
        }

        static void a(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new b(view, runnable));
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f2659b;
            if (runnable == null) {
                return;
            }
            runnable.run();
            this.f2659b = null;
            this.f2658a.post(new a());
        }
    }

    private k(Context context, c cVar, VirtualDisplay virtualDisplay, f fVar, Surface surface, e.a aVar, View.OnFocusChangeListener onFocusChangeListener, int i, Object obj) {
        this.f2654a = context;
        this.f2655b = cVar;
        this.f2657d = aVar;
        this.e = onFocusChangeListener;
        this.h = surface;
        this.f = virtualDisplay;
        this.f2656c = context.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context, this.f.getDisplay(), fVar, cVar, i, obj, onFocusChangeListener);
        this.g = singleViewPresentation;
        singleViewPresentation.show();
    }

    public static k a(Context context, c cVar, f fVar, e.a aVar, int i, int i2, int i3, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        aVar.b().setDefaultBufferSize(i, i2);
        Surface surface = new Surface(aVar.b());
        VirtualDisplay createVirtualDisplay = ((DisplayManager) context.getSystemService("display")).createVirtualDisplay("flutter-vd", i, i2, context.getResources().getDisplayMetrics().densityDpi, surface, 0);
        if (createVirtualDisplay == null) {
            return null;
        }
        return new k(context, cVar, createVirtualDisplay, fVar, surface, aVar, onFocusChangeListener, i3, obj);
    }

    public void b(MotionEvent motionEvent) {
        SingleViewPresentation singleViewPresentation = this.g;
        if (singleViewPresentation == null) {
            return;
        }
        singleViewPresentation.dispatchTouchEvent(motionEvent);
    }

    public void c() {
        e view = this.g.getView();
        this.g.cancel();
        this.g.detachState();
        view.a();
        this.f.release();
        this.f2657d.a();
    }

    public View d() {
        SingleViewPresentation singleViewPresentation = this.g;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(View view) {
        SingleViewPresentation singleViewPresentation = this.g;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.g.getView().d(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        SingleViewPresentation singleViewPresentation = this.g;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.g.getView().e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        SingleViewPresentation singleViewPresentation = this.g;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.g.getView().f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        SingleViewPresentation singleViewPresentation = this.g;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.g.getView().b();
    }

    public void i(int i, int i2, Runnable runnable) {
        boolean isFocused = d().isFocused();
        SingleViewPresentation.e detachState = this.g.detachState();
        this.f.setSurface(null);
        this.f.release();
        this.f2657d.b().setDefaultBufferSize(i, i2);
        this.f = ((DisplayManager) this.f2654a.getSystemService("display")).createVirtualDisplay("flutter-vd", i, i2, this.f2656c, this.h, 0);
        View d2 = d();
        d2.addOnAttachStateChangeListener(new a(this, d2, runnable));
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.f2654a, this.f.getDisplay(), this.f2655b, detachState, this.e, isFocused);
        singleViewPresentation.show();
        this.g.cancel();
        this.g = singleViewPresentation;
    }
}
