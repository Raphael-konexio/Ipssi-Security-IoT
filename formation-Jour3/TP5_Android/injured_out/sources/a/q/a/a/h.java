package a.q.a.a;

import a.g.d.c;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class h extends a.q.a.a.g {
    static final PorterDuff.Mode o = PorterDuff.Mode.SRC_IN;
    private C0030h g;
    private PorterDuffColorFilter h;
    private ColorFilter i;
    private boolean j;
    private boolean k;
    private final float[] l;
    private final Matrix m;
    private final Rect n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends f {
        b() {
        }

        b(b bVar) {
            super(bVar);
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f443b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f442a = a.g.d.c.d(string2);
            }
            this.f444c = androidx.core.content.d.g.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // a.q.a.a.h.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (androidx.core.content.d.g.j(xmlPullParser, "pathData")) {
                TypedArray k = androidx.core.content.d.g.k(resources, theme, attributeSet, a.q.a.a.a.f428d);
                f(k, xmlPullParser);
                k.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends f {
        private int[] e;
        androidx.core.content.d.b f;
        float g;
        androidx.core.content.d.b h;
        float i;
        float j;
        float k;
        float l;
        float m;
        Paint.Cap n;
        Paint.Join o;
        float p;

        c() {
            this.g = 0.0f;
            this.i = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        c(c cVar) {
            super(cVar);
            this.g = 0.0f;
            this.i = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.i = cVar.i;
            this.h = cVar.h;
            this.f444c = cVar.f444c;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }

        private Paint.Cap e(int i, Paint.Cap cap) {
            return i != 0 ? i != 1 ? i != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join f(int i, Paint.Join join) {
            return i != 0 ? i != 1 ? i != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.e = null;
            if (androidx.core.content.d.g.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f443b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f442a = a.g.d.c.d(string2);
                }
                this.h = androidx.core.content.d.g.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.j = androidx.core.content.d.g.f(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
                this.n = e(androidx.core.content.d.g.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = f(androidx.core.content.d.g.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = androidx.core.content.d.g.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.f = androidx.core.content.d.g.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.i = androidx.core.content.d.g.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.i);
                this.g = androidx.core.content.d.g.f(typedArray, xmlPullParser, "strokeWidth", 4, this.g);
                this.l = androidx.core.content.d.g.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = androidx.core.content.d.g.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.k = androidx.core.content.d.g.f(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
                this.f444c = androidx.core.content.d.g.g(typedArray, xmlPullParser, "fillType", 13, this.f444c);
            }
        }

        @Override // a.q.a.a.h.e
        public boolean a() {
            return this.h.i() || this.f.i();
        }

        @Override // a.q.a.a.h.e
        public boolean b(int[] iArr) {
            return this.f.j(iArr) | this.h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k = androidx.core.content.d.g.k(resources, theme, attributeSet, a.q.a.a.a.f427c);
            h(k, xmlPullParser, theme);
            k.recycle();
        }

        float getFillAlpha() {
            return this.j;
        }

        int getFillColor() {
            return this.h.e();
        }

        float getStrokeAlpha() {
            return this.i;
        }

        int getStrokeColor() {
            return this.f.e();
        }

        float getStrokeWidth() {
            return this.g;
        }

        float getTrimPathEnd() {
            return this.l;
        }

        float getTrimPathOffset() {
            return this.m;
        }

        float getTrimPathStart() {
            return this.k;
        }

        void setFillAlpha(float f) {
            this.j = f;
        }

        void setFillColor(int i) {
            this.h.k(i);
        }

        void setStrokeAlpha(float f) {
            this.i = f;
        }

        void setStrokeColor(int i) {
            this.f.k(i);
        }

        void setStrokeWidth(float f) {
            this.g = f;
        }

        void setTrimPathEnd(float f) {
            this.l = f;
        }

        void setTrimPathOffset(float f) {
            this.m = f;
        }

        void setTrimPathStart(float f) {
            this.k = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f438a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<e> f439b;

        /* renamed from: c  reason: collision with root package name */
        float f440c;

        /* renamed from: d  reason: collision with root package name */
        private float f441d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        final Matrix j;
        int k;
        private int[] l;
        private String m;

        public d() {
            super();
            this.f438a = new Matrix();
            this.f439b = new ArrayList<>();
            this.f440c = 0.0f;
            this.f441d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }

        public d(d dVar, a.d.a<String, Object> aVar) {
            super();
            f bVar;
            this.f438a = new Matrix();
            this.f439b = new ArrayList<>();
            this.f440c = 0.0f;
            this.f441d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
            this.f440c = dVar.f440c;
            this.f441d = dVar.f441d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.g = dVar.g;
            this.h = dVar.h;
            this.i = dVar.i;
            this.l = dVar.l;
            String str = dVar.m;
            this.m = str;
            this.k = dVar.k;
            if (str != null) {
                aVar.put(str, this);
            }
            this.j.set(dVar.j);
            ArrayList<e> arrayList = dVar.f439b;
            for (int i = 0; i < arrayList.size(); i++) {
                e eVar = arrayList.get(i);
                if (eVar instanceof d) {
                    this.f439b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else if (!(eVar instanceof b)) {
                        throw new IllegalStateException("Unknown object in the tree!");
                    } else {
                        bVar = new b((b) eVar);
                    }
                    this.f439b.add(bVar);
                    String str2 = bVar.f443b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        private void d() {
            this.j.reset();
            this.j.postTranslate(-this.f441d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.f440c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.f441d, this.i + this.e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f440c = androidx.core.content.d.g.f(typedArray, xmlPullParser, "rotation", 5, this.f440c);
            this.f441d = typedArray.getFloat(1, this.f441d);
            this.e = typedArray.getFloat(2, this.e);
            this.f = androidx.core.content.d.g.f(typedArray, xmlPullParser, "scaleX", 3, this.f);
            this.g = androidx.core.content.d.g.f(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = androidx.core.content.d.g.f(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = androidx.core.content.d.g.f(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            d();
        }

        @Override // a.q.a.a.h.e
        public boolean a() {
            for (int i = 0; i < this.f439b.size(); i++) {
                if (this.f439b.get(i).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // a.q.a.a.h.e
        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.f439b.size(); i++) {
                z |= this.f439b.get(i).b(iArr);
            }
            return z;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k = androidx.core.content.d.g.k(resources, theme, attributeSet, a.q.a.a.a.f426b);
            e(k, xmlPullParser);
            k.recycle();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.f441d;
        }

        public float getPivotY() {
            return this.e;
        }

        public float getRotation() {
            return this.f440c;
        }

        public float getScaleX() {
            return this.f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f) {
            if (f != this.f441d) {
                this.f441d = f;
                d();
            }
        }

        public void setPivotY(float f) {
            if (f != this.e) {
                this.e = f;
                d();
            }
        }

        public void setRotation(float f) {
            if (f != this.f440c) {
                this.f440c = f;
                d();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f) {
                this.f = f;
                d();
            }
        }

        public void setScaleY(float f) {
            if (f != this.g) {
                this.g = f;
                d();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.h) {
                this.h = f;
                d();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.i) {
                this.i = f;
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class f extends e {

        /* renamed from: a  reason: collision with root package name */
        protected c.b[] f442a;

        /* renamed from: b  reason: collision with root package name */
        String f443b;

        /* renamed from: c  reason: collision with root package name */
        int f444c;

        /* renamed from: d  reason: collision with root package name */
        int f445d;

        public f() {
            super();
            this.f442a = null;
            this.f444c = 0;
        }

        public f(f fVar) {
            super();
            this.f442a = null;
            this.f444c = 0;
            this.f443b = fVar.f443b;
            this.f445d = fVar.f445d;
            this.f442a = a.g.d.c.f(fVar.f442a);
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            c.b[] bVarArr = this.f442a;
            if (bVarArr != null) {
                c.b.e(bVarArr, path);
            }
        }

        public c.b[] getPathData() {
            return this.f442a;
        }

        public String getPathName() {
            return this.f443b;
        }

        public void setPathData(c.b[] bVarArr) {
            if (a.g.d.c.b(this.f442a, bVarArr)) {
                a.g.d.c.j(this.f442a, bVarArr);
            } else {
                this.f442a = a.g.d.c.f(bVarArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final Matrix q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        private final Path f446a;

        /* renamed from: b  reason: collision with root package name */
        private final Path f447b;

        /* renamed from: c  reason: collision with root package name */
        private final Matrix f448c;

        /* renamed from: d  reason: collision with root package name */
        Paint f449d;
        Paint e;
        private PathMeasure f;
        private int g;
        final d h;
        float i;
        float j;
        float k;
        float l;
        int m;
        String n;
        Boolean o;
        final a.d.a<String, Object> p;

        public g() {
            this.f448c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new a.d.a<>();
            this.h = new d();
            this.f446a = new Path();
            this.f447b = new Path();
        }

        public g(g gVar) {
            this.f448c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            a.d.a<String, Object> aVar = new a.d.a<>();
            this.p = aVar;
            this.h = new d(gVar.h, aVar);
            this.f446a = new Path(gVar.f446a);
            this.f447b = new Path(gVar.f447b);
            this.i = gVar.i;
            this.j = gVar.j;
            this.k = gVar.k;
            this.l = gVar.l;
            this.g = gVar.g;
            this.m = gVar.m;
            this.n = gVar.n;
            String str = gVar.n;
            if (str != null) {
                this.p.put(str, this);
            }
            this.o = gVar.o;
        }

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            dVar.f438a.set(matrix);
            dVar.f438a.preConcat(dVar.j);
            canvas.save();
            for (int i3 = 0; i3 < dVar.f439b.size(); i3++) {
                e eVar = dVar.f439b.get(i3);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f438a, canvas, i, i2, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.k;
            float f2 = i2 / this.l;
            float min = Math.min(f, f2);
            Matrix matrix = dVar.f438a;
            this.f448c.set(matrix);
            this.f448c.postScale(f, f2);
            float e = e(matrix);
            if (e == 0.0f) {
                return;
            }
            fVar.d(this.f446a);
            Path path = this.f446a;
            this.f447b.reset();
            if (fVar.c()) {
                this.f447b.setFillType(fVar.f444c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f447b.addPath(path, this.f448c);
                canvas.clipPath(this.f447b);
                return;
            }
            c cVar = (c) fVar;
            if (cVar.k != 0.0f || cVar.l != 1.0f) {
                float f3 = cVar.k;
                float f4 = cVar.m;
                float f5 = (f3 + f4) % 1.0f;
                float f6 = (cVar.l + f4) % 1.0f;
                if (this.f == null) {
                    this.f = new PathMeasure();
                }
                this.f.setPath(this.f446a, false);
                float length = this.f.getLength();
                float f7 = f5 * length;
                float f8 = f6 * length;
                path.reset();
                if (f7 > f8) {
                    this.f.getSegment(f7, length, path, true);
                    this.f.getSegment(0.0f, f8, path, true);
                } else {
                    this.f.getSegment(f7, f8, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f447b.addPath(path, this.f448c);
            if (cVar.h.l()) {
                androidx.core.content.d.b bVar = cVar.h;
                if (this.e == null) {
                    Paint paint = new Paint(1);
                    this.e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.e;
                if (bVar.h()) {
                    Shader f9 = bVar.f();
                    f9.setLocalMatrix(this.f448c);
                    paint2.setShader(f9);
                    paint2.setAlpha(Math.round(cVar.j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(h.a(bVar.e(), cVar.j));
                }
                paint2.setColorFilter(colorFilter);
                this.f447b.setFillType(cVar.f444c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f447b, paint2);
            }
            if (cVar.f.l()) {
                androidx.core.content.d.b bVar2 = cVar.f;
                if (this.f449d == null) {
                    Paint paint3 = new Paint(1);
                    this.f449d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f449d;
                Paint.Join join = cVar.o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.p);
                if (bVar2.h()) {
                    Shader f10 = bVar2.f();
                    f10.setLocalMatrix(this.f448c);
                    paint4.setShader(f10);
                    paint4.setAlpha(Math.round(cVar.i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(h.a(bVar2.e(), cVar.i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.g * min * e);
                canvas.drawPath(this.f447b, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c(this.h, q, canvas, i, i2, colorFilter);
        }

        public boolean f() {
            if (this.o == null) {
                this.o = Boolean.valueOf(this.h.a());
            }
            return this.o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.m = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a.q.a.a.h$h  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0030h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f450a;

        /* renamed from: b  reason: collision with root package name */
        g f451b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f452c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f453d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public C0030h() {
            this.f452c = null;
            this.f453d = h.o;
            this.f451b = new g();
        }

        public C0030h(C0030h c0030h) {
            this.f452c = null;
            this.f453d = h.o;
            if (c0030h != null) {
                this.f450a = c0030h.f450a;
                g gVar = new g(c0030h.f451b);
                this.f451b = gVar;
                if (c0030h.f451b.e != null) {
                    gVar.e = new Paint(c0030h.f451b.e);
                }
                if (c0030h.f451b.f449d != null) {
                    this.f451b.f449d = new Paint(c0030h.f451b.f449d);
                }
                this.f452c = c0030h.f452c;
                this.f453d = c0030h.f453d;
                this.e = c0030h.e;
            }
        }

        public boolean a(int i, int i2) {
            return i == this.f.getWidth() && i2 == this.f.getHeight();
        }

        public boolean b() {
            return !this.k && this.g == this.f452c && this.h == this.f453d && this.j == this.e && this.i == this.f451b.getRootAlpha();
        }

        public void c(int i, int i2) {
            if (this.f == null || !a(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (f() || colorFilter != null) {
                if (this.l == null) {
                    Paint paint = new Paint();
                    this.l = paint;
                    paint.setFilterBitmap(true);
                }
                this.l.setAlpha(this.f451b.getRootAlpha());
                this.l.setColorFilter(colorFilter);
                return this.l;
            }
            return null;
        }

        public boolean f() {
            return this.f451b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f451b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f450a;
        }

        public boolean h(int[] iArr) {
            boolean g = this.f451b.g(iArr);
            this.k |= g;
            return g;
        }

        public void i() {
            this.g = this.f452c;
            this.h = this.f453d;
            this.i = this.f451b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        public void j(int i, int i2) {
            this.f.eraseColor(0);
            this.f451b.b(new Canvas(this.f), i, i2, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new h(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new h(this);
        }
    }

    /* loaded from: classes.dex */
    private static class i extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f454a;

        public i(Drawable.ConstantState constantState) {
            this.f454a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f454a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f454a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h hVar = new h();
            hVar.f = (VectorDrawable) this.f454a.newDrawable();
            return hVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            h hVar = new h();
            hVar.f = (VectorDrawable) this.f454a.newDrawable(resources);
            return hVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            h hVar = new h();
            hVar.f = (VectorDrawable) this.f454a.newDrawable(resources, theme);
            return hVar;
        }
    }

    h() {
        this.k = true;
        this.l = new float[9];
        this.m = new Matrix();
        this.n = new Rect();
        this.g = new C0030h();
    }

    h(C0030h c0030h) {
        this.k = true;
        this.l = new float[9];
        this.m = new Matrix();
        this.n = new Rect();
        this.g = c0030h;
        this.h = j(this.h, c0030h.f452c, c0030h.f453d);
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (Color.alpha(i2) * f2)) << 24);
    }

    public static h b(Resources resources, int i2, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            h hVar = new h();
            hVar.f = androidx.core.content.d.f.d(resources, i2, theme);
            new i(hVar.f.getConstantState());
            return hVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next == 2) {
                return c(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static h c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        h hVar = new h();
        hVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return hVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int i2;
        int i3;
        b bVar;
        C0030h c0030h = this.g;
        g gVar = c0030h.f451b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f439b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.p.put(cVar.getPathName(), cVar);
                    }
                    z = false;
                    bVar = cVar;
                } else if ("clip-path".equals(name)) {
                    b bVar2 = new b();
                    bVar2.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f439b.add(bVar2);
                    String pathName = bVar2.getPathName();
                    bVar = bVar2;
                    if (pathName != null) {
                        gVar.p.put(bVar2.getPathName(), bVar2);
                        bVar = bVar2;
                    }
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f439b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.p.put(dVar2.getGroupName(), dVar2);
                    }
                    i2 = c0030h.f450a;
                    i3 = dVar2.k;
                    c0030h.f450a = i3 | i2;
                }
                i2 = c0030h.f450a;
                i3 = bVar.f445d;
                c0030h.f450a = i3 | i2;
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && androidx.core.graphics.drawable.a.f(this) == 1;
    }

    private static PorterDuff.Mode g(int i2, PorterDuff.Mode mode) {
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 != 9) {
                    switch (i2) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        C0030h c0030h = this.g;
        g gVar = c0030h.f451b;
        c0030h.f453d = g(androidx.core.content.d.g.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList c2 = androidx.core.content.d.g.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (c2 != null) {
            c0030h.f452c = c2;
        }
        c0030h.e = androidx.core.content.d.g.a(typedArray, xmlPullParser, "autoMirrored", 5, c0030h.e);
        gVar.k = androidx.core.content.d.g.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.k);
        float f2 = androidx.core.content.d.g.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.l);
        gVar.l = f2;
        if (gVar.k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (f2 <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            gVar.i = typedArray.getDimension(3, gVar.i);
            float dimension = typedArray.getDimension(2, gVar.j);
            gVar.j = dimension;
            if (gVar.i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                gVar.setAlpha(androidx.core.content.d.g.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.n = string;
                    gVar.p.put(string, gVar);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.b(drawable);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object d(String str) {
        return this.g.f451b.p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.n);
        if (this.n.width() <= 0 || this.n.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.i;
        if (colorFilter == null) {
            colorFilter = this.h;
        }
        canvas.getMatrix(this.m);
        this.m.getValues(this.l);
        float abs = Math.abs(this.l[0]);
        float abs2 = Math.abs(this.l[4]);
        float abs3 = Math.abs(this.l[1]);
        float abs4 = Math.abs(this.l[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.n.width() * abs));
        int min2 = Math.min(2048, (int) (this.n.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.n;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.n.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.n.offsetTo(0, 0);
        this.g.c(min, min2);
        if (!this.k) {
            this.g.j(min, min2);
        } else if (!this.g.b()) {
            this.g.j(min, min2);
            this.g.i();
        }
        this.g.d(canvas, colorFilter, this.n);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.g.f451b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.g.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f;
        return drawable != null ? androidx.core.graphics.drawable.a.e(drawable) : this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f == null || Build.VERSION.SDK_INT < 24) {
            this.g.f450a = getChangingConfigurations();
            return this.g;
        }
        return new i(this.f.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.g.f451b.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.g.f451b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(boolean z) {
        this.k = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0030h c0030h = this.g;
        c0030h.f451b = new g();
        TypedArray k = androidx.core.content.d.g.k(resources, theme, attributeSet, a.q.a.a.a.f425a);
        i(k, xmlPullParser, theme);
        k.recycle();
        c0030h.f450a = getChangingConfigurations();
        c0030h.k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.h = j(this.h, c0030h.f452c, c0030h.f453d);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f;
        return drawable != null ? androidx.core.graphics.drawable.a.h(drawable) : this.g.e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        C0030h c0030h;
        ColorStateList colorStateList;
        Drawable drawable = this.f;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((c0030h = this.g) != null && (c0030h.g() || ((colorStateList = this.g.f452c) != null && colorStateList.isStateful())));
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.j && super.mutate() == this) {
            this.g = new C0030h(this.g);
            this.j = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        C0030h c0030h = this.g;
        ColorStateList colorStateList = c0030h.f452c;
        if (colorStateList != null && (mode = c0030h.f453d) != null) {
            this.h = j(this.h, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (c0030h.g() && c0030h.h(iArr)) {
            invalidateSelf();
            return true;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.g.f451b.getRootAlpha() != i2) {
            this.g.f451b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z);
        } else {
            this.g.e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.i = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            return;
        }
        C0030h c0030h = this.g;
        if (c0030h.f452c != colorStateList) {
            c0030h.f452c = colorStateList;
            this.h = j(this.h, colorStateList, c0030h.f453d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
            return;
        }
        C0030h c0030h = this.g;
        if (c0030h.f453d != mode) {
            c0030h.f453d = mode;
            this.h = j(this.h, c0030h.f452c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
