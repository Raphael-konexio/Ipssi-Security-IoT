package com.google.firebase.database.o;

import java.net.URI;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final String f2067a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2068b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2069c;

    public f(String str, String str2, boolean z) {
        this.f2067a = str;
        this.f2068b = str2;
        this.f2069c = z;
    }

    public static URI a(String str, boolean z, String str2, String str3) {
        String str4 = (z ? "wss" : "ws") + "://" + str + "/.ws?ns=" + str2 + "&v=5";
        if (str3 != null) {
            str4 = str4 + "&ls=" + str3;
        }
        return URI.create(str4);
    }

    public String b() {
        return this.f2067a;
    }

    public String c() {
        return this.f2068b;
    }

    public boolean d() {
        return this.f2069c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("http");
        sb.append(this.f2069c ? "s" : "");
        sb.append("://");
        sb.append(this.f2067a);
        return sb.toString();
    }
}
