package a.p;

import android.graphics.Matrix;
import android.view.View;
/* loaded from: classes.dex */
class e0 extends d0 {
    private static boolean f = true;
    private static boolean g = true;

    @Override // a.p.i0
    public void h(View view, Matrix matrix) {
        if (f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f = false;
            }
        }
    }

    @Override // a.p.i0
    public void i(View view, Matrix matrix) {
        if (g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                g = false;
            }
        }
    }
}
