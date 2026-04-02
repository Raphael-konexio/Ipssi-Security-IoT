package a.e.a.j;

import a.e.a.j.e;
/* loaded from: classes.dex */
public class l extends n {

    /* renamed from: c  reason: collision with root package name */
    e f119c;

    /* renamed from: d  reason: collision with root package name */
    l f120d;
    float e;
    l f;
    float g;
    private l i;
    int h = 0;
    private m j = null;
    private int k = 1;
    private m l = null;
    private int m = 1;

    public l(e eVar) {
        this.f119c = eVar;
    }

    @Override // a.e.a.j.n
    public void e() {
        super.e();
        this.f120d = null;
        this.e = 0.0f;
        this.j = null;
        this.k = 1;
        this.l = null;
        this.m = 1;
        this.f = null;
        this.g = 0.0f;
        this.i = null;
        this.h = 0;
    }

    @Override // a.e.a.j.n
    public void f() {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        l lVar5;
        l lVar6;
        float f;
        l lVar7;
        e eVar;
        float D;
        float f2;
        l lVar8;
        float f3;
        boolean z = true;
        if (this.f123b == 1 || this.h == 4) {
            return;
        }
        m mVar = this.j;
        if (mVar != null) {
            if (mVar.f123b != 1) {
                return;
            }
            this.e = this.k * mVar.f121c;
        }
        m mVar2 = this.l;
        if (mVar2 != null) {
            if (mVar2.f123b != 1) {
                return;
            }
            float f4 = mVar2.f121c;
        }
        if (this.h == 1 && ((lVar8 = this.f120d) == null || lVar8.f123b == 1)) {
            l lVar9 = this.f120d;
            if (lVar9 == null) {
                this.f = this;
                f3 = this.e;
            } else {
                this.f = lVar9.f;
                f3 = lVar9.g + this.e;
            }
            this.g = f3;
            b();
            return;
        }
        if (this.h == 2 && (lVar4 = this.f120d) != null && lVar4.f123b == 1 && (lVar5 = this.i) != null && (lVar6 = lVar5.f120d) != null && lVar6.f123b == 1) {
            if (a.e.a.e.x() != null) {
                a.e.a.e.x().v++;
            }
            this.f = this.f120d.f;
            l lVar10 = this.i;
            lVar10.f = lVar10.f120d.f;
            e.d dVar = this.f119c.f104c;
            int i = 0;
            if (dVar != e.d.RIGHT && dVar != e.d.BOTTOM) {
                z = false;
            }
            if (z) {
                f = this.f120d.g;
                lVar7 = this.i.f120d;
            } else {
                f = this.i.f120d.g;
                lVar7 = this.f120d;
            }
            float f5 = f - lVar7.g;
            e.d dVar2 = this.f119c.f104c;
            if (dVar2 == e.d.LEFT || dVar2 == e.d.RIGHT) {
                D = f5 - this.f119c.f103b.D();
                f2 = this.f119c.f103b.V;
            } else {
                D = f5 - eVar.f103b.r();
                f2 = this.f119c.f103b.W;
            }
            int d2 = this.f119c.d();
            int d3 = this.i.f119c.d();
            if (this.f119c.i() == this.i.f119c.i()) {
                f2 = 0.5f;
                d3 = 0;
            } else {
                i = d2;
            }
            float f6 = i;
            float f7 = d3;
            float f8 = (D - f6) - f7;
            if (z) {
                l lVar11 = this.i;
                lVar11.g = lVar11.f120d.g + f7 + (f8 * f2);
                this.g = (this.f120d.g - f6) - (f8 * (1.0f - f2));
            } else {
                this.g = this.f120d.g + f6 + (f8 * f2);
                l lVar12 = this.i;
                lVar12.g = (lVar12.f120d.g - f7) - (f8 * (1.0f - f2));
            }
        } else if (this.h != 3 || (lVar = this.f120d) == null || lVar.f123b != 1 || (lVar2 = this.i) == null || (lVar3 = lVar2.f120d) == null || lVar3.f123b != 1) {
            if (this.h == 5) {
                this.f119c.f103b.U();
                return;
            }
            return;
        } else {
            if (a.e.a.e.x() != null) {
                a.e.a.e.x().w++;
            }
            l lVar13 = this.f120d;
            this.f = lVar13.f;
            l lVar14 = this.i;
            l lVar15 = lVar14.f120d;
            lVar14.f = lVar15.f;
            this.g = lVar13.g + this.e;
            lVar14.g = lVar15.g + lVar14.e;
        }
        b();
        this.i.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(a.e.a.e eVar) {
        a.e.a.i g = this.f119c.g();
        l lVar = this.f;
        if (lVar == null) {
            eVar.f(g, (int) (this.g + 0.5f));
        } else {
            eVar.e(g, eVar.r(lVar.f119c), (int) (this.g + 0.5f), 6);
        }
    }

    public void h(int i, l lVar, int i2) {
        this.h = i;
        this.f120d = lVar;
        this.e = i2;
        lVar.a(this);
    }

    public void i(l lVar, int i) {
        this.f120d = lVar;
        this.e = i;
        lVar.a(this);
    }

    public void j(l lVar, int i, m mVar) {
        this.f120d = lVar;
        lVar.a(this);
        this.j = mVar;
        this.k = i;
        mVar.a(this);
    }

    public float k() {
        return this.g;
    }

    public void l(l lVar, float f) {
        if (this.f123b == 0 || !(this.f == lVar || this.g == f)) {
            this.f = lVar;
            this.g = f;
            if (this.f123b == 1) {
                c();
            }
            b();
        }
    }

    String m(int i) {
        return i == 1 ? "DIRECT" : i == 2 ? "CENTER" : i == 3 ? "MATCH" : i == 4 ? "CHAIN" : i == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public void n(l lVar, float f) {
        this.i = lVar;
    }

    public void o(l lVar, int i, m mVar) {
        this.i = lVar;
        this.l = mVar;
        this.m = i;
    }

    public void p(int i) {
        this.h = i;
    }

    public void q() {
        e i = this.f119c.i();
        if (i == null) {
            return;
        }
        if (i.i() == this.f119c) {
            this.h = 4;
            i.f().h = 4;
        }
        int d2 = this.f119c.d();
        e.d dVar = this.f119c.f104c;
        if (dVar == e.d.RIGHT || dVar == e.d.BOTTOM) {
            d2 = -d2;
        }
        i(i.f(), d2);
    }

    public String toString() {
        StringBuilder sb;
        String str;
        if (this.f123b != 1) {
            sb = new StringBuilder();
            sb.append("{ ");
            sb.append(this.f119c);
            str = " UNRESOLVED} type: ";
        } else if (this.f == this) {
            sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f119c);
            sb.append(", RESOLVED: ");
            sb.append(this.g);
            str = "]  type: ";
        } else {
            sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f119c);
            sb.append(", RESOLVED: ");
            sb.append(this.f);
            sb.append(":");
            sb.append(this.g);
            str = "] type: ";
        }
        sb.append(str);
        sb.append(m(this.h));
        return sb.toString();
    }
}
