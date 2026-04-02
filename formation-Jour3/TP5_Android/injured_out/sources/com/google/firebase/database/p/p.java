package com.google.firebase.database.p;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class p {

    /* renamed from: b  reason: collision with root package name */
    private static final p f2278b = new p();

    /* renamed from: a  reason: collision with root package name */
    private final Map<g, Map<String, n>> f2279a = new HashMap();

    private n a(g gVar, o oVar, com.google.firebase.database.f fVar) {
        n nVar;
        gVar.i();
        String str = "https://" + oVar.f2275a + "/" + oVar.f2277c;
        synchronized (this.f2279a) {
            if (!this.f2279a.containsKey(gVar)) {
                this.f2279a.put(gVar, new HashMap());
            }
            Map<String, n> map = this.f2279a.get(gVar);
            if (map.containsKey(str)) {
                throw new IllegalStateException("createLocalRepo() called for existing repo.");
            }
            nVar = new n(oVar, gVar, fVar);
            map.put(str, nVar);
        }
        return nVar;
    }

    public static n b(g gVar, o oVar, com.google.firebase.database.f fVar) {
        return f2278b.a(gVar, oVar, fVar);
    }
}
