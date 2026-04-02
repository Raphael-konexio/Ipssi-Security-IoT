package com.google.android.gms.common.api;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends Exception {
    private final a.d.a<com.google.android.gms.common.api.internal.b<?>, b.c.a.a.b.a> f;

    public c(a.d.a<com.google.android.gms.common.api.internal.b<?>, b.c.a.a.b.a> aVar) {
        this.f = aVar;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (com.google.android.gms.common.api.internal.b<?> bVar : this.f.keySet()) {
            b.c.a.a.b.a aVar = this.f.get(bVar);
            if (aVar.k()) {
                z = false;
            }
            String a2 = bVar.a();
            String valueOf = String.valueOf(aVar);
            StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 2 + String.valueOf(valueOf).length());
            sb.append(a2);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z ? "None of the queried APIs are available. " : "Some of the queried APIs are unavailable. ");
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
