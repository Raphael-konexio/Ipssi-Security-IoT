package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class y0 implements Parcelable.Creator<w0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ w0 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        a2 a2Var = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            if (com.google.android.gms.common.internal.w.b.h(k) != 1) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                a2Var = (a2) com.google.android.gms.common.internal.w.b.b(parcel, k, a2.CREATOR);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new w0(a2Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ w0[] newArray(int i) {
        return new w0[i];
    }
}
