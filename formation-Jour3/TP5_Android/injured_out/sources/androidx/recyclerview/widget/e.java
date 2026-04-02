package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements Runnable {
    static final ThreadLocal<e> j = new ThreadLocal<>();
    static Comparator<c> k = new a();
    long g;
    long h;
    ArrayList<RecyclerView> f = new ArrayList<>();
    private ArrayList<c> i = new ArrayList<>();

    /* loaded from: classes.dex */
    static class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            if ((cVar.f1098d == null) != (cVar2.f1098d == null)) {
                return cVar.f1098d == null ? 1 : -1;
            }
            boolean z = cVar.f1095a;
            if (z != cVar2.f1095a) {
                return z ? -1 : 1;
            }
            int i = cVar2.f1096b - cVar.f1096b;
            if (i != 0) {
                return i;
            }
            int i2 = cVar.f1097c - cVar2.f1097c;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements RecyclerView.o.c {

        /* renamed from: a  reason: collision with root package name */
        int f1091a;

        /* renamed from: b  reason: collision with root package name */
        int f1092b;

        /* renamed from: c  reason: collision with root package name */
        int[] f1093c;

        /* renamed from: d  reason: collision with root package name */
        int f1094d;

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.f1094d * 2;
            int[] iArr = this.f1093c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f1093c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.f1093c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f1093c;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.f1094d++;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f1093c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1094d = 0;
        }

        void c(RecyclerView recyclerView, boolean z) {
            this.f1094d = 0;
            int[] iArr = this.f1093c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || oVar == null || !oVar.u0()) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.p()) {
                    oVar.p(recyclerView.mAdapter.c(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                oVar.o(this.f1091a, this.f1092b, recyclerView.mState, this);
            }
            int i = this.f1094d;
            if (i > oVar.m) {
                oVar.m = i;
                oVar.n = z;
                recyclerView.mRecycler.K();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean d(int i) {
            if (this.f1093c != null) {
                int i2 = this.f1094d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f1093c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i, int i2) {
            this.f1091a = i;
            this.f1092b = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1095a;

        /* renamed from: b  reason: collision with root package name */
        public int f1096b;

        /* renamed from: c  reason: collision with root package name */
        public int f1097c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f1098d;
        public int e;

        c() {
        }

        public void a() {
            this.f1095a = false;
            this.f1096b = 0;
            this.f1097c = 0;
            this.f1098d = null;
            this.e = 0;
        }
    }

    private void b() {
        c cVar;
        int size = this.f.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.c(recyclerView, false);
                i += recyclerView.mPrefetchRegistry.f1094d;
            }
        }
        this.i.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(bVar.f1091a) + Math.abs(bVar.f1092b);
                for (int i5 = 0; i5 < bVar.f1094d * 2; i5 += 2) {
                    if (i3 >= this.i.size()) {
                        cVar = new c();
                        this.i.add(cVar);
                    } else {
                        cVar = this.i.get(i3);
                    }
                    int i6 = bVar.f1093c[i5 + 1];
                    cVar.f1095a = i6 <= abs;
                    cVar.f1096b = abs;
                    cVar.f1097c = i6;
                    cVar.f1098d = recyclerView2;
                    cVar.e = bVar.f1093c[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.i, k);
    }

    private void c(c cVar, long j2) {
        RecyclerView.d0 i = i(cVar.f1098d, cVar.e, cVar.f1095a ? Long.MAX_VALUE : j2);
        if (i == null || i.f985b == null || !i.s() || i.t()) {
            return;
        }
        h(i.f985b.get(), j2);
    }

    private void d(long j2) {
        for (int i = 0; i < this.i.size(); i++) {
            c cVar = this.i.get(i);
            if (cVar.f1098d == null) {
                return;
            }
            c(cVar, j2);
            cVar.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i) {
        int j2 = recyclerView.mChildHelper.j();
        for (int i2 = 0; i2 < j2; i2++) {
            RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i2));
            if (childViewHolderInt.f986c == i && !childViewHolderInt.t()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j2) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        b bVar = recyclerView.mPrefetchRegistry;
        bVar.c(recyclerView, true);
        if (bVar.f1094d != 0) {
            try {
                a.g.g.c.a("RV Nested Prefetch");
                recyclerView.mState.f(recyclerView.mAdapter);
                for (int i = 0; i < bVar.f1094d * 2; i += 2) {
                    i(recyclerView, bVar.f1093c[i], j2);
                }
            } finally {
                a.g.g.c.b();
            }
        }
    }

    private RecyclerView.d0 i(RecyclerView recyclerView, int i, long j2) {
        if (e(recyclerView, i)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.d0 I = vVar.I(i, false, j2);
            if (I != null) {
                if (!I.s() || I.t()) {
                    vVar.a(I, false);
                } else {
                    vVar.B(I.f984a);
                }
            }
            return I;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f.add(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.g == 0) {
            this.g = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.e(i, i2);
    }

    void g(long j2) {
        b();
        d(j2);
    }

    public void j(RecyclerView recyclerView) {
        this.f.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a.g.g.c.a("RV Prefetch");
            if (!this.f.isEmpty()) {
                int size = this.f.size();
                long j2 = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j2) + this.h);
                }
            }
        } finally {
            this.g = 0L;
            a.g.g.c.b();
        }
    }
}
