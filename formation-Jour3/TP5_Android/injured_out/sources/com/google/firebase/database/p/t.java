package com.google.firebase.database.p;

import java.util.Map;
/* loaded from: classes.dex */
class t {

    /* renamed from: a  reason: collision with root package name */
    private com.google.firebase.database.r.n f2284a = null;

    /* renamed from: b  reason: collision with root package name */
    private Map<com.google.firebase.database.r.b, t> f2285b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f2286a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f2287b;

        a(t tVar, l lVar, c cVar) {
            this.f2286a = lVar;
            this.f2287b = cVar;
        }

        @Override // com.google.firebase.database.p.t.b
        public void a(com.google.firebase.database.r.b bVar, t tVar) {
            tVar.b(this.f2286a.l(bVar), this.f2287b);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(com.google.firebase.database.r.b bVar, t tVar);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(l lVar, com.google.firebase.database.r.n nVar);
    }

    public void a(b bVar) {
        Map<com.google.firebase.database.r.b, t> map = this.f2285b;
        if (map != null) {
            for (Map.Entry<com.google.firebase.database.r.b, t> entry : map.entrySet()) {
                bVar.a(entry.getKey(), entry.getValue());
            }
        }
    }

    public void b(l lVar, c cVar) {
        com.google.firebase.database.r.n nVar = this.f2284a;
        if (nVar != null) {
            cVar.a(lVar, nVar);
        } else {
            a(new a(this, lVar, cVar));
        }
    }
}
