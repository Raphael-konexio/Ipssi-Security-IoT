package com.google.firebase.database.t;

import java.io.IOException;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f2396a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Object> f2397b;

    public a(String str, Map<String, Object> map) {
        this.f2396a = str;
        this.f2397b = map;
    }

    public static a c(String str) {
        if (str.startsWith("gauth|")) {
            try {
                Map<String, Object> a2 = b.a(str.substring(6));
                return new a((String) a2.get("token"), (Map) a2.get("auth"));
            } catch (IOException e) {
                throw new RuntimeException("Failed to parse gauth token", e);
            }
        }
        return null;
    }

    public Map<String, Object> a() {
        return this.f2397b;
    }

    public String b() {
        return this.f2396a;
    }
}
