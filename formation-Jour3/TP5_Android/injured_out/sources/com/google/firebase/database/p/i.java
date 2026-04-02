package com.google.firebase.database.p;

import com.google.firebase.database.p.h0.e;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: b  reason: collision with root package name */
    private j f2247b;

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f2246a = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private boolean f2248c = false;

    public abstract i a(com.google.firebase.database.p.h0.i iVar);

    public abstract com.google.firebase.database.p.h0.d b(com.google.firebase.database.p.h0.c cVar, com.google.firebase.database.p.h0.i iVar);

    public abstract void c(com.google.firebase.database.b bVar);

    public abstract void d(com.google.firebase.database.p.h0.d dVar);

    public abstract com.google.firebase.database.p.h0.i e();

    public abstract boolean f(i iVar);

    public boolean g() {
        return this.f2246a.get();
    }

    public abstract boolean h(e.a aVar);

    public void i(boolean z) {
        this.f2248c = z;
    }

    public void j(j jVar) {
        this.f2247b = jVar;
    }

    public void k() {
        j jVar;
        if (!this.f2246a.compareAndSet(false, true) || (jVar = this.f2247b) == null) {
            return;
        }
        jVar.a(this);
        this.f2247b = null;
    }
}
