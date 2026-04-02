package com.google.firebase.database;

import com.google.firebase.database.p.g0.m;
import com.google.firebase.database.p.n;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class d extends j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(n nVar, com.google.firebase.database.p.l lVar) {
        super(nVar, lVar);
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && toString().equals(obj.toString());
    }

    public d h(String str) {
        if (str != null) {
            if (d().isEmpty()) {
                m.c(str);
            } else {
                m.b(str);
            }
            return new d(this.f2016a, d().i(new com.google.firebase.database.p.l(str)));
        }
        throw new NullPointerException("Can't pass null for argument 'pathString' in child()");
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String i() {
        if (d().isEmpty()) {
            return null;
        }
        return d().u().e();
    }

    public d j() {
        com.google.firebase.database.p.l y = d().y();
        if (y != null) {
            return new d(this.f2016a, y);
        }
        return null;
    }

    public String toString() {
        d j = j();
        if (j == null) {
            return this.f2016a.toString();
        }
        try {
            return j.toString() + "/" + URLEncoder.encode(i(), "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new c("Failed to URLEncode key: " + i(), e);
        }
    }
}
