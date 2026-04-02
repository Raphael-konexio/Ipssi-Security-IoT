package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class y1 implements Parcelable.Creator<x1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x1 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        s1 s1Var = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 2) {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h == 3) {
                str2 = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h == 4) {
                str3 = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h != 5) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                s1Var = (s1) com.google.android.gms.common.internal.w.b.b(parcel, k, s1.CREATOR);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new x1(str, str2, str3, s1Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x1[] newArray(int i) {
        return new x1[i];
    }
}
