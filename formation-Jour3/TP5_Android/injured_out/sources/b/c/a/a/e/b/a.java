package b.c.a.a.e.b;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.s;
/* loaded from: classes.dex */
public class a extends com.google.android.gms.common.internal.h<f> implements b.c.a.a.e.e {
    private Integer A;
    private final boolean x;
    private final com.google.android.gms.common.internal.d y;
    private final Bundle z;

    private a(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.d dVar, Bundle bundle, com.google.android.gms.common.api.f fVar, com.google.android.gms.common.api.g gVar) {
        super(context, looper, 44, dVar, fVar, gVar);
        this.x = true;
        this.y = dVar;
        this.z = bundle;
        this.A = dVar.d();
    }

    public a(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.d dVar, b.c.a.a.e.a aVar, com.google.android.gms.common.api.f fVar, com.google.android.gms.common.api.g gVar) {
        this(context, looper, true, dVar, k0(dVar), fVar, gVar);
    }

    public static Bundle k0(com.google.android.gms.common.internal.d dVar) {
        b.c.a.a.e.a h = dVar.h();
        Integer d2 = dVar.d();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", dVar.a());
        if (d2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", d2.intValue());
        }
        if (h != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", h.j());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", h.i());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", h.g());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", h.h());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", h.d());
            bundle.putString("com.google.android.gms.signin.internal.logSessionId", h.e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", h.k());
            if (h.b() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", h.b().longValue());
            }
            if (h.f() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", h.f().longValue());
            }
        }
        return bundle;
    }

    @Override // b.c.a.a.e.e
    public final void a() {
        o(new c.d());
    }

    @Override // com.google.android.gms.common.internal.c
    protected String f() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected /* synthetic */ IInterface h(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof f ? (f) queryLocalInterface : new h(iBinder);
    }

    @Override // b.c.a.a.e.e
    public final void i(d dVar) {
        r.i(dVar, "Expecting a valid ISignInCallbacks");
        try {
            Account b2 = this.y.b();
            ((f) C()).R(new j(new s(b2, this.A.intValue(), "<<default account>>".equals(b2.name) ? com.google.android.gms.auth.api.signin.a.a.a(y()).b() : null)), dVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                dVar.D(new l(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.h, com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public int k() {
        return b.c.a.a.b.g.f1220a;
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public boolean q() {
        return this.x;
    }

    @Override // com.google.android.gms.common.internal.c
    protected String r() {
        return "com.google.android.gms.signin.service.START";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.c
    public Bundle z() {
        if (!y().getPackageName().equals(this.y.f())) {
            this.z.putString("com.google.android.gms.signin.internal.realClientPackageName", this.y.f());
        }
        return this.z;
    }
}
