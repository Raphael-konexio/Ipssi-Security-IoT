package com.google.firebase.auth.internal;

import java.util.Map;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final b.c.a.a.b.k.a f1898a = new b.c.a.a.b.k.a("GetTokenResultFactory", new String[0]);

    public static com.google.firebase.auth.p a(String str) {
        Map a2;
        try {
            a2 = j.b(str);
        } catch (com.google.firebase.auth.z.b e) {
            f1898a.a("Error parsing token claims", e, new Object[0]);
            a2 = b.c.a.a.d.c.b0.a();
        }
        return new com.google.firebase.auth.p(str, a2);
    }
}
