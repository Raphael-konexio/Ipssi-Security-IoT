package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b2 implements Parcelable.Creator<z1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z1 createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        int i = 0;
        ArrayList<String> arrayList = null;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                i = com.google.android.gms.common.internal.w.b.m(parcel, k);
            } else if (h != 2) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                arrayList = com.google.android.gms.common.internal.w.b.d(parcel, k);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new z1(i, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ z1[] newArray(int i) {
        return new z1[i];
    }
}
