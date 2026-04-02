package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class z0 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<z0> CREATOR = new b1();
    private final String f;
    private final String g;
    private final String h;

    public z0(String str, String str2, String str3) {
        this.f = str;
        this.g = str2;
        this.h = str3;
    }

    public final String b() {
        return this.f;
    }

    public final String c() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, this.g, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 3, this.h, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
