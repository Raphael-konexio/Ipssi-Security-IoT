package io.flutter.plugin.platform;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.flutter.embedding.android.g;
import io.flutter.embedding.android.k;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.i.i;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.plugin.platform.j;
import io.flutter.view.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class j implements i {

    /* renamed from: b  reason: collision with root package name */
    private io.flutter.embedding.android.b f2650b;

    /* renamed from: c  reason: collision with root package name */
    private Context f2651c;

    /* renamed from: d  reason: collision with root package name */
    private View f2652d;
    private io.flutter.view.e e;
    private io.flutter.plugin.editing.d f;
    private io.flutter.embedding.engine.i.i g;
    private int n = 0;
    private boolean o = false;
    private final i.e s = new a();

    /* renamed from: a  reason: collision with root package name */
    private final h f2649a = new h();
    final HashMap<Integer, k> i = new HashMap<>();
    private final c h = new c();
    private final HashMap<Context, View> j = new HashMap<>();
    private final SparseArray<io.flutter.embedding.android.g> m = new SparseArray<>();
    private HashSet<Integer> p = new HashSet<>();
    private HashSet<Integer> q = new HashSet<>();
    private final SparseArray<e> k = new SparseArray<>();
    private final SparseArray<io.flutter.embedding.engine.mutatorsstack.a> l = new SparseArray<>();
    private final io.flutter.embedding.android.k r = io.flutter.embedding.android.k.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements i.e {

        /* renamed from: io.flutter.plugin.platform.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0127a implements Runnable {
            final /* synthetic */ k f;
            final /* synthetic */ Runnable g;

            RunnableC0127a(k kVar, Runnable runnable) {
                this.f = kVar;
                this.g = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                j.this.Z(this.f);
                this.g.run();
            }
        }

        a() {
        }

        private void i(int i) {
            if (Build.VERSION.SDK_INT >= i) {
                return;
            }
            throw new IllegalStateException("Trying to use platform views with API " + Build.VERSION.SDK_INT + ", required API level is: " + i);
        }

        @Override // io.flutter.embedding.engine.i.i.e
        public void a(i.c cVar, Runnable runnable) {
            i(20);
            k kVar = j.this.i.get(Integer.valueOf(cVar.f2561a));
            if (kVar == null) {
                throw new IllegalStateException("Trying to resize a platform view with unknown id: " + cVar.f2561a);
            }
            int Y = j.this.Y(cVar.f2562b);
            int Y2 = j.this.Y(cVar.f2563c);
            j.this.b0(Y, Y2);
            j.this.L(kVar);
            kVar.i(Y, Y2, new RunnableC0127a(kVar, runnable));
        }

        @Override // io.flutter.embedding.engine.i.i.e
        public void b(int i) {
            e eVar = (e) j.this.k.get(i);
            io.flutter.embedding.engine.mutatorsstack.a aVar = (io.flutter.embedding.engine.mutatorsstack.a) j.this.l.get(i);
            if (eVar != null) {
                if (aVar != null) {
                    aVar.removeView(eVar.c());
                }
                j.this.k.remove(i);
                eVar.a();
            }
            if (aVar != null) {
                ((ViewGroup) aVar.getParent()).removeView(aVar);
                j.this.l.remove(i);
            }
        }

        @Override // io.flutter.embedding.engine.i.i.e
        public void c(int i, int i2) {
            if (!j.a0(i2)) {
                throw new IllegalStateException("Trying to set unknown direction value: " + i2 + "(view id: " + i + ")");
            }
            i(20);
            View d2 = j.this.i.get(Integer.valueOf(i)).d();
            if (d2 != null) {
                d2.setLayoutDirection(i2);
                return;
            }
            throw new IllegalStateException("Sending touch to an unknown view with id: " + i2);
        }

        @Override // io.flutter.embedding.engine.i.i.e
        public long d(final i.b bVar) {
            i(20);
            if (!j.a0(bVar.e)) {
                throw new IllegalStateException("Trying to create a view with unknown direction value: " + bVar.e + "(view id: " + bVar.f2557a + ")");
            } else if (j.this.i.containsKey(Integer.valueOf(bVar.f2557a))) {
                throw new IllegalStateException("Trying to create an already created platform view, view id: " + bVar.f2557a);
            } else {
                f a2 = j.this.f2649a.a(bVar.f2558b);
                if (a2 == null) {
                    throw new IllegalStateException("Trying to create a platform view of unregistered type: " + bVar.f2558b);
                }
                Object b2 = bVar.f != null ? a2.b().b(bVar.f) : null;
                int Y = j.this.Y(bVar.f2559c);
                int Y2 = j.this.Y(bVar.f2560d);
                j.this.b0(Y, Y2);
                e.a a3 = j.this.e.a();
                k a4 = k.a(j.this.f2651c, j.this.h, a2, a3, Y, Y2, bVar.f2557a, b2, new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.a
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z) {
                        j.a.this.j(bVar, view, z);
                    }
                });
                if (a4 == null) {
                    throw new IllegalStateException("Failed creating virtual display for a " + bVar.f2558b + " with id: " + bVar.f2557a);
                }
                if (j.this.f2652d != null) {
                    a4.e(j.this.f2652d);
                }
                j.this.i.put(Integer.valueOf(bVar.f2557a), a4);
                View d2 = a4.d();
                d2.setLayoutDirection(bVar.e);
                j.this.j.put(d2.getContext(), d2);
                return a3.c();
            }
        }

        @Override // io.flutter.embedding.engine.i.i.e
        public void e(int i) {
            i(20);
            j.this.i.get(Integer.valueOf(i)).d().clearFocus();
        }

        @Override // io.flutter.embedding.engine.i.i.e
        public void f(int i) {
            i(20);
            k kVar = j.this.i.get(Integer.valueOf(i));
            if (kVar == null) {
                throw new IllegalStateException("Trying to dispose a platform view with unknown id: " + i);
            }
            if (j.this.f != null) {
                j.this.f.j(i);
            }
            j.this.j.remove(kVar.d().getContext());
            kVar.c();
            j.this.i.remove(Integer.valueOf(i));
        }

        @Override // io.flutter.embedding.engine.i.i.e
        public void g(i.b bVar) {
            i(19);
            if (!j.a0(bVar.e)) {
                throw new IllegalStateException("Trying to create a view with unknown direction value: " + bVar.e + "(view id: " + bVar.f2557a + ")");
            }
            f a2 = j.this.f2649a.a(bVar.f2558b);
            if (a2 != null) {
                j.this.k.put(bVar.f2557a, a2.a(j.this.f2651c, bVar.f2557a, bVar.f != null ? a2.b().b(bVar.f) : null));
                return;
            }
            throw new IllegalStateException("Trying to create a platform view of unregistered type: " + bVar.f2558b);
        }

        @Override // io.flutter.embedding.engine.i.i.e
        public void h(i.d dVar) {
            int i = dVar.f2564a;
            float f = j.this.f2651c.getResources().getDisplayMetrics().density;
            i(20);
            if (j.this.i.containsKey(Integer.valueOf(i))) {
                j.this.i.get(Integer.valueOf(dVar.f2564a)).b(j.this.X(f, dVar, true));
            } else if (j.this.k.get(i) == null) {
                throw new IllegalStateException("Sending touch to an unknown view with id: " + i);
            } else {
                MotionEvent X = j.this.X(f, dVar, false);
                View c2 = ((e) j.this.k.get(dVar.f2564a)).c();
                if (c2 != null) {
                    c2.dispatchTouchEvent(X);
                }
            }
        }

        public /* synthetic */ void j(i.b bVar, View view, boolean z) {
            if (z) {
                j.this.g.d(bVar.f2557a);
            }
        }
    }

    private void E(boolean z) {
        for (int i = 0; i < this.m.size(); i++) {
            int keyAt = this.m.keyAt(i);
            io.flutter.embedding.android.g valueAt = this.m.valueAt(i);
            if (this.p.contains(Integer.valueOf(keyAt))) {
                ((io.flutter.embedding.android.j) this.f2652d).i(valueAt);
                z &= valueAt.d();
            } else {
                if (!this.o) {
                    valueAt.a();
                }
                valueAt.setVisibility(8);
            }
        }
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            int keyAt2 = this.l.keyAt(i2);
            io.flutter.embedding.engine.mutatorsstack.a aVar = this.l.get(keyAt2);
            if (z && this.q.contains(Integer.valueOf(keyAt2))) {
                aVar.setVisibility(0);
            } else {
                aVar.setVisibility(8);
            }
        }
    }

    private void F() {
        for (k kVar : this.i.values()) {
            kVar.c();
        }
        this.i.clear();
        while (this.k.size() > 0) {
            this.s.b(this.k.keyAt(0));
        }
    }

    private float G() {
        return this.f2651c.getResources().getDisplayMetrics().density;
    }

    private void J() {
        if (this.o) {
            return;
        }
        ((io.flutter.embedding.android.j) this.f2652d).l();
        this.o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(k kVar) {
        io.flutter.plugin.editing.d dVar = this.f;
        if (dVar == null) {
            return;
        }
        dVar.s();
        kVar.g();
    }

    private static MotionEvent.PointerCoords T(Object obj, float f) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        pointerCoords.toolMajor = ((float) ((Double) list.get(3)).doubleValue()) * f;
        pointerCoords.toolMinor = ((float) ((Double) list.get(4)).doubleValue()) * f;
        pointerCoords.touchMajor = ((float) ((Double) list.get(5)).doubleValue()) * f;
        pointerCoords.touchMinor = ((float) ((Double) list.get(6)).doubleValue()) * f;
        pointerCoords.x = ((float) ((Double) list.get(7)).doubleValue()) * f;
        pointerCoords.y = ((float) ((Double) list.get(8)).doubleValue()) * f;
        return pointerCoords;
    }

    private static List<MotionEvent.PointerCoords> U(Object obj, float f) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (List) obj) {
            arrayList.add(T(obj2, f));
        }
        return arrayList;
    }

    private static MotionEvent.PointerProperties V(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    private static List<MotionEvent.PointerProperties> W(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (List) obj) {
            arrayList.add(V(obj2));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Y(double d2) {
        return (int) Math.round(d2 * G());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(k kVar) {
        io.flutter.plugin.editing.d dVar = this.f;
        if (dVar == null) {
            return;
        }
        dVar.F();
        kVar.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a0(int i) {
        return i == 0 || i == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(int i, int i2) {
        DisplayMetrics displayMetrics = this.f2651c.getResources().getDisplayMetrics();
        if (i2 > displayMetrics.heightPixels || i > displayMetrics.widthPixels) {
            c.a.b.e("PlatformViewsController", "Creating a virtual display of size: [" + i + ", " + i2 + "] may result in problems(https://github.com/flutter/flutter/issues/2897).It is larger than the device screen size: [" + displayMetrics.widthPixels + ", " + displayMetrics.heightPixels + "].");
        }
    }

    public void A() {
        for (int i = 0; i < this.m.size(); i++) {
            this.m.keyAt(i);
            io.flutter.embedding.android.g valueAt = this.m.valueAt(i);
            valueAt.a();
            ((io.flutter.embedding.android.j) this.f2652d).removeView(valueAt);
        }
        this.m.clear();
    }

    public void B() {
        io.flutter.embedding.engine.i.i iVar = this.g;
        if (iVar != null) {
            iVar.e(null);
        }
        this.g = null;
        this.f2651c = null;
        this.e = null;
    }

    public void C() {
        this.f2652d = null;
        for (k kVar : this.i.values()) {
            kVar.f();
        }
    }

    public void D() {
        this.f = null;
    }

    public g H() {
        return this.f2649a;
    }

    void I(int i) {
        e eVar = this.k.get(i);
        if (eVar == null) {
            throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        }
        if (this.l.get(i) != null) {
            return;
        }
        if (eVar.c() == null) {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        if (eVar.c().getParent() != null) {
            throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        }
        Context context = this.f2651c;
        io.flutter.embedding.engine.mutatorsstack.a aVar = new io.flutter.embedding.engine.mutatorsstack.a(context, context.getResources().getDisplayMetrics().density, this.f2650b);
        this.l.put(i, aVar);
        aVar.addView(eVar.c());
        ((io.flutter.embedding.android.j) this.f2652d).addView(aVar);
    }

    public /* synthetic */ void K() {
        E(false);
    }

    public void M() {
    }

    public void N() {
        this.p.clear();
        this.q.clear();
    }

    public void O() {
        F();
    }

    public void P(int i, int i2, int i3, int i4, int i5) {
        J();
        io.flutter.embedding.android.g gVar = this.m.get(i);
        if (gVar.getParent() == null) {
            ((io.flutter.embedding.android.j) this.f2652d).addView(gVar);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5);
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        gVar.setLayoutParams(layoutParams);
        gVar.setVisibility(0);
        gVar.bringToFront();
        this.p.add(Integer.valueOf(i));
    }

    public void Q(int i, int i2, int i3, int i4, int i5, int i6, int i7, FlutterMutatorsStack flutterMutatorsStack) {
        J();
        I(i);
        io.flutter.embedding.engine.mutatorsstack.a aVar = this.l.get(i);
        aVar.a(flutterMutatorsStack, i2, i3, i4, i5);
        aVar.setVisibility(0);
        aVar.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, i7);
        View c2 = this.k.get(i).c();
        if (c2 != null) {
            c2.setLayoutParams(layoutParams);
            c2.bringToFront();
        }
        this.q.add(Integer.valueOf(i));
    }

    public void R() {
        io.flutter.embedding.android.j jVar = (io.flutter.embedding.android.j) this.f2652d;
        boolean z = false;
        if (this.o && this.q.isEmpty()) {
            this.o = false;
            jVar.v(new Runnable() { // from class: io.flutter.plugin.platform.b
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.K();
                }
            });
            return;
        }
        if (this.o && jVar.f()) {
            z = true;
        }
        E(z);
    }

    public void S() {
        F();
    }

    public MotionEvent X(float f, i.d dVar, boolean z) {
        MotionEvent b2 = this.r.b(k.a.c(dVar.p));
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) W(dVar.f).toArray(new MotionEvent.PointerProperties[dVar.e]);
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) U(dVar.g, f).toArray(new MotionEvent.PointerCoords[dVar.e]);
        return (z || b2 == null) ? MotionEvent.obtain(dVar.f2565b.longValue(), dVar.f2566c.longValue(), dVar.f2567d, dVar.e, pointerPropertiesArr, pointerCoordsArr, dVar.h, dVar.i, dVar.j, dVar.k, dVar.l, dVar.m, dVar.n, dVar.o) : MotionEvent.obtain(b2.getDownTime(), b2.getEventTime(), b2.getAction(), dVar.e, pointerPropertiesArr, pointerCoordsArr, b2.getMetaState(), b2.getButtonState(), b2.getXPrecision(), b2.getYPrecision(), b2.getDeviceId(), b2.getEdgeFlags(), b2.getSource(), b2.getFlags());
    }

    @Override // io.flutter.plugin.platform.i
    public void a(io.flutter.view.c cVar) {
        this.h.b(cVar);
    }

    @Override // io.flutter.plugin.platform.i
    public void b() {
        this.h.b(null);
    }

    @Override // io.flutter.plugin.platform.i
    public boolean c(Integer num) {
        return this.i.containsKey(num);
    }

    @Override // io.flutter.plugin.platform.i
    public View d(Integer num) {
        if (this.k.get(num.intValue()) != null) {
            return this.k.get(num.intValue()).c();
        }
        k kVar = this.i.get(num);
        if (kVar == null) {
            return null;
        }
        return kVar.d();
    }

    public void t(Context context, io.flutter.view.e eVar, io.flutter.embedding.engine.e.a aVar) {
        if (this.f2651c != null) {
            throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
        }
        this.f2651c = context;
        this.e = eVar;
        io.flutter.embedding.engine.i.i iVar = new io.flutter.embedding.engine.i.i(aVar);
        this.g = iVar;
        iVar.e(this.s);
    }

    public void u(io.flutter.plugin.editing.d dVar) {
        this.f = dVar;
    }

    public void v(io.flutter.embedding.engine.renderer.a aVar) {
        this.f2650b = new io.flutter.embedding.android.b(aVar, true);
    }

    public void w(View view) {
        this.f2652d = view;
        for (k kVar : this.i.values()) {
            kVar.e(view);
        }
    }

    public boolean x(View view) {
        if (view != null && this.j.containsKey(view.getContext())) {
            View view2 = this.j.get(view.getContext());
            if (view2 == view) {
                return true;
            }
            return view2.checkInputConnectionProxy(view);
        }
        return false;
    }

    public FlutterOverlaySurface y() {
        return z(new io.flutter.embedding.android.g(this.f2652d.getContext(), this.f2652d.getWidth(), this.f2652d.getHeight(), g.b.overlay));
    }

    public FlutterOverlaySurface z(io.flutter.embedding.android.g gVar) {
        int i = this.n;
        this.n = i + 1;
        this.m.put(i, gVar);
        return new FlutterOverlaySurface(i, gVar.getSurface());
    }
}
