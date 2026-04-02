package b.c.a.a.e.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public final class c extends com.google.android.gms.common.internal.w.a implements com.google.android.gms.common.api.k {
    public static final Parcelable.Creator<c> CREATOR = new b();
    private final int f;
    private int g;
    private Intent h;

    public c() {
        this(0, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i, int i2, Intent intent) {
        this.f = i;
        this.g = i2;
        this.h = intent;
    }

    private c(int i, Intent intent) {
        this(2, 0, null);
    }

    @Override // com.google.android.gms.common.api.k
    public final Status getStatus() {
        return this.g == 0 ? Status.j : Status.l;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.g(parcel, 1, this.f);
        com.google.android.gms.common.internal.w.c.g(parcel, 2, this.g);
        com.google.android.gms.common.internal.w.c.j(parcel, 3, this.h, i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
