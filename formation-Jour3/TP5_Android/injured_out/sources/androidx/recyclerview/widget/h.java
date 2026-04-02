package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.crypto.tink.shaded.protobuf.Reader;
/* loaded from: classes.dex */
public class h extends n {

    /* renamed from: d  reason: collision with root package name */
    private j f1103d;
    private j e;

    private float m(RecyclerView.o oVar, j jVar) {
        int J = oVar.J();
        if (J == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i = Reader.READ_DONE;
        int i2 = RecyclerView.UNDEFINED_DURATION;
        for (int i3 = 0; i3 < J; i3++) {
            View I = oVar.I(i3);
            int h0 = oVar.h0(I);
            if (h0 != -1) {
                if (h0 < i) {
                    view = I;
                    i = h0;
                }
                if (h0 > i2) {
                    view2 = I;
                    i2 = h0;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int max = Math.max(jVar.d(view), jVar.d(view2)) - Math.min(jVar.g(view), jVar.g(view2));
        if (max == 0) {
            return 1.0f;
        }
        return (max * 1.0f) / ((i2 - i) + 1);
    }

    private int n(RecyclerView.o oVar, View view, j jVar) {
        return (jVar.g(view) + (jVar.e(view) / 2)) - (jVar.m() + (jVar.n() / 2));
    }

    private int o(RecyclerView.o oVar, j jVar, int i, int i2) {
        int[] d2 = d(i, i2);
        float m = m(oVar, jVar);
        if (m <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(d2[0]) > Math.abs(d2[1]) ? d2[0] : d2[1]) / m);
    }

    private View p(RecyclerView.o oVar, j jVar) {
        int J = oVar.J();
        View view = null;
        if (J == 0) {
            return null;
        }
        int m = jVar.m() + (jVar.n() / 2);
        int i = Reader.READ_DONE;
        for (int i2 = 0; i2 < J; i2++) {
            View I = oVar.I(i2);
            int abs = Math.abs((jVar.g(I) + (jVar.e(I) / 2)) - m);
            if (abs < i) {
                view = I;
                i = abs;
            }
        }
        return view;
    }

    private j q(RecyclerView.o oVar) {
        j jVar = this.e;
        if (jVar == null || jVar.f1105a != oVar) {
            this.e = j.a(oVar);
        }
        return this.e;
    }

    private j r(RecyclerView.o oVar) {
        j jVar = this.f1103d;
        if (jVar == null || jVar.f1105a != oVar) {
            this.f1103d = j.c(oVar);
        }
        return this.f1103d;
    }

    @Override // androidx.recyclerview.widget.n
    public int[] c(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.k()) {
            iArr[0] = n(oVar, view, q(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.l()) {
            iArr[1] = n(oVar, view, r(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.n
    public View h(RecyclerView.o oVar) {
        j q;
        if (oVar.l()) {
            q = r(oVar);
        } else if (!oVar.k()) {
            return null;
        } else {
            q = q(oVar);
        }
        return p(oVar, q);
    }

    @Override // androidx.recyclerview.widget.n
    public int i(RecyclerView.o oVar, int i, int i2) {
        int Y;
        View h;
        int h0;
        int i3;
        PointF a2;
        int i4;
        int i5;
        if (!(oVar instanceof RecyclerView.z.b) || (Y = oVar.Y()) == 0 || (h = h(oVar)) == null || (h0 = oVar.h0(h)) == -1 || (a2 = ((RecyclerView.z.b) oVar).a(Y - 1)) == null) {
            return -1;
        }
        if (oVar.k()) {
            i4 = o(oVar, q(oVar), i, 0);
            if (a2.x < 0.0f) {
                i4 = -i4;
            }
        } else {
            i4 = 0;
        }
        if (oVar.l()) {
            i5 = o(oVar, r(oVar), 0, i2);
            if (a2.y < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (oVar.l()) {
            i4 = i5;
        }
        if (i4 == 0) {
            return -1;
        }
        int i6 = h0 + i4;
        int i7 = i6 >= 0 ? i6 : 0;
        return i7 >= Y ? i3 : i7;
    }
}
