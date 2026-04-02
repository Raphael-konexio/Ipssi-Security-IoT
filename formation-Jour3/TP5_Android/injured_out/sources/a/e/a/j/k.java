package a.e.a.j;

import a.e.a.j.f;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    static boolean[] f118a = new boolean[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01c4, code lost:
        if (r6 != false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01c6, code lost:
        r4.j(r2, 1, r17.w());
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01cf, code lost:
        r4.i(r2, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01e0, code lost:
        if (r6 != false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0070, code lost:
        if (r6 != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0080, code lost:
        if (r6 != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008f, code lost:
        if (r6 != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e9, code lost:
        if (r6 != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00eb, code lost:
        r3.j(r1, 1, r17.x());
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f4, code lost:
        r7 = r17.D();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f8, code lost:
        r3.i(r1, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x010f, code lost:
        if (r6 != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(int r16, a.e.a.j.f r17) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.j.k.a(int, a.e.a.j.f):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r7.e0 == 2) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r7.f0 == 2) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0104 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(a.e.a.j.g r24, a.e.a.e r25, int r26, int r27, a.e.a.j.d r28) {
        /*
            Method dump skipped, instructions count: 903
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.j.k.b(a.e.a.j.g, a.e.a.e, int, int, a.e.a.j.d):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(g gVar, a.e.a.e eVar, f fVar) {
        if (gVar.C[0] != f.b.WRAP_CONTENT && fVar.C[0] == f.b.MATCH_PARENT) {
            int i = fVar.s.e;
            int D = gVar.D() - fVar.u.e;
            e eVar2 = fVar.s;
            eVar2.i = eVar.r(eVar2);
            e eVar3 = fVar.u;
            eVar3.i = eVar.r(eVar3);
            eVar.f(fVar.s.i, i);
            eVar.f(fVar.u.i, D);
            fVar.f107a = 2;
            fVar.f0(i, D);
        }
        if (gVar.C[1] == f.b.WRAP_CONTENT || fVar.C[1] != f.b.MATCH_PARENT) {
            return;
        }
        int i2 = fVar.t.e;
        int r = gVar.r() - fVar.v.e;
        e eVar4 = fVar.t;
        eVar4.i = eVar.r(eVar4);
        e eVar5 = fVar.v;
        eVar5.i = eVar.r(eVar5);
        eVar.f(fVar.t.i, i2);
        eVar.f(fVar.v.i, r);
        if (fVar.Q > 0 || fVar.C() == 8) {
            e eVar6 = fVar.w;
            eVar6.i = eVar.r(eVar6);
            eVar.f(fVar.w.i, fVar.Q + i2);
        }
        fVar.f108b = 2;
        fVar.t0(i2, r);
    }

    private static boolean d(f fVar, int i) {
        f.b[] bVarArr = fVar.C;
        if (bVarArr[i] != f.b.MATCH_CONSTRAINT) {
            return false;
        }
        if (fVar.G != 0.0f) {
            f.b bVar = bVarArr[i != 0 ? (char) 0 : (char) 1];
            f.b bVar2 = f.b.MATCH_CONSTRAINT;
            return false;
        }
        if (i == 0) {
            if (fVar.e != 0 || fVar.h != 0 || fVar.i != 0) {
                return false;
            }
        } else if (fVar.f != 0 || fVar.k != 0 || fVar.l != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(f fVar, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        fVar.A[i3].f().f = fVar.u().s.f();
        fVar.A[i3].f().g = i2;
        fVar.A[i3].f().f123b = 1;
        fVar.A[i4].f().f = fVar.A[i3].f();
        fVar.A[i4].f().g = fVar.t(i);
        fVar.A[i4].f().f123b = 1;
    }
}
