package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class j1 implements Parcelable.Creator<h1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h1 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        ArrayList arrayList = null;
        com.google.firebase.auth.i0 i0Var = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                str = com.google.android.gms.common.internal.w.b.c(parcel, k);
            } else if (h == 2) {
                arrayList = com.google.android.gms.common.internal.w.b.f(parcel, k, s1.CREATOR);
            } else if (h != 3) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                i0Var = (com.google.firebase.auth.i0) com.google.android.gms.common.internal.w.b.b(parcel, k, com.google.firebase.auth.i0.CREATOR);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new h1(str, arrayList, i0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h1[] newArray(int i) {
        return new h1[i];
    }
}
