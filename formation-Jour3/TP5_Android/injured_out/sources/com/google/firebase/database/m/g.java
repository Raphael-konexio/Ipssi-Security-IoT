package com.google.firebase.database.m;

import android.os.Handler;
import android.os.Looper;
import com.google.firebase.database.p.k;
/* loaded from: classes.dex */
public class g implements k {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f2028a = new Handler(Looper.getMainLooper());

    @Override // com.google.firebase.database.p.k
    public void a() {
    }

    @Override // com.google.firebase.database.p.k
    public void b(Runnable runnable) {
        this.f2028a.post(runnable);
    }
}
