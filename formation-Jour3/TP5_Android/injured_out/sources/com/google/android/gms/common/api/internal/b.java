package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
/* loaded from: classes.dex */
public final class b<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1538a = false;

    /* renamed from: b  reason: collision with root package name */
    private final int f1539b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.gms.common.api.a<O> f1540c;

    /* renamed from: d  reason: collision with root package name */
    private final O f1541d;

    private b(com.google.android.gms.common.api.a<O> aVar, O o) {
        this.f1540c = aVar;
        this.f1541d = o;
        this.f1539b = com.google.android.gms.common.internal.q.b(aVar, o);
    }

    public static <O extends a.d> b<O> b(com.google.android.gms.common.api.a<O> aVar, O o) {
        return new b<>(aVar, o);
    }

    public final String a() {
        return this.f1540c.a();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return !this.f1538a && !bVar.f1538a && com.google.android.gms.common.internal.q.a(this.f1540c, bVar.f1540c) && com.google.android.gms.common.internal.q.a(this.f1541d, bVar.f1541d);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1539b;
    }
}
