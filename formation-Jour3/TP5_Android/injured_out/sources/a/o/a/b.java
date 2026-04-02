package a.o.a;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f332a;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f333a;

        static {
            int[] iArr = new int[c.values().length];
            f333a = iArr;
            try {
                iArr[c.AES256_GCM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: a.o.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0024b {

        /* renamed from: a  reason: collision with root package name */
        private final String f334a;

        /* renamed from: b  reason: collision with root package name */
        private KeyGenParameterSpec f335b;

        /* renamed from: c  reason: collision with root package name */
        private c f336c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f337d;
        private int e;
        private boolean f;
        private final Context g;

        public C0024b(Context context, String str) {
            this.g = context.getApplicationContext();
            this.f334a = str;
        }

        private b b() {
            if (this.f336c == null && this.f335b == null) {
                throw new IllegalArgumentException("build() called before setKeyGenParameterSpec or setKeyScheme.");
            }
            if (this.f336c == c.AES256_GCM) {
                KeyGenParameterSpec.Builder keySize = new KeyGenParameterSpec.Builder(this.f334a, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256);
                if (this.f337d) {
                    keySize.setUserAuthenticationRequired(true).setUserAuthenticationValidityDurationSeconds(this.e);
                }
                if (Build.VERSION.SDK_INT >= 28 && this.f && this.g.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore")) {
                    keySize.setIsStrongBoxBacked(true);
                }
                this.f335b = keySize.build();
            }
            KeyGenParameterSpec keyGenParameterSpec = this.f335b;
            if (keyGenParameterSpec != null) {
                return new b(a.o.a.c.c(keyGenParameterSpec), this.f335b);
            }
            throw new NullPointerException("KeyGenParameterSpec was null after build() check");
        }

        public b a() {
            return Build.VERSION.SDK_INT >= 23 ? b() : new b(this.f334a, null);
        }

        public C0024b c(c cVar) {
            if (a.f333a[cVar.ordinal()] != 1) {
                throw new IllegalArgumentException("Unsupported scheme: " + cVar);
            } else if (Build.VERSION.SDK_INT < 23 || this.f335b == null) {
                this.f336c = cVar;
                return this;
            } else {
                throw new IllegalArgumentException("KeyScheme set after setting a KeyGenParamSpec");
            }
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        AES256_GCM
    }

    b(String str, Object obj) {
        this.f332a = str;
        if (Build.VERSION.SDK_INT >= 23) {
            KeyGenParameterSpec keyGenParameterSpec = (KeyGenParameterSpec) obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f332a;
    }

    public boolean b() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.containsAlias(this.f332a);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
            return false;
        }
    }

    public String toString() {
        return "MasterKey{keyAlias=" + this.f332a + ", isKeyStoreBacked=" + b() + "}";
    }
}
