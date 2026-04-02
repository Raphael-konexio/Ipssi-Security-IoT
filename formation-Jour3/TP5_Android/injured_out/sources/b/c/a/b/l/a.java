package b.c.a.b.l;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f1340a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f1341b = new a.k.a.a.b();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f1342c = new a.k.a.a.a();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f1343d = new a.k.a.a.c();
    public static final TimeInterpolator e = new DecelerateInterpolator();

    public static float a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }
}
