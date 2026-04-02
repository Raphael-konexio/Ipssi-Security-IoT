package io.flutter.embedding.engine.i;

import java.util.HashMap;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.a<Object> f2578a;

    public l(io.flutter.embedding.engine.e.a aVar) {
        this.f2578a = new c.a.c.a.a<>(aVar, "flutter/system", c.a.c.a.d.f1488a);
    }

    public void a() {
        c.a.b.d("SystemChannel", "Sending memory pressure warning to Flutter.");
        HashMap hashMap = new HashMap(1);
        hashMap.put("type", "memoryPressure");
        this.f2578a.c(hashMap);
    }
}
