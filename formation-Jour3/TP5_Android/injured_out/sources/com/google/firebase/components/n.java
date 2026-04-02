package com.google.firebase.components;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f1989a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1990b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1991c;

    private n(Class<?> cls, int i, int i2) {
        u.c(cls, "Null dependency anInterface.");
        this.f1989a = cls;
        this.f1990b = i;
        this.f1991c = i2;
    }

    public static n e(Class<?> cls) {
        return new n(cls, 0, 0);
    }

    public static n f(Class<?> cls) {
        return new n(cls, 0, 1);
    }

    public static n g(Class<?> cls) {
        return new n(cls, 1, 0);
    }

    public static n h(Class<?> cls) {
        return new n(cls, 2, 0);
    }

    public Class<?> a() {
        return this.f1989a;
    }

    public boolean b() {
        return this.f1991c == 0;
    }

    public boolean c() {
        return this.f1990b == 1;
    }

    public boolean d() {
        return this.f1990b == 2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            return this.f1989a == nVar.f1989a && this.f1990b == nVar.f1990b && this.f1991c == nVar.f1991c;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f1989a.hashCode() ^ 1000003) * 1000003) ^ this.f1990b) * 1000003) ^ this.f1991c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f1989a);
        sb.append(", type=");
        int i = this.f1990b;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", direct=");
        sb.append(this.f1991c == 0);
        sb.append("}");
        return sb.toString();
    }
}
