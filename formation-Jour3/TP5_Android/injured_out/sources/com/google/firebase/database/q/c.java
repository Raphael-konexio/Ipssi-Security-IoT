package com.google.firebase.database.q;

import com.google.firebase.database.q.d;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final d f2349a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2350b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2351c;

    public c(d dVar, String str) {
        this(dVar, str, null);
    }

    public c(d dVar, String str, String str2) {
        this.f2349a = dVar;
        this.f2350b = str;
        this.f2351c = str2;
    }

    private static String d(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private long g() {
        return System.currentTimeMillis();
    }

    private String h(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        if (this.f2351c == null) {
            return str;
        }
        return this.f2351c + " - " + str;
    }

    public void a(String str, Throwable th, Object... objArr) {
        if (f()) {
            String h = h(str, objArr);
            if (th != null) {
                h = h + "\n" + d(th);
            }
            this.f2349a.a(d.a.DEBUG, this.f2350b, h, g());
        }
    }

    public void b(String str, Object... objArr) {
        a(str, null, objArr);
    }

    public void c(String str, Throwable th) {
        this.f2349a.a(d.a.ERROR, this.f2350b, h(str, new Object[0]) + "\n" + d(th), g());
    }

    public void e(String str) {
        this.f2349a.a(d.a.INFO, this.f2350b, h(str, new Object[0]), g());
    }

    public boolean f() {
        return this.f2349a.b().ordinal() <= d.a.DEBUG.ordinal();
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, Throwable th) {
        String h = h(str, new Object[0]);
        if (th != null) {
            h = h + "\n" + d(th);
        }
        this.f2349a.a(d.a.WARN, this.f2350b, h, g());
    }
}
