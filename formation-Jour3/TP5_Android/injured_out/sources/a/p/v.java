package a.p;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
/* loaded from: classes.dex */
class v implements w {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f418a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ViewGroup viewGroup) {
        this.f418a = viewGroup.getOverlay();
    }

    @Override // a.p.w
    public void a(View view) {
        this.f418a.add(view);
    }

    @Override // a.p.b0
    public void b(Drawable drawable) {
        this.f418a.add(drawable);
    }

    @Override // a.p.w
    public void c(View view) {
        this.f418a.remove(view);
    }

    @Override // a.p.b0
    public void d(Drawable drawable) {
        this.f418a.remove(drawable);
    }
}
