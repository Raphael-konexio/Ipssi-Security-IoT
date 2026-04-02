package a.p;

import a.p.m;
import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class q extends m {
    int Q;
    private ArrayList<m> O = new ArrayList<>();
    private boolean P = true;
    boolean R = false;
    private int S = 0;

    /* loaded from: classes.dex */
    class a extends n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f406a;

        a(q qVar, m mVar) {
            this.f406a = mVar;
        }

        @Override // a.p.m.f
        public void e(m mVar) {
            this.f406a.T();
            mVar.P(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends n {

        /* renamed from: a  reason: collision with root package name */
        q f407a;

        b(q qVar) {
            this.f407a = qVar;
        }

        @Override // a.p.n, a.p.m.f
        public void a(m mVar) {
            q qVar = this.f407a;
            if (qVar.R) {
                return;
            }
            qVar.a0();
            this.f407a.R = true;
        }

        @Override // a.p.m.f
        public void e(m mVar) {
            q qVar = this.f407a;
            int i = qVar.Q - 1;
            qVar.Q = i;
            if (i == 0) {
                qVar.R = false;
                qVar.p();
            }
            mVar.P(this);
        }
    }

    private void f0(m mVar) {
        this.O.add(mVar);
        mVar.w = this;
    }

    private void o0() {
        b bVar = new b(this);
        Iterator<m> it = this.O.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.Q = this.O.size();
    }

    @Override // a.p.m
    public void N(View view) {
        super.N(view);
        int size = this.O.size();
        for (int i = 0; i < size; i++) {
            this.O.get(i).N(view);
        }
    }

    @Override // a.p.m
    public void R(View view) {
        super.R(view);
        int size = this.O.size();
        for (int i = 0; i < size; i++) {
            this.O.get(i).R(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.p.m
    public void T() {
        if (this.O.isEmpty()) {
            a0();
            p();
            return;
        }
        o0();
        if (this.P) {
            Iterator<m> it = this.O.iterator();
            while (it.hasNext()) {
                it.next().T();
            }
            return;
        }
        for (int i = 1; i < this.O.size(); i++) {
            this.O.get(i - 1).a(new a(this, this.O.get(i)));
        }
        m mVar = this.O.get(0);
        if (mVar != null) {
            mVar.T();
        }
    }

    @Override // a.p.m
    public /* bridge */ /* synthetic */ m U(long j) {
        k0(j);
        return this;
    }

    @Override // a.p.m
    public void V(m.e eVar) {
        super.V(eVar);
        this.S |= 8;
        int size = this.O.size();
        for (int i = 0; i < size; i++) {
            this.O.get(i).V(eVar);
        }
    }

    @Override // a.p.m
    public void X(g gVar) {
        super.X(gVar);
        this.S |= 4;
        if (this.O != null) {
            for (int i = 0; i < this.O.size(); i++) {
                this.O.get(i).X(gVar);
            }
        }
    }

    @Override // a.p.m
    public void Y(p pVar) {
        super.Y(pVar);
        this.S |= 2;
        int size = this.O.size();
        for (int i = 0; i < size; i++) {
            this.O.get(i).Y(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.p.m
    public String b0(String str) {
        String b0 = super.b0(str);
        for (int i = 0; i < this.O.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(b0);
            sb.append("\n");
            sb.append(this.O.get(i).b0(str + "  "));
            b0 = sb.toString();
        }
        return b0;
    }

    @Override // a.p.m
    /* renamed from: c0 */
    public q a(m.f fVar) {
        super.a(fVar);
        return this;
    }

    @Override // a.p.m
    /* renamed from: d0 */
    public q b(View view) {
        for (int i = 0; i < this.O.size(); i++) {
            this.O.get(i).b(view);
        }
        super.b(view);
        return this;
    }

    public q e0(m mVar) {
        f0(mVar);
        long j = this.h;
        if (j >= 0) {
            mVar.U(j);
        }
        if ((this.S & 1) != 0) {
            mVar.W(s());
        }
        if ((this.S & 2) != 0) {
            mVar.Y(w());
        }
        if ((this.S & 4) != 0) {
            mVar.X(v());
        }
        if ((this.S & 8) != 0) {
            mVar.V(r());
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.p.m
    public void f() {
        super.f();
        int size = this.O.size();
        for (int i = 0; i < size; i++) {
            this.O.get(i).f();
        }
    }

    @Override // a.p.m
    public void g(s sVar) {
        if (G(sVar.f412b)) {
            Iterator<m> it = this.O.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.G(sVar.f412b)) {
                    next.g(sVar);
                    sVar.f413c.add(next);
                }
            }
        }
    }

    public m g0(int i) {
        if (i < 0 || i >= this.O.size()) {
            return null;
        }
        return this.O.get(i);
    }

    public int h0() {
        return this.O.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a.p.m
    public void i(s sVar) {
        super.i(sVar);
        int size = this.O.size();
        for (int i = 0; i < size; i++) {
            this.O.get(i).i(sVar);
        }
    }

    @Override // a.p.m
    /* renamed from: i0 */
    public q P(m.f fVar) {
        super.P(fVar);
        return this;
    }

    @Override // a.p.m
    public void j(s sVar) {
        if (G(sVar.f412b)) {
            Iterator<m> it = this.O.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.G(sVar.f412b)) {
                    next.j(sVar);
                    sVar.f413c.add(next);
                }
            }
        }
    }

    @Override // a.p.m
    /* renamed from: j0 */
    public q Q(View view) {
        for (int i = 0; i < this.O.size(); i++) {
            this.O.get(i).Q(view);
        }
        super.Q(view);
        return this;
    }

    public q k0(long j) {
        ArrayList<m> arrayList;
        super.U(j);
        if (this.h >= 0 && (arrayList = this.O) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.O.get(i).U(j);
            }
        }
        return this;
    }

    @Override // a.p.m
    /* renamed from: l0 */
    public q W(TimeInterpolator timeInterpolator) {
        this.S |= 1;
        ArrayList<m> arrayList = this.O;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.O.get(i).W(timeInterpolator);
            }
        }
        super.W(timeInterpolator);
        return this;
    }

    @Override // a.p.m
    /* renamed from: m */
    public m clone() {
        q qVar = (q) super.clone();
        qVar.O = new ArrayList<>();
        int size = this.O.size();
        for (int i = 0; i < size; i++) {
            qVar.f0(this.O.get(i).clone());
        }
        return qVar;
    }

    public q m0(int i) {
        if (i == 0) {
            this.P = true;
        } else if (i != 1) {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        } else {
            this.P = false;
        }
        return this;
    }

    @Override // a.p.m
    /* renamed from: n0 */
    public q Z(long j) {
        super.Z(j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.p.m
    public void o(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long y = y();
        int size = this.O.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.O.get(i);
            if (y > 0 && (this.P || i == 0)) {
                long y2 = mVar.y();
                if (y2 > 0) {
                    mVar.Z(y2 + y);
                } else {
                    mVar.Z(y);
                }
            }
            mVar.o(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }
}
