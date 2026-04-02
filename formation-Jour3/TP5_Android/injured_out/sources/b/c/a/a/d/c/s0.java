package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class s0 implements Parcelable.Creator<p0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p0 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        a2 a2Var = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h != 2) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                a2Var = (a2) com.google.android.gms.common.internal.w.b.b(parcel, k, a2.CREATOR);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new p0(str, a2Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p0[] newArray(int i) {
        return new p0[i];
    }
}
