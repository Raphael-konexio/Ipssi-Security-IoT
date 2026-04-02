package a.e.a;

import a.e.a.e;
import a.e.a.i;
/* loaded from: classes.dex */
public class b implements e.a {

    /* renamed from: c  reason: collision with root package name */
    boolean f79c;

    /* renamed from: d  reason: collision with root package name */
    public final a f80d;

    /* renamed from: a  reason: collision with root package name */
    i f77a = null;

    /* renamed from: b  reason: collision with root package name */
    float f78b = 0.0f;
    boolean e = false;

    public b(c cVar) {
        this.f80d = new a(this, cVar);
    }

    @Override // a.e.a.e.a
    public void a(e.a aVar) {
        if (!(aVar instanceof b)) {
            return;
        }
        b bVar = (b) aVar;
        this.f77a = null;
        this.f80d.c();
        int i = 0;
        while (true) {
            a aVar2 = bVar.f80d;
            if (i >= aVar2.f73a) {
                return;
            }
            this.f80d.a(aVar2.h(i), bVar.f80d.i(i), true);
            i++;
        }
    }

    @Override // a.e.a.e.a
    public void b(i iVar) {
        int i = iVar.f97d;
        float f = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
        }
        this.f80d.l(iVar, f);
    }

    @Override // a.e.a.e.a
    public i c(e eVar, boolean[] zArr) {
        return this.f80d.g(zArr, null);
    }

    @Override // a.e.a.e.a
    public void clear() {
        this.f80d.c();
        this.f77a = null;
        this.f78b = 0.0f;
    }

    public b d(e eVar, int i) {
        this.f80d.l(eVar.p(i, "ep"), 1.0f);
        this.f80d.l(eVar.p(i, "em"), -1.0f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e(i iVar, int i) {
        this.f80d.l(iVar, i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(e eVar) {
        boolean z;
        i b2 = this.f80d.b(eVar);
        if (b2 == null) {
            z = true;
        } else {
            v(b2);
            z = false;
        }
        if (this.f80d.f73a == 0) {
            this.e = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b g(i iVar, i iVar2, int i, float f, i iVar3, i iVar4, int i2) {
        float f2;
        if (iVar2 == iVar3) {
            this.f80d.l(iVar, 1.0f);
            this.f80d.l(iVar4, 1.0f);
            this.f80d.l(iVar2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.f80d.l(iVar, 1.0f);
            this.f80d.l(iVar2, -1.0f);
            this.f80d.l(iVar3, -1.0f);
            this.f80d.l(iVar4, 1.0f);
            if (i > 0 || i2 > 0) {
                f2 = (-i) + i2;
                this.f78b = f2;
            }
        } else {
            if (f <= 0.0f) {
                this.f80d.l(iVar, -1.0f);
                this.f80d.l(iVar2, 1.0f);
                f2 = i;
            } else if (f >= 1.0f) {
                this.f80d.l(iVar3, -1.0f);
                this.f80d.l(iVar4, 1.0f);
                f2 = i2;
            } else {
                float f3 = 1.0f - f;
                this.f80d.l(iVar, f3 * 1.0f);
                this.f80d.l(iVar2, f3 * (-1.0f));
                this.f80d.l(iVar3, (-1.0f) * f);
                this.f80d.l(iVar4, 1.0f * f);
                if (i > 0 || i2 > 0) {
                    f2 = ((-i) * f3) + (i2 * f);
                }
            }
            this.f78b = f2;
        }
        return this;
    }

    @Override // a.e.a.e.a
    public i getKey() {
        return this.f77a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b h(i iVar, int i) {
        this.f77a = iVar;
        float f = i;
        iVar.e = f;
        this.f78b = f;
        this.e = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b i(i iVar, i iVar2, i iVar3, float f) {
        this.f80d.l(iVar, -1.0f);
        this.f80d.l(iVar2, 1.0f - f);
        this.f80d.l(iVar3, f);
        return this;
    }

    public b j(i iVar, i iVar2, i iVar3, i iVar4, float f) {
        this.f80d.l(iVar, -1.0f);
        this.f80d.l(iVar2, 1.0f);
        this.f80d.l(iVar3, f);
        this.f80d.l(iVar4, -f);
        return this;
    }

    public b k(float f, float f2, float f3, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f78b = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.f80d.l(iVar, 1.0f);
            this.f80d.l(iVar2, -1.0f);
            this.f80d.l(iVar4, 1.0f);
            this.f80d.l(iVar3, -1.0f);
        } else if (f == 0.0f) {
            this.f80d.l(iVar, 1.0f);
            this.f80d.l(iVar2, -1.0f);
        } else if (f3 == 0.0f) {
            this.f80d.l(iVar3, 1.0f);
            this.f80d.l(iVar4, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.f80d.l(iVar, 1.0f);
            this.f80d.l(iVar2, -1.0f);
            this.f80d.l(iVar4, f4);
            this.f80d.l(iVar3, -f4);
        }
        return this;
    }

    public b l(i iVar, int i) {
        a aVar;
        float f;
        if (i < 0) {
            this.f78b = i * (-1);
            aVar = this.f80d;
            f = 1.0f;
        } else {
            this.f78b = i;
            aVar = this.f80d;
            f = -1.0f;
        }
        aVar.l(iVar, f);
        return this;
    }

    public b m(i iVar, i iVar2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f78b = i;
        }
        if (z) {
            this.f80d.l(iVar, 1.0f);
            this.f80d.l(iVar2, -1.0f);
        } else {
            this.f80d.l(iVar, -1.0f);
            this.f80d.l(iVar2, 1.0f);
        }
        return this;
    }

    public b n(i iVar, i iVar2, i iVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f78b = i;
        }
        if (z) {
            this.f80d.l(iVar, 1.0f);
            this.f80d.l(iVar2, -1.0f);
            this.f80d.l(iVar3, -1.0f);
        } else {
            this.f80d.l(iVar, -1.0f);
            this.f80d.l(iVar2, 1.0f);
            this.f80d.l(iVar3, 1.0f);
        }
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f78b = i;
        }
        if (z) {
            this.f80d.l(iVar, 1.0f);
            this.f80d.l(iVar2, -1.0f);
            this.f80d.l(iVar3, 1.0f);
        } else {
            this.f80d.l(iVar, -1.0f);
            this.f80d.l(iVar2, 1.0f);
            this.f80d.l(iVar3, -1.0f);
        }
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, i iVar4, float f) {
        this.f80d.l(iVar3, 0.5f);
        this.f80d.l(iVar4, 0.5f);
        this.f80d.l(iVar, -0.5f);
        this.f80d.l(iVar2, -0.5f);
        this.f78b = -f;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        float f = this.f78b;
        if (f < 0.0f) {
            this.f78b = f * (-1.0f);
            this.f80d.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        i iVar = this.f77a;
        return iVar != null && (iVar.g == i.a.UNRESTRICTED || this.f78b >= 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s(i iVar) {
        return this.f80d.d(iVar);
    }

    public boolean t() {
        return this.f77a == null && this.f78b == 0.0f && this.f80d.f73a == 0;
    }

    public String toString() {
        return x();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i u(i iVar) {
        return this.f80d.g(null, iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(i iVar) {
        i iVar2 = this.f77a;
        if (iVar2 != null) {
            this.f80d.l(iVar2, -1.0f);
            this.f77a = null;
        }
        float m = this.f80d.m(iVar, true) * (-1.0f);
        this.f77a = iVar;
        if (m == 1.0f) {
            return;
        }
        this.f78b /= m;
        this.f80d.e(m);
    }

    public void w() {
        this.f77a = null;
        this.f80d.c();
        this.f78b = 0.0f;
        this.e = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.lang.String x() {
        /*
            r10 = this;
            a.e.a.i r0 = r10.f77a
            java.lang.String r1 = ""
            if (r0 != 0) goto L14
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            goto L21
        L14:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            a.e.a.i r1 = r10.f77a
            r0.append(r1)
        L21:
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r10.f78b
            r2 = 0
            r3 = 1
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L52
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.f78b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1
            goto L53
        L52:
            r1 = 0
        L53:
            a.e.a.a r5 = r10.f80d
            int r5 = r5.f73a
        L57:
            if (r2 >= r5) goto Ld0
            a.e.a.a r6 = r10.f80d
            a.e.a.i r6 = r6.h(r2)
            if (r6 != 0) goto L62
            goto Lcd
        L62:
            a.e.a.a r7 = r10.f80d
            float r7 = r7.i(r2)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 != 0) goto L6d
            goto Lcd
        L6d:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L84
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto La9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            goto La0
        L84:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            if (r8 <= 0) goto L98
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto La9
        L98:
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
        La0:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r7 = r7 * r9
        La9:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto Lb5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto Lc2
        Lb5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
        Lc2:
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            r1 = 1
        Lcd:
            int r2 = r2 + 1
            goto L57
        Ld0:
            if (r1 != 0) goto Le3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        Le3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.b.x():java.lang.String");
    }
}
