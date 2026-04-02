package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.r;
/* loaded from: classes.dex */
public final class Scope extends com.google.android.gms.common.internal.w.a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new o();
    private final int f;
    private final String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Scope(int i, String str) {
        r.g(str, "scopeUri must not be null or empty");
        this.f = i;
        this.g = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final String b() {
        return this.g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.g.equals(((Scope) obj).g);
        }
        return false;
    }

    public final int hashCode() {
        return this.g.hashCode();
    }

    public final String toString() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.g(parcel, 1, this.f);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, b(), false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
