package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class c1 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<c1> CREATOR = new e1();
    private final com.google.firebase.auth.t f;
    private final String g;

    public c1(com.google.firebase.auth.t tVar, String str) {
        this.f = tVar;
        this.g = str;
    }

    public final com.google.firebase.auth.t b() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.j(parcel, 1, this.f, i, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, this.g, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
