package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class m0 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<m0> CREATOR = new n0();
    private final String f;

    public m0(String str) {
        this.f = str;
    }

    public final String b() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
