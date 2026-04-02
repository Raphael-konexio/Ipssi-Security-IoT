package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class p1 implements Parcelable.Creator<q1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q1 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        String str2 = null;
        Long l = null;
        String str3 = null;
        Long l2 = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 2) {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h == 3) {
                str2 = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h == 4) {
                l = com.google.android.gms.common.internal.w.b.o(parcel, k);
            } else if (h == 5) {
                str3 = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h != 6) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                l2 = com.google.android.gms.common.internal.w.b.o(parcel, k);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new q1(str, str2, l, str3, l2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q1[] newArray(int i) {
        return new q1[i];
    }
}
