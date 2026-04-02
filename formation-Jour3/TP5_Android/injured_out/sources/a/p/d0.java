package a.p;

import android.view.View;
/* loaded from: classes.dex */
class d0 extends i0 {
    private static boolean e = true;

    @Override // a.p.i0
    public void a(View view) {
    }

    @Override // a.p.i0
    public float c(View view) {
        if (e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // a.p.i0
    public void d(View view) {
    }

    @Override // a.p.i0
    public void f(View view, float f) {
        if (e) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
        view.setAlpha(f);
    }
}
