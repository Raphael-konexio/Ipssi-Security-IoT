package b.c.a.a.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static h f1223a;

    private h(Context context) {
        context.getApplicationContext();
    }

    public static h a(Context context) {
        com.google.android.gms.common.internal.r.h(context);
        synchronized (h.class) {
            if (f1223a == null) {
                p.a(context);
                f1223a = new h(context);
            }
        }
        return f1223a;
    }

    private static q b(PackageInfo packageInfo, q... qVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        r rVar = new r(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < qVarArr.length; i++) {
            if (qVarArr[i].equals(rVar)) {
                return qVarArr[i];
            }
        }
        return null;
    }

    public static boolean c(PackageInfo packageInfo, boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? b(packageInfo, t.f1237a) : b(packageInfo, t.f1237a[0])) != null) {
                return true;
            }
        }
        return false;
    }
}
