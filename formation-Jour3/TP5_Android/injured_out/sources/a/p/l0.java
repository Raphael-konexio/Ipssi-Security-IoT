package a.p;

import android.view.View;
import android.view.WindowId;
/* loaded from: classes.dex */
class l0 implements m0 {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f393a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(View view) {
        this.f393a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof l0) && ((l0) obj).f393a.equals(this.f393a);
    }

    public int hashCode() {
        return this.f393a.hashCode();
    }
}
