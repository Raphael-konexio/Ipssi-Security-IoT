package a.g.k;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private int f265a;

    /* renamed from: b  reason: collision with root package name */
    private int f266b;

    public o(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f265a | this.f266b;
    }

    public void b(View view, View view2, int i) {
        c(view, view2, i, 0);
    }

    public void c(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.f266b = i;
        } else {
            this.f265a = i;
        }
    }

    public void d(View view, int i) {
        if (i == 1) {
            this.f266b = 0;
        } else {
            this.f265a = 0;
        }
    }
}
