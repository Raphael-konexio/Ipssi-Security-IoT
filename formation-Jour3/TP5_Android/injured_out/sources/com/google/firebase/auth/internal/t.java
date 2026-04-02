package com.google.firebase.auth.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, String> f1911a;

    static {
        HashMap hashMap = new HashMap();
        f1911a = hashMap;
        hashMap.put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
        f1911a.put("auth/invalid-cert-hash", "INVALID_CERT_HASH");
        f1911a.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
        f1911a.put("auth/web-storage-unsupported", "WEB_STORAGE_UNSUPPORTED");
        f1911a.put("auth/operation-not-allowed", "OPERATION_NOT_ALLOWED");
    }

    public static void a(Intent intent, Status status) {
        com.google.android.gms.common.internal.w.e.e(status, intent, "com.google.firebase.auth.internal.STATUS");
    }

    public static boolean b(Intent intent) {
        com.google.android.gms.common.internal.r.h(intent);
        return intent.hasExtra("com.google.firebase.auth.internal.STATUS");
    }

    public static Status c(Intent intent) {
        com.google.android.gms.common.internal.r.h(intent);
        com.google.android.gms.common.internal.r.a(b(intent));
        return (Status) com.google.android.gms.common.internal.w.e.b(intent, "com.google.firebase.auth.internal.STATUS", Status.CREATOR);
    }
}
