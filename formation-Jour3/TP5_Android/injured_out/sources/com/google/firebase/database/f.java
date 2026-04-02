package com.google.firebase.database;

import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.firebase.database.p.n;
import com.google.firebase.database.p.o;
import com.google.firebase.database.p.p;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final o f2008a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.database.p.h f2009b;

    /* renamed from: c  reason: collision with root package name */
    private n f2010c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b.c.c.c cVar, o oVar, com.google.firebase.database.p.h hVar) {
        this.f2008a = oVar;
        this.f2009b = hVar;
    }

    private synchronized void a() {
        if (this.f2010c == null) {
            this.f2010c = p.b(this.f2009b, this.f2008a, this);
        }
    }

    public static f b() {
        b.c.c.c k = b.c.c.c.k();
        if (k != null) {
            return c(k, k.n().d());
        }
        throw new c("You must call FirebaseApp.initialize() first.");
    }

    public static synchronized f c(b.c.c.c cVar, String str) {
        f a2;
        synchronized (f.class) {
            if (TextUtils.isEmpty(str)) {
                throw new c("Failed to get FirebaseDatabase instance: Specify DatabaseURL within FirebaseApp or from your getInstance() call.");
            }
            com.google.firebase.database.p.g0.h g = com.google.firebase.database.p.g0.l.g(str);
            if (!g.f2185b.isEmpty()) {
                throw new c("Specified Database URL '" + str + "' is invalid. It should point to the root of a Firebase Database but it includes a path: " + g.f2185b.toString());
            }
            r.i(cVar, "Provided FirebaseApp must not be null.");
            g gVar = (g) cVar.h(g.class);
            r.i(gVar, "Firebase Database component is not present.");
            a2 = gVar.a(g.f2184a);
        }
        return a2;
    }

    public static String e() {
        return "19.2.1";
    }

    public d d() {
        a();
        return new d(this.f2010c, com.google.firebase.database.p.l.w());
    }
}
