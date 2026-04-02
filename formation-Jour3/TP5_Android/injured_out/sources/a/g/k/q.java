package a.g.k;

import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes.dex */
public final class q implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    private final View f;
    private ViewTreeObserver g;
    private final Runnable h;

    private q(View view, Runnable runnable) {
        this.f = view;
        this.g = view.getViewTreeObserver();
        this.h = runnable;
    }

    public static q a(View view, Runnable runnable) {
        if (view != null) {
            if (runnable != null) {
                q qVar = new q(view, runnable);
                view.getViewTreeObserver().addOnPreDrawListener(qVar);
                view.addOnAttachStateChangeListener(qVar);
                return qVar;
            }
            throw new NullPointerException("runnable == null");
        }
        throw new NullPointerException("view == null");
    }

    public void b() {
        (this.g.isAlive() ? this.g : this.f.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.h.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.g = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
