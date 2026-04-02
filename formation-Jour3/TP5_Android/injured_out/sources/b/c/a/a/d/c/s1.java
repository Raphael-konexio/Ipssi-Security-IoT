package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class s1 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<s1> CREATOR = new r1();
    private final String f;
    private final String g;
    private final String h;
    private final long i;

    public s1(String str, String str2, String str3, long j) {
        this.f = str;
        com.google.android.gms.common.internal.r.f(str2);
        this.g = str2;
        this.h = str3;
        this.i = j;
    }

    public final String b() {
        return this.f;
    }

    public final String c() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final long j() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, this.g, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 3, this.h, false);
        com.google.android.gms.common.internal.w.c.h(parcel, 4, this.i);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
