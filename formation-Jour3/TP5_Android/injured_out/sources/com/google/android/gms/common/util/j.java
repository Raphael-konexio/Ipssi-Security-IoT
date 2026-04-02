package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static String f1652a;

    /* renamed from: b  reason: collision with root package name */
    private static int f1653b;

    public static String a() {
        if (f1652a == null) {
            if (f1653b == 0) {
                f1653b = Process.myPid();
            }
            f1652a = b(f1653b);
        }
        return f1652a;
    }

    private static String b(int i) {
        Throwable th;
        BufferedReader bufferedReader;
        String str = null;
        if (i <= 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i);
            sb.append("/cmdline");
            bufferedReader = c(sb.toString());
        } catch (IOException unused) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            str = bufferedReader.readLine().trim();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            th = th3;
            h.a(bufferedReader);
            throw th;
        }
        h.a(bufferedReader);
        return str;
    }

    private static BufferedReader c(String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
