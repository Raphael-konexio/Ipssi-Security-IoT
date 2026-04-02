package b.a.a.v;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import b.a.a.n;
import java.io.File;
/* loaded from: classes.dex */
public class m {
    public static n a(Context context) {
        return c(context, null);
    }

    private static n b(Context context, b.a.a.h hVar) {
        n nVar = new n(new e(new File(context.getCacheDir(), "volley")), hVar);
        nVar.d();
        return nVar;
    }

    public static n c(Context context, b bVar) {
        c cVar;
        c cVar2;
        String str;
        if (bVar != null) {
            cVar = new c(bVar);
        } else if (Build.VERSION.SDK_INT >= 9) {
            cVar2 = new c((b) new j());
            return b(context, cVar2);
        } else {
            try {
                String packageName = context.getPackageName();
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                str = packageName + "/" + packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                str = "volley/0";
            }
            cVar = new c(new f(AndroidHttpClient.newInstance(str)));
        }
        cVar2 = cVar;
        return b(context, cVar2);
    }
}
