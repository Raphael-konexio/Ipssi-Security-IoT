package b.c.a.a.b.m;

import android.content.Context;
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f1230b = new b();

    /* renamed from: a  reason: collision with root package name */
    private a f1231a = null;

    public static a a(Context context) {
        return f1230b.b(context);
    }

    private final synchronized a b(Context context) {
        if (this.f1231a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f1231a = new a(context);
        }
        return this.f1231a;
    }
}
