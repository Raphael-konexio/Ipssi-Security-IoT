package a.e.a.j;

import a.e.a.j.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    protected f f98a;

    /* renamed from: b  reason: collision with root package name */
    protected f f99b;

    /* renamed from: c  reason: collision with root package name */
    protected f f100c;

    /* renamed from: d  reason: collision with root package name */
    protected f f101d;
    protected f e;
    protected f f;
    protected f g;
    protected ArrayList<f> h;
    protected int i;
    protected int j;
    protected float k = 0.0f;
    private int l;
    private boolean m;
    protected boolean n;
    protected boolean o;
    protected boolean p;
    private boolean q;

    public d(f fVar, int i, boolean z) {
        this.m = false;
        this.f98a = fVar;
        this.l = i;
        this.m = z;
    }

    private void b() {
        int i = this.l * 2;
        f fVar = this.f98a;
        boolean z = false;
        f fVar2 = fVar;
        boolean z2 = false;
        while (!z2) {
            this.i++;
            f[] fVarArr = fVar.i0;
            int i2 = this.l;
            f fVar3 = null;
            fVarArr[i2] = null;
            fVar.h0[i2] = null;
            if (fVar.C() != 8) {
                if (this.f99b == null) {
                    this.f99b = fVar;
                }
                this.f101d = fVar;
                f.b[] bVarArr = fVar.C;
                int i3 = this.l;
                if (bVarArr[i3] == f.b.MATCH_CONSTRAINT) {
                    int[] iArr = fVar.g;
                    if (iArr[i3] == 0 || iArr[i3] == 3 || iArr[i3] == 2) {
                        this.j++;
                        float[] fArr = fVar.g0;
                        int i4 = this.l;
                        float f = fArr[i4];
                        if (f > 0.0f) {
                            this.k += fArr[i4];
                        }
                        if (c(fVar, this.l)) {
                            if (f < 0.0f) {
                                this.n = true;
                            } else {
                                this.o = true;
                            }
                            if (this.h == null) {
                                this.h = new ArrayList<>();
                            }
                            this.h.add(fVar);
                        }
                        if (this.f == null) {
                            this.f = fVar;
                        }
                        f fVar4 = this.g;
                        if (fVar4 != null) {
                            fVar4.h0[this.l] = fVar;
                        }
                        this.g = fVar;
                    }
                }
            }
            if (fVar2 != fVar) {
                fVar2.i0[this.l] = fVar;
            }
            e eVar = fVar.A[i + 1].f105d;
            if (eVar != null) {
                f fVar5 = eVar.f103b;
                e[] eVarArr = fVar5.A;
                if (eVarArr[i].f105d != null && eVarArr[i].f105d.f103b == fVar) {
                    fVar3 = fVar5;
                }
            }
            if (fVar3 == null) {
                fVar3 = fVar;
                z2 = true;
            }
            fVar2 = fVar;
            fVar = fVar3;
        }
        this.f100c = fVar;
        if (this.l == 0 && this.m) {
            this.e = fVar;
        } else {
            this.e = this.f98a;
        }
        if (this.o && this.n) {
            z = true;
        }
        this.p = z;
    }

    private static boolean c(f fVar, int i) {
        if (fVar.C() != 8 && fVar.C[i] == f.b.MATCH_CONSTRAINT) {
            int[] iArr = fVar.g;
            if (iArr[i] == 0 || iArr[i] == 3) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        if (!this.q) {
            b();
        }
        this.q = true;
    }
}
