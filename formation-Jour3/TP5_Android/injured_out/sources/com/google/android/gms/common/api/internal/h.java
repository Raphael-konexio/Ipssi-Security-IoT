package com.google.android.gms.common.api.internal;
/* loaded from: classes.dex */
public final class h<L> {

    /* renamed from: a  reason: collision with root package name */
    private final L f1562a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1563b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.f1562a == hVar.f1562a && this.f1563b.equals(hVar.f1563b);
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f1562a) * 31) + this.f1563b.hashCode();
    }
}
