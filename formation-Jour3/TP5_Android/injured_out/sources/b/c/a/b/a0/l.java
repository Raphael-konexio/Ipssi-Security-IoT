package b.c.a.b.a0;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final m[] f1315a = new m[4];

    /* renamed from: b  reason: collision with root package name */
    private final Matrix[] f1316b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix[] f1317c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    private final PointF f1318d = new PointF();
    private final m e = new m();
    private final float[] f = new float[2];
    private final float[] g = new float[2];

    /* loaded from: classes.dex */
    public interface a {
        void a(m mVar, Matrix matrix, int i);

        void b(m mVar, Matrix matrix, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final k f1319a;

        /* renamed from: b  reason: collision with root package name */
        public final Path f1320b;

        /* renamed from: c  reason: collision with root package name */
        public final RectF f1321c;

        /* renamed from: d  reason: collision with root package name */
        public final a f1322d;
        public final float e;

        b(k kVar, float f, RectF rectF, a aVar, Path path) {
            this.f1322d = aVar;
            this.f1319a = kVar;
            this.e = f;
            this.f1321c = rectF;
            this.f1320b = path;
        }
    }

    public l() {
        for (int i = 0; i < 4; i++) {
            this.f1315a[i] = new m();
            this.f1316b[i] = new Matrix();
            this.f1317c[i] = new Matrix();
        }
    }

    private float a(int i) {
        return (i + 1) * 90;
    }

    private void b(b bVar, int i) {
        this.f[0] = this.f1315a[i].j();
        this.f[1] = this.f1315a[i].k();
        this.f1316b[i].mapPoints(this.f);
        Path path = bVar.f1320b;
        float[] fArr = this.f;
        if (i == 0) {
            path.moveTo(fArr[0], fArr[1]);
        } else {
            path.lineTo(fArr[0], fArr[1]);
        }
        this.f1315a[i].d(this.f1316b[i], bVar.f1320b);
        a aVar = bVar.f1322d;
        if (aVar != null) {
            aVar.b(this.f1315a[i], this.f1316b[i], i);
        }
    }

    private void c(b bVar, int i) {
        int i2 = (i + 1) % 4;
        this.f[0] = this.f1315a[i].h();
        this.f[1] = this.f1315a[i].i();
        this.f1316b[i].mapPoints(this.f);
        this.g[0] = this.f1315a[i2].j();
        this.g[1] = this.f1315a[i2].k();
        this.f1316b[i2].mapPoints(this.g);
        float[] fArr = this.f;
        float f = fArr[0];
        float[] fArr2 = this.g;
        float max = Math.max(((float) Math.hypot(f - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float i3 = i(bVar.f1321c, i);
        this.e.m(0.0f, 0.0f);
        j(i, bVar.f1319a).a(max, i3, bVar.e, this.e);
        this.e.d(this.f1317c[i], bVar.f1320b);
        a aVar = bVar.f1322d;
        if (aVar != null) {
            aVar.a(this.e, this.f1317c[i], i);
        }
    }

    private void f(int i, RectF rectF, PointF pointF) {
        float f;
        float f2;
        if (i == 1) {
            f = rectF.right;
        } else if (i != 2) {
            f = i != 3 ? rectF.right : rectF.left;
            f2 = rectF.top;
            pointF.set(f, f2);
        } else {
            f = rectF.left;
        }
        f2 = rectF.bottom;
        pointF.set(f, f2);
    }

    private c g(int i, k kVar) {
        return i != 1 ? i != 2 ? i != 3 ? kVar.t() : kVar.r() : kVar.j() : kVar.l();
    }

    private d h(int i, k kVar) {
        return i != 1 ? i != 2 ? i != 3 ? kVar.s() : kVar.q() : kVar.i() : kVar.k();
    }

    private float i(RectF rectF, int i) {
        float centerX;
        float f;
        float[] fArr = this.f;
        m[] mVarArr = this.f1315a;
        fArr[0] = mVarArr[i].f1325c;
        fArr[1] = mVarArr[i].f1326d;
        this.f1316b[i].mapPoints(fArr);
        if (i == 1 || i == 3) {
            centerX = rectF.centerX();
            f = this.f[0];
        } else {
            centerX = rectF.centerY();
            f = this.f[1];
        }
        return Math.abs(centerX - f);
    }

    private f j(int i, k kVar) {
        return i != 1 ? i != 2 ? i != 3 ? kVar.o() : kVar.p() : kVar.n() : kVar.h();
    }

    private void k(b bVar, int i) {
        h(i, bVar.f1319a).b(this.f1315a[i], 90.0f, bVar.e, bVar.f1321c, g(i, bVar.f1319a));
        float a2 = a(i);
        this.f1316b[i].reset();
        f(i, bVar.f1321c, this.f1318d);
        Matrix matrix = this.f1316b[i];
        PointF pointF = this.f1318d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f1316b[i].preRotate(a2);
    }

    private void l(int i) {
        this.f[0] = this.f1315a[i].h();
        this.f[1] = this.f1315a[i].i();
        this.f1316b[i].mapPoints(this.f);
        float a2 = a(i);
        this.f1317c[i].reset();
        Matrix matrix = this.f1317c[i];
        float[] fArr = this.f;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f1317c[i].preRotate(a2);
    }

    public void d(k kVar, float f, RectF rectF, Path path) {
        e(kVar, f, rectF, null, path);
    }

    public void e(k kVar, float f, RectF rectF, a aVar, Path path) {
        path.rewind();
        b bVar = new b(kVar, f, rectF, aVar, path);
        for (int i = 0; i < 4; i++) {
            k(bVar, i);
            l(i);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            b(bVar, i2);
            c(bVar, i2);
        }
        path.close();
    }
}
