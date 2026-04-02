package a.p;

import android.os.IBinder;
/* loaded from: classes.dex */
class k0 implements m0 {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f390a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k0(IBinder iBinder) {
        this.f390a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof k0) && ((k0) obj).f390a.equals(this.f390a);
    }

    public int hashCode() {
        return this.f390a.hashCode();
    }
}
