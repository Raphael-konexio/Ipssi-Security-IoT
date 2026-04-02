package b3nac.injuredandroid;

import a.o.a.a;
import a.o.a.b;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public final class j extends Application {
    private static Context i;
    public static final a j = new a(null);
    private final String f = "b3nac.injuredandroid.encrypted";
    private a.o.a.b g;
    private final SharedPreferences h;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d.s.d.e eVar) {
            this();
        }

        public final void a(Context context) {
            d.s.d.g.e(context, "con");
            j.i = context;
        }
    }

    public j() {
        Context context = i;
        if (context == null) {
            d.s.d.g.n("context");
            throw null;
        }
        b.C0024b c0024b = new b.C0024b(context, "_androidx_security_master_key_");
        c0024b.c(b.c.AES256_GCM);
        a.o.a.b a2 = c0024b.a();
        d.s.d.g.d(a2, "MasterKey.Builder(contex…cheme.AES256_GCM).build()");
        this.g = a2;
        Context context2 = i;
        if (context2 == null) {
            d.s.d.g.n("context");
            throw null;
        }
        SharedPreferences a3 = a.o.a.a.a(context2, this.f, a2, a.d.AES256_SIV, a.e.AES256_GCM);
        d.s.d.g.d(a3, "EncryptedSharedPreferenc…ryptionScheme.AES256_GCM)");
        this.h = a3;
    }

    public final void b(Context context, String str, boolean z) {
        d.s.d.g.e(context, "context");
        d.s.d.g.e(str, "string");
        SharedPreferences.Editor edit = this.h.edit();
        edit.putBoolean(str, z).apply();
        edit.clear();
    }

    public final String c(String str, String str2) {
        d.s.d.g.e(str, "s");
        d.s.d.g.e(str2, "s1");
        return this.h.getString(str, str2);
    }

    public final void d(Context context, String str, String str2) {
        d.s.d.g.e(context, "context");
        d.s.d.g.e(str, "string");
        SharedPreferences.Editor edit = this.h.edit();
        edit.putString(str, str2).apply();
        edit.clear();
    }
}
