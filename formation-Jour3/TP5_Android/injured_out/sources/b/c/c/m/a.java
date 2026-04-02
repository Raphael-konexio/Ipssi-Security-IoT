package b.c.c.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import b.c.c.j.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1427a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f1428b;

    public a(Context context, String str, c cVar) {
        this.f1427a = a(context);
        this.f1428b = context.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        new AtomicBoolean(b());
    }

    private static Context a(Context context) {
        return (Build.VERSION.SDK_INT < 24 || androidx.core.content.a.g(context)) ? context : androidx.core.content.a.a(context);
    }

    private boolean b() {
        ApplicationInfo applicationInfo;
        if (this.f1428b.contains("firebase_data_collection_default_enabled")) {
            return this.f1428b.getBoolean("firebase_data_collection_default_enabled", true);
        }
        try {
            PackageManager packageManager = this.f1427a.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.f1427a.getPackageName(), 128)) != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey("firebase_data_collection_default_enabled")) {
                return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return true;
    }
}
