package com.google.firebase.auth.z.a;

import android.text.TextUtils;
/* loaded from: classes.dex */
public final class x0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return b("firebase-auth");
    }

    private static String b(String str) {
        String b2 = com.google.android.gms.common.internal.p.a().b(str);
        return (TextUtils.isEmpty(b2) || b2.equals("UNKNOWN")) ? "-1" : b2;
    }
}
