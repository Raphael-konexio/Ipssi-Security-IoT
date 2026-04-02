package b.c.a.a.e.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.t;
/* loaded from: classes.dex */
public final class l extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<l> CREATOR = new k();
    private final int f;
    private final b.c.a.a.b.a g;
    private final t h;

    public l(int i) {
        this(new b.c.a.a.b.a(8, null), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(int i, b.c.a.a.b.a aVar, t tVar) {
        this.f = i;
        this.g = aVar;
        this.h = tVar;
    }

    private l(b.c.a.a.b.a aVar, t tVar) {
        this(1, aVar, null);
    }

    public final b.c.a.a.b.a b() {
        return this.g;
    }

    public final t c() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.g(parcel, 1, this.f);
        com.google.android.gms.common.internal.w.c.j(parcel, 2, this.g, i, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 3, this.h, i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
