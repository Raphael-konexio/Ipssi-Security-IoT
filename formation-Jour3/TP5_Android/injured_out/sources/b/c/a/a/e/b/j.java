package b.c.a.a.e.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
/* loaded from: classes.dex */
public final class j extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<j> CREATOR = new i();
    private final int f;
    private final s g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(int i, s sVar) {
        this.f = i;
        this.g = sVar;
    }

    public j(s sVar) {
        this(1, sVar);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.g(parcel, 1, this.f);
        com.google.android.gms.common.internal.w.c.j(parcel, 2, this.g, i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
