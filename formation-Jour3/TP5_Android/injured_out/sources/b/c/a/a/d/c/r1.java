package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class r1 implements Parcelable.Creator<s1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ s1 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        long j = 0;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h == 2) {
                str2 = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h == 3) {
                str3 = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h != 4) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                j = com.google.android.gms.common.internal.w.b.n(parcel, k);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new s1(str, str2, str3, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ s1[] newArray(int i) {
        return new s1[i];
    }
}
