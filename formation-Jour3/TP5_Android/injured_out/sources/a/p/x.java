package a.p;

import android.os.Build;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class x {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f419a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static w a(ViewGroup viewGroup) {
        return Build.VERSION.SDK_INT >= 18 ? new v(viewGroup) : u.g(viewGroup);
    }

    private static void b(ViewGroup viewGroup, boolean z) {
        if (f419a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                f419a = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(ViewGroup viewGroup, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            viewGroup.suppressLayout(z);
        } else if (i >= 18) {
            b(viewGroup, z);
        } else {
            y.b(viewGroup, z);
        }
    }
}
