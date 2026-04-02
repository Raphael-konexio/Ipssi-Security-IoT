package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class w0 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<w0> CREATOR = new y0();
    private final a2 f;

    public w0(a2 a2Var) {
        this.f = a2Var;
    }

    public final a2 b() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.j(parcel, 1, this.f, i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
