package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class t0 implements Parcelable.Creator<r0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ r0 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        com.google.firebase.auth.t tVar = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h != 2) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                tVar = (com.google.firebase.auth.t) com.google.android.gms.common.internal.w.b.b(parcel, k, com.google.firebase.auth.t.CREATOR);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new r0(str, tVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ r0[] newArray(int i) {
        return new r0[i];
    }
}
