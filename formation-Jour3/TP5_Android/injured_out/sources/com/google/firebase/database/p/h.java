package com.google.firebase.database.p;
/* loaded from: classes.dex */
public class h extends g {
    public void F(a aVar) {
        this.f2170c = aVar;
    }

    public synchronized void G(b.c.c.c cVar) {
        this.k = cVar;
    }

    public synchronized void H(String str) {
        a();
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Session identifier is not allowed to be empty or null!");
        }
        this.e = str;
    }
}
