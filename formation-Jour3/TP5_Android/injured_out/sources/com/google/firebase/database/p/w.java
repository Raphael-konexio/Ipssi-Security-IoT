package com.google.firebase.database.p;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    private final long f2338a;

    public w(long j) {
        this.f2338a = j;
    }

    public long a() {
        return this.f2338a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && w.class == obj.getClass() && this.f2338a == ((w) obj).f2338a;
    }

    public int hashCode() {
        long j = this.f2338a;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return "Tag{tagNumber=" + this.f2338a + '}';
    }
}
