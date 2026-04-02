package com.google.firebase.auth.z.a;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.firebase.auth.z.a.d;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public abstract class b<T extends d> {

    /* renamed from: b  reason: collision with root package name */
    private static b.c.a.a.b.k.a f1920b = new b.c.a.a.b.k.a("BiChannelGoogleApi", "FirebaseAuth: ");

    /* renamed from: a  reason: collision with root package name */
    private a<T> f1921a;

    private final com.google.android.gms.common.api.e<T> a(String str) {
        a<T> f = f();
        if (f.f1919c.f(str)) {
            b.c.a.a.b.k.a aVar = f1920b;
            String valueOf = String.valueOf(f.f1918b);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 43);
            sb.append("getGoogleApiForMethod() returned Fallback: ");
            sb.append(valueOf);
            aVar.d(sb.toString(), new Object[0]);
            return f.f1918b;
        }
        b.c.a.a.b.k.a aVar2 = f1920b;
        String valueOf2 = String.valueOf(f.f1917a);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 38);
        sb2.append("getGoogleApiForMethod() returned Gms: ");
        sb2.append(valueOf2);
        aVar2.d(sb2.toString(), new Object[0]);
        return f.f1917a;
    }

    private static <ResultT> b.c.a.a.f.g<ResultT> d() {
        return b.c.a.a.f.j.a(o0.a(new Status(17499, "Unable to connect to GoogleApi instance - Google Play Services may be unavailable")));
    }

    private final a<T> f() {
        a<T> aVar;
        synchronized (this) {
            if (this.f1921a == null) {
                try {
                    this.f1921a = c().get();
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    throw new RuntimeException(valueOf.length() != 0 ? "There was an error while initializing the connection to Google Play Services: ".concat(valueOf) : new String("There was an error while initializing the connection to Google Play Services: "));
                }
            }
            aVar = this.f1921a;
        }
        return aVar;
    }

    public final <ResultT, A extends a.b> b.c.a.a.f.g<ResultT> b(e<A, ResultT> eVar) {
        com.google.android.gms.common.api.e<T> a2 = a(eVar.c());
        if (a2 == null) {
            return d();
        }
        if (a2.e().f) {
            eVar.d();
        }
        return (b.c.a.a.f.g<ResultT>) a2.b((com.google.android.gms.common.api.internal.m<A, ResultT>) eVar.a());
    }

    abstract Future<a<T>> c();

    public final <ResultT, A extends a.b> b.c.a.a.f.g<ResultT> e(e<A, ResultT> eVar) {
        com.google.android.gms.common.api.e<T> a2 = a(eVar.c());
        if (a2 == null) {
            return d();
        }
        if (a2.e().f) {
            eVar.d();
        }
        return (b.c.a.a.f.g<ResultT>) a2.c((com.google.android.gms.common.api.internal.m<A, ResultT>) eVar.a());
    }
}
