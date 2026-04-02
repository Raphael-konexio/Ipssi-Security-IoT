package b.c.a.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
/* loaded from: classes.dex */
public class c extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<c> CREATOR = new o();
    private final String f;
    @Deprecated
    private final int g;
    private final long h;

    public c(String str, int i, long j) {
        this.f = str;
        this.g = i;
        this.h = j;
    }

    public c(String str, long j) {
        this.f = str;
        this.h = j;
        this.g = -1;
    }

    public String b() {
        return this.f;
    }

    public long c() {
        long j = this.h;
        return j == -1 ? this.g : j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (((b() != null && b().equals(cVar.b())) || (b() == null && cVar.b() == null)) && c() == cVar.c()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.b(b(), Long.valueOf(c()));
    }

    public String toString() {
        q.a c2 = com.google.android.gms.common.internal.q.c(this);
        c2.a("name", b());
        c2.a("version", Long.valueOf(c()));
        return c2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, b(), false);
        com.google.android.gms.common.internal.w.c.g(parcel, 2, this.g);
        com.google.android.gms.common.internal.w.c.h(parcel, 3, c());
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
