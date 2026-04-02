package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.o f1105a;

    /* renamed from: b  reason: collision with root package name */
    private int f1106b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f1107c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends j {
        a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.j
        public int d(View view) {
            return this.f1105a.T(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1105a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1105a.R(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int g(View view) {
            return this.f1105a.Q(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int h() {
            return this.f1105a.o0();
        }

        @Override // androidx.recyclerview.widget.j
        public int i() {
            return this.f1105a.o0() - this.f1105a.f0();
        }

        @Override // androidx.recyclerview.widget.j
        public int j() {
            return this.f1105a.f0();
        }

        @Override // androidx.recyclerview.widget.j
        public int k() {
            return this.f1105a.p0();
        }

        @Override // androidx.recyclerview.widget.j
        public int l() {
            return this.f1105a.X();
        }

        @Override // androidx.recyclerview.widget.j
        public int m() {
            return this.f1105a.e0();
        }

        @Override // androidx.recyclerview.widget.j
        public int n() {
            return (this.f1105a.o0() - this.f1105a.e0()) - this.f1105a.f0();
        }

        @Override // androidx.recyclerview.widget.j
        public int p(View view) {
            this.f1105a.n0(view, true, this.f1107c);
            return this.f1107c.right;
        }

        @Override // androidx.recyclerview.widget.j
        public int q(View view) {
            this.f1105a.n0(view, true, this.f1107c);
            return this.f1107c.left;
        }

        @Override // androidx.recyclerview.widget.j
        public void r(int i) {
            this.f1105a.C0(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends j {
        b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.j
        public int d(View view) {
            return this.f1105a.O(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1105a.R(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1105a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int g(View view) {
            return this.f1105a.U(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int h() {
            return this.f1105a.W();
        }

        @Override // androidx.recyclerview.widget.j
        public int i() {
            return this.f1105a.W() - this.f1105a.d0();
        }

        @Override // androidx.recyclerview.widget.j
        public int j() {
            return this.f1105a.d0();
        }

        @Override // androidx.recyclerview.widget.j
        public int k() {
            return this.f1105a.X();
        }

        @Override // androidx.recyclerview.widget.j
        public int l() {
            return this.f1105a.p0();
        }

        @Override // androidx.recyclerview.widget.j
        public int m() {
            return this.f1105a.g0();
        }

        @Override // androidx.recyclerview.widget.j
        public int n() {
            return (this.f1105a.W() - this.f1105a.g0()) - this.f1105a.d0();
        }

        @Override // androidx.recyclerview.widget.j
        public int p(View view) {
            this.f1105a.n0(view, true, this.f1107c);
            return this.f1107c.bottom;
        }

        @Override // androidx.recyclerview.widget.j
        public int q(View view) {
            this.f1105a.n0(view, true, this.f1107c);
            return this.f1107c.top;
        }

        @Override // androidx.recyclerview.widget.j
        public void r(int i) {
            this.f1105a.D0(i);
        }
    }

    private j(RecyclerView.o oVar) {
        this.f1106b = RecyclerView.UNDEFINED_DURATION;
        this.f1107c = new Rect();
        this.f1105a = oVar;
    }

    /* synthetic */ j(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static j a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static j b(RecyclerView.o oVar, int i) {
        if (i != 0) {
            if (i == 1) {
                return c(oVar);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return a(oVar);
    }

    public static j c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f1106b) {
            return 0;
        }
        return n() - this.f1106b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i);

    public void s() {
        this.f1106b = n();
    }
}
