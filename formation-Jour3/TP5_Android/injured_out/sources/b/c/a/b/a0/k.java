package b.c.a.b.a0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
/* loaded from: classes.dex */
public class k {
    public static final b.c.a.b.a0.c m = new i(0.5f);

    /* renamed from: a  reason: collision with root package name */
    d f1307a;

    /* renamed from: b  reason: collision with root package name */
    d f1308b;

    /* renamed from: c  reason: collision with root package name */
    d f1309c;

    /* renamed from: d  reason: collision with root package name */
    d f1310d;
    b.c.a.b.a0.c e;
    b.c.a.b.a0.c f;
    b.c.a.b.a0.c g;
    b.c.a.b.a0.c h;
    f i;
    f j;
    f k;
    f l;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private d f1311a;

        /* renamed from: b  reason: collision with root package name */
        private d f1312b;

        /* renamed from: c  reason: collision with root package name */
        private d f1313c;

        /* renamed from: d  reason: collision with root package name */
        private d f1314d;
        private b.c.a.b.a0.c e;
        private b.c.a.b.a0.c f;
        private b.c.a.b.a0.c g;
        private b.c.a.b.a0.c h;
        private f i;
        private f j;
        private f k;
        private f l;

        public b() {
            this.f1311a = h.b();
            this.f1312b = h.b();
            this.f1313c = h.b();
            this.f1314d = h.b();
            this.e = new b.c.a.b.a0.a(0.0f);
            this.f = new b.c.a.b.a0.a(0.0f);
            this.g = new b.c.a.b.a0.a(0.0f);
            this.h = new b.c.a.b.a0.a(0.0f);
            this.i = h.c();
            this.j = h.c();
            this.k = h.c();
            this.l = h.c();
        }

        public b(k kVar) {
            this.f1311a = h.b();
            this.f1312b = h.b();
            this.f1313c = h.b();
            this.f1314d = h.b();
            this.e = new b.c.a.b.a0.a(0.0f);
            this.f = new b.c.a.b.a0.a(0.0f);
            this.g = new b.c.a.b.a0.a(0.0f);
            this.h = new b.c.a.b.a0.a(0.0f);
            this.i = h.c();
            this.j = h.c();
            this.k = h.c();
            this.l = h.c();
            this.f1311a = kVar.f1307a;
            this.f1312b = kVar.f1308b;
            this.f1313c = kVar.f1309c;
            this.f1314d = kVar.f1310d;
            this.e = kVar.e;
            this.f = kVar.f;
            this.g = kVar.g;
            this.h = kVar.h;
            this.i = kVar.i;
            this.j = kVar.j;
            this.k = kVar.k;
            this.l = kVar.l;
        }

