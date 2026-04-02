package androidx.recyclerview.widget;

import a.g.k.b0.c;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    private BitSet B;
    private boolean G;
    private boolean H;
    private e I;
    private int J;
    private int[] O;
    f[] t;
    j u;
    j v;
    private int w;
    private int x;
    private final androidx.recyclerview.widget.f y;
    private int s = -1;
    boolean z = false;
    boolean A = false;
    int C = -1;
    int D = RecyclerView.UNDEFINED_DURATION;
    d E = new d();
    private int F = 2;
    private final Rect K = new Rect();
    private final b L = new b();
    private boolean M = false;
    private boolean N = true;
    private final Runnable P = new a();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.S1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        int f1032a;

        /* renamed from: b  reason: collision with root package name */
        int f1033b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1034c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1035d;
        boolean e;
        int[] f;

        b() {
            c();
        }

        void a() {
            this.f1033b = this.f1034c ? StaggeredGridLayoutManager.this.u.i() : StaggeredGridLayoutManager.this.u.m();
        }

        void b(int i) {
            this.f1033b = this.f1034c ? StaggeredGridLayoutManager.this.u.i() - i : StaggeredGridLayoutManager.this.u.m() + i;
        }

        void c() {
            this.f1032a = -1;
            this.f1033b = RecyclerView.UNDEFINED_DURATION;
            this.f1034c = false;
            this.f1035d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f;
            if (iArr == null || iArr.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.t.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = fVarArr[i].p(RecyclerView.UNDEFINED_DURATION);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends RecyclerView.p {
        f e;
        boolean f;

        public c(int i, int i2) {
            super(i, i2);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public final int e() {
            f fVar = this.e;
            if (fVar == null) {
                return -1;
            }
            return fVar.e;
        }

        public boolean f() {
            return this.f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        int[] f1036a;

        /* renamed from: b  reason: collision with root package name */
        List<a> f1037b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0049a();
            int f;
            int g;
            int[] h;
            boolean i;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            static class C0049a implements Parcelable.Creator<a> {
                C0049a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b */
                public a[] newArray(int i) {
                    return new a[i];
                }
            }

            a() {
            }

            a(Parcel parcel) {
                this.f = parcel.readInt();
                this.g = parcel.readInt();
                this.i = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.h = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int a(int i) {
                int[] iArr = this.h;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f + ", mGapDir=" + this.g + ", mHasUnwantedGapAfter=" + this.i + ", mGapPerSpan=" + Arrays.toString(this.h) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f);
                parcel.writeInt(this.g);
                parcel.writeInt(this.i ? 1 : 0);
                int[] iArr = this.h;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.h);
            }
        }

        d() {
        }

        private int i(int i) {
            if (this.f1037b == null) {
                return -1;
            }
            a f = f(i);
            if (f != null) {
                this.f1037b.remove(f);
            }
            int size = this.f1037b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f1037b.get(i2).f >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                this.f1037b.remove(i2);
                return this.f1037b.get(i2).f;
            }
            return -1;
        }

        private void l(int i, int i2) {
            List<a> list = this.f1037b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1037b.get(size);
                int i3 = aVar.f;
                if (i3 >= i) {
                    aVar.f = i3 + i2;
                }
            }
        }

        private void m(int i, int i2) {
            List<a> list = this.f1037b;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1037b.get(size);
                int i4 = aVar.f;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.f1037b.remove(size);
                    } else {
                        aVar.f = i4 - i2;
                    }
                }
            }
        }

        public void a(a aVar) {
            if (this.f1037b == null) {
                this.f1037b = new ArrayList();
            }
            int size = this.f1037b.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.f1037b.get(i);
                if (aVar2.f == aVar.f) {
                    this.f1037b.remove(i);
                }
                if (aVar2.f >= aVar.f) {
                    this.f1037b.add(i, aVar);
                    return;
                }
            }
            this.f1037b.add(aVar);
        }

        void b() {
            int[] iArr = this.f1036a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1037b = null;
        }

        void c(int i) {
            int[] iArr = this.f1036a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.f1036a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[o(i)];
                this.f1036a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f1036a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i) {
            List<a> list = this.f1037b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f1037b.get(size).f >= i) {
                        this.f1037b.remove(size);
                    }
                }
            }
            return h(i);
        }

        public a e(int i, int i2, int i3, boolean z) {
            List<a> list = this.f1037b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.f1037b.get(i4);
                int i5 = aVar.f;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || aVar.g == i3 || (z && aVar.i))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i) {
            List<a> list = this.f1037b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1037b.get(size);
                if (aVar.f == i) {
                    return aVar;
                }
            }
            return null;
        }

        int g(int i) {
            int[] iArr = this.f1036a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        int h(int i) {
            int[] iArr = this.f1036a;
            if (iArr != null && i < iArr.length) {
                int i2 = i(i);
                if (i2 == -1) {
                    int[] iArr2 = this.f1036a;
                    Arrays.fill(iArr2, i, iArr2.length, -1);
                    return this.f1036a.length;
                }
                int i3 = i2 + 1;
                Arrays.fill(this.f1036a, i, i3, -1);
                return i3;
            }
            return -1;
        }

        void j(int i, int i2) {
            int[] iArr = this.f1036a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            c(i3);
            int[] iArr2 = this.f1036a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.f1036a, i, i3, -1);
            l(i, i2);
        }

        void k(int i, int i2) {
            int[] iArr = this.f1036a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            c(i3);
            int[] iArr2 = this.f1036a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.f1036a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            m(i, i2);
        }

        void n(int i, f fVar) {
            c(i);
            this.f1036a[i] = fVar.e;
        }

        int o(int i) {
            int length = this.f1036a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();
        int f;
        int g;
        int h;
        int[] i;
        int j;
        int[] k;
        List<d.a> l;
        boolean m;
        boolean n;
        boolean o;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public e[] newArray(int i) {
                return new e[i];
            }
        }

        public e() {
        }

        e(Parcel parcel) {
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            int readInt = parcel.readInt();
            this.h = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.i = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.j = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.k = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.m = parcel.readInt() == 1;
            this.n = parcel.readInt() == 1;
            this.o = parcel.readInt() == 1;
            this.l = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.h = eVar.h;
            this.f = eVar.f;
            this.g = eVar.g;
            this.i = eVar.i;
            this.j = eVar.j;
            this.k = eVar.k;
            this.m = eVar.m;
            this.n = eVar.n;
            this.o = eVar.o;
            this.l = eVar.l;
        }

        void a() {
            this.i = null;
            this.h = 0;
            this.f = -1;
            this.g = -1;
        }

        void b() {
            this.i = null;
            this.h = 0;
            this.j = 0;
            this.k = null;
            this.l = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
            if (this.h > 0) {
                parcel.writeIntArray(this.i);
            }
            parcel.writeInt(this.j);
            if (this.j > 0) {
                parcel.writeIntArray(this.k);
            }
            parcel.writeInt(this.m ? 1 : 0);
            parcel.writeInt(this.n ? 1 : 0);
            parcel.writeInt(this.o ? 1 : 0);
            parcel.writeList(this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f1038a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f1039b = RecyclerView.UNDEFINED_DURATION;

        /* renamed from: c  reason: collision with root package name */
        int f1040c = RecyclerView.UNDEFINED_DURATION;

        /* renamed from: d  reason: collision with root package name */
        int f1041d = 0;
        final int e;

        f(int i) {
            this.e = i;
        }

        void a(View view) {
            c n = n(view);
            n.e = this;
            this.f1038a.add(view);
            this.f1040c = RecyclerView.UNDEFINED_DURATION;
            if (this.f1038a.size() == 1) {
                this.f1039b = RecyclerView.UNDEFINED_DURATION;
            }
            if (n.c() || n.b()) {
                this.f1041d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }

        void b(boolean z, int i) {
            int l = z ? l(RecyclerView.UNDEFINED_DURATION) : p(RecyclerView.UNDEFINED_DURATION);
            e();
            if (l == Integer.MIN_VALUE) {
                return;
            }
            if (!z || l >= StaggeredGridLayoutManager.this.u.i()) {
                if (z || l <= StaggeredGridLayoutManager.this.u.m()) {
                    if (i != Integer.MIN_VALUE) {
                        l += i;
                    }
                    this.f1040c = l;
                    this.f1039b = l;
                }
            }
        }

        void c() {
            d.a f;
            ArrayList<View> arrayList = this.f1038a;
            View view = arrayList.get(arrayList.size() - 1);
            c n = n(view);
            this.f1040c = StaggeredGridLayoutManager.this.u.d(view);
            if (n.f && (f = StaggeredGridLayoutManager.this.E.f(n.a())) != null && f.g == 1) {
                this.f1040c += f.a(this.e);
            }
        }

        void d() {
            d.a f;
            View view = this.f1038a.get(0);
            c n = n(view);
            this.f1039b = StaggeredGridLayoutManager.this.u.g(view);
            if (n.f && (f = StaggeredGridLayoutManager.this.E.f(n.a())) != null && f.g == -1) {
                this.f1039b -= f.a(this.e);
            }
        }

        void e() {
            this.f1038a.clear();
            q();
            this.f1041d = 0;
        }

        public int f() {
            int i;
            int size;
            if (StaggeredGridLayoutManager.this.z) {
                i = this.f1038a.size() - 1;
                size = -1;
            } else {
                i = 0;
                size = this.f1038a.size();
            }
            return i(i, size, true);
        }

        public int g() {
            int size;
            int i;
            if (StaggeredGridLayoutManager.this.z) {
                size = 0;
                i = this.f1038a.size();
            } else {
                size = this.f1038a.size() - 1;
                i = -1;
            }
            return i(size, i, true);
        }

        int h(int i, int i2, boolean z, boolean z2, boolean z3) {
            int m = StaggeredGridLayoutManager.this.u.m();
            int i3 = StaggeredGridLayoutManager.this.u.i();
            int i4 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f1038a.get(i);
                int g = StaggeredGridLayoutManager.this.u.g(view);
                int d2 = StaggeredGridLayoutManager.this.u.d(view);
                boolean z4 = false;
                boolean z5 = !z3 ? g >= i3 : g > i3;
                if (!z3 ? d2 > m : d2 >= m) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (!z2 && g >= m && d2 <= i3) {
                        }
                        return StaggeredGridLayoutManager.this.h0(view);
                    } else if (g >= m && d2 <= i3) {
                        return StaggeredGridLayoutManager.this.h0(view);
                    }
                }
                i += i4;
            }
            return -1;
        }

        int i(int i, int i2, boolean z) {
            return h(i, i2, false, false, z);
        }

        public int j() {
            return this.f1041d;
        }

        int k() {
            int i = this.f1040c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            c();
            return this.f1040c;
        }

        int l(int i) {
            int i2 = this.f1040c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f1038a.size() == 0) {
                return i;
            }
            c();
            return this.f1040c;
        }

        public View m(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f1038a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f1038a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.h0(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.h0(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f1038a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f1038a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.h0(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.h0(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        c n(View view) {
            return (c) view.getLayoutParams();
        }

        int o() {
            int i = this.f1039b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            d();
            return this.f1039b;
        }

        int p(int i) {
            int i2 = this.f1039b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f1038a.size() == 0) {
                return i;
            }
            d();
            return this.f1039b;
        }

        void q() {
            this.f1039b = RecyclerView.UNDEFINED_DURATION;
            this.f1040c = RecyclerView.UNDEFINED_DURATION;
        }

        void r(int i) {
            int i2 = this.f1039b;
            if (i2 != Integer.MIN_VALUE) {
                this.f1039b = i2 + i;
            }
            int i3 = this.f1040c;
            if (i3 != Integer.MIN_VALUE) {
                this.f1040c = i3 + i;
            }
        }

        void s() {
            int size = this.f1038a.size();
            View remove = this.f1038a.remove(size - 1);
            c n = n(remove);
            n.e = null;
            if (n.c() || n.b()) {
                this.f1041d -= StaggeredGridLayoutManager.this.u.e(remove);
            }
            if (size == 1) {
                this.f1039b = RecyclerView.UNDEFINED_DURATION;
            }
            this.f1040c = RecyclerView.UNDEFINED_DURATION;
        }

        void t() {
            View remove = this.f1038a.remove(0);
            c n = n(remove);
            n.e = null;
            if (this.f1038a.size() == 0) {
                this.f1040c = RecyclerView.UNDEFINED_DURATION;
            }
            if (n.c() || n.b()) {
                this.f1041d -= StaggeredGridLayoutManager.this.u.e(remove);
            }
            this.f1039b = RecyclerView.UNDEFINED_DURATION;
        }

        void u(View view) {
            c n = n(view);
            n.e = this;
            this.f1038a.add(0, view);
            this.f1039b = RecyclerView.UNDEFINED_DURATION;
            if (this.f1038a.size() == 1) {
                this.f1040c = RecyclerView.UNDEFINED_DURATION;
            }
            if (n.c() || n.b()) {
                this.f1041d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }

        void v(int i) {
            this.f1039b = i;
            this.f1040c = i;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.o.d i0 = RecyclerView.o.i0(context, attributeSet, i, i2);
        H2(i0.f1005a);
        J2(i0.f1006b);
        I2(i0.f1007c);
        this.y = new androidx.recyclerview.widget.f();
        a2();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0010, code lost:
        if (r4.e == (-1)) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A2(androidx.recyclerview.widget.RecyclerView.v r3, androidx.recyclerview.widget.f r4) {
        /*
            r2 = this;
            boolean r0 = r4.f1099a
            if (r0 == 0) goto L4d
            boolean r0 = r4.i
            if (r0 == 0) goto L9
            goto L4d
        L9:
            int r0 = r4.f1100b
            r1 = -1
            if (r0 != 0) goto L1e
            int r0 = r4.e
            if (r0 != r1) goto L18
        L12:
            int r4 = r4.g
        L14:
            r2.B2(r3, r4)
            goto L4d
        L18:
            int r4 = r4.f
        L1a:
            r2.C2(r3, r4)
            goto L4d
        L1e:
            int r0 = r4.e
            if (r0 != r1) goto L37
            int r0 = r4.f
            int r1 = r2.m2(r0)
            int r0 = r0 - r1
            if (r0 >= 0) goto L2c
            goto L12
        L2c:
            int r1 = r4.g
            int r4 = r4.f1100b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r1 - r4
            goto L14
        L37:
            int r0 = r4.g
            int r0 = r2.n2(r0)
            int r1 = r4.g
            int r0 = r0 - r1
            if (r0 >= 0) goto L43
            goto L18
        L43:
            int r1 = r4.f
            int r4 = r4.f1100b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r4 + r1
            goto L1a
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.A2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.f):void");
    }

    private void B2(RecyclerView.v vVar, int i) {
        for (int J = J() - 1; J >= 0; J--) {
            View I = I(J);
            if (this.u.g(I) < i || this.u.q(I) < i) {
                return;
            }
            c cVar = (c) I.getLayoutParams();
            if (cVar.f) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].f1038a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].s();
                }
            } else if (cVar.e.f1038a.size() == 1) {
                return;
            } else {
                cVar.e.s();
            }
            m1(I, vVar);
        }
    }

    private void C2(RecyclerView.v vVar, int i) {
        while (J() > 0) {
            View I = I(0);
            if (this.u.d(I) > i || this.u.p(I) > i) {
                return;
            }
            c cVar = (c) I.getLayoutParams();
            if (cVar.f) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    if (this.t[i2].f1038a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].t();
                }
            } else if (cVar.e.f1038a.size() == 1) {
                return;
            } else {
                cVar.e.t();
            }
            m1(I, vVar);
        }
    }

    private void D2() {
        if (this.v.k() == 1073741824) {
            return;
        }
        float f2 = 0.0f;
        int J = J();
        for (int i = 0; i < J; i++) {
            View I = I(i);
            float e2 = this.v.e(I);
            if (e2 >= f2) {
                if (((c) I.getLayoutParams()).f()) {
                    e2 = (e2 * 1.0f) / this.s;
                }
                f2 = Math.max(f2, e2);
            }
        }
        int i2 = this.x;
        int round = Math.round(f2 * this.s);
        if (this.v.k() == Integer.MIN_VALUE) {
            round = Math.min(round, this.v.n());
        }
        P2(round);
        if (this.x == i2) {
            return;
        }
        for (int i3 = 0; i3 < J; i3++) {
            View I2 = I(i3);
            c cVar = (c) I2.getLayoutParams();
            if (!cVar.f) {
                if (t2() && this.w == 1) {
                    int i4 = this.s;
                    int i5 = cVar.e.e;
                    I2.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.x) - ((-((i4 - 1) - i5)) * i2));
                } else {
                    int i6 = cVar.e.e;
                    int i7 = this.w;
                    int i8 = (this.x * i6) - (i6 * i2);
                    if (i7 == 1) {
                        I2.offsetLeftAndRight(i8);
                    } else {
                        I2.offsetTopAndBottom(i8);
                    }
                }
            }
        }
    }

    private void E2() {
        this.A = (this.w == 1 || !t2()) ? this.z : !this.z;
    }

    private void G2(int i) {
        androidx.recyclerview.widget.f fVar = this.y;
        fVar.e = i;
        fVar.f1102d = this.A != (i == -1) ? -1 : 1;
    }

    private void K2(int i, int i2) {
        for (int i3 = 0; i3 < this.s; i3++) {
            if (!this.t[i3].f1038a.isEmpty()) {
                Q2(this.t[i3], i, i2);
            }
        }
    }

    private boolean L2(RecyclerView.a0 a0Var, b bVar) {
        boolean z = this.G;
        int b2 = a0Var.b();
        bVar.f1032a = z ? g2(b2) : c2(b2);
        bVar.f1033b = RecyclerView.UNDEFINED_DURATION;
        return true;
    }

    private void M1(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].a(view);
        }
    }

    private void N1(b bVar) {
        boolean z;
        e eVar = this.I;
        int i = eVar.h;
        if (i > 0) {
            if (i == this.s) {
                for (int i2 = 0; i2 < this.s; i2++) {
                    this.t[i2].e();
                    e eVar2 = this.I;
                    int i3 = eVar2.i[i2];
                    if (i3 != Integer.MIN_VALUE) {
                        i3 += eVar2.n ? this.u.i() : this.u.m();
                    }
                    this.t[i2].v(i3);
                }
            } else {
                eVar.b();
                e eVar3 = this.I;
                eVar3.f = eVar3.g;
            }
        }
        e eVar4 = this.I;
        this.H = eVar4.o;
        I2(eVar4.m);
        E2();
        e eVar5 = this.I;
        int i4 = eVar5.f;
        if (i4 != -1) {
            this.C = i4;
            z = eVar5.n;
        } else {
            z = this.A;
        }
        bVar.f1034c = z;
        e eVar6 = this.I;
        if (eVar6.j > 1) {
            d dVar = this.E;
            dVar.f1036a = eVar6.k;
            dVar.f1037b = eVar6.l;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void O2(int r5, androidx.recyclerview.widget.RecyclerView.a0 r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.f r0 = r4.y
            r1 = 0
            r0.f1100b = r1
            r0.f1101c = r5
            boolean r0 = r4.x0()
            r2 = 1
            if (r0 == 0) goto L2e
            int r6 = r6.c()
            r0 = -1
            if (r6 == r0) goto L2e
            boolean r0 = r4.A
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L25
            androidx.recyclerview.widget.j r5 = r4.u
            int r5 = r5.n()
            goto L2f
        L25:
            androidx.recyclerview.widget.j r5 = r4.u
            int r5 = r5.n()
            r6 = r5
            r5 = 0
            goto L30
        L2e:
            r5 = 0
        L2f:
            r6 = 0
        L30:
            boolean r0 = r4.M()
            if (r0 == 0) goto L4d
            androidx.recyclerview.widget.f r0 = r4.y
            androidx.recyclerview.widget.j r3 = r4.u
            int r3 = r3.m()
            int r3 = r3 - r6
            r0.f = r3
            androidx.recyclerview.widget.f r6 = r4.y
            androidx.recyclerview.widget.j r0 = r4.u
            int r0 = r0.i()
            int r0 = r0 + r5
            r6.g = r0
            goto L5d
        L4d:
            androidx.recyclerview.widget.f r0 = r4.y
            androidx.recyclerview.widget.j r3 = r4.u
            int r3 = r3.h()
            int r3 = r3 + r5
            r0.g = r3
            androidx.recyclerview.widget.f r5 = r4.y
            int r6 = -r6
            r5.f = r6
        L5d:
            androidx.recyclerview.widget.f r5 = r4.y
            r5.h = r1
            r5.f1099a = r2
            androidx.recyclerview.widget.j r6 = r4.u
            int r6 = r6.k()
            if (r6 != 0) goto L74
            androidx.recyclerview.widget.j r6 = r4.u
            int r6 = r6.h()
            if (r6 != 0) goto L74
            r1 = 1
        L74:
            r5.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.O2(int, androidx.recyclerview.widget.RecyclerView$a0):void");
    }

    private void Q1(View view, c cVar, androidx.recyclerview.widget.f fVar) {
        if (fVar.e == 1) {
            if (cVar.f) {
                M1(view);
            } else {
                cVar.e.a(view);
            }
        } else if (cVar.f) {
            z2(view);
        } else {
            cVar.e.u(view);
        }
    }

    private void Q2(f fVar, int i, int i2) {
        int j = fVar.j();
        if (i == -1) {
            if (fVar.o() + j > i2) {
                return;
            }
        } else if (fVar.k() - j < i2) {
            return;
        }
        this.B.set(fVar.e, false);
    }

    private int R1(int i) {
        if (J() == 0) {
            return this.A ? 1 : -1;
        }
        return (i < j2()) != this.A ? -1 : 1;
    }

    private int R2(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private boolean T1(f fVar) {
        if (this.A) {
            if (fVar.k() < this.u.i()) {
                ArrayList<View> arrayList = fVar.f1038a;
                return !fVar.n(arrayList.get(arrayList.size() - 1)).f;
            }
        } else if (fVar.o() > this.u.m()) {
            return !fVar.n(fVar.f1038a.get(0)).f;
        }
        return false;
    }

    private int U1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return l.a(a0Var, this.u, e2(!this.N), d2(!this.N), this, this.N);
    }

    private int V1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return l.b(a0Var, this.u, e2(!this.N), d2(!this.N), this, this.N, this.A);
    }

    private int W1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return l.c(a0Var, this.u, e2(!this.N), d2(!this.N), this, this.N);
    }

    private int X1(int i) {
        if (i == 1) {
            return (this.w != 1 && t2()) ? 1 : -1;
        } else if (i == 2) {
            return (this.w != 1 && t2()) ? -1 : 1;
        } else if (i == 17) {
            if (this.w == 0) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        } else if (i == 33) {
            if (this.w == 1) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        } else if (i == 66) {
            if (this.w == 0) {
                return 1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        } else if (i == 130 && this.w == 1) {
            return 1;
        } else {
            return RecyclerView.UNDEFINED_DURATION;
        }
    }

    private d.a Y1(int i) {
        d.a aVar = new d.a();
        aVar.h = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            aVar.h[i2] = i - this.t[i2].l(i);
        }
        return aVar;
    }

    private d.a Z1(int i) {
        d.a aVar = new d.a();
        aVar.h = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            aVar.h[i2] = this.t[i2].p(i) - i;
        }
        return aVar;
    }

    private void a2() {
        this.u = j.b(this, this.w);
        this.v = j.b(this, 1 - this.w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int b2(RecyclerView.v vVar, androidx.recyclerview.widget.f fVar, RecyclerView.a0 a0Var) {
        int i;
        f fVar2;
        int e2;
        int i2;
        int i3;
        int e3;
        RecyclerView.o oVar;
        View view;
        int i4;
        int i5;
        ?? r9 = 0;
        this.B.set(0, this.s, true);
        if (this.y.i) {
            i = fVar.e == 1 ? Reader.READ_DONE : RecyclerView.UNDEFINED_DURATION;
        } else {
            i = fVar.e == 1 ? fVar.g + fVar.f1100b : fVar.f - fVar.f1100b;
        }
        K2(fVar.e, i);
        int i6 = this.A ? this.u.i() : this.u.m();
        boolean z = false;
        while (fVar.a(a0Var) && (this.y.i || !this.B.isEmpty())) {
            View b2 = fVar.b(vVar);
            c cVar = (c) b2.getLayoutParams();
            int a2 = cVar.a();
            int g = this.E.g(a2);
            boolean z2 = g == -1;
            if (z2) {
                fVar2 = cVar.f ? this.t[r9] : p2(fVar);
                this.E.n(a2, fVar2);
            } else {
                fVar2 = this.t[g];
            }
            f fVar3 = fVar2;
            cVar.e = fVar3;
            if (fVar.e == 1) {
                d(b2);
            } else {
                e(b2, r9);
            }
            v2(b2, cVar, r9);
            if (fVar.e == 1) {
                int l2 = cVar.f ? l2(i6) : fVar3.l(i6);
                int e4 = this.u.e(b2) + l2;
                if (z2 && cVar.f) {
                    d.a Y1 = Y1(l2);
                    Y1.g = -1;
                    Y1.f = a2;
                    this.E.a(Y1);
                }
                i2 = e4;
                e2 = l2;
            } else {
                int o2 = cVar.f ? o2(i6) : fVar3.p(i6);
                e2 = o2 - this.u.e(b2);
                if (z2 && cVar.f) {
                    d.a Z1 = Z1(o2);
                    Z1.g = 1;
                    Z1.f = a2;
                    this.E.a(Z1);
                }
                i2 = o2;
            }
            if (cVar.f && fVar.f1102d == -1) {
                if (!z2) {
                    if (!(fVar.e == 1 ? O1() : P1())) {
                        d.a f2 = this.E.f(a2);
                        if (f2 != null) {
                            f2.i = true;
                        }
                    }
                }
                this.M = true;
            }
            Q1(b2, cVar, fVar);
            if (t2() && this.w == 1) {
                int i7 = cVar.f ? this.v.i() : this.v.i() - (((this.s - 1) - fVar3.e) * this.x);
                e3 = i7;
                i3 = i7 - this.v.e(b2);
            } else {
                int m = cVar.f ? this.v.m() : (fVar3.e * this.x) + this.v.m();
                i3 = m;
                e3 = this.v.e(b2) + m;
            }
            if (this.w == 1) {
                oVar = this;
                view = b2;
                i4 = i3;
                i3 = e2;
                i5 = e3;
            } else {
                oVar = this;
                view = b2;
                i4 = e2;
                i5 = i2;
                i2 = e3;
            }
            oVar.z0(view, i4, i3, i5, i2);
            if (cVar.f) {
                K2(this.y.e, i);
            } else {
                Q2(fVar3, this.y.e, i);
            }
            A2(vVar, this.y);
            if (this.y.h && b2.hasFocusable()) {
                if (cVar.f) {
                    this.B.clear();
                } else {
                    this.B.set(fVar3.e, false);
                    z = true;
                    r9 = 0;
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            A2(vVar, this.y);
        }
        int m2 = this.y.e == -1 ? this.u.m() - o2(this.u.m()) : l2(this.u.i()) - this.u.i();
        if (m2 > 0) {
            return Math.min(fVar.f1100b, m2);
        }
        return 0;
    }

    private int c2(int i) {
        int J = J();
        for (int i2 = 0; i2 < J; i2++) {
            int h0 = h0(I(i2));
            if (h0 >= 0 && h0 < i) {
                return h0;
            }
        }
        return 0;
    }

    private int g2(int i) {
        for (int J = J() - 1; J >= 0; J--) {
            int h0 = h0(I(J));
            if (h0 >= 0 && h0 < i) {
                return h0;
            }
        }
        return 0;
    }

    private void h2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int i;
        int l2 = l2(RecyclerView.UNDEFINED_DURATION);
        if (l2 != Integer.MIN_VALUE && (i = this.u.i() - l2) > 0) {
            int i2 = i - (-F2(-i, vVar, a0Var));
            if (!z || i2 <= 0) {
                return;
            }
            this.u.r(i2);
        }
    }

    private void i2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int m;
        int o2 = o2(Reader.READ_DONE);
        if (o2 != Integer.MAX_VALUE && (m = o2 - this.u.m()) > 0) {
            int F2 = m - F2(m, vVar, a0Var);
            if (!z || F2 <= 0) {
                return;
            }
            this.u.r(-F2);
        }
    }

    private int l2(int i) {
        int l = this.t[0].l(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int l2 = this.t[i2].l(i);
            if (l2 > l) {
                l = l2;
            }
        }
        return l;
    }

    private int m2(int i) {
        int p = this.t[0].p(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int p2 = this.t[i2].p(i);
            if (p2 > p) {
                p = p2;
            }
        }
        return p;
    }

    private int n2(int i) {
        int l = this.t[0].l(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int l2 = this.t[i2].l(i);
            if (l2 < l) {
                l = l2;
            }
        }
        return l;
    }

    private int o2(int i) {
        int p = this.t[0].p(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int p2 = this.t[i2].p(i);
            if (p2 < p) {
                p = p2;
            }
        }
        return p;
    }

    private f p2(androidx.recyclerview.widget.f fVar) {
        int i;
        int i2;
        int i3 = -1;
        if (x2(fVar.e)) {
            i = this.s - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.s;
            i2 = 1;
        }
        f fVar2 = null;
        if (fVar.e == 1) {
            int i4 = Reader.READ_DONE;
            int m = this.u.m();
            while (i != i3) {
                f fVar3 = this.t[i];
                int l = fVar3.l(m);
                if (l < i4) {
                    fVar2 = fVar3;
                    i4 = l;
                }
                i += i2;
            }
            return fVar2;
        }
        int i5 = RecyclerView.UNDEFINED_DURATION;
        int i6 = this.u.i();
        while (i != i3) {
            f fVar4 = this.t[i];
            int p = fVar4.p(i6);
            if (p > i5) {
                fVar2 = fVar4;
                i5 = p;
            }
            i += i2;
        }
        return fVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void q2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L9
            int r0 = r6.k2()
            goto Ld
        L9:
            int r0 = r6.j2()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1a
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1c
        L16:
            int r2 = r7 + 1
            r3 = r8
            goto L1d
        L1a:
            int r2 = r7 + r8
        L1c:
            r3 = r7
        L1d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.E
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3c
            r5 = 2
            if (r9 == r5) goto L36
            if (r9 == r1) goto L2b
            goto L41
        L2b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.E
            r7.j(r8, r4)
            goto L41
        L36:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.k(r7, r8)
            goto L41
        L3c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.j(r7, r8)
        L41:
            if (r2 > r0) goto L44
            return
        L44:
            boolean r7 = r6.A
            if (r7 == 0) goto L4d
            int r7 = r6.j2()
            goto L51
        L4d:
            int r7 = r6.k2()
        L51:
            if (r3 > r7) goto L56
            r6.t1()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.q2(int, int, int):void");
    }

    private void u2(View view, int i, int i2, boolean z) {
        j(view, this.K);
        c cVar = (c) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.K;
        int R2 = R2(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.K;
        int R22 = R2(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z ? H1(view, R2, R22, cVar) : F1(view, R2, R22, cVar)) {
            view.measure(R2, R22);
        }
    }

    private void v2(View view, c cVar, boolean z) {
        int K;
        int K2;
        if (cVar.f) {
            if (this.w != 1) {
                u2(view, RecyclerView.o.K(o0(), p0(), e0() + f0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.J, z);
                return;
            }
            K = this.J;
        } else if (this.w != 1) {
            K = RecyclerView.o.K(o0(), p0(), e0() + f0(), ((ViewGroup.MarginLayoutParams) cVar).width, true);
            K2 = RecyclerView.o.K(this.x, X(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false);
            u2(view, K, K2, z);
        } else {
            K = RecyclerView.o.K(this.x, p0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false);
        }
        K2 = RecyclerView.o.K(W(), X(), g0() + d0(), ((ViewGroup.MarginLayoutParams) cVar).height, true);
        u2(view, K, K2, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x014b, code lost:
        if (S1() != false) goto L83;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void w2(androidx.recyclerview.widget.RecyclerView.v r9, androidx.recyclerview.widget.RecyclerView.a0 r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.w2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, boolean):void");
    }

    private boolean x2(int i) {
        if (this.w == 0) {
            return (i == -1) != this.A;
        }
        return ((i == -1) == this.A) == t2();
    }

    private void z2(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].u(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C0(int i) {
        super.C0(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].r(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C1(Rect rect, int i, int i2) {
        int n;
        int n2;
        int e0 = e0() + f0();
        int g0 = g0() + d0();
        if (this.w == 1) {
            n2 = RecyclerView.o.n(i2, rect.height() + g0, b0());
            n = RecyclerView.o.n(i, (this.x * this.s) + e0, c0());
        } else {
            n = RecyclerView.o.n(i, rect.width() + e0, c0());
            n2 = RecyclerView.o.n(i2, (this.x * this.s) + g0, b0());
        }
        B1(n, n2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return this.w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D0(int i) {
        super.D0(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].r(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    int F2(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (J() == 0 || i == 0) {
            return 0;
        }
        y2(i, a0Var);
        int b2 = b2(vVar, this.y, a0Var);
        if (this.y.f1100b >= b2) {
            i = i < 0 ? -b2 : b2;
        }
        this.u.r(-i);
        this.G = this.A;
        androidx.recyclerview.widget.f fVar = this.y;
        fVar.f1100b = 0;
        A2(vVar, fVar);
        return i;
    }

    public void H2(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        g(null);
        if (i == this.w) {
            return;
        }
        this.w = i;
        j jVar = this.u;
        this.u = this.v;
        this.v = jVar;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.I0(recyclerView, vVar);
        o1(this.P);
        for (int i = 0; i < this.s; i++) {
            this.t[i].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i) {
        g gVar = new g(recyclerView.getContext());
        gVar.p(i);
        J1(gVar);
    }

    public void I2(boolean z) {
        g(null);
        e eVar = this.I;
        if (eVar != null && eVar.m != z) {
            eVar.m = z;
        }
        this.z = z;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View view, int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View B;
        View m;
        if (J() == 0 || (B = B(view)) == null) {
            return null;
        }
        E2();
        int X1 = X1(i);
        if (X1 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) B.getLayoutParams();
        boolean z = cVar.f;
        f fVar = cVar.e;
        int k2 = X1 == 1 ? k2() : j2();
        O2(k2, a0Var);
        G2(X1);
        androidx.recyclerview.widget.f fVar2 = this.y;
        fVar2.f1101c = fVar2.f1102d + k2;
        fVar2.f1100b = (int) (this.u.n() * 0.33333334f);
        androidx.recyclerview.widget.f fVar3 = this.y;
        fVar3.h = true;
        fVar3.f1099a = false;
        b2(vVar, fVar3, a0Var);
        this.G = this.A;
        if (z || (m = fVar.m(k2, X1)) == null || m == B) {
            if (x2(X1)) {
                for (int i2 = this.s - 1; i2 >= 0; i2--) {
                    View m2 = this.t[i2].m(k2, X1);
                    if (m2 != null && m2 != B) {
                        return m2;
                    }
                }
            } else {
                for (int i3 = 0; i3 < this.s; i3++) {
                    View m3 = this.t[i3].m(k2, X1);
                    if (m3 != null && m3 != B) {
                        return m3;
                    }
                }
            }
            boolean z2 = (this.z ^ true) == (X1 == -1);
            if (!z) {
                View C = C(z2 ? fVar.f() : fVar.g());
                if (C != null && C != B) {
                    return C;
                }
            }
            if (x2(X1)) {
                for (int i4 = this.s - 1; i4 >= 0; i4--) {
                    if (i4 != fVar.e) {
                        f[] fVarArr = this.t;
                        View C2 = C(z2 ? fVarArr[i4].f() : fVarArr[i4].g());
                        if (C2 != null && C2 != B) {
                            return C2;
                        }
                    }
                }
            } else {
                for (int i5 = 0; i5 < this.s; i5++) {
                    f[] fVarArr2 = this.t;
                    View C3 = C(z2 ? fVarArr2[i5].f() : fVarArr2[i5].g());
                    if (C3 != null && C3 != B) {
                        return C3;
                    }
                }
            }
            return null;
        }
        return m;
    }

    public void J2(int i) {
        g(null);
        if (i != this.s) {
            s2();
            this.s = i;
            this.B = new BitSet(this.s);
            this.t = new f[this.s];
            for (int i2 = 0; i2 < this.s; i2++) {
                this.t[i2] = new f(i2);
            }
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent accessibilityEvent) {
        super.K0(accessibilityEvent);
        if (J() > 0) {
            View e2 = e2(false);
            View d2 = d2(false);
            if (e2 == null || d2 == null) {
                return;
            }
            int h0 = h0(e2);
            int h02 = h0(d2);
            if (h0 < h02) {
                accessibilityEvent.setFromIndex(h0);
                accessibilityEvent.setToIndex(h02);
                return;
            }
            accessibilityEvent.setFromIndex(h02);
            accessibilityEvent.setToIndex(h0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.I == null;
    }

    boolean M2(RecyclerView.a0 a0Var, b bVar) {
        int i;
        int m;
        int g;
        if (!a0Var.e() && (i = this.C) != -1) {
            if (i >= 0 && i < a0Var.b()) {
                e eVar = this.I;
                if (eVar == null || eVar.f == -1 || eVar.h < 1) {
                    View C = C(this.C);
                    if (C != null) {
                        bVar.f1032a = this.A ? k2() : j2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.f1034c) {
                                m = this.u.i() - this.D;
                                g = this.u.d(C);
                            } else {
                                m = this.u.m() + this.D;
                                g = this.u.g(C);
                            }
                            bVar.f1033b = m - g;
                            return true;
                        } else if (this.u.e(C) > this.u.n()) {
                            bVar.f1033b = bVar.f1034c ? this.u.i() : this.u.m();
                            return true;
                        } else {
                            int g2 = this.u.g(C) - this.u.m();
                            if (g2 < 0) {
                                bVar.f1033b = -g2;
                                return true;
                            }
                            int i2 = this.u.i() - this.u.d(C);
                            if (i2 < 0) {
                                bVar.f1033b = i2;
                                return true;
                            }
                            bVar.f1033b = RecyclerView.UNDEFINED_DURATION;
                        }
                    } else {
                        int i3 = this.C;
                        bVar.f1032a = i3;
                        int i4 = this.D;
                        if (i4 == Integer.MIN_VALUE) {
                            bVar.f1034c = R1(i3) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i4);
                        }
                        bVar.f1035d = true;
                    }
                } else {
                    bVar.f1033b = RecyclerView.UNDEFINED_DURATION;
                    bVar.f1032a = this.C;
                }
                return true;
            }
            this.C = -1;
            this.D = RecyclerView.UNDEFINED_DURATION;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.w == 1 ? this.s : super.N(vVar, a0Var);
    }

    void N2(RecyclerView.a0 a0Var, b bVar) {
        if (M2(a0Var, bVar) || L2(a0Var, bVar)) {
            return;
        }
        bVar.a();
        bVar.f1032a = 0;
    }

    boolean O1() {
        int l = this.t[0].l(RecyclerView.UNDEFINED_DURATION);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].l(RecyclerView.UNDEFINED_DURATION) != l) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void P0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, a.g.k.b0.c cVar) {
        int i;
        int i2;
        int e2;
        int i3;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.O0(view, cVar);
            return;
        }
        c cVar2 = (c) layoutParams;
        if (this.w == 0) {
            i = cVar2.e();
            i2 = cVar2.f ? this.s : 1;
            e2 = -1;
            i3 = -1;
        } else {
            i = -1;
            i2 = -1;
            e2 = cVar2.e();
            i3 = cVar2.f ? this.s : 1;
        }
        cVar.Z(c.C0013c.a(i, i2, e2, i3, false, false));
    }

    boolean P1() {
        int p = this.t[0].p(RecyclerView.UNDEFINED_DURATION);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].p(RecyclerView.UNDEFINED_DURATION) != p) {
                return false;
            }
        }
        return true;
    }

    void P2(int i) {
        this.x = i / this.s;
        this.J = View.MeasureSpec.makeMeasureSpec(i, this.v.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView, int i, int i2) {
        q2(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView) {
        this.E.b();
        t1();
    }

    boolean S1() {
        int j2;
        int k2;
        if (J() == 0 || this.F == 0 || !r0()) {
            return false;
        }
        if (this.A) {
            j2 = k2();
            k2 = j2();
        } else {
            j2 = j2();
            k2 = k2();
        }
        if (j2 == 0 && r2() != null) {
            this.E.b();
        } else if (!this.M) {
            return false;
        } else {
            int i = this.A ? -1 : 1;
            int i2 = k2 + 1;
            d.a e2 = this.E.e(j2, i2, i, true);
            if (e2 == null) {
                this.M = false;
                this.E.d(i2);
                return false;
            }
            d.a e3 = this.E.e(j2, e2.f, i * (-1), true);
            if (e3 == null) {
                this.E.d(e2.f);
            } else {
                this.E.d(e3.f + 1);
            }
        }
        u1();
        t1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int i, int i2, int i3) {
        q2(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int i, int i2) {
        q2(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView recyclerView, int i, int i2, Object obj) {
        q2(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        w2(vVar, a0Var, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.a0 a0Var) {
        super.Y0(a0Var);
        this.C = -1;
        this.D = RecyclerView.UNDEFINED_DURATION;
        this.I = null;
        this.L.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i) {
        int R1 = R1(i);
        PointF pointF = new PointF();
        if (R1 == 0) {
            return null;
        }
        if (this.w == 0) {
            pointF.x = R1;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = R1;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.I = (e) parcelable;
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        int p;
        int m;
        int[] iArr;
        if (this.I != null) {
            return new e(this.I);
        }
        e eVar = new e();
        eVar.m = this.z;
        eVar.n = this.G;
        eVar.o = this.H;
        d dVar = this.E;
        if (dVar == null || (iArr = dVar.f1036a) == null) {
            eVar.j = 0;
        } else {
            eVar.k = iArr;
            eVar.j = iArr.length;
            eVar.l = dVar.f1037b;
        }
        if (J() > 0) {
            eVar.f = this.G ? k2() : j2();
            eVar.g = f2();
            int i = this.s;
            eVar.h = i;
            eVar.i = new int[i];
            for (int i2 = 0; i2 < this.s; i2++) {
                if (this.G) {
                    p = this.t[i2].l(RecyclerView.UNDEFINED_DURATION);
                    if (p != Integer.MIN_VALUE) {
                        m = this.u.i();
                        p -= m;
                        eVar.i[i2] = p;
                    } else {
                        eVar.i[i2] = p;
                    }
                } else {
                    p = this.t[i2].p(RecyclerView.UNDEFINED_DURATION);
                    if (p != Integer.MIN_VALUE) {
                        m = this.u.m();
                        p -= m;
                        eVar.i[i2] = p;
                    } else {
                        eVar.i[i2] = p;
                    }
                }
            }
        } else {
            eVar.f = -1;
            eVar.g = -1;
            eVar.h = 0;
        }
        return eVar;
    }

    View d2(boolean z) {
        int m = this.u.m();
        int i = this.u.i();
        View view = null;
        for (int J = J() - 1; J >= 0; J--) {
            View I = I(J);
            int g = this.u.g(I);
            int d2 = this.u.d(I);
            if (d2 > m && g < i) {
                if (d2 <= i || !z) {
                    return I;
                }
                if (view == null) {
                    view = I;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e1(int i) {
        if (i == 0) {
            S1();
        }
    }

    View e2(boolean z) {
        int m = this.u.m();
        int i = this.u.i();
        int J = J();
        View view = null;
        for (int i2 = 0; i2 < J; i2++) {
            View I = I(i2);
            int g = this.u.g(I);
            if (this.u.d(I) > m && g < i) {
                if (g >= m || !z) {
                    return I;
                }
                if (view == null) {
                    view = I;
                }
            }
        }
        return view;
    }

    int f2() {
        View d2 = this.A ? d2(true) : e2(true);
        if (d2 == null) {
            return -1;
        }
        return h0(d2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.I == null) {
            super.g(str);
        }
    }

    int j2() {
        if (J() == 0) {
            return 0;
        }
        return h0(I(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int k0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.w == 0 ? this.s : super.k0(vVar, a0Var);
    }

    int k2() {
        int J = J();
        if (J == 0) {
            return 0;
        }
        return h0(I(J - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i, int i2, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        int l;
        int i3;
        if (this.w != 0) {
            i = i2;
        }
        if (J() == 0 || i == 0) {
            return;
        }
        y2(i, a0Var);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.s) {
            this.O = new int[this.s];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.s; i5++) {
            androidx.recyclerview.widget.f fVar = this.y;
            if (fVar.f1102d == -1) {
                l = fVar.f;
                i3 = this.t[i5].p(l);
            } else {
                l = this.t[i5].l(fVar.g);
                i3 = this.y.g;
            }
            int i6 = l - i3;
            if (i6 >= 0) {
                this.O[i4] = i6;
                i4++;
            }
        }
        Arrays.sort(this.O, 0, i4);
        for (int i7 = 0; i7 < i4 && this.y.a(a0Var); i7++) {
            cVar.a(this.y.f1101c, this.O[i7]);
            androidx.recyclerview.widget.f fVar2 = this.y;
            fVar2.f1101c += fVar2.f1102d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.a0 a0Var) {
        return U1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return V1(a0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
        if (r10 == r11) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View r2() {
        /*
            r12 = this;
            int r0 = r12.J()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.s
            r2.<init>(r3)
            int r3 = r12.s
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.w
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.t2()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.A
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.I(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.e
            int r9 = r9.e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.e
            boolean r9 = r12.T1(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.e
            int r9 = r9.e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.I(r9)
            boolean r10 = r12.A
            if (r10 == 0) goto L77
            androidx.recyclerview.widget.j r10 = r12.u
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.j r11 = r12.u
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            androidx.recyclerview.widget.j r10 = r12.u
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.j r11 = r12.u
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = 1
            goto L8b
        L8a:
            r10 = 0
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r8 = r8.e
            int r8 = r8.e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r9.e
            int r9 = r9.e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = 1
            goto La1
        La0:
            r8 = 0
        La1:
            if (r3 >= 0) goto La5
            r9 = 1
            goto La6
        La5:
            r9 = 0
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.r2():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return W1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return this.F != 0;
    }

    public void s2() {
        this.E.b();
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return U1(a0Var);
    }

    boolean t2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return V1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return W1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return F2(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i) {
        e eVar = this.I;
        if (eVar != null && eVar.f != i) {
            eVar.a();
        }
        this.C = i;
        this.D = RecyclerView.UNDEFINED_DURATION;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return F2(i, vVar, a0Var);
    }

    void y2(int i, RecyclerView.a0 a0Var) {
        int j2;
        int i2;
        if (i > 0) {
            j2 = k2();
            i2 = 1;
        } else {
            j2 = j2();
            i2 = -1;
        }
        this.y.f1099a = true;
        O2(j2, a0Var);
        G2(i2);
        androidx.recyclerview.widget.f fVar = this.y;
        fVar.f1101c = j2 + fVar.f1102d;
        fVar.f1100b = Math.abs(i);
    }
}
