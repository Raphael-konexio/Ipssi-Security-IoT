package com.google.android.gms.auth.api.signin.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.r;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
/* loaded from: classes.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final Lock f1519c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    private static a f1520d;

    /* renamed from: a  reason: collision with root package name */
    private final Lock f1521a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f1522b;

    private a(Context context) {
        this.f1522b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        r.h(context);
        f1519c.lock();
        try {
            if (f1520d == null) {
                f1520d = new a(context.getApplicationContext());
            }
            return f1520d;
        } finally {
            f1519c.unlock();
        }
    }

    private static String c(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    private final GoogleSignInAccount d(String str) {
        String e;
        if (!TextUtils.isEmpty(str) && (e = e(c("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.t(e);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private final String e(String str) {
        this.f1521a.lock();
        try {
            return this.f1522b.getString(str, null);
        } finally {
            this.f1521a.unlock();
        }
    }

    public GoogleSignInAccount b() {
        return d(e("defaultGoogleSignInAccount"));
    }
}
