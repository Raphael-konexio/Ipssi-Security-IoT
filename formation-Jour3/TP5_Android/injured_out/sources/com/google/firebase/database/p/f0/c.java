package com.google.firebase.database.p.f0;
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public final long f2152a;

    public c(long j) {
        this.f2152a = j;
    }

    @Override // com.google.firebase.database.p.f0.a
    public boolean a(long j, long j2) {
        return j > this.f2152a || j2 > 1000;
    }

    @Override // com.google.firebase.database.p.f0.a
    public float b() {
        return 0.2f;
    }

    @Override // com.google.firebase.database.p.f0.a
    public long c() {
        return 1000L;
    }

    @Override // com.google.firebase.database.p.f0.a
    public boolean d(long j) {
        return j > 1000;
    }
}
