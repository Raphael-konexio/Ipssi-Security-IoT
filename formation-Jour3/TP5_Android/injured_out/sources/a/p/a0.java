package a.p;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
/* loaded from: classes.dex */
class a0 implements b0 {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f339a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(View view) {
        this.f339a = view.getOverlay();
    }

    @Override // a.p.b0
    public void b(Drawable drawable) {
        this.f339a.add(drawable);
    }

    @Override // a.p.b0
    public void d(Drawable drawable) {
        this.f339a.remove(drawable);
    }
}
