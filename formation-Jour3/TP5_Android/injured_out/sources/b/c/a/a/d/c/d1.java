package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class d1 implements Parcelable.Creator<a1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a1 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        com.google.firebase.auth.c cVar = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            if (com.google.android.gms.common.internal.w.b.h(k) != 1) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                cVar = (com.google.firebase.auth.c) com.google.android.gms.common.internal.w.b.b(parcel, k, com.google.firebase.auth.c.CREATOR);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new a1(cVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a1[] newArray(int i) {
        return new a1[i];
    }
}
