package b.c.a.b.y;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import b.c.a.b.a0.g;
import b.c.a.b.a0.k;
import b.c.a.b.a0.n;
/* loaded from: classes.dex */
public class a extends Drawable implements n, androidx.core.graphics.drawable.b {
    private b f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        g f1390a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1391b;

        public b(g gVar) {
            this.f1390a = gVar;
            this.f1391b = false;
        }

        public b(b bVar) {
            this.f1390a = (g) bVar.f1390a.getConstantState().newDrawable();
            this.f1391b = bVar.f1391b;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* renamed from: a */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }

    public a(k kVar) {
        this(new b(new g(kVar)));
    }

    private a(b bVar) {
        this.f = bVar;
    }

    public a a() {
        this.f = new b(this.f);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f;
        if (bVar.f1391b) {
            bVar.f1390a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f.f1390a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable mutate() {
        a();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f.f1390a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f.f1390a.setState(iArr)) {
            onStateChange = true;
        }
        boolean b2 = b.c.a.b.y.b.b(iArr);
        b bVar = this.f;
        if (bVar.f1391b != b2) {
            bVar.f1391b = b2;
            return true;
        }
        return onStateChange;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f.f1390a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f.f1390a.setColorFilter(colorFilter);
    }

    @Override // b.c.a.b.a0.n
    public void setShapeAppearanceModel(k kVar) {
        this.f.f1390a.setShapeAppearanceModel(kVar);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        this.f.f1390a.setTint(i);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f.f1390a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f.f1390a.setTintMode(mode);
    }
}
