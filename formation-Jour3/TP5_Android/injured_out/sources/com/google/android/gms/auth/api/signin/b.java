package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int r = com.google.android.gms.common.internal.w.b.r(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < r) {
            int k = com.google.android.gms.common.internal.w.b.k(parcel);
            switch (com.google.android.gms.common.internal.w.b.h(k)) {
                case 1:
                    i = com.google.android.gms.common.internal.w.b.m(parcel, k);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 6:
                    uri = (Uri) com.google.android.gms.common.internal.w.b.b(parcel, k, Uri.CREATOR);
                    break;
                case 7:
                    str5 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 8:
                    j = com.google.android.gms.common.internal.w.b.n(parcel, k);
                    break;
                case 9:
                    str6 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 10:
                    arrayList = com.google.android.gms.common.internal.w.b.f(parcel, k, Scope.CREATOR);
                    break;
                case 11:
                    str7 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                case 12:
                    str8 = com.google.android.gms.common.internal.w.b.c(parcel, k);
                    break;
                default:
                    com.google.android.gms.common.internal.w.b.q(parcel, k);
                    break;
            }
        }
        com.google.android.gms.common.internal.w.b.g(parcel, r);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, arrayList, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
