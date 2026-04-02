package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
/* loaded from: classes.dex */
public final class e0 implements Parcelable.Creator<g> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ g createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        b.c.a.a.b.c[] cVarArr = null;
        b.c.a.a.b.c[] cVarArr2 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            switch (com.google.android.gms.common.internal.w.b.h(k)) {
                case 1:
                    i = com.google.android.gms.common.internal.w.b.m(parcel, k);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.w.b.m(parcel, k);
                    break;
                case 3:
                    i3 = com.google.android.gms.common.internal.w.b.m(parcel, k);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 5:
                    iBinder = com.google.android.gms.common.internal.w.b.l(parcel, k);
                    break;
                case 6:
                    scopeArr = (Scope[]) com.google.android.gms.common.internal.w.b.e(parcel, k, Scope.CREATOR);
                    break;
                case 7:
                    bundle = com.google.android.gms.common.internal.w.b.a(parcel, k);
                    break;
                case 8:
                    account = (Account) com.google.android.gms.common.internal.w.b.b(parcel, k, Account.CREATOR);
                    break;
                case 9:
                default:
                    com.google.android.gms.common.internal.w.b.q(parcel, k);
                    break;
                case 10:
                    cVarArr = (b.c.a.a.b.c[]) com.google.android.gms.common.internal.w.b.e(parcel, k, b.c.a.a.b.c.CREATOR);
                    break;
                case 11:
                    cVarArr2 = (b.c.a.a.b.c[]) com.google.android.gms.common.internal.w.b.e(parcel, k, b.c.a.a.b.c.CREATOR);
                    break;
                case 12:
                    z = com.google.android.gms.common.internal.w.b.i(parcel, k);
                    break;
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new g(i, i2, i3, str, iBinder, scopeArr, bundle, account, cVarArr, cVarArr2, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ g[] newArray(int i) {
        return new g[i];
    }
}
