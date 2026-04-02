package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class v1 implements Parcelable.Creator<w1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ w1 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        ArrayList arrayList = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            if (com.google.android.gms.common.internal.w.b.h(k) != 2) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                arrayList = com.google.android.gms.common.internal.w.b.f(parcel, k, u1.CREATOR);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new w1(arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ w1[] newArray(int i) {
        return new w1[i];
    }
}
