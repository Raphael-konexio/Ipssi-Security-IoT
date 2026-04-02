package b.c.a.b.p;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import b.c.a.b.p.d;
/* loaded from: classes.dex */
public class b extends FrameLayout implements d {
    private final c f;

    @Override // b.c.a.b.p.d
    public void a() {
        this.f.b();
    }

    @Override // b.c.a.b.p.d
    public void b() {
        this.f.a();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f.d();
    }

    @Override // b.c.a.b.p.d
    public int getCircularRevealScrimColor() {
        return this.f.e();
    }

    @Override // b.c.a.b.p.d
    public d.e getRevealInfo() {
        return this.f.f();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.f;
        return cVar != null ? cVar.g() : super.isOpaque();
    }

    @Override // b.c.a.b.p.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f.h(drawable);
    }

    @Override // b.c.a.b.p.d
    public void setCircularRevealScrimColor(int i) {
        this.f.i(i);
    }

    @Override // b.c.a.b.p.d
    public void setRevealInfo(d.e eVar) {
        this.f.j(eVar);
    }
}
