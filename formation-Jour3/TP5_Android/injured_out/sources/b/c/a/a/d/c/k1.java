package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes.dex */
public final class k1 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<k1> CREATOR = new l1();
    private String f;
    private boolean g;
    private String h;
    private boolean i;
    private z1 j;
    private List<String> k;

    public k1() {
        this.j = z1.c();
    }

    public k1(String str, boolean z, String str2, boolean z2, z1 z1Var, List<String> list) {
        this.f = str;
        this.g = z;
        this.h = str2;
        this.i = z2;
        this.j = z1Var == null ? z1.c() : z1.b(z1Var);
        this.k = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, this.f, false);
        com.google.android.gms.common.internal.w.c.c(parcel, 3, this.g);
        com.google.android.gms.common.internal.w.c.k(parcel, 4, this.h, false);
        com.google.android.gms.common.internal.w.c.c(parcel, 5, this.i);
        com.google.android.gms.common.internal.w.c.j(parcel, 6, this.j, i, false);
        com.google.android.gms.common.internal.w.c.l(parcel, 7, this.k, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
