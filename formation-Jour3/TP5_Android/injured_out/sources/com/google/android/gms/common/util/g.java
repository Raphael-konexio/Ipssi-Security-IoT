package com.google.android.gms.common.util;

import android.content.Context;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f1649a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f1650b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f1651c;

    public static boolean a(Context context) {
        if (f1650b == null) {
            f1650b = Boolean.valueOf(i.f() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f1650b.booleanValue();
    }

    public static boolean b(Context context) {
        if (f1649a == null) {
            f1649a = Boolean.valueOf(i.e() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f1649a.booleanValue();
    }

    public static boolean c(Context context) {
        if (b(context)) {
            if (i.g()) {
                return a(context) && !i.h();
            }
            return true;
        }
        return false;
    }

    public static boolean d(Context context) {
        if (f1651c == null) {
            f1651c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f1651c.booleanValue();
    }
}
