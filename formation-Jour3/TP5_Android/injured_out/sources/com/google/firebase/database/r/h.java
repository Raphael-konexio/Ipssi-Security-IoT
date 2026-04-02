package com.google.firebase.database.r;

import java.util.Comparator;
/* loaded from: classes.dex */
public abstract class h implements Comparator<m> {
    public static h b(String str) {
        if (str.equals(".value")) {
            return u.j();
        }
        if (str.equals(".key")) {
            return j.j();
        }
        if (str.equals(".priority")) {
            throw new IllegalStateException("queryDefinition shouldn't ever be .priority since it's the default");
        }
        return new p(new com.google.firebase.database.p.l(str));
    }

    public int a(m mVar, m mVar2, boolean z) {
        return z ? compare(mVar2, mVar) : compare(mVar, mVar2);
    }

    public abstract String c();

    public boolean d(n nVar, n nVar2) {
        return compare(new m(b.l(), nVar), new m(b.l(), nVar2)) != 0;
    }

    public abstract boolean e(n nVar);

    public abstract m f(b bVar, n nVar);

    public abstract m g();

    public m h() {
        return m.b();
    }
}
