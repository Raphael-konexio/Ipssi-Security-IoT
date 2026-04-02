package com.google.firebase.database.p.h0;

import com.google.firebase.database.p.h0.e;
/* loaded from: classes.dex */
public class d implements e {

    /* renamed from: a  reason: collision with root package name */
    private final e.a f2206a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.database.p.i f2207b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.database.a f2208c;

    public d(e.a aVar, com.google.firebase.database.p.i iVar, com.google.firebase.database.a aVar2, String str) {
        this.f2206a = aVar;
        this.f2207b = iVar;
        this.f2208c = aVar2;
    }

    @Override // com.google.firebase.database.p.h0.e
    public void a() {
        this.f2207b.d(this);
    }

    public com.google.firebase.database.p.l b() {
        com.google.firebase.database.p.l d2 = this.f2208c.b().d();
        return this.f2206a == e.a.VALUE ? d2 : d2.y();
    }

    public com.google.firebase.database.a c() {
        return this.f2208c;
    }

    @Override // com.google.firebase.database.p.h0.e
    public String toString() {
        StringBuilder sb;
        if (this.f2206a == e.a.VALUE) {
            sb = new StringBuilder();
            sb.append(b());
            sb.append(": ");
            sb.append(this.f2206a);
            sb.append(": ");
            sb.append(this.f2208c.d(true));
        } else {
            sb = new StringBuilder();
            sb.append(b());
            sb.append(": ");
            sb.append(this.f2206a);
            sb.append(": { ");
            sb.append(this.f2208c.a());
            sb.append(": ");
            sb.append(this.f2208c.d(true));
            sb.append(" }");
        }
        return sb.toString();
    }
}
