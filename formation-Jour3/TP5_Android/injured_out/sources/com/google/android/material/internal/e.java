package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<b> f1785a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private b f1786b = null;

    /* renamed from: c  reason: collision with root package name */
    ValueAnimator f1787c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Animator.AnimatorListener f1788d = new a();

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e eVar = e.this;
            if (eVar.f1787c == animator) {
                eVar.f1787c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final int[] f1790a;

        /* renamed from: b  reason: collision with root package name */
        final ValueAnimator f1791b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.f1790a = iArr;
            this.f1791b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f1787c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f1787c = null;
        }
    }

    private void e(b bVar) {
        ValueAnimator valueAnimator = bVar.f1791b;
        this.f1787c = valueAnimator;
        valueAnimator.start();
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f1788d);
        this.f1785a.add(bVar);
    }

    public void c() {
        ValueAnimator valueAnimator = this.f1787c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f1787c = null;
        }
    }

    public void d(int[] iArr) {
        b bVar;
        int size = this.f1785a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                bVar = null;
                break;
            }
            bVar = this.f1785a.get(i);
            if (StateSet.stateSetMatches(bVar.f1790a, iArr)) {
                break;
            }
            i++;
        }
        b bVar2 = this.f1786b;
        if (bVar == bVar2) {
            return;
        }
        if (bVar2 != null) {
            b();
        }
        this.f1786b = bVar;
        if (bVar != null) {
            e(bVar);
        }
    }
}
