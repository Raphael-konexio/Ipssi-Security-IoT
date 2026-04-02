package com.google.android.gms.common.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class p {

    /* renamed from: b  reason: collision with root package name */
    private static final j f1639b = new j("LibraryVersion", "");

    /* renamed from: c  reason: collision with root package name */
    private static p f1640c = new p();

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, String> f1641a = new ConcurrentHashMap<>();

    protected p() {
    }

    public static p a() {
        return f1640c;
    }

    public String b(String str) {
        r.g(str, "Please provide a valid libraryName");
        if (this.f1641a.containsKey(str)) {
            return this.f1641a.get(str);
        }
        Properties properties = new Properties();
        String str2 = null;
        try {
            InputStream resourceAsStream = p.class.getResourceAsStream(String.format("/%s.properties", str));
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                str2 = properties.getProperty("version", null);
                j jVar = f1639b;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(str2).length());
                sb.append(str);
                sb.append(" version is ");
                sb.append(str2);
                jVar.e("LibraryVersion", sb.toString());
            } else {
                j jVar2 = f1639b;
                String valueOf = String.valueOf(str);
                jVar2.c("LibraryVersion", valueOf.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf) : new String("Failed to get app version for libraryName: "));
            }
        } catch (IOException e) {
            j jVar3 = f1639b;
            String valueOf2 = String.valueOf(str);
            jVar3.d("LibraryVersion", valueOf2.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf2) : new String("Failed to get app version for libraryName: "), e);
        }
        if (str2 == null) {
            f1639b.b("LibraryVersion", ".properties file is dropped during release process. Failure to read app version isexpected druing Google internal testing where locally-built libraries are used");
            str2 = "UNKNOWN";
        }
        this.f1641a.put(str, str2);
        return str2;
    }
}
