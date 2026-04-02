package b.c.a.a.b;

import android.content.Context;
import android.util.Log;
/* loaded from: classes.dex */
final class p {

    /* renamed from: a  reason: collision with root package name */
    private static Context f1232a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(Context context) {
        synchronized (p.class) {
            if (f1232a != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f1232a = context.getApplicationContext();
            }
        }
    }
}
