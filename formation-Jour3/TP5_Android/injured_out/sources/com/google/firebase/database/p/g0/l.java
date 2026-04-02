package com.google.firebase.database.p.g0;

import android.net.Uri;
import android.util.Base64;
import com.google.firebase.database.p.o;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f2194a = "0123456789abcdef".toCharArray();

    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int b(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    public static String c(double d2) {
        StringBuilder sb = new StringBuilder(16);
        long doubleToLongBits = Double.doubleToLongBits(d2);
        for (int i = 7; i >= 0; i--) {
            int i2 = (int) ((doubleToLongBits >>> (i * 8)) & 255);
            sb.append(f2194a[(i2 >> 4) & 15]);
            sb.append(f2194a[i2 & 15]);
        }
        return sb.toString();
    }

    private static String d(String str) {
        int indexOf = str.indexOf("//");
        if (indexOf != -1) {
            String substring = str.substring(indexOf + 2);
            int indexOf2 = substring.indexOf("/");
            if (indexOf2 != -1) {
                int indexOf3 = substring.indexOf("?");
                int i = indexOf2 + 1;
                return indexOf3 != -1 ? substring.substring(i, indexOf3) : substring.substring(i);
            }
            return "";
        }
        throw new com.google.firebase.database.c("Firebase Database URL is missing URL scheme");
    }

    public static void e(boolean z) {
        f(z, "");
    }

    public static void f(boolean z, String str) {
        if (z) {
            return;
        }
        throw new AssertionError("hardAssert failed: " + str);
    }

    public static h g(String str) {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (scheme != null) {
                String host = parse.getHost();
                if (host != null) {
                    o oVar = new o();
                    oVar.f2275a = host.toLowerCase();
                    int port = parse.getPort();
                    boolean z = true;
                    if (port != -1) {
                        if (!scheme.equals("https") && !scheme.equals("wss")) {
                            z = false;
                        }
                        oVar.f2276b = z;
                        oVar.f2275a += ":" + port;
                    } else {
                        oVar.f2276b = true;
                    }
                    String queryParameter = parse.getQueryParameter("ns");
                    if (queryParameter == null) {
                        queryParameter = host.split("\\.", -1)[0].toLowerCase();
                    }
                    oVar.f2277c = queryParameter;
                    String replace = d(str).replace("+", " ");
                    m.c(replace);
                    h hVar = new h();
                    hVar.f2185b = new com.google.firebase.database.p.l(replace);
                    hVar.f2184a = oVar;
                    return hVar;
                }
                throw new IllegalArgumentException("Database URL does not specify a valid host");
            }
            throw new IllegalArgumentException("Database URL does not specify a URL scheme");
        } catch (Exception e) {
            throw new com.google.firebase.database.c("Invalid Firebase Database url specified: " + str, e);
        }
    }

    public static String h(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("UTF-8"));
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 encoding is required for Firebase Database to run!");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Missing SHA-1 MessageDigest provider.", e);
        }
    }

    public static String i(String str) {
        String replace = str.indexOf(92) != -1 ? str.replace("\\", "\\\\") : str;
        if (str.indexOf(34) != -1) {
            replace = replace.replace("\"", "\\\"");
        }
        return '\"' + replace + '\"';
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x005b, code lost:
        if (r2 > 2147483647L) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Integer j(java.lang.String r8) {
        /*
            int r0 = r8.length()
            r1 = 0
            r2 = 11
            if (r0 > r2) goto L5d
            int r0 = r8.length()
            if (r0 != 0) goto L10
            goto L5d
        L10:
            r0 = 0
            char r2 = r8.charAt(r0)
            r3 = 45
            r4 = 1
            if (r2 != r3) goto L23
            int r0 = r8.length()
            if (r0 != r4) goto L21
            return r1
        L21:
            r0 = 1
            goto L24
        L23:
            r4 = 0
        L24:
            r2 = 0
        L26:
            int r5 = r8.length()
            if (r0 >= r5) goto L45
            char r5 = r8.charAt(r0)
            r6 = 48
            if (r5 < r6) goto L44
            r6 = 57
            if (r5 <= r6) goto L39
            goto L44
        L39:
            r6 = 10
            long r2 = r2 * r6
            int r5 = r5 + (-48)
            long r5 = (long) r5
            long r2 = r2 + r5
            int r0 = r0 + 1
            goto L26
        L44:
            return r1
        L45:
            if (r4 == 0) goto L56
            long r2 = -r2
            r4 = -2147483648(0xffffffff80000000, double:NaN)
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 >= 0) goto L50
            return r1
        L50:
            int r8 = (int) r2
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            return r8
        L56:
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 <= 0) goto L50
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.p.g0.l.j(java.lang.String):java.lang.Integer");
    }
}
