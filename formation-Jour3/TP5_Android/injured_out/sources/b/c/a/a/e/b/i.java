package b.c.a.a.e.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
/* loaded from: classes.dex */
public final class i implements Parcelable.Creator<j> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ j createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        int i = 0;
        s sVar = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                i = com.google.android.gms.common.internal.w.b.m(parcel, k);
            } else if (h != 2) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                sVar = (s) com.google.android.gms.common.internal.w.b.b(parcel, k, s.CREATOR);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new j(i, sVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ j[] newArray(int i) {
        return new j[i];
    }
}
