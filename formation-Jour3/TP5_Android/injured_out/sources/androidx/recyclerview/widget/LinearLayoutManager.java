package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.List;
/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    int A;
    int B;
    private boolean C;
    d D;
    final a E;
    private final b F;
    private int G;
    private int[] H;
    int s;
    private c t;
    j u;
    private boolean v;
    private boolean w;
    boolean x;
    private boolean y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        j f967a;

        /* renamed from: b  reason: collision with root package name */
        int f968b;

        /* renamed from: c  reason: collision with root package name */
        int f969c;

        /* renamed from: d  reason: collision with root package name */
        boolean f970d;
        boolean e;

        a() {
            e();
        }

        void a() {
            this.f969c = this.f970d ? this.f967a.i() : this.f967a.m();
        }

        public void b(View view, int i) {
            this.f969c = this.f970d ? this.f967a.d(view) + this.f967a.o() : this.f967a.g(view);
            this.f968b = i;
        }

        public void c(View view, int i) {
            int o = this.f967a.o();
            if (o >= 0) {
                b(view, i);
                return;
            }
            this.f968b = i;
            if (this.f970d) {
                int i2 = (this.f967a.i() - o) - this.f967a.d(view);
                this.f969c = this.f967a.i() - i2;
                if (i2 > 0) {
                    int e = this.f969c - this.f967a.e(view);
                    int m = this.f967a.m();
                    int min = e - (m + Math.min(this.f967a.g(view) - m, 0));
                    if (min < 0) {
                        this.f969c += Math.min(i2, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g = this.f967a.g(view);
            int m2 = g - this.f967a.m();
            this.f969c = g;
            if (m2 > 0) {
                int i3 = (this.f967a.i() - Math.min(0, (this.f967a.i() - o) - this.f967a.d(view))) - (g + this.f967a.e(view));
                if (i3 < 0) {
                    this.f969c -= Math.min(m2, -i3);
                }
            }
        }

        boolean d(View view, RecyclerView.a0 a0Var) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < a0Var.b();
        }

        void e() {
            this.f968b = -1;
            this.f969c = RecyclerView.UNDEFINED_DURATION;
            this.f970d = false;
            this.e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f968b + ", mCoordinate=" + this.f969c + ", mLayoutFromEnd=" + this.f970d + ", mValid=" + this.e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f971a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f972b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f973c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f974d;

        protected b() {
        }

        void a() {
            this.f971a = 0;
            this.f972b = false;
            this.f973c = false;
            this.f974d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b  reason: collision with root package name */
        int f976b;

        /* renamed from: c  reason: collision with root package name */
        int f977c;

        /* renamed from: d  reason: collision with root package name */
        int f978d;
        int e;
        int f;
        int g;
        boolean j;
        int k;
        boolean m;

        /* renamed from: a  reason: collision with root package name */
        boolean f975a = true;
        int h = 0;
        int i = 0;
        List<RecyclerView.d0> l = null;

        c() {
        }

        private View e() {
            int size = this.l.size();
            for (int i = 0; i < size; i++) {
                View view = this.l.get(i).f984a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f978d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View f = f(view);
            this.f978d = f == null ? -1 : ((RecyclerView.p) f.getLayoutParams()).a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(RecyclerView.a0 a0Var) {
            int i = this.f978d;
            return i >= 0 && i < a0Var.b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View d(RecyclerView.v vVar) {
            if (this.l != null) {
                return e();
            }
            View o = vVar.o(this.f978d);
            this.f978d += this.e;
            return o;
        }

        public View f(View view) {
            int a2;
            int size = this.l.size();
            View view2 = null;
            int i = Reader.READ_DONE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.l.get(i2).f984a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (a2 = (pVar.a() - this.f978d) * this.e) >= 0 && a2 < i) {
                    view2 = view3;
                    if (a2 == 0) {
                        break;
                    }
                    i = a2;
                }
            }
            return view2;
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();
        int f;
        int g;
        boolean h;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        public d() {
        }

        d(Parcel parcel) {
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            this.h = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f = dVar.f;
            this.g = dVar.g;
            this.h = dVar.h;
        }

        boolean a() {
            return this.f >= 0;
        }

        void b() {
            this.f = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        C2(i);
        D2(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.o.d i0 = RecyclerView.o.i0(context, attributeSet, i, i2);
        C2(i0.f1005a);
        D2(i0.f1007c);
        E2(i0.f1008d);
    }

    private void A2() {
        this.x = (this.s == 1 || !q2()) ? this.w : !this.w;
    }

    private boolean F2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        boolean z = false;
        if (J() == 0) {
            return false;
        }
        View V = V();
        if (V != null && aVar.d(V, a0Var)) {
            aVar.c(V, h0(V));
            return true;
        } else if (this.v != this.y) {
            return false;
        } else {
            View i2 = aVar.f970d ? i2(vVar, a0Var) : j2(vVar, a0Var);
            if (i2 != null) {
                aVar.b(i2, h0(i2));
                if (!a0Var.e() && L1()) {
                    if ((this.u.g(i2) >= this.u.i() || this.u.d(i2) < this.u.m()) ? true : true) {
                        aVar.f969c = aVar.f970d ? this.u.i() : this.u.m();
                    }
                }
                return true;
            }
            return false;
        }
    }

    private boolean G2(RecyclerView.a0 a0Var, a aVar) {
        int i;
        if (!a0Var.e() && (i = this.A) != -1) {
            if (i >= 0 && i < a0Var.b()) {
                aVar.f968b = this.A;
                d dVar = this.D;
                if (dVar != null && dVar.a()) {
                    boolean z = this.D.h;
                    aVar.f970d = z;
                    aVar.f969c = z ? this.u.i() - this.D.g : this.u.m() + this.D.g;
                    return true;
                } else if (this.B != Integer.MIN_VALUE) {
                    boolean z2 = this.x;
                    aVar.f970d = z2;
                    aVar.f969c = z2 ? this.u.i() - this.B : this.u.m() + this.B;
                    return true;
                } else {
                    View C = C(this.A);
                    if (C == null) {
                        if (J() > 0) {
                            aVar.f970d = (this.A < h0(I(0))) == this.x;
                        }
                        aVar.a();
                    } else if (this.u.e(C) > this.u.n()) {
                        aVar.a();
                        return true;
                    } else if (this.u.g(C) - this.u.m() < 0) {
                        aVar.f969c = this.u.m();
                        aVar.f970d = false;
                        return true;
                    } else if (this.u.i() - this.u.d(C) < 0) {
                        aVar.f969c = this.u.i();
                        aVar.f970d = true;
                        return true;
                    } else {
                        aVar.f969c = aVar.f970d ? this.u.d(C) + this.u.o() : this.u.g(C);
                    }
                    return true;
                }
            }
            this.A = -1;
            this.B = RecyclerView.UNDEFINED_DURATION;
        }
        return false;
    }

    private void H2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (G2(a0Var, aVar) || F2(vVar, a0Var, aVar)) {
            return;
        }
        aVar.a();
        aVar.f968b = this.y ? a0Var.b() - 1 : 0;
    }

    private void I2(int i, int i2, boolean z, RecyclerView.a0 a0Var) {
        int m;
        this.t.m = z2();
        this.t.f = i;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(a0Var, iArr);
        int max = Math.max(0, this.H[0]);
        int max2 = Math.max(0, this.H[1]);
        boolean z2 = i == 1;
        this.t.h = z2 ? max2 : max;
        c cVar = this.t;
        if (!z2) {
            max = max2;
        }
        cVar.i = max;
        if (z2) {
            this.t.h += this.u.j();
            View m2 = m2();
            this.t.e = this.x ? -1 : 1;
            c cVar2 = this.t;
            int h0 = h0(m2);
            c cVar3 = this.t;
            cVar2.f978d = h0 + cVar3.e;
            cVar3.f976b = this.u.d(m2);
            m = this.u.d(m2) - this.u.i();
        } else {
            View n2 = n2();
            this.t.h += this.u.m();
            this.t.e = this.x ? 1 : -1;
            c cVar4 = this.t;
            int h02 = h0(n2);
            c cVar5 = this.t;
            cVar4.f978d = h02 + cVar5.e;
            cVar5.f976b = this.u.g(n2);
            m = (-this.u.g(n2)) + this.u.m();
        }
        c cVar6 = this.t;
        cVar6.f977c = i2;
        if (z) {
            cVar6.f977c = i2 - m;
        }
        this.t.g = m;
    }

    private void J2(int i, int i2) {
        this.t.f977c = this.u.i() - i2;
        this.t.e = this.x ? -1 : 1;
        c cVar = this.t;
        cVar.f978d = i;
        cVar.f = 1;
        cVar.f976b = i2;
        cVar.g = RecyclerView.UNDEFINED_DURATION;
    }

    private void K2(a aVar) {
        J2(aVar.f968b, aVar.f969c);
    }

    private void L2(int i, int i2) {
        this.t.f977c = i2 - this.u.m();
        c cVar = this.t;
        cVar.f978d = i;
        cVar.e = this.x ? 1 : -1;
        c cVar2 = this.t;
        cVar2.f = -1;
        cVar2.f976b = i2;
        cVar2.g = RecyclerView.UNDEFINED_DURATION;
    }

    private void M2(a aVar) {
        L2(aVar.f968b, aVar.f969c);
    }

    private int O1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.a(a0Var, this.u, Y1(!this.z, true), X1(!this.z, true), this, this.z);
    }

    private int P1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.b(a0Var, this.u, Y1(!this.z, true), X1(!this.z, true), this, this.z, this.x);
    }

    private int Q1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.c(a0Var, this.u, Y1(!this.z, true), X1(!this.z, true), this, this.z);
    }

    private View V1() {
        return d2(0, J());
    }

    private View W1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return h2(vVar, a0Var, 0, J(), a0Var.b());
    }

    private View a2() {
        return d2(J() - 1, -1);
    }

    private View b2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return h2(vVar, a0Var, J() - 1, -1, a0Var.b());
    }

    private View f2() {
        return this.x ? V1() : a2();
    }

    private View g2() {
        return this.x ? a2() : V1();
    }

    private View i2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.x ? W1(vVar, a0Var) : b2(vVar, a0Var);
    }

    private View j2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.x ? b2(vVar, a0Var) : W1(vVar, a0Var);
    }

    private int k2(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int i2;
        int i3 = this.u.i() - i;
        if (i3 > 0) {
            int i4 = -B2(-i3, vVar, a0Var);
            int i5 = i + i4;
            if (!z || (i2 = this.u.i() - i5) <= 0) {
                return i4;
            }
            this.u.r(i2);
            return i2 + i4;
        }
        return 0;
    }

    private int l2(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int m;
        int m2 = i - this.u.m();
        if (m2 > 0) {
            int i2 = -B2(m2, vVar, a0Var);
            int i3 = i + i2;
            if (!z || (m = i3 - this.u.m()) <= 0) {
                return i2;
            }
            this.u.r(-m);
            return i2 - m;
        }
        return 0;
    }

    private View m2() {
        return I(this.x ? 0 : J() - 1);
    }

    private View n2() {
        return I(this.x ? J() - 1 : 0);
    }

    private void t2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i, int i2) {
        if (!a0Var.g() || J() == 0 || a0Var.e() || !L1()) {
            return;
        }
        List<RecyclerView.d0> k = vVar.k();
        int size = k.size();
        int h0 = h0(I(0));
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.d0 d0Var = k.get(i5);
            if (!d0Var.v()) {
                char c2 = (d0Var.m() < h0) != this.x ? (char) 65535 : (char) 1;
                int e = this.u.e(d0Var.f984a);
                if (c2 == 65535) {
                    i3 += e;
                } else {
                    i4 += e;
                }
            }
        }
        this.t.l = k;
        if (i3 > 0) {
            L2(h0(n2()), i);
            c cVar = this.t;
            cVar.h = i3;
            cVar.f977c = 0;
            cVar.a();
            U1(vVar, this.t, a0Var, false);
        }
        if (i4 > 0) {
            J2(h0(m2()), i2);
            c cVar2 = this.t;
            cVar2.h = i4;
            cVar2.f977c = 0;
            cVar2.a();
            U1(vVar, this.t, a0Var, false);
        }
        this.t.l = null;
    }

    private void v2(RecyclerView.v vVar, c cVar) {
        if (!cVar.f975a || cVar.m) {
            return;
        }
        int i = cVar.g;
        int i2 = cVar.i;
        if (cVar.f == -1) {
            x2(vVar, i, i2);
        } else {
            y2(vVar, i, i2);
        }
    }

    private void w2(RecyclerView.v vVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                n1(i, vVar);
                i--;
            }
            return;
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            n1(i3, vVar);
        }
    }

    private void x2(RecyclerView.v vVar, int i, int i2) {
        int J = J();
        if (i < 0) {
            return;
        }
        int h = (this.u.h() - i) + i2;
        if (this.x) {
            for (int i3 = 0; i3 < J; i3++) {
                View I = I(i3);
                if (this.u.g(I) < h || this.u.q(I) < h) {
                    w2(vVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = J - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View I2 = I(i5);
            if (this.u.g(I2) < h || this.u.q(I2) < h) {
                w2(vVar, i4, i5);
                return;
            }
        }
    }

    private void y2(RecyclerView.v vVar, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int J = J();
        if (!this.x) {
            for (int i4 = 0; i4 < J; i4++) {
                View I = I(i4);
                if (this.u.d(I) > i3 || this.u.p(I) > i3) {
                    w2(vVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = J - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View I2 = I(i6);
            if (this.u.d(I2) > i3 || this.u.p(I2) > i3) {
                w2(vVar, i5, i6);
                return;
            }
        }
    }

    int B2(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (J() == 0 || i == 0) {
            return 0;
        }
        T1();
        this.t.f975a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        I2(i2, abs, true, a0Var);
        c cVar = this.t;
        int U1 = cVar.g + U1(vVar, cVar, a0Var, false);
        if (U1 < 0) {
            return 0;
        }
        if (abs > U1) {
            i = i2 * U1;
        }
        this.u.r(-i);
        this.t.k = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View C(int i) {
        int J = J();
        if (J == 0) {
            return null;
        }
        int h0 = i - h0(I(0));
        if (h0 >= 0 && h0 < J) {
            View I = I(h0);
            if (h0(I) == i) {
                return I;
            }
        }
        return super.C(i);
    }

    public void C2(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        g(null);
        if (i != this.s || this.u == null) {
            j b2 = j.b(this, i);
            this.u = b2;
            this.E.f967a = b2;
            this.s = i;
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return new RecyclerView.p(-2, -2);
    }

    public void D2(boolean z) {
        g(null);
        if (z == this.w) {
            return;
        }
        this.w = z;
        t1();
    }

    public void E2(boolean z) {
        g(null);
        if (this.y == z) {
            return;
        }
        this.y = z;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    boolean G1() {
        return (X() == 1073741824 || p0() == 1073741824 || !q0()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.I0(recyclerView, vVar);
        if (this.C) {
            k1(vVar);
            vVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i) {
        g gVar = new g(recyclerView.getContext());
        gVar.p(i);
        J1(gVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View view, int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int R1;
        A2();
        if (J() == 0 || (R1 = R1(i)) == Integer.MIN_VALUE) {
            return null;
        }
        T1();
        I2(R1, (int) (this.u.n() * 0.33333334f), false, a0Var);
        c cVar = this.t;
        cVar.g = RecyclerView.UNDEFINED_DURATION;
        cVar.f975a = false;
        U1(vVar, cVar, a0Var, true);
        View g2 = R1 == -1 ? g2() : f2();
        View n2 = R1 == -1 ? n2() : m2();
        if (n2.hasFocusable()) {
            if (g2 == null) {
                return null;
            }
            return n2;
        }
        return g2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent accessibilityEvent) {
        super.K0(accessibilityEvent);
        if (J() > 0) {
            accessibilityEvent.setFromIndex(Z1());
            accessibilityEvent.setToIndex(c2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.D == null && this.v == this.y;
    }

    protected void M1(RecyclerView.a0 a0Var, int[] iArr) {
        int i;
        int o2 = o2(a0Var);
        if (this.t.f == -1) {
            i = 0;
        } else {
            i = o2;
            o2 = 0;
        }
        iArr[0] = o2;
        iArr[1] = i;
    }

    void N1(RecyclerView.a0 a0Var, c cVar, RecyclerView.o.c cVar2) {
        int i = cVar.f978d;
        if (i < 0 || i >= a0Var.b()) {
            return;
        }
        cVar2.a(i, Math.max(0, cVar.g));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int R1(int i) {
        if (i == 1) {
            return (this.s != 1 && q2()) ? 1 : -1;
        } else if (i == 2) {
            return (this.s != 1 && q2()) ? -1 : 1;
        } else if (i == 17) {
            if (this.s == 0) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        } else if (i == 33) {
            if (this.s == 1) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        } else if (i == 66) {
            if (this.s == 0) {
                return 1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        } else if (i == 130 && this.s == 1) {
            return 1;
        } else {
            return RecyclerView.UNDEFINED_DURATION;
        }
    }

    c S1() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T1() {
        if (this.t == null) {
            this.t = S1();
        }
    }

    int U1(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z) {
        int i = cVar.f977c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            v2(vVar, cVar);
        }
        int i3 = cVar.f977c + cVar.h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.m && i3 <= 0) || !cVar.c(a0Var)) {
                break;
            }
            bVar.a();
            s2(vVar, a0Var, cVar, bVar);
            if (!bVar.f972b) {
                cVar.f976b += bVar.f971a * cVar.f;
                if (!bVar.f973c || cVar.l != null || !a0Var.e()) {
                    int i4 = cVar.f977c;
                    int i5 = bVar.f971a;
                    cVar.f977c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.g;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + bVar.f971a;
                    cVar.g = i7;
                    int i8 = cVar.f977c;
                    if (i8 < 0) {
                        cVar.g = i7 + i8;
                    }
                    v2(vVar, cVar);
                }
                if (z && bVar.f974d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.f977c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int k2;
        int i5;
        View C;
        int g;
        int i6;
        int i7 = -1;
        if (!(this.D == null && this.A == -1) && a0Var.b() == 0) {
            k1(vVar);
            return;
        }
        d dVar = this.D;
        if (dVar != null && dVar.a()) {
            this.A = this.D.f;
        }
        T1();
        this.t.f975a = false;
        A2();
        View V = V();
        if (!this.E.e || this.A != -1 || this.D != null) {
            this.E.e();
            a aVar = this.E;
            aVar.f970d = this.x ^ this.y;
            H2(vVar, a0Var, aVar);
            this.E.e = true;
        } else if (V != null && (this.u.g(V) >= this.u.i() || this.u.d(V) <= this.u.m())) {
            this.E.c(V, h0(V));
        }
        c cVar = this.t;
        cVar.f = cVar.k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(a0Var, iArr);
        int max = Math.max(0, this.H[0]) + this.u.m();
        int max2 = Math.max(0, this.H[1]) + this.u.j();
        if (a0Var.e() && (i5 = this.A) != -1 && this.B != Integer.MIN_VALUE && (C = C(i5)) != null) {
            if (this.x) {
                i6 = this.u.i() - this.u.d(C);
                g = this.B;
            } else {
                g = this.u.g(C) - this.u.m();
                i6 = this.B;
            }
            int i8 = i6 - g;
            if (i8 > 0) {
                max += i8;
            } else {
                max2 -= i8;
            }
        }
        if (!this.E.f970d ? !this.x : this.x) {
            i7 = 1;
        }
        u2(vVar, a0Var, this.E, i7);
        w(vVar);
        this.t.m = z2();
        this.t.j = a0Var.e();
        this.t.i = 0;
        a aVar2 = this.E;
        if (aVar2.f970d) {
            M2(aVar2);
            c cVar2 = this.t;
            cVar2.h = max;
            U1(vVar, cVar2, a0Var, false);
            c cVar3 = this.t;
            i2 = cVar3.f976b;
            int i9 = cVar3.f978d;
            int i10 = cVar3.f977c;
            if (i10 > 0) {
                max2 += i10;
            }
            K2(this.E);
            c cVar4 = this.t;
            cVar4.h = max2;
            cVar4.f978d += cVar4.e;
            U1(vVar, cVar4, a0Var, false);
            c cVar5 = this.t;
            i = cVar5.f976b;
            int i11 = cVar5.f977c;
            if (i11 > 0) {
                L2(i9, i2);
                c cVar6 = this.t;
                cVar6.h = i11;
                U1(vVar, cVar6, a0Var, false);
                i2 = this.t.f976b;
            }
        } else {
            K2(aVar2);
            c cVar7 = this.t;
            cVar7.h = max2;
            U1(vVar, cVar7, a0Var, false);
            c cVar8 = this.t;
            i = cVar8.f976b;
            int i12 = cVar8.f978d;
            int i13 = cVar8.f977c;
            if (i13 > 0) {
                max += i13;
            }
            M2(this.E);
            c cVar9 = this.t;
            cVar9.h = max;
            cVar9.f978d += cVar9.e;
            U1(vVar, cVar9, a0Var, false);
            c cVar10 = this.t;
            i2 = cVar10.f976b;
            int i14 = cVar10.f977c;
            if (i14 > 0) {
                J2(i12, i);
                c cVar11 = this.t;
                cVar11.h = i14;
                U1(vVar, cVar11, a0Var, false);
                i = this.t.f976b;
            }
        }
        if (J() > 0) {
            if (this.x ^ this.y) {
                int k22 = k2(i, vVar, a0Var, true);
                i3 = i2 + k22;
                i4 = i + k22;
                k2 = l2(i3, vVar, a0Var, false);
            } else {
                int l2 = l2(i2, vVar, a0Var, true);
                i3 = i2 + l2;
                i4 = i + l2;
                k2 = k2(i4, vVar, a0Var, false);
            }
            i2 = i3 + k2;
            i = i4 + k2;
        }
        t2(vVar, a0Var, i2, i);
        if (a0Var.e()) {
            this.E.e();
        } else {
            this.u.s();
        }
        this.v = this.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View X1(boolean z, boolean z2) {
        int J;
        int i;
        if (this.x) {
            J = 0;
            i = J();
        } else {
            J = J() - 1;
            i = -1;
        }
        return e2(J, i, z, z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.a0 a0Var) {
        super.Y0(a0Var);
        this.D = null;
        this.A = -1;
        this.B = RecyclerView.UNDEFINED_DURATION;
        this.E.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Y1(boolean z, boolean z2) {
        int i;
        int J;
        if (this.x) {
            i = J() - 1;
            J = -1;
        } else {
            i = 0;
            J = J();
        }
        return e2(i, J, z, z2);
    }

    public int Z1() {
        View e2 = e2(0, J(), false, true);
        if (e2 == null) {
            return -1;
        }
        return h0(e2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i) {
        if (J() == 0) {
            return null;
        }
        int i2 = (i < h0(I(0))) != this.x ? -1 : 1;
        return this.s == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.D = (d) parcelable;
            t1();
        }
    }

    public int c2() {
        View e2 = e2(J() - 1, -1, false, true);
        if (e2 == null) {
            return -1;
        }
        return h0(e2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        if (this.D != null) {
            return new d(this.D);
        }
        d dVar = new d();
        if (J() > 0) {
            T1();
            boolean z = this.v ^ this.x;
            dVar.h = z;
            if (z) {
                View m2 = m2();
                dVar.g = this.u.i() - this.u.d(m2);
                dVar.f = h0(m2);
            } else {
                View n2 = n2();
                dVar.f = h0(n2);
                dVar.g = this.u.g(n2) - this.u.m();
            }
        } else {
            dVar.b();
        }
        return dVar;
    }

    View d2(int i, int i2) {
        int i3;
        int i4;
        T1();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return I(i);
        }
        if (this.u.g(I(i)) < this.u.m()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return (this.s == 0 ? this.e : this.f).a(i, i2, i3, i4);
    }

    View e2(int i, int i2, boolean z, boolean z2) {
        T1();
        return (this.s == 0 ? this.e : this.f).a(i, i2, z ? 24579 : 320, z2 ? 320 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.D == null) {
            super.g(str);
        }
    }

    View h2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i, int i2, int i3) {
        T1();
        int m = this.u.m();
        int i4 = this.u.i();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View I = I(i);
            int h0 = h0(I);
            if (h0 >= 0 && h0 < i3) {
                if (((RecyclerView.p) I.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = I;
                    }
                } else if (this.u.g(I) < i4 && this.u.d(I) >= m) {
                    return I;
                } else {
                    if (view == null) {
                        view = I;
                    }
                }
            }
            i += i5;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.s == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.s == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i, int i2, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        if (this.s != 0) {
            i = i2;
        }
        if (J() == 0 || i == 0) {
            return;
        }
        T1();
        I2(i > 0 ? 1 : -1, Math.abs(i), true, a0Var);
        N1(a0Var, this.t, cVar);
    }

    @Deprecated
    protected int o2(RecyclerView.a0 a0Var) {
        if (a0Var.d()) {
            return this.u.n();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int i, RecyclerView.o.c cVar) {
        boolean z;
        int i2;
        d dVar = this.D;
        if (dVar == null || !dVar.a()) {
            A2();
            z = this.x;
            i2 = this.A;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            d dVar2 = this.D;
            z = dVar2.h;
            i2 = dVar2.f;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.G && i2 >= 0 && i2 < i; i4++) {
            cVar.a(i2, 0);
            i2 += i3;
        }
    }

    public int p2() {
        return this.s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.a0 a0Var) {
        return O1(a0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return P1(a0Var);
    }

    public boolean r2() {
        return this.z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return Q1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return true;
    }

    void s2(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int f;
        View d2 = cVar.d(vVar);
        if (d2 == null) {
            bVar.f972b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) d2.getLayoutParams();
        if (cVar.l == null) {
            if (this.x == (cVar.f == -1)) {
                d(d2);
            } else {
                e(d2, 0);
            }
        } else {
            if (this.x == (cVar.f == -1)) {
                b(d2);
            } else {
                c(d2, 0);
            }
        }
        A0(d2, 0, 0);
        bVar.f971a = this.u.e(d2);
        if (this.s == 1) {
            if (q2()) {
                f = o0() - f0();
                i4 = f - this.u.f(d2);
            } else {
                i4 = e0();
                f = this.u.f(d2) + i4;
            }
            int i5 = cVar.f;
            int i6 = cVar.f976b;
            if (i5 == -1) {
                i3 = i6;
                i2 = f;
                i = i6 - bVar.f971a;
            } else {
                i = i6;
                i2 = f;
                i3 = bVar.f971a + i6;
            }
        } else {
            int g0 = g0();
            int f2 = this.u.f(d2) + g0;
            int i7 = cVar.f;
            int i8 = cVar.f976b;
            if (i7 == -1) {
                i2 = i8;
                i = g0;
                i3 = f2;
                i4 = i8 - bVar.f971a;
            } else {
                i = g0;
                i2 = bVar.f971a + i8;
                i3 = f2;
                i4 = i8;
            }
        }
        z0(d2, i4, i, i2, i3);
        if (pVar.c() || pVar.b()) {
            bVar.f973c = true;
        }
        bVar.f974d = d2.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return O1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return P1(a0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return Q1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 1) {
            return 0;
        }
        return B2(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i) {
        this.A = i;
        this.B = RecyclerView.UNDEFINED_DURATION;
        d dVar = this.D;
        if (dVar != null) {
            dVar.b();
        }
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 0) {
            return 0;
        }
        return B2(i, vVar, a0Var);
    }

    boolean z2() {
        return this.u.k() == 0 && this.u.h() == 0;
    }
}
