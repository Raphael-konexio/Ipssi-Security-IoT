package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class d2 implements Parcelable.Creator<a2> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a2 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
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
                case 9:
                    str8 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 10:
                    z = com.google.android.gms.common.internal.w.b.i(parcel, k);
                    break;
                case 11:
                    z2 = com.google.android.gms.common.internal.w.b.i(parcel, k);
                    break;
                case 12:
                    str9 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 13:
                    str10 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 14:
                    str11 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 15:
                    str12 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 16:
                    z3 = com.google.android.gms.common.internal.w.b.i(parcel, k);
                    break;
                case 17:
                    str13 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                default:
                    com.google.android.gms.common.internal.w.b.q(parcel, k);
                    break;
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new a2(str, str2, str3, str4, str5, str6, str7, str8, z, z2, str9, str10, str11, str12, z3, str13);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a2[] newArray(int i) {
        return new a2[i];
    }
}
