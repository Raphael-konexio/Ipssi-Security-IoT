package b.c.a.a.e.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.t;
/* loaded from: classes.dex */
public final class k implements Parcelable.Creator<l> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        b.c.a.a.b.a aVar = null;
        t tVar = null;
        int i = 0;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                i = com.google.android.gms.common.internal.w.b.m(parcel, k);
            } else if (h == 2) {
                aVar = (b.c.a.a.b.a) com.google.android.gms.common.internal.w.b.b(parcel, k, b.c.a.a.b.a.CREATOR);
            } else if (h != 3) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                tVar = (t) com.google.android.gms.common.internal.w.b.b(parcel, k, t.CREATOR);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new l(i, aVar, tVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l[] newArray(int i) {
        return new l[i];
    }
}
