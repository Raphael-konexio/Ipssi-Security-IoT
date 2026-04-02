package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes.dex */
public final class h1 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<h1> CREATOR = new j1();
    private String f;
    private List<s1> g;
    private com.google.firebase.auth.i0 h;

    public h1(String str, List<s1> list, com.google.firebase.auth.i0 i0Var) {
        this.f = str;
        this.g = list;
        this.h = i0Var;
    }

    public final String b() {
        return this.f;
    }

    public final com.google.firebase.auth.i0 c() {
        return this.h;
    }

    public final List<com.google.firebase.auth.u0> h() {
        return com.google.firebase.auth.internal.m.b(this.g);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.n(parcel, 2, this.g, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 3, this.h, i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
