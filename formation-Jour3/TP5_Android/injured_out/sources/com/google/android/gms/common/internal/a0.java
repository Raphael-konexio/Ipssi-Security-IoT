package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
/* loaded from: classes.dex */
public final class a0 implements Parcelable.Creator<s> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ s createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            int h = com.google.android.gms.common.internal.w.b.h(k);
            if (h == 1) {
                i = com.google.android.gms.common.internal.w.b.m(parcel, k);
            } else if (h == 2) {
                account = (Account) com.google.android.gms.common.internal.w.b.b(parcel, k, Account.CREATOR);
            } else if (h == 3) {
                i2 = com.google.android.gms.common.internal.w.b.m(parcel, k);
            } else if (h != 4) {
                com.google.android.gms.common.internal.w.b.q(parcel, k);
            } else {
                googleSignInAccount = (GoogleSignInAccount) com.google.android.gms.common.internal.w.b.b(parcel, k, GoogleSignInAccount.CREATOR);
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new s(i, account, i2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ s[] newArray(int i) {
        return new s[i];
    }
}
