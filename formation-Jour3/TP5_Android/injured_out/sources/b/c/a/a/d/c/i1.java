package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public final class i1 implements Parcelable.Creator<g1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ g1 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        Status status = null;
        com.google.firebase.auth.i0 i0Var = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                status = (Status) com.google.android.gms.common.internal.w.b.b(parcel, k, Status.CREATOR);
            } else if (h == 2) {
                i0Var = (com.google.firebase.auth.i0) com.google.android.gms.common.internal.w.b.b(parcel, k, com.google.firebase.auth.i0.CREATOR);
            } else if (h == 3) {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h != 4) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                str2 = com.google.android.gms.common.internal.w.b.c(parcel, k);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new g1(status, i0Var, str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ g1[] newArray(int i) {
        return new g1[i];
    }
}
