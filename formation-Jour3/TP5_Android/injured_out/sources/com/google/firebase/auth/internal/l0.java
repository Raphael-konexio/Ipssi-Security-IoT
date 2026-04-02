package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.u0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class l0 extends com.google.firebase.auth.a0 {
    public static final Parcelable.Creator<l0> CREATOR = new k0();
    private String f;
    private String g;
    private List<com.google.firebase.auth.e0> h;

    private l0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(String str, String str2, List<com.google.firebase.auth.e0> list) {
        this.f = str;
        this.g = str2;
        this.h = list;
    }

    public static l0 b(List<u0> list, String str) {
        com.google.android.gms.common.internal.r.h(list);
        com.google.android.gms.common.internal.r.f(str);
        l0 l0Var = new l0();
        l0Var.h = new ArrayList();
        for (u0 u0Var : list) {
            if (u0Var instanceof com.google.firebase.auth.e0) {
                l0Var.h.add((com.google.firebase.auth.e0) u0Var);
            }
        }
        l0Var.g = str;
        return l0Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.k(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 2, this.g, false);
        com.google.android.gms.common.internal.w.c.n(parcel, 3, this.h, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
