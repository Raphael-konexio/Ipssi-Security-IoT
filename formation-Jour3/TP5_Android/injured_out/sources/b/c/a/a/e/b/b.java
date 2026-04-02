package b.c.a.a.e.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<c> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        int i = 0;
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                i = com.google.android.gms.common.internal.w.b.m(parcel, k);
            } else if (h == 2) {
                i2 = com.google.android.gms.common.internal.w.b.m(parcel, k);
            } else if (h != 3) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                intent = (Intent) com.google.android.gms.common.internal.w.b.b(parcel, k, Intent.CREATOR);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new c(i, i2, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i) {
        return new c[i];
    }
}
