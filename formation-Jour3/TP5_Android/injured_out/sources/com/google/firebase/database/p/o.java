package com.google.firebase.database.p;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public String f2275a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2276b;

    /* renamed from: c  reason: collision with root package name */
    public String f2277c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f2276b == oVar.f2276b && this.f2275a.equals(oVar.f2275a)) {
            return this.f2277c.equals(oVar.f2277c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f2275a.hashCode() * 31) + (this.f2276b ? 1 : 0)) * 31) + this.f2277c.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("http");
        sb.append(this.f2276b ? "s" : "");
        sb.append("://");
        sb.append(this.f2275a);
        return sb.toString();
    }
}
