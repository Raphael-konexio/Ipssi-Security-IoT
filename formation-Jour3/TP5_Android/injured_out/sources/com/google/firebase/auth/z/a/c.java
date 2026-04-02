package com.google.firebase.auth.z.a;

import android.util.Log;
import java.util.Map;
/* loaded from: classes.dex */
final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    private final int f1924a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1925b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Integer> f1926c;

    public c(int i, int i2, Map<String, Integer> map) {
        this.f1924a = a() ? 0 : i;
        this.f1925b = i2;
        com.google.android.gms.common.internal.r.h(map);
        this.f1926c = map;
        a();
    }

    private static boolean a() {
        boolean equals = "local".equals(j1.a("firebear.preference"));
        if (equals) {
            Log.e("BiChannelGoogleApi", "Found local preference, will always use local service instance");
        }
        return equals;
    }

    @Override // com.google.firebase.auth.z.a.g
    public final boolean f(String str) {
        int i = this.f1924a;
        if (i == 0) {
            return true;
        }
        if (this.f1925b <= i) {
            return false;
        }
        Integer num = this.f1926c.get(str);
        if (num == null) {
            num = 0;
        }
        return num.intValue() > this.f1924a && this.f1925b >= num.intValue();
    }
}
