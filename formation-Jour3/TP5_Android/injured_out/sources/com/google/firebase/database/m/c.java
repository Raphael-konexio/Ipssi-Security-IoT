package com.google.firebase.database.m;

import com.google.firebase.database.p.a;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
final /* synthetic */ class c implements com.google.firebase.auth.internal.a {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f2025a;

    /* renamed from: b  reason: collision with root package name */
    private final a.b f2026b;

    private c(ExecutorService executorService, a.b bVar) {
        this.f2025a = executorService;
        this.f2026b = bVar;
    }

    public static com.google.firebase.auth.internal.a b(ExecutorService executorService, a.b bVar) {
        return new c(executorService, bVar);
    }

    @Override // com.google.firebase.auth.internal.a
    public void a(b.c.c.m.b bVar) {
        this.f2025a.execute(d.a(this.f2026b, bVar));
    }
}
