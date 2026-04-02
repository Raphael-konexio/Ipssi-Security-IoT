package a.g.d;

import a.g.h.f;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.d.c;
import androidx.core.content.d.f;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final j f140a;

    /* renamed from: b  reason: collision with root package name */
    private static final a.d.e<String, Typeface> f141b;

    /* loaded from: classes.dex */
    public static class a extends f.c {

        /* renamed from: a  reason: collision with root package name */
        private f.c f142a;

        public a(f.c cVar) {
            this.f142a = cVar;
        }

        @Override // a.g.h.f.c
        public void a(int i) {
            f.c cVar = this.f142a;
            if (cVar != null) {
                cVar.d(i);
            }
        }

        @Override // a.g.h.f.c
        public void b(Typeface typeface) {
            f.c cVar = this.f142a;
            if (cVar != null) {
                cVar.e(typeface);
            }
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        f140a = i >= 29 ? new i() : i >= 28 ? new h() : i >= 26 ? new g() : (i < 24 || !f.m()) ? Build.VERSION.SDK_INT >= 21 ? new e() : new j() : new f();
        f141b = new a.d.e<>(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        Typeface g;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (g = g(context, typeface, i)) == null) ? Typeface.create(typeface, i) : g;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        return f140a.c(context, cancellationSignal, bVarArr, i);
    }

    public static Typeface c(Context context, c.a aVar, Resources resources, int i, int i2, f.c cVar, Handler handler, boolean z) {
        Typeface b2;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            Typeface h = h(dVar.c());
            if (h != null) {
                if (cVar != null) {
                    cVar.b(h, handler);
                }
                return h;
            }
            b2 = a.g.h.f.a(context, dVar.b(), i2, !z ? cVar != null : dVar.a() != 0, z ? dVar.d() : -1, f.c.c(handler), new a(cVar));
        } else {
            b2 = f140a.b(context, (c.b) aVar, resources, i2);
            if (cVar != null) {
                if (b2 != null) {
                    cVar.b(b2, handler);
                } else {
                    cVar.a(-3, handler);
                }
            }
        }
        if (b2 != null) {
            f141b.d(e(resources, i, i2), b2);
        }
        return b2;
    }

    public static Typeface d(Context context, Resources resources, int i, String str, int i2) {
        Typeface e = f140a.e(context, resources, i, str, i2);
        if (e != null) {
            f141b.d(e(resources, i, i2), e);
        }
        return e;
    }

    private static String e(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface f(Resources resources, int i, int i2) {
        return f141b.c(e(resources, i, i2));
    }

    private static Typeface g(Context context, Typeface typeface, int i) {
        c.b i2 = f140a.i(typeface);
        if (i2 == null) {
            return null;
        }
        return f140a.b(context, i2, context.getResources(), i);
    }

    private static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
