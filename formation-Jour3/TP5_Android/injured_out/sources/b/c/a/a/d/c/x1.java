package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class x1 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<x1> CREATOR = new y1();
    private String f;
    private String g;
    private String h;
    private s1 i;

    public x1() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x1(String str, String str2, String str3, s1 s1Var) {
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = s1Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, this.f, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 3, this.g, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 4, this.h, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 5, this.i, i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
