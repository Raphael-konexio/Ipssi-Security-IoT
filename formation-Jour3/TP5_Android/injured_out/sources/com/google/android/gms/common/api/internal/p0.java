package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map<BasePendingResult<?>, Boolean> f1581a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final Map<b.c.a.a.f.h<?>, Boolean> f1582b = Collections.synchronizedMap(new WeakHashMap());

    private final void b(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f1581a) {
            hashMap = new HashMap(this.f1581a);
        }
        synchronized (this.f1582b) {
            hashMap2 = new HashMap(this.f1582b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).j(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((b.c.a.a.f.h) entry2.getKey()).d(new com.google.android.gms.common.api.b(status));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <TResult> void a(b.c.a.a.f.h<TResult> hVar, boolean z) {
        this.f1582b.put(hVar, Boolean.valueOf(z));
        hVar.a().c(new o(this, hVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c() {
        return (this.f1581a.isEmpty() && this.f1582b.isEmpty()) ? false : true;
    }

    public final void d() {
        b(false, e.n);
    }

    public final void e() {
        b(true, h0.f1564a);
    }
}
