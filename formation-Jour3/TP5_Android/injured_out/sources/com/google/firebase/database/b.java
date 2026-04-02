package com.google.firebase.database;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Integer, String> f2003c;

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, Integer> f2004d;

    /* renamed from: a  reason: collision with root package name */
    private final int f2005a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2006b;

    static {
        HashMap hashMap = new HashMap();
        f2003c = hashMap;
        hashMap.put(-1, "The transaction needs to be run again with current data");
        f2003c.put(-2, "The server indicated that this operation failed");
        f2003c.put(-3, "This client does not have permission to perform this operation");
        f2003c.put(-4, "The operation had to be aborted due to a network disconnect");
        f2003c.put(-6, "The supplied auth token has expired");
        f2003c.put(-7, "The supplied auth token was invalid");
        f2003c.put(-8, "The transaction had too many retries");
        f2003c.put(-9, "The transaction was overridden by a subsequent set");
        f2003c.put(-10, "The service is unavailable");
        f2003c.put(-11, "User code called from the Firebase Database runloop threw an exception:\n");
        f2003c.put(-24, "The operation could not be performed due to a network error");
        f2003c.put(-25, "The write was canceled by the user.");
        f2003c.put(-999, "An unknown error occurred");
        HashMap hashMap2 = new HashMap();
        f2004d = hashMap2;
        hashMap2.put("datastale", -1);
        f2004d.put("failure", -2);
        f2004d.put("permission_denied", -3);
        f2004d.put("disconnected", -4);
        f2004d.put("expired_token", -6);
        f2004d.put("invalid_token", -7);
        f2004d.put("maxretries", -8);
        f2004d.put("overriddenbyset", -9);
        f2004d.put("unavailable", -10);
        f2004d.put("network_error", -24);
        f2004d.put("write_canceled", -25);
    }

    private b(int i, String str) {
        this(i, str, null);
    }

    private b(int i, String str, String str2) {
        this.f2005a = i;
        this.f2006b = str;
    }

    public static b a(int i) {
        if (f2003c.containsKey(Integer.valueOf(i))) {
            return new b(i, f2003c.get(Integer.valueOf(i)), null);
        }
        throw new IllegalArgumentException("Invalid Firebase Database error code: " + i);
    }

    public static b b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new b(-11, f2003c.get(-11) + stringWriter.toString());
    }

    public static b c(String str) {
        return d(str, null);
    }

    public static b d(String str, String str2) {
        return e(str, str2, null);
    }

    public static b e(String str, String str2, String str3) {
        Integer num = f2004d.get(str.toLowerCase());
        if (num == null) {
            num = -999;
        }
        if (str2 == null) {
            str2 = f2003c.get(num);
        }
        return new b(num.intValue(), str2, str3);
    }

    public int f() {
        return this.f2005a;
    }

    public c g() {
        return new c("Firebase Database error: " + this.f2006b);
    }

    public String toString() {
        return "DatabaseError: " + this.f2006b;
    }
}
