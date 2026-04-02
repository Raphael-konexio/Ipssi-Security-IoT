package b.c.a.a.e.b;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes.dex */
public final class h extends b.c.a.a.d.a.b implements f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public h(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // b.c.a.a.e.b.f
    public final void R(j jVar, d dVar) {
        Parcel d2 = d();
        b.c.a.a.d.a.c.c(d2, jVar);
        b.c.a.a.d.a.c.b(d2, dVar);
        g(12, d2);
    }
}
