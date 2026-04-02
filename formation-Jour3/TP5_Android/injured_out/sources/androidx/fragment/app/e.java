package androidx.fragment.app;

import a.g.g.b;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.fragment.app.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f788a;

        a(Fragment fragment) {
            this.f788a = fragment;
        }

        @Override // a.g.g.b.a
        public void a() {
            if (this.f788a.n() != null) {
                View n = this.f788a.n();
                this.f788a.h1(null);
                n.clearAnimation();
            }
            this.f788a.i1(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f789a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f790b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ u.g f791c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a.g.g.b f792d;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f790b.n() != null) {
                    b.this.f790b.h1(null);
                    b bVar = b.this;
                    bVar.f791c.a(bVar.f790b, bVar.f792d);
                }
            }
        }

        b(ViewGroup viewGroup, Fragment fragment, u.g gVar, a.g.g.b bVar) {
            this.f789a = viewGroup;
            this.f790b = fragment;
            this.f791c = gVar;
            this.f792d = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f789a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f793a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f794b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f795c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ u.g f796d;
        final /* synthetic */ a.g.g.b e;

        c(ViewGroup viewGroup, View view, Fragment fragment, u.g gVar, a.g.g.b bVar) {
            this.f793a = viewGroup;
            this.f794b = view;
            this.f795c = fragment;
            this.f796d = gVar;
            this.e = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f793a.endViewTransition(this.f794b);
            Animator o = this.f795c.o();
            this.f795c.i1(null);
            if (o == null || this.f793a.indexOfChild(this.f794b) >= 0) {
                return;
            }
            this.f796d.a(this.f795c, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f797a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f798b;

        d(Animator animator) {
            this.f797a = null;
            this.f798b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        d(Animation animation) {
            this.f797a = animation;
            this.f798b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.fragment.app.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0044e extends AnimationSet implements Runnable {
        private final ViewGroup f;
        private final View g;
        private boolean h;
        private boolean i;
        private boolean j;

        RunnableC0044e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.j = true;
            this.f = viewGroup;
            this.g = view;
            addAnimation(animation);
            this.f.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.j = true;
            if (this.h) {
                return !this.i;
            }
            if (!super.getTransformation(j, transformation)) {
                this.h = true;
                a.g.k.q.a(this.f, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.j = true;
            if (this.h) {
                return !this.i;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.h = true;
                a.g.k.q.a(this.f, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.h || !this.j) {
                this.f.endViewTransition(this.g);
                this.i = true;
                return;
            }
            this.j = false;
            this.f.post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Fragment fragment, d dVar, u.g gVar) {
        View view = fragment.L;
        ViewGroup viewGroup = fragment.K;
        viewGroup.startViewTransition(view);
        a.g.g.b bVar = new a.g.g.b();
        bVar.c(new a(fragment));
        gVar.b(fragment, bVar);
        if (dVar.f797a != null) {
            RunnableC0044e runnableC0044e = new RunnableC0044e(dVar.f797a, viewGroup, view);
            fragment.h1(fragment.L);
            runnableC0044e.setAnimationListener(new b(viewGroup, fragment, gVar, bVar));
            fragment.L.startAnimation(runnableC0044e);
            return;
        }
        Animator animator = dVar.f798b;
        fragment.i1(animator);
        animator.addListener(new c(viewGroup, view, fragment, gVar, bVar));
        animator.setTarget(fragment.L);
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d b(Context context, f fVar, Fragment fragment, boolean z) {
        int c2;
        int A = fragment.A();
        int z2 = fragment.z();
        boolean z3 = false;
        fragment.l1(0);
        View c3 = fVar.c(fragment.B);
        if (c3 != null && c3.getTag(a.j.b.visible_removing_fragment_view_tag) != null) {
            c3.setTag(a.j.b.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup = fragment.K;
        if (viewGroup == null || viewGroup.getLayoutTransition() == null) {
            Animation f0 = fragment.f0(A, z, z2);
            if (f0 != null) {
                return new d(f0);
            }
            Animator g0 = fragment.g0(A, z, z2);
            if (g0 != null) {
                return new d(g0);
            }
            if (z2 != 0) {
                boolean equals = "anim".equals(context.getResources().getResourceTypeName(z2));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(context, z2);
                        if (loadAnimation != null) {
                            return new d(loadAnimation);
                        }
                        z3 = true;
                    } catch (Resources.NotFoundException e) {
                        throw e;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z3) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, z2);
                        if (loadAnimator != null) {
                            return new d(loadAnimator);
                        }
                    } catch (RuntimeException e2) {
                        if (equals) {
                            throw e2;
                        }
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, z2);
                        if (loadAnimation2 != null) {
                            return new d(loadAnimation2);
                        }
                    }
                }
            }
            if (A != 0 && (c2 = c(A, z)) >= 0) {
                return new d(AnimationUtils.loadAnimation(context, c2));
            }
            return null;
        }
        return null;
    }

    private static int c(int i, boolean z) {
        if (i == 4097) {
            return z ? a.j.a.fragment_open_enter : a.j.a.fragment_open_exit;
        } else if (i == 4099) {
            return z ? a.j.a.fragment_fade_enter : a.j.a.fragment_fade_exit;
        } else if (i != 8194) {
            return -1;
        } else {
            return z ? a.j.a.fragment_close_enter : a.j.a.fragment_close_exit;
        }
    }
}
