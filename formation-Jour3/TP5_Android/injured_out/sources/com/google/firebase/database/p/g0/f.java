package com.google.firebase.database.p.g0;
/* loaded from: classes.dex */
public class f implements a {

    /* renamed from: a  reason: collision with root package name */
    private final a f2180a;

    /* renamed from: b  reason: collision with root package name */
    private long f2181b;

    public f(a aVar, long j) {
        this.f2181b = 0L;
        this.f2180a = aVar;
        this.f2181b = j;
    }

    @Override // com.google.firebase.database.p.g0.a
    public long a() {
        return this.f2180a.a() + this.f2181b;
    }

    public void b(long j) {
        this.f2181b = j;
    }
}
