package com.google.firebase.database.p.e0;

import com.google.firebase.database.p.l;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    protected final a f2140a;

    /* renamed from: b  reason: collision with root package name */
    protected final e f2141b;

    /* renamed from: c  reason: collision with root package name */
    protected final l f2142c;

    /* loaded from: classes.dex */
    public enum a {
        Overwrite,
        Merge,
        AckUserWrite,
        ListenComplete
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(a aVar, e eVar, l lVar) {
        this.f2140a = aVar;
        this.f2141b = eVar;
        this.f2142c = lVar;
    }

    public l a() {
        return this.f2142c;
    }

    public e b() {
        return this.f2141b;
    }

    public a c() {
        return this.f2140a;
    }

    public abstract d d(com.google.firebase.database.r.b bVar);
}
