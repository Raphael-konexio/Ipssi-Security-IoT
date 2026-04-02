package com.google.firebase.database.p;

import com.google.firebase.database.o.c;
import com.google.firebase.database.p.g;
import java.util.concurrent.ScheduledExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements com.google.firebase.database.o.c {

    /* renamed from: a  reason: collision with root package name */
    private final a f2134a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f2135b;

    private d(a aVar, ScheduledExecutorService scheduledExecutorService) {
        this.f2134a = aVar;
        this.f2135b = scheduledExecutorService;
    }

    public static com.google.firebase.database.o.c b(a aVar, ScheduledExecutorService scheduledExecutorService) {
        return new d(aVar, scheduledExecutorService);
    }

    @Override // com.google.firebase.database.o.c
    public void a(boolean z, c.a aVar) {
        this.f2134a.a(z, new g.a(this.f2135b, aVar));
    }
}
