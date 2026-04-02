package b.c.a.a.d.c;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
/* loaded from: classes.dex */
public final class u1 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<u1> CREATOR = new t1();
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;

    public u1() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u1(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = str4;
        this.j = str5;
        this.k = str6;
        this.l = str7;
    }

    public final String b() {
        return this.f;
    }

    public final String c() {
        return this.g;
    }

    public final Uri h() {
        if (TextUtils.isEmpty(this.h)) {
            return null;
        }
        return Uri.parse(this.h);
    }

    public final String j() {
        return this.i;
    }

    public final String k() {
        return this.k;
    }

    public final String n() {
        return this.j;
    }

    public final String o() {
        return this.l;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, this.f, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 3, this.g, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 4, this.h, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 5, this.i, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 6, this.j, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 7, this.k, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 8, this.l, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
