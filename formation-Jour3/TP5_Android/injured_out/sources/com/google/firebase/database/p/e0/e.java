package com.google.firebase.database.p.e0;

import com.google.firebase.database.p.h0.h;
/* loaded from: classes.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static final e f2143d = new e(a.User, null, false);
    public static final e e = new e(a.Server, null, false);

    /* renamed from: a  reason: collision with root package name */
    private final a f2144a;

    /* renamed from: b  reason: collision with root package name */
    private final h f2145b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2146c;

    /* loaded from: classes.dex */
    private enum a {
        User,
        Server
    }

    public e(a aVar, h hVar, boolean z) {
        this.f2144a = aVar;
        this.f2145b = hVar;
        this.f2146c = z;
    }

    public static e a(h hVar) {
        return new e(a.Server, hVar, true);
    }

    public h b() {
        return this.f2145b;
    }

    public boolean c() {
        return this.f2144a == a.User;
    }

    public boolean d() {
        return this.f2146c;
    }

    public String toString() {
        return "OperationSource{source=" + this.f2144a + ", queryParams=" + this.f2145b + ", tagged=" + this.f2146c + '}';
    }
}
