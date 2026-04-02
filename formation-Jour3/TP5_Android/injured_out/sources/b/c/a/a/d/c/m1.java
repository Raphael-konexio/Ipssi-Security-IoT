package b.c.a.a.d.c;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes.dex */
public final class m1 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<m1> CREATOR = new n1();
    private String f;
    private String g;
    private boolean h;
    private String i;
    private String j;
    private w1 k;
    private String l;
    private String m;
    private long n;
    private long o;
    private boolean p;
    private com.google.firebase.auth.i0 q;
    private List<s1> r;

    public m1() {
        this.k = new w1();
    }

    public m1(String str, String str2, boolean z, String str3, String str4, w1 w1Var, String str5, String str6, long j, long j2, boolean z2, com.google.firebase.auth.i0 i0Var, List<s1> list) {
        this.f = str;
        this.g = str2;
        this.h = z;
        this.i = str3;
        this.j = str4;
        this.k = w1Var == null ? new w1() : w1.b(w1Var);
        this.l = str5;
        this.m = str6;
        this.n = j;
        this.o = j2;
        this.p = z2;
        this.q = i0Var;
        this.r = list == null ? w.l() : list;
    }

    public final String b() {
        return this.g;
    }

    public final boolean c() {
        return this.h;
    }

    public final String h() {
        return this.f;
    }

    public final String j() {
        return this.i;
    }

    public final Uri k() {
        if (TextUtils.isEmpty(this.j)) {
            return null;
        }
        return Uri.parse(this.j);
    }

    public final String n() {
        return this.m;
    }

    public final long o() {
        return this.n;
    }

    public final long p() {
        return this.o;
    }

    public final boolean q() {
        return this.p;
    }

    public final List<u1> r() {
        return this.k.c();
    }

    public final com.google.firebase.auth.i0 t() {
        return this.q;
    }

    public final List<s1> v() {
        return this.r;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, this.f, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 3, this.g, false);
        com.google.android.gms.common.internal.w.c.c(parcel, 4, this.h);
        com.google.android.gms.common.internal.w.c.k(parcel, 5, this.i, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 6, this.j, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 7, this.k, i, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 8, this.l, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 9, this.m, false);
        com.google.android.gms.common.internal.w.c.h(parcel, 10, this.n);
        com.google.android.gms.common.internal.w.c.h(parcel, 11, this.o);
        com.google.android.gms.common.internal.w.c.c(parcel, 12, this.p);
        com.google.android.gms.common.internal.w.c.j(parcel, 13, this.q, i, false);
        com.google.android.gms.common.internal.w.c.n(parcel, 14, this.r, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