        private static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).f1306a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f1298a;
            }
            return -1.0f;
        }

        public b A(b.c.a.b.a0.c cVar) {
            this.e = cVar;
            return this;
        }

        public b B(int i, b.c.a.b.a0.c cVar) {
            C(h.a(i));
            E(cVar);
            return this;
        }

        public b C(d dVar) {
            this.f1312b = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                D(n);
            }
            return this;
        }

        public b D(float f) {
            this.f = new b.c.a.b.a0.a(f);
            return this;
        }

        public b E(b.c.a.b.a0.c cVar) {
            this.f = cVar;
            return this;
        }

        public k m() {
            return new k(this);
        }

        public b o(float f) {
            z(f);
            D(f);
            v(f);
            r(f);
            return this;
        }

        public b p(int i, b.c.a.b.a0.c cVar) {
            q(h.a(i));
            s(cVar);
            return this;
        }

        public b q(d dVar) {
            this.f1314d = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                r(n);
            }
            return this;
        }

        public b r(float f) {
            this.h = new b.c.a.b.a0.a(f);
            return this;
        }

        public b s(b.c.a.b.a0.c cVar) {
            this.h = cVar;
            return this;
        }

        public b t(int i, b.c.a.b.a0.c cVar) {
            u(h.a(i));
            w(cVar);
            return this;
        }

        public b u(d dVar) {
            this.f1313c = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                v(n);
            }
            return this;
        }

        public b v(float f) {
            this.g = new b.c.a.b.a0.a(f);
            return this;
        }

        public b w(b.c.a.b.a0.c cVar) {
            this.g = cVar;
            return this;
        }

        public b x(int i, b.c.a.b.a0.c cVar) {
            y(h.a(i));
            A(cVar);
            return this;
        }

        public b y(d dVar) {
            this.f1311a = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                z(n);
            }
            return this;
        }

        public b z(float f) {
            this.e = new b.c.a.b.a0.a(f);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        b.c.a.b.a0.c a(b.c.a.b.a0.c cVar);
    }

    public k() {
        this.f1307a = h.b();
        this.f1308b = h.b();
        this.f1309c = h.b();
        this.f1310d = h.b();
        this.e = new b.c.a.b.a0.a(0.0f);
        this.f = new b.c.a.b.a0.a(0.0f);
        this.g = new b.c.a.b.a0.a(0.0f);
        this.h = new b.c.a.b.a0.a(0.0f);
        this.i = h.c();
        this.j = h.c();
        this.k = h.c();
        this.l = h.c();
    }

    private k(b bVar) {
        this.f1307a = bVar.f1311a;
        this.f1308b = bVar.f1312b;
        this.f1309c = bVar.f1313c;
        this.f1310d = bVar.f1314d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i, int i2) {
        return c(context, i, i2, 0);
    }

    private static b c(Context context, int i, int i2, int i3) {
        return d(context, i, i2, new b.c.a.b.a0.a(i3));
    }

    private static b d(Context context, int i, int i2, b.c.a.b.a0.c cVar) {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, b.c.a.b.k.ShapeAppearance);
        try {
            int i3 = obtainStyledAttributes.getInt(b.c.a.b.k.ShapeAppearance_cornerFamily, 0);
            int i4 = obtainStyledAttributes.getInt(b.c.a.b.k.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = obtainStyledAttributes.getInt(b.c.a.b.k.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = obtainStyledAttributes.getInt(b.c.a.b.k.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = obtainStyledAttributes.getInt(b.c.a.b.k.ShapeAppearance_cornerFamilyBottomLeft, i3);
            b.c.a.b.a0.c m2 = m(obtainStyledAttributes, b.c.a.b.k.ShapeAppearance_cornerSize, cVar);
            b.c.a.b.a0.c m3 = m(obtainStyledAttributes, b.c.a.b.k.ShapeAppearance_cornerSizeTopLeft, m2);
            b.c.a.b.a0.c m4 = m(obtainStyledAttributes, b.c.a.b.k.ShapeAppearance_cornerSizeTopRight, m2);
            b.c.a.b.a0.c m5 = m(obtainStyledAttributes, b.c.a.b.k.ShapeAppearance_cornerSizeBottomRight, m2);
            b.c.a.b.a0.c m6 = m(obtainStyledAttributes, b.c.a.b.k.ShapeAppearance_cornerSizeBottomLeft, m2);
            b bVar = new b();
            bVar.x(i4, m3);
            bVar.B(i5, m4);
            bVar.t(i6, m5);
            bVar.p(i7, m6);
            return bVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i, int i2) {
        return f(context, attributeSet, i, i2, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        return g(context, attributeSet, i, i2, new b.c.a.b.a0.a(i3));
    }

    public static b g(Context context, AttributeSet attributeSet, int i, int i2, b.c.a.b.a0.c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.c.a.b.k.MaterialShape, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(b.c.a.b.k.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(b.c.a.b.k.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    private static b.c.a.b.a0.c m(TypedArray typedArray, int i, b.c.a.b.a0.c cVar) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return cVar;
        }
        int i2 = peekValue.type;
        return i2 == 5 ? new b.c.a.b.a0.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i2 == 6 ? new i(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public f h() {
        return this.k;
    }

    public d i() {
        return this.f1310d;
    }

    public b.c.a.b.a0.c j() {
        return this.h;
    }

    public d k() {
        return this.f1309c;
    }

    public b.c.a.b.a0.c l() {
        return this.g;
    }

    public f n() {
        return this.l;
    }

    public f o() {
        return this.j;
    }

    public f p() {
        return this.i;
    }

    public d q() {
        return this.f1307a;
    }

    public b.c.a.b.a0.c r() {
        return this.e;
    }

    public d s() {
        return this.f1308b;
    }

    public b.c.a.b.a0.c t() {
        return this.f;
    }

    public boolean u(RectF rectF) {
        boolean z = this.l.getClass().equals(f.class) && this.j.getClass().equals(f.class) && this.i.getClass().equals(f.class) && this.k.getClass().equals(f.class);
        float a2 = this.e.a(rectF);
        return z && ((this.f.a(rectF) > a2 ? 1 : (this.f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.h.a(rectF) > a2 ? 1 : (this.h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.g.a(rectF) > a2 ? 1 : (this.g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.f1308b instanceof j) && (this.f1307a instanceof j) && (this.f1309c instanceof j) && (this.f1310d instanceof j));
    }

    public b v() {
        return new b(this);
    }

    public k w(float f) {
        b v = v();
        v.o(f);
        return v.m();
    }

    public k x(c cVar) {
        b v = v();
        v.A(cVar.a(r()));
        v.E(cVar.a(t()));
        v.s(cVar.a(j()));
        v.w(cVar.a(l()));
        return v.m();
    }
}
