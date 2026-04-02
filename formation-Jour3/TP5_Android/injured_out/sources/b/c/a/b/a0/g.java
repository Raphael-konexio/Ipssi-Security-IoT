package b.c.a.b.a0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import b.c.a.b.a0.k;
import b.c.a.b.a0.l;
import b.c.a.b.a0.m;
/* loaded from: classes.dex */
public class g extends Drawable implements androidx.core.graphics.drawable.b, n {
    private static final Paint A = new Paint(1);
    private c f;
    private final m.g[] g;
    private final m.g[] h;
    private boolean i;
    private final Matrix j;
    private final Path k;
    private final Path l;
    private final RectF m;
    private final RectF n;
    private final Region o;
    private final Region p;
    private k q;
    private final Paint r;
    private final Paint s;
    private final b.c.a.b.z.a t;
    private final l.a u;
    private final l v;
    private PorterDuffColorFilter w;
    private PorterDuffColorFilter x;
    private Rect y;
    private final RectF z;

    /* loaded from: classes.dex */
    class a implements l.a {
        a() {
        }

        @Override // b.c.a.b.a0.l.a
        public void a(m mVar, Matrix matrix, int i) {
            g.this.h[i] = mVar.e(matrix);
        }

        @Override // b.c.a.b.a0.l.a
        public void b(m mVar, Matrix matrix, int i) {
            g.this.g[i] = mVar.e(matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements k.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f1300a;

        b(g gVar, float f) {
            this.f1300a = f;
        }

        @Override // b.c.a.b.a0.k.c
        public b.c.a.b.a0.c a(b.c.a.b.a0.c cVar) {
            return cVar instanceof i ? cVar : new b.c.a.b.a0.b(this.f1300a, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public k f1301a;

        /* renamed from: b  reason: collision with root package name */
        public b.c.a.b.t.a f1302b;

        /* renamed from: c  reason: collision with root package name */
        public ColorFilter f1303c;

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f1304d;
        public ColorStateList e;
        public ColorStateList f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public Rect i;
        public float j;
        public float k;
        public float l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public c(c cVar) {
            this.f1304d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.f1301a = cVar.f1301a;
            this.f1302b = cVar.f1302b;
            this.l = cVar.l;
            this.f1303c = cVar.f1303c;
            this.f1304d = cVar.f1304d;
            this.e = cVar.e;
            this.h = cVar.h;
            this.g = cVar.g;
            this.m = cVar.m;
            this.j = cVar.j;
            this.s = cVar.s;
            this.q = cVar.q;
            this.u = cVar.u;
            this.k = cVar.k;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
            this.r = cVar.r;
            this.t = cVar.t;
            this.f = cVar.f;
            this.v = cVar.v;
            if (cVar.i != null) {
                this.i = new Rect(cVar.i);
            }
        }

        public c(k kVar, b.c.a.b.t.a aVar) {
            this.f1304d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.f1301a = kVar;
            this.f1302b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this, null);
            gVar.i = true;
            return gVar;
        }
    }

    public g() {
        this(new k());
    }

    public g(Context context, AttributeSet attributeSet, int i, int i2) {
        this(k.e(context, attributeSet, i, i2).m());
    }

    private g(c cVar) {
        this.g = new m.g[4];
        this.h = new m.g[4];
        this.j = new Matrix();
        this.k = new Path();
        this.l = new Path();
        this.m = new RectF();
        this.n = new RectF();
        this.o = new Region();
        this.p = new Region();
        this.r = new Paint(1);
        this.s = new Paint(1);
        this.t = new b.c.a.b.z.a();
        this.v = new l();
        this.z = new RectF();
        this.f = cVar;
        this.s.setStyle(Paint.Style.STROKE);
        this.r.setStyle(Paint.Style.FILL);
        A.setColor(-1);
        A.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        e0();
        d0(getState());
        this.u = new a();
    }

    /* synthetic */ g(c cVar, a aVar) {
        this(cVar);
    }

    public g(k kVar) {
        this(new c(kVar, null));
    }

    private float C() {
        if (K()) {
            return this.s.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean I() {
        c cVar = this.f;
        int i = cVar.q;
        return i != 1 && cVar.r > 0 && (i == 2 || R());
    }

    private boolean J() {
        Paint.Style style = this.f.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean K() {
        Paint.Style style = this.f.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.s.getStrokeWidth() > 0.0f;
    }

    private void M() {
        super.invalidateSelf();
    }

    private static int P(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    private void Q(Canvas canvas) {
        int y = y();
        int z = z();
        if (Build.VERSION.SDK_INT < 21) {
            Rect clipBounds = canvas.getClipBounds();
            int i = this.f.r;
            clipBounds.inset(-i, -i);
            clipBounds.offset(y, z);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate(y, z);
    }

    private boolean R() {
        return Build.VERSION.SDK_INT < 21 || !(O() || this.k.isConvex());
    }

    private boolean d0(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f.f1304d == null || color2 == (colorForState2 = this.f.f1304d.getColorForState(iArr, (color2 = this.r.getColor())))) {
            z = false;
        } else {
            this.r.setColor(colorForState2);
            z = true;
        }
        if (this.f.e == null || color == (colorForState = this.f.e.getColorForState(iArr, (color = this.s.getColor())))) {
            return z;
        }
        this.s.setColor(colorForState);
        return true;
    }

    private PorterDuffColorFilter e(Paint paint, boolean z) {
        int color;
        int k;
        if (!z || (k = k((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(k, PorterDuff.Mode.SRC_IN);
    }

    private boolean e0() {
        PorterDuffColorFilter porterDuffColorFilter = this.w;
        PorterDuffColorFilter porterDuffColorFilter2 = this.x;
        c cVar = this.f;
        this.w = j(cVar.g, cVar.h, this.r, true);
        c cVar2 = this.f;
        this.x = j(cVar2.f, cVar2.h, this.s, false);
        c cVar3 = this.f;
        if (cVar3.u) {
            this.t.d(cVar3.g.getColorForState(getState(), 0));
        }
        return (a.g.j.d.a(porterDuffColorFilter, this.w) && a.g.j.d.a(porterDuffColorFilter2, this.x)) ? false : true;
    }

    private void f(RectF rectF, Path path) {
        g(rectF, path);
        if (this.f.j != 1.0f) {
            this.j.reset();
            Matrix matrix = this.j;
            float f = this.f.j;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.j);
        }
        path.computeBounds(this.z, true);
    }

    private void f0() {
        float H = H();
        this.f.r = (int) Math.ceil(0.75f * H);
        this.f.s = (int) Math.ceil(H * 0.25f);
        e0();
        M();
    }

    private void h() {
        k x = B().x(new b(this, -C()));
        this.q = x;
        this.v.d(x, this.f.k, u(), this.l);
    }

    private PorterDuffColorFilter i(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = k(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        return (colorStateList == null || mode == null) ? e(paint, z) : i(colorStateList, mode, z);
    }

    private int k(int i) {
        float H = H() + x();
        b.c.a.b.t.a aVar = this.f.f1302b;
        return aVar != null ? aVar.c(i, H) : i;
    }

    public static g l(Context context, float f) {
        int b2 = b.c.a.b.q.a.b(context, b.c.a.b.b.colorSurface, g.class.getSimpleName());
        g gVar = new g();
        gVar.L(context);
        gVar.T(ColorStateList.valueOf(b2));
        gVar.S(f);
        return gVar;
    }

    private void m(Canvas canvas) {
        if (this.f.s != 0) {
            canvas.drawPath(this.k, this.t.c());
        }
        for (int i = 0; i < 4; i++) {
            this.g[i].b(this.t, this.f.r, canvas);
            this.h[i].b(this.t, this.f.r, canvas);
        }
        int y = y();
        int z = z();
        canvas.translate(-y, -z);
        canvas.drawPath(this.k, A);
        canvas.translate(y, z);
    }

    private void n(Canvas canvas) {
        p(canvas, this.r, this.k, this.f.f1301a, t());
    }

    private void p(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (!kVar.u(rectF)) {
            canvas.drawPath(path, paint);
            return;
        }
        float a2 = kVar.t().a(rectF);
        canvas.drawRoundRect(rectF, a2, a2, paint);
    }

    private void q(Canvas canvas) {
        p(canvas, this.s, this.l, this.q, u());
    }

    private RectF u() {
        RectF t = t();
        float C = C();
        this.n.set(t.left + C, t.top + C, t.right - C, t.bottom - C);
        return this.n;
    }

    public int A() {
        return this.f.r;
    }

    public k B() {
        return this.f.f1301a;
    }

    public ColorStateList D() {
        return this.f.g;
    }

    public float E() {
        return this.f.f1301a.r().a(t());
    }

    public float F() {
        return this.f.f1301a.t().a(t());
    }

    public float G() {
        return this.f.p;
    }

    public float H() {
        return v() + G();
    }

    public void L(Context context) {
        this.f.f1302b = new b.c.a.b.t.a(context);
        f0();
    }

    public boolean N() {
        b.c.a.b.t.a aVar = this.f.f1302b;
        return aVar != null && aVar.d();
    }

    public boolean O() {
        return this.f.f1301a.u(t());
    }

    public void S(float f) {
        c cVar = this.f;
        if (cVar.o != f) {
            cVar.o = f;
            f0();
        }
    }

    public void T(ColorStateList colorStateList) {
        c cVar = this.f;
        if (cVar.f1304d != colorStateList) {
            cVar.f1304d = colorStateList;
            onStateChange(getState());
        }
    }

    public void U(float f) {
        c cVar = this.f;
        if (cVar.k != f) {
            cVar.k = f;
            this.i = true;
            invalidateSelf();
        }
    }

    public void V(int i, int i2, int i3, int i4) {
        c cVar = this.f;
        if (cVar.i == null) {
            cVar.i = new Rect();
        }
        this.f.i.set(i, i2, i3, i4);
        this.y = this.f.i;
        invalidateSelf();
    }

    public void W(float f) {
        c cVar = this.f;
        if (cVar.n != f) {
            cVar.n = f;
            f0();
        }
    }

    public void X(int i) {
        this.t.d(i);
        this.f.u = false;
        M();
    }

    public void Y(int i) {
        c cVar = this.f;
        if (cVar.t != i) {
            cVar.t = i;
            M();
        }
    }

    public void Z(float f, int i) {
        c0(f);
        b0(ColorStateList.valueOf(i));
    }

    public void a0(float f, ColorStateList colorStateList) {
        c0(f);
        b0(colorStateList);
    }

    public void b0(ColorStateList colorStateList) {
        c cVar = this.f;
        if (cVar.e != colorStateList) {
            cVar.e = colorStateList;
            onStateChange(getState());
        }
    }

    public void c0(float f) {
        this.f.l = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.r.setColorFilter(this.w);
        int alpha = this.r.getAlpha();
        this.r.setAlpha(P(alpha, this.f.m));
        this.s.setColorFilter(this.x);
        this.s.setStrokeWidth(this.f.l);
        int alpha2 = this.s.getAlpha();
        this.s.setAlpha(P(alpha2, this.f.m));
        if (this.i) {
            h();
            f(t(), this.k);
            this.i = false;
        }
        if (I()) {
            canvas.save();
            Q(canvas);
            int width = (int) (this.z.width() - getBounds().width());
            int height = (int) (this.z.height() - getBounds().height());
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.z.width()) + (this.f.r * 2) + width, ((int) this.z.height()) + (this.f.r * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f = (getBounds().left - this.f.r) - width;
            float f2 = (getBounds().top - this.f.r) - height;
            canvas2.translate(-f, -f2);
            m(canvas2);
            canvas.drawBitmap(createBitmap, f, f2, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
        }
        if (J()) {
            n(canvas);
        }
        if (K()) {
            q(canvas);
        }
        this.r.setAlpha(alpha);
        this.s.setAlpha(alpha2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(RectF rectF, Path path) {
        l lVar = this.v;
        c cVar = this.f;
        lVar.e(cVar.f1301a, cVar.k, rectF, this.u, path);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f.q == 2) {
            return;
        }
        if (O()) {
            outline.setRoundRect(getBounds(), E());
            return;
        }
        f(t(), this.k);
        if (this.k.isConvex()) {
            outline.setConvexPath(this.k);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.y;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.o.set(getBounds());
        f(t(), this.k);
        this.p.setPath(this.k, this.o);
        this.o.op(this.p, Region.Op.DIFFERENCE);
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.i = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f.g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f.f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f.e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f.f1304d) != null && colorStateList4.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f = new c(this.f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(Canvas canvas, Paint paint, Path path, RectF rectF) {
        p(canvas, paint, path, this.f.f1301a, rectF);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.i = true;
        super.onBoundsChange(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z = d0(iArr) || e0();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public float r() {
        return this.f.f1301a.j().a(t());
    }

    public float s() {
        return this.f.f1301a.l().a(t());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        c cVar = this.f;
        if (cVar.m != i) {
            cVar.m = i;
            M();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f.f1303c = colorFilter;
        M();
    }

    @Override // b.c.a.b.a0.n
    public void setShapeAppearanceModel(k kVar) {
        this.f.f1301a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f.g = colorStateList;
        e0();
        M();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f;
        if (cVar.h != mode) {
            cVar.h = mode;
            e0();
            M();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RectF t() {
        Rect bounds = getBounds();
        this.m.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        return this.m;
    }

    public float v() {
        return this.f.o;
    }

    public ColorStateList w() {
        return this.f.f1304d;
    }

    public float x() {
        return this.f.n;
    }

    public int y() {
        c cVar = this.f;
        return (int) (cVar.s * Math.sin(Math.toRadians(cVar.t)));
    }

    public int z() {
        c cVar = this.f;
        return (int) (cVar.s * Math.cos(Math.toRadians(cVar.t)));
    }
}
