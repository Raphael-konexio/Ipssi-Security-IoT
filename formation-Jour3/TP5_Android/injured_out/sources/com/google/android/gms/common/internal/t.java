package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
/* loaded from: classes.dex */
public class t extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<t> CREATOR = new b0();
    private final int f;
    private IBinder g;
    private b.c.a.a.b.a h;
    private boolean i;
    private boolean j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(int i, IBinder iBinder, b.c.a.a.b.a aVar, boolean z, boolean z2) {
        this.f = i;
        this.g = iBinder;
        this.h = aVar;
        this.i = z;
        this.j = z2;
    }

    public l b() {
        return l.a.g(this.g);
    }

    public b.c.a.a.b.a c() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            return this.h.equals(tVar.h) && b().equals(tVar.b());
        }
        return false;
    }

    public boolean h() {
        return this.i;
    }

    public boolean j() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.g(parcel, 1, this.f);
        com.google.android.gms.common.internal.w.c.f(parcel, 2, this.g, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 3, c(), i, false);
        com.google.android.gms.common.internal.w.c.c(parcel, 4, h());
        com.google.android.gms.common.internal.w.c.c(parcel, 5, j());
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
