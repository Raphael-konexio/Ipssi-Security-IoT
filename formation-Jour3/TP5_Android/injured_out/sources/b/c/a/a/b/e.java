package b.c.a.a.b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.h0;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1218a = g.f1220a;

    /* renamed from: b  reason: collision with root package name */
    private static final e f1219b = new e();

    public static e e() {
        return f1219b;
    }

    private static String i(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f1218a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(b.c.a.a.b.m.b.a(context).c(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }

    public Intent a(Context context, int i, String str) {
        if (i == 1 || i == 2) {
            return (context == null || !com.google.android.gms.common.util.g.c(context)) ? h0.a("com.google.android.gms", i(context, str)) : h0.c();
        } else if (i != 3) {
            return null;
        } else {
            return h0.b("com.google.android.gms");
        }
    }

    public PendingIntent b(Context context, int i, int i2) {
        return c(context, i, i2, null);
    }

    public PendingIntent c(Context context, int i, int i2, String str) {
        Intent a2 = a(context, i, str);
        if (a2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, a2, 134217728);
    }

    public String d(int i) {
        return g.a(i);
    }

    public int f(Context context) {
        return g(context, f1218a);
    }

    public int g(Context context, int i) {
        int c2 = g.c(context, i);
        if (g.d(context, c2)) {
            return 18;
        }
        return c2;
    }

    public boolean h(int i) {
        return g.g(i);
    }
}
