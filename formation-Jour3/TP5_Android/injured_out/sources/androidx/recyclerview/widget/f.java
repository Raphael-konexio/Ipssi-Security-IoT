package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
class f {

    /* renamed from: b  reason: collision with root package name */
    int f1100b;

    /* renamed from: c  reason: collision with root package name */
    int f1101c;

    /* renamed from: d  reason: collision with root package name */
    int f1102d;
    int e;
    boolean h;
    boolean i;

    /* renamed from: a  reason: collision with root package name */
    boolean f1099a = true;
    int f = 0;
    int g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.a0 a0Var) {
        int i = this.f1101c;
        return i >= 0 && i < a0Var.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(RecyclerView.v vVar) {
        View o = vVar.o(this.f1101c);
        this.f1101c += this.f1102d;
        return o;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f1100b + ", mCurrentPosition=" + this.f1101c + ", mItemDirection=" + this.f1102d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
