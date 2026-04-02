package io.flutter.plugin.platform;

import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
@Keep
/* loaded from: classes.dex */
class SingleViewPresentation extends Presentation {
    private final io.flutter.plugin.platform.c accessibilityEventsDelegate;
    private FrameLayout container;
    private Object createParams;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private a rootView;
    private boolean startFocused;
    private e state;
    private final io.flutter.plugin.platform.f viewFactory;
    private int viewId;

    /* loaded from: classes.dex */
    private static class a extends FrameLayout {
        private final io.flutter.plugin.platform.c f;
        private final View g;

        public a(Context context, io.flutter.plugin.platform.c cVar, View view) {
            super(context);
            this.f = cVar;
            this.g = view;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f.a(this.g, view, accessibilityEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends ViewGroup {
        private final Rect f;
        private final Rect g;

        public b(Context context) {
            super(context);
            this.f = new Rect();
            this.g = new Rect();
        }

        private static int a(int i) {
            return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), RecyclerView.UNDEFINED_DURATION);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
                this.f.set(i, i2, i3, i4);
                Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.f, layoutParams.x, layoutParams.y, this.g);
                Rect rect = this.g;
                childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).measure(a(i), a(i2));
            }
            super.onMeasure(i, i2);
        }
    }

    /* loaded from: classes.dex */
    private static class c extends ContextWrapper {

        /* renamed from: a  reason: collision with root package name */
        private final InputMethodManager f2629a;

        c(Context context) {
            this(context, null);
        }

        private c(Context context, InputMethodManager inputMethodManager) {
            super(context);
            this.f2629a = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context createDisplayContext(Display display) {
            return new c(super.createDisplayContext(display), this.f2629a);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "input_method".equals(str) ? this.f2629a : super.getSystemService(str);
        }
    }

    /* loaded from: classes.dex */
    private static class d extends ContextWrapper {

        /* renamed from: a  reason: collision with root package name */
        private final f f2630a;

        /* renamed from: b  reason: collision with root package name */
        private WindowManager f2631b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f2632c;

        d(Context context, f fVar, Context context2) {
            super(context);
            this.f2630a = fVar;
            this.f2632c = context2;
        }

        private WindowManager a() {
            if (this.f2631b == null) {
                this.f2631b = this.f2630a.b();
            }
            return this.f2631b;
        }

        private boolean b() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i = 0; i < stackTrace.length && i < 11; i++) {
                if (stackTrace[i].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i].getMethodName().equals("<init>")) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "window".equals(str) ? b() ? this.f2632c.getSystemService(str) : a() : super.getSystemService(str);
        }
    }

    /* loaded from: classes.dex */
    static class e {

        /* renamed from: a  reason: collision with root package name */
        private io.flutter.plugin.platform.e f2633a;

        /* renamed from: b  reason: collision with root package name */
        private f f2634b;

        /* renamed from: c  reason: collision with root package name */
        private b f2635c;

        e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final WindowManager f2636a;

        /* renamed from: b  reason: collision with root package name */
        b f2637b;

        f(WindowManager windowManager, b bVar) {
            this.f2636a = windowManager;
            this.f2637b = bVar;
        }

        private void a(Object[] objArr) {
            b bVar = this.f2637b;
            if (bVar == null) {
                c.a.b.e("PlatformViewsController", "Embedded view called addView while detached from presentation");
            } else {
                bVar.addView((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
            }
        }

        private void c(Object[] objArr) {
            b bVar = this.f2637b;
            if (bVar == null) {
                c.a.b.e("PlatformViewsController", "Embedded view called removeView while detached from presentation");
            } else {
                bVar.removeView((View) objArr[0]);
            }
        }

        private void d(Object[] objArr) {
            if (this.f2637b == null) {
                c.a.b.e("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
                return;
            }
            View view = (View) objArr[0];
            view.clearAnimation();
            this.f2637b.removeView(view);
        }

        private void e(Object[] objArr) {
            b bVar = this.f2637b;
            if (bVar == null) {
                c.a.b.e("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
            } else {
                bVar.updateViewLayout((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
            }
        }

        public WindowManager b() {
            return (WindowManager) Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[]{WindowManager.class}, this);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            char c2;
            String name = method.getName();
            switch (name.hashCode()) {
                case -1148522778:
                    if (name.equals("addView")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 542766184:
                    if (name.equals("removeViewImmediate")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 931413976:
                    if (name.equals("updateViewLayout")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1098630473:
                    if (name.equals("removeView")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                a(objArr);
                return null;
            } else if (c2 == 1) {
                c(objArr);
                return null;
            } else if (c2 == 2) {
                d(objArr);
                return null;
            } else if (c2 == 3) {
                e(objArr);
                return null;
            } else {
                try {
                    return method.invoke(this.f2636a, objArr);
                } catch (InvocationTargetException e) {
                    throw e.getCause();
                }
            }
        }
    }

    public SingleViewPresentation(Context context, Display display, io.flutter.plugin.platform.c cVar, e eVar, View.OnFocusChangeListener onFocusChangeListener, boolean z) {
        super(new c(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = cVar;
        this.viewFactory = null;
        this.state = eVar;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z;
    }

    public SingleViewPresentation(Context context, Display display, io.flutter.plugin.platform.f fVar, io.flutter.plugin.platform.c cVar, int i, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        super(new c(context), display);
        this.startFocused = false;
        this.viewFactory = fVar;
        this.accessibilityEventsDelegate = cVar;
        this.viewId = i;
        this.createParams = obj;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        this.state = new e();
        getWindow().setFlags(8, 8);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setType(2030);
        }
    }

    public e detachState() {
        this.container.removeAllViews();
        this.rootView.removeAllViews();
        return this.state;
    }

    public io.flutter.plugin.platform.e getView() {
        if (this.state.f2633a == null) {
            return null;
        }
        return this.state.f2633a;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.state.f2635c == null) {
            this.state.f2635c = new b(getContext());
        }
        if (this.state.f2634b == null) {
            e eVar = this.state;
            eVar.f2634b = new f((WindowManager) getContext().getSystemService("window"), eVar.f2635c);
        }
        this.container = new FrameLayout(getContext());
        d dVar = new d(getContext(), this.state.f2634b, this.outerContext);
        if (this.state.f2633a == null) {
            this.state.f2633a = this.viewFactory.a(dVar, this.viewId, this.createParams);
        }
        View c2 = this.state.f2633a.c();
        this.container.addView(c2);
        a aVar = new a(getContext(), this.accessibilityEventsDelegate, c2);
        this.rootView = aVar;
        aVar.addView(this.container);
        this.rootView.addView(this.state.f2635c);
        c2.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            c2.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }
}
