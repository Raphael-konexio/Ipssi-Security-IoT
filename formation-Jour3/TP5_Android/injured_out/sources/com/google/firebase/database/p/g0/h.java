package com.google.firebase.database.p.g0;

import com.google.firebase.database.p.o;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public o f2184a;

    /* renamed from: b  reason: collision with root package name */
    public com.google.firebase.database.p.l f2185b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f2184a.equals(hVar.f2184a)) {
            return this.f2185b.equals(hVar.f2185b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f2184a.hashCode() * 31) + this.f2185b.hashCode();
    }
}
