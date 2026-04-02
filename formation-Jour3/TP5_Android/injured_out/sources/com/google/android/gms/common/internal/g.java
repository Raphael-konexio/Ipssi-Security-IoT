package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.l;
/* loaded from: classes.dex */
public class g extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<g> CREATOR = new e0();
    private final int f;
    private final int g;
    private int h;
    String i;
    IBinder j;
    Scope[] k;
    Bundle l;
    Account m;
    b.c.a.a.b.c[] n;
    b.c.a.a.b.c[] o;
    private boolean p;

    public g(int i) {
        this.f = 4;
        this.h = b.c.a.a.b.e.f1218a;
        this.g = i;
        this.p = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, b.c.a.a.b.c[] cVarArr, b.c.a.a.b.c[] cVarArr2, boolean z) {
        this.f = i;
        this.g = i2;
        this.h = i3;
        if ("com.google.android.gms".equals(str)) {
            this.i = "com.google.android.gms";
        } else {
            this.i = str;
        }
        if (i < 2) {
            this.m = iBinder != null ? a.h(l.a.g(iBinder)) : null;
        } else {
            this.j = iBinder;
            this.m = account;
        }
        this.k = scopeArr;
        this.l = bundle;
        this.n = cVarArr;
        this.o = cVarArr2;
        this.p = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.g(parcel, 1, this.f);
        com.google.android.gms.common.internal.w.c.g(parcel, 2, this.g);
        com.google.android.gms.common.internal.w.c.g(parcel, 3, this.h);
        com.google.android.gms.common.internal.w.c.k(parcel, 4, this.i, false);
        com.google.android.gms.common.internal.w.c.f(parcel, 5, this.j, false);
        com.google.android.gms.common.internal.w.c.m(parcel, 6, this.k, i, false);
        com.google.android.gms.common.internal.w.c.e(parcel, 7, this.l, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 8, this.m, i, false);
        com.google.android.gms.common.internal.w.c.m(parcel, 10, this.n, i, false);
        com.google.android.gms.common.internal.w.c.m(parcel, 11, this.o, i, false);
        com.google.android.gms.common.internal.w.c.c(parcel, 12, this.p);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
