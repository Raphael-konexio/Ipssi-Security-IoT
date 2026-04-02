package com.google.firebase.auth.internal;

import b.c.a.a.d.c.a2;
/* loaded from: classes.dex */
public final class v {
    public static a2 a(com.google.firebase.auth.b bVar, String str) {
        com.google.android.gms.common.internal.r.h(bVar);
        if (com.google.firebase.auth.r.class.isAssignableFrom(bVar.getClass())) {
            return com.google.firebase.auth.r.h((com.google.firebase.auth.r) bVar, str);
        }
        if (com.google.firebase.auth.d.class.isAssignableFrom(bVar.getClass())) {
            return com.google.firebase.auth.d.h((com.google.firebase.auth.d) bVar, str);
        }
        if (com.google.firebase.auth.x.class.isAssignableFrom(bVar.getClass())) {
            return com.google.firebase.auth.x.h((com.google.firebase.auth.x) bVar, str);
        }
        if (com.google.firebase.auth.q.class.isAssignableFrom(bVar.getClass())) {
            return com.google.firebase.auth.q.h((com.google.firebase.auth.q) bVar, str);
        }
        if (com.google.firebase.auth.w.class.isAssignableFrom(bVar.getClass())) {
            return com.google.firebase.auth.w.h((com.google.firebase.auth.w) bVar, str);
        }
        if (com.google.firebase.auth.i0.class.isAssignableFrom(bVar.getClass())) {
            return com.google.firebase.auth.i0.n((com.google.firebase.auth.i0) bVar, str);
        }
        throw new IllegalArgumentException("Unsupported credential type.");
    }
}
