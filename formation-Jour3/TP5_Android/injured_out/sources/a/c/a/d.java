package a.c.a;

import a.c.a.h;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
/* loaded from: classes.dex */
class d implements f {

    /* renamed from: a  reason: collision with root package name */
    final RectF f51a = new RectF();

    /* loaded from: classes.dex */
    class a implements h.a {
        a() {
        }

        @Override // a.c.a.h.a
        public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
            float f2 = 2.0f * f;
            float width = (rectF.width() - f2) - 1.0f;
            float height = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                float f3 = f + 0.5f;
                float f4 = -f3;
                d.this.f51a.set(f4, f4, f3, f3);
                int save = canvas.save();
                canvas.translate(rectF.left + f3, rectF.top + f3);
                canvas.drawArc(d.this.f51a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(d.this.f51a, 180.0f, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(d.this.f51a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(d.this.f51a, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(save);
                float f5 = rectF.top;
                canvas.drawRect((rectF.left + f3) - 1.0f, f5, (rectF.right - f3) + 1.0f, f5 + f3, paint);
                float f6 = rectF.bottom;
                canvas.drawRect((rectF.left + f3) - 1.0f, f6 - f3, (rectF.right - f3) + 1.0f, f6, paint);
            }
            canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
        }
    }

    private h n(e eVar) {
        return (h) eVar.f();
    }

    @Override // a.c.a.f
    public float a(e eVar) {
        return n(eVar).i();
    }

    @Override // a.c.a.f
    public ColorStateList b(e eVar) {
        return n(eVar).f();
    }

    @Override // a.c.a.f
    public void c(e eVar, float f) {
        n(eVar).p(f);
        o(eVar);
    }

    @Override // a.c.a.f
    public float d(e eVar) {
        return n(eVar).l();
    }

    @Override // a.c.a.f
    public void e() {
        h.r = new a();
    }

    @Override // a.c.a.f
    public float f(e eVar) {
        return n(eVar).g();
    }

    @Override // a.c.a.f
    public float g(e eVar) {
        return n(eVar).j();
    }

    @Override // a.c.a.f
    public float h(e eVar) {
        return n(eVar).k();
    }

    @Override // a.c.a.f
    public void i(e eVar) {
    }

    @Override // a.c.a.f
    public void j(e eVar, float f) {
        n(eVar).r(f);
    }

    @Override // a.c.a.f
    public void k(e eVar) {
        n(eVar).m(eVar.d());
        o(eVar);
    }

    @Override // a.c.a.f
    public void l(e eVar, ColorStateList colorStateList) {
        n(eVar).o(colorStateList);
    }

    @Override // a.c.a.f
    public void m(e eVar, float f) {
        n(eVar).q(f);
        o(eVar);
    }

    public void o(e eVar) {
        Rect rect = new Rect();
        n(eVar).h(rect);
        eVar.c((int) Math.ceil(h(eVar)), (int) Math.ceil(g(eVar)));
        eVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
