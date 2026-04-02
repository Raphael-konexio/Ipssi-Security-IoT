package com.google.firebase.auth;

import android.net.Uri;
import java.util.Set;
/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    private final String f1884a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1885b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1886c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1887d;

    static {
        b.c.a.a.d.c.a0 a0Var = new b.c.a.a.d.c.a0();
        a0Var.a("recoverEmail", 2);
        a0Var.a("resetPassword", 0);
        a0Var.a("signIn", 4);
        a0Var.a("verifyEmail", 1);
        a0Var.a("verifyBeforeChangeEmail", 5);
        a0Var.a("revertSecondFactorAddition", 6);
        a0Var.b();
    }

    private h0(String str) {
        this.f1884a = b(str, "apiKey");
        this.f1885b = b(str, "oobCode");
        String b2 = b(str, "mode");
        this.f1886c = b2;
        if (this.f1884a == null || this.f1885b == null || b2 == null) {
            throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", "apiKey", "oobCode", "mode"));
        }
        b(str, "continueUrl");
        b(str, "languageCode");
        this.f1887d = b(str, "tenantId");
    }

    public static h0 a(String str) {
        com.google.android.gms.common.internal.r.f(str);
        try {
            return new h0(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static String b(String str, String str2) {
        Uri parse = Uri.parse(str);
        try {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return parse.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(parse.getQueryParameter("link")).getQueryParameter(str2);
            }
            return null;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    public final String c() {
        return this.f1887d;
    }
}
