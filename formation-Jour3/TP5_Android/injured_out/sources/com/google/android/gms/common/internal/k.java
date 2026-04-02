package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f1633a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    private b.c.a.a.b.e f1634b;

    public k(b.c.a.a.b.e eVar) {
        r.h(eVar);
        this.f1634b = eVar;
    }

    public void a() {
        this.f1633a.clear();
    }

    public int b(Context context, a.f fVar) {
        r.h(context);
        r.h(fVar);
        int i = 0;
        if (fVar.j()) {
            int k = fVar.k();
            int i2 = this.f1633a.get(k, -1);
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= this.f1633a.size()) {
                    i = i2;
                    break;
                }
                int keyAt = this.f1633a.keyAt(i3);
                if (keyAt > k && this.f1633a.get(keyAt) == 0) {
                    break;
                }
                i3++;
            }
            if (i == -1) {
                i = this.f1634b.g(context, k);
            }
            this.f1633a.put(k, i);
            return i;
        }
        return 0;
    }
}
