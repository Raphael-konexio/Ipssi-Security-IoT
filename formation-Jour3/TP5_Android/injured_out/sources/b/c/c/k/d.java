package b.c.c.k;

import android.content.Context;
/* loaded from: classes.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f1426a;

    private d(Context context) {
        context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f1426a == null) {
                f1426a = new d(context);
            }
            dVar = f1426a;
        }
        return dVar;
    }
}
