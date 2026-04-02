package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class e1 implements Parcelable.Creator<c1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c1 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        com.google.firebase.auth.t tVar = null;
        String str = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                tVar = (com.google.firebase.auth.t) com.google.android.gms.common.internal.w.b.b(parcel, k, com.google.firebase.auth.t.CREATOR);
            } else if (h != 2) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new c1(tVar, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c1[] newArray(int i) {
        return new c1[i];
    }
}
