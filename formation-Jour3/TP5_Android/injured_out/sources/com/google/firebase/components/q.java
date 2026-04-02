package com.google.firebase.components;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class q implements Runnable {
    private final Map.Entry f;
    private final b.c.c.j.a g;

    private q(Map.Entry entry, b.c.c.j.a aVar) {
        this.f = entry;
        this.g = aVar;
    }

    public static Runnable a(Map.Entry entry, b.c.c.j.a aVar) {
        return new q(entry, aVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((b.c.c.j.b) this.f.getKey()).a(this.g);
    }
}
