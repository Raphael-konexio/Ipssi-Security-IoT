package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
class l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RecyclerView.a0 a0Var, j jVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.J() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (z) {
            return Math.min(jVar.n(), jVar.d(view2) - jVar.g(view));
        }
        return Math.abs(oVar.h0(view) - oVar.h0(view2)) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(RecyclerView.a0 a0Var, j jVar, View view, View view2, RecyclerView.o oVar, boolean z, boolean z2) {
        if (oVar.J() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (a0Var.b() - Math.max(oVar.h0(view), oVar.h0(view2))) - 1) : Math.max(0, Math.min(oVar.h0(view), oVar.h0(view2)));
        if (z) {
            return Math.round((max * (Math.abs(jVar.d(view2) - jVar.g(view)) / (Math.abs(oVar.h0(view) - oVar.h0(view2)) + 1))) + (jVar.m() - jVar.g(view)));
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(RecyclerView.a0 a0Var, j jVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.J() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (z) {
            return (int) (((jVar.d(view2) - jVar.g(view)) / (Math.abs(oVar.h0(view) - oVar.h0(view2)) + 1)) * a0Var.b());
        }
        return a0Var.b();
    }
}
