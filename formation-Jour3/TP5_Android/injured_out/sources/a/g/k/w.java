package a.g.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<View> f283a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f284b = null;

    /* renamed from: c  reason: collision with root package name */
    Runnable f285c = null;

    /* renamed from: d  reason: collision with root package name */
    int f286d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f287a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f288b;

        a(w wVar, x xVar, View view) {
            this.f287a = xVar;
            this.f288b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f287a.a(this.f288b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f287a.b(this.f288b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f287a.c(this.f288b);
        }
    }

    /* loaded from: classes.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z f289a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f290b;

        b(w wVar, z zVar, View view) {
            this.f289a = zVar;
            this.f290b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f289a.a(this.f290b);
        }
    }

    /* loaded from: classes.dex */
    static class c implements x {

        /* renamed from: a  reason: collision with root package name */
        w f291a;

        /* renamed from: b  reason: collision with root package name */
        boolean f292b;

        c(w wVar) {
            this.f291a = wVar;
        }

        @Override // a.g.k.x
        public void a(View view) {
            Object tag = view.getTag(2113929216);
            x xVar = tag instanceof x ? (x) tag : null;
            if (xVar != null) {
                xVar.a(view);
            }
        }

        @Override // a.g.k.x
        public void b(View view) {
            int i = this.f291a.f286d;
            if (i > -1) {
                view.setLayerType(i, null);
                this.f291a.f286d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f292b) {
                w wVar = this.f291a;
                Runnable runnable = wVar.f285c;
                if (runnable != null) {
                    wVar.f285c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                x xVar = tag instanceof x ? (x) tag : null;
                if (xVar != null) {
                    xVar.b(view);
                }
                this.f292b = true;
            }
        }

        @Override // a.g.k.x
        public void c(View view) {
            this.f292b = false;
            if (this.f291a.f286d > -1) {
                view.setLayerType(2, null);
            }
            w wVar = this.f291a;
            Runnable runnable = wVar.f284b;
            if (runnable != null) {
                wVar.f284b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            x xVar = tag instanceof x ? (x) tag : null;
            if (xVar != null) {
                xVar.c(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(View view) {
        this.f283a = new WeakReference<>(view);
    }

    private void g(View view, x xVar) {
        if (xVar != null) {
            view.animate().setListener(new a(this, xVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public w a(float f) {
        View view = this.f283a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public void b() {
        View view = this.f283a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = this.f283a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public w d(long j) {
        View view = this.f283a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public w e(Interpolator interpolator) {
        View view = this.f283a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public w f(x xVar) {
        View view = this.f283a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                view.setTag(2113929216, xVar);
                xVar = new c(this);
            }
            g(view, xVar);
        }
        return this;
    }

    public w h(long j) {
        View view = this.f283a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public w i(z zVar) {
        View view = this.f283a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(zVar != null ? new b(this, zVar, view) : null);
        }
        return this;
    }

    public void j() {
        View view = this.f283a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public w k(float f) {
        View view = this.f283a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }
}
