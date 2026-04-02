package com.google.firebase.database.o;

import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f2063a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2064b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.database.q.d f2065c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2066d;
    private final String e;
    private final String f;
    private final String g;

    public d(com.google.firebase.database.q.d dVar, c cVar, ScheduledExecutorService scheduledExecutorService, boolean z, String str, String str2, String str3) {
        this.f2065c = dVar;
        this.f2064b = cVar;
        this.f2063a = scheduledExecutorService;
        this.f2066d = z;
        this.e = str;
        this.f = str2;
        this.g = str3;
    }

    public c a() {
        return this.f2064b;
    }

    public String b() {
        return this.e;
    }

    public ScheduledExecutorService c() {
        return this.f2063a;
    }

    public com.google.firebase.database.q.d d() {
        return this.f2065c;
    }

    public String e() {
        return this.g;
    }

    public String f() {
        return this.f;
    }

    public boolean g() {
        return this.f2066d;
    }
}
