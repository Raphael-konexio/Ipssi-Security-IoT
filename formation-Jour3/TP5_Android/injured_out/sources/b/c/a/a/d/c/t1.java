package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class t1 implements Parcelable.Creator<u1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u1 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            switch (com.google.android.gms.common.internal.w.b.h(k)) {
                case 2:
                    str = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 6:
                    str5 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 7:
                    str6 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 8:
                    str7 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                default:
                    com.google.android.gms.common.internal.w.b.q(parcel, k);
                    break;
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new u1(str, str2, str3, str4, str5, str6, str7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u1[] newArray(int i) {
        return new u1[i];
    }
}
