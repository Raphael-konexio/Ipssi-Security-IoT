package com.google.android.gms.common.api.internal;

import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: a  reason: collision with root package name */
    private final a.d.a<b<?>, b.c.a.a.b.a> f1575a;

    /* renamed from: b  reason: collision with root package name */
    private final a.d.a<b<?>, String> f1576b;

    /* renamed from: c  reason: collision with root package name */
    private final b.c.a.a.f.h<Map<b<?>, String>> f1577c;

    /* renamed from: d  reason: collision with root package name */
    private int f1578d;
    private boolean e;

    public final void a(b<?> bVar, b.c.a.a.b.a aVar, String str) {
        this.f1575a.put(bVar, aVar);
        this.f1576b.put(bVar, str);
        this.f1578d--;
        if (!aVar.k()) {
            this.e = true;
        }
        if (this.f1578d == 0) {
            if (!this.e) {
                this.f1577c.c(this.f1576b);
                return;
            }
            this.f1577c.b(new com.google.android.gms.common.api.c(this.f1575a));
        }
    }

    public final Set<b<?>> b() {
        return this.f1575a.keySet();
    }
}
