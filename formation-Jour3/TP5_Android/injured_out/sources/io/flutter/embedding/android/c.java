package io.flutter.embedding.android;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
public final class c implements n {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f2438a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView.ScaleType f2439b;

    /* renamed from: c  reason: collision with root package name */
    private final long f2440c;

    /* renamed from: d  reason: collision with root package name */
    private b f2441d;

    /* loaded from: classes.dex */
    class a implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f2442a;

        a(c cVar, Runnable runnable) {
            this.f2442a = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2442a.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2442a.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes.dex */
    public static class b extends ImageView {
        public b(Context context) {
            this(context, null, 0);
        }

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        public void a(Drawable drawable, ImageView.ScaleType scaleType) {
            setScaleType(scaleType);
            setImageDrawable(drawable);
        }

        public void setSplashDrawable(Drawable drawable) {
            a(drawable, ImageView.ScaleType.FIT_XY);
        }
    }

    public c(Drawable drawable) {
        this(drawable, ImageView.ScaleType.FIT_XY, 500L);
    }

    public c(Drawable drawable, ImageView.ScaleType scaleType, long j) {
        this.f2438a = drawable;
        this.f2439b = scaleType;
        this.f2440c = j;
    }

    @Override // io.flutter.embedding.android.n
    public void a(Runnable runnable) {
        b bVar = this.f2441d;
        if (bVar == null) {
            runnable.run();
        } else {
            bVar.animate().alpha(0.0f).setDuration(this.f2440c).setListener(new a(this, runnable));
        }
    }

    @Override // io.flutter.embedding.android.n
    public /* synthetic */ boolean b() {
        return m.a(this);
    }

    @Override // io.flutter.embedding.android.n
    public View c(Context context, Bundle bundle) {
        b bVar = new b(context);
        this.f2441d = bVar;
        bVar.a(this.f2438a, this.f2439b);
        return this.f2441d;
    }

    @Override // io.flutter.embedding.android.n
    public /* synthetic */ Bundle d() {
        return m.b(this);
    }
}
