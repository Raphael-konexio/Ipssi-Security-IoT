package com.google.firebase.database.m;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import b.c.c.c;
import com.google.firebase.database.o.h;
import com.google.firebase.database.p.k;
import com.google.firebase.database.p.m;
import com.google.firebase.database.p.q;
import com.google.firebase.database.q.d;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class h implements m {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2029a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<String> f2030b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private final b.c.c.c f2031c;

    /* loaded from: classes.dex */
    class a extends com.google.firebase.database.p.g0.c {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.q.c f2032b;

        /* renamed from: com.google.firebase.database.m.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0091a implements Runnable {
            final /* synthetic */ String f;
            final /* synthetic */ Throwable g;

            RunnableC0091a(a aVar, String str, Throwable th) {
                this.f = str;
                this.g = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw new RuntimeException(this.f, this.g);
            }
        }

        a(com.google.firebase.database.q.c cVar) {
            this.f2032b = cVar;
        }

        @Override // com.google.firebase.database.p.g0.c
        public void f(Throwable th) {
            String g = com.google.firebase.database.p.g0.c.g(th);
            this.f2032b.c(g, th);
            new Handler(h.this.f2029a.getMainLooper()).post(new RunnableC0091a(this, g, th));
            c().shutdownNow();
        }
    }

    /* loaded from: classes.dex */
    class b implements c.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.o.h f2034a;

        b(h hVar, com.google.firebase.database.o.h hVar2) {
            this.f2034a = hVar2;
        }

        @Override // b.c.c.c.b
        public void a(boolean z) {
            if (z) {
                this.f2034a.i("app_in_background");
            } else {
                this.f2034a.m("app_in_background");
            }
        }
    }

    public h(b.c.c.c cVar) {
        this.f2031c = cVar;
        if (cVar != null) {
            this.f2029a = cVar.j();
            return;
        }
        Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Log.e("FirebaseDatabase", "ERROR: You must call FirebaseApp.initializeApp() before using Firebase Database.");
        Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        throw new RuntimeException("You need to call FirebaseApp.initializeApp() before using Firebase Database.");
    }

    @Override // com.google.firebase.database.p.m
    public com.google.firebase.database.p.f0.e a(com.google.firebase.database.p.g gVar, String str) {
        String u = gVar.u();
        String str2 = str + "_" + u;
        if (!this.f2030b.contains(str2)) {
            this.f2030b.add(str2);
            return new com.google.firebase.database.p.f0.b(gVar, new i(this.f2029a, gVar, str2), new com.google.firebase.database.p.f0.c(gVar.p()));
        }
        throw new com.google.firebase.database.c("SessionPersistenceKey '" + u + "' has already been used.");
    }

    @Override // com.google.firebase.database.p.m
    public String b(com.google.firebase.database.p.g gVar) {
        return Build.VERSION.SDK_INT + "/Android";
    }

    @Override // com.google.firebase.database.p.m
    public k c(com.google.firebase.database.p.g gVar) {
        return new g();
    }

    @Override // com.google.firebase.database.p.m
    public File d() {
        return this.f2029a.getApplicationContext().getDir("sslcache", 0);
    }

    @Override // com.google.firebase.database.p.m
    public com.google.firebase.database.q.d e(com.google.firebase.database.p.g gVar, d.a aVar, List<String> list) {
        return new com.google.firebase.database.q.a(aVar, list);
    }

    @Override // com.google.firebase.database.p.m
    public com.google.firebase.database.o.h f(com.google.firebase.database.p.g gVar, com.google.firebase.database.o.d dVar, com.google.firebase.database.o.f fVar, h.a aVar) {
        com.google.firebase.database.o.i iVar = new com.google.firebase.database.o.i(dVar, fVar, aVar);
        this.f2031c.e(new b(this, iVar));
        return iVar;
    }

    @Override // com.google.firebase.database.p.m
    public q g(com.google.firebase.database.p.g gVar) {
        return new a(gVar.n("RunLoop"));
    }
}
