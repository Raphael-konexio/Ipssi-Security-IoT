package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.e;
import java.util.Map;
/* loaded from: classes.dex */
final class x implements Runnable {
    private final /* synthetic */ b.c.a.a.b.a f;
    private final /* synthetic */ e.b g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(e.b bVar, b.c.a.a.b.a aVar) {
        this.g = bVar;
        this.f = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar;
        a.f fVar;
        a.f fVar2;
        a.f fVar3;
        Map map = e.this.i;
        bVar = this.g.f1555b;
        e.a aVar = (e.a) map.get(bVar);
        if (aVar == null) {
            return;
        }
        if (!this.f.k()) {
            aVar.g(this.f);
            return;
        }
        e.b.e(this.g, true);
        fVar = this.g.f1554a;
        if (fVar.q()) {
            this.g.g();
            return;
        }
        try {
            fVar2 = this.g.f1554a;
            fVar3 = this.g.f1554a;
            fVar2.g(null, fVar3.e());
        } catch (SecurityException e) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
            aVar.g(new b.c.a.a.b.a(10));
        }
    }
}
