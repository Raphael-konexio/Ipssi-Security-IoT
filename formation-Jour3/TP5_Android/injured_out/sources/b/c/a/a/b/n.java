package b.c.a.a.b;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class n implements Parcelable.Creator<a> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        PendingIntent pendingIntent = null;
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                i = com.google.android.gms.common.internal.w.b.m(parcel, k);
            } else if (h == 2) {
                i2 = com.google.android.gms.common.internal.w.b.m(parcel, k);
            } else if (h == 3) {
                pendingIntent = (PendingIntent) com.google.android.gms.common.internal.w.b.b(parcel, k, PendingIntent.CREATOR);
            } else if (h != 4) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new a(i, i2, pendingIntent, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a[] newArray(int i) {
        return new a[i];
    }
}
