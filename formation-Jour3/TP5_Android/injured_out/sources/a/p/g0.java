package a.p;

import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
class g0 extends f0 {
    private static boolean i = true;

    @Override // a.p.i0
    public void g(View view, int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, i2);
        } else if (i) {
            try {
                view.setTransitionVisibility(i2);
            } catch (NoSuchMethodError unused) {
                i = false;
            }
        }
    }
}
