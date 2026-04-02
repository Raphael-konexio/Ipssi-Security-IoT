package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class a1 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<a1> CREATOR = new d1();
    private final com.google.firebase.auth.c f;

    public a1(com.google.firebase.auth.c cVar) {
        this.f = cVar;
    }

    public final com.google.firebase.auth.c b() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.j(parcel, 1, this.f, i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
