package com.google.firebase.components;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
class r implements b.c.c.j.d, b.c.c.j.c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, ConcurrentHashMap<b.c.c.j.b<Object>, Executor>> f1992a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Queue<b.c.c.j.a<?>> f1993b = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Executor executor) {
    }

    private synchronized Set<Map.Entry<b.c.c.j.b<Object>, Executor>> b(b.c.c.j.a<?> aVar) {
        ConcurrentHashMap<b.c.c.j.b<Object>, Executor> concurrentHashMap;
        concurrentHashMap = this.f1992a.get(aVar.a());
        return concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Queue<b.c.c.j.a<?>> queue;
        synchronized (this) {
            queue = null;
            if (this.f1993b != null) {
                Queue<b.c.c.j.a<?>> queue2 = this.f1993b;
                this.f1993b = null;
                queue = queue2;
            }
        }
        if (queue != null) {
            for (b.c.c.j.a<?> aVar : queue) {
                d(aVar);
            }
        }
    }

    public void d(b.c.c.j.a<?> aVar) {
        u.b(aVar);
        synchronized (this) {
            if (this.f1993b != null) {
                this.f1993b.add(aVar);
                return;
            }
            for (Map.Entry<b.c.c.j.b<Object>, Executor> entry : b(aVar)) {
                entry.getValue().execute(q.a(entry, aVar));
            }
        }
    }
}
