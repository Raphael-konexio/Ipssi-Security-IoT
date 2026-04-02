package b.c.a.b.l;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private long f1354a;

    /* renamed from: b  reason: collision with root package name */
    private long f1355b;

    /* renamed from: c  reason: collision with root package name */
    private TimeInterpolator f1356c;

    /* renamed from: d  reason: collision with root package name */
    private int f1357d;
    private int e;

    public i(long j, long j2) {
        this.f1354a = 0L;
        this.f1355b = 300L;
        this.f1356c = null;
        this.f1357d = 0;
        this.e = 1;
        this.f1354a = j;
        this.f1355b = j2;
    }

    public i(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f1354a = 0L;
        this.f1355b = 300L;
        this.f1356c = null;
        this.f1357d = 0;
        this.e = 1;
        this.f1354a = j;
        this.f1355b = j2;
        this.f1356c = timeInterpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i b(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f1357d = valueAnimator.getRepeatCount();
        iVar.e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.f1341b : interpolator instanceof AccelerateInterpolator ? a.f1342c : interpolator instanceof DecelerateInterpolator ? a.f1343d : interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f1354a;
    }

    public long d() {
        return this.f1355b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f1356c;
        return timeInterpolator != null ? timeInterpolator : a.f1341b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
                return e().getClass().equals(iVar.e().getClass());
            }
            return false;
        }
        return false;
    }

    public int g() {
        return this.f1357d;
    }

    public int h() {
        return this.e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + i.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }
}
