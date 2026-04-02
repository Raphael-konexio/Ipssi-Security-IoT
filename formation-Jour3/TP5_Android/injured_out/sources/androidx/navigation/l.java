package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.r;
@r.b("navigation")
/* loaded from: classes.dex */
public class l extends r<k> {

    /* renamed from: a  reason: collision with root package name */
    private final s f945a;

    public l(s sVar) {
        this.f945a = sVar;
    }

    @Override // androidx.navigation.r
    public boolean e() {
        return true;
    }

    @Override // androidx.navigation.r
    /* renamed from: f */
    public k a() {
        return new k(this);
    }

    @Override // androidx.navigation.r
    /* renamed from: g */
    public j b(k kVar, Bundle bundle, o oVar, r.a aVar) {
        int I = kVar.I();
        if (I == 0) {
            throw new IllegalStateException("no start destination defined via app:startDestination for " + kVar.l());
        }
        j G = kVar.G(I, false);
        if (G != null) {
            return this.f945a.e(G.u()).b(G, G.f(bundle), oVar, aVar);
        }
        String H = kVar.H();
        throw new IllegalArgumentException("navigation destination " + H + " is not a direct child of this NavGraph");
    }
}
