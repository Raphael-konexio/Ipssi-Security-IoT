package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
/* loaded from: classes.dex */
public final class Status extends com.google.android.gms.common.internal.w.a implements k, ReflectedParcelable {
    private final int f;
    private final int g;
    private final String h;
    private final PendingIntent i;
    public static final Status j = new Status(0);
    public static final Status k = new Status(15);
    public static final Status l = new Status(16);
    public static final Parcelable.Creator<Status> CREATOR = new p();

    public Status(int i) {
        this(i, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f = i;
        this.g = i2;
        this.h = str;
        this.i = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public final int b() {
        return this.g;
    }

    public final String c() {
        return this.h;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Status) {
            Status status = (Status) obj;
            return this.f == status.f && this.g == status.g && q.a(this.h, status.h) && q.a(this.i, status.i);
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.k
    public final Status getStatus() {
        return this;
    }

    public final boolean h() {
        return this.i != null;
    }

    public final int hashCode() {
        return q.b(Integer.valueOf(this.f), Integer.valueOf(this.g), this.h, this.i);
    }

    public final String j() {
        String str = this.h;
        return str != null ? str : d.a(this.g);
    }

    public final String toString() {
        q.a c2 = q.c(this);
        c2.a("statusCode", j());
        c2.a("resolution", this.i);
        return c2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.g(parcel, 1, b());
        com.google.android.gms.common.internal.w.c.k(parcel, 2, c(), false);
        com.google.android.gms.common.internal.w.c.j(parcel, 3, this.i, i, false);
        com.google.android.gms.common.internal.w.c.g(parcel, 1000, this.f);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
