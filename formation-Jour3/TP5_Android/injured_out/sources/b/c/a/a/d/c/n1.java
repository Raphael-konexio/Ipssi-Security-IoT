package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class n1 implements Parcelable.Creator<m1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ m1 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        w1 w1Var = null;
        String str5 = null;
        String str6 = null;
        com.google.firebase.auth.i0 i0Var = null;
        ArrayList arrayList = null;
        boolean z = false;
        boolean z2 = false;
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
                    z = com.google.android.gms.common.internal.w.b.i(parcel, k);
                    break;
                case 5:
                    str3 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 6:
                    str4 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 7:
                    w1Var = (w1) com.google.android.gms.common.internal.w.b.b(parcel, k, w1.CREATOR);
                    break;
                case 8:
                    str5 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 9:
                    str6 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 10:
                    j = com.google.android.gms.common.internal.w.b.n(parcel, k);
                    break;
                case 11:
                    j2 = com.google.android.gms.common.internal.w.b.n(parcel, k);
                    break;
                case 12:
                    z2 = com.google.android.gms.common.internal.w.b.i(parcel, k);
                    break;
                case 13:
                    i0Var = (com.google.firebase.auth.i0) com.google.android.gms.common.internal.w.b.b(parcel, k, com.google.firebase.auth.i0.CREATOR);
                    break;
                case 14:
                    arrayList = com.google.android.gms.common.internal.w.b.f(parcel, k, s1.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.w.b.q(parcel, k);
                    break;
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new m1(str, str2, z, str3, str4, w1Var, str5, str6, j, j2, z2, i0Var, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ m1[] newArray(int i) {
        return new m1[i];
    }
}
