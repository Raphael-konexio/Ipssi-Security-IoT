package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class r0 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<r0> CREATOR = new t0();
    private final String f;
    private final com.google.firebase.auth.t g;

    public r0(String str, com.google.firebase.auth.t tVar) {
        this.f = str;
        this.g = tVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 2, this.g, i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
