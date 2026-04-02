package b.c.a.a.b;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.j0;
import com.google.android.gms.common.internal.k0;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
/* loaded from: classes.dex */
abstract class q extends k0 {

    /* renamed from: a  reason: collision with root package name */
    private int f1233a;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(byte[] bArr) {
        com.google.android.gms.common.internal.r.a(bArr.length == 25);
        this.f1233a = Arrays.hashCode(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] h(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.android.gms.common.internal.j0
    public final b.c.a.a.c.a a() {
        return b.c.a.a.c.b.h(g());
    }

    @Override // com.google.android.gms.common.internal.j0
    public final int b() {
        return hashCode();
    }

    public boolean equals(Object obj) {
        b.c.a.a.c.a a2;
        if (obj != null && (obj instanceof j0)) {
            try {
                j0 j0Var = (j0) obj;
                if (j0Var.b() == hashCode() && (a2 = j0Var.a()) != null) {
                    return Arrays.equals(g(), (byte[]) b.c.a.a.c.b.g(a2));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    abstract byte[] g();

    public int hashCode() {
        return this.f1233a;
    }
}
