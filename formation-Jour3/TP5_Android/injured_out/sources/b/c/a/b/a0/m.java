package b.c.a.b.a0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public float f1323a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public float f1324b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public float f1325c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public float f1326d;
    @Deprecated
    public float e;
    @Deprecated
    public float f;
    private final List<f> g = new ArrayList();
    private final List<g> h = new ArrayList();

    /* loaded from: classes.dex */
    class a extends g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f1327b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Matrix f1328c;

        a(m mVar, List list, Matrix matrix) {
            this.f1327b = list;
            this.f1328c = matrix;
        }

        @Override // b.c.a.b.a0.m.g
        public void a(Matrix matrix, b.c.a.b.z.a aVar, int i, Canvas canvas) {
            for (g gVar : this.f1327b) {
                gVar.a(this.f1328c, aVar, i, canvas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends g {

        /* renamed from: b  reason: collision with root package name */
        private final d f1329b;

        public b(d dVar) {
            this.f1329b = dVar;
        }

        @Override // b.c.a.b.a0.m.g
        public void a(Matrix matrix, b.c.a.b.z.a aVar, int i, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f1329b.k(), this.f1329b.o(), this.f1329b.l(), this.f1329b.j()), i, this.f1329b.m(), this.f1329b.n());
        }
    }

    /* loaded from: classes.dex */
    static class c extends g {

        /* renamed from: b  reason: collision with root package name */
        private final e f1330b;

        /* renamed from: c  reason: collision with root package name */
        private final float f1331c;

        /* renamed from: d  reason: collision with root package name */
        private final float f1332d;

        public c(e eVar, float f, float f2) {
            this.f1330b = eVar;
            this.f1331c = f;
            this.f1332d = f2;
        }

        @Override // b.c.a.b.a0.m.g
        public void a(Matrix matrix, b.c.a.b.z.a aVar, int i, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f1330b.f1337c - this.f1332d, this.f1330b.f1336b - this.f1331c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f1331c, this.f1332d);
            matrix2.preRotate(c());
            aVar.b(canvas, matrix2, rectF, i);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f1330b.f1337c - this.f1332d) / (this.f1330b.f1336b - this.f1331c)));
        }
    }

    /* loaded from: classes.dex */
    public static class d extends f {
        private static final RectF h = new RectF();
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public float f1333b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public float f1334c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public float f1335d;
        @Deprecated
        public float e;
        @Deprecated
        public float f;
        @Deprecated
        public float g;

        public d(float f, float f2, float f3, float f4) {
            q(f);
            u(f2);
            r(f3);
            p(f4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f1333b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f1335d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f1334c;
        }

        private void p(float f) {
            this.e = f;
        }

        private void q(float f) {
            this.f1333b = f;
        }

        private void r(float f) {
            this.f1335d = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f) {
            this.f = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f) {
            this.g = f;
        }

        private void u(float f) {
            this.f1334c = f;
        }

        @Override // b.c.a.b.a0.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f1338a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            h.set(k(), o(), l(), j());
            path.arcTo(h, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends f {

        /* renamed from: b  reason: collision with root package name */
        private float f1336b;

        /* renamed from: c  reason: collision with root package name */
        private float f1337c;

        @Override // b.c.a.b.a0.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f1338a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f1336b, this.f1337c);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        protected final Matrix f1338a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class g {

        /* renamed from: a  reason: collision with root package name */
        static final Matrix f1339a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, b.c.a.b.z.a aVar, int i, Canvas canvas);

        public final void b(b.c.a.b.z.a aVar, int i, Canvas canvas) {
            a(f1339a, aVar, i, canvas);
        }
    }

    public m() {
        m(0.0f, 0.0f);
    }

    private void b(float f2) {
        if (f() == f2) {
            return;
        }
        float f3 = ((f2 - f()) + 360.0f) % 360.0f;
        if (f3 > 180.0f) {
            return;
        }
        d dVar = new d(h(), i(), h(), i());
        dVar.s(f());
        dVar.t(f3);
        this.h.add(new b(dVar));
        o(f2);
    }

    private void c(g gVar, float f2, float f3) {
        b(f2);
        this.h.add(gVar);
        o(f3);
    }

    private float f() {
        return this.e;
    }

    private float g() {
        return this.f;
    }

    private void o(float f2) {
        this.e = f2;
    }

    private void p(float f2) {
        this.f = f2;
    }

    private void q(float f2) {
        this.f1325c = f2;
    }

    private void r(float f2) {
        this.f1326d = f2;
    }

    private void s(float f2) {
        this.f1323a = f2;
    }

    private void t(float f2) {
        this.f1324b = f2;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        d dVar = new d(f2, f3, f4, f5);
        dVar.s(f6);
        dVar.t(f7);
        this.g.add(dVar);
        b bVar = new b(dVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        c(bVar, f6, z ? (180.0f + f8) % 360.0f : f8);
        double d2 = f8;
        q(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        r(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.g.get(i).a(matrix, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g e(Matrix matrix) {
        b(g());
        return new a(this, new ArrayList(this.h), matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float h() {
        return this.f1325c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f1326d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f1323a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        return this.f1324b;
    }

    public void l(float f2, float f3) {
        e eVar = new e();
        eVar.f1336b = f2;
        eVar.f1337c = f3;
        this.g.add(eVar);
        c cVar = new c(eVar, h(), i());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        q(f2);
        r(f3);
    }

    public void m(float f2, float f3) {
        n(f2, f3, 270.0f, 0.0f);
    }

    public void n(float f2, float f3, float f4, float f5) {
        s(f2);
        t(f3);
        q(f2);
        r(f3);
        o(f4);
        p((f4 + f5) % 360.0f);
        this.g.clear();
        this.h.clear();
    }
}
