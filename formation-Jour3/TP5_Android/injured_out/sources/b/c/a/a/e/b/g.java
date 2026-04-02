package b.c.a.a.e.b;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public abstract class g extends b.c.a.a.d.a.a implements d {
    public g() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // b.c.a.a.d.a.a
    protected boolean Y(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 3) {
            H((b.c.a.a.b.a) b.c.a.a.d.a.c.a(parcel, b.c.a.a.b.a.CREATOR), (c) b.c.a.a.d.a.c.a(parcel, c.CREATOR));
        } else if (i == 4) {
            V((Status) b.c.a.a.d.a.c.a(parcel, Status.CREATOR));
        } else if (i == 6) {
            k((Status) b.c.a.a.d.a.c.a(parcel, Status.CREATOR));
        } else if (i == 7) {
            p((Status) b.c.a.a.d.a.c.a(parcel, Status.CREATOR), (GoogleSignInAccount) b.c.a.a.d.a.c.a(parcel, GoogleSignInAccount.CREATOR));
        } else if (i != 8) {
            return false;
        } else {
            D((l) b.c.a.a.d.a.c.a(parcel, l.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
