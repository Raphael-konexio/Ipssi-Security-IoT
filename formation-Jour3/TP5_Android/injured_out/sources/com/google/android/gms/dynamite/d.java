package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes.dex */
public final class d extends b.c.a.a.d.b.a implements c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.c
    public final int O() {
        Parcel g = g(6, d());
        int readInt = g.readInt();
        g.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.c
    public final int j(b.c.a.a.c.a aVar, String str, boolean z) {
        Parcel d2 = d();
        b.c.a.a.d.b.c.c(d2, aVar);
        d2.writeString(str);
        b.c.a.a.d.b.c.a(d2, z);
        Parcel g = g(5, d2);
        int readInt = g.readInt();
        g.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.c
    public final int y(b.c.a.a.c.a aVar, String str, boolean z) {
        Parcel d2 = d();
        b.c.a.a.d.b.c.c(d2, aVar);
        d2.writeString(str);
        b.c.a.a.d.b.c.a(d2, z);
        Parcel g = g(3, d2);
        int readInt = g.readInt();
        g.recycle();
        return readInt;
    }
}
