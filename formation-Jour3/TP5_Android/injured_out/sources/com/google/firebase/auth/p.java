package com.google.firebase.auth;

import java.util.Map;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private String f1913a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Object> f1914b;

    public p(String str, Map<String, Object> map) {
        this.f1913a = str;
        this.f1914b = map;
    }

    public Map<String, Object> a() {
        return this.f1914b;
    }

    public String b() {
        Map map = (Map) this.f1914b.get("firebase");
        if (map != null) {
            return (String) map.get("sign_in_provider");
        }
        return null;
    }

    public String c() {
        return this.f1913a;
    }
}
