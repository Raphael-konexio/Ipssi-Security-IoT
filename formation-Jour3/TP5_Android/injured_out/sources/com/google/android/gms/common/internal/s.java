package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
/* loaded from: classes.dex */
public class s extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<s> CREATOR = new a0();
    private final int f;
    private final Account g;
    private final int h;
    private final GoogleSignInAccount i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f = i;
        this.g = account;
        this.h = i2;
        this.i = googleSignInAccount;
    }

    public s(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public Account b() {
        return this.g;
    }

    public int c() {
        return this.h;
    }

    public GoogleSignInAccount h() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.g(parcel, 1, this.f);
        com.google.android.gms.common.internal.w.c.j(parcel, 2, b(), i, false);
        com.google.android.gms.common.internal.w.c.g(parcel, 3, c());
        com.google.android.gms.common.internal.w.c.j(parcel, 4, h(), i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
