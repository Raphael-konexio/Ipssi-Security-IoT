package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class b1 implements Parcelable.Creator<z0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z0 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h == 2) {
                str2 = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h != 3) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                str3 = com.google.android.gms.common.internal.w.b.c(parcel, k);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new z0(str, str2, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z0[] newArray(int i) {
        return new z0[i];
    }
}
