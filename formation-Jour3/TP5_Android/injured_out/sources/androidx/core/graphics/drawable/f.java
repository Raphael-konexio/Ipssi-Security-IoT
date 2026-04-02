package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f763a;

    /* renamed from: b  reason: collision with root package name */
    Drawable.ConstantState f764b;

    /* renamed from: c  reason: collision with root package name */
    ColorStateList f765c;

    /* renamed from: d  reason: collision with root package name */
    PorterDuff.Mode f766d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(f fVar) {
        this.f765c = null;
        this.f766d = d.l;
        if (fVar != null) {
            this.f763a = fVar.f763a;
            this.f764b = fVar.f764b;
            this.f765c = fVar.f765c;
            this.f766d = fVar.f766d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f764b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i = this.f763a;
        Drawable.ConstantState constantState = this.f764b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new e(this, resources) : new d(this, resources);
    }
}
