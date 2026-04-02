package b.c.a.b.p.e;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import b.c.a.b.p.c;
import b.c.a.b.p.d;
/* loaded from: classes.dex */
public class a extends b.c.a.b.n.a implements d {
    private final c s;

    @Override // b.c.a.b.p.d
    public void a() {
        this.s.b();
    }

    @Override // b.c.a.b.p.d
    public void b() {
        this.s.a();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        c cVar = this.s;
        if (cVar != null) {
            cVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.s.d();
    }

    @Override // b.c.a.b.p.d
    public int getCircularRevealScrimColor() {
        return this.s.e();
    }

    @Override // b.c.a.b.p.d
    public d.e getRevealInfo() {
        return this.s.f();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.s;
        return cVar != null ? cVar.g() : super.isOpaque();
    }

    @Override // b.c.a.b.p.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.s.h(drawable);
    }

    @Override // b.c.a.b.p.d
    public void setCircularRevealScrimColor(int i) {
        this.s.i(i);
    }

    @Override // b.c.a.b.p.d
    public void setRevealInfo(d.e eVar) {
        this.s.j(eVar);
    }
}
