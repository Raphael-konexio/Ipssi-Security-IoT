package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.crypto.tink.shaded.protobuf.Reader;
/* loaded from: classes.dex */
public abstract class n extends RecyclerView.r {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f1110a;

    /* renamed from: b  reason: collision with root package name */
    private Scroller f1111b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView.t f1112c = new a();

    /* loaded from: classes.dex */
    class a extends RecyclerView.t {

        /* renamed from: a  reason: collision with root package name */
        boolean f1113a = false;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            super.a(recyclerView, i);
            if (i == 0 && this.f1113a) {
                this.f1113a = false;
                n.this.l();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.f1113a = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends g {
        b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.g, androidx.recyclerview.widget.RecyclerView.z
        protected void o(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
            n nVar = n.this;
            RecyclerView recyclerView = nVar.f1110a;
            if (recyclerView == null) {
                return;
            }
            int[] c2 = nVar.c(recyclerView.getLayoutManager(), view);
            int i = c2[0];
            int i2 = c2[1];
            int w = w(Math.max(Math.abs(i), Math.abs(i2)));
            if (w > 0) {
                aVar.d(i, i2, w, this.j);
            }
        }

        @Override // androidx.recyclerview.widget.g
        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    private void g() {
        this.f1110a.removeOnScrollListener(this.f1112c);
        this.f1110a.setOnFlingListener(null);
    }

    private void j() {
        if (this.f1110a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f1110a.addOnScrollListener(this.f1112c);
        this.f1110a.setOnFlingListener(this);
    }

    private boolean k(RecyclerView.o oVar, int i, int i2) {
        RecyclerView.z e;
        int i3;
        if (!(oVar instanceof RecyclerView.z.b) || (e = e(oVar)) == null || (i3 = i(oVar, i, i2)) == -1) {
            return false;
        }
        e.p(i3);
        oVar.J1(e);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean a(int i, int i2) {
        RecyclerView.o layoutManager = this.f1110a.getLayoutManager();
        if (layoutManager == null || this.f1110a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f1110a.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && k(layoutManager, i, i2);
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f1110a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            g();
        }
        this.f1110a = recyclerView;
        if (recyclerView != null) {
            j();
            this.f1111b = new Scroller(this.f1110a.getContext(), new DecelerateInterpolator());
            l();
        }
    }

    public abstract int[] c(RecyclerView.o oVar, View view);

    public int[] d(int i, int i2) {
        this.f1111b.fling(0, 0, i, i2, RecyclerView.UNDEFINED_DURATION, Reader.READ_DONE, RecyclerView.UNDEFINED_DURATION, Reader.READ_DONE);
        return new int[]{this.f1111b.getFinalX(), this.f1111b.getFinalY()};
    }

    protected RecyclerView.z e(RecyclerView.o oVar) {
        return f(oVar);
    }

    @Deprecated
    protected g f(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.z.b) {
            return new b(this.f1110a.getContext());
        }
        return null;
    }

    public abstract View h(RecyclerView.o oVar);

    public abstract int i(RecyclerView.o oVar, int i, int i2);

    void l() {
        RecyclerView.o layoutManager;
        View h;
        RecyclerView recyclerView = this.f1110a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (h = h(layoutManager)) == null) {
            return;
        }
        int[] c2 = c(layoutManager, h);
        if (c2[0] == 0 && c2[1] == 0) {
            return;
        }
        this.f1110a.smoothScrollBy(c2[0], c2[1]);
    }
}
