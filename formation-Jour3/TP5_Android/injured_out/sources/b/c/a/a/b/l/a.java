package b.c.a.a.b.l;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.c;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1227a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f1228b;

    private a() {
        List list = Collections.EMPTY_LIST;
    }

    public static a a() {
        if (f1228b == null) {
            synchronized (f1227a) {
                if (f1228b == null) {
                    f1228b = new a();
                }
            }
        }
        return f1228b;
    }

    public void b(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    public final boolean c(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        if (component == null ? false : c.a(context, component.getPackageName())) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        return context.bindService(intent, serviceConnection, i);
    }
}
