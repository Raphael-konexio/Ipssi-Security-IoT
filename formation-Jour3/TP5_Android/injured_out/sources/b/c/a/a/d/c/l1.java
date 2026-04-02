package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class l1 implements Parcelable.Creator<k1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k1 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        String str2 = null;
        z1 z1Var = null;
        ArrayList<String> arrayList = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            switch (com.google.android.gms.common.internal.w.b.h(k)) {
                case 2:
                    str = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 3:
                    z = com.google.android.gms.common.internal.w.b.i(parcel, k);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 5:
                    z2 = com.google.android.gms.common.internal.w.b.i(parcel, k);
                    break;
                case 6:
                    z1Var = (z1) com.google.android.gms.common.internal.w.b.b(parcel, k, z1.CREATOR);
                    break;
                case 7:
                    arrayList = com.google.android.gms.common.internal.w.b.d(parcel, k);
                    break;
                default:
                    com.google.android.gms.common.internal.w.b.q(parcel, k);
                    break;
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new k1(str, z, str2, z2, z1Var, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k1[] newArray(int i) {
        return new k1[i];
    }
}
