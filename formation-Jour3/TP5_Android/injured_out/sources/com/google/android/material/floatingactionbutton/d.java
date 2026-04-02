package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import b.c.a.b.l.h;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public interface d {
    void a();

    void b();

    void c(h hVar);

    void d();

    h e();

    AnimatorSet f();

    List<Animator.AnimatorListener> g();

    void h(ExtendedFloatingActionButton.d dVar);

    boolean i();

    void onAnimationStart(Animator animator);
}
