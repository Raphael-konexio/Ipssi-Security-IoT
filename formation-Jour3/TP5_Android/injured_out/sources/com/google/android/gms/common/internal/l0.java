package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: a  reason: collision with root package name */
    private static Object f1635a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1636b;

    /* renamed from: c  reason: collision with root package name */
    private static int f1637c;

    public static int a(Context context) {
        b(context);
        return f1637c;
    }

    private static void b(Context context) {
        Bundle bundle;
        synchronized (f1635a) {
            if (f1636b) {
                return;
            }
            f1636b = true;
            try {
                bundle = b.c.a.a.b.m.b.a(context).a(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
            if (bundle == null) {
                return;
            }
            bundle.getString("com.google.app.id");
            f1637c = bundle.getInt("com.google.android.gms.version");
        }
    }
}
