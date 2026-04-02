package b.c.a.b.t;

import android.content.Context;
import android.graphics.Color;
import b.c.a.b.x.b;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1370a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1371b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1372c;

    /* renamed from: d  reason: collision with root package name */
    private final float f1373d;

    public a(Context context) {
        this.f1370a = b.b(context, b.c.a.b.b.elevationOverlayEnabled, false);
        this.f1371b = b.c.a.b.q.a.a(context, b.c.a.b.b.elevationOverlayColor, 0);
        this.f1372c = b.c.a.b.q.a.a(context, b.c.a.b.b.colorSurface, 0);
        this.f1373d = context.getResources().getDisplayMetrics().density;
    }

    private boolean e(int i) {
        return a.g.d.a.d(i, 255) == this.f1372c;
    }

    public float a(float f) {
        float f2 = this.f1373d;
        if (f2 <= 0.0f || f <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f / f2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i, float f) {
        float a2 = a(f);
        return a.g.d.a.d(b.c.a.b.q.a.f(a.g.d.a.d(i, 255), this.f1371b, a2), Color.alpha(i));
    }

    public int c(int i, float f) {
        return (this.f1370a && e(i)) ? b(i, f) : i;
    }

    public boolean d() {
        return this.f1370a;
    }
}
