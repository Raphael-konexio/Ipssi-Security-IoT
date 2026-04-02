package b.c.a.b.p;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import b.c.a.b.p.d;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1362a;

    static {
        int i = Build.VERSION.SDK_INT;
        f1362a = i >= 21 ? 2 : i >= 18 ? 1 : 0;
    }

    public abstract void a();

    public abstract void b();

    public abstract void c(Canvas canvas);

    public abstract Drawable d();

    public abstract int e();

    public abstract d.e f();

    public abstract boolean g();

    public abstract void h(Drawable drawable);

    public abstract void i(int i);

    public abstract void j(d.e eVar);
}
