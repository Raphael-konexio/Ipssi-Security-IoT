package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public final class g1 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<g1> CREATOR = new i1();
    private final Status f;
    private final com.google.firebase.auth.i0 g;
    private final String h;
    private final String i;

    public g1(Status status, com.google.firebase.auth.i0 i0Var, String str, String str2) {
        this.f = status;
        this.g = i0Var;
        this.h = str;
        this.i = str2;
    }

    public final Status b() {
        return this.f;
    }

    public final com.google.firebase.auth.i0 c() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final String j() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.j(parcel, 1, this.f, i, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 2, this.g, i, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 3, this.h, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 4, this.i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
