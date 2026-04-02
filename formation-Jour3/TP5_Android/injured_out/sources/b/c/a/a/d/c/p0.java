package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class p0 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<p0> CREATOR = new s0();
    private final String f;
    private final a2 g;

    public p0(String str, a2 a2Var) {
        this.f = str;
        this.g = a2Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 2, this.g, i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
